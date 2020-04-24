package com.davis.mall.adapter;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;

import com.davis.mall.R;
import com.davis.mall.bean.PingpaiBean;
import com.davis.mall.interfac.IPodListActivity;
import com.davis.mall.utils.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 王阳
 * @time 2020/1/3  12:52
 * @desc
 */
public class PingpaiRvAdapter extends BaseQuickAdapter<PingpaiBean.DataBean.TreeBean> {

    public ArrayList<String> currentSelected=new ArrayList<>();

    public ArrayList<String> currentSelectedId=new ArrayList<>();

    public PingpaiRvAdapter(IPodListActivity podListActivity, List<PingpaiBean.DataBean.TreeBean> dataList) {
        super(R.layout.adapter_fuwuzekou,dataList);
    }

    @Override
    protected void convert(BaseViewHolder helper, final PingpaiBean.DataBean.TreeBean item) {
        helper.setText(R.id.tv_fuwuzekou,item.getPingpai_name());
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
                    currentSelectedId.add(item.getPingpai_id());
                }else {
                    tView.setTextColor(mContext.getResources().getColor(R.color.BLACK));
                    tView.setBackground(drawableGrey);
                    tView.setTag("0");
                    currentSelected.remove(tView.getText().toString());
                    currentSelectedId.remove(item.getPingpai_id());
                }
            }
        });

    }
    public ArrayList<String> getCurrentSelected() {
        return currentSelected;
    }

    public ArrayList<String> getCurrentSelectedId() {
        return currentSelectedId;
    }

    public void onReset() {
        if(currentSelected.size()>0) {
            currentSelected.clear();
        }
        if(currentSelectedId.size()>0) {
            currentSelectedId.clear();
        }
        notifyDataSetChanged();
    }
}
