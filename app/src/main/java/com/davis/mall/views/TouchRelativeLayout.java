package com.davis.mall.views;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

/**
 * @author 王阳
 * @time 2020/1/16  14:07
 * @desc
 */
public class TouchRelativeLayout extends RelativeLayout {
    public TouchRelativeLayout(Context context) {
        super(context);
    }

    public TouchRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e("Touch ", "TouchRelativeLayout dispatchTouchEvent");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.e("Touch ", "TouchRelativeLayout onInterceptTouchEvent");
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("Touch ", "TouchRelativeLayout onTouchEvent");
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.e("Touch ", "TouchRelativeLayout onTouchEvent ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e("Touch "  , "TouchRelativeLayout onTouchEvent ACTION_MOVE");
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.e("Touch ", "TouchRelativeLayout onTouchEvent ACTION_CANCEL");
                break;
            case MotionEvent.ACTION_UP:
                Log.e("Touch ", "TouchRelativeLayout onTouchEvent ACTION_UP");
                break;
            default:
                Log.e("Touch ", "TouchRelativeLayout onTouchEvent " + event.getAction());
                break;
        }
        return super.onTouchEvent(event);
    }
    
    
}
