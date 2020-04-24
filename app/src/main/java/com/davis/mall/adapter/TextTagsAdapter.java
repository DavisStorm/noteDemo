package com.davis.mall.adapter;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.davis.mall.views.tagcloud.TagsAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author 王阳
 * @time 2019/11/15  19:50
 * @desc
 */
public class TextTagsAdapter extends TagsAdapter {
    private List<String> mData = new ArrayList<String>();

    public TextTagsAdapter(List<String> data) {
        mData = data;
    }


    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public View getView(Context context, int position, ViewGroup parent) {
        Random rand = new Random();
        final int randNum = rand.nextInt(mData.size() - 1);

        TextView tv = new TextView(context);
        ViewGroup.MarginLayoutParams lp = new ViewGroup.MarginLayoutParams(200, 100);
        tv.setLayoutParams(lp);
        tv.setText(mData.get(randNum));
        tv.setGravity(Gravity.CENTER);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mData.get(randNum).contains("开眼视频")) {
                    //TODO 界面跳转
                }
            }
        });

        return tv;
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public int getPopularity(int position) {
        return position % 7;
    }

    @Override
    public void onThemeColorChanged(View view, int themeColor, float alpha) {
        TextView tv = (TextView) view;
        tv.setTextColor(themeColor);
    }
}
