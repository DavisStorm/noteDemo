package com.davis.mall.presenter;

import android.util.Log;

import com.davis.mall.bean.ShouYeCategoryBean;
import com.davis.mall.bean.ShouYeTuijianBean;
import com.davis.mall.interfac.IShouyeFragment;
import com.davis.mall.network.NetClient;
import com.google.gson.Gson;

import rx.Observer;

/**
 * @author 王阳
 * @time 2019/11/9  0:29
 * @desc
 */
public class ShouyeFragmentPresenter extends BaseFragmentPresenter {
    public IShouyeFragment imvp;
    public ShouyeFragmentPresenter(IShouyeFragment imvp) {
        super(imvp);
        this.imvp = imvp;
    }

    public void getRecv1Data(){
        NetClient.getShouYeRecv1Data("0db6ffd00372064035ef33763dd1c61e","1547700576328")
                .subscribe(new Observer<ShouYeCategoryBean>() {
                    @Override
                    public void onCompleted() {
                        Log.e("getShouYeRecv1Data: ", "onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("getShouYeRecv1Data: ", "onError");
                    }

                    @Override
                    public void onNext(ShouYeCategoryBean shouYeCategoryBean) {
                        Log.e("getShouYeRecv1Data: ", "onNext:"+new Gson().toJson(shouYeCategoryBean));
                        imvp.requestRev1Success(shouYeCategoryBean);
                    }
                });

    }
    public void getRecv2Data(){
        NetClient.changeRetrofitUrlTo3()
                .getShouYeRecv2Data("App.Table.FreeTree","INTRODUCE_MAIN", "parent_id",
                        0,NetClient.app_key, "description,h5Url,image,items_id,mainname,title" +
                                ",parent_id,brandName,cate_id,keyword,originalPrice,price")
                .subscribe(new Observer<ShouYeTuijianBean>() {
                    @Override
                    public void onCompleted() {
                        Log.e("getShouYeRecv2Data: ", "onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("getShouYeRecv2Data: ", "onError:"+e.getMessage());
                    }

                    @Override
                    public void onNext(ShouYeTuijianBean shouYeTuijianBean) {
                        Log.e("getShouYeRecv2Data: ", "onNext:"+new Gson().toJson(shouYeTuijianBean));
                        imvp.requestRev2Success(shouYeTuijianBean);
                    }
                });
    }
}
