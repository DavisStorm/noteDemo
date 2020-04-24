package com.davis.mall.bean;

import java.util.List;

/**
 * @author 王阳
 * @time 2020/1/3  12:41
 * @desc
 */
public class PingpaiBean extends BaseObjectEntity<PingpaiBean.DataBean>{


    /**
     * ret : 200
     * data : {"err_code":0,"err_msg":"","tree":[{"id":3,"uuid":"","add_time":"2020-01-02 14:30:48","update_time":null,"ext_data":null,"class_id":0,"pingpai_name":"花花公子","pingpai_id":"11111111","fenzhi_id":1,"children_tree":[]},{"id":4,"uuid":"","add_time":"2020-01-03 11:11:51","update_time":null,"ext_data":null,"class_id":0,"pingpai_name":"稻草人","pingpai_id":"11111112","fenzhi_id":1,"children_tree":[]},{"id":5,"uuid":"","add_time":"2020-01-03 11:12:26","update_time":null,"ext_data":null,"class_id":0,"pingpai_name":"贵人鸟","pingpai_id":"11111113","fenzhi_id":1,"children_tree":[]},{"id":6,"uuid":"","add_time":"2020-01-03 11:12:51","update_time":null,"ext_data":null,"class_id":0,"pingpai_name":"TEEK","pingpai_id":"11111114","fenzhi_id":1,"children_tree":[]},{"id":7,"uuid":"","add_time":"2020-01-03 11:13:13","update_time":null,"ext_data":null,"class_id":0,"pingpai_name":"涵之风","pingpai_id":"11111115","fenzhi_id":1,"children_tree":[]},{"id":8,"uuid":"","add_time":"2020-01-03 11:13:33","update_time":null,"ext_data":null,"class_id":0,"pingpai_name":"回图","pingpai_id":"11111116","fenzhi_id":1,"children_tree":[]},{"id":9,"uuid":"","add_time":"2020-01-03 11:14:38","update_time":null,"ext_data":null,"class_id":0,"pingpai_name":"富贵鸟","pingpai_id":"11111117","fenzhi_id":1,"children_tree":[]},{"id":10,"uuid":"","add_time":"2020-01-03 11:15:01","update_time":null,"ext_data":null,"class_id":0,"pingpai_name":"迪克牛仔","pingpai_id":"11111118","fenzhi_id":1,"children_tree":[]},{"id":11,"uuid":"","add_time":"2020-01-03 11:15:41","update_time":null,"ext_data":null,"class_id":0,"pingpai_name":"南极人","pingpai_id":"11111119","fenzhi_id":1,"children_tree":[]},{"id":12,"uuid":"","add_time":"2020-01-03 11:24:40","update_time":null,"ext_data":null,"class_id":0,"pingpai_name":"男韩版","pingpai_id":"11111120","fenzhi_id":1,"children_tree":[]}]}
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
         * tree : [{"id":3,"uuid":"","add_time":"2020-01-02 14:30:48","update_time":null,"ext_data":null,"class_id":0,"pingpai_name":"花花公子","pingpai_id":"11111111","fenzhi_id":1,"children_tree":[]},{"id":4,"uuid":"","add_time":"2020-01-03 11:11:51","update_time":null,"ext_data":null,"class_id":0,"pingpai_name":"稻草人","pingpai_id":"11111112","fenzhi_id":1,"children_tree":[]},{"id":5,"uuid":"","add_time":"2020-01-03 11:12:26","update_time":null,"ext_data":null,"class_id":0,"pingpai_name":"贵人鸟","pingpai_id":"11111113","fenzhi_id":1,"children_tree":[]},{"id":6,"uuid":"","add_time":"2020-01-03 11:12:51","update_time":null,"ext_data":null,"class_id":0,"pingpai_name":"TEEK","pingpai_id":"11111114","fenzhi_id":1,"children_tree":[]},{"id":7,"uuid":"","add_time":"2020-01-03 11:13:13","update_time":null,"ext_data":null,"class_id":0,"pingpai_name":"涵之风","pingpai_id":"11111115","fenzhi_id":1,"children_tree":[]},{"id":8,"uuid":"","add_time":"2020-01-03 11:13:33","update_time":null,"ext_data":null,"class_id":0,"pingpai_name":"回图","pingpai_id":"11111116","fenzhi_id":1,"children_tree":[]},{"id":9,"uuid":"","add_time":"2020-01-03 11:14:38","update_time":null,"ext_data":null,"class_id":0,"pingpai_name":"富贵鸟","pingpai_id":"11111117","fenzhi_id":1,"children_tree":[]},{"id":10,"uuid":"","add_time":"2020-01-03 11:15:01","update_time":null,"ext_data":null,"class_id":0,"pingpai_name":"迪克牛仔","pingpai_id":"11111118","fenzhi_id":1,"children_tree":[]},{"id":11,"uuid":"","add_time":"2020-01-03 11:15:41","update_time":null,"ext_data":null,"class_id":0,"pingpai_name":"南极人","pingpai_id":"11111119","fenzhi_id":1,"children_tree":[]},{"id":12,"uuid":"","add_time":"2020-01-03 11:24:40","update_time":null,"ext_data":null,"class_id":0,"pingpai_name":"男韩版","pingpai_id":"11111120","fenzhi_id":1,"children_tree":[]}]
         */

        private int err_code;
        private String err_msg;
        private List<TreeBean> tree;

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

        public List<TreeBean> getTree() {
            return tree;
        }

        public void setTree(List<TreeBean> tree) {
            this.tree = tree;
        }

        public static class TreeBean {
            /**
             * id : 3
             * uuid :
             * add_time : 2020-01-02 14:30:48
             * update_time : null
             * ext_data : null
             * class_id : 0
             * pingpai_name : 花花公子
             * pingpai_id : 11111111
             * fenzhi_id : 1
             * children_tree : []
             */

            private int id;
            private String uuid;
            private String add_time;
            private Object update_time;
            private Object ext_data;
            private int class_id;
            private String pingpai_name;
            private String pingpai_id;
            private int fenzhi_id;
            private List<?> children_tree;

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

            public int getClass_id() {
                return class_id;
            }

            public void setClass_id(int class_id) {
                this.class_id = class_id;
            }

            public String getPingpai_name() {
                return pingpai_name;
            }

            public void setPingpai_name(String pingpai_name) {
                this.pingpai_name = pingpai_name;
            }

            public String getPingpai_id() {
                return pingpai_id;
            }

            public void setPingpai_id(String pingpai_id) {
                this.pingpai_id = pingpai_id;
            }

            public int getFenzhi_id() {
                return fenzhi_id;
            }

            public void setFenzhi_id(int fenzhi_id) {
                this.fenzhi_id = fenzhi_id;
            }

            public List<?> getChildren_tree() {
                return children_tree;
            }

            public void setChildren_tree(List<?> children_tree) {
                this.children_tree = children_tree;
            }
        }
    }
}
