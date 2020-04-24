package com.davis.mall.presenter;

import android.util.Log;

import com.davis.mall.bean.CategoryBannerBean;
import com.davis.mall.bean.CategoryBean;
import com.davis.mall.bean.CategoryMuluBean;
import com.davis.mall.interfac.IFenLeiFragment;
import com.davis.mall.network.NetClient;
import com.davis.mall.utils.JsonObjectUtil;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import rx.Observer;

/**
 * @author 王阳
 * @time 2019/11/13  21:09
 * @desc
 */
public class FenLeiFragmentPresenter extends BaseFragmentPresenter {
    private IFenLeiFragment ienLeiFragment;

    public FenLeiFragmentPresenter(IFenLeiFragment ienLeiFragment) {
        super(ienLeiFragment);
        this.ienLeiFragment = ienLeiFragment;
    }

    public void getleftRvList() {
        JSONObject jsonObject = JsonObjectUtil.getJsonObject("id", ">", "0",
                "POD_Category", "App.Table.FreeQuery");
        try {
            jsonObject.put("page", "1");
            jsonObject.put("perpage", "13");
            jsonObject.put("is_real_total", "1");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        NetClient.changeRetrofitUrlTo3().getleftRvList(jsonObject)
                .subscribe(new Observer<CategoryMuluBean>() {
                    @Override
                    public void onCompleted() {
                        Log.e("getleftRvList: ", "onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("getleftRvList: ", "onError");
                    }

                    @Override
                    public void onNext(CategoryMuluBean categoryMuluBean) {
                        Log.e("getleftRvList: ", "onNext:" + new Gson().toJson(categoryMuluBean));
                        ienLeiFragment.requestSuccess1(categoryMuluBean);
                    }
                });

    }

    public void getCategoryRightList(String categoryId) {
        JSONObject jsonObject = JsonObjectUtil.getJsonObject("id", ">", "0",
                "POD_Category", "App.Table.FreeTree");
        try {
            jsonObject.put("parent_field", "fenzhi_id");
            jsonObject.put("parent_id", categoryId);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        NetClient.changeRetrofitUrlTo3().getCategoryRightList(jsonObject)
                .subscribe(new Observer<CategoryBean>() {
                    @Override
                    public void onCompleted() {
                        Log.e("getCategoryList: ", "onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("getCategoryList: ", e.getMessage());
                    }

                    @Override
                    public void onNext(CategoryBean categoryBean) {
                        Log.e("getCategoryList: ", "onNext:" + new Gson().toJson(categoryBean));
                        ienLeiFragment.requestSuccess3(categoryBean);
                    }
                });

    }

    public void getBannerList() {
        //"App.Table.FreeQuery",NetClient.app_key, "AD_IMG_URLS",where
        JSONObject jsonObject = JsonObjectUtil.getJsonObject("typeId", "=", "2",
                "AD_IMG_URLS", "App.Table.FreeQuery");

        //        String[][] where =  {{"typeId","=","2"}};
        //         String whereNew ="[['typeId','=','2']]";
        NetClient.changeRetrofitUrlTo3().getCategoryBannerList(jsonObject)
                .subscribe(new Observer<CategoryBannerBean>() {
                    @Override
                    public void onCompleted() {
                        Log.e("getBannerList: ", "onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("getBannerList: ", "onError");
                    }

                    @Override
                    public void onNext(CategoryBannerBean categoryBannerBean) {
                        Log.e("getBannerList: ", "onNext:" + new Gson().toJson(categoryBannerBean));
                        ienLeiFragment.requestSuccess2(categoryBannerBean);
                    }
                });

    }
}
