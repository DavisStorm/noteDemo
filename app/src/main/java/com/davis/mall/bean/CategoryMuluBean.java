package com.davis.mall.bean;

import java.util.List;

/**
 * @author 王阳
 * @time 2019/12/27  7:48
 * @desc
 */
public class CategoryMuluBean extends BaseObjectEntity<CategoryMuluBean.DataBean> {

    /**
     * ret : 200
     * data : {"err_code":0,"err_msg":"","total":80,"list":[{"id":14,"uuid":"","add_time":"2019-12-27 03:59:02","update_time":null,"ext_data":null,"first_class_id":"1","second_class_id":"","third_class_id":"","fenzhi_id":0,"first_class_name":"精品男装","second_class_name":"","third_class_name":"","img_url":""},{"id":15,"uuid":"","add_time":"2019-12-27 03:59:02","update_time":null,"ext_data":null,"first_class_id":"2","second_class_id":"","third_class_id":"","fenzhi_id":0,"first_class_name":"时尚女装","second_class_name":"","third_class_name":"","img_url":""},{"id":16,"uuid":"","add_time":"2019-12-27 03:59:02","update_time":null,"ext_data":null,"first_class_id":"3","second_class_id":"","third_class_id":"","fenzhi_id":0,"first_class_name":"美妆护肤","second_class_name":"","third_class_name":"","img_url":""},{"id":17,"uuid":"","add_time":"2019-12-27 03:59:02","update_time":null,"ext_data":null,"first_class_id":"4","second_class_id":"","third_class_id":"","fenzhi_id":0,"first_class_name":"手机数码","second_class_name":"","third_class_name":"","img_url":""},{"id":18,"uuid":"","add_time":"2019-12-27 03:59:02","update_time":null,"ext_data":null,"first_class_id":"5","second_class_id":"","third_class_id":"","fenzhi_id":0,"first_class_name":"电脑办公","second_class_name":"","third_class_name":"","img_url":""},{"id":19,"uuid":"","add_time":"2019-12-27 03:59:02","update_time":null,"ext_data":null,"first_class_id":"6","second_class_id":"","third_class_id":"","fenzhi_id":0,"first_class_name":"家用电器","second_class_name":"","third_class_name":"","img_url":""},{"id":20,"uuid":"","add_time":"2019-12-27 03:59:02","update_time":null,"ext_data":null,"first_class_id":"7","second_class_id":"","third_class_id":"","fenzhi_id":0,"first_class_name":"钟表珠宝","second_class_name":"","third_class_name":"","img_url":""},{"id":21,"uuid":"","add_time":"2019-12-27 03:59:02","update_time":null,"ext_data":null,"first_class_id":"8","second_class_id":"","third_class_id":"","fenzhi_id":0,"first_class_name":"箱包手袋","second_class_name":"","third_class_name":"","img_url":""},{"id":22,"uuid":"","add_time":"2019-12-27 03:59:02","update_time":null,"ext_data":null,"first_class_id":"9","second_class_id":"","third_class_id":"","fenzhi_id":0,"first_class_name":"食品生鲜","second_class_name":"","third_class_name":"","img_url":""},{"id":23,"uuid":"","add_time":"2019-12-27 03:59:02","update_time":null,"ext_data":null,"first_class_id":"10","second_class_id":"","third_class_id":"","fenzhi_id":0,"first_class_name":"玩具乐器","second_class_name":"","third_class_name":"","img_url":""},{"id":24,"uuid":"","add_time":"2019-12-27 03:59:02","update_time":null,"ext_data":null,"first_class_id":"11","second_class_id":"","third_class_id":"","fenzhi_id":0,"first_class_name":"医药保健","second_class_name":"","third_class_name":"","img_url":""},{"id":25,"uuid":"","add_time":"2019-12-27 03:59:02","update_time":null,"ext_data":null,"first_class_id":"12","second_class_id":"","third_class_id":"","fenzhi_id":0,"first_class_name":"礼品鲜花","second_class_name":"","third_class_name":"","img_url":""},{"id":26,"uuid":"","add_time":"2019-12-27 03:59:02","update_time":null,"ext_data":null,"first_class_id":"13","second_class_id":"","third_class_id":"","fenzhi_id":0,"first_class_name":"生活家居","second_class_name":"","third_class_name":"","img_url":""}],"page":1,"perpage":13}
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
         * total : 80
         * list : [{"id":14,"uuid":"","add_time":"2019-12-27 03:59:02","update_time":null,"ext_data":null,"first_class_id":"1","second_class_id":"","third_class_id":"","fenzhi_id":0,"first_class_name":"精品男装","second_class_name":"","third_class_name":"","img_url":""},{"id":15,"uuid":"","add_time":"2019-12-27 03:59:02","update_time":null,"ext_data":null,"first_class_id":"2","second_class_id":"","third_class_id":"","fenzhi_id":0,"first_class_name":"时尚女装","second_class_name":"","third_class_name":"","img_url":""},{"id":16,"uuid":"","add_time":"2019-12-27 03:59:02","update_time":null,"ext_data":null,"first_class_id":"3","second_class_id":"","third_class_id":"","fenzhi_id":0,"first_class_name":"美妆护肤","second_class_name":"","third_class_name":"","img_url":""},{"id":17,"uuid":"","add_time":"2019-12-27 03:59:02","update_time":null,"ext_data":null,"first_class_id":"4","second_class_id":"","third_class_id":"","fenzhi_id":0,"first_class_name":"手机数码","second_class_name":"","third_class_name":"","img_url":""},{"id":18,"uuid":"","add_time":"2019-12-27 03:59:02","update_time":null,"ext_data":null,"first_class_id":"5","second_class_id":"","third_class_id":"","fenzhi_id":0,"first_class_name":"电脑办公","second_class_name":"","third_class_name":"","img_url":""},{"id":19,"uuid":"","add_time":"2019-12-27 03:59:02","update_time":null,"ext_data":null,"first_class_id":"6","second_class_id":"","third_class_id":"","fenzhi_id":0,"first_class_name":"家用电器","second_class_name":"","third_class_name":"","img_url":""},{"id":20,"uuid":"","add_time":"2019-12-27 03:59:02","update_time":null,"ext_data":null,"first_class_id":"7","second_class_id":"","third_class_id":"","fenzhi_id":0,"first_class_name":"钟表珠宝","second_class_name":"","third_class_name":"","img_url":""},{"id":21,"uuid":"","add_time":"2019-12-27 03:59:02","update_time":null,"ext_data":null,"first_class_id":"8","second_class_id":"","third_class_id":"","fenzhi_id":0,"first_class_name":"箱包手袋","second_class_name":"","third_class_name":"","img_url":""},{"id":22,"uuid":"","add_time":"2019-12-27 03:59:02","update_time":null,"ext_data":null,"first_class_id":"9","second_class_id":"","third_class_id":"","fenzhi_id":0,"first_class_name":"食品生鲜","second_class_name":"","third_class_name":"","img_url":""},{"id":23,"uuid":"","add_time":"2019-12-27 03:59:02","update_time":null,"ext_data":null,"first_class_id":"10","second_class_id":"","third_class_id":"","fenzhi_id":0,"first_class_name":"玩具乐器","second_class_name":"","third_class_name":"","img_url":""},{"id":24,"uuid":"","add_time":"2019-12-27 03:59:02","update_time":null,"ext_data":null,"first_class_id":"11","second_class_id":"","third_class_id":"","fenzhi_id":0,"first_class_name":"医药保健","second_class_name":"","third_class_name":"","img_url":""},{"id":25,"uuid":"","add_time":"2019-12-27 03:59:02","update_time":null,"ext_data":null,"first_class_id":"12","second_class_id":"","third_class_id":"","fenzhi_id":0,"first_class_name":"礼品鲜花","second_class_name":"","third_class_name":"","img_url":""},{"id":26,"uuid":"","add_time":"2019-12-27 03:59:02","update_time":null,"ext_data":null,"first_class_id":"13","second_class_id":"","third_class_id":"","fenzhi_id":0,"first_class_name":"生活家居","second_class_name":"","third_class_name":"","img_url":""}]
         * page : 1
         * perpage : 13
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
             * id : 14
             * uuid :
             * add_time : 2019-12-27 03:59:02
             * update_time : null
             * ext_data : null
             * first_class_id : 1
             * second_class_id :
             * third_class_id :
             * fenzhi_id : 0
             * first_class_name : 精品男装
             * second_class_name :
             * third_class_name :
             * img_url :
             */

            private int id;
            private String uuid;
            private String add_time;
            private Object update_time;
            private Object ext_data;
            private String first_class_id;
            private String second_class_id;
            private String third_class_id;
            private int fenzhi_id;
            private String first_class_name;
            private String second_class_name;
            private String third_class_name;
            private String img_url;

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

            public Object getUpdate_time() {
                return update_time;
            }

            public void setUpdate_time(Object update_time) {
                this.update_time = update_time;
            }

            public Object getExt_data() {
                return ext_data;
            }

            public void setExt_data(Object ext_data) {
                this.ext_data = ext_data;
            }

            public String getFirst_class_id() {
                return first_class_id;
            }

            public void setFirst_class_id(String first_class_id) {
                this.first_class_id = first_class_id;
            }

            public String getSecond_class_id() {
                return second_class_id;
            }

            public void setSecond_class_id(String second_class_id) {
                this.second_class_id = second_class_id;
            }

            public String getThird_class_id() {
                return third_class_id;
            }

            public void setThird_class_id(String third_class_id) {
                this.third_class_id = third_class_id;
            }

            public int getFenzhi_id() {
                return fenzhi_id;
            }

            public void setFenzhi_id(int fenzhi_id) {
                this.fenzhi_id = fenzhi_id;
            }

            public String getFirst_class_name() {
                return first_class_name;
            }

            public void setFirst_class_name(String first_class_name) {
                this.first_class_name = first_class_name;
            }

            public String getSecond_class_name() {
                return second_class_name;
            }

            public void setSecond_class_name(String second_class_name) {
                this.second_class_name = second_class_name;
            }

            public String getThird_class_name() {
                return third_class_name;
            }

            public void setThird_class_name(String third_class_name) {
                this.third_class_name = third_class_name;
            }

            public String getImg_url() {
                return img_url;
            }

            public void setImg_url(String img_url) {
                this.img_url = img_url;
            }
        }
    }
}
