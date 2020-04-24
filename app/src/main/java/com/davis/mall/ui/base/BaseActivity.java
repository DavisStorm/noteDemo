package com.davis.mall.ui.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.davis.mall.presenter.BaseActivityPresenter;

import butterknife.ButterKnife;

/**
 * @author 王阳
 * @time 2019/12/18  22:32
 * @desc
 */
public abstract class BaseActivity<T extends BaseActivityPresenter> extends AppCompatActivity {

    private T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        ButterKnife.bind(this);
        bindView();
        mPresenter = createPresenter();
    }

    protected abstract int getLayout();
    protected abstract void bindView();
    protected abstract void bindData();
    protected abstract void bindLisener();
    protected abstract T createPresenter();


    @Override
    protected void onResume() {
        super.onResume();
        bindData();
        bindLisener();
    }
    public  T getPresenter(){
        return mPresenter;
    }
    public void getBack(){
        finish();
    }
}
