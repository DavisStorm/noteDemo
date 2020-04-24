package com.davis.mall.ui;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.davis.mall.R;
import com.davis.mall.bean.PODDetaliBean;
import com.davis.mall.presenter.BaseFragmentPresenter;
import com.davis.mall.ui.base.BaseFragment;

/**
 * @author 王阳
 * @time 2019/11/2  0:30
 * @desc
 */
public class PODDetail_TUIJIANFragment extends BaseFragment {


    private static PODDetail_TUIJIANFragment fragment;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    protected int setLayout() {
        return R.layout.fm_poddetail_tuijian;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void bindData() {

    }

    @Override
    protected void bindListenter() {

    }

    @Override
    protected BaseFragmentPresenter createPresenter() {
        return null;
    }

    public static PODDetail_TUIJIANFragment newInstance() {
        if (fragment == null) {
            fragment = new PODDetail_TUIJIANFragment();
        }
        return fragment;

    }

    @Override
    public void setMenuVisibility(boolean menuVisible) {//menuVisible true 相当于Fragment的onResume
        super.setMenuVisibility(menuVisible);           //menuVisible false 相当于Fragment的onPause
        if (this.getView() != null) {
            this.getView().setVisibility(menuVisible ? View.VISIBLE : View.GONE); //设置自己是否可见
        }
    }

    public void setData(PODDetaliBean.DataBean.ListBean infoBean) {

    }
}
