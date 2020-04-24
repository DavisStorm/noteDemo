package com.davis.mall.presenter;

import android.util.Log;

import com.davis.mall.bean.GouWuCheBean;
import com.davis.mall.interfac.IGouWuCheFragment;
import com.davis.mall.network.NetClient;
import com.davis.mall.utils.JsonObjectUtil;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import rx.Observer;

/**
 * @author 王阳
 * @time 2020/1/6  10:27
 * @desc
 */
public class GouWuCheFragmentPresenter extends BaseFragmentPresenter {
    private IGouWuCheFragment imvp;
    public GouWuCheFragmentPresenter(IGouWuCheFragment imvp) {
        super(imvp);
        this.imvp = imvp;
    }

    public void getGouWuCheByUserId(String user_id) {
        JSONObject jsonObject = JsonObjectUtil.getJsonObject("user_id", "=", user_id,
                "SHAPPING_CAR", "App.Table.FreeQuery");
        try {
            jsonObject.put("perpage","1000");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        NetClient.changeRetrofitUrlTo3().requestAllGouWuChe(jsonObject)
                .subscribe(new Observer<GouWuCheBean>() {
                    @Override
                    public void onCompleted() {
                        Log.e("requestAllFavorData: ", "onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("requestAllFavorData: ", "onError");
                    }

                    @Override
                    public void onNext(GouWuCheBean gouWuCheBean) {
                        Log.e("requestAllFavorData: ", "onNext:" + new Gson().toJson(gouWuCheBean));
                        imvp.requestSuccess(gouWuCheBean);
                    }
                });
    }
}
