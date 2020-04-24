package com.davis.mall;


import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import com.davis.mall.bean.FragmentInfo;
import com.davis.mall.presenter.BaseFragmentPresenter;
import com.davis.mall.ui.base.BaseFragment;
import com.davis.mall.ui.AllFavorFragment;
import com.davis.mall.ui.JingXuanFragment;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * @author 王阳
 * @time 2019/11/12  21:01
 * @desc
 */
public class TestFragment extends BaseFragment {
    @BindView(R.id.viewpagertab)
    SmartTabLayout mViewpagertab;
    @BindView(R.id.viewpager)
    ViewPager mViewpager;

    @Override
    protected int setLayout() {
        return R.layout.test_fm;
    }

    @Override
    protected void initView() {
        //初始化SmartTabLayout适配器数据
        //        ArrayList<FragmentInfo> fragmentInfos = initPageViewData();
        //初始化SmartTabLayout和适配器
        FragmentManager manager = getChildFragmentManager();
        FragmentPagerItemAdapter pageAdapter = new FragmentPagerItemAdapter(manager,
                FragmentPagerItems.with(getActivity())
                        .add("精选",JingXuanFragment.class)
                        .add("大家喜欢",AllFavorFragment.class)
                        .create());
        //        pageAdapter.setData(fragmentInfos);
        mViewpager.setAdapter(pageAdapter);
        mViewpagertab.setViewPager(mViewpager);
    }

    @Override
    protected void bindData() {

    }
    private ArrayList<FragmentInfo> initPageViewData() {
        ArrayList<FragmentInfo> infos = new ArrayList<>();
        FragmentInfo jingXuanfragmentInfo = new FragmentInfo("精选", new JingXuanFragment());
        FragmentInfo allFavorragmentInfo = new FragmentInfo("大家喜欢", new AllFavorFragment());
        infos.add(jingXuanfragmentInfo);
        infos.add(allFavorragmentInfo);
        return infos;
    }
    @Override
    protected void bindListenter() {

    }

    @Override
    protected BaseFragmentPresenter createPresenter() {
        return null;
    }

}
