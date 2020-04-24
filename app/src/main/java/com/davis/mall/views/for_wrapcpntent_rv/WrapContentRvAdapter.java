package com.davis.mall.views.for_wrapcpntent_rv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.davis.mall.R;
import com.davis.mall.bean.CategoryBean;

import java.util.List;

/**
 * @author 王阳
 * @time 2019/12/27  11:56
 * @desc
 */
public class WrapContentRvAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private int itemHeight;

    private List<CategoryBean.DataBean.TreeBean.ChildrenTreeBean> children_tree;
    private Context mContext;
    public WrapContentRvAdapter(Context context,List<CategoryBean.DataBean.TreeBean.ChildrenTreeBean> children_tree) {
        this.children_tree= children_tree;
        this.mContext= context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.inneradapter_category, viewGroup, false);
        return new InnerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        InnerViewHolder holder = (InnerViewHolder) viewHolder;
        holder.tv_inner_name.setText(children_tree.get(position).getThird_class_name());
        Glide.with(mContext).load(children_tree.get(position).getImg_url()).into(holder.inner_adapter_img);
    }

    @Override
    public int getItemCount() {
        return children_tree == null ? 0 : children_tree.size();
    }

    class InnerViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_inner_name;
        private ImageView inner_adapter_img;
        private RelativeLayout inner_rl_container;

        public InnerViewHolder(@NonNull final View itemView) {
            super(itemView);
            tv_inner_name = itemView.findViewById(R.id.tv_inner_name);
            inner_adapter_img = itemView.findViewById(R.id.inner_adapter_img);
            inner_rl_container = itemView.findViewById(R.id.inner_rl_container);
            itemView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                @Override
                public boolean onPreDraw() {
                    itemHeight=itemView.getMeasuredHeight();
                    return true;
                }
            });
        }
    }
    public int getItemHeight(){ return itemHeight;}
}
