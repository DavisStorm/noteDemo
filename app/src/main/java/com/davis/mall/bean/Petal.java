package com.davis.mall.bean;

public class Petal {

    private int resId;//资源id
    private String info;//资源描述

    public Petal(int iconId, String iconName) {
        this.resId = iconId;
        this.info = iconName;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
