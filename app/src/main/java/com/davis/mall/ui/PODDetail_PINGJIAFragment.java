package com.davis.mall.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.davis.mall.R;
import com.davis.mall.adapter.PingjiaRvAdapter;
import com.davis.mall.bean.PODDetaliBean;
import com.davis.mall.bean.PingJiaBean;
import com.davis.mall.interfac.IPODDetail_PINGJIAFragment;
import com.davis.mall.presenter.PODDetail_PINGJIAFragmentPresenter;
import com.davis.mall.ui.base.BaseFragment;

import java.util.List;

import butterknife.BindView;

/**
 * @author 王阳
 * @time 2019/11/2  0:30
 * @desc
 */
public class PODDetail_PINGJIAFragment extends BaseFragment<PODDetail_PINGJIAFragmentPresenter> implements IPODDetail_PINGJIAFragment {


    private static PODDetail_PINGJIAFragment fragment;
    @BindView(R.id.tv_pingjia)
    TextView mTvPingjia;
    @BindView(R.id.rl_pingjia)
    RelativeLayout mRlPingjia;
    @BindView(R.id.rv_pj)
    RecyclerView mRvPj;
    private int mCate_id = 0;
    private PingjiaRvAdapter mPingjiaRvAdapter;
    private List<PingJiaBean.DataBean.ListBean> mListData;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    protected int setLayout() {
        return R.layout.fm_poddetail_pingjia;
    }

    @Override
    protected void initView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRvPj.setLayoutManager(layoutManager);
        mPingjiaRvAdapter = new PingjiaRvAdapter(getActivity(), null);
        mRvPj.setAdapter(mPingjiaRvAdapter);
    }

    @Override
    protected void bindData() {
        if (mCate_id != 0) {
            mCate_id = 1111111;//评价全用一个数据
            getPresenter().getPingjiaById(mCate_id);
        }
    }

    @Override
    protected void bindListenter() {

    }

    @Override
    protected PODDetail_PINGJIAFragmentPresenter createPresenter() {
        return new PODDetail_PINGJIAFragmentPresenter(this);
    }

    public static PODDetail_PINGJIAFragment newInstance() {
        if (fragment == null) {
            fragment = new PODDetail_PINGJIAFragment();
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
        mCate_id = infoBean.getCate_id();
        getPresenter().getPingjiaById(mCate_id);
    }

    @Override
    public void requestPingjiaByCate_id(PingJiaBean pingJiaBean) {
        PingJiaBean.DataBean beanData = pingJiaBean.getData();
        if(beanData!=null) {
            mListData = beanData.getList();
            mPingjiaRvAdapter.setNewData(mListData);
        }
    }
}
