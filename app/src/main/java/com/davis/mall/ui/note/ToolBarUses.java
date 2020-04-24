package com.davis.mall.ui.note;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.davis.mall.R;
import com.davis.mall.presenter.BaseActivityPresenter;
import com.davis.mall.ui.base.BaseActivity;

import butterknife.ButterKnife;

/**
 * Created by CZY on 2018/12/19.
 */

public class ToolBarUses extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_toolbar;
    }

    @Override
    protected void bindView() {

    }



    @Override
    protected void bindData() {

    }

    @Override
    protected void bindLisener() {

    }

    @Override
    protected BaseActivityPresenter createPresenter() {
        return null;
    }


}
