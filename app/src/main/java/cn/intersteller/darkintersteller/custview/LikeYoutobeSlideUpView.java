package cn.intersteller.darkintersteller.custview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.FloatEvaluator;
import android.animation.IntEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.SeekBar;

import cn.intersteller.darkintersteller.utils.ScreenUtils;

public class LikeYoutobeSlideUpView extends ViewGroup {
    private static final String TAG = "-dengLikeYoutobeSlideUpView-tag";
    //我们定义的这个视图,分为3个部分:封面, 标题&歌手, 控制器.所以对这三个部分分别动画
    //先简单起见,只有专辑封面可以拖动
    private IntEvaluator intEvaluator = new IntEvaluator();
    private FloatEvaluator floatEvaluator = new FloatEvaluator();
    private ArgbEvaluator colorEvaluator = new ArgbEvaluator();
    private int downY;

    public interface Callback {
        void onVideoViewHide();

        void onVideoClick();
    }

    //单击以及消失时的回调
    private Callback mCallback;

    // 可拖动的videoView 和下方的播放信息,控制面板
    private View likeyoutobe_video_child_1;
    private View likeyoutobe_player_song_info_child_2;
    private View likeyoutobe_player_bottom_controler_3;
    private SeekBar likeyoutobe_seek_bottom;

    // video类的包装类，用于属性动画
    private Child_1_Wrapper mChild_1_Wrapper;
    private Child_2_Wrapper mChild_2_Wrapper;
//    private Child_3_Wrapper mChild_3_Wrapper;

    //滑动区间,取值为是videoView最小化时距离屏幕顶端的高度
//    private float allScrollY;

    //1f为初始状态，0.5f或0.25f(横屏时)为最小状态
    private float nowStateScale;
    //最小的缩放比例
    private float MIN_RATIO = 0.3f;
    //播放器比例
    private static final float VIDEO_RATIO = 16f / 9f;

    //是否是第一次Measure，用于获取播放器初始宽高
    private boolean isFirstMeasure = true;
    private final int screenWidth;
    private final int screenHeight;
    //VideoView初始宽高
    private int child_1_originalWidth = 1080;
    private int child_1_originalHeight = 570;

    //歌曲名和歌手的初始宽高
    private int child_2_originalWidth;
    private int child_2_originalHeight;

    //底部控制栏的初始宽高
    private int child_3_originalWidth;
    private int child_3_originalHeight;


    //最小时距离屏幕右边以及下边的 DP值 初始化时会转化为PX
    private static final int MARGIN_DP = 44;
    private int marginPx;

    //是否可以横滑删除
    private boolean canHide;

    public LikeYoutobeSlideUpView(Context context) {
        this(context, null);
    }

    public LikeYoutobeSlideUpView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LikeYoutobeSlideUpView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        screenWidth = ScreenUtils.getScreenWidth(context);
        screenHeight = ScreenUtils.getScreenHeight(context);
        //初始化包装类
        //DP To PX
        marginPx = MARGIN_DP * (getContext().getResources().getDisplayMetrics().densityDpi / 160);
    }


    //111111111111111111111111
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        final int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        final int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        final int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        final int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        if (widthMode != MeasureSpec.EXACTLY && widthMode != MeasureSpec.AT_MOST) {
            throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
        } else if (heightMode != MeasureSpec.EXACTLY && heightMode != MeasureSpec.AT_MOST) {
            throw new IllegalStateException("Height must have an exact value or MATCH_PARENT");
        }
        int childCount = getChildCount();

        for (int i = 0; i < childCount; i++) {
            final View child = getChildAt(i);
            //这里非常重要,不然每个child里面的东西不会显示,只会显示child的背景颜色
            measureChild(child, widthMeasureSpec, heightMeasureSpec);
            measureChildWithMargins(child, widthMeasureSpec, 0, heightMeasureSpec, 0);
        }
        if (isFirstMeasure) {
            //滑动区间,取值为是videoView最小化时距离屏幕顶端的高度 也就是最小化时的marginTop
//            allScrollY = this.getMeasuredHeight() - MIN_RATIO * child_1_originalHeight;

            isFirstMeasure = false;
        }
        setMeasuredDimension(widthSize, heightSize);

    }

    //2222222222222222222222222
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        Log.i(TAG, "onLayout");
        int child_1_measuredWidth = likeyoutobe_video_child_1.getMeasuredWidth();
        int child_1_measuredHeight = likeyoutobe_video_child_1.getMeasuredHeight();
//        likeyoutobe_video_child_1.getM
        int child_2_measuredWidth = likeyoutobe_player_song_info_child_2.getMeasuredWidth();
        int child_2_measuredHeight = likeyoutobe_player_song_info_child_2.getMeasuredHeight();

        int child_3_measuredWidth = likeyoutobe_player_bottom_controler_3.getMeasuredWidth();
        int child_3_measuredHeight = likeyoutobe_player_bottom_controler_3.getMeasuredHeight();

        int child_4_measuredWidth = likeyoutobe_seek_bottom.getMeasuredWidth();
        int child_4_measuredHeight = likeyoutobe_seek_bottom.getMeasuredHeight();

        likeyoutobe_video_child_1.layout(
                0, getMeasuredHeight() - child_1_measuredHeight,
                child_1_measuredWidth, getMeasuredHeight() - child_4_measuredHeight);
        likeyoutobe_player_song_info_child_2.layout(child_1_measuredWidth, getMeasuredHeight() - child_2_measuredHeight,
                child_1_measuredWidth + child_2_measuredWidth, getMeasuredHeight() - child_4_measuredHeight);
        likeyoutobe_player_bottom_controler_3.layout(child_1_measuredWidth + child_2_measuredWidth, getMeasuredHeight() - child_3_measuredHeight,
                getMeasuredWidth(), getMeasuredHeight() - child_4_measuredHeight);
        likeyoutobe_seek_bottom.layout(0, getMeasuredHeight() - child_4_measuredHeight,
                child_4_measuredWidth, getMeasuredHeight());
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        likeyoutobe_video_child_1 = getChildAt(0);
        likeyoutobe_player_song_info_child_2 = getChildAt(1);
        likeyoutobe_player_bottom_controler_3 = getChildAt(2);
        likeyoutobe_seek_bottom = (SeekBar) getChildAt(3);
        init();
    }


    private void init() {
        likeyoutobe_video_child_1.setOnTouchListener(new Child_1_OnTouchListener());
        mChild_1_Wrapper = new Child_1_Wrapper();
        mChild_2_Wrapper = new Child_2_Wrapper();
//        child_1_originalWidth = likeyoutobe_video_child_1.getContext().getResources().getDisplayMetrics().widthPixels;
//        child_1_originalHeight = (int) (child_1_originalWidth / VIDEO_RATIO);
        Log.i(TAG, "originalWidth = " + child_1_originalWidth);
        Log.i(TAG, "originalHeight = " + child_1_originalHeight);
    }


    private class Child_1_OnTouchListener implements OnTouchListener {
        //保存上一个滑动事件手指的坐标
        private int mLastY;
        private int mLastX;
        //刚触摸时手指的坐标
        private int mDownY;
        private int mDownX;

        private int dy;//和上一次滑动的差值 设置为全局变量是因为 UP里也要使用

        private boolean isClick;
        private int touchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();

        private VelocityTracker tracker;

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    downY = (int) event.getY();
                    break;
                case MotionEvent.ACTION_MOVE:
                    int moveY = (int) event.getY();
                    if (moveY > -150) break;
                    int dY = downY - moveY;
                    Log.i(TAG, "moveY = " + moveY);
                    Log.i(TAG, "getMeasuredHeight = " + likeyoutobe_video_child_1.getMeasuredHeight());
                    float mPercent = (dY * 1f) / (getHeight());
                    Log.i(TAG, "mPercent = " + mPercent);

                    mChild_1_Wrapper.setWidth(1080 * mPercent);
                    mChild_1_Wrapper.setHeight(1080 * mPercent /VIDEO_RATIO);
//                    mChild_1_Wrapper.setMarginRight(300);

//                    likeyoutobe_player_song_info_child_2.setTranslationY(floatEvaluator.evaluate(mPercent, 100, -500));
//                    likeyoutobe_player_song_info_child_2.setTranslationX(floatEvaluator.evaluate(mPercent, 0, -330));

                    break;
                case MotionEvent.ACTION_UP:
                    int upScrollX = getScrollX();
                    int dx;
//                    if (upScrollX > -menuWidth / 2) {
//                        dx = -upScrollX;
//                        isOpen = false;
//                    } else {
//                        dx = -menuWidth - upScrollX;
//                        isOpen = true;
//                    }
//                    // 要想用Scroller滚动,需要调用invalidate
//                    mScroller.startScroll(upScrollX, 0, dx, 0);
//                    // ViewGroup重绘必然会调用孩子的重绘
//                    invalidate();
                    break;

                default:
                    break;
            }
            return true;
        }

    }

    private void moveVideo() {


    }


    private void updateVideoView(int m) {
        //如果当前状态是最小化，先把我们的的布局宽高设置为MATCH_PARENT
        if (nowStateScale == MIN_RATIO) {
            LayoutParams params = getLayoutParams();
            params.width = -1;
            params.height = -1;
            setLayoutParams(params);
        }
        //设置宽高
//        mChild_1_Wrapper.setWidth(child_1_originalWidth * videoPercent);
//        mChild_1_Wrapper.setHeight(child_1_originalHeight * videoPercent);

    }

    private void dismissView() {
//        ObjectAnimator anim = ObjectAnimator.ofFloat(likeyoutobe_video_child_1, "alpha", 1f, 0);
//        anim.addListener(new AnimatorListenerAdapter() {
//            @Override
//            public void onAnimationEnd(Animator animation) {
//                setVisibility(INVISIBLE);
//                likeyoutobe_video_child_1.setAlpha(1f);
//            }
//        });
//        anim.setDuration(300).start();

        if (mCallback != null)
            mCallback.onVideoViewHide();
    }

    private void confirmState(float v, int dy) { //dy用于判断是否反方向滑动了

        //如果手指抬起时宽度达到一定值 或者 速度达到一定值 则改变状态
        if (nowStateScale == 1f) {
            if (likeyoutobe_video_child_1.getWidth() <= child_1_originalWidth * 0.75f || (v > 15 && dy > 0)) {
                goMin();
            } else
                goMax();
        } else {
            if (likeyoutobe_video_child_1.getWidth() >= child_1_originalWidth * 0.75f || (v > 15 && dy < 0)) {
                goMax();
            } else
                goMin();
        }
    }

    public void goMax() {
//        if (nowStateScale == MIN_RATIO) {
        LayoutParams params = getLayoutParams();
        params.width = -1;
        params.height = -1;
        setLayoutParams(params);
//        }

        AnimatorSet set = new AnimatorSet();
        set.playTogether(

                ObjectAnimator.ofFloat(mChild_1_Wrapper, "translationY", 0, -900),
                ObjectAnimator.ofFloat(mChild_1_Wrapper, "width", mChild_1_Wrapper.getWidth(), child_1_originalWidth - 10),
                ObjectAnimator.ofFloat(mChild_1_Wrapper, "height", mChild_1_Wrapper.getHeight(), 1111)
//
//                ObjectAnimator.ofFloat(likeyoutobe_player_song_info_child_2, "translationX",
//                        0, -(getMeasuredWidth() / 2) - likeyoutobe_player_song_info_child_2.getMeasuredWidth() / 2),
//                ObjectAnimator.ofFloat(likeyoutobe_player_song_info_child_2, "translationY", 0, -600),


//                ObjectAnimator.ofFloat(likeyoutobe_player_bottom_controler_3, "translationX", 0, -(getMeasuredWidth() / 2 + likeyoutobe_player_bottom_controler_3.getMeasuredWidth() / 2)),
//                ObjectAnimator.ofFloat(likeyoutobe_player_bottom_controler_3, "translationY", 0, -400)
        );
        Log.i(TAG, "mChild_1_Wrapper.getHeight() = " + mChild_1_Wrapper.getHeight());
        Log.i(TAG, "child_1_originalHeight() = " + child_1_originalHeight);
        set.setInterpolator(new DecelerateInterpolator());

        set.setDuration(300).start();
        nowStateScale = 1.0f;
        canHide = false;
    }

    public void goMin() {
        AnimatorSet set = new AnimatorSet();
        set.playTogether(
                //videoview的缩小动画
                ObjectAnimator.ofFloat(mChild_1_Wrapper, "width", mChild_1_Wrapper.getWidth(), child_1_originalWidth * MIN_RATIO),
                ObjectAnimator.ofFloat(mChild_1_Wrapper, "height", mChild_1_Wrapper.getHeight(), child_1_originalHeight * MIN_RATIO),
//                ObjectAnimator.ofInt(mChild_1_Wrapper, "marginTop", mChild_1_Wrapper.getMarginTop(), (int) allScrollY),
//                ObjectAnimator.ofInt(mChild_1_Wrapper, "marginRight", mChild_1_Wrapper.getMarginRight(), marginPx),
//                ObjectAnimator.ofInt(mChild_1_Wrapper, "detailMargin", mChild_1_Wrapper.getDetailMargin(), marginPx),
                ObjectAnimator.ofFloat(mChild_1_Wrapper, "z", mChild_1_Wrapper.getZ(), marginPx / 2)
//                ObjectAnimator.ofInt(this.getBackground(), "alpha", this.getBackground().getAlpha(), 0)

                //歌曲名和歌手的缩小动画
//                ObjectAnimator.ofFloat(likeyoutobe_player_song_info_child_2, "alpha", likeyoutobe_player_song_info_child_2.getAlpha(), 0)
//                ObjectAnimator.ofFloat(mChild_2_Wrapper, "width", likeyoutobe_player_song_info_child_2.getWidth(), 270),
//                ObjectAnimator.ofFloat(mChild_2_Wrapper, "height", likeyoutobe_player_song_info_child_2.getHeight(), screenWidth - 50)
        );
        set.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                canHide = true;

//                ViewGroup.LayoutParams p = getLayoutParams();
//                p.width = ViewGroup.LayoutParams.MATCH_PARENT;//-1
//                p.height = LayoutParams.WRAP_CONTENT;//-1
//                setLayoutParams(p);

                nowStateScale = MIN_RATIO;
            }
        });
        set.setDuration(400).start();
    }

    //获取当前状态
    public float getNowStateScale() {
        return nowStateScale;
    }

    public void show_adaw() {
        setVisibility(VISIBLE);
        goMax();
    }

    public void setCallback(Callback callback) {
        mCallback = callback;
    }


    private class Child_1_Wrapper {

        private final LayoutParams child_1_params;
        private MarginLayoutParams marginParams;

        Child_1_Wrapper() {
            child_1_params = likeyoutobe_video_child_1.getLayoutParams();
            marginParams = null;
            //获取view的margin设置参数
            if (child_1_params instanceof ViewGroup.MarginLayoutParams) {
                marginParams = (ViewGroup.MarginLayoutParams) child_1_params;
            } else {
                //不存在时创建一个新的参数
                //基于View本身原有的布局参数对象
                marginParams = new ViewGroup.MarginLayoutParams(child_1_params);
            }
        }

        int getWidth() {
            return child_1_params.width < 0 ? child_1_originalWidth : child_1_params.width;
        }

        void setWidth(float width) {
            if (width == child_1_originalWidth) {
                marginParams.width = -1;
                marginParams.setMargins(0, 0, 0, 0);
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


        void setMarginTop(int m) {
            marginParams.topMargin = m;
            likeyoutobe_video_child_1.setLayoutParams(child_1_params);
        }

        int getMarginTop() {
            return marginParams.topMargin;
        }


        void setMarginRight(int mr) {
            marginParams.rightMargin = mr;
            likeyoutobe_video_child_1.setLayoutParams(child_1_params);
        }

        int getMarginRight() {
            return marginParams.rightMargin;
        }

        void setZ(float z) {
            likeyoutobe_video_child_1.setTranslationZ(z);
        }

        float getZ() {
            return likeyoutobe_video_child_1.getTranslationZ();
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


    private class Child_2_Wrapper {

        private final LayoutParams child_1_params;
        private MarginLayoutParams marginParams;

        Child_2_Wrapper() {
            child_1_params = likeyoutobe_video_child_1.getLayoutParams();
            marginParams = null;
            //获取view的margin设置参数
            if (child_1_params instanceof ViewGroup.MarginLayoutParams) {
                marginParams = (ViewGroup.MarginLayoutParams) child_1_params;
            } else {
                //不存在时创建一个新的参数
                //基于View本身原有的布局参数对象
                marginParams = new ViewGroup.MarginLayoutParams(child_1_params);
            }
        }

        int getWidth() {
            return child_1_params.width < 0 ? child_1_originalWidth : child_1_params.width;
        }

        void setWidth(float width) {
            if (width == child_1_originalWidth) {
                marginParams.width = -1;
                marginParams.setMargins(0, 0, 0, 0);
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


        void setMarginTop(int m) {
            marginParams.topMargin = m;
            likeyoutobe_video_child_1.setLayoutParams(child_1_params);
        }

        int getMarginTop() {
            return marginParams.topMargin;
        }

        void setMarginRight(int mr) {
            marginParams.rightMargin = mr;
            likeyoutobe_video_child_1.setLayoutParams(child_1_params);
        }

        int getMarginRight() {
            return marginParams.rightMargin;
        }

        void setZ(float z) {
            likeyoutobe_video_child_1.setTranslationZ(z);
        }

        float getZ() {
            return likeyoutobe_video_child_1.getTranslationZ();
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


    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new MyLayoutParams(getContext(), attrs);
    }

    @Override
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams lp) {
        return new MyLayoutParams(lp);
    }

    @Override
    protected LayoutParams generateDefaultLayoutParams() {
        return new MyLayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
    }


    public static class MyLayoutParams extends ViewGroup.MarginLayoutParams {
        public MyLayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
        }

        public MyLayoutParams(int width, int height) {
            super(width, height);
        }

        public MyLayoutParams(MarginLayoutParams source) {
            super(source);
        }

        public MyLayoutParams(LayoutParams source) {
            super(source);
        }
    }

}