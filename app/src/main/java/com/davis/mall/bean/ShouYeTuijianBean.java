package com.davis.mall.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author 王阳
 * @time 2019/11/9  4:31
 * @desc
 */
public class ShouYeTuijianBean extends BaseObjectEntity<ShouYeTuijianBean.DataBean>{


    /**
     * ret : 200
     * data : {"err_code":0,"err_msg":"","tree":[{"id":1,"uuid":"","add_time":"2019-12-16 23:34:31","update_time":"2019-12-16 23:44:34","ext_data":null,"description":"最后一波粉丝福利","h5Url":"http://www.xiangqu.com/shopping/banner/index?id=694","image":"http://xqproduct.xiangqu.com/Fre342GeQH8mTkYIVvjdEIIBF0fk?imageView2/2/w/800/q/90/format/jpg/960x615/","items_id":3115926,"mainname":"告别季优惠大放送","title":"限时折扣","parent_id":0,"brandName":"","cate_id":0,"keyword":"","originalPrice":0,"price":"","children_tree":[{"id":5,"uuid":"","add_time":"2019-12-17 01:31:30","update_time":"2019-12-17 02:16:11","ext_data":null,"description":"","h5Url":"","image":"http://xqproduct.xiangqu.com/Fr4qmHsSvXrGKYRwB_vP-2F8bPMh?imageView2/2/w/240/q/90/format/jpg/540x540/","items_id":0,"mainname":"","title":"","parent_id":1,"brandName":"想去优选","cate_id":3115926,"keyword":"加拿大 \\u2022 限时折扣","originalPrice":39,"price":"36"},{"id":6,"uuid":"","add_time":"2019-12-17 01:32:51","update_time":"2019-12-17 02:16:23","ext_data":null,"description":"","h5Url":"","image":"http://xqproduct.xiangqu.com/FigdwSMwnBppgcDiQI_k6aDw8qaE?imageView2/2/w/240/q/90/format/jpg/491x540/","items_id":0,"mainname":"","title":"","parent_id":1,"brandName":"想去优选","cate_id":3113607,"keyword":"礼盒 \\u2022 韩国","originalPrice":39,"price":"27.3"}]},{"id":7,"uuid":"","add_time":"2019-12-17 01:34:02","update_time":null,"ext_data":null,"description":"木质美学，提升家居格调，让生活回归自然味道","h5Url":"http://www.xiangqu.com/shopping/banner/index?id=691","image":"http://xqproduct.xiangqu.com/Fj8s3BkFo4YTXHe3Q2Jo2KEb2f0o?imageView2/2/w/800/q/90/format/jpg/960x615/","items_id":691,"mainname":"生活回归自然的味道","title":"木质美学","parent_id":0,"brandName":"","cate_id":0,"keyword":"","originalPrice":0,"price":"","children_tree":[{"id":8,"uuid":"","add_time":"2019-12-17 01:34:45","update_time":"2019-12-17 02:16:47","ext_data":null,"description":"","h5Url":"","image":"http://xqproduct.xiangqu.com/FsjtpI5UyHABKFMJSRaCgX-u9k5w?imageView2/2/w/240/q/90/format/jpg/800x800/","items_id":0,"mainname":"","title":"","parent_id":7,"brandName":"良木传奇","cate_id":3096737,"keyword":"挂衣钩 \\u2022 衣帽钩","originalPrice":18,"price":"17"},{"id":9,"uuid":"","add_time":"2019-12-17 01:36:28","update_time":"2019-12-17 02:17:03","ext_data":null,"description":"","h5Url":"","image":"http://xqproduct.xiangqu.com/FqLLLnEalq9DkjT2Gxh_OIAZiKNV?imageView2/2/w/240/q/90/format/jpg/800x800/","items_id":0,"mainname":"","title":"","parent_id":7,"brandName":"良木传奇","cate_id":3057755,"keyword":"花架 \\u2022 架子","originalPrice":109,"price":"99"},{"id":10,"uuid":"","add_time":"2019-12-17 01:37:15","update_time":"2019-12-17 02:17:15","ext_data":null,"description":"","h5Url":"","image":"http://xqproduct.xiangqu.com/FnLnMJOaM3K2x_QggvoFSwUfDDTK?imageView2/2/w/240/q/90/format/jpg/800x800/","items_id":0,"mainname":"","title":"","parent_id":7,"brandName":"木说","cate_id":3132452,"keyword":"面包 \\u2022 工具","originalPrice":11.9,"price":"11.9"},{"id":11,"uuid":"","add_time":"2019-12-17 01:37:54","update_time":"2019-12-17 02:17:23","ext_data":null,"description":"","h5Url":"","image":"http://xqproduct.xiangqu.com/Fq70ntCAgKeayAlmRjm1-CAztIcn?imageView2/2/w/240/q/90/format/jpg/800x800/","items_id":0,"mainname":"","title":"","parent_id":7,"brandName":"良木传奇","cate_id":3057762,"keyword":"凳子 \\u2022 矮凳","originalPrice":298,"price":"255"},{"id":12,"uuid":"","add_time":"2019-12-17 01:38:27","update_time":"2019-12-17 02:17:30","ext_data":null,"description":"","h5Url":"","image":"http://xqproduct.xiangqu.com/FqtGRlnx4xzih5xhkx2DF9lorT-9?imageView2/2/w/240/q/90/format/jpg/800x800/","items_id":0,"mainname":"","title":"","parent_id":7,"brandName":"木说","cate_id":3132383,"keyword":"厨具 \\u2022 木勺\"","originalPrice":21,"price":"21"},{"id":13,"uuid":"","add_time":"2019-12-17 01:39:20","update_time":"2019-12-17 02:17:38","ext_data":null,"description":"","h5Url":"","image":"http://xqproduct.xiangqu.com/FozHlAtIl9-gaQ19z78E70yHI0IF?imageView2/2/w/240/q/90/format/jpg/800x800/","items_id":0,"mainname":"","title":"","parent_id":7,"brandName":"良木传奇","cate_id":3057592,"keyword":"支架 \\u2022 手机","originalPrice":16.8,"price":"16.8"},{"id":14,"uuid":"","add_time":"2019-12-17 01:39:56","update_time":"2019-12-17 02:17:46","ext_data":null,"description":"","h5Url":"","image":"http://xqproduct.xiangqu.com/FuINMXHkUkq0A-1Tm4o3hmMZ7r3I?imageView2/2/w/240/q/90/format/jpg/800x800/","items_id":0,"mainname":"","title":"","parent_id":7,"brandName":"木说","cate_id":3124592,"keyword":"储物罐 \\u2022 收纳罐","originalPrice":22.8,"price":"22.8"},{"id":15,"uuid":"","add_time":"2019-12-17 01:40:28","update_time":"2019-12-17 02:17:55","ext_data":null,"description":"","h5Url":"","image":"http://xqproduct.xiangqu.com/FvY6CE1AopAdkJaPXWh7ADzB8m1D?imageView2/2/w/240/q/90/format/jpg/800x800/","items_id":0,"mainname":"","title":"","parent_id":7,"brandName":"良木传奇","cate_id":3057759,"keyword":"书桌 \\u2022 茶几","originalPrice":498,"price":"435"},{"id":16,"uuid":"","add_time":"2019-12-17 01:40:58","update_time":"2019-12-17 02:18:07","ext_data":null,"description":"","h5Url":"","image":"http://xqproduct.xiangqu.com/Foy5M8kxy1PlCtvsDLJGpu5mIzWB?imageView2/2/w/240/q/90/format/jpg/800x800/","items_id":0,"mainname":"","title":"","parent_id":7,"brandName":"梵瀚生活创意","cate_id":3106631,"keyword":"茶叶罐 \\u2022 木质","originalPrice":107,"price":"99"},{"id":17,"uuid":"","add_time":"2019-12-17 01:41:42","update_time":"2019-12-17 02:18:15","ext_data":null,"description":"","h5Url":"","image":"http://xqproduct.xiangqu.com/Fu3Kp5UWd6rWes4i3bmg8kyPadY7?imageView2/2/w/240/q/90/format/jpg/800x800/","items_id":0,"mainname":"","title":"","parent_id":7,"brandName":"梵瀚生活创意","cate_id":3097522,"keyword":"音箱 \\u2022 手机","originalPrice":59,"price":"49"}]},{"id":18,"uuid":"","add_time":"2019-12-17 01:42:54","update_time":null,"ext_data":null,"description":"手机壳的\\u201c毒\\u201d你知道么？越漂亮越毒！","h5Url":"http://www.xiangqu.com/shopping/banner/index?id=672","image":"http://xqproduct.xiangqu.com/FqroKRay8iBB3qbprJPJFs-OaPpL?imageView2/2/w/800/q/90/format/jpg/960x615/","items_id":672,"mainname":"有趣的人 连手机壳都不一样","title":"时髦不撞款","parent_id":0,"brandName":"","cate_id":0,"keyword":"","originalPrice":0,"price":"","children_tree":[{"id":19,"uuid":"","add_time":"2019-12-17 01:43:33","update_time":"2019-12-17 02:18:47","ext_data":null,"description":"","h5Url":"","image":"http://xqproduct.xiangqu.com/Flzx7G89GojI7xNLBRJZCJydh6iS?imageView2/2/w/240/q/90/format/jpg/748x748/","items_id":0,"mainname":"","title":"","parent_id":18,"brandName":"Cerulean","cate_id":3137320,"keyword":"苹果手机壳 \\u2022 水果","originalPrice":19.9,"price":"19.9"},{"id":20,"uuid":"","add_time":"2019-12-17 01:44:17","update_time":"2019-12-17 02:18:57","ext_data":null,"description":"","h5Url":"","image":"http://xqproduct.xiangqu.com/FgrXnAtghs563v2Nv4--nnktd0LA?imageView2/2/w/240/q/90/format/jpg/800x800/","items_id":0,"mainname":"","title":"","parent_id":18,"brandName":"Cerulean","cate_id":3135617,"keyword":"手机壳 \\u2022 包","originalPrice":35,"price":"35"},{"id":21,"uuid":"","add_time":"2019-12-17 01:45:12","update_time":"2019-12-17 02:19:07","ext_data":null,"description":"","h5Url":"","image":"http://xqproduct.xiangqu.com/FgL4sweQoclrrwxcy4ZNUKeAMrEq?imageView2/2/w/240/q/90/format/jpg/748x748/","items_id":0,"mainname":"","title":"","parent_id":18,"brandName":"Cerulean","cate_id":3137319,"keyword":"苹果手机壳 \\u2022 几何","originalPrice":19.9,"price":"19.9"},{"id":22,"uuid":"","add_time":"2019-12-17 01:45:45","update_time":"2019-12-17 02:19:16","ext_data":null,"description":"","h5Url":"","image":"http://xqproduct.xiangqu.com/FsvyUYNZ6XOB8FJrtu6luVBkWmNg?imageView2/2/w/240/q/90/format/jpg/700x700/","items_id":0,"mainname":"","title":"","parent_id":18,"brandName":"东西出品原创环保袋","cate_id":3127709,"keyword":"手机壳 \\u2022 包","originalPrice":27.3,"price":"27.3"},{"id":23,"uuid":"","add_time":"2019-12-17 01:46:19","update_time":"2019-12-17 02:19:25","ext_data":null,"description":"","h5Url":"","image":"http://xqproduct.xiangqu.com/FsoBTpAteeeOAeKGDT1vwtw78w4Y?imageView2/2/w/240/q/90/format/jpg/750x750/","items_id":0,"mainname":"","title":"","parent_id":18,"brandName":"Cerulean","cate_id":3135686,"keyword":"指环 \\u2022 手机壳","originalPrice":29.9,"price":"29.9"},{"id":24,"uuid":"","add_time":"2019-12-17 01:46:58","update_time":"2019-12-17 02:19:35","ext_data":null,"description":"","h5Url":"","image":"http://xqproduct.xiangqu.com/FqFgrHuGJf7qhI3aG-RMWKIqNWjc?imageView2/2/w/240/q/90/format/jpg/999x999/","items_id":0,"mainname":"","title":"","parent_id":18,"brandName":"东西出品原创环保袋","cate_id":3127711,"keyword":"手机壳 \\u2022 包","originalPrice":31.2,"price":"31.2"},{"id":25,"uuid":"","add_time":"2019-12-17 01:47:31","update_time":"2019-12-17 02:19:45","ext_data":null,"description":"","h5Url":"","image":"http://xqproduct.xiangqu.com/Fiin9gwK8f_rMqbYYV1GSityuH6F?imageView2/2/w/240/q/90/format/jpg/800x800/","items_id":0,"mainname":"","title":"","parent_id":18,"brandName":"yufuu渔夫原创","cate_id":3128544,"keyword":"插画 \\u2022 手机壳","originalPrice":33,"price":"29"},{"id":26,"uuid":"","add_time":"2019-12-17 01:48:17","update_time":"2019-12-17 02:19:54","ext_data":null,"description":"","h5Url":"","image":"http://xqproduct.xiangqu.com/FpN_eBghIa86Hn1BpM-GCPx_HjYk?imageView2/2/w/240/q/90/format/jpg/1200x1200/","items_id":0,"mainname":"","title":"","parent_id":18,"brandName":"yufuu渔夫原创","cate_id":3124771,"keyword":"插画 \\u2022 苹果","originalPrice":33,"price":"25"},{"id":27,"uuid":"","add_time":"2019-12-17 01:50:39","update_time":"2019-12-17 02:20:04","ext_data":null,"description":"","h5Url":"","image":"http://xqproduct.xiangqu.com/FjfMilN5hEe9jEPZP8BTR4Fis90D?imageView2/2/w/240/q/90/format/jpg/1200x1200/","items_id":0,"mainname":"","title":"","parent_id":18,"brandName":"yufuu渔夫原创","cate_id":3124772,"keyword":"插画 \\u2022 苹果","originalPrice":33,"price":"29"}]},{"id":28,"uuid":"","add_time":"2019-12-17 01:51:37","update_time":null,"ext_data":null,"description":"选一盏灯，犹如房间的滤镜","h5Url":"http://www.xiangqu.com/shopping/banner/index?id=563","image":"http://xqproduct.xiangqu.com/Fg2NrDC3R7k8DMFMbzB5bJpZDSWc?imageView2/2/w/800/q/90/format/jpg/960x615/","items_id":563,"mainname":"美颜效果不止一点点","title":"灯~灯~灯~灯~灯灯","parent_id":0,"brandName":"","cate_id":0,"keyword":"","originalPrice":0,"price":"","children_tree":[{"id":29,"uuid":"","add_time":"2019-12-17 01:52:20","update_time":"2019-12-17 02:20:20","ext_data":null,"description":"","h5Url":"","image":"http://xqproduct.xiangqu.com/Fk5HO4Vacj55mLudKX_PeDnBXJvw?imageView2/2/w/240/q/90/format/jpg/800x800/","items_id":0,"mainname":"","title":"","parent_id":28,"brandName":"意品造物","cate_id":3134941,"keyword":"创意台灯 \\u2022 卡通","originalPrice":169,"price":"169"},{"id":30,"uuid":"","add_time":"2019-12-17 01:52:59","update_time":"2019-12-17 02:20:29","ext_data":null,"description":"","h5Url":"","image":"http://xqproduct.xiangqu.com/Fomxqg809Q6HnmqP6anliXnQL81Y?imageView2/2/w/240/q/90/format/jpg/800x800/","items_id":0,"mainname":"","title":"","parent_id":28,"brandName":"意品造物","cate_id":3134957,"keyword":"落地灯 \\u2022 创意","originalPrice":460,"price":"440"},{"id":31,"uuid":"","add_time":"2019-12-17 01:53:39","update_time":"2019-12-17 02:20:38","ext_data":null,"description":"","h5Url":"","image":"http://xqproduct.xiangqu.com/Fp66fRRrMDOAFQ_js5WpmXd2uhua?imageView2/2/w/240/q/90/format/jpg/800x800/","items_id":0,"mainname":"","title":"","parent_id":28,"brandName":"漫之绘","cate_id":3055345,"keyword":"灯 \\u2022 妈妈","originalPrice":98,"price":"98"},{"id":32,"uuid":"","add_time":"2019-12-17 01:54:12","update_time":"2019-12-17 02:20:47","ext_data":null,"description":"","h5Url":"","image":"http://xqproduct.xiangqu.com/Fg6uQeYWnP3QAZe-p1mHgn8zCWCK?imageView2/2/w/240/q/90/format/jpg/800x800/","items_id":0,"mainname":"","title":"","parent_id":28,"brandName":"依雯然","cate_id":3050379,"keyword":"摆件 \\u2022 灯","originalPrice":159,"price":"159"},{"id":33,"uuid":"","add_time":"2019-12-17 01:54:54","update_time":"2019-12-17 02:20:54","ext_data":null,"description":"","h5Url":"","image":"http://xqproduct.xiangqu.com/FqpzQ4SRlLfll2QuGfbEd0zUvpYu?imageView2/2/w/240/q/90/format/jpg/800x800/","items_id":0,"mainname":"","title":"","parent_id":28,"brandName":"叁杉初品","cate_id":2536921,"keyword":"夜灯 \\u2022 道具","originalPrice":28,"price":"28"},{"id":34,"uuid":"","add_time":"2019-12-17 01:55:27","update_time":"2019-12-17 02:21:02","ext_data":null,"description":"","h5Url":"","image":"http://xqproduct.xiangqu.com/FrQ9K-UBrSOMIERg80HMer8A8LhK?imageView2/2/w/240/q/90/format/jpg/800x800/\"","items_id":0,"mainname":"","title":"","parent_id":28,"brandName":"智能集市","cate_id":2898295,"keyword":"灯 \\u2022 礼物","originalPrice":69,"price":"69"},{"id":35,"uuid":"","add_time":"2019-12-17 01:56:40","update_time":"2019-12-17 02:21:10","ext_data":null,"description":"","h5Url":"","image":"http://xqproduct.xiangqu.com/Fsg9L6I_4wD7gm2ahd7j-VmBeJfx?imageView2/2/w/240/q/90/format/jpg/800x800/","items_id":0,"mainname":"","title":"","parent_id":28,"brandName":"米米","cate_id":3033727,"keyword":"夜灯 \\u2022 镜","originalPrice":197,"price":"197"}]}]}
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
         * tree : [{"id":1,"uuid":"","add_time":"2019-12-16 23:34:31","update_time":"2019-12-16 23:44:34","ext_data":null,"description":"最后一波粉丝福利","h5Url":"http://www.xiangqu.com/shopping/banner/index?id=694","image":"http://xqproduct.xiangqu.com/Fre342GeQH8mTkYIVvjdEIIBF0fk?imageView2/2/w/800/q/90/format/jpg/960x615/","items_id":3115926,"mainname":"告别季优惠大放送","title":"限时折扣","parent_id":0,"brandName":"","cate_id":0,"keyword":"","originalPrice":0,"price":"","children_tree":[{"id":5,"uuid":"","add_time":"2019-12-17 01:31:30","update_time":"2019-12-17 02:16:11","ext_data":null,"description":"","h5Url":"","image":"http://xqproduct.xiangqu.com/Fr4qmHsSvXrGKYRwB_vP-2F8bPMh?imageView2/2/w/240/q/90/format/jpg/540x540/","items_id":0,"mainname":"","title":"","parent_id":1,"brandName":"想去优选","cate_id":3115926,"keyword":"加拿大 \\u2022 限时折扣","originalPrice":39,"price":"36"},{"id":6,"uuid":"","add_time":"2019-12-17 01:32:51","update_time":"2019-12-17 02:16:23","ext_data":null,"description":"","h5Url":"","image":"http://xqproduct.xiangqu.com/FigdwSMwnBppgcDiQI_k6aDw8qaE?imageView2/2/w/240/q/90/format/jpg/491x540/","items_id":0,"mainname":"","title":"","parent_id":1,"brandName":"想去优选","cate_id":3113607,"keyword":"礼盒 \\u2022 韩国","originalPrice":39,"price":"27.3"}]},{"id":7,"uuid":"","add_time":"2019-12-17 01:34:02","update_time":null,"ext_data":null,"description":"木质美学，提升家居格调，让生活回归自然味道","h5Url":"http://www.xiangqu.com/shopping/banner/index?id=691","image":"http://xqproduct.xiangqu.com/Fj8s3BkFo4YTXHe3Q2Jo2KEb2f0o?imageView2/2/w/800/q/90/format/jpg/960x615/","items_id":691,"mainname":"生活回归自然的味道","title":"木质美学","parent_id":0,"brandName":"","cate_id":0,"keyword":"","originalPrice":0,"price":"","children_tree":[{"id":8,"uuid":"","add_time":"2019-12-17 01:34:45","update_time":"2019-12-17 02:16:47","ext_data":null,"description":"","h5Url":"","image":"http://xqproduct.xiangqu.com/FsjtpI5UyHABKFMJSRaCgX-u9k5w?imageView2/2/w/240/q/90/format/jpg/800x800/","items_id":0,"mainname":"","title":"","parent_id":7,"brandName":"良木传奇","cate_id":3096737,"keyword":"挂衣钩 \\u2022 衣帽钩","originalPrice":18,"price":"17"},{"id":9,"uuid":"","add_time":"2019-12-17 01:36:28","update_time":"2019-12-17 02:17:03","ext_data":null,"description":"","h5Url":"","image":"http://xqproduct.xiangqu.com/FqLLLnEalq9DkjT2Gxh_OIAZiKNV?imageView2/2/w/240/q/90/format/jpg/800x800/","items_id":0,"mainname":"","title":"","parent_id":7,"brandName":"良木传奇","cate_id":3057755,"keyword":"花架 \\u2022 架子","originalPrice":109,"price":"99"},{"id":10,"uuid":"","add_time":"2019-12-17 01:37:15","update_time":"2019-12-17 02:17:15","ext_data":null,"description":"","h5Url":"","image":"http://xqproduct.xiangqu.com/FnLnMJOaM3K2x_QggvoFSwUfDDTK?imageView2/2/w/240/q/90/format/jpg/800x800/","items_id":0,"mainname":"","title":"","parent_id":7,"brandName":"木说","cate_id":3132452,"keyword":"面包 \\u2022 工具","originalPrice":11.9,"price":"11.9"},{"id":11,"uuid":"","add_time":"2019-12-17 01:37:54","update_time":"2019-12-17 02:17:23","ext_data":null,"description":"","h5Url":"","image":"http://xqproduct.xiangqu.com/Fq70ntCAgKeayAlmRjm1-CAztIcn?imageView2/2/w/240/q/90/format/jpg/800x800/","items_id":0,"mainname":"","title":"","parent_id":7,"brandName":"良木传奇","cate_id":3057762,"keyword":"凳子 \\u2022 矮凳","originalPrice":298,"price":"255"},{"id":12,"uuid":"","add_time":"2019-12-17 01:38:27","update_time":"2019-12-17 02:17:30","ext_data":null,"description":"","h5Url":"","image":"http://xqproduct.xiangqu.com/FqtGRlnx4xzih5xhkx2DF9lorT-9?imageView2/2/w/240/q/90/format/jpg/800x800/","items_id":0,"mainname":"","title":"","parent_id":7,"brandName":"木说","cate_id":3132383,"keyword":"厨具 \\u2022 木勺\"","originalPrice":21,"price":"21"},{"id":13,"uuid":"","add_time":"2019-12-17 01:39:20","update_time":"2019-12-17 02:17:38","ext_data":null,"description":"","h5Url":"","image":"http://xqproduct.xiangqu.com/FozHlAtIl9-gaQ19z78E70yHI0IF?imageView2/2/w/240/q/90/format/jpg/800x800/","items_id":0,"mainname":"","title":"","parent_id":7,"brandName":"良木传奇","cate_id":3057592,"keyword":"支架 \\u2022 手机","originalPrice":16.8,"price":"16.8"},{"id":14,"uuid":"","add_time":"2019-12-17 01:39:56","update_time":"2019-12-17 02:17:46","ext_data":null,"description":"","h5Url":"","image":"http://xqproduct.xiangqu.com/FuINMXHkUkq0A-1Tm4o3hmMZ7r3I?imageView2/2/w/240/q/90/format/jpg/800x800/","items_id":0,"mainname":"","title":"","parent_id":7,"brandName":"木说","cate_id":3124592,"keyword":"储物罐 \\u2022 收纳罐","originalPrice":22.8,"price":"22.8"},{"id":15,"uuid":"","add_time":"2019-12-17 01:40:28","update_time":"2019-12-17 02:17:55","ext_data":null,"description":"","h5Url":"","image":"http://xqproduct.xiangqu.com/FvY6CE1AopAdkJaPXWh7ADzB8m1D?imageView2/2/w/240/q/90/format/jpg/800x800/","items_id":0,"mainname":"","title":"","parent_id":7,"brandName":"良木传奇","cate_id":3057759,"keyword":"书桌 \\u2022 茶几","originalPrice":498,"price":"435"},{"id":16,"uuid":"","add_time":"2019-12-17 01:40:58","update_time":"2019-12-17 02:18:07","ext_data":null,"description":"","h5Url":"","image":"http://xqproduct.xiangqu.com/Foy5M8kxy1PlCtvsDLJGpu5mIzWB?imageView2/2/w/240/q/90/format/jpg/800x800/","items_id":0,"mainname":"","title":"","parent_id":7,"brandName":"梵瀚生活创意","cate_id":3106631,"keyword":"茶叶罐 \\u2022 木质","originalPrice":107,"price":"99"},{"id":17,"uuid":"","add_time":"2019-12-17 01:41:42","update_time":"2019-12-17 02:18:15","ext_data":null,"description":"","h5Url":"","image":"http://xqproduct.xiangqu.com/Fu3Kp5UWd6rWes4i3bmg8kyPadY7?imageView2/2/w/240/q/90/format/jpg/800x800/","items_id":0,"mainname":"","title":"","parent_id":7,"brandName":"梵瀚生活创意","cate_id":3097522,"keyword":"音箱 \\u2022 手机","originalPrice":59,"price":"49"}]},{"id":18,"uuid":"","add_time":"2019-12-17 01:42:54","update_time":null,"ext_data":null,"description":"手机壳的\\u201c毒\\u201d你知道么？越漂亮越毒！","h5Url":"http://www.xiangqu.com/shopping/banner/index?id=672","image":"http://xqproduct.xiangqu.com/FqroKRay8iBB3qbprJPJFs-OaPpL?imageView2/2/w/800/q/90/format/jpg/960x615/","items_id":672,"mainname":"有趣的人 连手机壳都不一样","title":"时髦不撞款","parent_id":0,"brandName":"","cate_id":0,"keyword":"","originalPrice":0,"price":"","children_tree":[{"id":19,"uuid":"","add_time":"2019-12-17 01:43:33","update_time":"2019-12-17 02:18:47","ext_data":null,"description":"","h5Url":"","image":"http://xqproduct.xiangqu.com/Flzx7G89GojI7xNLBRJZCJydh6iS?imageView2/2/w/240/q/90/format/jpg/748x748/","items_id":0,"mainname":"","title":"","parent_id":18,"brandName":"Cerulean","cate_id":3137320,"keyword":"苹果手机壳 \\u2022 水果","originalPrice":19.9,"price":"19.9"},{"id":20,"uuid":"","add_time":"2019-12-17 01:44:17","update_time":"2019-12-17 02:18:57","ext_data":null,"description":"","h5Url":"","image":"http://xqproduct.xiangqu.com/FgrXnAtghs563v2Nv4--nnktd0LA?imageView2/2/w/240/q/90/format/jpg/800x800/","items_id":0,"mainname":"","title":"","parent_id":18,"brandName":"Cerulean","cate_id":3135617,"keyword":"手机壳 \\u2022 包","originalPrice":35,"price":"35"},{"id":21,"uuid":"","add_time":"2019-12-17 01:45:12","update_time":"2019-12-17 02:19:07","ext_data":null,"description":"","h5Url":"","image":"http://xqproduct.xiangqu.com/FgL4sweQoclrrwxcy4ZNUKeAMrEq?imageView2/2/w/240/q/90/format/jpg/748x748/","items_id":0,"mainname":"","title":"","parent_id":18,"brandName":"Cerulean","cate_id":3137319,"keyword":"苹果手机壳 \\u2022 几何","originalPrice":19.9,"price":"19.9"},{"id":22,"uuid":"","add_time":"2019-12-17 01:45:45","update_time":"2019-12-17 02:19:16","ext_data":null,"description":"","h5Url":"","image":"http://xqproduct.xiangqu.com/FsvyUYNZ6XOB8FJrtu6luVBkWmNg?imageView2/2/w/240/q/90/format/jpg/700x700/","items_id":0,"mainname":"","title":"","parent_id":18,"brandName":"东西出品原创环保袋","cate_id":3127709,"keyword":"手机壳 \\u2022 包","originalPrice":27.3,"price":"27.3"},{"id":23,"uuid":"","add_time":"2019-12-17 01:46:19","update_time":"2019-12-17 02:19:25","ext_data":null,"description":"","h5Url":"","image":"http://xqproduct.xiangqu.com/FsoBTpAteeeOAeKGDT1vwtw78w4Y?imageView2/2/w/240/q/90/format/jpg/750x750/","items_id":0,"mainname":"","title":"","parent_id":18,"brandName":"Cerulean","cate_id":3135686,"keyword":"指环 \\u2022 手机壳","originalPrice":29.9,"price":"29.9"},{"id":24,"uuid":"","add_time":"2019-12-17 01:46:58","update_time":"2019-12-17 02:19:35","ext_data":null,"description":"","h5Url":"","image":"http://xqproduct.xiangqu.com/FqFgrHuGJf7qhI3aG-RMWKIqNWjc?imageView2/2/w/240/q/90/format/jpg/999x999/","items_id":0,"mainname":"","title":"","parent_id":18,"brandName":"东西出品原创环保袋","cate_id":3127711,"keyword":"手机壳 \\u2022 包","originalPrice":31.2,"price":"31.2"},{"id":25,"uuid":"","add_time":"2019-12-17 01:47:31","update_time":"2019-12-17 02:19:45","ext_data":null,"description":"","h5Url":"","image":"http://xqproduct.xiangqu.com/Fiin9gwK8f_rMqbYYV1GSityuH6F?imageView2/2/w/240/q/90/format/jpg/800x800/","items_id":0,"mainname":"","title":"","parent_id":18,"brandName":"yufuu渔夫原创","cate_id":3128544,"keyword":"插画 \\u2022 手机壳","originalPrice":33,"price":"29"},{"id":26,"uuid":"","add_time":"2019-12-17 01:48:17","update_time":"2019-12-17 02:19:54","ext_data":null,"description":"","h5Url":"","image":"http://xqproduct.xiangqu.com/FpN_eBghIa86Hn1BpM-GCPx_HjYk?imageView2/2/w/240/q/90/format/jpg/1200x1200/","items_id":0,"mainname":"","title":"","parent_id":18,"brandName":"yufuu渔夫原创","cate_id":3124771,"keyword":"插画 \\u2022 苹果","originalPrice":33,"price":"25"},{"id":27,"uuid":"","add_time":"2019-12-17 01:50:39","update_time":"2019-12-17 02:20:04","ext_data":null,"description":"","h5Url":"","image":"http://xqproduct.xiangqu.com/FjfMilN5hEe9jEPZP8BTR4Fis90D?imageView2/2/w/240/q/90/format/jpg/1200x1200/","items_id":0,"mainname":"","title":"","parent_id":18,"brandName":"yufuu渔夫原创","cate_id":3124772,"keyword":"插画 \\u2022 苹果","originalPrice":33,"price":"29"}]},{"id":28,"uuid":"","add_time":"2019-12-17 01:51:37","update_time":null,"ext_data":null,"description":"选一盏灯，犹如房间的滤镜","h5Url":"http://www.xiangqu.com/shopping/banner/index?id=563","image":"http://xqproduct.xiangqu.com/Fg2NrDC3R7k8DMFMbzB5bJpZDSWc?imageView2/2/w/800/q/90/format/jpg/960x615/","items_id":563,"mainname":"美颜效果不止一点点","title":"灯~灯~灯~灯~灯灯","parent_id":0,"brandName":"","cate_id":0,"keyword":"","originalPrice":0,"price":"","children_tree":[{"id":29,"uuid":"","add_time":"2019-12-17 01:52:20","update_time":"2019-12-17 02:20:20","ext_data":null,"description":"","h5Url":"","image":"http://xqproduct.xiangqu.com/Fk5HO4Vacj55mLudKX_PeDnBXJvw?imageView2/2/w/240/q/90/format/jpg/800x800/","items_id":0,"mainname":"","title":"","parent_id":28,"brandName":"意品造物","cate_id":3134941,"keyword":"创意台灯 \\u2022 卡通","originalPrice":169,"price":"169"},{"id":30,"uuid":"","add_time":"2019-12-17 01:52:59","update_time":"2019-12-17 02:20:29","ext_data":null,"description":"","h5Url":"","image":"http://xqproduct.xiangqu.com/Fomxqg809Q6HnmqP6anliXnQL81Y?imageView2/2/w/240/q/90/format/jpg/800x800/","items_id":0,"mainname":"","title":"","parent_id":28,"brandName":"意品造物","cate_id":3134957,"keyword":"落地灯 \\u2022 创意","originalPrice":460,"price":"440"},{"id":31,"uuid":"","add_time":"2019-12-17 01:53:39","update_time":"2019-12-17 02:20:38","ext_data":null,"description":"","h5Url":"","image":"http://xqproduct.xiangqu.com/Fp66fRRrMDOAFQ_js5WpmXd2uhua?imageView2/2/w/240/q/90/format/jpg/800x800/","items_id":0,"mainname":"","title":"","parent_id":28,"brandName":"漫之绘","cate_id":3055345,"keyword":"灯 \\u2022 妈妈","originalPrice":98,"price":"98"},{"id":32,"uuid":"","add_time":"2019-12-17 01:54:12","update_time":"2019-12-17 02:20:47","ext_data":null,"description":"","h5Url":"","image":"http://xqproduct.xiangqu.com/Fg6uQeYWnP3QAZe-p1mHgn8zCWCK?imageView2/2/w/240/q/90/format/jpg/800x800/","items_id":0,"mainname":"","title":"","parent_id":28,"brandName":"依雯然","cate_id":3050379,"keyword":"摆件 \\u2022 灯","originalPrice":159,"price":"159"},{"id":33,"uuid":"","add_time":"2019-12-17 01:54:54","update_time":"2019-12-17 02:20:54","ext_data":null,"description":"","h5Url":"","image":"http://xqproduct.xiangqu.com/FqpzQ4SRlLfll2QuGfbEd0zUvpYu?imageView2/2/w/240/q/90/format/jpg/800x800/","items_id":0,"mainname":"","title":"","parent_id":28,"brandName":"叁杉初品","cate_id":2536921,"keyword":"夜灯 \\u2022 道具","originalPrice":28,"price":"28"},{"id":34,"uuid":"","add_time":"2019-12-17 01:55:27","update_time":"2019-12-17 02:21:02","ext_data":null,"description":"","h5Url":"","image":"http://xqproduct.xiangqu.com/FrQ9K-UBrSOMIERg80HMer8A8LhK?imageView2/2/w/240/q/90/format/jpg/800x800/\"","items_id":0,"mainname":"","title":"","parent_id":28,"brandName":"智能集市","cate_id":2898295,"keyword":"灯 \\u2022 礼物","originalPrice":69,"price":"69"},{"id":35,"uuid":"","add_time":"2019-12-17 01:56:40","update_time":"2019-12-17 02:21:10","ext_data":null,"description":"","h5Url":"","image":"http://xqproduct.xiangqu.com/Fsg9L6I_4wD7gm2ahd7j-VmBeJfx?imageView2/2/w/240/q/90/format/jpg/800x800/","items_id":0,"mainname":"","title":"","parent_id":28,"brandName":"米米","cate_id":3033727,"keyword":"夜灯 \\u2022 镜","originalPrice":197,"price":"197"}]}]
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
             * id : 1
             * uuid :
             * add_time : 2019-12-16 23:34:31
             * update_time : 2019-12-16 23:44:34
             * ext_data : null
             * description : 最后一波粉丝福利
             * h5Url : http://www.xiangqu.com/shopping/banner/index?id=694
             * image : http://xqproduct.xiangqu.com/Fre342GeQH8mTkYIVvjdEIIBF0fk?imageView2/2/w/800/q/90/format/jpg/960x615/
             * items_id : 3115926
             * mainname : 告别季优惠大放送
             * title : 限时折扣
             * parent_id : 0
             * brandName :
             * cate_id : 0
             * keyword :
             * originalPrice : 0
             * price :
             * children_tree : [{"id":5,"uuid":"","add_time":"2019-12-17 01:31:30","update_time":"2019-12-17 02:16:11","ext_data":null,"description":"","h5Url":"","image":"http://xqproduct.xiangqu.com/Fr4qmHsSvXrGKYRwB_vP-2F8bPMh?imageView2/2/w/240/q/90/format/jpg/540x540/","items_id":0,"mainname":"","title":"","parent_id":1,"brandName":"想去优选","cate_id":3115926,"keyword":"加拿大 \\u2022 限时折扣","originalPrice":39,"price":"36"},{"id":6,"uuid":"","add_time":"2019-12-17 01:32:51","update_time":"2019-12-17 02:16:23","ext_data":null,"description":"","h5Url":"","image":"http://xqproduct.xiangqu.com/FigdwSMwnBppgcDiQI_k6aDw8qaE?imageView2/2/w/240/q/90/format/jpg/491x540/","items_id":0,"mainname":"","title":"","parent_id":1,"brandName":"想去优选","cate_id":3113607,"keyword":"礼盒 \\u2022 韩国","originalPrice":39,"price":"27.3"}]
             */

            private int id;
            private String uuid;
            private String add_time;
            private String update_time;
            private Object ext_data;
            private String description;
            private String h5Url;
            private String image;
            private int items_id;
            private String mainname;
            private String title;
            private int parent_id;
            private String brandName;
            private int cate_id;
            private String keyword;
            private double originalPrice;
            private String price;
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

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getH5Url() {
                return h5Url;
            }

            public void setH5Url(String h5Url) {
                this.h5Url = h5Url;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public int getItems_id() {
                return items_id;
            }

            public void setItems_id(int items_id) {
                this.items_id = items_id;
            }

            public String getMainname() {
                return mainname;
            }

            public void setMainname(String mainname) {
                this.mainname = mainname;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getParent_id() {
                return parent_id;
            }

            public void setParent_id(int parent_id) {
                this.parent_id = parent_id;
            }

            public String getBrandName() {
                return brandName;
            }

            public void setBrandName(String brandName) {
                this.brandName = brandName;
            }

            public int getCate_id() {
                return cate_id;
            }

            public void setCate_id(int cate_id) {
                this.cate_id = cate_id;
            }

            public String getKeyword() {
                return keyword;
            }

            public void setKeyword(String keyword) {
                this.keyword = keyword;
            }

            public double getOriginalPrice() {
                return originalPrice;
            }

            public void setOriginalPrice(double originalPrice) {
                this.originalPrice = originalPrice;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public List<ChildrenTreeBean> getChildren_tree() {
                return children_tree;
            }

            public void setChildren_tree(List<ChildrenTreeBean> children_tree) {
                this.children_tree = children_tree;
            }

            public static class ChildrenTreeBean {
                /**
                 * id : 5
                 * uuid :
                 * add_time : 2019-12-17 01:31:30
                 * update_time : 2019-12-17 02:16:11
                 * ext_data : null
                 * description :
                 * h5Url :
                 * image : http://xqproduct.xiangqu.com/Fr4qmHsSvXrGKYRwB_vP-2F8bPMh?imageView2/2/w/240/q/90/format/jpg/540x540/
                 * items_id : 0
                 * mainname :
                 * title :
                 * parent_id : 1
                 * brandName : 想去优选
                 * cate_id : 3115926
                 * keyword : 加拿大 \u2022 限时折扣
                 * originalPrice : 39
                 * price : 36
                 */

                private int id;
                private String uuid;
                private String add_time;
                private String update_time;
                private Object ext_data;
                private String description;
                private String h5Url;
                private String image;
                private int items_id;
                private String mainname;
                private String title;
                private int parent_id;
                private String brandName;
                private int cate_id;
                private String keyword;
                private double originalPrice;
                private String price;

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

                public String getDescription() {
                    return description;
                }

                public void setDescription(String description) {
                    this.description = description;
                }

                public String getH5Url() {
                    return h5Url;
                }

                public void setH5Url(String h5Url) {
                    this.h5Url = h5Url;
                }

                public String getImage() {
                    return image;
                }

                public void setImage(String image) {
                    this.image = image;
                }

                public int getItems_id() {
                    return items_id;
                }

                public void setItems_id(int items_id) {
                    this.items_id = items_id;
                }

                public String getMainname() {
                    return mainname;
                }

                public void setMainname(String mainname) {
                    this.mainname = mainname;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public int getParent_id() {
                    return parent_id;
                }

                public void setParent_id(int parent_id) {
                    this.parent_id = parent_id;
                }

                public String getBrandName() {
                    return brandName;
                }

                public void setBrandName(String brandName) {
                    this.brandName = brandName;
                }

                public int getCate_id() {
                    return cate_id;
                }

                public void setCate_id(int cate_id) {
                    this.cate_id = cate_id;
                }

                public String getKeyword() {
                    return keyword;
                }

                public void setKeyword(String keyword) {
                    this.keyword = keyword;
                }

                public double getOriginalPrice() {
                    return originalPrice;
                }

                public void setOriginalPrice(double originalPrice) {
                    this.originalPrice = originalPrice;
                }

                public String getPrice() {
                    return price;
                }

                public void setPrice(String price) {
                    this.price = price;
                }
            }
        }
    }
}
