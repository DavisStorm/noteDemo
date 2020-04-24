package com.davis.mall.bean;

import java.util.List;

/**
 * @author 王阳
 * @time 2019/11/16  22:36
 * @desc
 */
public class LoginBean {


    /**
     * ret : 200
     * data : {"err_code":0,"err_msg":"","total":1,"list":[{"id":2,"uuid":"","add_time":"2019-11-13 18:45:45","update_time":null,"ext_data":null,"user_id":"0","phone":"13422222222","username":"admin","nick_name":"ad","is_admin":1,"pass_word":"000000"}],"page":1,"perpage":10}
     * msg : 当前小白接口：App.Table.FreeQuery
     */

    private int ret;
    private DataBean data;
    private String msg;

    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static class DataBean {
        /**
         * err_code : 0
         * err_msg :
         * total : 1
         * list : [{"id":2,"uuid":"","add_time":"2019-11-13 18:45:45","update_time":null,"ext_data":null,"user_id":"0","phone":"13422222222","username":"admin","nick_name":"ad","is_admin":1,"pass_word":"000000"}]
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
             * id : 2
             * uuid :
             * add_time : 2019-11-13 18:45:45
             * update_time : null
             * ext_data : null
             * user_id : 0
             * phone : 13422222222
             * username : admin
             * nick_name : ad
             * is_admin : 1
             * pass_word : 000000
             */

            private int id;
            private String uuid;
            private String add_time;
            private Object update_time;
            private Object ext_data;
            private String user_id;
            private String phone;
            private String username;
            private String nick_name;
            private int is_admin;
            private String pass_word;

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

            public String getUser_id() {
                return user_id;
            }

            public void setUser_id(String user_id) {
                this.user_id = user_id;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public String getNick_name() {
                return nick_name;
            }

            public void setNick_name(String nick_name) {
                this.nick_name = nick_name;
            }

            public int getIs_admin() {
                return is_admin;
            }

            public void setIs_admin(int is_admin) {
                this.is_admin = is_admin;
            }

            public String getPass_word() {
                return pass_word;
            }

            public void setPass_word(String pass_word) {
                this.pass_word = pass_word;
            }
        }
    }
}
