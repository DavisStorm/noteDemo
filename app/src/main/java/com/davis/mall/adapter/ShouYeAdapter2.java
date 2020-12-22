package com.davis.mall.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.davis.mall.R;
import com.davis.mall.bean.ShouYeTuijianBean;
import com.davis.mall.views.MarqueTextView;
import com.davis.mall.views.MyRecycleView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 王阳
 * @time 2019/11/9  3:08
 * @desc
 */
public class ShouYeAdapter2 extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private int windowWidth;
    private List<ShouYeTuijianBean.DataBean.TreeBean> beanlist = new ArrayList<>();
    private Context context;

    public ShouYeAdapter2(Context context, List<ShouYeTuijianBean.DataBean.TreeBean> beanlist, int width) {
        this.beanlist = beanlist;
        this.context = context;
        this.windowWidth = width;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Log.e("ShouYeAdapter2", "onCreateViewHolder: "+i);
        View view = LayoutInflater.from(context).inflate(R.layout.fragment_souye_rev2, viewGroup, false);
        return new Recv2ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        Log.e("ShouYeAdapter2", "onBindViewHolder: "+position);
        Recv2ViewHolder holder = (Recv2ViewHolder) viewHolder;
        //设置imageview与屏幕同宽
        ViewGroup.LayoutParams params = holder.mImg.getLayoutParams();
        params.width = windowWidth;
        holder.mImg.setLayoutParams(params);

        ShouYeTuijianBean.DataBean.TreeBean treeBean = beanlist.get(position);

        RequestOptions options =new RequestOptions()
                .dontAnimate()
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.NONE)//跳过磁盘缓存
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE);//只缓存最终的图片
        Glide.with(context).load(treeBean.getImage()).apply(options).into(holder.mImg);
        holder.tv_sroltv.setText(treeBean.getDescription());
        //初始化内部recycleview的适配器并加载数据
        initAdapterAndData(holder.mRv,treeBean.getChildren_tree(),position);

    }

    private void initAdapterAndData(RecyclerView mRv, List<ShouYeTuijianBean.DataBean.TreeBean.ChildrenTreeBean> items, int position) {
        InnerAdapter innerAdapter = new InnerAdapter(context, items,position);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRv.setLayoutManager(layoutManager);
        mRv.setAdapter(innerAdapter);
    }


    @Override
    public int getItemCount() {
        Log.e("ShouYeAdapter2", "getItemCount: ");
        return beanlist==null?0:beanlist.size();
    }

    @Override
    public int getItemViewType(int position) {
        Log.e("ShouYeAdapter2", "getItemViewType: ");
        return super.getItemViewType(position);
    }

    @Override
    public void onViewAttachedToWindow(@NonNull RecyclerView.ViewHolder holder) {
        Log.e("ShouYeAdapter2", "onViewAttachedToWindow: ");
        super.onViewAttachedToWindow(holder);
    }

    public void setData(List<ShouYeTuijianBean.DataBean.TreeBean> dataList) {
        if (dataList ==null ||dataList.size()==0) return;
        beanlist = dataList;
        notifyDataSetChanged();
    }

    class Recv2ViewHolder extends RecyclerView.ViewHolder{

        private ImageView mImg;
        private MyRecycleView mRv;
        private MarqueTextView tv_sroltv;

        public Recv2ViewHolder(View view) {
            super(view);
            mImg = view.findViewById(R.id.img);
            mRv = view.findViewById(R.id.rv);
            tv_sroltv = view.findViewById(R.id.tv_sroltv);
        }
    }
}
