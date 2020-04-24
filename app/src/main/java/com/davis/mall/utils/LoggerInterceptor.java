package com.davis.mall.utils;

import com.facebook.stetho.BuildConfig;
import com.facebook.stetho.common.LogUtil;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author 王阳
 * @time 2019/12/24  1:07
 * @desc
 */
public class LoggerInterceptor implements Interceptor {

    private static String TAG = "LoggerInterceptor";
    private boolean isDebug;

    public LoggerInterceptor(boolean isDebug) {
        this(TAG, isDebug);
    }

    public LoggerInterceptor(String tag, boolean isDebug) {
        this.isDebug = isDebug;
        TAG = tag;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        if (BuildConfig.DEBUG || isDebug) {
            LogUtil.i(TAG, String.format("发送请求:%s on %s%n%s%n%s",
                    request.url(), chain.connection(), request.headers(), request.body()));
        }
        return chain.proceed(request);
    }
}