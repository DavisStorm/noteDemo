package com.davis.mall.adapter;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.davis.mall.R;
import com.davis.mall.bean.AllFavorBean;
import com.davis.mall.ui.PODDetailActivity;
import com.davis.mall.utils.BaseViewHolder;

import java.util.List;

/**
 * @author 王阳
 * @time 2019/11/11  2:27
 * @desc
 */
public class AllFavorAdapter extends BaseQuickAdapter<AllFavorBean.DataBean.ListBean>{


    public AllFavorAdapter(List<AllFavorBean.DataBean.ListBean> data) {
        super(R.layout.af_adapter,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, final AllFavorBean.DataBean.ListBean bean) {

//        CircleImageView iviCon =helper.getView(R.id.img);
//        Glide.with(mContext).load(bean.getFavor_icon()).error(R.drawable.loading)
//                .placeholder(R.drawable.loading).into(iviCon);

        helper.setText(R.id.tv_name,bean.getFavor_name());
        helper.setText(R.id.tv_likes,"喜欢了"+bean.getFavor_name_num()+"件商品");
        helper.setText(R.id.tv_time,bean.getAdd_time());

        ImageView parsed_img =helper.getView(R.id.parsed_img);
        RequestOptions options =new RequestOptions()
                .placeholder(R.drawable.loading)//加载成功之前占位图
                .error(R.drawable.loading)//加载错误之后的错误图
                .override(300,300)//指定图片的尺寸
                //指定图片的缩放类型为fitCenter （等比例缩放图片，宽或者是高等于ImageView的宽或者是高。）
                .fitCenter()
                //指定图片的缩放类型为centerCrop （等比例缩放图片，直到图片的狂高都大于等于ImageView的宽度，然后截取中间的显示。）
//                .centerCrop()
//                .circleCrop()//指定图片的缩放类型为centerCrop （圆形）
//                .skipMemoryCache(true)//跳过内存缓存
//                .diskCacheStrategy(DiskCacheStrategy.ALL)//缓存所有版本的图像
                .diskCacheStrategy(DiskCacheStrategy.NONE)//跳过磁盘缓存
//                .diskCacheStrategy(DiskCacheStrategy.DATA)//只缓存原来分辨率的图片
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE);//只缓存最终的图片 ;
        Glide.with(mContext).load(bean.getFavor_img()).apply(options).into(parsed_img);

        helper.setText(R.id.favor_num,bean.getFavorNum()+"");
        parsed_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra(PODDetailActivity.CATE_ID_FOR_RESULT,bean.getCate_id());
                intent.setClass(mContext, PODDetailActivity.class);
                mContext.startActivity(intent);
            }
        });

    }

    public void setData(List<AllFavorBean.DataBean.ListBean> list) {
        mData = list;
        notifyDataSetChanged();
    }
    public void setDataWithPartDataChange(List<AllFavorBean.DataBean.ListBean> data, int positionStart, int itemCount){
        if(mData!=null && mData.size()>0) {
            mData.clear();
        }
        mData = data;
        notifyItemRangeChanged(positionStart,itemCount);
    }
}
