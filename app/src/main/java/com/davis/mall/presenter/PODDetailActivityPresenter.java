package com.davis.mall.presenter;

import android.util.Log;

import com.davis.mall.bean.PODDetaliBean;
import com.davis.mall.interfac.IPODDetailActivity;
import com.davis.mall.network.NetClient;
import com.davis.mall.utils.JsonObjectUtil;
import com.google.gson.Gson;

import org.json.JSONObject;

import rx.Observer;

/**
 * @author 王阳
 * @time 2019/12/19  6:08
 * @desc
 */
public class PODDetailActivityPresenter extends BaseActivityPresenter {
private IPODDetailActivity imvp;
    public PODDetailActivityPresenter(IPODDetailActivity imvp) {
        super(imvp);
        this.imvp = imvp;
    }

    public void getPODDetailData(int cate_id){
        JSONObject jsonObject = JsonObjectUtil.getJsonObject("cate_id", "=", ""+cate_id,
                "ITEM_DETAIL_TRUE", "App.Table.FreeQuery");

        NetClient.changeRetrofitUrlTo3()
                .getPODDetailDataByCate_id(jsonObject)
                .subscribe(new Observer<PODDetaliBean>() {
                    @Override
                    public void onCompleted() {
                        Log.e("getShouYeRecv2Data: ", "onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("getShouYeRecv2Data: ", "onError:"+e.getMessage());
                    }

                    @Override
                    public void onNext(PODDetaliBean pODDetaliBean) {
                        Log.e("getShouYeRecv2Data: ", "onNext:"+new Gson().toJson(pODDetaliBean));
                        imvp.requestPODDetaliSuccess(pODDetaliBean);
                    }
                });
    }
}
