package com.davis.mall.bean;

import java.util.List;

/**
 * @author 王阳
 * @time 2019/11/11  3:09
 * @desc
 */
public class AllFavorBean extends BaseObjectEntity<AllFavorBean.DataBean>{


    /**
     * ret : 200
     * data : {"err_code":0,"err_msg":"","total":3,"list":[{"id":1,"uuid":"","add_time":"2020-01-04 08:13:41","update_time":"2020-01-04 08:15:57","ext_data":null,"favorNum":999,"favor_name":"何润东","favor_name_num":1,"favor_icon":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219055351_2ad618fb9e21a2b729b9425bbaf51296.jpeg","favor_img":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053342_3ada5e4491d5dd877a2526d51680b2cb.jpeg","cate_id":1111111},{"id":2,"uuid":"","add_time":"2020-01-04 08:15:42","update_time":null,"ext_data":null,"favorNum":3012,"favor_name":"张学友","favor_name_num":1,"favor_icon":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219055351_2ad618fb9e21a2b729b9425bbaf51296.jpeg","favor_img":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225162053_c3ba36f1e6ab168c816bf434be04c6fc.png","cate_id":1111112},{"id":3,"uuid":"","add_time":"2020-01-04 08:17:51","update_time":null,"ext_data":null,"favorNum":899,"favor_name":"刘德华","favor_name_num":1,"favor_icon":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219055351_2ad618fb9e21a2b729b9425bbaf51296.jpeg","favor_img":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20200101133047_e72d71e3410e0be69d7bc930d548855e.png","cate_id":1111115}],"page":1,"perpage":10}
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
         * total : 3
         * list : [{"id":1,"uuid":"","add_time":"2020-01-04 08:13:41","update_time":"2020-01-04 08:15:57","ext_data":null,"favorNum":999,"favor_name":"何润东","favor_name_num":1,"favor_icon":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219055351_2ad618fb9e21a2b729b9425bbaf51296.jpeg","favor_img":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053342_3ada5e4491d5dd877a2526d51680b2cb.jpeg","cate_id":1111111},{"id":2,"uuid":"","add_time":"2020-01-04 08:15:42","update_time":null,"ext_data":null,"favorNum":3012,"favor_name":"张学友","favor_name_num":1,"favor_icon":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219055351_2ad618fb9e21a2b729b9425bbaf51296.jpeg","favor_img":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225162053_c3ba36f1e6ab168c816bf434be04c6fc.png","cate_id":1111112},{"id":3,"uuid":"","add_time":"2020-01-04 08:17:51","update_time":null,"ext_data":null,"favorNum":899,"favor_name":"刘德华","favor_name_num":1,"favor_icon":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219055351_2ad618fb9e21a2b729b9425bbaf51296.jpeg","favor_img":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20200101133047_e72d71e3410e0be69d7bc930d548855e.png","cate_id":1111115}]
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
             * add_time : 2020-01-04 08:13:41
             * update_time : 2020-01-04 08:15:57
             * ext_data : null
             * favorNum : 999
             * favor_name : 何润东
             * favor_name_num : 1
             * favor_icon : http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219055351_2ad618fb9e21a2b729b9425bbaf51296.jpeg
             * favor_img : http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053342_3ada5e4491d5dd877a2526d51680b2cb.jpeg
             * cate_id : 1111111
             */

            private int id;
            private String uuid;
            private String add_time;
            private String update_time;
            private Object ext_data;
            private int favorNum;
            private String favor_name;
            private int favor_name_num;
            private String favor_icon;
            private String favor_img;
            private int cate_id;

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

            public int getFavorNum() {
                return favorNum;
            }

            public void setFavorNum(int favorNum) {
                this.favorNum = favorNum;
            }

            public String getFavor_name() {
                return favor_name;
            }

            public void setFavor_name(String favor_name) {
                this.favor_name = favor_name;
            }

            public int getFavor_name_num() {
                return favor_name_num;
            }

            public void setFavor_name_num(int favor_name_num) {
                this.favor_name_num = favor_name_num;
            }

            public String getFavor_icon() {
                return favor_icon;
            }

            public void setFavor_icon(String favor_icon) {
                this.favor_icon = favor_icon;
            }

            public String getFavor_img() {
                return favor_img;
            }

            public void setFavor_img(String favor_img) {
                this.favor_img = favor_img;
            }

            public int getCate_id() {
                return cate_id;
            }

            public void setCate_id(int cate_id) {
                this.cate_id = cate_id;
            }
        }
    }
}
