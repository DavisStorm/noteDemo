package com.davis.mall.presenter;

import android.util.Log;

import com.davis.mall.bean.PingJiaBean;
import com.davis.mall.interfac.IPODDetail_PINGJIAFragment;
import com.davis.mall.network.NetClient;
import com.davis.mall.utils.JsonObjectUtil;
import com.google.gson.Gson;

import org.json.JSONObject;

import rx.Observer;

/**
 * @author 王阳
 * @time 2019/12/25  14:33
 * @desc
 */
public class PODDetail_PINGJIAFragmentPresenter extends BaseFragmentPresenter {
    IPODDetail_PINGJIAFragment imvp;
    public PODDetail_PINGJIAFragmentPresenter(IPODDetail_PINGJIAFragment imvp) {
        super(imvp);
        this.imvp = imvp;
    }

    public void getPingjiaById(int cate_id) {
        JSONObject jsonObject = JsonObjectUtil.getJsonObject("cate_id", "=", ""+cate_id,
                "POD_COMMENTS", "App.Table.FreeQuery");

        NetClient.changeRetrofitUrlTo3()
                .getPingjiaByCate_id(jsonObject)
                .subscribe(new Observer<PingJiaBean>() {
                    @Override
                    public void onCompleted() {
                        Log.e("getSavedAddressByUser: ", "onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("getSavedAddressByUser: ", "onError:"+e.getMessage());
                    }

                    @Override
                    public void onNext(PingJiaBean pingJiaBean) {
                        Log.e("getSavedAddressByUser: ", "onNext:"+new Gson().toJson(pingJiaBean));
                        imvp.requestPingjiaByCate_id(pingJiaBean);
                    }
                });
    }
}
