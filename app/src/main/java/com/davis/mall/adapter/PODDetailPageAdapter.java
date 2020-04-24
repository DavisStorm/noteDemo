package com.davis.mall.adapter;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.davis.mall.R;

import java.util.List;

/**
 * @author 王阳
 * @time 2019/12/19  7:15
 * @desc
 */

public class PODDetailPageAdapter extends PagerAdapter {
    private List<String> mImgList;
    private Context mContext;

    public PODDetailPageAdapter(Context context ,List<String> imgList) {
        mImgList = imgList;
        mContext = context;
    }

    @Override
    public int getCount() {
        return mImgList == null ? 0 : mImgList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        return view == obj;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        RelativeLayout rl_out = (RelativeLayout) LayoutInflater.from(mContext).inflate
                (R.layout.banner_img2_viewpager, container, false);
        ImageView imgView = (ImageView) rl_out.getChildAt(0);
        RequestOptions options =new RequestOptions().override(500,490);//指定图片的尺寸
        Glide.with(container.getContext()).load(mImgList.get(position)).apply(options).into(imgView);
        container.addView(rl_out);
        return rl_out;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    public void setData(List<String> stringsResult) {
        if(mImgList!=null) {
            mImgList.clear();
        }
        mImgList = stringsResult;
        notifyDataSetChanged();
    }
}

