package cn.intersteller.darkintersteller.custview;


import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;

import cn.intersteller.darkintersteller.R;


//这个自定义类,是想在底部提供一个按钮,然后一点就很多烟花或激光,模仿那个卫星菜单
public class ArcMenuByImooc extends ViewGroup implements View.OnClickListener {

    private final int DEFAULT_RADIUS = 40;
    private static final int LEFT_TOP = 0;
    private static final int RIGHT_TOP = 1;
    private static final int LEFT_BOTTOM = 2;
    private static final int RIGHT_BOTTOM = 3;
    private int arcmenubyimooc_menu_radius;
    private int arcmenubyimooc_menu_position;
    private View mCenterButton;
    private Status mCurrentStatus = Status.OPEN;
    private TranslateAnimation tranAnim;


    public enum Status {
        OPEN,
        CLOSE
    }

    public ArcMenuByImooc(Context context) {
        this(context, null);
    }

    public ArcMenuByImooc(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ArcMenuByImooc(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ArcMenuByImooc, defStyleAttr, 0);
        arcmenubyimooc_menu_radius = (int) typedArray.getDimension(R.styleable.ArcMenuByImooc_menu_radius, 10f);
        arcmenubyimooc_menu_position = typedArray.getInt(R.styleable.ArcMenuByImooc_menu_position, RIGHT_BOTTOM);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            measureChild(getChildAt(i), widthMeasureSpec, heightMeasureSpec);
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int childCount = getChildCount();
        //1.定位中心button
        mCenterButton = getChildAt(0);
        mCenterButton.setOnClickListener(this);
        //2.得到中心button的宽高
        int button_measuredWidth = mCenterButton.getMeasuredWidth();
        int button_measuredHeight = mCenterButton.getMeasuredHeight();
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
//        Log.i("dengarcmeasure", "button_measuredWidth  = " + button_measuredWidth);
//        Log.i("dengarcmeasure", "measuredWidth  = " + measuredWidth);
        //4.根据xml中指定的菜单位置设定中心按钮的宽高,肯定要设置一个缓存位置
        //这里知道左边就可以知道右边
        //知道上面就知道下面的位置了
        int left = 0, top = 0;
        switch (arcmenubyimooc_menu_position) {
            case 0:
                //在左上角
                left = 0;
                top = 0;
                break;
            case 1:
                //在右上角
                left = measuredWidth - button_measuredWidth;
                top = 0;
                break;
            case 2:
                //在左下角
                left = 0;
                top = measuredHeight - button_measuredHeight;
                break;
            case 3:
                //在右下角
                left = measuredWidth - button_measuredWidth;
                top = measuredHeight - button_measuredHeight;

                break;
        }

        int l1 = left;
        int t1 = top;
        int r1 = left + button_measuredWidth;
        int b1 = top + button_measuredHeight;
        mCenterButton.layout(l1, t1, r1, b1);

        //如果有n个菜单,那么childCount=n+1,有一个是中心button的,从i=1开始才是菜单child
        for (int i = 1; i < childCount; i++) {
            View child_menu = getChildAt(i);
            child_menu.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i("dengchild", "child onClick ");

                }
            });
            int child_menu_left = 0;
            int child_menu_top = 0;
            int child_menuMeasuredWidth = child_menu.getMeasuredWidth();
            int child_menuMeasuredHeight = child_menu.getMeasuredHeight();
            child_menu_left = (int) (arcmenubyimooc_menu_radius * Math.sin(Math.PI / 2 / (childCount - 2) * (i - 1)));
            child_menu_top = (int) (arcmenubyimooc_menu_radius * Math.cos(Math.PI / 2 / (childCount - 2) * (i - 1)));
            switch (arcmenubyimooc_menu_position) {
                case LEFT_TOP:
                    child_menu.layout(
                            left + child_menu_left,
                            top + child_menu_top,
                            left + child_menu_left + child_menuMeasuredWidth,
                            top + child_menu_top + child_menuMeasuredHeight);
                    break;

                case RIGHT_BOTTOM:
                    child_menu_left = (int) (arcmenubyimooc_menu_radius * Math.sin(Math.PI / 2 / (childCount - 2) * (i - 1)));
                    child_menu_top = (int) (arcmenubyimooc_menu_radius * Math.cos(Math.PI / 2 / (childCount - 2) * (i - 1)));
                    int paddingRight = mCenterButton.getPaddingRight();
                    int paddingBottom = mCenterButton.getPaddingBottom();
                    child_menu.layout(
                            getMeasuredWidth() - child_menu_left - child_menuMeasuredWidth - button_measuredWidth / 2 + paddingRight,
                            getMeasuredHeight() - child_menu_top - child_menuMeasuredHeight - button_measuredHeight / 2 + paddingBottom,
                            getMeasuredWidth() - child_menu_left - button_measuredWidth / 2 + paddingRight,
                            getMeasuredHeight() - child_menu_top - button_measuredHeight / 2 + paddingBottom);
                    break;
            }
        }
    }

    /*
     *中心button的点击事件
     */
    @Override
    public void onClick(View v) {
        centerButtonAnim();
        menuAnim();
    }

    private void menuAnim() {
        int childCount = getChildCount();
        for (int i = 1; i < childCount; i++) {
            View menu_child = getChildAt(i);
            int child_menu_left = (int) (arcmenubyimooc_menu_radius * Math.sin(Math.PI / 2 / (childCount - 2) * (i - 1)));
            int child_menu_top = (int) (arcmenubyimooc_menu_radius * Math.cos(Math.PI / 2 / (childCount - 2) * (i - 1)));
            AnimationSet animset = new AnimationSet(true);
            if (mCurrentStatus == Status.CLOSE) {
                tranAnim = new TranslateAnimation(child_menu_left, 0, child_menu_top, 0);
                menu_child.setClickable(false);
                menu_child.setFocusable(false);
            } else {
                tranAnim = new TranslateAnimation(0, child_menu_left, 0, child_menu_top);
                menu_child.setClickable(true);
                menu_child.setFocusable(true);
            }
            tranAnim.setFillAfter(true);
            tranAnim.setDuration(150);
            tranAnim.setStartOffset(((i) * 150) / childCount);
            tranAnim.setAnimationListener(new Animation.AnimationListener() {

                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    if (mCurrentStatus == Status.CLOSE) {
                        menu_child.setVisibility(GONE);
                    } else {
                        menu_child.setVisibility(VISIBLE);
                    }
                }
            });

            animset.addAnimation(tranAnim);
            menu_child.startAnimation(animset);

        }
        mCurrentStatus = (mCurrentStatus == Status.CLOSE ? Status.OPEN
                : Status.CLOSE);

    }

    private void centerButtonAnim() {

    }
}
