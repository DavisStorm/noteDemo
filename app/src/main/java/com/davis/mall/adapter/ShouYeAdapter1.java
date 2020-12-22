package com.davis.mall.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.davis.mall.R;
import com.davis.mall.bean.ShouYeCategoryBean;

import java.util.List;

/**
 * @author 王阳
 * @time 2019/11/9  3:08
 * @desc
 */
public class ShouYeAdapter1 extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<ShouYeCategoryBean.DataList> beanlist;
    private Context context;
    private onItemClickLisener lisener;

    public ShouYeAdapter1(Context context, List<ShouYeCategoryBean.DataList> beanlist) {
        this.beanlist = beanlist;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.fragment_souye_rev1, viewGroup, false);
        return new Recv1ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int position) {
        Recv1ViewHolder holder = (Recv1ViewHolder) viewHolder;
        ShouYeCategoryBean.DataList databean = beanlist.get(position);
        RequestOptions options =new RequestOptions()
                .override(150,150)//指定图片的尺寸
                .fitCenter()
                .diskCacheStrategy(DiskCacheStrategy.NONE);//跳过磁盘缓存
        Glide.with(context).load(databean.getLogo()).apply(options).into(holder.mImg);
        holder.mTv.setText(databean.getName());
        holder.mRl_content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //界面跳转
                lisener.onItemClick(beanlist.get(position).getName());
            }
        });

    }

    @Override
    public int getItemCount() {
        return beanlist==null?0:beanlist.size();
    }

    public void setData(List<ShouYeCategoryBean.DataList> dataList) {
        if (dataList ==null || dataList.size() ==0) return;
        beanlist = dataList;
        notifyDataSetChanged();
    }

    class Recv1ViewHolder extends RecyclerView.ViewHolder{

        private TextView mTv;
        private ImageView mImg;
        private RelativeLayout mRl_content;

        public Recv1ViewHolder(View view) {
            super(view);
            mTv = view.findViewById(R.id.tv);
            mImg = view.findViewById(R.id.img);
            mRl_content = view.findViewById(R.id.rl_content);
        }
    }
    public void setOnItemClickLisener(onItemClickLisener clickLisener){
        lisener = clickLisener;
    }
    public interface onItemClickLisener{
        void onItemClick(String keyword);
    }
}
