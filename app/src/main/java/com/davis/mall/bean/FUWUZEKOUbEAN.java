package com.davis.mall.bean;

import java.util.List;

/**
 * @author 王阳
 * @time 2020/1/3  12:41
 * @desc
 */
public class FUWUZEKOUbEAN extends BaseObjectEntity<FUWUZEKOUbEAN.DataBean>{

    /**
     * ret : 200
     * data : {"err_code":0,"err_msg":"","total":7,"list":[{"id":1,"uuid":"","add_time":"2020-01-03 12:37:10","update_time":null,"ext_data":null,"fuwuzekou_name":"货到付款","fuwuzekou_id":1},{"id":2,"uuid":"","add_time":"2020-01-03 12:37:31","update_time":null,"ext_data":null,"fuwuzekou_name":"促销","fuwuzekou_id":2},{"id":3,"uuid":"","add_time":"2020-01-03 12:37:52","update_time":null,"ext_data":null,"fuwuzekou_name":"仅看有货","fuwuzekou_id":3},{"id":4,"uuid":"","add_time":"2020-01-03 12:38:11","update_time":null,"ext_data":null,"fuwuzekou_name":"配送全球","fuwuzekou_id":4},{"id":5,"uuid":"","add_time":"2020-01-03 12:38:29","update_time":null,"ext_data":null,"fuwuzekou_name":"PLUS专享","fuwuzekou_id":5},{"id":6,"uuid":"","add_time":"2020-01-03 12:38:54","update_time":null,"ext_data":null,"fuwuzekou_name":"新品","fuwuzekou_id":6},{"id":7,"uuid":"","add_time":"2020-01-03 12:39:33","update_time":null,"ext_data":null,"fuwuzekou_name":"拍拍二手","fuwuzekou_id":7}],"page":1,"perpage":10}
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
         * total : 7
         * list : [{"id":1,"uuid":"","add_time":"2020-01-03 12:37:10","update_time":null,"ext_data":null,"fuwuzekou_name":"货到付款","fuwuzekou_id":1},{"id":2,"uuid":"","add_time":"2020-01-03 12:37:31","update_time":null,"ext_data":null,"fuwuzekou_name":"促销","fuwuzekou_id":2},{"id":3,"uuid":"","add_time":"2020-01-03 12:37:52","update_time":null,"ext_data":null,"fuwuzekou_name":"仅看有货","fuwuzekou_id":3},{"id":4,"uuid":"","add_time":"2020-01-03 12:38:11","update_time":null,"ext_data":null,"fuwuzekou_name":"配送全球","fuwuzekou_id":4},{"id":5,"uuid":"","add_time":"2020-01-03 12:38:29","update_time":null,"ext_data":null,"fuwuzekou_name":"PLUS专享","fuwuzekou_id":5},{"id":6,"uuid":"","add_time":"2020-01-03 12:38:54","update_time":null,"ext_data":null,"fuwuzekou_name":"新品","fuwuzekou_id":6},{"id":7,"uuid":"","add_time":"2020-01-03 12:39:33","update_time":null,"ext_data":null,"fuwuzekou_name":"拍拍二手","fuwuzekou_id":7}]
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
             * add_time : 2020-01-03 12:37:10
             * update_time : null
             * ext_data : null
             * fuwuzekou_name : 货到付款
             * fuwuzekou_id : 1
             */

            private int id;
            private String uuid;
            private String add_time;
            private Object update_time;
            private Object ext_data;
            private String fuwuzekou_name;
            private int fuwuzekou_id;

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

            public String getFuwuzekou_name() {
                return fuwuzekou_name;
            }

            public void setFuwuzekou_name(String fuwuzekou_name) {
                this.fuwuzekou_name = fuwuzekou_name;
            }

            public int getFuwuzekou_id() {
                return fuwuzekou_id;
            }

            public void setFuwuzekou_id(int fuwuzekou_id) {
                this.fuwuzekou_id = fuwuzekou_id;
            }
        }
    }
}
