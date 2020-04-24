package com.davis.mall.bean;

import java.util.List;

/**
 * @author 王阳
 * @time 2019/12/24  0:27
 * @desc
 */
public class PODDetaliBean extends BaseObjectEntity<PODDetaliBean.DataBean> {

    /**
     * ret : 200
     * data : {"err_code":0,"err_msg":"","total":34,"list":[{"id":1,"uuid":"","add_time":"2019-12-19 05:52:29","update_time":"2019-12-25 17:37:22","ext_data":null,"cate_id":1111111,"bannerImages":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053342_3ada5e4491d5dd877a2526d51680b2cb.jpeg#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053353_af6cd79d54f532a4c8005bb4aa907009.jpeg#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053358_3bffcf9ad52b6c9bf1e8a3b07fbf8438.jpeg#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053404_4c1e63e543debb40f670095cd9923ac8.jpeg#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053411_0f6d2aceebfd69bddfaff80c00b74173.jpeg#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053418_068684ea4d9666e5a7cfd989acc82545.jpeg","namepod":"花花公子2019冬季新款羽绒服男士立领短款轻薄羽绒袄中青年商务休闲防寒保暖上衣男装时尚百搭外套爸爸装","price":468,"favNum":999,"ifBaoyou":"免邮费","coupon":"上衣","brandName":"花花公子","brandIcon":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219054755_c18f62af3095c44d8fab64b5f51a51e9.jpeg","pod_colors":"黑色#墨绿色#咸菜色#上青色#亮青色#红色","pod_kuanxin":"963#972#966# 972# 963#963","pod_chima":"170#175#180#185#190#195","youhui_card":"满59减2","youhui_morepod":"满2件，总价打9折；满3件，总价打8折","pod_detail_img":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225114903_3b5ae17213f0b57b3a46d7a981e73ad3.png#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225114920_3f6f12030cce4a8b162906c71e92af88.png#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225114912_579d8a3e30ef29abe67cf7002a7899a1.png","guige_cansu":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225114954_580a26fd970e242b24a5240b2f06a48a.png","baozhuang_shouhou":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225114959_1bd2766f14ec4755e253953b2c99ce20.png","advice_degree":0,"zekou_fuwu":"","pingpai_id":0,"store_name":"","store_id":0,"sold_num":0},{"id":2,"uuid":"","add_time":"2019-12-25 16:26:05","update_time":"2019-12-25 17:38:04","ext_data":null,"cate_id":1111112,"bannerImages":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225162053_c3ba36f1e6ab168c816bf434be04c6fc.png#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225162100_f045d107e940d7ecaab28acfdf5c2691.png#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225162107_b782ab57f25aeef7c3d56ff6e639aad5.png#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225162113_0bf975c57e41b94c33b7c34518b14fa3.png","namepod":"花花公子毛衣男保暖秋冬季韩版修身休闲加绒加厚针织衫男士圆领毛线衣服饰长袖t恤男装潮牌青年学生毛衫","price":139,"favNum":3012,"ifBaoyou":"免邮费","coupon":"上衣","brandName":"花花公子","brandIcon":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219054755_c18f62af3095c44d8fab64b5f51a51e9.jpeg","pod_colors":"白色#酒红色#灰色#黑色","pod_kuanxin":"963#972#966#972","pod_chima":"M#L#XL#2XL#3XL","youhui_card":"满99减5","youhui_morepod":"满2件，总价打9折；满3件，总价打8折","pod_detail_img":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225162243_99b7f16c34808c6e2631b228384e286d.png#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225162248_3f3aac1fb973ee4230858214869362bd.png#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225162256_234d87dbc13e649f7fac85e8519ba95e.png","guige_cansu":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225114954_580a26fd970e242b24a5240b2f06a48a.png","baozhuang_shouhou":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225114959_1bd2766f14ec4755e253953b2c99ce20.png","advice_degree":0,"zekou_fuwu":"","pingpai_id":0,"store_name":"","store_id":0,"sold_num":0},{"id":3,"uuid":"","add_time":"2019-12-25 16:39:08","update_time":"2019-12-25 17:41:41","ext_data":null,"cate_id":1111113,"bannerImages":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225163156_93a30b8a321d38bd3af97d35c02977db.png#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225163205_17f39be83ee6d8b6fe756dd9609941d9.png#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225163215_9add6ace3d53e278220036903286bc3c.png","namepod":"裤子男韩版潮流秋冬季薄款九分休闲宽松加绒加厚保暖直筒束脚9分cargo潮牌工装裤","price":148,"favNum":45,"ifBaoyou":"免邮费","coupon":"裤子","brandName":"男韩版","brandIcon":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219054755_c18f62af3095c44d8fab64b5f51a51e9.jpeg","pod_colors":"深绿色#白色#黑色","pod_kuanxin":"250#8541#5147","pod_chima":"170#175#180#185#190#195","youhui_card":"满100减9","youhui_morepod":"满2件，总价打9折；满3件，总价打8折","pod_detail_img":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225163755_12ce40fcafc0153d65ec49399e2185af.png#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225163800_dfab7e2c33cd22f404e7020dadc2adec.png#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225163804_a53a12ac762af1fe3c90b9ec9d1e0913.png#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225163811_695fb82c35caba294a78b40b9cf7e5ff.png#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225163816_42536c7b09e02b1008e241a9db3e1f05.png","guige_cansu":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225114954_580a26fd970e242b24a5240b2f06a48a.png","baozhuang_shouhou":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225114959_1bd2766f14ec4755e253953b2c99ce20.png","advice_degree":0,"zekou_fuwu":"","pingpai_id":0,"store_name":"","store_id":0,"sold_num":0},{"id":4,"uuid":"","add_time":"2019-12-25 16:42:11","update_time":"2019-12-25 17:41:52","ext_data":null,"cate_id":1111114,"bannerImages":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225163156_93a30b8a321d38bd3af97d35c02977db.png#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225163205_17f39be83ee6d8b6fe756dd9609941d9.png#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225163215_9add6ace3d53e278220036903286bc3c.png","namepod":"裤子男韩版潮流秋冬季薄款九分休闲宽松加绒加厚保暖直筒束脚9分cargo潮牌工装裤","price":148,"favNum":45,"ifBaoyou":"免邮费","coupon":"裤子","brandName":"男韩版","brandIcon":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219054755_c18f62af3095c44d8fab64b5f51a51e9.jpeg","pod_colors":"深绿色#白色#黑色","pod_kuanxin":"250#8541#5147","pod_chima":"170#175#180#185#190#195","youhui_card":"满100减9","youhui_morepod":"满2件，总价打9折；满3件，总价打8折","pod_detail_img":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225163755_12ce40fcafc0153d65ec49399e2185af.png#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225163800_dfab7e2c33cd22f404e7020dadc2adec.png#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225163804_a53a12ac762af1fe3c90b9ec9d1e0913.png#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225163811_695fb82c35caba294a78b40b9cf7e5ff.png#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225163816_42536c7b09e02b1008e241a9db3e1f05.png","guige_cansu":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225114954_580a26fd970e242b24a5240b2f06a48a.png","baozhuang_shouhou":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225114959_1bd2766f14ec4755e253953b2c99ce20.png","advice_degree":0,"zekou_fuwu":"","pingpai_id":0,"store_name":"","store_id":0,"sold_num":0},{"id":5,"uuid":"","add_time":"2019-12-25 16:44:11","update_time":"2019-12-25 17:42:02","ext_data":null,"cate_id":1111115,"bannerImages":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053342_3ada5e4491d5dd877a2526d51680b2cb.jpeg#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053353_af6cd79d54f532a4c8005bb4aa907009.jpeg#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053358_3bffcf9ad52b6c9bf1e8a3b07fbf8438.jpeg#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053404_4c1e63e543debb40f670095cd9923ac8.jpeg#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053411_0f6d2aceebfd69bddfaff80c00b74173.jpeg#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053418_068684ea4d9666e5a7cfd989acc82545.jpeg","namepod":"花花公子2019冬季新款羽绒服男士立领短款轻薄羽绒袄中青年商务休闲防寒保暖上衣男装时尚百搭外套爸爸装","price":468,"favNum":999,"ifBaoyou":"免邮费","coupon":"上衣","brandName":"花花公子","brandIcon":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219054755_c18f62af3095c44d8fab64b5f51a51e9.jpeg","pod_colors":"黑色#墨绿色#咸菜色#上青色#亮青色#红色","pod_kuanxin":"963#972#966# 972# 963#963","pod_chima":"170#175#180#185#190#195","youhui_card":"满59减2","youhui_morepod":"满2件，总价打9折；满3件，总价打8折","pod_detail_img":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225114903_3b5ae17213f0b57b3a46d7a981e73ad3.png#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225114920_3f6f12030cce4a8b162906c71e92af88.png#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225114912_579d8a3e30ef29abe67cf7002a7899a1.png","guige_cansu":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225114954_580a26fd970e242b24a5240b2f06a48a.png","baozhuang_shouhou":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225114959_1bd2766f14ec4755e253953b2c99ce20.png","advice_degree":0,"zekou_fuwu":"","pingpai_id":0,"store_name":"","store_id":0,"sold_num":0},{"id":6,"uuid":"","add_time":"2019-12-25 16:50:05","update_time":"2019-12-25 17:42:12","ext_data":null,"cate_id":1111116,"bannerImages":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053342_3ada5e4491d5dd877a2526d51680b2cb.jpeg#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053353_af6cd79d54f532a4c8005bb4aa907009.jpeg#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053358_3bffcf9ad52b6c9bf1e8a3b07fbf8438.jpeg#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053404_4c1e63e543debb40f670095cd9923ac8.jpeg#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053411_0f6d2aceebfd69bddfaff80c00b74173.jpeg#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053418_068684ea4d9666e5a7cfd989acc82545.jpeg","namepod":"花花公子2019冬季新款羽绒服男士立领短款轻薄羽绒袄中青年商务休闲防寒保暖上衣男装时尚百搭外套爸爸装","price":468,"favNum":999,"ifBaoyou":"免邮费","coupon":"上衣","brandName":"花花公子","brandIcon":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219054755_c18f62af3095c44d8fab64b5f51a51e9.jpeg","pod_colors":"黑色#墨绿色#咸菜色#上青色#亮青色#红色","pod_kuanxin":"963#972#966# 972# 963#963","pod_chima":"170#175#180#185#190#195","youhui_card":"满59减2","youhui_morepod":"满2件，总价打9折；满3件，总价打8折","pod_detail_img":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225114903_3b5ae17213f0b57b3a46d7a981e73ad3.png#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225114920_3f6f12030cce4a8b162906c71e92af88.png#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225114912_579d8a3e30ef29abe67cf7002a7899a1.png","guige_cansu":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225114954_580a26fd970e242b24a5240b2f06a48a.png","baozhuang_shouhou":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225114959_1bd2766f14ec4755e253953b2c99ce20.png","advice_degree":0,"zekou_fuwu":"","pingpai_id":0,"store_name":"","store_id":0,"sold_num":0},{"id":7,"uuid":"","add_time":"2019-12-25 16:50:08","update_time":"2019-12-25 17:42:22","ext_data":null,"cate_id":1111117,"bannerImages":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053342_3ada5e4491d5dd877a2526d51680b2cb.jpeg#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053353_af6cd79d54f532a4c8005bb4aa907009.jpeg#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053358_3bffcf9ad52b6c9bf1e8a3b07fbf8438.jpeg#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053404_4c1e63e543debb40f670095cd9923ac8.jpeg#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053411_0f6d2aceebfd69bddfaff80c00b74173.jpeg#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053418_068684ea4d9666e5a7cfd989acc82545.jpeg","namepod":"花花公子2019冬季新款羽绒服男士立领短款轻薄羽绒袄中青年商务休闲防寒保暖上衣男装时尚百搭外套爸爸装","price":468,"favNum":999,"ifBaoyou":"免邮费","coupon":"上衣","brandName":"花花公子","brandIcon":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219054755_c18f62af3095c44d8fab64b5f51a51e9.jpeg","pod_colors":"黑色#墨绿色#咸菜色#上青色#亮青色#红色","pod_kuanxin":"963#972#966# 972# 963#963","pod_chima":"170#175#180#185#190#195","youhui_card":"满59减2","youhui_morepod":"满2件，总价打9折；满3件，总价打8折","pod_detail_img":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225114903_3b5ae17213f0b57b3a46d7a981e73ad3.png#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225114920_3f6f12030cce4a8b162906c71e92af88.png#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225114912_579d8a3e30ef29abe67cf7002a7899a1.png","guige_cansu":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225114954_580a26fd970e242b24a5240b2f06a48a.png","baozhuang_shouhou":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225114959_1bd2766f14ec4755e253953b2c99ce20.png","advice_degree":0,"zekou_fuwu":"","pingpai_id":0,"store_name":"","store_id":0,"sold_num":0},{"id":8,"uuid":"","add_time":"2019-12-25 16:50:11","update_time":"2019-12-25 17:42:31","ext_data":null,"cate_id":1111118,"bannerImages":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053342_3ada5e4491d5dd877a2526d51680b2cb.jpeg#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053353_af6cd79d54f532a4c8005bb4aa907009.jpeg#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053358_3bffcf9ad52b6c9bf1e8a3b07fbf8438.jpeg#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053404_4c1e63e543debb40f670095cd9923ac8.jpeg#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053411_0f6d2aceebfd69bddfaff80c00b74173.jpeg#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053418_068684ea4d9666e5a7cfd989acc82545.jpeg","namepod":"花花公子2019冬季新款羽绒服男士立领短款轻薄羽绒袄中青年商务休闲防寒保暖上衣男装时尚百搭外套爸爸装","price":468,"favNum":999,"ifBaoyou":"免邮费","coupon":"上衣","brandName":"花花公子","brandIcon":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219054755_c18f62af3095c44d8fab64b5f51a51e9.jpeg","pod_colors":"黑色#墨绿色#咸菜色#上青色#亮青色#红色","pod_kuanxin":"963#972#966# 972# 963#963","pod_chima":"170#175#180#185#190#195","youhui_card":"满59减2","youhui_morepod":"满2件，总价打9折；满3件，总价打8折","pod_detail_img":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225114903_3b5ae17213f0b57b3a46d7a981e73ad3.png#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225114920_3f6f12030cce4a8b162906c71e92af88.png#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225114912_579d8a3e30ef29abe67cf7002a7899a1.png","guige_cansu":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225114954_580a26fd970e242b24a5240b2f06a48a.png","baozhuang_shouhou":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225114959_1bd2766f14ec4755e253953b2c99ce20.png","advice_degree":0,"zekou_fuwu":"","pingpai_id":0,"store_name":"","store_id":0,"sold_num":0},{"id":9,"uuid":"","add_time":"2019-12-25 16:50:16","update_time":"2019-12-25 17:42:42","ext_data":null,"cate_id":1111119,"bannerImages":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053342_3ada5e4491d5dd877a2526d51680b2cb.jpeg#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053353_af6cd79d54f532a4c8005bb4aa907009.jpeg#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053358_3bffcf9ad52b6c9bf1e8a3b07fbf8438.jpeg#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053404_4c1e63e543debb40f670095cd9923ac8.jpeg#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053411_0f6d2aceebfd69bddfaff80c00b74173.jpeg#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053418_068684ea4d9666e5a7cfd989acc82545.jpeg","namepod":"花花公子2019冬季新款羽绒服男士立领短款轻薄羽绒袄中青年商务休闲防寒保暖上衣男装时尚百搭外套爸爸装","price":468,"favNum":999,"ifBaoyou":"免邮费","coupon":"上衣","brandName":"花花公子","brandIcon":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219054755_c18f62af3095c44d8fab64b5f51a51e9.jpeg","pod_colors":"黑色#墨绿色#咸菜色#上青色#亮青色#红色","pod_kuanxin":"963#972#966# 972# 963#963","pod_chima":"170#175#180#185#190#195","youhui_card":"满59减2","youhui_morepod":"满2件，总价打9折；满3件，总价打8折","pod_detail_img":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225114903_3b5ae17213f0b57b3a46d7a981e73ad3.png#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225114920_3f6f12030cce4a8b162906c71e92af88.png#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225114912_579d8a3e30ef29abe67cf7002a7899a1.png","guige_cansu":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225114954_580a26fd970e242b24a5240b2f06a48a.png","baozhuang_shouhou":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225114959_1bd2766f14ec4755e253953b2c99ce20.png","advice_degree":0,"zekou_fuwu":"","pingpai_id":0,"store_name":"","store_id":0,"sold_num":0},{"id":10,"uuid":"","add_time":"2019-12-25 16:50:18","update_time":"2019-12-25 17:42:51","ext_data":null,"cate_id":1111120,"bannerImages":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053342_3ada5e4491d5dd877a2526d51680b2cb.jpeg#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053353_af6cd79d54f532a4c8005bb4aa907009.jpeg#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053358_3bffcf9ad52b6c9bf1e8a3b07fbf8438.jpeg#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053404_4c1e63e543debb40f670095cd9923ac8.jpeg#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053411_0f6d2aceebfd69bddfaff80c00b74173.jpeg#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053418_068684ea4d9666e5a7cfd989acc82545.jpeg","namepod":"花花公子2019冬季新款羽绒服男士立领短款轻薄羽绒袄中青年商务休闲防寒保暖上衣男装时尚百搭外套爸爸装","price":468,"favNum":999,"ifBaoyou":"免邮费","coupon":"上衣","brandName":"花花公子","brandIcon":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219054755_c18f62af3095c44d8fab64b5f51a51e9.jpeg","pod_colors":"黑色#墨绿色#咸菜色#上青色#亮青色#红色","pod_kuanxin":"963#972#966# 972# 963#963","pod_chima":"170#175#180#185#190#195","youhui_card":"满59减2","youhui_morepod":"满2件，总价打9折；满3件，总价打8折","pod_detail_img":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225114903_3b5ae17213f0b57b3a46d7a981e73ad3.png#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225114920_3f6f12030cce4a8b162906c71e92af88.png#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225114912_579d8a3e30ef29abe67cf7002a7899a1.png","guige_cansu":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225114954_580a26fd970e242b24a5240b2f06a48a.png","baozhuang_shouhou":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225114959_1bd2766f14ec4755e253953b2c99ce20.png","advice_degree":0,"zekou_fuwu":"","pingpai_id":0,"store_name":"","store_id":0,"sold_num":0}],"page":1,"perpage":10}
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
         * total : 34
         * list : [{"id":1,"uuid":"","add_time":"2019-12-19 05:52:29","update_time":"2019-12-25 17:37:22","ext_data":null,"cate_id":1111111,"bannerImages":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053342_3ada5e4491d5dd877a2526d51680b2cb.jpeg#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053353_af6cd79d54f532a4c8005bb4aa907009.jpeg#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053358_3bffcf9ad52b6c9bf1e8a3b07fbf8438.jpeg#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053404_4c1e63e543debb40f670095cd9923ac8.jpeg#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053411_0f6d2aceebfd69bddfaff80c00b74173.jpeg#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053418_068684ea4d9666e5a7cfd989acc82545.jpeg","namepod":"花花公子2019冬季新款羽绒服男士立领短款轻薄羽绒袄中青年商务休闲防寒保暖上衣男装时尚百搭外套爸爸装","price":468,"favNum":999,"ifBaoyou":"免邮费","coupon":"上衣","brandName":"花花公子","brandIcon":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219054755_c18f62af3095c44d8fab64b5f51a51e9.jpeg","pod_colors":"黑色#墨绿色#咸菜色#上青色#亮青色#红色","pod_kuanxin":"963#972#966# 972# 963#963","pod_chima":"170#175#180#185#190#195","youhui_card":"满59减2","youhui_morepod":"满2件，总价打9折；满3件，总价打8折","pod_detail_img":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225114903_3b5ae17213f0b57b3a46d7a981e73ad3.png#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225114920_3f6f12030cce4a8b162906c71e92af88.png#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225114912_579d8a3e30ef29abe67cf7002a7899a1.png","guige_cansu":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225114954_580a26fd970e242b24a5240b2f06a48a.png","baozhuang_shouhou":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225114959_1bd2766f14ec4755e253953b2c99ce20.png","advice_degree":0,"zekou_fuwu":"","pingpai_id":0,"store_name":"","store_id":0,"sold_num":0},{"id":2,"uuid":"","add_time":"2019-12-25 16:26:05","update_time":"2019-12-25 17:38:04","ext_data":null,"cate_id":1111112,"bannerImages":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225162053_c3ba36f1e6ab168c816bf434be04c6fc.png#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225162100_f045d107e940d7ecaab28acfdf5c2691.png#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225162107_b782ab57f25aeef7c3d56ff6e639aad5.png#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225162113_0bf975c57e41b94c33b7c34518b14fa3.png","namepod":"花花公子毛衣男保暖秋冬季韩版修身休闲加绒加厚针织衫男士圆领毛线衣服饰长袖t恤男装潮牌青年学生毛衫","price":139,"favNum":3012,"ifBaoyou":"免邮费","coupon":"上衣","brandName":"花花公子","brandIcon":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219054755_c18f62af3095c44d8fab64b5f51a51e9.jpeg","pod_colors":"白色#酒红色#灰色#黑色","pod_kuanxin":"963#972#966#972","pod_chima":"M#L#XL#2XL#3XL","youhui_card":"满99减5","youhui_morepod":"满2件，总价打9折；满3件，总价打8折","pod_detail_img":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225162243_99b7f16c34808c6e2631b228384e286d.png#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225162248_3f3aac1fb973ee4230858214869362bd.png#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225162256_234d87dbc13e649f7fac85e8519ba95e.png","guige_cansu":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225114954_580a26fd970e242b24a5240b2f06a48a.png","baozhuang_shouhou":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225114959_1bd2766f14ec4755e253953b2c99ce20.png","advice_degree":0,"zekou_fuwu":"","pingpai_id":0,"store_name":"","store_id":0,"sold_num":0},{"id":3,"uuid":"","add_time":"2019-12-25 16:39:08","update_time":"2019-12-25 17:41:41","ext_data":null,"cate_id":1111113,"bannerImages":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225163156_93a30b8a321d38bd3af97d35c02977db.png#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225163205_17f39be83ee6d8b6fe756dd9609941d9.png#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225163215_9add6ace3d53e278220036903286bc3c.png","namepod":"裤子男韩版潮流秋冬季薄款九分休闲宽松加绒加厚保暖直筒束脚9分cargo潮牌工装裤","price":148,"favNum":45,"ifBaoyou":"免邮费","coupon":"裤子","brandName":"男韩版","brandIcon":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219054755_c18f62af3095c44d8fab64b5f51a51e9.jpeg","pod_colors":"深绿色#白色#黑色","pod_kuanxin":"250#8541#5147","pod_chima":"170#175#180#185#190#195","youhui_card":"满100减9","youhui_morepod":"满2件，总价打9折；满3件，总价打8折","pod_detail_img":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225163755_12ce40fcafc0153d65ec49399e2185af.png#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225163800_dfab7e2c33cd22f404e7020dadc2adec.png#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225163804_a53a12ac762af1fe3c90b9ec9d1e0913.png#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225163811_695fb82c35caba294a78b40b9cf7e5ff.png#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225163816_42536c7b09e02b1008e241a9db3e1f05.png","guige_cansu":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225114954_580a26fd970e242b24a5240b2f06a48a.png","baozhuang_shouhou":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225114959_1bd2766f14ec4755e253953b2c99ce20.png","advice_degree":0,"zekou_fuwu":"","pingpai_id":0,"store_name":"","store_id":0,"sold_num":0},{"id":4,"uuid":"","add_time":"2019-12-25 16:42:11","update_time":"2019-12-25 17:41:52","ext_data":null,"cate_id":1111114,"bannerImages":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225163156_93a30b8a321d38bd3af97d35c02977db.png#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225163205_17f39be83ee6d8b6fe756dd9609941d9.png#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225163215_9add6ace3d53e278220036903286bc3c.png","namepod":"裤子男韩版潮流秋冬季薄款九分休闲宽松加绒加厚保暖直筒束脚9分cargo潮牌工装裤","price":148,"favNum":45,"ifBaoyou":"免邮费","coupon":"裤子","brandName":"男韩版","brandIcon":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219054755_c18f62af3095c44d8fab64b5f51a51e9.jpeg","pod_colors":"深绿色#白色#黑色","pod_kuanxin":"250#8541#5147","pod_chima":"170#175#180#185#190#195","youhui_card":"满100减9","youhui_morepod":"满2件，总价打9折；满3件，总价打8折","pod_detail_img":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225163755_12ce40fcafc0153d65ec49399e2185af.png#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225163800_dfab7e2c33cd22f404e7020dadc2adec.png#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225163804_a53a12ac762af1fe3c90b9ec9d1e0913.png#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225163811_695fb82c35caba294a78b40b9cf7e5ff.png#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225163816_42536c7b09e02b1008e241a9db3e1f05.png","guige_cansu":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225114954_580a26fd970e242b24a5240b2f06a48a.png","baozhuang_shouhou":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225114959_1bd2766f14ec4755e253953b2c99ce20.png","advice_degree":0,"zekou_fuwu":"","pingpai_id":0,"store_name":"","store_id":0,"sold_num":0},{"id":5,"uuid":"","add_time":"2019-12-25 16:44:11","update_time":"2019-12-25 17:42:02","ext_data":null,"cate_id":1111115,"bannerImages":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053342_3ada5e4491d5dd877a2526d51680b2cb.jpeg#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053353_af6cd79d54f532a4c8005bb4aa907009.jpeg#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053358_3bffcf9ad52b6c9bf1e8a3b07fbf8438.jpeg#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053404_4c1e63e543debb40f670095cd9923ac8.jpeg#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053411_0f6d2aceebfd69bddfaff80c00b74173.jpeg#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053418_068684ea4d9666e5a7cfd989acc82545.jpeg","namepod":"花花公子2019冬季新款羽绒服男士立领短款轻薄羽绒袄中青年商务休闲防寒保暖上衣男装时尚百搭外套爸爸装","price":468,"favNum":999,"ifBaoyou":"免邮费","coupon":"上衣","brandName":"花花公子","brandIcon":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219054755_c18f62af3095c44d8fab64b5f51a51e9.jpeg","pod_colors":"黑色#墨绿色#咸菜色#上青色#亮青色#红色","pod_kuanxin":"963#972#966# 972# 963#963","pod_chima":"170#175#180#185#190#195","youhui_card":"满59减2","youhui_morepod":"满2件，总价打9折；满3件，总价打8折","pod_detail_img":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225114903_3b5ae17213f0b57b3a46d7a981e73ad3.png#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225114920_3f6f12030cce4a8b162906c71e92af88.png#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225114912_579d8a3e30ef29abe67cf7002a7899a1.png","guige_cansu":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225114954_580a26fd970e242b24a5240b2f06a48a.png","baozhuang_shouhou":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225114959_1bd2766f14ec4755e253953b2c99ce20.png","advice_degree":0,"zekou_fuwu":"","pingpai_id":0,"store_name":"","store_id":0,"sold_num":0},{"id":6,"uuid":"","add_time":"2019-12-25 16:50:05","update_time":"2019-12-25 17:42:12","ext_data":null,"cate_id":1111116,"bannerImages":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053342_3ada5e4491d5dd877a2526d51680b2cb.jpeg#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053353_af6cd79d54f532a4c8005bb4aa907009.jpeg#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053358_3bffcf9ad52b6c9bf1e8a3b07fbf8438.jpeg#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053404_4c1e63e543debb40f670095cd9923ac8.jpeg#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053411_0f6d2aceebfd69bddfaff80c00b74173.jpeg#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053418_068684ea4d9666e5a7cfd989acc82545.jpeg","namepod":"花花公子2019冬季新款羽绒服男士立领短款轻薄羽绒袄中青年商务休闲防寒保暖上衣男装时尚百搭外套爸爸装","price":468,"favNum":999,"ifBaoyou":"免邮费","coupon":"上衣","brandName":"花花公子","brandIcon":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219054755_c18f62af3095c44d8fab64b5f51a51e9.jpeg","pod_colors":"黑色#墨绿色#咸菜色#上青色#亮青色#红色","pod_kuanxin":"963#972#966# 972# 963#963","pod_chima":"170#175#180#185#190#195","youhui_card":"满59减2","youhui_morepod":"满2件，总价打9折；满3件，总价打8折","pod_detail_img":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225114903_3b5ae17213f0b57b3a46d7a981e73ad3.png#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225114920_3f6f12030cce4a8b162906c71e92af88.png#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225114912_579d8a3e30ef29abe67cf7002a7899a1.png","guige_cansu":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225114954_580a26fd970e242b24a5240b2f06a48a.png","baozhuang_shouhou":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225114959_1bd2766f14ec4755e253953b2c99ce20.png","advice_degree":0,"zekou_fuwu":"","pingpai_id":0,"store_name":"","store_id":0,"sold_num":0},{"id":7,"uuid":"","add_time":"2019-12-25 16:50:08","update_time":"2019-12-25 17:42:22","ext_data":null,"cate_id":1111117,"bannerImages":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053342_3ada5e4491d5dd877a2526d51680b2cb.jpeg#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053353_af6cd79d54f532a4c8005bb4aa907009.jpeg#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053358_3bffcf9ad52b6c9bf1e8a3b07fbf8438.jpeg#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053404_4c1e63e543debb40f670095cd9923ac8.jpeg#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053411_0f6d2aceebfd69bddfaff80c00b74173.jpeg#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053418_068684ea4d9666e5a7cfd989acc82545.jpeg","namepod":"花花公子2019冬季新款羽绒服男士立领短款轻薄羽绒袄中青年商务休闲防寒保暖上衣男装时尚百搭外套爸爸装","price":468,"favNum":999,"ifBaoyou":"免邮费","coupon":"上衣","brandName":"花花公子","brandIcon":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219054755_c18f62af3095c44d8fab64b5f51a51e9.jpeg","pod_colors":"黑色#墨绿色#咸菜色#上青色#亮青色#红色","pod_kuanxin":"963#972#966# 972# 963#963","pod_chima":"170#175#180#185#190#195","youhui_card":"满59减2","youhui_morepod":"满2件，总价打9折；满3件，总价打8折","pod_detail_img":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225114903_3b5ae17213f0b57b3a46d7a981e73ad3.png#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225114920_3f6f12030cce4a8b162906c71e92af88.png#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225114912_579d8a3e30ef29abe67cf7002a7899a1.png","guige_cansu":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225114954_580a26fd970e242b24a5240b2f06a48a.png","baozhuang_shouhou":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225114959_1bd2766f14ec4755e253953b2c99ce20.png","advice_degree":0,"zekou_fuwu":"","pingpai_id":0,"store_name":"","store_id":0,"sold_num":0},{"id":8,"uuid":"","add_time":"2019-12-25 16:50:11","update_time":"2019-12-25 17:42:31","ext_data":null,"cate_id":1111118,"bannerImages":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053342_3ada5e4491d5dd877a2526d51680b2cb.jpeg#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053353_af6cd79d54f532a4c8005bb4aa907009.jpeg#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053358_3bffcf9ad52b6c9bf1e8a3b07fbf8438.jpeg#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053404_4c1e63e543debb40f670095cd9923ac8.jpeg#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053411_0f6d2aceebfd69bddfaff80c00b74173.jpeg#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053418_068684ea4d9666e5a7cfd989acc82545.jpeg","namepod":"花花公子2019冬季新款羽绒服男士立领短款轻薄羽绒袄中青年商务休闲防寒保暖上衣男装时尚百搭外套爸爸装","price":468,"favNum":999,"ifBaoyou":"免邮费","coupon":"上衣","brandName":"花花公子","brandIcon":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219054755_c18f62af3095c44d8fab64b5f51a51e9.jpeg","pod_colors":"黑色#墨绿色#咸菜色#上青色#亮青色#红色","pod_kuanxin":"963#972#966# 972# 963#963","pod_chima":"170#175#180#185#190#195","youhui_card":"满59减2","youhui_morepod":"满2件，总价打9折；满3件，总价打8折","pod_detail_img":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225114903_3b5ae17213f0b57b3a46d7a981e73ad3.png#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225114920_3f6f12030cce4a8b162906c71e92af88.png#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225114912_579d8a3e30ef29abe67cf7002a7899a1.png","guige_cansu":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225114954_580a26fd970e242b24a5240b2f06a48a.png","baozhuang_shouhou":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225114959_1bd2766f14ec4755e253953b2c99ce20.png","advice_degree":0,"zekou_fuwu":"","pingpai_id":0,"store_name":"","store_id":0,"sold_num":0},{"id":9,"uuid":"","add_time":"2019-12-25 16:50:16","update_time":"2019-12-25 17:42:42","ext_data":null,"cate_id":1111119,"bannerImages":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053342_3ada5e4491d5dd877a2526d51680b2cb.jpeg#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053353_af6cd79d54f532a4c8005bb4aa907009.jpeg#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053358_3bffcf9ad52b6c9bf1e8a3b07fbf8438.jpeg#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053404_4c1e63e543debb40f670095cd9923ac8.jpeg#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053411_0f6d2aceebfd69bddfaff80c00b74173.jpeg#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053418_068684ea4d9666e5a7cfd989acc82545.jpeg","namepod":"花花公子2019冬季新款羽绒服男士立领短款轻薄羽绒袄中青年商务休闲防寒保暖上衣男装时尚百搭外套爸爸装","price":468,"favNum":999,"ifBaoyou":"免邮费","coupon":"上衣","brandName":"花花公子","brandIcon":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219054755_c18f62af3095c44d8fab64b5f51a51e9.jpeg","pod_colors":"黑色#墨绿色#咸菜色#上青色#亮青色#红色","pod_kuanxin":"963#972#966# 972# 963#963","pod_chima":"170#175#180#185#190#195","youhui_card":"满59减2","youhui_morepod":"满2件，总价打9折；满3件，总价打8折","pod_detail_img":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225114903_3b5ae17213f0b57b3a46d7a981e73ad3.png#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225114920_3f6f12030cce4a8b162906c71e92af88.png#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225114912_579d8a3e30ef29abe67cf7002a7899a1.png","guige_cansu":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225114954_580a26fd970e242b24a5240b2f06a48a.png","baozhuang_shouhou":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225114959_1bd2766f14ec4755e253953b2c99ce20.png","advice_degree":0,"zekou_fuwu":"","pingpai_id":0,"store_name":"","store_id":0,"sold_num":0},{"id":10,"uuid":"","add_time":"2019-12-25 16:50:18","update_time":"2019-12-25 17:42:51","ext_data":null,"cate_id":1111120,"bannerImages":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053342_3ada5e4491d5dd877a2526d51680b2cb.jpeg#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053353_af6cd79d54f532a4c8005bb4aa907009.jpeg#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053358_3bffcf9ad52b6c9bf1e8a3b07fbf8438.jpeg#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053404_4c1e63e543debb40f670095cd9923ac8.jpeg#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053411_0f6d2aceebfd69bddfaff80c00b74173.jpeg#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053418_068684ea4d9666e5a7cfd989acc82545.jpeg","namepod":"花花公子2019冬季新款羽绒服男士立领短款轻薄羽绒袄中青年商务休闲防寒保暖上衣男装时尚百搭外套爸爸装","price":468,"favNum":999,"ifBaoyou":"免邮费","coupon":"上衣","brandName":"花花公子","brandIcon":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219054755_c18f62af3095c44d8fab64b5f51a51e9.jpeg","pod_colors":"黑色#墨绿色#咸菜色#上青色#亮青色#红色","pod_kuanxin":"963#972#966# 972# 963#963","pod_chima":"170#175#180#185#190#195","youhui_card":"满59减2","youhui_morepod":"满2件，总价打9折；满3件，总价打8折","pod_detail_img":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225114903_3b5ae17213f0b57b3a46d7a981e73ad3.png#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225114920_3f6f12030cce4a8b162906c71e92af88.png#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225114912_579d8a3e30ef29abe67cf7002a7899a1.png","guige_cansu":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225114954_580a26fd970e242b24a5240b2f06a48a.png","baozhuang_shouhou":"http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225114959_1bd2766f14ec4755e253953b2c99ce20.png","advice_degree":0,"zekou_fuwu":"","pingpai_id":0,"store_name":"","store_id":0,"sold_num":0}]
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
             * add_time : 2019-12-19 05:52:29
             * update_time : 2019-12-25 17:37:22
             * ext_data : null
             * cate_id : 1111111
             * bannerImages : http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053342_3ada5e4491d5dd877a2526d51680b2cb.jpeg#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053353_af6cd79d54f532a4c8005bb4aa907009.jpeg#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053358_3bffcf9ad52b6c9bf1e8a3b07fbf8438.jpeg#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053404_4c1e63e543debb40f670095cd9923ac8.jpeg#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053411_0f6d2aceebfd69bddfaff80c00b74173.jpeg#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219053418_068684ea4d9666e5a7cfd989acc82545.jpeg
             * namepod : 花花公子2019冬季新款羽绒服男士立领短款轻薄羽绒袄中青年商务休闲防寒保暖上衣男装时尚百搭外套爸爸装
             * price : 468
             * favNum : 999
             * ifBaoyou : 免邮费
             * coupon : 上衣
             * brandName : 花花公子
             * brandIcon : http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191219054755_c18f62af3095c44d8fab64b5f51a51e9.jpeg
             * pod_colors : 黑色#墨绿色#咸菜色#上青色#亮青色#红色
             * pod_kuanxin : 963#972#966# 972# 963#963
             * pod_chima : 170#175#180#185#190#195
             * youhui_card : 满59减2
             * youhui_morepod : 满2件，总价打9折；满3件，总价打8折
             * pod_detail_img : http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225114903_3b5ae17213f0b57b3a46d7a981e73ad3.png#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225114920_3f6f12030cce4a8b162906c71e92af88.png#http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225114912_579d8a3e30ef29abe67cf7002a7899a1.png
             * guige_cansu : http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225114954_580a26fd970e242b24a5240b2f06a48a.png
             * baozhuang_shouhou : http://cd7.yesapi.net/1F58A9F3A5E17014A4B21972CA1A165B_20191225114959_1bd2766f14ec4755e253953b2c99ce20.png
             * advice_degree : 0
             * zekou_fuwu :
             * pingpai_id : 0
             * store_name :
             * store_id : 0
             * sold_num : 0
             * youhui_type
             */

            private int id;
            private String uuid;
            private String add_time;
            private String update_time;
            private Object ext_data;
            private int cate_id;
            private String bannerImages;
            private String namepod;
            private int price;
            private int favNum;
            private String ifBaoyou;
            private String coupon;
            private String brandName;
            private String brandIcon;
            private String pod_colors;
            private String pod_kuanxin;
            private String pod_chima;
            private String youhui_card;
            private String youhui_morepod;
            private String pod_detail_img;
            private String guige_cansu;
            private String baozhuang_shouhou;
            private int advice_degree;
            private String zekou_fuwu;
            private int pingpai_id;
            private String store_name;
            private int store_id;
            private int sold_num;
            private int upload_time;
            private int youhui_type;

            public int getYouhui_type() {
                return youhui_type;
            }

            public void setYouhui_type(int youhui_type) {
                this.youhui_type = youhui_type;
            }

            public int getupload_time() {
                return upload_time;
            }

            public void setupload_time(int upload_time) {
                this.upload_time = upload_time;
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

            public int getCate_id() {
                return cate_id;
            }

            public void setCate_id(int cate_id) {
                this.cate_id = cate_id;
            }

            public String getBannerImages() {
                return bannerImages;
            }

            public void setBannerImages(String bannerImages) {
                this.bannerImages = bannerImages;
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

            public int getFavNum() {
                return favNum;
            }

            public void setFavNum(int favNum) {
                this.favNum = favNum;
            }

            public String getIfBaoyou() {
                return ifBaoyou;
            }

            public void setIfBaoyou(String ifBaoyou) {
                this.ifBaoyou = ifBaoyou;
            }

            public String getCoupon() {
                return coupon;
            }

            public void setCoupon(String coupon) {
                this.coupon = coupon;
            }

            public String getBrandName() {
                return brandName;
            }

            public void setBrandName(String brandName) {
                this.brandName = brandName;
            }

            public String getBrandIcon() {
                return brandIcon;
            }

            public void setBrandIcon(String brandIcon) {
                this.brandIcon = brandIcon;
            }

            public String getPod_colors() {
                return pod_colors;
            }

            public void setPod_colors(String pod_colors) {
                this.pod_colors = pod_colors;
            }

            public String getPod_kuanxin() {
                return pod_kuanxin;
            }

            public void setPod_kuanxin(String pod_kuanxin) {
                this.pod_kuanxin = pod_kuanxin;
            }

            public String getPod_chima() {
                return pod_chima;
            }

            public void setPod_chima(String pod_chima) {
                this.pod_chima = pod_chima;
            }

            public String getYouhui_card() {
                return youhui_card;
            }

            public void setYouhui_card(String youhui_card) {
                this.youhui_card = youhui_card;
            }

            public String getYouhui_morepod() {
                return youhui_morepod;
            }

            public void setYouhui_morepod(String youhui_morepod) {
                this.youhui_morepod = youhui_morepod;
            }

            public String getPod_detail_img() {
                return pod_detail_img;
            }

            public void setPod_detail_img(String pod_detail_img) {
                this.pod_detail_img = pod_detail_img;
            }

            public String getGuige_cansu() {
                return guige_cansu;
            }

            public void setGuige_cansu(String guige_cansu) {
                this.guige_cansu = guige_cansu;
            }

            public String getBaozhuang_shouhou() {
                return baozhuang_shouhou;
            }

            public void setBaozhuang_shouhou(String baozhuang_shouhou) {
                this.baozhuang_shouhou = baozhuang_shouhou;
            }

            public int getAdvice_degree() {
                return advice_degree;
            }

            public void setAdvice_degree(int advice_degree) {
                this.advice_degree = advice_degree;
            }

            public String getZekou_fuwu() {
                return zekou_fuwu;
            }

            public void setZekou_fuwu(String zekou_fuwu) {
                this.zekou_fuwu = zekou_fuwu;
            }

            public int getPingpai_id() {
                return pingpai_id;
            }

            public void setPingpai_id(int pingpai_id) {
                this.pingpai_id = pingpai_id;
            }

            public String getStore_name() {
                return store_name;
            }

            public void setStore_name(String store_name) {
                this.store_name = store_name;
            }

            public int getStore_id() {
                return store_id;
            }

            public void setStore_id(int store_id) {
                this.store_id = store_id;
            }

            public int getSold_num() {
                return sold_num;
            }

            public void setSold_num(int sold_num) {
                this.sold_num = sold_num;
            }
        }
    }
}
