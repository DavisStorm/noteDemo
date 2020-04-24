package com.davis.mall.network;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by wyw on 2017/1/6.
 */

public abstract class RetrofitCallback<T>  implements Callback<T> {
    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if(response.isSuccessful()) {
            onSuccess(call, response);
        } else {
            onFailure(call, new Throwable(response.message()));
        }
    }

    protected abstract void onSuccess(Call<T> call, Response<T> response);
    public void onLoading(long total, long progress) {

    }
}
