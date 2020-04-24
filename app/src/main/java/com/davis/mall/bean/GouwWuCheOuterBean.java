package com.davis.mall.bean;

/**
 * @author 王阳
 * @time 2020/1/6  12:22
 * @desc
 */
public class GouwWuCheOuterBean {

    private int youhui_type;
    private String youhui_name;
    private String store_name;
    private int dianpu_id;
    private int dianpu_pod_num;//购物车内店铺下的商品种类数量
    private int youhui_sum;//优惠金额
    private int selected_num;//已选商品数量

    public int getSelected_num() {
        return selected_num;
    }

    public void setSelected_num(int selected_num) {
        this.selected_num = selected_num;
    }

    public int getYouhui_sum() {
        return youhui_sum;
    }

    public void setYouhui_sum(int youhui_sum) {
        this.youhui_sum = youhui_sum;
    }

    public int getYouhui_type() {
        return youhui_type;
    }

    public void setYouhui_type(int youhui_type) {
        this.youhui_type = youhui_type;
    }

    public String getYouhui_name() {
        return youhui_name;
    }

    public void setYouhui_name(String youhui_name) {
        this.youhui_name = youhui_name;
    }

    public String getStore_name() {
        return store_name;
    }

    public void setStore_name(String store_name) {
        this.store_name = store_name;
    }

    public int getDianpu_id() {
        return dianpu_id;
    }

    public void setDianpu_id(int dianpu_id) {
        this.dianpu_id = dianpu_id;
    }

    public int getDianpu_pod_num() {
        return dianpu_pod_num;
    }

    public void setDianpu_pod_num(int dianpu_pod_num) {
        this.dianpu_pod_num = dianpu_pod_num;
    }
}
