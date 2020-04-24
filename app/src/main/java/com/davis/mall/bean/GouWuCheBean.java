package com.davis.mall.bean;

import java.util.List;

/**
 * @author 王阳
 * @time 2020/1/6  12:20
 * @desc
 */
public class GouWuCheBean extends BaseObjectEntity<GouWuCheBean.DataBean> {

    /**
     * ret : 200
     * data : {"err_code":0,"err_msg":"","total":1,"list":[{"id":1,"uuid":"","add_time":"2020-01-06 12:01:15","update_time":"2020-01-06 12:08:13","ext_data":null,"dianpu_id":111113,"youhui_type":1,"youhui_name":"2件8折，3件7折","cate_id":1111111,"images":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053342_3ada5e4491d5dd877a2526d51680b2cb.jpeg","namepod":"花花公子2019冬季新款羽绒服男士立领短款轻薄羽绒袄中青年商务休闲防寒保暖上衣男装时尚百搭外套爸爸装","price":468,"ifBaoyou":"免邮费","pod_color":"黑色","pod_chima":"170","store_name":"鑫众服装专营店","pod_num":1,"user_id":1111111111}],"page":1,"perpage":10}
     */

    private int ret;

    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public static class DataBean {
        /**
         * err_code : 0
         * err_msg :
         * total : 1
         * list : [{"id":1,"uuid":"","add_time":"2020-01-06 12:01:15","update_time":"2020-01-06 12:08:13","ext_data":null,"dianpu_id":111113,"youhui_type":1,"youhui_name":"2件8折，3件7折","cate_id":1111111,"images":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053342_3ada5e4491d5dd877a2526d51680b2cb.jpeg","namepod":"花花公子2019冬季新款羽绒服男士立领短款轻薄羽绒袄中青年商务休闲防寒保暖上衣男装时尚百搭外套爸爸装","price":468,"ifBaoyou":"免邮费","pod_color":"黑色","pod_chima":"170","store_name":"鑫众服装专营店","pod_num":1,"user_id":1111111111}]
         * page : 1
         * perpage : 10
         */

        private int err_code;
        private String err_msg;
        private int total;
        private int page;
        private int perpage;
        private List<ListBean> list;

        public int getErr_code() {
            return err_code;
        }

        public void setErr_code(int err_code) {
            this.err_code = err_code;
        }

        public String getErr_msg() {
            return err_msg;
        }

        public void setErr_msg(String err_msg) {
            this.err_msg = err_msg;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public int getPerpage() {
            return perpage;
        }

        public void setPerpage(int perpage) {
            this.perpage = perpage;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * id : 1
             * uuid :
             * add_time : 2020-01-06 12:01:15
             * update_time : 2020-01-06 12:08:13
             * ext_data : null
             * dianpu_id : 111113
             * youhui_type : 1
             * youhui_name : 2件8折，3件7折
             * cate_id : 1111111
             * images : http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053342_3ada5e4491d5dd877a2526d51680b2cb.jpeg
             * namepod : 花花公子2019冬季新款羽绒服男士立领短款轻薄羽绒袄中青年商务休闲防寒保暖上衣男装时尚百搭外套爸爸装
             * price : 468
             * ifBaoyou : 免邮费
             * pod_color : 黑色
             * pod_chima : 170
             * store_name : 鑫众服装专营店
             * pod_num : 1
             * user_id : 1111111111
             *
             */

            private int id;
            private String uuid;
            private String add_time;
            private String update_time;
            private Object ext_data;
            private int dianpu_id;
            private int youhui_type;
            private String youhui_name;
            private int cate_id;
            private String images;
            private String namepod;
            private int price;
            private String ifBaoyou;
            private String pod_color;
            private String pod_chima;
            private String store_name;
            private int pod_num;
            private int user_id;
            private boolean ifSelected;

            public boolean isIfSelected() {
                return ifSelected;
            }

            public void setIfSelected(boolean ifSelected) {
                this.ifSelected = ifSelected;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getUuid() {
                return uuid;
            }

            public void setUuid(String uuid) {
                this.uuid = uuid;
            }

            public String getAdd_time() {
                return add_time;
            }

            public void setAdd_time(String add_time) {
                this.add_time = add_time;
            }

            public String getUpdate_time() {
                return update_time;
            }

            public void setUpdate_time(String update_time) {
                this.update_time = update_time;
            }

            public Object getExt_data() {
                return ext_data;
            }

            public void setExt_data(Object ext_data) {
                this.ext_data = ext_data;
            }

            public int getDianpu_id() {
                return dianpu_id;
            }

            public void setDianpu_id(int dianpu_id) {
                this.dianpu_id = dianpu_id;
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

            public int getCate_id() {
                return cate_id;
            }

            public void setCate_id(int cate_id) {
                this.cate_id = cate_id;
            }

            public String getImages() {
                return images;
            }

            public void setImages(String images) {
                this.images = images;
            }

            public String getNamepod() {
                return namepod;
            }

            public void setNamepod(String namepod) {
                this.namepod = namepod;
            }

            public int getPrice() {
                return price;
            }

            public void setPrice(int price) {
                this.price = price;
            }

            public String getIfBaoyou() {
                return ifBaoyou;
            }

            public void setIfBaoyou(String ifBaoyou) {
                this.ifBaoyou = ifBaoyou;
            }

            public String getPod_color() {
                return pod_color;
            }

            public void setPod_color(String pod_color) {
                this.pod_color = pod_color;
            }

            public String getPod_chima() {
                return pod_chima;
            }

            public void setPod_chima(String pod_chima) {
                this.pod_chima = pod_chima;
            }

            public String getStore_name() {
                return store_name;
            }

            public void setStore_name(String store_name) {
                this.store_name = store_name;
            }

            public int getPod_num() {
                return pod_num;
            }

            public void setPod_num(int pod_num) {
                this.pod_num = pod_num;
            }

            public int getUser_id() {
                return user_id;
            }

            public void setUser_id(int user_id) {
                this.user_id = user_id;
            }
        }
    }
}
