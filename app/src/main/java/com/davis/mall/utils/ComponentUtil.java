package com.davis.mall.utils;

import android.view.View;

/**
 * @author 王阳
 * @time 2019/11/12  23:55
 * @desc
 */
public class ComponentUtil {

    public static int getComponentHeight(View component){
        int w = View.MeasureSpec.makeMeasureSpec(0,
                View.MeasureSpec.UNSPECIFIED);
        int h = View.MeasureSpec.makeMeasureSpec(0,
                View.MeasureSpec.UNSPECIFIED);
        component.measure(w, h);
        return component.getMeasuredHeight();
    }
}
