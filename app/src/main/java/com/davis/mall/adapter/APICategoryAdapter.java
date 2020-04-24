package com.davis.mall.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.davis.mall.R;
import com.davis.mall.ui.note.ActivityRelativeActivity;
import com.davis.mall.ui.note.AndroidNewFeaturesTestActivity;
import com.davis.mall.ui.note.AnimationListActivity;
import com.davis.mall.ui.note.ComponentDetailActivity;
import com.davis.mall.ui.note.DIYListViewActivity;
import com.davis.mall.ui.note.DIYViewActivity;
import com.davis.mall.ui.note.FragmentRelativeActivity;
import com.davis.mall.ui.note.JinRiTouTiaoPingMuShiPei;
import com.davis.mall.ui.note.RecyclerViewActivity;
import com.davis.mall.ui.note.ToolBarUses;
import com.davis.mall.ui.note.WidgetTestActivity;

import java.util.List;

/**
 * Created by CZY on 2018/10/18.
 */

public class APICategoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<String> mData;
    private Context mContext;
    public APICategoryAdapter(Context context, List<String> strings) {
        mData=strings;
        mContext=context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.adapter_apicategory, null);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        MyHolder myHolder = (MyHolder) holder;
        myHolder.tvCategory.setText(mData.get(position));
        myHolder.tvCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mData==null?0:mData.size();
    }

    public void startActivity(int position) {
        Intent intent = new Intent();
        switch (position){
            case 0:
                intent.setClass(mContext, ComponentDetailActivity.class);
                break;
            case 1:
                intent.setClass(mContext, ActivityRelativeActivity.class);
                break;
            case 2:
                intent.setClass(mContext, FragmentRelativeActivity.class);
//                intent.setClass(mContext,);
                break;
            case 3:
//                intent.setClass(mContext,);
                break;
            case 4:
//                intent.setClass(mContext,);
                break;
            case 5:
//                intent.setClass(mContext,);
                break;
            case 6:
//                intent.setClass(mContext,);
                break;
            case 11:
                intent.setClass(mContext, AnimationListActivity.class);
                break;
            case 17:
                intent.setClass(mContext, WidgetTestActivity.class);
                break;
            case 18:
                intent.setClass(mContext, AndroidNewFeaturesTestActivity.class);
                break;
            case 19:
                intent.setClass(mContext, JinRiTouTiaoPingMuShiPei.class);
                break;
            case 20:
                intent.setClass(mContext, ToolBarUses.class);
                break;
            case 21:

                break;
            case 22:
                intent.setClass(mContext, DIYListViewActivity.class);
                break;
            case 23:
                intent.setClass(mContext, RecyclerViewActivity.class);
                break;
        }
        mContext.startActivity(intent);
    }

    class MyHolder extends RecyclerView.ViewHolder{
        TextView tvCategory;
        public MyHolder(View itemView) {
            super(itemView);
            tvCategory = (TextView)itemView.findViewById(R.id.tv_category);
        }
    }
}
