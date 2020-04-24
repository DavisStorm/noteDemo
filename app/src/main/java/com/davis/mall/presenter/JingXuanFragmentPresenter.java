package com.davis.mall.presenter;

import android.util.Log;

import com.davis.mall.bean.PODDetaliBean;
import com.davis.mall.interfac.IJingXuanFragment;
import com.davis.mall.network.NetClient;
import com.davis.mall.utils.JsonObjectUtil;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import rx.Observer;

/**
 * @author 王阳
 * @time 2020/1/4  5:58
 * @desc
 */
public class JingXuanFragmentPresenter extends BaseFragmentPresenter {
    private IJingXuanFragment iJingXuanFragment;
    public JingXuanFragmentPresenter(IJingXuanFragment imvp) {
        super(imvp);
        iJingXuanFragment = imvp;
    }
    public void getTuijianPodList(int perpage){
        JSONObject jsonObject = JsonObjectUtil.getJsonObject("id", ">", "0",
                "INTRODUCE_POD", "App.Table.FreeQuery");
        try {
            jsonObject.put("perpage", perpage);
            jsonObject.put("is_real_total", 1);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        NetClient.changeRetrofitUrlTo3().getTuijianPodList(jsonObject)
                .subscribe(new Observer<PODDetaliBean>() {
                    @Override
                    public void onCompleted() {
                        Log.e("getTuijianPodList: ", "onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("getTuijianPodList: ", e.getMessage());
                    }

                    @Override
                    public void onNext(PODDetaliBean pODDetaliBean) {
                        Log.e("getTuijianPodList: ", "onNext:" + new Gson().toJson(pODDetaliBean));
                        iJingXuanFragment.onSwiperRefresh(pODDetaliBean);
                    }
                });
    }
}
