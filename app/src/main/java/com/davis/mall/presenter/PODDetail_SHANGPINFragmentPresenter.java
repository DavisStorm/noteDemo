package com.davis.mall.presenter;

import android.util.Log;

import com.davis.mall.bean.AddGouWuCheBean;
import com.davis.mall.bean.AddressBean;
import com.davis.mall.bean.GouWuCheBean;
import com.davis.mall.interfac.IPODDetail_SHANGPINFragment;
import com.davis.mall.network.NetClient;
import com.davis.mall.utils.JsonObjectUtil;
import com.google.gson.Gson;

import org.json.JSONObject;

import rx.Observer;

/**
 * @author 王阳
 * @time 2019/12/24  9:29
 * @desc
 */
public class PODDetail_SHANGPINFragmentPresenter extends BaseFragmentPresenter {
    private IPODDetail_SHANGPINFragment imvp;
    public PODDetail_SHANGPINFragmentPresenter(IPODDetail_SHANGPINFragment imvp) {
        super(imvp);
        this.imvp = imvp;
    }
    public void getSavedAddressByUser_id(){
        JSONObject jsonObject = JsonObjectUtil.getJsonObject("user_id", "=", "0",
                "INFO_TO", "App.Table.FreeQuery");

        NetClient.changeRetrofitUrlTo3()
                .getSavedAddressByUser_id(jsonObject)
                .subscribe(new Observer<AddressBean>() {
                    @Override
                    public void onCompleted() {
                        Log.e("getSavedAddressByUser: ", "onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("getSavedAddressByUser: ", "onError:"+e.getMessage());
                    }

                    @Override
                    public void onNext(AddressBean addressBean) {
                        Log.e("getSavedAddressByUser: ", "onNext:"+new Gson().toJson(addressBean));
                        imvp.requestAddressByUser_id(addressBean);
                    }
                });
    }

    public void addCar(AddGouWuCheBean dataBean) {
        JSONObject jsonObject = JsonObjectUtil.getNormalJsonObject("SHAPPING_CAR",
                "App.Table.Create", new Gson().toJson(dataBean));
        NetClient.changeRetrofitUrlTo3()
                .addCar(jsonObject)
                .subscribe(new Observer<GouWuCheBean>() {
                    @Override
                    public void onCompleted() {
                        Log.e("addCar: ", "onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("addCar: ", "onError:"+e.getMessage());
                    }

                    @Override
                    public void onNext(GouWuCheBean addressBean) {
                        Log.e("addCar: ", "onNext:"+new Gson().toJson(addressBean));
                        imvp.addCarSuccessful(addressBean);
                    }
                });
    }
}
