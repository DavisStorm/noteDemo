package com.davis.mall.presenter;

import com.davis.mall.interfac.IMVP;

/**
 * @author 王阳
 * @time 2019/11/8  23:11
 * @desc
 */
public class BaseFragmentPresenter {
    public IMVP imvp;
    public BaseFragmentPresenter(IMVP imvp) {
//        imvp = imvp;
    }

    public IMVP getView(){
        return imvp;
    }
}
