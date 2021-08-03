package cn.intersteller.darkintersteller.custview.slidinguppanel;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import cn.intersteller.darkintersteller.R;

public class SlidingUpPanelLayout extends ViewGroup {
    private static final int DEFAULT_FADE_COLOR = 0x99000000;
    private static final int DEFAULT_MIN_FLING_SPPED = 400;
    private static final int DEFAULT_PANDEL_HEIGT = 68;

    private int slideup_flingvelocity;
    private int slideup_shadowcolor;
    private int slideup_panelheight;

    public SlidingUpPanelLayout(Context context) {
        this(context, null);
    }

    public SlidingUpPanelLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SlidingUpPanelLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttrs(context, attrs);
        initOthers(context);
    }

    private void initOthers(Context context) {
        float density = context.getResources().getDisplayMetrics().density;

    }

    private void initAttrs(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.SlidingUpPanelLayout);
        if (typedArray == null) return;
        //最小上滑速度定义为投掷速度
        slideup_flingvelocity = typedArray.getInt(R.styleable.SlidingUpPanelLayout_deng_slideup_flingvelocity, DEFAULT_MIN_FLING_SPPED);
        //背部阴影
        slideup_shadowcolor = typedArray.getColor(R.styleable.SlidingUpPanelLayout_deng_slideup_shadowcolor, DEFAULT_FADE_COLOR);
        //面板高度dp值
        slideup_panelheight = typedArray.getDimensionPixelSize(R.styleable.SlidingUpPanelLayout_deng_slideup_panelheight, -1);

        typedArray.recycle();

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //widthMeasureSpec & heightMeasureSpec应该是这个自定义view在xml中声明的那个区间
        //所以下面的widthSize & heightSize就是这个区间的大小
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        final int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        final int heightMode = MeasureSpec.getMode(heightMeasureSpec);


        int childCount = getChildCount();
        View mMainView = getChildAt(0);
        View mSlideView = getChildAt(1);
        //parent_heightSize & parent_widthSize应该就是去掉边界后的大小,比如你在xml中声
        //明自定义控件的地方设置了padding外部区域的
        int parent_heightSize = widthSize - getPaddingTop() - getPaddingBottom();//子view所有的高度
        int parent_widthSize = heightSize - getPaddingLeft() - getPaddingRight();//子view所有的宽度
        for (int i = 0; i < childCount; i++) {
            View childView = getChildAt(i);
            LayoutParams layoutParams = childView.getLayoutParams();
            //
            int childWidth = parent_widthSize;
            int childHeight = parent_heightSize;
            int childWidthSpec;
            int childHeightSpec;
            if (childView == mMainView) {
                //主界面采用一个FrameLayout

            } else if (childView == mSlideView) {
                //滑动界面采用一个FrameLayout或者LinerLayout都行吧
            }


            if (layoutParams.width == LayoutParams.WRAP_CONTENT) {
                childWidthSpec = MeasureSpec.makeMeasureSpec(childWidth, MeasureSpec.AT_MOST);
            } else if (layoutParams.width == LayoutParams.MATCH_PARENT) {
                childWidthSpec = MeasureSpec.makeMeasureSpec(childWidth, MeasureSpec.EXACTLY);
            } else {
                childWidthSpec = MeasureSpec.makeMeasureSpec(childWidth, MeasureSpec.EXACTLY);
            }

            if (layoutParams.height == LayoutParams.WRAP_CONTENT) {
                childHeightSpec = MeasureSpec.makeMeasureSpec(childHeight, MeasureSpec.AT_MOST);
            } else {
                childHeightSpec = MeasureSpec.makeMeasureSpec(childHeight, MeasureSpec.EXACTLY);
            }
            childView.measure(childWidthSpec, childHeightSpec);
        }

        setMeasuredDimension(widthSize, heightSize);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

        final int paddingLeft = getPaddingLeft();
        final int paddingTop = getPaddingTop();

        final int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            final View child = getChildAt(i);
            final LayoutParams lp = child.getLayoutParams();
            int childTop = paddingTop;
            final int childHeight = child.getMeasuredHeight();

            final int childBottom = childTop + childHeight;
            final int childLeft = paddingLeft;
            final int childRight = childLeft + child.getMeasuredWidth();

            child.layout(childLeft, childTop, childRight, childBottom);
        }
    }


}
