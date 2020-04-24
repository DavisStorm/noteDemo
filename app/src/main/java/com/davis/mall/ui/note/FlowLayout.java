package com.davis.mall.ui.note;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FlowLayout extends ViewGroup {
    private int HorizontalSpace = 10;
    private int verticallSpace = 10;

    public FlowLayout(Context context) {
        super(context);
    }

    public FlowLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FlowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    private List<List<View>> allViews = new ArrayList<>();//行结构的所有子view集合
    private List<View> lineViews = new ArrayList<>();//一行包含的子view
    private int widthUsed = 0;//一行已经使用的宽度
    private int maxHeight = 0;//一行中最高的某个子view的高度
    private int maxWidth = 0;//记录下最宽的一行的宽度
    private int wholeHeight = 0;//一行中最高的某个子view的高度

    /**
     * 1.需要测量子view的尺寸，需要知道childWidthMeasureSpc和childHeightMeasureSpc，通过getChildMeasureSpec(int spec, int padding, int childDimension)
     * spec拿爷爷的，padding用父亲的，childDimension具体数值
     * 2.需要保存自己的宽高
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        getChildMeasureSpec()
//        View view = new TextView(getContext());
//        view.measure();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int paddingTop = getPaddingTop();
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        //测量孩子
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            LayoutParams layoutParams = childAt.getLayoutParams();
            int childWidthMeasureSpec = getChildMeasureSpec(widthMeasureSpec, paddingLeft + paddingRight, layoutParams.width);
            int childHeightMeasureSpec = getChildMeasureSpec(widthMeasureSpec, paddingBottom + paddingTop, layoutParams.height);
            childAt.measure(childWidthMeasureSpec, childHeightMeasureSpec);
            //测量孩子完后，要为计算父亲的宽高保存数据
            if (widthUsed + HorizontalSpace + childWidthMeasureSpec <= widthSize) {
                lineViews.add(childAt);
                widthUsed = widthUsed + childWidthMeasureSpec + HorizontalSpace;
                maxHeight = Math.max(maxHeight, childHeightMeasureSpec);
            } else {
                allViews.add(new ArrayList<>(lineViews));
                maxWidth = Math.max(maxWidth,widthUsed);
                wholeHeight += maxHeight;
                //清除数据添加下一行
                lineViews.clear();
                lineViews.add(childAt);
                widthUsed = childWidthMeasureSpec + HorizontalSpace;
                maxHeight = childHeightMeasureSpec;
            }
        }
        //测量完孩子要保存自己的宽高了
        switch (widthMode){
            case MeasureSpec.EXACTLY:
                break;
            case MeasureSpec.AT_MOST:
                widthSize = maxWidth;
                break;
            case MeasureSpec.UNSPECIFIED:
                break;
        }
        switch (heightMode){
            case MeasureSpec.EXACTLY:
                break;
            case MeasureSpec.AT_MOST:
                heightSize = wholeHeight;
                break;
            case MeasureSpec.UNSPECIFIED:
                break;
        }
        setMeasuredDimension(widthSize,heightSize);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int left =0;
        int top =0;
        for (int i = 0; i < allViews.size(); i++) {
            List<View> lineviews = allViews.get(i);
            left=0;
            int maxItemHeight =0;
            for (int j = 0; j < lineviews.size(); j++) {
                View view = lineviews.get(j);
                int measuredWidth = view.getMeasuredWidth();
                int measuredHeight = view.getMeasuredHeight();
                //保存最高子view的高度
                maxItemHeight = Math.max(maxItemHeight,measuredHeight);
                view.layout(left,top,left+measuredWidth,top+measuredHeight);
                left = measuredWidth+HorizontalSpace;

            }
            top += maxItemHeight+verticallSpace;
        }
    }
}
