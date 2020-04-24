package com.davis.mall.bean;

/**
 * @author 王阳
 * @time 2019/11/9  1:57
 * @desc
 */
public class BaseMsg {
    public int code;
    public boolean success;
    public String msg;


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
