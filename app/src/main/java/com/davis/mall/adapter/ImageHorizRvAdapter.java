package com.davis.mall.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.davis.mall.R;
import com.davis.mall.utils.BaseViewHolder;

import java.util.List;

/**
 * @author 王阳
 * @time 2019/12/19  19:35
 * @desc
 */
public class ImageHorizRvAdapter extends BaseQuickAdapter<String> {

    private Context mContext;
    private ImageHorizRvAdapter.onItemClickListener mLisener;

    private int selectedPosition = 0;
    public ImageHorizRvAdapter(Context context, List<String> data, ImageHorizRvAdapter.onItemClickListener lisener) {
        super(R.layout.adapter_img_horizen,data);
        mContext = context;
        mLisener = lisener;
    }

    @Override
    protected void convert(final BaseViewHolder helper, String item) {
        ImageView imgv = helper.getView(R.id.img);
        RequestOptions options =new RequestOptions()
                .placeholder(R.drawable.loading)//加载成功之前占位图
                .error(R.drawable.loading)//加载错误之后的错误图
                .override(300,300)//指定图片的尺寸
                .fitCenter()
                .diskCacheStrategy(DiskCacheStrategy.NONE)//跳过磁盘缓存
                //                .diskCacheStrategy(DiskCacheStrategy.DATA)//只缓存原来分辨率的图片
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE);//只缓存最终的图片 ;
        Glide.with(mContext).load(item).apply(options).into(imgv);

        if(selectedPosition == helper.getAdapterPosition()) {
            imgv.setBackground(mContext.getResources().getDrawable(R.drawable.chosen_rec_outside));
        }else {
            imgv.setBackground(null);
        }
        imgv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedPosition = helper.getAdapterPosition();
                mLisener.onItemClicked(selectedPosition,helper.getAdapterPosition());//ViewPager的响应
                notifyDataSetChanged();//必须放后面,不然helper.getAdapterPosition()会是-1
            }
        });
    }
    public interface onItemClickListener{
        void onItemClicked(int selectedPosition,int selectingPosition);
    }

    public void setSelectedPosition(int selectedPosition) {
        this.selectedPosition = selectedPosition;
        notifyDataSetChanged();
    }
}
