package com.davis.mall.adapter;

import android.content.Context;
import android.widget.ImageView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.davis.mall.R;
import com.davis.mall.bean.PODDetaliBean;
import com.davis.mall.utils.BaseViewHolder;
import com.davis.mall.utils.StringUtil;

import java.util.List;

/**
 * @author 王阳
 * @time 2019/12/30  10:05
 * @desc
 */
public class PodListRvAdapter extends BaseQuickAdapter<PODDetaliBean.DataBean.ListBean> {
    private Context mContext;
    public PodListRvAdapter(Context context,List<PODDetaliBean.DataBean.ListBean> data) {
        super(R.layout.adapter_pod_list,data);
        mContext = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, PODDetaliBean.DataBean.ListBean item) {
        String bannerImages = item.getBannerImages();
        String[] strings = StringUtil.splitStringByJInghao(bannerImages);
        ImageView img = helper.getView(R.id.img_pic);
        RequestOptions options =new RequestOptions()
                .override(300,300);//指定图片的尺寸
        Glide.with(mContext).load(strings[1]).apply(options).into(img);
        helper.setText(R.id.tv_pod_name,item.getNamepod());
        helper.setText(R.id.tv_price_main,item.getPrice()+"");
        helper.setText(R.id.tv_sold_num,item.getSold_num()+"");
        helper.setText(R.id.tv_sold_num,item.getSold_num()+"件卖出");
        helper.setText(R.id.tv_pj_rate,"100%好评");
        helper.setText(R.id.tv_dianpu_name,item.getStore_name());
        CardView cView = helper.getView(R.id.cv_container);
        GridLayoutManager.LayoutParams lp = (GridLayoutManager.LayoutParams) cView.getLayoutParams();
        if(helper.getAdapterPosition()%2==0) {
            lp.rightMargin = 10;
        }else {
            lp.leftMargin = 10;
        }
        cView.setLayoutParams(lp);
    }

    public void setData(List<PODDetaliBean.DataBean.ListBean> data){
        if(mData!=null && mData.size()>0) {
            mData.clear();
        }
        mData = data;
        notifyDataSetChanged();
    }


    public void setDataWithPartDataChange(List<PODDetaliBean.DataBean.ListBean> data,int positionStart,int itemCount){
        if(mData!=null && mData.size()>0) {
            mData.clear();
        }
        mData = data;
        notifyItemRangeChanged(positionStart,itemCount);
    }
}
