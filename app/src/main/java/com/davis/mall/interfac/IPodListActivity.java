package com.davis.mall.interfac;

import com.davis.mall.bean.FUWUZEKOUbEAN;
import com.davis.mall.bean.PODDetaliBean;
import com.davis.mall.bean.PingpaiBean;

/**
 * @author 王阳
 * @time 2019/12/30  9:18
 * @desc
 */
public interface IPodListActivity extends IMVP {
    void onSwiperRefresh(PODDetaliBean pODDetaliBean);
    void onSwiperLoadMore(PODDetaliBean pODDetaliBean);

    void getFuwuZEkouSuccess(FUWUZEKOUbEAN fUWUZEKOUbEAN);

    void getPingpaiSuccess(PingpaiBean pingpaiBean);
}
