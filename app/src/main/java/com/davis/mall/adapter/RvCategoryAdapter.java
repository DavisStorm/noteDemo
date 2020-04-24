package com.davis.mall.adapter;

import android.graphics.Typeface;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.davis.mall.R;
import com.davis.mall.bean.CategoryMuluBean;
import com.davis.mall.utils.BaseViewHolder;

import java.util.List;

/**
 * @author 王阳
 * @time 2019/11/13  15:36
 * @desc
 */
public class RvCategoryAdapter extends BaseQuickAdapter<CategoryMuluBean.DataBean.ListBean> {
    private OnTextViewClickLisener lisener =null;
    public static int curPosition =0;
    public RvCategoryAdapter( List<CategoryMuluBean.DataBean.ListBean> data) {
        super(R.layout.category_adapter, data);
    }

    @Override
    protected void convert(final BaseViewHolder helper, CategoryMuluBean.DataBean.ListBean item) {
        helper.setText(R.id.tv,item.getFirst_class_name());
        helper.setOnClickListener(R.id.tv, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lisener!=null) {
                    int selectedPosition = helper.getPosition();
                    //改变item选中状态
                    lisener.changItemSelectedBg(selectedPosition,curPosition);
                    curPosition =selectedPosition;
                    //点击事件修改数据
                    lisener.onClick(selectedPosition);
                }
            }
        });

    }

    public void setOnItemClick(OnTextViewClickLisener mlisener) {
        lisener = mlisener;
    }
    public abstract static class OnTextViewClickLisener  {
        public abstract void onClick(int position);
        public abstract void changItemSelectedBg(int curPosition,int selectedPosition);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        Log.e("RvCategoryAdapter", "onAttachedToRecyclerView:");
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        Log.e("RvCategoryAdapter", "getItemCount:");
        return super.getItemCount();
    }

    @Override
    public int getItemViewType(int position) {
        Log.e("RvCategoryAdapter", "getItemViewType:+position:"+position);
        return super.getItemViewType(position);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.e("RvCategoryAdapter", "onCreateViewHolder");
        return super.onCreateViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int positions) {
        Log.e("RvCategoryAdapter", "onBindViewHolder");
        super.onBindViewHolder(holder, positions);
    }

    @Override
    public void onViewAttachedToWindow(RecyclerView.ViewHolder holder) {//在itemview可见时执行，同时也是解决控件复用的方法
        int adapterPosition = holder.getAdapterPosition();
        TextView itemView = (TextView) holder.itemView;
        if(curPosition == adapterPosition) {
            itemView.setBackgroundColor(mContext.getResources().getColor(R.color.WHITE));
            itemView.setTextSize(18);
            itemView.setTypeface(Typeface.DEFAULT, Typeface.BOLD);

        }else {
            itemView.setBackgroundColor(mContext.getResources().getColor(R.color.pageBackground));
            itemView.setTextSize(14);
            itemView.setTypeface(Typeface.DEFAULT, Typeface.NORMAL);
        }
        Log.e("RvCategoryAdapter", "onViewAttachedToWindow position:"+holder.getAdapterPosition());
        super.onViewAttachedToWindow(holder);
    }

    @Override
    public void onViewRecycled(@NonNull RecyclerView.ViewHolder holder) {
        Log.e("RvCategoryAdapter", "onViewRecycled position:"+holder.getAdapterPosition());
        super.onViewRecycled(holder);
    }

    @Override
    public void onViewDetachedFromWindow(@NonNull RecyclerView.ViewHolder holder) {
        Log.e("RvCategoryAdapter", "onViewRecycled position:"+holder.getAdapterPosition());
        super.onViewDetachedFromWindow(holder);
    }
}
