package com.davis.mall.network;


import com.davis.mall.bean.AddressBean;
import com.davis.mall.bean.AllFavorBean;
import com.davis.mall.bean.CategoryBannerBean;
import com.davis.mall.bean.CategoryBean;
import com.davis.mall.bean.CategoryMuluBean;
import com.davis.mall.bean.FUWUZEKOUbEAN;
import com.davis.mall.bean.GouWuCheBean;
import com.davis.mall.bean.LoginBean;
import com.davis.mall.bean.PODDetaliBean;
import com.davis.mall.bean.PingJiaBean;
import com.davis.mall.bean.PingpaiBean;
import com.davis.mall.bean.ShouYeCategoryBean;
import com.davis.mall.bean.ShouYeTuijianBean;
import com.facebook.stetho.okhttp3.StethoInterceptor;

import org.json.JSONObject;

import java.util.concurrent.TimeUnit;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author 王阳
 * @time 2019/11/9  0:57
 * @desc
 */
public class NetClient {
    public static NetClient netClient;
    public static OkHttpClient okHttpClient;
    private static RequestApi requestApi;
    private static Retrofit mRetrofit;

    public static String BASE_URL = "http://api.xiangqu.com";
    //    http://api.xiangqu.com/shopping/banner/list?key=0db6ffd00372064035ef33763dd1c61e&t=1547700576328
    public static String BASE_URL2 = "http://112.124.22.238:8081";
    public static String BASE_URL3 = "http://hb9.api.yesapi.cn";
    public static String app_key = "1F58A9F3A5E17014A4B21972CA1A165B";


    public static NetClient getInstance() {
        if (netClient == null) {
            netClient = new NetClient();
        }
        return netClient;
    }

    public NetClient() {

        reBuildOkhttpClient();

        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                //注意顺序
                //.addConverterFactory(NobodyConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
        requestApi = mRetrofit.create(RequestApi.class);

    }

    public static NetClient changeRetrofitUrlTo1() {

        reBuildOkhttpClient();

        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
        requestApi = mRetrofit.create(RequestApi.class);
        return getInstance();
    }

    public static NetClient changeRetrofitUrlTo2() {

        reBuildOkhttpClient();

        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL2)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
        requestApi = mRetrofit.create(RequestApi.class);
        return getInstance();
    }

    public static NetClient changeRetrofitUrlTo3() {

        reBuildOkhttpClient();

        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL3)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
        requestApi = mRetrofit.create(RequestApi.class);
        return getInstance();
    }
    private static void reBuildOkhttpClient(){
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        // 包含header、body数据
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder okHttpBuilder = new OkHttpClient().newBuilder()
                //添加网络拦截器
                .addNetworkInterceptor(new StethoInterceptor())
                //添加应用拦截器,http数据log，日志中打印出HTTP请求&响应数据
                .addInterceptor(loggingInterceptor)
                .connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                //设置错误重连
                .retryOnConnectionFailure(true);

        okHttpClient = okHttpBuilder.build();
    }

    public static RequestApi getRequest() {
        return getInstance().requestApi;
    }


    //用注解的方法做一个数据请求的内部接口
    public interface RequestApi {

        /**
         * 首页分类数据获取
         */
        @FormUrlEncoded
        @POST("category/out/children")
        Observable<ShouYeCategoryBean> getShouYeRecv1Data(@Field("key") String key,
                                                          @Field("t") String t);

        /**
         * 首页推荐数据获取
         */
        @FormUrlEncoded
        @POST("/")
        Observable<ShouYeTuijianBean> getShouYeRecv2Data(@Field("s") String s,
                                                         @Field("model_name") String model_name,
                                                         @Field("parent_field") String parent_field,
                                                         @Field("parent_id") int parent_id,
                                                         @Field("app_key") String app_key,
                                                         @Field("select") String select);

        /**
         * 首页大家喜欢数据获取
         */
        @POST("/")
        Observable<AllFavorBean> requestAllFavorData(@Body RequestBody data);

        /**
         * 分类获取分类列表
         * http://hb9.api.yesapi.cn/?s=App.Table.FreeQuery&app_key=1F58A9F3A5E17014A4B21972CA1A165B&model_name=AD_IMG_URLS&where=[[%22typeId%22,%22=%22,%222%22]]
         */
        //        @FormUrlEncoded
        //        @POST("/")
        //        Observable<CategoryBannerBean> getCategoryBannerList(@Field("s") String s,
        //                                                             @Field("app_key") String app_key,
        //                                                             @Field("model_name") String pageSize,
        //                                                             @Field("where") String[][] where);
        //        @FormUrlEncoded // 使用@Body时，就不要使用@FormUrlEncoded，否则会报错！
        @POST("/")
        Observable<CategoryBannerBean> getCategoryBannerList(@Body RequestBody data);

        /**
         * 登录验证
         */
        @POST("/")
        Observable<LoginBean> login(@Body RequestBody data);

        /**
         * 根据索引id获取商品详情
         * http://hb9.api.yesapi.cn/?&s=App.Table.FreeQuery&model_name=ITEM_DETAIL_TRUE&logic=and&where=[["cate_id","=","1111111"]]&app_key=1F58A9F3A5E17014A4B21972CA1A165B
         */
        @POST("/")
        Observable<PODDetaliBean> getPODDetailDataByCate_id(@Body RequestBody data);

        /**
         * 根据索引id获取商品详情
         * http://hb9.api.yesapi.cn/?&s=App.Table.FreeQuery&model_name=ITEM_DETAIL_TRUE&logic=and&where=[["cate_id","=","1111111"]]&app_key=1F58A9F3A5E17014A4B21972CA1A165B
         */
        @POST("/")
        Observable<AddressBean> getSavedAddressByUser_id(@Body RequestBody data);

        /**
         * 根据索引id获取商品详情
         * http://hb9.api.yesapi.cn/?s=App.Table.FreeQuery&model_name=POD_COMMENTS&where=[["cate_id","=","1111111"]]&page=1&perpage=5&is_real_total=1&app_key=1F58A9F3A5E17014A4B21972CA1A165B
         */
        @POST("/")
        Observable<PingJiaBean> getPingjiaByCate_id(@Body RequestBody data);
        /**
         * 获取一级分类目录
         * http://hb9.api.yesapi.cn/?s=App.Table.FreeQuery&model_name=POD_Category&logic=and&where=[["id", ">", "0"]]&page=1&perpage=13&is_real_total=1&app_key=1F58A9F3A5E17014A4B21972CA1A165B
         */
        @POST("/")
        Observable<CategoryMuluBean> getleftRvList(@Body RequestBody data);

        /**
         * 分类获取二级分类列表
         */
        @POST("/")
        Observable<CategoryBean> getCategoryRightList(@Body RequestBody data);

        /**
         * 获取商品列表
         * http://hb9.api.yesapi.cn/?s=App.Table.FreeQuery&model_name=ITEM_DETAIL_TRUE&where=%5B%5B%22coupon%22%2C+%22%3D%22%2C+%223801%22%5D%5D&page=1&perpage=10&is_real_total=1&app_key=1F58A9F3A5E17014A4B21972CA1A165B
         */
        @POST("/")
        Observable<PODDetaliBean> getPodListOrderBy(@Body RequestBody data);

        /**
         * 获取服务折扣种类
         * http://hb9.api.yesapi.cn/?s=App.Table.FreeQuery&model_name=FUWUZEKOU&where=%5B%5B%22id%22%2C+%22%3E%22%2C+%220%22%5D%5D&app_key=1F58A9F3A5E17014A4B21972CA1A165B&sign=62BC0025A11D40BDA5C1F61793FC0DCE
         */
        @POST("/")
        Observable<FUWUZEKOUbEAN> getFuwuZekouList(@Body RequestBody data);

        /**
         * 根据三级分类获取品牌
         * http://hb9.api.yesapi.cn/?s=App.Table.FreeTree&model_name=PINGPAI_MODEL&parent_field=fenzhi_id&parent_id=1&where=%5B%5B%22id%22%2C+%22%3E%22%2C+%220%22%5D%5D&app_key=1F58A9F3A5E17014A4B21972CA1A165B&sign=FE0797AD21499DEA9BC82CFD6C54BFDC
         */
        @POST("/")
        Observable<PingpaiBean> getPinpai(@Body RequestBody data);

        /**
         * 获取推荐商品列表
         * http://hb9.api.yesapi.cn/?s=App.Table.FreeTree&model_name=PINGPAI_MODEL&parent_field=fenzhi_id&parent_id=1&where=%5B%5B%22id%22%2C+%22%3E%22%2C+%220%22%5D%5D&app_key=1F58A9F3A5E17014A4B21972CA1A165B&sign=FE0797AD21499DEA9BC82CFD6C54BFDC
         */
        @POST("/")
        Observable<PODDetaliBean> getTuijianPodList(@Body RequestBody data);
        /**
         * 获取购物车列表
         * http://hb9.api.yesapi.cn/?s=App.Table.FreeQuery&model_name=SHAPPING_CAR&where=%5B%5B%22user_id%22%2C+%22%3D%22%2C+%221111111111%22%5D%5D&app_key=1F58A9F3A5E17014A4B21972CA1A165B&sign=0DE4944E5CD32C734605FF123124C833
         * */
        @POST("/")
        Observable<GouWuCheBean> requestAllGouWuChe(@Body RequestBody data);
        /**
         * 添加到购物车
         * */
        @POST("/")
        Observable<GouWuCheBean> addCar(@Body RequestBody data);

    }

    public static Observable<ShouYeCategoryBean> getShouYeRecv1Data(String key, String t) {
        return getRequest().getShouYeRecv1Data(key, t)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public static Observable<ShouYeTuijianBean> getShouYeRecv2Data
            (String s, String model_name, String parent_field, int parent_id, String app_key, String select) {
        return getRequest().getShouYeRecv2Data(s, model_name, parent_field, parent_id, app_key,select)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public static Observable<AllFavorBean> requestAllFavorData(JSONObject jsonObject) {
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"),
                jsonObject.toString());
        return getRequest().requestAllFavorData(requestBody)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public static Observable<CategoryBean> getCategoryRightList(JSONObject jsonObject) {
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"),
                jsonObject.toString());
        return getRequest().getCategoryRightList(requestBody)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public static Observable<CategoryBannerBean> getCategoryBannerList(JSONObject jsonObject) {
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"),
                jsonObject.toString());
        return getRequest().getCategoryBannerList(requestBody)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }


    public static Observable<LoginBean> login(JSONObject jsonObject) {//当参数中有数组时使用JsonObject
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"),
                jsonObject.toString());
        return getRequest().login(requestBody)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public static Observable<PODDetaliBean> getPODDetailDataByCate_id(JSONObject jsonObject) {
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"),
                jsonObject.toString());
        return getRequest().getPODDetailDataByCate_id(requestBody)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public static Observable<AddressBean> getSavedAddressByUser_id(JSONObject jsonObject) {
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"),
                jsonObject.toString());
        return getRequest().getSavedAddressByUser_id(requestBody)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public static Observable<PingJiaBean> getPingjiaByCate_id(JSONObject jsonObject) {
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"),
                jsonObject.toString());
        return getRequest().getPingjiaByCate_id(requestBody)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public static Observable<CategoryMuluBean> getleftRvList(JSONObject jsonObject) {
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"),
                jsonObject.toString());
        return getRequest().getleftRvList(requestBody)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }
    public static Observable<PODDetaliBean> getPodListOrderBy(JSONObject jsonObject) {
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"),
                jsonObject.toString());
        return getRequest().getPodListOrderBy(requestBody)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public static Observable<FUWUZEKOUbEAN> getFuwuZekouList(JSONObject jsonObject) {
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"),
                jsonObject.toString());
        return getRequest().getFuwuZekouList(requestBody)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public static Observable<PingpaiBean> getPinpai(JSONObject jsonObject) {
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"),
                jsonObject.toString());
        return getRequest().getPinpai(requestBody)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public static Observable<PODDetaliBean> getTuijianPodList(JSONObject jsonObject) {
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"),
                jsonObject.toString());
        return getRequest().getTuijianPodList(requestBody)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }
    public static Observable<GouWuCheBean> requestAllGouWuChe(JSONObject jsonObject) {
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"),
                jsonObject.toString());
        return getRequest().requestAllGouWuChe(requestBody)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }
    public static Observable<GouWuCheBean> addCar(JSONObject jsonObject) {
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"),
                jsonObject.toString());
        return getRequest().addCar(requestBody)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
