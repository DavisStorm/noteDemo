package com.davis.mall.adapter;

import com.davis.mall.R;
import com.davis.mall.utils.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 王阳
 * @time 2019/12/18  23:25
 * @desc
 */
public class KeywordsAdapter extends BaseQuickAdapter<String> {

    public KeywordsAdapter(List<String> data) {
        super(R.layout.adapter_keywords,data==null?new ArrayList<>():data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String keywords) {
        helper.setText(R.id.tv_keywords,keywords);
    }

}
