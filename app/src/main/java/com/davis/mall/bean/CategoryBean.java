package com.davis.mall.bean;

import java.util.List;

/**
 * @author 王阳
 * @time 2019/11/13  21:34
 * @desc
 */
public class CategoryBean extends BaseObjectEntity<CategoryBean.DataBean> {


    /**
     * ret : 200
     * data : {"err_code":0,"err_msg":"","tree":[{"id":40,"uuid":"","add_time":"2019-12-27 04:22:44","update_time":null,"ext_data":null,"first_class_id":"","second_class_id":"11","third_class_id":"","fenzhi_id":14,"first_class_name":"","second_class_name":"羽绒服","third_class_name":"","img_url":"","children_tree":[{"id":85,"uuid":"","add_time":"2019-12-27 05:00:56","update_time":null,"ext_data":null,"first_class_id":"","second_class_id":"","third_class_id":"1101","fenzhi_id":40,"first_class_name":"","second_class_name":"","third_class_name":"中长款大衣","img_url":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191227043340_43619bc209b2f06d2e42c0267930a7dc.png"},{"id":86,"uuid":"","add_time":"2019-12-27 05:00:56","update_time":null,"ext_data":null,"first_class_id":"","second_class_id":"","third_class_id":"1102","fenzhi_id":40,"first_class_name":"","second_class_name":"","third_class_name":"短款外套","img_url":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191227043348_5faa0ec2912a24705abd8a242c147a4a.png"},{"id":87,"uuid":"","add_time":"2019-12-27 05:00:56","update_time":null,"ext_data":null,"first_class_id":"","second_class_id":"","third_class_id":"1103","fenzhi_id":40,"first_class_name":"","second_class_name":"","third_class_name":"长款大衣","img_url":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191227043354_ed8053229c79ebf71e264641ce31b038.png"},{"id":88,"uuid":"","add_time":"2019-12-27 05:00:56","update_time":null,"ext_data":null,"first_class_id":"","second_class_id":"","third_class_id":"1104","fenzhi_id":40,"first_class_name":"","second_class_name":"","third_class_name":"轻薄外套","img_url":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191227043358_0796b05d004e85f42e8fb51f67ad97c3.png"},{"id":89,"uuid":"","add_time":"2019-12-27 05:00:56","update_time":null,"ext_data":null,"first_class_id":"","second_class_id":"","third_class_id":"1105","fenzhi_id":40,"first_class_name":"","second_class_name":"","third_class_name":"羽绒马甲","img_url":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191227043402_3f9228023925369af5a3c878fd830dd1.png"}]},{"id":41,"uuid":"","add_time":"2019-12-27 04:22:44","update_time":null,"ext_data":null,"first_class_id":"","second_class_id":"12","third_class_id":"","fenzhi_id":14,"first_class_name":"","second_class_name":"男士外套","third_class_name":"","img_url":"","children_tree":[{"id":90,"uuid":"","add_time":"2019-12-27 05:00:56","update_time":null,"ext_data":null,"first_class_id":"","second_class_id":"","third_class_id":"1201","fenzhi_id":41,"first_class_name":"","second_class_name":"","third_class_name":"风衣","img_url":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191227044250_c3ad370d19c83f013f8e15441d7aa2c2.png"},{"id":91,"uuid":"","add_time":"2019-12-27 05:00:56","update_time":null,"ext_data":null,"first_class_id":"","second_class_id":"","third_class_id":"1202","fenzhi_id":41,"first_class_name":"","second_class_name":"","third_class_name":"卫衣","img_url":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191227044256_a00de003f95c23df1714460c4dc113a8.png"},{"id":92,"uuid":"","add_time":"2019-12-27 05:00:56","update_time":null,"ext_data":null,"first_class_id":"","second_class_id":"","third_class_id":"1203","fenzhi_id":41,"first_class_name":"","second_class_name":"","third_class_name":"牛仔外套","img_url":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191227044302_22824397925ad2b47c5eccfe34ffb9da.png"},{"id":93,"uuid":"","add_time":"2019-12-27 05:00:56","update_time":null,"ext_data":null,"first_class_id":"","second_class_id":"","third_class_id":"1204","fenzhi_id":41,"first_class_name":"","second_class_name":"","third_class_name":"棒球服","img_url":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191227044308_3666792e45cb00f324233b94b70b3a33.png"},{"id":94,"uuid":"","add_time":"2019-12-27 05:00:56","update_time":null,"ext_data":null,"first_class_id":"","second_class_id":"","third_class_id":"1205","fenzhi_id":41,"first_class_name":"","second_class_name":"","third_class_name":"西服","img_url":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191227044315_d3cf80c167dc45f2efa337e8916c91c8.png"},{"id":95,"uuid":"","add_time":"2019-12-27 05:00:56","update_time":null,"ext_data":null,"first_class_id":"","second_class_id":"","third_class_id":"1206","fenzhi_id":41,"first_class_name":"","second_class_name":"","third_class_name":"棉服","img_url":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191227044321_c1686987dc421a1fc0d178f4ce895fd4.png"},{"id":96,"uuid":"","add_time":"2019-12-27 05:00:56","update_time":null,"ext_data":null,"first_class_id":"","second_class_id":"","third_class_id":"1207","fenzhi_id":41,"first_class_name":"","second_class_name":"","third_class_name":"毛呢大衣","img_url":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191227044327_b4b3c08d63d3b48eb12323ae0b34c867.png"},{"id":97,"uuid":"","add_time":"2019-12-27 05:00:56","update_time":null,"ext_data":null,"first_class_id":"","second_class_id":"","third_class_id":"1208","fenzhi_id":41,"first_class_name":"","second_class_name":"","third_class_name":"针织衫","img_url":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191227044340_dae1d5d10f552a80d794e11c23d90067.png"}]},{"id":42,"uuid":"","add_time":"2019-12-27 04:22:44","update_time":null,"ext_data":null,"first_class_id":"","second_class_id":"13","third_class_id":"","fenzhi_id":14,"first_class_name":"","second_class_name":"休闲裤","third_class_name":"","img_url":"","children_tree":[{"id":98,"uuid":"","add_time":"2019-12-27 05:00:56","update_time":null,"ext_data":null,"first_class_id":"","second_class_id":"","third_class_id":"1301","fenzhi_id":42,"first_class_name":"","second_class_name":"","third_class_name":"工装裤","img_url":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191227045239_92627521efb9a5b5dee11dc14a3f12b6.png"},{"id":99,"uuid":"","add_time":"2019-12-27 05:00:56","update_time":null,"ext_data":null,"first_class_id":"","second_class_id":"","third_class_id":"1302","fenzhi_id":42,"first_class_name":"","second_class_name":"","third_class_name":"束脚裤","img_url":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191227045244_c059ffa011e984f292e55f2318e6d591.png"},{"id":100,"uuid":"","add_time":"2019-12-27 05:00:56","update_time":null,"ext_data":null,"first_class_id":"","second_class_id":"","third_class_id":"1303","fenzhi_id":42,"first_class_name":"","second_class_name":"","third_class_name":"加绒裤","img_url":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191227045250_bfbf457e49ee1f2645acee0732c10a01.png"},{"id":101,"uuid":"","add_time":"2019-12-27 05:00:56","update_time":null,"ext_data":null,"first_class_id":"","second_class_id":"","third_class_id":"1304","fenzhi_id":42,"first_class_name":"","second_class_name":"","third_class_name":"哈伦裤","img_url":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191227045255_6d600a0447e5d9851a861b5227e56ba7.png"}]},{"id":43,"uuid":"","add_time":"2019-12-27 04:22:44","update_time":null,"ext_data":null,"first_class_id":"","second_class_id":"14","third_class_id":"","fenzhi_id":14,"first_class_name":"","second_class_name":"牛仔裤","third_class_name":"","img_url":"","children_tree":[{"id":102,"uuid":"","add_time":"2019-12-27 05:00:56","update_time":null,"ext_data":null,"first_class_id":"","second_class_id":"","third_class_id":"1401","fenzhi_id":43,"first_class_name":"","second_class_name":"","third_class_name":"修身牛仔","img_url":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191227045748_ad3d208a7b4dd359c454bcbc6b16841d.png"},{"id":103,"uuid":"","add_time":"2019-12-27 05:00:56","update_time":null,"ext_data":null,"first_class_id":"","second_class_id":"","third_class_id":"1402","fenzhi_id":43,"first_class_name":"","second_class_name":"","third_class_name":"加绒牛仔","img_url":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191227045753_605453e73cf69817594b79f4d86430b8.png"},{"id":104,"uuid":"","add_time":"2019-12-27 05:00:56","update_time":null,"ext_data":null,"first_class_id":"","second_class_id":"","third_class_id":"1403","fenzhi_id":43,"first_class_name":"","second_class_name":"","third_class_name":"直筒牛仔","img_url":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191227045757_9091f1a25199983a53d877428dee6220.png"},{"id":105,"uuid":"","add_time":"2019-12-27 05:00:56","update_time":null,"ext_data":null,"first_class_id":"","second_class_id":"","third_class_id":"1404","fenzhi_id":43,"first_class_name":"","second_class_name":"","third_class_name":"弹力牛仔","img_url":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191227045802_88281cf106e8297f0d8447e90d114432.png"},{"id":106,"uuid":"","add_time":"2019-12-27 05:00:56","update_time":null,"ext_data":null,"first_class_id":"","second_class_id":"","third_class_id":"1405","fenzhi_id":43,"first_class_name":"","second_class_name":"","third_class_name":"破洞牛仔","img_url":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191227045807_86b1276df47f736bffb6a990936c2a03.png"}]},{"id":44,"uuid":"","add_time":"2019-12-27 04:22:44","update_time":null,"ext_data":null,"first_class_id":"","second_class_id":"15","third_class_id":"","fenzhi_id":14,"first_class_name":"","second_class_name":"衬衫","third_class_name":"","img_url":"","children_tree":[]}]}
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
         * tree : [{"id":40,"uuid":"","add_time":"2019-12-27 04:22:44","update_time":null,"ext_data":null,"first_class_id":"","second_class_id":"11","third_class_id":"","fenzhi_id":14,"first_class_name":"","second_class_name":"羽绒服","third_class_name":"","img_url":"","children_tree":[{"id":85,"uuid":"","add_time":"2019-12-27 05:00:56","update_time":null,"ext_data":null,"first_class_id":"","second_class_id":"","third_class_id":"1101","fenzhi_id":40,"first_class_name":"","second_class_name":"","third_class_name":"中长款大衣","img_url":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191227043340_43619bc209b2f06d2e42c0267930a7dc.png"},{"id":86,"uuid":"","add_time":"2019-12-27 05:00:56","update_time":null,"ext_data":null,"first_class_id":"","second_class_id":"","third_class_id":"1102","fenzhi_id":40,"first_class_name":"","second_class_name":"","third_class_name":"短款外套","img_url":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191227043348_5faa0ec2912a24705abd8a242c147a4a.png"},{"id":87,"uuid":"","add_time":"2019-12-27 05:00:56","update_time":null,"ext_data":null,"first_class_id":"","second_class_id":"","third_class_id":"1103","fenzhi_id":40,"first_class_name":"","second_class_name":"","third_class_name":"长款大衣","img_url":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191227043354_ed8053229c79ebf71e264641ce31b038.png"},{"id":88,"uuid":"","add_time":"2019-12-27 05:00:56","update_time":null,"ext_data":null,"first_class_id":"","second_class_id":"","third_class_id":"1104","fenzhi_id":40,"first_class_name":"","second_class_name":"","third_class_name":"轻薄外套","img_url":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191227043358_0796b05d004e85f42e8fb51f67ad97c3.png"},{"id":89,"uuid":"","add_time":"2019-12-27 05:00:56","update_time":null,"ext_data":null,"first_class_id":"","second_class_id":"","third_class_id":"1105","fenzhi_id":40,"first_class_name":"","second_class_name":"","third_class_name":"羽绒马甲","img_url":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191227043402_3f9228023925369af5a3c878fd830dd1.png"}]},{"id":41,"uuid":"","add_time":"2019-12-27 04:22:44","update_time":null,"ext_data":null,"first_class_id":"","second_class_id":"12","third_class_id":"","fenzhi_id":14,"first_class_name":"","second_class_name":"男士外套","third_class_name":"","img_url":"","children_tree":[{"id":90,"uuid":"","add_time":"2019-12-27 05:00:56","update_time":null,"ext_data":null,"first_class_id":"","second_class_id":"","third_class_id":"1201","fenzhi_id":41,"first_class_name":"","second_class_name":"","third_class_name":"风衣","img_url":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191227044250_c3ad370d19c83f013f8e15441d7aa2c2.png"},{"id":91,"uuid":"","add_time":"2019-12-27 05:00:56","update_time":null,"ext_data":null,"first_class_id":"","second_class_id":"","third_class_id":"1202","fenzhi_id":41,"first_class_name":"","second_class_name":"","third_class_name":"卫衣","img_url":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191227044256_a00de003f95c23df1714460c4dc113a8.png"},{"id":92,"uuid":"","add_time":"2019-12-27 05:00:56","update_time":null,"ext_data":null,"first_class_id":"","second_class_id":"","third_class_id":"1203","fenzhi_id":41,"first_class_name":"","second_class_name":"","third_class_name":"牛仔外套","img_url":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191227044302_22824397925ad2b47c5eccfe34ffb9da.png"},{"id":93,"uuid":"","add_time":"2019-12-27 05:00:56","update_time":null,"ext_data":null,"first_class_id":"","second_class_id":"","third_class_id":"1204","fenzhi_id":41,"first_class_name":"","second_class_name":"","third_class_name":"棒球服","img_url":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191227044308_3666792e45cb00f324233b94b70b3a33.png"},{"id":94,"uuid":"","add_time":"2019-12-27 05:00:56","update_time":null,"ext_data":null,"first_class_id":"","second_class_id":"","third_class_id":"1205","fenzhi_id":41,"first_class_name":"","second_class_name":"","third_class_name":"西服","img_url":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191227044315_d3cf80c167dc45f2efa337e8916c91c8.png"},{"id":95,"uuid":"","add_time":"2019-12-27 05:00:56","update_time":null,"ext_data":null,"first_class_id":"","second_class_id":"","third_class_id":"1206","fenzhi_id":41,"first_class_name":"","second_class_name":"","third_class_name":"棉服","img_url":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191227044321_c1686987dc421a1fc0d178f4ce895fd4.png"},{"id":96,"uuid":"","add_time":"2019-12-27 05:00:56","update_time":null,"ext_data":null,"first_class_id":"","second_class_id":"","third_class_id":"1207","fenzhi_id":41,"first_class_name":"","second_class_name":"","third_class_name":"毛呢大衣","img_url":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191227044327_b4b3c08d63d3b48eb12323ae0b34c867.png"},{"id":97,"uuid":"","add_time":"2019-12-27 05:00:56","update_time":null,"ext_data":null,"first_class_id":"","second_class_id":"","third_class_id":"1208","fenzhi_id":41,"first_class_name":"","second_class_name":"","third_class_name":"针织衫","img_url":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191227044340_dae1d5d10f552a80d794e11c23d90067.png"}]},{"id":42,"uuid":"","add_time":"2019-12-27 04:22:44","update_time":null,"ext_data":null,"first_class_id":"","second_class_id":"13","third_class_id":"","fenzhi_id":14,"first_class_name":"","second_class_name":"休闲裤","third_class_name":"","img_url":"","children_tree":[{"id":98,"uuid":"","add_time":"2019-12-27 05:00:56","update_time":null,"ext_data":null,"first_class_id":"","second_class_id":"","third_class_id":"1301","fenzhi_id":42,"first_class_name":"","second_class_name":"","third_class_name":"工装裤","img_url":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191227045239_92627521efb9a5b5dee11dc14a3f12b6.png"},{"id":99,"uuid":"","add_time":"2019-12-27 05:00:56","update_time":null,"ext_data":null,"first_class_id":"","second_class_id":"","third_class_id":"1302","fenzhi_id":42,"first_class_name":"","second_class_name":"","third_class_name":"束脚裤","img_url":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191227045244_c059ffa011e984f292e55f2318e6d591.png"},{"id":100,"uuid":"","add_time":"2019-12-27 05:00:56","update_time":null,"ext_data":null,"first_class_id":"","second_class_id":"","third_class_id":"1303","fenzhi_id":42,"first_class_name":"","second_class_name":"","third_class_name":"加绒裤","img_url":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191227045250_bfbf457e49ee1f2645acee0732c10a01.png"},{"id":101,"uuid":"","add_time":"2019-12-27 05:00:56","update_time":null,"ext_data":null,"first_class_id":"","second_class_id":"","third_class_id":"1304","fenzhi_id":42,"first_class_name":"","second_class_name":"","third_class_name":"哈伦裤","img_url":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191227045255_6d600a0447e5d9851a861b5227e56ba7.png"}]},{"id":43,"uuid":"","add_time":"2019-12-27 04:22:44","update_time":null,"ext_data":null,"first_class_id":"","second_class_id":"14","third_class_id":"","fenzhi_id":14,"first_class_name":"","second_class_name":"牛仔裤","third_class_name":"","img_url":"","children_tree":[{"id":102,"uuid":"","add_time":"2019-12-27 05:00:56","update_time":null,"ext_data":null,"first_class_id":"","second_class_id":"","third_class_id":"1401","fenzhi_id":43,"first_class_name":"","second_class_name":"","third_class_name":"修身牛仔","img_url":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191227045748_ad3d208a7b4dd359c454bcbc6b16841d.png"},{"id":103,"uuid":"","add_time":"2019-12-27 05:00:56","update_time":null,"ext_data":null,"first_class_id":"","second_class_id":"","third_class_id":"1402","fenzhi_id":43,"first_class_name":"","second_class_name":"","third_class_name":"加绒牛仔","img_url":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191227045753_605453e73cf69817594b79f4d86430b8.png"},{"id":104,"uuid":"","add_time":"2019-12-27 05:00:56","update_time":null,"ext_data":null,"first_class_id":"","second_class_id":"","third_class_id":"1403","fenzhi_id":43,"first_class_name":"","second_class_name":"","third_class_name":"直筒牛仔","img_url":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191227045757_9091f1a25199983a53d877428dee6220.png"},{"id":105,"uuid":"","add_time":"2019-12-27 05:00:56","update_time":null,"ext_data":null,"first_class_id":"","second_class_id":"","third_class_id":"1404","fenzhi_id":43,"first_class_name":"","second_class_name":"","third_class_name":"弹力牛仔","img_url":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191227045802_88281cf106e8297f0d8447e90d114432.png"},{"id":106,"uuid":"","add_time":"2019-12-27 05:00:56","update_time":null,"ext_data":null,"first_class_id":"","second_class_id":"","third_class_id":"1405","fenzhi_id":43,"first_class_name":"","second_class_name":"","third_class_name":"破洞牛仔","img_url":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191227045807_86b1276df47f736bffb6a990936c2a03.png"}]},{"id":44,"uuid":"","add_time":"2019-12-27 04:22:44","update_time":null,"ext_data":null,"first_class_id":"","second_class_id":"15","third_class_id":"","fenzhi_id":14,"first_class_name":"","second_class_name":"衬衫","third_class_name":"","img_url":"","children_tree":[]}]
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
             * id : 40
             * uuid :
             * add_time : 2019-12-27 04:22:44
             * update_time : null
             * ext_data : null
             * first_class_id :
             * second_class_id : 11
             * third_class_id :
             * fenzhi_id : 14
             * first_class_name :
             * second_class_name : 羽绒服
             * third_class_name :
             * img_url :
             * children_tree : [{"id":85,"uuid":"","add_time":"2019-12-27 05:00:56","update_time":null,"ext_data":null,"first_class_id":"","second_class_id":"","third_class_id":"1101","fenzhi_id":40,"first_class_name":"","second_class_name":"","third_class_name":"中长款大衣","img_url":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191227043340_43619bc209b2f06d2e42c0267930a7dc.png"},{"id":86,"uuid":"","add_time":"2019-12-27 05:00:56","update_time":null,"ext_data":null,"first_class_id":"","second_class_id":"","third_class_id":"1102","fenzhi_id":40,"first_class_name":"","second_class_name":"","third_class_name":"短款外套","img_url":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191227043348_5faa0ec2912a24705abd8a242c147a4a.png"},{"id":87,"uuid":"","add_time":"2019-12-27 05:00:56","update_time":null,"ext_data":null,"first_class_id":"","second_class_id":"","third_class_id":"1103","fenzhi_id":40,"first_class_name":"","second_class_name":"","third_class_name":"长款大衣","img_url":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191227043354_ed8053229c79ebf71e264641ce31b038.png"},{"id":88,"uuid":"","add_time":"2019-12-27 05:00:56","update_time":null,"ext_data":null,"first_class_id":"","second_class_id":"","third_class_id":"1104","fenzhi_id":40,"first_class_name":"","second_class_name":"","third_class_name":"轻薄外套","img_url":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191227043358_0796b05d004e85f42e8fb51f67ad97c3.png"},{"id":89,"uuid":"","add_time":"2019-12-27 05:00:56","update_time":null,"ext_data":null,"first_class_id":"","second_class_id":"","third_class_id":"1105","fenzhi_id":40,"first_class_name":"","second_class_name":"","third_class_name":"羽绒马甲","img_url":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191227043402_3f9228023925369af5a3c878fd830dd1.png"}]
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
            private List<ChildrenTreeBean> children_tree;

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

            public List<ChildrenTreeBean> getChildren_tree() {
                return children_tree;
            }

            public void setChildren_tree(List<ChildrenTreeBean> children_tree) {
                this.children_tree = children_tree;
            }

            public static class ChildrenTreeBean {
                /**
                 * id : 85
                 * uuid :
                 * add_time : 2019-12-27 05:00:56
                 * update_time : null
                 * ext_data : null
                 * first_class_id :
                 * second_class_id :
                 * third_class_id : 1101
                 * fenzhi_id : 40
                 * first_class_name :
                 * second_class_name :
                 * third_class_name : 中长款大衣
                 * img_url : http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191227043340_43619bc209b2f06d2e42c0267930a7dc.png
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
}
