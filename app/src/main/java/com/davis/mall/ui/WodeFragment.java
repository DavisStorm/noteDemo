package com.davis.mall.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.davis.mall.MallApplication;
import com.davis.mall.R;
import com.davis.mall.interfac.IWodeFragment;
import com.davis.mall.presenter.WodeFragmentPresenter;
import com.davis.mall.ui.base.BaseFragment;
import com.davis.mall.views.CircleImageView;

import butterknife.BindView;

/**
 * @author 王阳
 * @time 2019/11/2  0:30
 * @desc
 */
public class WodeFragment extends BaseFragment<WodeFragmentPresenter> implements IWodeFragment, View.OnClickListener {


    private static WodeFragment fragment;
    @BindView(R.id.img_head)
    CircleImageView mImgHead;
    @BindView(R.id.tv_name)
    TextView mTvName;
    @BindView(R.id.rl_please_login)
    RelativeLayout mRlPleaseLogin;
    @BindView(R.id.rl_head)
    RelativeLayout mRlHead;
    @BindView(R.id.tv_orders)
    TextView mTvOrders;
    @BindView(R.id.tv_shouchang)
    TextView mTvShouchang;
    @BindView(R.id.tv_address)
    TextView mTvAddress;
    @BindView(R.id.btn_exit)
    Button mBtnExit;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    protected int setLayout() {
        return R.layout.fm_wode;
    }

    @Override
    protected void initView() {
    }

    @Override
    protected void bindData() {
    }

    private void changeName() {
        if (MallApplication.IF_LOGIN_IN) {
            String username = getActivity().getSharedPreferences
                    ("userlogin", Context.MODE_PRIVATE).getString("username", "");
            mTvName.setText(username);
        } else {
            mTvName.setText("点击登录");
        }
    }


    @Override
    public void onResume() {
        super.onResume();
        changeName();
    }

    @Override
    protected void bindListenter() {
        mRlPleaseLogin.setOnClickListener(this);
        mBtnExit.setOnClickListener(this);
        mTvOrders.setOnClickListener(this);
        mTvShouchang.setOnClickListener(this);
        mTvAddress.setOnClickListener(this);
    }

    private void createDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("退出登录");
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MallApplication.IF_LOGIN_IN = false;
                mTvName.setText("点击登录");
                dialogInterface.dismiss();
                Toast.makeText(getActivity(), "已退出", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.create().show();
    }

    @Override
    protected WodeFragmentPresenter createPresenter() {
        return new WodeFragmentPresenter(this);
    }

    public static WodeFragment newInstance() {
        if (fragment == null) {
            fragment = new WodeFragment();
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
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_please_login:
                if (!MallApplication.IF_LOGIN_IN) {
                    Intent intent = new Intent();
                    intent.setClass(getActivity(), LoginActivity.class);
                    startActivity(intent);
                }
                break;

            case R.id.btn_exit:
                if (MallApplication.IF_LOGIN_IN) {
                    createDialog();
                } else {
                    Toast.makeText(getActivity(), "您还未登录", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.tv_orders:
                Toast.makeText(getActivity(), "待完成", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_shouchang:
                Toast.makeText(getActivity(), "待完成", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_address:
                Toast.makeText(getActivity(), "待完成", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
