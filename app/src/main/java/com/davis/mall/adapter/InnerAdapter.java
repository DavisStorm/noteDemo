package com.davis.mall.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.davis.mall.R;
import com.davis.mall.bean.ShouYeTuijianBean;
import com.davis.mall.ui.PODDetailActivity;

import java.util.List;

/**
 * @author 王阳
 * @time 2019/11/9  16:48
 * @desc
 */
public class InnerAdapter  extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<ShouYeTuijianBean.DataBean.TreeBean.ChildrenTreeBean> beanlist;
    private Context context;
    private int TAG;

    public InnerAdapter(Context context, List<ShouYeTuijianBean.DataBean.TreeBean.ChildrenTreeBean> beanlist, int position) {
        this.beanlist = beanlist;
        this.context = context;
        this.TAG = position;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.fragment_souye_innerview, viewGroup, false);
        return new InnerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        Log.e("InnerAdapter", "onBindViewHolder: "+viewHolder.getClass()+" TAG:"+TAG+" position:"+ position);
        InnerViewHolder innerViewHolder = (InnerViewHolder) viewHolder;
        final ShouYeTuijianBean.DataBean.TreeBean.ChildrenTreeBean itemsBean = beanlist.get(position);
        RequestOptions options =new RequestOptions()
                .override(300,300);//指定图片的尺寸
        Glide.with(context).load(itemsBean.getImage()).apply(options).into(innerViewHolder.mImg);
        innerViewHolder.mTv1.setText(itemsBean.getBrandName());
        innerViewHolder.mTv2.setText(itemsBean.getKeyword());
        innerViewHolder.mTv3.setText("¥"+itemsBean.getPrice());
        innerViewHolder.rlContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra(PODDetailActivity.CATE_ID_FOR_RESULT,itemsBean.getCate_id());
                intent.setClass(context, PODDetailActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return beanlist==null?0:beanlist.size();
    }
    class InnerViewHolder extends RecyclerView.ViewHolder{

        private final ImageView mImg;
        private final TextView mTv1;
        private final TextView mTv2;
        private final TextView mTv3;
        private final RelativeLayout rlContainer;

        public InnerViewHolder(@NonNull View itemView) {
            super(itemView);
            mImg = itemView.findViewById(R.id.inner_img);
            mTv1 = itemView.findViewById(R.id.inner_tv1);
            mTv2 = itemView.findViewById(R.id.inner_tv2);
            mTv3 = itemView.findViewById(R.id.inner_tv3);
            rlContainer = itemView.findViewById(R.id.rl_container);
        }
    }
}
