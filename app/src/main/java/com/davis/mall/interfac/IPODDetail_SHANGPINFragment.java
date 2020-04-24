package com.davis.mall.interfac;

import com.davis.mall.bean.AddressBean;
import com.davis.mall.bean.GouWuCheBean;

/**
 * @author 王阳
 * @time 2019/12/24  9:30
 * @desc
 */
public interface IPODDetail_SHANGPINFragment extends IMVP {
    void requestAddressByUser_id(AddressBean addressBean);

    void addCarSuccessful(GouWuCheBean addressBean);
}
