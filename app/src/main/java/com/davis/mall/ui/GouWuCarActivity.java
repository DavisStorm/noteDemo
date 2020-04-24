package com.davis.mall.ui;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.fragment.app.FragmentManager;

import com.davis.mall.R;
import com.davis.mall.interfac.IGouWuCarActivity;
import com.davis.mall.presenter.GouWuCarActivityPresenter;
import com.davis.mall.ui.base.BaseActivity;
import com.davis.mall.utils.StatusBarUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author 王阳
 * @time 2020/1/10  19:25
 * @desc
 */
public class GouWuCarActivity extends BaseActivity<GouWuCarActivityPresenter> implements IGouWuCarActivity {
    @BindView(R.id.img_back)
    ImageView mImgBack;
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.img_search)
    ImageView mImgSearch;
    @BindView(R.id.rl_search)
    RelativeLayout mRlSearch;
    @BindView(R.id.fragment_container)
    FrameLayout fragment_container;

    @Override
    protected int getLayout() {
        return R.layout.activity_gouwucar;
    }

    @Override
    protected void bindView() {
        StatusBarUtil.enableTranslucentStatusBar(this);
        mTvTitle.setText("购物车");
        FragmentManager manager = getSupportFragmentManager();
        GouWuCheFragment fragment = GouWuCheFragment.newInstance();
        fragment.setVisiable(true);
        manager.beginTransaction().add(R.id.fragment_container,fragment).commit();

    }

    @Override
    protected void bindData() {

    }

    @Override
    protected void bindLisener() {

    }

    @Override
    protected GouWuCarActivityPresenter createPresenter() {
        return new GouWuCarActivityPresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
