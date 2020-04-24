package com.davis.mall.bean;

import java.util.List;

/**
 * @author 王阳
 * @time 2019/12/24  9:05
 * @desc
 */
public class AddressBean extends BaseObjectEntity<AddressBean.DataBean>{

    /**
     * ret : 200
     * data : {"err_code":0,"err_msg":"","total":3,"list":[{"id":1,"uuid":"","add_time":"2019-12-24 08:25:07","update_time":"2019-12-24 09:11:42","ext_data":null,"name_to":"王阳","phone_num":"13424079568","sheng":"上海市","shi":"直辖市","xian_or_qu":"宝山区","zhen":"","xiangxi_part_address":"场北路5000弄502","ifmoren":1,"sheng_ucode":"310000","shi_ucode":"310100","qu_or_xian_ucode":"310113","user_id":"0"},{"id":2,"uuid":"","add_time":"2019-12-24 08:27:30","update_time":"2019-12-24 09:11:33","ext_data":null,"name_to":"王大锤","phone_num":"15654785124","sheng":"湖北省","shi":"荆门市","xian_or_qu":"沙洋县","zhen":"","xiangxi_part_address":"桂林路3114号4#804","ifmoren":0,"sheng_ucode":"420000","shi_ucode":"420800","qu_or_xian_ucode":"420822","user_id":"0"},{"id":3,"uuid":"","add_time":"2019-12-24 08:30:56","update_time":"2019-12-24 09:11:24","ext_data":null,"name_to":"郭富城","phone_num":"18754214568","sheng":"湖南省","shi":"长沙市","xian_or_qu":"芙蓉区","zhen":"","xiangxi_part_address":"诸葛正我路555号","ifmoren":0,"sheng_ucode":"430000","shi_ucode":"430100","qu_or_xian_ucode":"430102","user_id":"0"}],"page":1,"perpage":10}
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
         * list : [{"id":1,"uuid":"","add_time":"2019-12-24 08:25:07","update_time":"2019-12-24 09:11:42","ext_data":null,"name_to":"王阳","phone_num":"13424079568","sheng":"上海市","shi":"直辖市","xian_or_qu":"宝山区","zhen":"","xiangxi_part_address":"场北路5000弄502","ifmoren":1,"sheng_ucode":"310000","shi_ucode":"310100","qu_or_xian_ucode":"310113","user_id":"0"},{"id":2,"uuid":"","add_time":"2019-12-24 08:27:30","update_time":"2019-12-24 09:11:33","ext_data":null,"name_to":"王大锤","phone_num":"15654785124","sheng":"湖北省","shi":"荆门市","xian_or_qu":"沙洋县","zhen":"","xiangxi_part_address":"桂林路3114号4#804","ifmoren":0,"sheng_ucode":"420000","shi_ucode":"420800","qu_or_xian_ucode":"420822","user_id":"0"},{"id":3,"uuid":"","add_time":"2019-12-24 08:30:56","update_time":"2019-12-24 09:11:24","ext_data":null,"name_to":"郭富城","phone_num":"18754214568","sheng":"湖南省","shi":"长沙市","xian_or_qu":"芙蓉区","zhen":"","xiangxi_part_address":"诸葛正我路555号","ifmoren":0,"sheng_ucode":"430000","shi_ucode":"430100","qu_or_xian_ucode":"430102","user_id":"0"}]
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
             * add_time : 2019-12-24 08:25:07
             * update_time : 2019-12-24 09:11:42
             * ext_data : null
             * name_to : 王阳
             * phone_num : 13424079568
             * sheng : 上海市
             * shi : 直辖市
             * xian_or_qu : 宝山区
             * zhen :
             * xiangxi_part_address : 场北路5000弄502
             * ifmoren : 1
             * sheng_ucode : 310000
             * shi_ucode : 310100
             * qu_or_xian_ucode : 310113
             * user_id : 0
             */

            private int id;
            private String uuid;
            private String add_time;
            private String update_time;
            private Object ext_data;
            private String name_to;
            private String phone_num;
            private String sheng;
            private String shi;
            private String xian_or_qu;
            private String zhen;
            private String xiangxi_part_address;
            private int ifmoren;
            private String sheng_ucode;
            private String shi_ucode;
            private String qu_or_xian_ucode;
            private String user_id;

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

            public String getName_to() {
                return name_to;
            }

            public void setName_to(String name_to) {
                this.name_to = name_to;
            }

            public String getPhone_num() {
                return phone_num;
            }

            public void setPhone_num(String phone_num) {
                this.phone_num = phone_num;
            }

            public String getSheng() {
                return sheng;
            }

            public void setSheng(String sheng) {
                this.sheng = sheng;
            }

            public String getShi() {
                return shi;
            }

            public void setShi(String shi) {
                this.shi = shi;
            }

            public String getXian_or_qu() {
                return xian_or_qu;
            }

            public void setXian_or_qu(String xian_or_qu) {
                this.xian_or_qu = xian_or_qu;
            }

            public String getZhen() {
                return zhen;
            }

            public void setZhen(String zhen) {
                this.zhen = zhen;
            }

            public String getXiangxi_part_address() {
                return xiangxi_part_address;
            }

            public void setXiangxi_part_address(String xiangxi_part_address) {
                this.xiangxi_part_address = xiangxi_part_address;
            }

            public int getIfmoren() {
                return ifmoren;
            }

            public void setIfmoren(int ifmoren) {
                this.ifmoren = ifmoren;
            }

            public String getSheng_ucode() {
                return sheng_ucode;
            }

            public void setSheng_ucode(String sheng_ucode) {
                this.sheng_ucode = sheng_ucode;
            }

            public String getShi_ucode() {
                return shi_ucode;
            }

            public void setShi_ucode(String shi_ucode) {
                this.shi_ucode = shi_ucode;
            }

            public String getQu_or_xian_ucode() {
                return qu_or_xian_ucode;
            }

            public void setQu_or_xian_ucode(String qu_or_xian_ucode) {
                this.qu_or_xian_ucode = qu_or_xian_ucode;
            }

            public String getUser_id() {
                return user_id;
            }

            public void setUser_id(String user_id) {
                this.user_id = user_id;
            }
        }
    }
}
