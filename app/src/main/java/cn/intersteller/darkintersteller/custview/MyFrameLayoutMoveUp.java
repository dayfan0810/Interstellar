package cn.intersteller.darkintersteller.custview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.IntEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import cn.intersteller.darkintersteller.R;
import cn.intersteller.darkintersteller.utils.ScreenUtils;

public class MyFrameLayoutMoveUp extends FrameLayout {
    private static final String TAG = MyFrameLayoutMoveUp.class.getSimpleName();
    private static final float VIDEO_RATIO = 16f / 9f;

    private IntEvaluator intEvaluator = new IntEvaluator();
    //    private FloatEvaluator floatEvaluator = new FloatEvaluator();
//    private ArgbEvaluator colorEvaluator = new ArgbEvaluator();
    private Child_1_AnimatorWrapper mChild_1_Wrapper;
    private Child_2_AnimatorWrapper mChild_2_Wrapper;
    private Child_3_AnimatorWrapper mChild_3_Wrapper;
    private MyFrameLayoutMoveUp_Parent_AnimatorWrapper mParentWrapper;
    private View likeyoutobe_video_child_1;
    private View likeyoutobe_player_song_info_child_2;
    private View likeyoutobe_player_bottom_controler_3;
    private int downY;
    //缩小到底部时, 底部的顶部距离放大到顶部的顶部总距离
    private int allCanScrollY;
    private int downX;
    private int child_1_originalWidth;
    private int child_1_originalHeight;
    private int child_1_minWidth = ScreenUtils.dp2px(getContext(), 100);
    private int child_1_minHeight = (int) (child_1_minWidth / VIDEO_RATIO);
    private Context mContext;
    private boolean isClick;
    private Status nowStateScale;
    private VelocityTracker tracker;
    private boolean isFirstMeasure = true;
    private int initiation_controller_3_topMargin;
    private int initiation_controller_3_getWidth;
    private int initiation_song_info_2_getWidth;
    private int touchSlop;
    private int dY;
    private PlayPauseView likeyoutobe_play_pause;


    public interface VideoCallBack {
        //这个接口回调只与点击视频有关系,用来暂停/播放,和在哪个fragment无关
        void onVideoClick();

        void onVideosweep();
    }
    //1.视频区域点击回调,给activity用

    public VideoCallBack mVideoCallBack;

    public void setmVideoCallBack(VideoCallBack mVideoCallBack) {
        this.mVideoCallBack = mVideoCallBack;
    }
    //2.play/pause区域点击回调,给自定义的MyExoplayer2PlayerControlView用

    public onPlayPauseClick mOnPlayPauseClick;

    public interface onPlayPauseClick {
        void onPlayPauseClick();
    }

    public void setmOnPlayPauseClick(onPlayPauseClick mOnPlayPauseClick) {
        this.mOnPlayPauseClick = mOnPlayPauseClick;
    }

    //3.下一曲区域点击回调,给自定义的MyExoplayer2PlayerControlView用
    public OnPlayNextClick mOnPlayNextClick;

    public interface OnPlayNextClick {

        void onPlayNextClick();
    }

    public void setmOnPlayNextClick(OnPlayNextClick mOnPlayNextClick) {
        this.mOnPlayNextClick = mOnPlayNextClick;
    }

    //4.上一曲区域点击回调,给自定义的MyExoplayer2PlayerControlView用
    public OnPlayPrevClick mOnPlayPrevClick;

    public interface OnPlayPrevClick {
        void onPlayPrevClick();
    }

    public void setmOnPlayPrevClick(OnPlayPrevClick mOnPlayPrevClick) {
        this.mOnPlayPrevClick = mOnPlayPrevClick;
    }

    public enum Status {
        MAX,
        MIN
    }

    public MyFrameLayoutMoveUp(@NonNull Context context) {
        this(context, null);
    }

    public MyFrameLayoutMoveUp(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyFrameLayoutMoveUp(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        touchSlop = ViewConfiguration.get(mContext).getScaledTouchSlop();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        int childCount = getChildCount();
        likeyoutobe_video_child_1 = getChildAt(0);
        likeyoutobe_player_song_info_child_2 = getChildAt(1);
        likeyoutobe_player_bottom_controler_3 = getChildAt(2);
        likeyoutobe_play_pause = findViewById(R.id.likeyoutobe_play_pause);
        init();
        request();
    }


    private void init() {
//        this.setOnTouchListener(new Child_1_OnTouchListener());
        child_1_originalWidth = mContext.getResources().getDisplayMetrics().widthPixels;
        //这里就是这个myplaylistfragment.xml的显示区域,减去触摸不到的区域即可
        allCanScrollY = ScreenUtils.getScreenHeight(mContext)//屏幕高度
//                - getResources().getDimensionPixelSize(R.dimen.inner_fragment_tl_height)//toolbar高度
//                - getResources().getDimensionPixelSize(R.dimen.outter_fragment_tl_height)//tablayout高度
//                - ScreenUtils.getStatusBarHeight(mContext)
                - child_1_minHeight//视频最小高度
        ;//状态栏高度
        child_1_originalHeight = (int) (child_1_originalWidth / VIDEO_RATIO);

        //给视频的初始位置是max的
        nowStateScale = Status.MAX;
        FrameLayout.LayoutParams lp1 = (LayoutParams) likeyoutobe_video_child_1.getLayoutParams();
        lp1.width = child_1_originalWidth;
        lp1.height = child_1_originalHeight;
        likeyoutobe_video_child_1.setLayoutParams(lp1);
        //三个子child等高
        FrameLayout.LayoutParams lp2 = (LayoutParams) likeyoutobe_player_song_info_child_2.getLayoutParams();
        //lp2.width = child_1_originalWidth;
        lp2.height = child_1_minHeight;
        likeyoutobe_player_song_info_child_2.setLayoutParams(lp2);
        //三个子child等高
        FrameLayout.LayoutParams lp3 = (LayoutParams) likeyoutobe_player_bottom_controler_3.getLayoutParams();
        //lp3.width = child_1_originalWidth;
        lp3.height = child_1_minHeight;
        likeyoutobe_player_bottom_controler_3.setLayoutParams(lp3);
    }


    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        //TODO deng: 后面使用单例试试
        mChild_1_Wrapper = new Child_1_AnimatorWrapper();
        mChild_2_Wrapper = new Child_2_AnimatorWrapper();
        mChild_3_Wrapper = new Child_3_AnimatorWrapper();
        if (isFirstMeasure) {
            isFirstMeasure = false;
            initiation_song_info_2_getWidth = mChild_2_Wrapper.getWidth();
            initiation_controller_3_topMargin = mChild_3_Wrapper.getTopMargin();
            initiation_controller_3_getWidth = mChild_3_Wrapper.getWidth();

        }

    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.i("dengtest1111", "ACTION_DOWN");

                tracker = VelocityTracker.obtain();
                isClick = true;
                downY = (int) event.getRawY();
                downX = (int) event.getRawX();
                break;
            case MotionEvent.ACTION_MOVE:
                Log.i("dengtest1111", "ACTION_MOVE");

                tracker.addMovement(event);
                int moveY = (int) event.getRawY();
                int moveX = (int) event.getRawX();
                dY = downY - moveY;
                int dX = downX - moveX;
                float mPercent = 1 - (Math.abs(dY) * 1f) / allCanScrollY;
                if (Math.abs(dY) > Math.abs(dX) && (Math.abs(dY) > touchSlop || Math.abs(dX) > touchSlop)) {
                    //是纵向移动才滑动,横向不管
                    //触摸具体大于touchSlop
                    if (dY < 0) {
                        //下滑
                        isClick = false;
                        if (mPercent >= 0 && mChild_1_Wrapper.getWidth() >= child_1_minWidth) {
                            Log.i("dengmove", mChild_1_Wrapper.getTopMargin() + "");
                            this.getBackground().setAlpha((int) ((mPercent) * 255));
                            //取最小值的原因是不能然宽度一直减小
                            mChild_1_Wrapper.setWidth(Math.max(child_1_originalWidth * mPercent, child_1_minWidth));
                            mChild_1_Wrapper.setHeight(Math.max(child_1_originalHeight * mPercent, child_1_minHeight));
                            mChild_1_Wrapper.setTopMargin(intEvaluator.evaluate(mPercent, allCanScrollY, 0));
//                        mParentWrapper.setTopMargin(-dY);//对上边距做一个倍率放大,不放大的话,就是跟手实际距离
                            //用包装类wrap可以设置layoutparams,也可以使用估值器件
                            //向下滑动时,用估值器从initiation_song_info_2_bottomMargin开始滑动,由于likeyoutobe_player_song_info设置了android:layout_gravity="center_vertical"
                            //所以它的初始点的marginTop就是0,这个要注意.由于是在中央,所以位置就是allCanScrollY的一半,然后看具体情况加不加height
                            mChild_2_Wrapper.setTopMargin(intEvaluator.evaluate(mPercent, allCanScrollY / 2, 0));
                            //这里就是歌手歌名的左移偏移量计算很复杂,怀疑原因是布局文件likeyoutobe_player_song_info设置了center属性,
                            //可以看assets文件夹中的图解释
                            mChild_2_Wrapper.setLeftMargin(intEvaluator.evaluate(mPercent, -(child_1_originalWidth / 2 - initiation_song_info_2_getWidth / 2 - child_1_minWidth), 0));
                            mChild_3_Wrapper.setTopMargin(intEvaluator.evaluate(mPercent, allCanScrollY, initiation_controller_3_topMargin));
                            //再在计算likeyoutobe_player_bottom_controler的leftMargin时,确信了上面说的layout_gravity为center将会导致
                            //leftMargin的初始位置为0,如果不设置layout_gravity,那么leftMargin将会是距离父控件的真正距离
                            //下面这个
                            // initiation_song_info_2_getWidth+child_1_minWidth-(child_1_originalWidth/2 - initiation_controller_3_getWidth/2)
                            //这个数据的计算其实很简单,就是看min状态下的leftMargin-max状态下的leftMargin
                            mChild_3_Wrapper.setLeftMargin(intEvaluator.evaluate(mPercent, initiation_song_info_2_getWidth + child_1_minWidth - (child_1_originalWidth / 2 - initiation_controller_3_getWidth / 2), 0));
                        }
                    }
                    if (dY > 0 && nowStateScale == Status.MIN) {
                        Log.i("dengtest1", "222222222222222222");

                        isClick = false;
                        //上滑
                        mChild_1_Wrapper.setWidth(Math.max(child_1_originalWidth * (1 - mPercent), child_1_minWidth));
                        mChild_1_Wrapper.setHeight(Math.max(child_1_originalHeight * (1 - mPercent), child_1_minHeight));
                        this.getBackground().setAlpha((int) ((1 - mPercent) * 255));
                        mChild_1_Wrapper.setTopMargin(intEvaluator.evaluate(mPercent, 0, allCanScrollY));
                        mChild_2_Wrapper.setTopMargin(intEvaluator.evaluate(mPercent, 0, allCanScrollY / 2));
                        mChild_2_Wrapper.setLeftMargin(intEvaluator.evaluate(mPercent, 0, -(child_1_originalWidth / 2 - initiation_song_info_2_getWidth / 2 - child_1_minWidth)));
                        mChild_3_Wrapper.setTopMargin(intEvaluator.evaluate(mPercent, initiation_controller_3_topMargin, allCanScrollY));
                        mChild_3_Wrapper.setLeftMargin(intEvaluator.evaluate(mPercent, 0, initiation_song_info_2_getWidth + child_1_minWidth - (child_1_originalWidth / 2 - initiation_controller_3_getWidth / 2)));

                    }
                }
                break;
            case MotionEvent.ACTION_UP:

                if (isClick) {
                    Log.i("dengtest1111", "ACTION_UP,isClick");

                    if (nowStateScale == Status.MAX) {
                        //拿起手时, 如果时点击状态,再判断是否是全屏,如果是,就播放视频,如果不是,就goMin
                        if (downY < child_1_originalHeight) {
                            //必须是点击child1区域才能是播放暂停
                            mVideoCallBack.onVideoClick();
                        }
//                        else if (isClickPlayPause(downX, downY)) {
//                            Toast.makeText(mContext, "点击了播放/暂停", Toast.LENGTH_SHORT).show();
//                            Log.i("dengtest1111", "isClickPlayPause");
//                            mOnPlayPauseClick.onPlayPauseClick();
//                        }
//                        else (isClickPlayPause()) {
//                            mOnPlayPauseClick.onPlayPauseClick();
//                        }else(isClickPlayNext()) {
//                            mOnPlayNextClick.onPlayNextClick();
//                        }else(isClickPlayPrev()) {
//                            mOnPlayPrevClick.onPlayPrevClick();
//                        }
                    } else {
                        goMax();
                    }
                    break;
                } else {
                    tracker.computeCurrentVelocity(100);
                    float yVelocity = Math.abs(tracker.getYVelocity());
                    tracker.clear();
                    tracker.recycle();
                    if (yVelocity > 600) {
                        //TODO 在全屏和收起时的,如果快速滑动反向滑动,
                        //TODO 就会反向运动,这个分支还要再判断下,后面再完善吧
                        if (nowStateScale == Status.MIN) {
                            goMax();
                        } else {
                            goMin();
                        }
                    } else {
                        if (nowStateScale == Status.MAX && mChild_1_Wrapper.getWidth() < child_1_originalWidth / 2) {
                            goMin();
                        } else if (nowStateScale == Status.MAX && mChild_1_Wrapper.getWidth() > child_1_originalWidth / 2) {
                            goMax();
                        }

                        if (nowStateScale == Status.MIN && mChild_1_Wrapper.getWidth() < child_1_originalWidth / 2) {
                            goMin();
                        } else if (nowStateScale == Status.MIN && mChild_1_Wrapper.getWidth() > child_1_originalWidth / 2) {
                            goMax();
                        }
                    }
                }
                break;
        }
        if (nowStateScale == Status.MAX) {
            return true;
        }
        //Min并且触摸y值在底部区域是,也是要消费触摸事件的
        return nowStateScale == Status.MIN && downY > mChild_1_Wrapper.getTopMargin();

    }

    private boolean isClickonPlayPause(int x, int y) {

        //计算指定的exo_pause在屏幕中的坐标。
        RectF exo_pauserectF = ScreenUtils.calcViewScreenLocation(likeyoutobe_play_pause);
        int left = (int) exo_pauserectF.left;
        int top = (int) exo_pauserectF.top;
        int right = (int) (left + exo_pauserectF.width());
        int bottom = (int) (top + exo_pauserectF.height());
        Log.i("deng111", "exo_pauserectF.contains(x, y) =" + exo_pauserectF.contains(x, y));

        return exo_pauserectF.contains(x, y);
    }

    private void request() {
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();//view自己的方法
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && nowStateScale == Status.MAX) {
            goMin();
            return true;
        } else {
            return super.onKeyDown(keyCode, event);
        }
    }

    public void goMin() {
        Log.i("dengtest1", "222222222222222222", new Throwable("22222222"));

        AnimatorSet set = new AnimatorSet();
        set.playTogether(
                ObjectAnimator.ofFloat(mChild_1_Wrapper, "width", mChild_1_Wrapper.getWidth(), child_1_minWidth),
                ObjectAnimator.ofFloat(mChild_1_Wrapper, "height", mChild_1_Wrapper.getHeight(), child_1_minHeight),
                ObjectAnimator.ofInt(mChild_1_Wrapper, "topMargin", mChild_1_Wrapper.getTopMargin(), allCanScrollY),
                ObjectAnimator.ofInt(mChild_2_Wrapper, "topMargin", mChild_2_Wrapper.getTopMargin(), allCanScrollY / 2),
                ObjectAnimator.ofInt(mChild_2_Wrapper, "leftMargin", mChild_2_Wrapper.getLeftMargin(), -(child_1_originalWidth / 2 - initiation_song_info_2_getWidth / 2 - child_1_minWidth)),
                ObjectAnimator.ofInt(mChild_3_Wrapper, "leftMargin", mChild_3_Wrapper.getLeftMargin(), initiation_song_info_2_getWidth + child_1_minWidth - (child_1_originalWidth / 2 - initiation_controller_3_getWidth / 2)),
                ObjectAnimator.ofInt(mChild_3_Wrapper, "topMargin", mChild_3_Wrapper.getTopMargin(), allCanScrollY),
//                ObjectAnimator.ofInt(mParentWrapper, "topMargin", mParentWrapper.getTopMargin(), allCanScrollY),
                ObjectAnimator.ofInt(this.getBackground(), "Alpha", this.getBackground().getAlpha(), 0)
//                            ObjectAnimator.ofInt(mChild_1_Wrapper, "marginRight", mChild_1_Wrapper.getMarginRight(), 0),
//                            ObjectAnimator.ofInt(mChild_1_Wrapper, "detailMargin", mChild_1_Wrapper.getDetailMargin(), 0),
//                            ObjectAnimator.ofFloat(mChild_1_Wrapper, "z", mChild_1_Wrapper.getZ(), 0),
//                            ObjectAnimator.ofInt(this.getBackground(), "alpha", this.getBackground().getAlpha(), 255)
        );
        set.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                nowStateScale = Status.MIN;
//                RelativeLayout.LayoutParams p = (RelativeLayout.LayoutParams) getLayoutParams();
//                p.width = -2;
//                p.height = -2;
//                setLayoutParams(p);
//                mChild_2_Wrapper.setBackgroundColor(Color.parseColor("#f34649"));
//                mChild_3_Wrapper.setBackgroundColor(Color.parseColor("#f34649"));

            }
        });
        set.setInterpolator(new DecelerateInterpolator());
        set.setDuration(400).start();
    }

    public void goMax() {
        AnimatorSet set = new AnimatorSet();
        set.playTogether(
                ObjectAnimator.ofInt(this.getBackground(), "Alpha", this.getBackground().getAlpha(), 255),
//                ObjectAnimator.ofInt(mParentWrapper, "topMargin", mParentWrapper.getTopMargin(), 0),
                ObjectAnimator.ofFloat(mChild_1_Wrapper, "width", mChild_1_Wrapper.getWidth(), child_1_originalWidth),
                ObjectAnimator.ofFloat(mChild_1_Wrapper, "height", mChild_1_Wrapper.getHeight(), child_1_originalHeight),
                ObjectAnimator.ofInt(mChild_1_Wrapper, "topMargin", mChild_1_Wrapper.getTopMargin(), 0),
                //布局是什么center的,初始的margin应该都是0
                ObjectAnimator.ofInt(mChild_2_Wrapper, "topMargin", mChild_2_Wrapper.getTopMargin(), 0),
                ObjectAnimator.ofInt(mChild_2_Wrapper, "leftMargin", mChild_2_Wrapper.getLeftMargin(), 0),

                ObjectAnimator.ofInt(mChild_3_Wrapper, "topMargin", mChild_3_Wrapper.getTopMargin(), initiation_controller_3_topMargin),
                ObjectAnimator.ofInt(mChild_3_Wrapper, "leftMargin", mChild_3_Wrapper.getLeftMargin(), 0)

//                ObjectAnimator.ofFloat(mChild_2_Wrapper, "Alpha", mChild_2_Wrapper.getAlpha(), 1f)
//                            ObjectAnimator.ofInt(mChild_1_Wrapper, "marginRight", mChild_1_Wrapper.getMarginRight(), 0),
//                            ObjectAnimator.ofInt(mChild_1_Wrapper, "detailMargin", mChild_1_Wrapper.getDetailMargin(), 0),
//                            ObjectAnimator.ofFloat(mChild_1_Wrapper, "z", mChild_1_Wrapper.getZ(), 0),
//                            ObjectAnimator.ofInt(this.getBackground(), "alpha", this.getBackground().getAlpha(), 255)
        );
        set.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                nowStateScale = Status.MAX;

            }
        });
        set.setInterpolator(new DecelerateInterpolator());
        set.setDuration(400).start();
    }


    private class MyFrameLayoutMoveUp_Parent_AnimatorWrapper {
        //我们在myplaylistfragment.xml布局中, 引入的自定义view的父布局的包装类
        //用于属性动画
/*
//                        RelativeLayout.LayoutParams params =
//                                new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) getLayoutParams();
//                    params.setMargins(0, Math.abs(dY) , 0, dY);//left,top,right,bottom
//                    setLayoutParams(params);
                        params.topMargin = -dY + 400;
                        requestLayout();
 */
        private final RelativeLayout.LayoutParams layoutParams;
        MyFrameLayoutMoveUp myFrameLayoutMoveUp;

        public MyFrameLayoutMoveUp_Parent_AnimatorWrapper(MyFrameLayoutMoveUp myFrameLayoutMoveUp) {
            layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
            myFrameLayoutMoveUp = myFrameLayoutMoveUp;
        }

        int getTopMargin() {
            return layoutParams.topMargin;
        }

        void setTopMargin(int mr) {
            layoutParams.topMargin = mr;
            setLayoutParams(layoutParams);
//            requestLayout();
        }

    }


    private class Child_1_AnimatorWrapper {

        private final FrameLayout.LayoutParams child_1_params;

        Child_1_AnimatorWrapper() {
            child_1_params = (FrameLayout.LayoutParams) likeyoutobe_video_child_1.getLayoutParams();
        }

        int getWidth() {
            return child_1_params.width < 0 ? child_1_originalWidth : child_1_params.width;
        }

        void setWidth(float width) {
            if (width == child_1_originalWidth) {
                child_1_params.width = -1;
                child_1_params.setMargins(0, 0, 0, 0);
            } else
                child_1_params.width = (int) width;

            likeyoutobe_video_child_1.setLayoutParams(child_1_params);
        }

        int getHeight() {
            return child_1_params.height < 0 ? child_1_originalHeight : child_1_params.height;
        }

        void setHeight(float height) {
            child_1_params.height = (int) height;
            likeyoutobe_video_child_1.setLayoutParams(child_1_params);
        }

        //
        void setMarginTop(int m) {
            child_1_params.topMargin = m;
            likeyoutobe_video_child_1.setLayoutParams(child_1_params);
        }

        int getMarginTop() {
            return child_1_params.topMargin;
        }


        void setMarginRight(int mr) {
            child_1_params.rightMargin = mr;
            likeyoutobe_video_child_1.setLayoutParams(child_1_params);
        }

        int getTopMargin() {
            return child_1_params.topMargin;
        }

        void setTopMargin(int mr) {
            child_1_params.topMargin = mr;
            likeyoutobe_video_child_1.setLayoutParams(child_1_params);
        }

        int getMarginRight() {
            return child_1_params.rightMargin;
        }

        void setTranslationY(float y) {
            likeyoutobe_video_child_1.setTranslationY(y);
        }

        float getTranslationY() {
            return likeyoutobe_video_child_1.getTranslationY();
        }

        void setTranslationX(float x) {
            likeyoutobe_video_child_1.setTranslationX(x);

        }

        float getTranslationX() {
            return likeyoutobe_video_child_1.getTranslationX();
        }
    }

    private class Child_2_AnimatorWrapper {

        private final FrameLayout.LayoutParams child_2_params;

        Child_2_AnimatorWrapper() {
            child_2_params = (FrameLayout.LayoutParams) likeyoutobe_player_song_info_child_2.getLayoutParams();

        }

        int getWidth() {
            return child_2_params.width;
        }

        void setWidth(float width) {
            child_2_params.width = (int) width;
            likeyoutobe_player_song_info_child_2.setLayoutParams(child_2_params);
        }

        int getLeftMargin() {
            return child_2_params.leftMargin;
        }

        void setLeftMargin(int mr) {
            child_2_params.leftMargin = mr;
            likeyoutobe_player_song_info_child_2.setLayoutParams(child_2_params);
        }

        int getTopMargin() {
            return child_2_params.topMargin;
        }

        void setTopMargin(int mr) {
            child_2_params.topMargin = mr;
            likeyoutobe_player_song_info_child_2.setLayoutParams(child_2_params);
        }

        int getMarginStart() {
            return child_2_params.getMarginStart();
        }

        void setMarginStart(int mr) {
            child_2_params.setMarginStart(mr);
            likeyoutobe_player_song_info_child_2.setLayoutParams(child_2_params);
        }


        int getBottomMargin() {
            return child_2_params.topMargin;
        }

        void setBottomMargin(int mr) {
            child_2_params.bottomMargin = mr;
            likeyoutobe_player_song_info_child_2.setLayoutParams(child_2_params);
        }


        void setTranslationY(float y) {
            likeyoutobe_player_song_info_child_2.setTranslationY(y);
        }

        float getTranslationY() {
            return likeyoutobe_player_song_info_child_2.getTranslationY();
        }

        void setTranslationX(float x) {
            likeyoutobe_player_song_info_child_2.setTranslationX(x);

        }

        float getTranslationX() {
            return likeyoutobe_player_song_info_child_2.getTranslationX();
        }

        void setBackgroundColor(int x) {
            likeyoutobe_player_song_info_child_2.setBackgroundColor(x);
        }

    }

    private class Child_3_AnimatorWrapper {

        private final FrameLayout.LayoutParams child_3_params;

        Child_3_AnimatorWrapper() {
            child_3_params = (FrameLayout.LayoutParams) likeyoutobe_player_bottom_controler_3.getLayoutParams();
        }

        int getWidth() {
            return child_3_params.width;
        }

        void setWidth(float width) {
            child_3_params.width = (int) width;
            likeyoutobe_player_bottom_controler_3.setLayoutParams(child_3_params);
        }

        int getTopMargin() {
            return child_3_params.topMargin;
        }

        void setTopMargin(int mr) {
            child_3_params.topMargin = mr;
            likeyoutobe_player_bottom_controler_3.setLayoutParams(child_3_params);
        }


        int getLeftMargin() {
            return child_3_params.leftMargin;
        }

        void setLeftMargin(int mr) {
            child_3_params.leftMargin = mr;
            likeyoutobe_player_bottom_controler_3.setLayoutParams(child_3_params);
        }

        void setTranslationY(float y) {
            likeyoutobe_player_bottom_controler_3.setTranslationY(y);
        }

        float getTranslationY() {
            return likeyoutobe_player_bottom_controler_3.getTranslationY();
        }

        void setTranslationX(float x) {
            likeyoutobe_player_bottom_controler_3.setTranslationX(x);

        }

        float getTranslationX() {
            return likeyoutobe_player_bottom_controler_3.getTranslationX();
        }

        void setBackgroundColor(int x) {
            likeyoutobe_player_bottom_controler_3.setBackgroundColor(x);
        }

    }
}
