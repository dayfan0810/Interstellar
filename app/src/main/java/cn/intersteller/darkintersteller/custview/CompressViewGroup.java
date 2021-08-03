package cn.intersteller.darkintersteller.custview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;

public class CompressViewGroup extends ViewGroup {
    public CompressViewGroup(Context context) {
        this(context, null);
    }

    public CompressViewGroup(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CompressViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {


    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }
}
