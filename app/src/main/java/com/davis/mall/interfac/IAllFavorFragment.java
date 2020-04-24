package com.davis.mall.interfac;

import com.davis.mall.bean.AllFavorBean;

/**
 * @author 王阳
 * @time 2019/11/11  3:08
 * @desc
 */
public interface IAllFavorFragment extends IMVP{
    void requestSuccess(AllFavorBean bean);
    void requestFailed();

}
