package com.davis.mall.bean;

/**
 * @author 王阳
 * @time 2019/11/9  2:01
 * @desc
 */
public class BaseObjectEntity<T> extends BaseMsg {
    public T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
