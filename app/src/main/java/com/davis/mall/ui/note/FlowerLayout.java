package com.davis.mall.ui.note;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ListAdapter;


public class FlowerLayout extends ViewGroup {


    private ListAdapter mAdapter;
    public void setAdapter(ListAdapter adapter) {
        mAdapter = adapter;
    }

    public FlowerLayout(Context context) {
        super(context);
    }

    public FlowerLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FlowerLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }
}
