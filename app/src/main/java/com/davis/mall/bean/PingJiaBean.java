package com.davis.mall.bean;

import java.util.List;

/**
 * @author 王阳
 * @time 2019/12/25  14:53
 * @desc
 */
public class PingJiaBean extends BaseObjectEntity<PingJiaBean.DataBean> {

    /**
     * ret : 200
     * data : {"err_code":0,"err_msg":"","total":7,"list":[{"id":1,"uuid":"","add_time":"2019-12-19 05:55:51","update_time":"2019-12-25 14:40:07","ext_data":null,"pj_name":"张学友","pj_icon":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219055351_2ad618fb9e21a2b729b9425bbaf51296.jpeg","pj_score":5,"pj_msg":"羽绒服蛮厚实的，保暖效果非常好，防风保暖，做工也不错，走线都很均匀紧密。面料舒适，尺码标准，穿着正合适！很满意...","pj_img":"","pj_video":"","pj_kuanxin":"972","pj_chima":"180","pj_color":"上青色","cate_id":1111111},{"id":2,"uuid":"","add_time":"2019-12-25 14:39:51","update_time":null,"ext_data":null,"pj_name":"郭富城","pj_icon":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219055351_2ad618fb9e21a2b729b9425bbaf51296.jpeg","pj_score":4,"pj_msg":"合身，今暖和的，这个冬天不怕冷了","pj_img":"","pj_video":"","pj_kuanxin":"922","pj_chima":"185","pj_color":"黑色","cate_id":1111111},{"id":3,"uuid":"","add_time":"2019-12-25 14:40:59","update_time":null,"ext_data":null,"pj_name":"刘德华","pj_icon":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219055351_2ad618fb9e21a2b729b9425bbaf51296.jpeg","pj_score":3,"pj_msg":"衣服的质量很好，布料手感都不错，穿上也很保暖的感觉，买的时候看评论太少还不放心，不过现在看来质量还不错，发货速度也很快","pj_img":"","pj_video":"","pj_kuanxin":"885","pj_chima":"195","pj_color":"灰色","cate_id":1111111},{"id":4,"uuid":"","add_time":"2019-12-25 14:42:32","update_time":null,"ext_data":null,"pj_name":"周杰伦","pj_icon":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219055351_2ad618fb9e21a2b729b9425bbaf51296.jpeg","pj_score":2,"pj_msg":"订的蓝色M，实际颜色接近铁灰，此衣为修身版，我身材偏瘦，刚好合身，衣长稍短了一点，外面两插袋够深，帽子不可拆。衣服轻薄，今天14度，待降温后再检验保暖如何。","pj_img":"","pj_video":"","pj_kuanxin":"972","pj_chima":"180","pj_color":"上青色","cate_id":1111111},{"id":5,"uuid":"","add_time":"2019-12-25 14:43:52","update_time":null,"ext_data":null,"pj_name":"陈奕迅","pj_icon":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219055351_2ad618fb9e21a2b729b9425bbaf51296.jpeg","pj_score":4,"pj_msg":"衣服还好吧，个人感觉有点薄了。不过作为一个外套穿够用了。款式新颖，宽松大气。秋季穿合适，冬天有点冷了。个人感觉这种衣服黑色穿人更好看。显得瘦。快递也很快。第一次买感觉小了，京东上门取件换送免运费还是很人性化的。京东买的东西放心。","pj_img":"","pj_video":"","pj_kuanxin":"285","pj_chima":"185","pj_color":"天蓝色","cate_id":1111111}],"page":1,"perpage":5}
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
         * list : [{"id":1,"uuid":"","add_time":"2019-12-19 05:55:51","update_time":"2019-12-25 14:40:07","ext_data":null,"pj_name":"张学友","pj_icon":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219055351_2ad618fb9e21a2b729b9425bbaf51296.jpeg","pj_score":5,"pj_msg":"羽绒服蛮厚实的，保暖效果非常好，防风保暖，做工也不错，走线都很均匀紧密。面料舒适，尺码标准，穿着正合适！很满意...","pj_img":"","pj_video":"","pj_kuanxin":"972","pj_chima":"180","pj_color":"上青色","cate_id":1111111},{"id":2,"uuid":"","add_time":"2019-12-25 14:39:51","update_time":null,"ext_data":null,"pj_name":"郭富城","pj_icon":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219055351_2ad618fb9e21a2b729b9425bbaf51296.jpeg","pj_score":4,"pj_msg":"合身，今暖和的，这个冬天不怕冷了","pj_img":"","pj_video":"","pj_kuanxin":"922","pj_chima":"185","pj_color":"黑色","cate_id":1111111},{"id":3,"uuid":"","add_time":"2019-12-25 14:40:59","update_time":null,"ext_data":null,"pj_name":"刘德华","pj_icon":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219055351_2ad618fb9e21a2b729b9425bbaf51296.jpeg","pj_score":3,"pj_msg":"衣服的质量很好，布料手感都不错，穿上也很保暖的感觉，买的时候看评论太少还不放心，不过现在看来质量还不错，发货速度也很快","pj_img":"","pj_video":"","pj_kuanxin":"885","pj_chima":"195","pj_color":"灰色","cate_id":1111111},{"id":4,"uuid":"","add_time":"2019-12-25 14:42:32","update_time":null,"ext_data":null,"pj_name":"周杰伦","pj_icon":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219055351_2ad618fb9e21a2b729b9425bbaf51296.jpeg","pj_score":2,"pj_msg":"订的蓝色M，实际颜色接近铁灰，此衣为修身版，我身材偏瘦，刚好合身，衣长稍短了一点，外面两插袋够深，帽子不可拆。衣服轻薄，今天14度，待降温后再检验保暖如何。","pj_img":"","pj_video":"","pj_kuanxin":"972","pj_chima":"180","pj_color":"上青色","cate_id":1111111},{"id":5,"uuid":"","add_time":"2019-12-25 14:43:52","update_time":null,"ext_data":null,"pj_name":"陈奕迅","pj_icon":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219055351_2ad618fb9e21a2b729b9425bbaf51296.jpeg","pj_score":4,"pj_msg":"衣服还好吧，个人感觉有点薄了。不过作为一个外套穿够用了。款式新颖，宽松大气。秋季穿合适，冬天有点冷了。个人感觉这种衣服黑色穿人更好看。显得瘦。快递也很快。第一次买感觉小了，京东上门取件换送免运费还是很人性化的。京东买的东西放心。","pj_img":"","pj_video":"","pj_kuanxin":"285","pj_chima":"185","pj_color":"天蓝色","cate_id":1111111}]
         * page : 1
         * perpage : 5
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
             * add_time : 2019-12-19 05:55:51
             * update_time : 2019-12-25 14:40:07
             * ext_data : null
             * pj_name : 张学友
             * pj_icon : http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219055351_2ad618fb9e21a2b729b9425bbaf51296.jpeg
             * pj_score : 5
             * pj_msg : 羽绒服蛮厚实的，保暖效果非常好，防风保暖，做工也不错，走线都很均匀紧密。面料舒适，尺码标准，穿着正合适！很满意...
             * pj_img :
             * pj_video :
             * pj_kuanxin : 972
             * pj_chima : 180
             * pj_color : 上青色
             * cate_id : 1111111
             */

            private int id;
            private String uuid;
            private String add_time;
            private String update_time;
            private Object ext_data;
            private String pj_name;
            private String pj_icon;
            private int pj_score;
            private String pj_msg;
            private String pj_img;
            private String pj_video;
            private String pj_kuanxin;
            private String pj_chima;
            private String pj_color;
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

            public String getPj_name() {
                return pj_name;
            }

            public void setPj_name(String pj_name) {
                this.pj_name = pj_name;
            }

            public String getPj_icon() {
                return pj_icon;
            }

            public void setPj_icon(String pj_icon) {
                this.pj_icon = pj_icon;
            }

            public int getPj_score() {
                return pj_score;
            }

            public void setPj_score(int pj_score) {
                this.pj_score = pj_score;
            }

            public String getPj_msg() {
                return pj_msg;
            }

            public void setPj_msg(String pj_msg) {
                this.pj_msg = pj_msg;
            }

            public String getPj_img() {
                return pj_img;
            }

            public void setPj_img(String pj_img) {
                this.pj_img = pj_img;
            }

            public String getPj_video() {
                return pj_video;
            }

            public void setPj_video(String pj_video) {
                this.pj_video = pj_video;
            }

            public String getPj_kuanxin() {
                return pj_kuanxin;
            }

            public void setPj_kuanxin(String pj_kuanxin) {
                this.pj_kuanxin = pj_kuanxin;
            }

            public String getPj_chima() {
                return pj_chima;
            }

            public void setPj_chima(String pj_chima) {
                this.pj_chima = pj_chima;
            }

            public String getPj_color() {
                return pj_color;
            }

            public void setPj_color(String pj_color) {
                this.pj_color = pj_color;
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
