package com.davis.mall.adapter;

import android.view.View;

import com.davis.mall.R;
import com.davis.mall.utils.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

public class BaseRecycleViewAdapter extends BaseQuickAdapter<String> {

    private final OnClickLisener mLisener;

    public BaseRecycleViewAdapter(List<String> data, OnClickLisener lisener) {
        super(R.layout.tv_simple,data==null?new ArrayList<>():data);
        mLisener = lisener;
    }

    @Override
    protected void convert(BaseViewHolder helper, String text) {
        helper.setText(R.id.tv_simple,text);
        helper.getView(R.id.tv_simple).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLisener.OnClick(helper.getLayoutPosition());
            }
        });
    }
    public interface OnClickLisener{
         void OnClick(int layoutPosition);
    }
}
