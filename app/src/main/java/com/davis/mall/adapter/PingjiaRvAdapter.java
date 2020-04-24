package com.davis.mall.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.davis.mall.R;
import com.davis.mall.bean.PingJiaBean;
import com.davis.mall.utils.BaseViewHolder;

import java.util.List;

/**
 * @author 王阳
 * @time 2019/12/25  15:04
 * @desc
 */
public class PingjiaRvAdapter extends BaseQuickAdapter<PingJiaBean.DataBean.ListBean> {
    Context context;
    public PingjiaRvAdapter(Context context,List<PingJiaBean.DataBean.ListBean> data) {
        super(R.layout.adapter_pingjia,data);
        this.context= context;
    }

    @Override
    protected void convert(BaseViewHolder helper, PingJiaBean.DataBean.ListBean item) {
        helper.setText(R.id.tv_pj_name,item.getPj_name());
//        helper.setProgress(R.id.tv_pj_name,item.getPj_score());
        ImageView imageView = helper.getView(R.id.img_pj_icon);
        RequestOptions options =new RequestOptions()
                .placeholder(R.drawable.loading)//加载成功之前占位图
                .error(R.drawable.loading)//加载错误之后的错误图
                .override(300,300)//指定图片的尺寸
                .fitCenter()
                .diskCacheStrategy(DiskCacheStrategy.NONE)//跳过磁盘缓存
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE);//只缓存最终的图片 ;
        Glide.with(context).load(item.getPj_icon()).apply(options).into(imageView);
        helper.setText(R.id.tv_pj_content,item.getPj_msg());
        //颜色：上青 972 型号：180
        String kuanxin = "颜色："+item.getPj_kuanxin()+item.getPj_color()+"　尺码："+item.getPj_chima();
        helper.setText(R.id.tv_pj_kuanshi,kuanxin);

    }
}
