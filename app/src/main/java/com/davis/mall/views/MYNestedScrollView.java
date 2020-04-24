package com.davis.mall.views;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewTreeObserver;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;

/**
 * @author 王阳
 * @time 2019/11/9  17:28
 * @desc
 */
public class MYNestedScrollView extends NestedScrollView {

    public MYNestedScrollView(@NonNull Context context) {
        super(context);
    }

    public MYNestedScrollView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MYNestedScrollView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, boolean isNeedScroll) {
        super(context, attrs, defStyleAttr);
        this.isNeedScroll = isNeedScroll;
        scaledTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    private boolean isNeedScroll = true;
    private Float xDistance = 0f;
    private Float yDistance = 0f;
    private Float xLast = 0f;
    private Float yLast = 0f;
    private int scaledTouchSlop;

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.e("MYNestedScrollView", "onInterceptTouchEvent");
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN :
                Log.e("MYNestedScrollView", "onInterceptTouchEvent ACTION_DOWN");
                yDistance = 0f;
                xDistance = yDistance;
                xLast = ev.getX();
                yLast = ev.getY();
                break;
            case MotionEvent.ACTION_MOVE :
                Log.e("MYNestedScrollView", "onInterceptTouchEvent ACTION_MOVE");
                float curX = ev.getX();
                float curY = ev.getY();

                xDistance += Math.abs(curX - xLast);
                yDistance += Math.abs(curY - yLast);
                xLast = curX;
                yLast = curY;
                //Log.e("SiberiaDante", "xDistance ：" + xDistance + "---yDistance:" + yDistance);
                Log.e("MYNestedScrollView", xDistance+"onInterceptTouchEvent ACTION_MOVE"+yDistance);
                return !(xDistance >= yDistance || yDistance < scaledTouchSlop) && isNeedScroll;
        }

        return super.onInterceptTouchEvent(ev);
    }


    /*
    该方法用来处理NestedScrollView是否拦截滑动事件  isNeedScroll= true 表示MyNestedScrollView消费该事件，false表示给子View消费
     */
    public void setNeedScroll(Boolean isNeedScroll) {
        this.isNeedScroll = isNeedScroll;
    }
}
