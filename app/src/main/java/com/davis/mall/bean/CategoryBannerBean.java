package com.davis.mall.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author 王阳
 * @time 2019/11/14  0:47
 * @desc
 */
public class CategoryBannerBean extends BaseObjectEntity<CategoryBannerBean.DataBean> {


    /**
     * ret : 200
     * data : {"err_code":0,"err_msg":"","total":3,"list":[{"id":5,"uuid":"","add_time":"2019-11-13 22:21:34","update_time":"2019-11-13 22:28:39","ext_data":null,"adimgurls":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191113221952_c2a7868ebf0855fa19b9b534dd701a65.png","typeId":"2"},{"id":6,"uuid":"","add_time":"2019-11-13 22:23:30","update_time":null,"ext_data":null,"adimgurls":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191113221946_6bb1dfdde1cdd5e01bc4cf7907ee51c0.png","typeId":"2"},{"id":7,"uuid":"","add_time":"2019-11-13 22:23:45","update_time":null,"ext_data":null,"adimgurls":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191113221938_006f86597182e015d16242a1d911e5b1.png","typeId":"2"}],"page":1,"perpage":10}
     */

    private int ret;
    @SerializedName("data")

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
         * list : [{"id":5,"uuid":"","add_time":"2019-11-13 22:21:34","update_time":"2019-11-13 22:28:39","ext_data":null,"adimgurls":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191113221952_c2a7868ebf0855fa19b9b534dd701a65.png","typeId":"2"},{"id":6,"uuid":"","add_time":"2019-11-13 22:23:30","update_time":null,"ext_data":null,"adimgurls":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191113221946_6bb1dfdde1cdd5e01bc4cf7907ee51c0.png","typeId":"2"},{"id":7,"uuid":"","add_time":"2019-11-13 22:23:45","update_time":null,"ext_data":null,"adimgurls":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191113221938_006f86597182e015d16242a1d911e5b1.png","typeId":"2"}]
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
             * id : 5
             * uuid :
             * add_time : 2019-11-13 22:21:34
             * update_time : 2019-11-13 22:28:39
             * ext_data : null
             * adimgurls : http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191113221952_c2a7868ebf0855fa19b9b534dd701a65.png
             * typeId : 2
             */

            private int id;
            private String uuid;
            private String add_time;
            private String update_time;
            private Object ext_data;
            private String adimgurls;
            private String typeId;

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

            public String getAdimgurls() {
                return adimgurls;
            }

            public void setAdimgurls(String adimgurls) {
                this.adimgurls = adimgurls;
            }

            public String getTypeId() {
                return typeId;
            }

            public void setTypeId(String typeId) {
                this.typeId = typeId;
            }
        }
    }
}
