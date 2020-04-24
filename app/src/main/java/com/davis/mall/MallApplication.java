package com.davis.mall;

import android.app.Application;
import android.content.Context;

import com.davis.mall.bean.LoginBean;
import com.davis.mall.db.LocalGreenDao;
import com.davis.mall.utils.CrashHandler;

/**
 * @author 王阳
 * @time 2019/10/29  1:09
 * @desc
 */
public class MallApplication extends Application {

    private static Context mContext;
    public static boolean IF_LOGIN_IN = false;

    public static LoginBean.DataBean.ListBean USER;

    @Override
    public void onCreate() {
        super.onCreate();

        mContext = getApplicationContext();
 //       LeakCanary.install(this);

        //未捕捉异常的处理
        CrashHandler.getInstance().init(mContext);


        //本地数据缓存
        LocalGreenDao.getInstance().insertUnit();

    }

    public static Context getContext() {
        return mContext;
    }

    public static LoginBean.DataBean.ListBean getUSER() {
        return USER;
    }

}
