package com.davis.mall.presenter;

import android.util.Log;

import com.davis.mall.bean.AllFavorBean;
import com.davis.mall.interfac.IAllFavorFragment;
import com.davis.mall.network.NetClient;
import com.davis.mall.utils.JsonObjectUtil;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import rx.Observer;

/**
 * @author 王阳
 * @time 2019/11/11  2:25
 * @desc
 */
public class AllFavorFragmentPresenter extends BaseFragmentPresenter {
    private IAllFavorFragment iaff;
    public AllFavorFragmentPresenter(IAllFavorFragment iaff) {
        super(iaff);
        this.iaff= iaff;
    }

    public void requestAllFavorData(int perpage){

        JSONObject jsonObject = JsonObjectUtil.getJsonObject("id", ">", "0",
                "FavorList", "App.Table.FreeQuery");
        try {
            jsonObject.put("perpage", perpage);
            jsonObject.put("is_real_total", "1");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        NetClient.changeRetrofitUrlTo3().requestAllFavorData(jsonObject)
                .subscribe(new Observer<AllFavorBean>() {
                    @Override
                    public void onCompleted() {
                        Log.e("requestAllFavorData: ", "onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("requestAllFavorData: ", "onError");
                    }

                    @Override
                    public void onNext(AllFavorBean allFavorBean) {
                        Log.e("requestAllFavorData: ", "onNext:" + new Gson().toJson(allFavorBean));
                        iaff.requestSuccess(allFavorBean);
                    }
                });
    }
}
