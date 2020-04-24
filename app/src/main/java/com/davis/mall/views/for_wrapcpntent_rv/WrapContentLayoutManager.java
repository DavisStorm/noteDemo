package com.davis.mall.views.for_wrapcpntent_rv;

import android.content.Context;
import android.view.View;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author 王阳
 * @time 2019/12/27  11:43
 * @desc
 */
public class WrapContentLayoutManager extends GridLayoutManager {
    private WrapContentRvAdapter adapter;
    // RecyclerView高度随Item自适应
    public WrapContentLayoutManager(WrapContentRvAdapter adapter, Context context, int spanCount) {
        super(context,spanCount);
        this.adapter = adapter;
    }
    @Override
    public void onMeasure(RecyclerView.Recycler recycler, RecyclerView.State state, final int widthSpec, final int heightSpec) {
        try {
            //不能使用   View view = recycler.getViewForPosition(0);
            //measureChild(view, widthSpec, heightSpec);
            // int measuredHeight  view.getMeasuredHeight();  这个高度不准确

            if(adapter!=null&&adapter.getItemHeight()>0) {
                int measuredWidth = View.MeasureSpec.getSize(widthSpec);
                int measuredHeight = adapter.getItemHeight();//+rvPhotos.getPaddingBottom()+rvPhotos.getPaddingTop()
                int line = adapter.getItemCount() / getSpanCount();
                if (adapter.getItemCount() % getSpanCount() > 0) line++;
                setMeasuredDimension(measuredWidth, measuredHeight * line);
            }else{
                super.onMeasure(recycler,state,widthSpec,heightSpec);
            }

        }catch (Exception e){
            super.onMeasure(recycler,state,widthSpec,heightSpec);
        }
    }
}
