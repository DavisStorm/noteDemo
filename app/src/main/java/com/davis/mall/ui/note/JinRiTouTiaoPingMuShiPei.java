package com.davis.mall.ui.note;

import android.os.Bundle;
import android.webkit.WebView;

import androidx.annotation.Nullable;

import com.davis.mall.R;
import com.davis.mall.presenter.BaseActivityPresenter;
import com.davis.mall.ui.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by CZY on 2018/12/19.
 */

public class JinRiTouTiaoPingMuShiPei extends BaseActivity {
    @BindView(R.id.webview)
    WebView webview;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_jrttpmsp;
    }

    @Override
    protected void bindView() {

    }

    @Override
    protected void bindData() {
        webview.loadUrl("https://blog.csdn.net/a31081314/article/details/80857503");
    }

    @Override
    protected void bindLisener() {

    }

    @Override
    protected BaseActivityPresenter createPresenter() {
        return null;
    }


}
