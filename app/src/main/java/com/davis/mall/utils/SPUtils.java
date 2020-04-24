package com.davis.mall.utils;

import android.content.Context;

/**
 * @author 王阳
 * @time 2019/12/18  23:01
 * @desc
 */
public class SPUtils {

    public static void putString(Context context,String name, String keyword){
        context.getSharedPreferences("APP_SP", Context.MODE_PRIVATE).edit()
                .putString(name,keyword).apply();
    }

    public static String getString(Context context,String name){
        return context.getSharedPreferences("APP_SP", Context.MODE_PRIVATE).getString(name,"");
    }

    public static void removeString(Context context,String keywords) {
        context.getSharedPreferences("APP_SP", Context.MODE_PRIVATE).edit().remove(keywords).apply();
    }
}
