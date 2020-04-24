package com.davis.mall.interfac;

import com.davis.mall.bean.ShouYeCategoryBean;
import com.davis.mall.bean.ShouYeTuijianBean;

/**
 * @author 王阳
 * @time 2019/11/9  0:26
 * @desc
 */
public interface IShouyeFragment extends IMVP {
    void requestRev1Success(ShouYeCategoryBean bean);
    void requestRev1Failed();

    void requestRev2Success(ShouYeTuijianBean bean);
    void requestRev2Failed();

}
