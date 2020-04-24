package com.davis.mall.bean;

import java.util.List;

/**
 * @author 王阳
 * @time 2019/11/9  2:01
 * @desc
 */
public class BaseArrayObjectEntity<T> extends BaseMsg {
    public List<T> data;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
