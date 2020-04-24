package com.davis.mall.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.davis.mall.R;
import com.davis.mall.adapter.TextTagsAdapter;
import com.davis.mall.presenter.BaseFragmentPresenter;
import com.davis.mall.ui.base.BaseFragment;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author 王阳
 * @time 2019/11/2  0:30
 * @desc
 */
public class FaXianFragment extends BaseFragment {


    private static FaXianFragment fragment;
    @BindView(R.id.tag_cloudview)
    com.davis.mall.views.tagcloud.TagCloudView mTagCloudview;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    protected int setLayout() {
        return R.layout.fm_faxian;
    }

    @Override
    protected void initView() {
        mTagCloudview.setBackgroundColor(getResources().getColor(R.color.WHITE));
        List<String> data = Arrays.asList("开眼视频","Kotlin", "组件化", "MVP", "Retrofit", "Rxjava"
                , "开眼视频", "好好学习", "进入开眼视频", "有趣的内容", "组件化", "Kotlin", "Dagger2"
                , "开眼视频", "Room数据库", "Retrofit", "开眼视频", "沉浸式状态栏", "5.0新特性", "Rxjava"
                , "烟火里的尘埃", "进入开眼视频", "猪年快乐", "加油努力", "进入开眼视频", "猪事顺利", "ARouter");
        TextTagsAdapter tagsAdapter = new TextTagsAdapter(data);//new String[20]-*arrayOfNulls(20)
        mTagCloudview.setAdapter(tagsAdapter);
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

    public static FaXianFragment newInstance() {
        if (fragment == null) {
            fragment = new FaXianFragment();
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
