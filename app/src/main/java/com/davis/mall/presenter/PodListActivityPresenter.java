package com.davis.mall.presenter;

import android.text.TextUtils;
import android.util.Log;

import com.davis.mall.bean.FUWUZEKOUbEAN;
import com.davis.mall.bean.PODDetaliBean;
import com.davis.mall.bean.PingpaiBean;
import com.davis.mall.interfac.IPodListActivity;
import com.davis.mall.network.NetClient;
import com.davis.mall.utils.JsonObjectUtil;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import rx.Observer;

/**
 * @author 王阳
 * @time 2019/12/30  9:17
 * @desc
 */
public class PodListActivityPresenter extends BaseActivityPresenter {
    private IPodListActivity iPodListActivity;

    public PodListActivityPresenter(IPodListActivity imvp) {
        super(imvp);
        this.iPodListActivity = imvp;
    }

    public void getPodList(String cate_id, int perpage, String order,
                           String priceStart, String priceEnd, ArrayList<String> mPingpaiListId){
        Log.e("getPodListOrderBy", "cate_id: "+cate_id);
        JSONObject jsonObject = JsonObjectUtil.getJsonObject("coupon", "=", cate_id,
                "ITEM_DETAIL_TRUE", "App.Table.FreeQuery");
        try {
            jsonObject.put("perpage", perpage);
            jsonObject.put("is_real_total", 1);

            //添加筛选条件
            JSONArray whereArray = jsonObject.getJSONArray("where");
            if(!TextUtils.isEmpty(priceStart)) {
                JSONArray jsonArray = new JSONArray();
                jsonArray.put("price");
                jsonArray.put(">");
                jsonArray.put(priceStart);
                whereArray.put(jsonArray);
            }
            if(!TextUtils.isEmpty(priceEnd)) {
                JSONArray jsonArray = new JSONArray();
                jsonArray.put("price");
                jsonArray.put("<");
                jsonArray.put(priceEnd);
                whereArray.put(jsonArray);
            }
            //这里没法处理多个品牌，暂时只查询第一个品牌吧
            if(mPingpaiListId!=null && mPingpaiListId.size()>0) {
                String mPingpaiId = mPingpaiListId.get(0);
                JSONArray jsonArray = new JSONArray();
                jsonArray.put("pingpai_id");
                jsonArray.put("=");
                jsonArray.put(mPingpaiId);
                whereArray.put(jsonArray);
            }
            if(!TextUtils.isEmpty(order)) {
                jsonObject.put("order", order);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        NetClient.changeRetrofitUrlTo3().getPodListOrderBy(jsonObject)
                .subscribe(new Observer<PODDetaliBean>() {
                    @Override
                    public void onCompleted() {
                        Log.e("getPodListOrderBy: ", "onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("getPodListOrderBy: ", e.getMessage());
                    }

                    @Override
                    public void onNext(PODDetaliBean pODDetaliBean) {
                        Log.e("getPodListOrderBy: ", "onNext:" + new Gson().toJson(pODDetaliBean));
                        iPodListActivity.onSwiperRefresh(pODDetaliBean);
                    }
                });
    }

    public void getPodListMore(String cate_id,int perpage,String order,
                               String priceStart, String priceEnd, ArrayList<String> mPingpaiListId){
        JSONObject jsonObject = JsonObjectUtil.getJsonObject("coupon", "=", cate_id,
                "ITEM_DETAIL_TRUE", "App.Table.FreeQuery");
        try {
            jsonObject.put("perpage", perpage);
            jsonObject.put("is_real_total", 1);

            //添加筛选条件
            JSONArray whereArray = jsonObject.getJSONArray("where");
            if(!TextUtils.isEmpty(priceStart)) {
                JSONArray jsonArray = new JSONArray();
                jsonArray.put("price");
                jsonArray.put(">");
                jsonArray.put(priceStart);
                whereArray.put(jsonArray);
            }
            if(!TextUtils.isEmpty(priceEnd)) {
                JSONArray jsonArray = new JSONArray();
                jsonArray.put("price");
                jsonArray.put("<");
                jsonArray.put(priceEnd);
                whereArray.put(jsonArray);
            }
            //这里没法处理多个品牌，暂时只查询第一个品牌吧
            if(mPingpaiListId!=null && mPingpaiListId.size()>0) {
                String mPingpaiId = mPingpaiListId.get(0);
                JSONArray jsonArray = new JSONArray();
                jsonArray.put("pingpai_id");
                jsonArray.put("=");
                jsonArray.put(mPingpaiId);
                whereArray.put(jsonArray);
            }
            if(!TextUtils.isEmpty(order)) {
                jsonObject.put("order", order);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        NetClient.changeRetrofitUrlTo3().getPodListOrderBy(jsonObject)
                .subscribe(new Observer<PODDetaliBean>() {
                    @Override
                    public void onCompleted() {
                        Log.e("getPodListOrderBy: ", "onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("getPodListOrderBy: ", e.getMessage());
                    }

                    @Override
                    public void onNext(PODDetaliBean pODDetaliBean) {
                        Log.e("getPodListOrderBy: ", "onNext:" + new Gson().toJson(pODDetaliBean));
                        iPodListActivity.onSwiperLoadMore(pODDetaliBean);
                    }
                });
    }

    public void getFuwuZekouList() {
        JSONObject jsonObject = JsonObjectUtil.getJsonObject("id", ">", "0",
                "FUWUZEKOU", "App.Table.FreeQuery");
        NetClient.changeRetrofitUrlTo3().getFuwuZekouList(jsonObject)
                .subscribe(new Observer<FUWUZEKOUbEAN>() {
                    @Override
                    public void onCompleted() {
                        Log.e("getPodListOrderBy: ", "onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("getPodListOrderBy: ", e.getMessage());
                    }

                    @Override
                    public void onNext(FUWUZEKOUbEAN fUWUZEKOUbEAN) {
                        Log.e("getPodListOrderBy: ", "onNext:" + new Gson().toJson(fUWUZEKOUbEAN));
                        iPodListActivity.getFuwuZEkouSuccess(fUWUZEKOUbEAN);
                    }
                });
    }

    public void getPinpai(int cate_id) {
        JSONObject jsonObject = JsonObjectUtil.getJsonObject("id", ">", "0",
                "PINGPAI_MODEL", "App.Table.FreeTree");
        try {
            jsonObject.put("parent_field","fenzhi_id");
            jsonObject.put("parent_id",cate_id);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        NetClient.changeRetrofitUrlTo3().getPinpai(jsonObject)
                .subscribe(new Observer<PingpaiBean>() {
                    @Override
                    public void onCompleted() {
                        Log.e("getPodListOrderBy: ", "onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("getPodListOrderBy: ", e.getMessage());
                    }

                    @Override
                    public void onNext(PingpaiBean pingpaiBean) {
                        Log.e("getPodListOrderBy: ", "onNext:" + new Gson().toJson(pingpaiBean));
                        iPodListActivity.getPingpaiSuccess(pingpaiBean);
                    }
                });


    }
}
