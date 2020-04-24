package com.davis.mall.views;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

/**
 * @author 王阳
 * @time 2020/1/16  14:36
 * @desc
 */
public class MytextView extends AppCompatTextView {
    public MytextView (Context context) {
        super(context);
    }

    public MytextView (Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e("Touch ", "MytextView dispatchTouchEvent");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("Touch ", "MytextView onTouchEvent");
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.e("Touch ", "MytextView onTouchEvent ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e("Touch ", "MytextView onTouchEvent ACTION_MOVE");
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.e("Touch ", "MytextView onTouchEvent ACTION_CANCEL");
                break;
            case MotionEvent.ACTION_UP:
                Log.e("Touch ", "MytextView onTouchEvent ACTION_UP");
                break;
            default:
                Log.e("Touch ", "MytextView onTouchEvent " + event.getAction());
                break;
        }
        return super.onTouchEvent(event);
    }
}
