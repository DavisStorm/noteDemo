package com.davis.mall.interfac;

import com.davis.mall.bean.PODDetaliBean;

/**
 * @author 王阳
 * @time 2019/12/19  6:08
 * @desc
 */
public interface IPODDetailActivity extends IMVP {

    void onYixuanDialogColorChange(int position);//监听商品颜色和尺寸选择对话框值得改变

    void requestPODDetaliSuccess(PODDetaliBean pODDetaliBean);
    void jumpToPingjia();
}
