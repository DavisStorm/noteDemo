package com.davis.mall.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.davis.mall.R;
import com.davis.mall.bean.PODDetaliBean;
import com.davis.mall.presenter.BaseFragmentPresenter;
import com.davis.mall.ui.base.BaseFragment;
import com.davis.mall.utils.StringUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author 王阳
 * @time 2019/11/2  0:30
 * @desc
 */
public class PODDetail_XIANGQINGFragment extends BaseFragment implements View.OnClickListener {


    private static PODDetail_XIANGQINGFragment fragment;
    @BindView(R.id.ll_container)
    LinearLayout mLlContainer;
    @BindView(R.id.ll_spjs)
    LinearLayout mLlSpjs;
    @BindView(R.id.ll_ggcs)
    LinearLayout mLlGgcs;
    @BindView(R.id.ll_bbsh)
    LinearLayout mLlBbsh;
    @BindView(R.id.rl_container)
    RelativeLayout mRlContainer;
    @BindView(R.id.tv_spjs)
    TextView mTvSpjs;
    @BindView(R.id.tv_ggcs)
    TextView mTvGgcs;
    @BindView(R.id.tv_bbsh)
    TextView mTvBbsh;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    protected int setLayout() {
        return R.layout.fm_poddetail_xiangqing;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_spjs:
                mTvSpjs.setTextColor(getResources().getColor(R.color.RED));
                mTvGgcs.setTextColor(getResources().getColor(R.color.BLACK));
                mTvBbsh.setTextColor(getResources().getColor(R.color.BLACK));
                mLlSpjs.setVisibility(View.VISIBLE);
                mLlGgcs.setVisibility(View.GONE);
                mLlBbsh.setVisibility(View.GONE);
                break;
            case R.id.tv_ggcs:
                mTvGgcs.setTextColor(getResources().getColor(R.color.RED));
                mTvSpjs.setTextColor(getResources().getColor(R.color.BLACK));
                mTvBbsh.setTextColor(getResources().getColor(R.color.BLACK));
                mLlGgcs.setVisibility(View.VISIBLE);
                mLlSpjs.setVisibility(View.GONE);
                mLlBbsh.setVisibility(View.GONE);
                break;
            case R.id.tv_bbsh:
                mTvBbsh.setTextColor(getResources().getColor(R.color.RED));
                mTvGgcs.setTextColor(getResources().getColor(R.color.BLACK));
                mTvSpjs.setTextColor(getResources().getColor(R.color.BLACK));
                mLlBbsh.setVisibility(View.VISIBLE);
                mLlGgcs.setVisibility(View.GONE);
                mLlSpjs.setVisibility(View.GONE);
                break;
        }
    }

    @Override
    protected void bindListenter() {
        mTvSpjs.setOnClickListener(this);
        mTvGgcs.setOnClickListener(this);
        mTvBbsh.setOnClickListener(this);
    }

    public void setData(PODDetaliBean.DataBean.ListBean infoBean) {
        if (infoBean == null) {
            return;
        }
        String pod_detail_img = infoBean.getPod_detail_img();
        String[] stringspod_detail_img = StringUtil.splitStringByJInghao(pod_detail_img);

        LayoutInflater inflater = LayoutInflater.from(getActivity());
        for (int i = 0; i < stringspod_detail_img.length; i++) {
            ImageView childView = (ImageView) inflater.inflate(R.layout.pod_detail_img, null);
            Glide.with(getActivity()).load(stringspod_detail_img[i]).into(childView);
            mLlSpjs.addView(childView);
        }

        String baozhuang_shouhou = infoBean.getBaozhuang_shouhou();
        String[] stringsbaozhuang_shouhou = StringUtil.splitStringByJInghao(baozhuang_shouhou);

        for (int i = 0; i < stringsbaozhuang_shouhou.length; i++) {
            ImageView childView = (ImageView) inflater.inflate(R.layout.pod_detail_img, null);
            Glide.with(getActivity()).load(stringsbaozhuang_shouhou[i]).into(childView);
            mLlBbsh.addView(childView);

        }
        String guige_cansu = infoBean.getGuige_cansu();
        String[] stringsguige_cansu = StringUtil.splitStringByJInghao(guige_cansu);

        for (int i = 0; i < stringsguige_cansu.length; i++) {
            ImageView childView = (ImageView) inflater.inflate(R.layout.pod_detail_img, null);
            Glide.with(getActivity()).load(stringsguige_cansu[i]).into(childView);
            mLlGgcs.addView(childView);

        }

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void bindData() {

    }

    @Override
    protected BaseFragmentPresenter createPresenter() {
        return null;
    }

    public static PODDetail_XIANGQINGFragment newInstance() {
        if (fragment == null) {
            fragment = new PODDetail_XIANGQINGFragment();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }
}
