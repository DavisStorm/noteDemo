package com.davis.mall.ui.note;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class FlowLayout extends ViewGroup {
    private int HorizontalSpace = 10;
    private int verticallSpace = 10;
    private boolean firstOnMeasure = true;
    private int selfMaxwidth=0;
    private int selfMaxheight=0;

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
     * spec拿自己的的，padding用父亲的，childDimension具体数值
     * 2.需要保存自己的宽高
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //因为onMeasure会被多次调用，所以用于测量或用于布局的数据要初始化
        initMeasureParams();

        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int paddingTop = getPaddingTop();
        /*
         * 第一次onMeasure这里widthSize是1080也就是父给的最大宽度，这时一行最多有4个子view，最宽的一行的宽是1036，测量完子view后将1036保存为了自己的宽度，所以
         * 第二次onMeasure测量，这里widthSize竟然变成了1036,而拿1036再去判断一行容纳几个子view是不正确的，如果FlowLayout属性width=match_parent就肯定不会出现这种情况，
         * 测试出结果正确，所以这里的宽度应该取第一次onMeasure出的最大宽度给子view作参考，设想一般容器和两个并排子view布局宽都为wrap_content，容器宽就为两子view宽之和，不会
         * 偏大和偏小，而这里会，是因为这里在第二次onMeasure的时候又拿子view判断是否换行，而这时候的容器的宽度是上一次onMeasure结尾时setMeasuredDimension的值
         * 所以结果出来的一行有几个子view又可能不同，导致容器的宽度又会改变，所以这是什么样的一类问题，我们可以想象如果容器内的子view宽高或者location会根据容器本身的宽高
         * 动态变化，子view需要拿到容器第一次onMeasure出的原始宽度作为判断标准来计算宽高和location
         * */
        if (firstOnMeasure) {
            selfMaxwidth = MeasureSpec.getSize(widthMeasureSpec);
            selfMaxheight = MeasureSpec.getSize(heightMeasureSpec);
            firstOnMeasure = false;
        }
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        //测量孩子
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            measureChild(childAt, widthMeasureSpec, heightMeasureSpec);
//            LayoutParams layoutParams = childAt.getLayoutParams();
//            int childWidthMeasureSpec = getChildMeasureSpec(widthMeasureSpec, paddingLeft + paddingRight, layoutParams.width);
//            int childHeightMeasureSpec = getChildMeasureSpec(heightMeasureSpec, paddingBottom + paddingTop, layoutParams.height);
//            childAt.measure(childWidthMeasureSpec, childHeightMeasureSpec);
            //测量孩子完后，要为计算父亲的宽高保存数据
            int childWidthSize = childAt.getMeasuredWidth();
            int childHeightSize = childAt.getMeasuredHeight();
            if (widthUsed + HorizontalSpace + childWidthSize < selfMaxwidth - paddingLeft - paddingRight) {
                lineViews.add(childAt);
                widthUsed = widthUsed + childWidthSize + HorizontalSpace;
                maxHeight = Math.max(maxHeight, childHeightSize);

            } else {
                allViews.add(new ArrayList<>(lineViews));
                widthUsed = widthUsed - HorizontalSpace;//最后一个减去右间距
                maxWidth = Math.max(maxWidth, widthUsed);
                wholeHeight += maxHeight + verticallSpace;
                //清除数据添加下一行
                lineViews.clear();
                lineViews.add(childAt);
                widthUsed = childWidthSize + HorizontalSpace;
                maxHeight = childHeightSize;
            }
            //最后一行是没有加到allViews的，这里加上
            if (i == childCount - 1) {//如果最后一个孩子没有换行
                allViews.add(new ArrayList<>(lineViews));
                widthUsed = widthUsed - HorizontalSpace;//最后一个减去右间距
                maxWidth = Math.max(maxWidth, widthUsed);
                wholeHeight += maxHeight;
            }
        }

        //测量完孩子要保存自己的宽高了
        int newWidth = 0;
        int newHeight = 0;
        switch (widthMode) {
            case MeasureSpec.EXACTLY:
                newWidth = selfMaxwidth;
                break;
            case MeasureSpec.AT_MOST:
                newWidth = maxWidth;
                break;
            case MeasureSpec.UNSPECIFIED:
                newWidth = 0;
                break;
        }
        switch (heightMode) {
            case MeasureSpec.EXACTLY:
                newHeight = selfMaxheight;
                break;
            case MeasureSpec.AT_MOST:
                newHeight = wholeHeight;
                break;
            case MeasureSpec.UNSPECIFIED:
                newHeight = 0;
                break;
        }
        setMeasuredDimension(newWidth + paddingLeft + paddingRight, newHeight + paddingTop + paddingBottom);
    }

    private void initMeasureParams() {
//        private List<List<View>> allViews = new ArrayList<>();//行结构的所有子view集合
//        private List<View> lineViews = new ArrayList<>();//一行包含的子view
//        private int widthUsed = 0;//一行已经使用的宽度
//        private int maxHeight = 0;//一行中最高的某个子view的高度
//        private int maxWidth = 0;//记录下最宽的一行的宽度
//        private int wholeHeight = 0;//一行中最高的某个子view的高度

        wholeHeight = 0;
        maxWidth = 0;
        maxHeight = 0;
        widthUsed = 0;
        allViews.clear();
        lineViews.clear();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int left = getPaddingLeft();
        int top = getPaddingTop();
        for (int i = 0; i < allViews.size(); i++) {
            List<View> lineviews = allViews.get(i);
            left = getPaddingLeft();
            int maxItemHeight = 0;
            for (int j = 0; j < lineviews.size(); j++) {
                View view = lineviews.get(j);
                int measuredWidth = view.getMeasuredWidth();
                int measuredHeight = view.getMeasuredHeight();
                //保存最高子view的高度
                maxItemHeight = Math.max(maxItemHeight, measuredHeight);
                view.layout(left, top, left + measuredWidth, top + measuredHeight);
                left = left + measuredWidth + HorizontalSpace;

            }
            top += maxItemHeight + verticallSpace;
        }
    }
}
