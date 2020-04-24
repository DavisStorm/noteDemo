package com.davis.mall.views;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author 王阳
 * @time 2019/11/9  18:55
 * @desc 替代adapter2的recycleview进行调试，如果快速水平滑动MyRecycleview内嵌的recycleview，会导致界面迅
速滚动到第一个MyRecycleview内嵌的recycleview顶部，调试结果并没有触发ontouchevent方法，
而且只有内嵌的recycleview第一次被快速滑动时才会出现上述问题，分析得出可能是内嵌的recycleview
第一次绘制界面时控件复用引起的，慢速滑动不会引起问题，好，一通乱分析，终于知道原因有两点快速滑动
时的itemview复用并绘制，但是要知道每个内嵌的recycleview是完全独立的，相互并不复用，不可能直接影响第一个
内嵌的recycleview，经查资料通过将内嵌的recycleview.setFocusableInTouchMode(false)解决问题，所以分析
是外部recyclview复用内部recycleview中item创建视图时获取焦点，导致第一个外部recyclview的内部recycleview
的itemview获取到了焦点，所以每次下面的内部recycleview创建item时都会复用焦点，但是不对，但是不对，只有快速滑动
内部recycleview时才会出现，所以当慢速滑动内部recycleview时，复用的是当前内部recycleview前面itemview的视图，
当快速滑动内部recycleview时，复用的是前面外部recycleview中内部recycleview的itemview的视图，所以在已经
将内嵌的recycleview.setFocusableInTouchMode(false)的情况下，如果内部recycleview的
如果还有EditText这种控件的话，那么快速滑动会复用前面外部recycleview中内部recycleview的EditText，并使其
获得焦点，话不多说，测试，经测试完全正确，焦点正处在第一个外部recycleview的内部recycleview的第一个item的EditText中
 */
public class MyRecycleView extends RecyclerView {
    public MyRecycleView(@NonNull Context context) {
        super(context);
    }

    public MyRecycleView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyRecycleView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.e("MyRecycleView", "MyViewGroup onInterceptTouchEvent");
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e("MyRecycleView", "MyViewGroup dispatchTouchEvent");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("MyRecycleView", "MyViewGroup onTouchEvent");
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.e("MyRecycleView", "MyViewGroup onTouchEvent ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e("MyRecycleView", "MyViewGroup onTouchEvent ACTION_MOVE");
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.e("MyRecycleView", "MyViewGroup onTouchEvent ACTION_CANCEL");
                break;
            case MotionEvent.ACTION_UP:
                Log.e("MyRecycleView", "MyViewGroup onTouchEvent ACTION_UP");
                break;
            default:
                Log.e("MyRecycleView", "MyViewGroup onTouchEvent " + event.getAction());
                break;
        }
        return super.onTouchEvent(event);
    }

    @Override
    public void scrollToPosition(int position) {
        Log.e("MyRecycleView", "scrollToPosition TAG:" +getTag()+ "position:"+position);
        super.scrollToPosition(position);
    }
}
