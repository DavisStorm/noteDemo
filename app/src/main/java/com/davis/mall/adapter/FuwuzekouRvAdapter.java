package com.davis.mall.adapter;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;

import com.davis.mall.R;
import com.davis.mall.bean.FUWUZEKOUbEAN;
import com.davis.mall.interfac.IPodListActivity;
import com.davis.mall.utils.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 王阳
 * @time 2020/1/3  12:52
 * @desc
 */
public class FuwuzekouRvAdapter extends BaseQuickAdapter<FUWUZEKOUbEAN.DataBean.ListBean> {

    public ArrayList<String> currentSelected=new ArrayList<>();

    public FuwuzekouRvAdapter(IPodListActivity podListActivity, List<FUWUZEKOUbEAN.DataBean.ListBean> dataList) {
        super(R.layout.adapter_fuwuzekou,dataList==null?new ArrayList<>():dataList);
    }

    @Override
    protected void convert(BaseViewHolder helper, FUWUZEKOUbEAN.DataBean.ListBean item) {
        helper.setText(R.id.tv_fuwuzekou,item.getFuwuzekou_name());
        TextView tv = helper.getView(R.id.tv_fuwuzekou);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tView = (TextView) v;
                String tag = (String) tView.getTag();
                Drawable drawableGrey = mContext.getResources().getDrawable(R.drawable.bg_tv_round_grey);
                Drawable drawableRed = mContext.getResources().getDrawable(R.drawable.bg_tv_round_grey_red_outline);
                if("0".equals(tag)) {
                    tView.setTextColor(mContext.getResources().getColor(R.color.RED));
                    tView.setBackground(drawableRed);
                    tView.setTag("1");
                    currentSelected.add(tView.getText().toString());
                }else {
                    tView.setTextColor(mContext.getResources().getColor(R.color.BLACK));
                    tView.setBackground(drawableGrey);
                    tView.setTag("0");
                    currentSelected.remove(tView.getText().toString());
                }
            }
        });

    }

    public ArrayList<String> getCurrentSelected() {
        return currentSelected;
    }

    public void onReset() {
        notifyDataSetChanged();
    }
}
