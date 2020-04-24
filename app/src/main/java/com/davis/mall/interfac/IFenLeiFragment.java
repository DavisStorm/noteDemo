package com.davis.mall.interfac;

import com.davis.mall.bean.CategoryBannerBean;
import com.davis.mall.bean.CategoryBean;
import com.davis.mall.bean.CategoryMuluBean;

/**
 * @author 王阳
 * @time 2019/11/13  21:10
 * @desc
 */
public interface IFenLeiFragment extends IMVP {
    void requestSuccess1(CategoryMuluBean categoryBean);

    void requestSuccess2(CategoryBannerBean categoryBannerBean);

    void requestSuccess3(CategoryBean categoryBean);
}
