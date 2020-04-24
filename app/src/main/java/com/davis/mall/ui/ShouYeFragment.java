package com.davis.mall.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.davis.mall.R;
import com.davis.mall.adapter.ShouYeAdapter1;
import com.davis.mall.adapter.ShouYeAdapter2;
import com.davis.mall.bean.ShouYeCategoryBean;
import com.davis.mall.bean.ShouYeTuijianBean;
import com.davis.mall.interfac.IShouyeFragment;
import com.davis.mall.presenter.ShouyeFragmentPresenter;
import com.davis.mall.ui.base.BaseFragment;
import com.davis.mall.utils.ComponentUtil;
import com.davis.mall.views.MYNestedScrollView;
import com.davis.mall.views.MyRecycleView;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * @author 王阳
 * @time 2019/11/2  0:30
 * @desc
 */
public class ShouYeFragment extends BaseFragment<ShouyeFragmentPresenter> implements IShouyeFragment, ShouYeAdapter1.onItemClickLisener {

    private static ShouYeFragment fragment;

    @BindView(R.id.recycle_no1)
    RecyclerView mRecycleNo1;
    @BindView(R.id.recycle_no2)
    MyRecycleView mRecycleNo2;
    @BindView(R.id.viewpagertab)
    SmartTabLayout mViewpagertab;
    @BindView(R.id.viewpager)
    ViewPager mViewpager;
    @BindView(R.id.souye_category)
    LinearLayout mSouyeCategory;
    @BindView(R.id.separate_line)
    TextView mSeparateLine;
    @BindView(R.id.scrollView)
    MYNestedScrollView mScrollView;
    @BindView(R.id.rl_tab)
    RelativeLayout mRlTab;
    @BindView(R.id.smtab_two)
    SmartTabLayout mSmtabTwo;
    private ShouYeAdapter1 mAdapter1;
    private ShouYeAdapter2 mAdapter2;
    private Toolbar mTabMain;
    private int mMTabMainHeight;


    @Override
    protected int setLayout() {
        return R.layout.fm_souye;
    }


    @Override
    protected void initView() {
        //初始化适配器
        mAdapter1 = new ShouYeAdapter1(getContext(), null);
        mRecycleNo1.setLayoutManager(new GridLayoutManager(getContext(), 4));
        mRecycleNo1.setAdapter(mAdapter1);
        //获取屏幕宽度用于适配
        Display display = getActivity().getWindowManager().getDefaultDisplay();
        int width = display.getWidth();
        mAdapter2 = new ShouYeAdapter2(getContext(), null, width);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecycleNo2.setLayoutManager(layoutManager);
        mRecycleNo2.setTag("outter");
        mRecycleNo2.setAdapter(mAdapter2);

        //初始化SmartTabLayout和适配器
        FragmentManager manager = getChildFragmentManager();
        FragmentPagerItemAdapter pageAdapter = new FragmentPagerItemAdapter(manager,
                FragmentPagerItems.with(getActivity())
                        .add("精选", JingXuanFragment.class)
                        .add("大家喜欢", AllFavorFragment.class)
                        .create());
        mViewpager.setAdapter(pageAdapter);
        mViewpagertab.setViewPager(mViewpager);
        mSmtabTwo.setViewPager(mViewpager);
        fixViewPageTabHeight();

        getPresenter().getRecv1Data();
        getPresenter().getRecv2Data();
    }

    @Override
    protected void bindData() {


    }

    private void fixViewPageTabHeight() {

        mTabMain = getActivity().findViewById(R.id.tb_main);
        mMTabMainHeight = ComponentUtil.getComponentHeight(mTabMain);
        int mViewpagertabHeight = ComponentUtil.getComponentHeight(mViewpagertab);
        int windowHeight = getActivity().getWindowManager().getDefaultDisplay().getHeight();

        ViewGroup.LayoutParams layoutParams = mViewpager.getLayoutParams();
        layoutParams.height = windowHeight - mMTabMainHeight - mViewpagertabHeight;
        mViewpager.setLayoutParams(layoutParams);
    }


    @Override
    protected void bindListenter() {
        mScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView nestedScrollView, int i, int i1, int i2, int i3) {
                int[] location = new int[2];
                mViewpagertab.getLocationOnScreen(location);
                int yTop = location[1];
                if (yTop < mMTabMainHeight) {//Viewpagertab已滑过顶部
                    mRlTab.setVisibility(View.VISIBLE);
                    mScrollView.setNeedScroll(false);
                } else if (mRlTab.getVisibility() == View.VISIBLE) {
                    mRlTab.setVisibility(View.GONE);
                    mScrollView.setNeedScroll(true);
                }
            }
        });

        mViewpagertab.setOnTabClickListener(new SmartTabLayout.OnTabClickListener() {
            @Override
            public void onTabClicked(int position) {
                mViewpager.setCurrentItem(position);
            }
        });
        mAdapter1.setOnItemClickLisener(this);
    }

    @Override
    protected ShouyeFragmentPresenter createPresenter() {
        return new ShouyeFragmentPresenter(this);
    }


    public static ShouYeFragment newInstance() {
        if (fragment == null) {
            fragment = new ShouYeFragment();
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
    public void requestRev1Success(ShouYeCategoryBean bean) {
        mAdapter1.setData(bean.getData());
    }

    @Override
    public void requestRev1Failed() {}

    @Override
    public void requestRev2Success(ShouYeTuijianBean bean) {
        ShouYeTuijianBean.DataBean treeBeans = bean.getData();
        mAdapter2.setData(treeBeans == null ? null : treeBeans.getTree());
    }

    @Override
    public void requestRev2Failed() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onItemClick(String keyword) {
        String cate_id = "";
        int cate_class = 3;
        if("女人".equals(keyword)) {
            cate_id = "1601";
        }else if("男人".equals(keyword)) {
            cate_id = "1101";
        }else if("饰品".equals(keyword)) {
            cate_id = "3501";
        }else if("箱包".equals(keyword)) {
            cate_id = "3801";
        }else if("配件".equals(keyword)) {
            cate_id = "2802";
        }else if("生活家居".equals(keyword)) {
            cate_id = "3302";
        }else if("好吃的".equals(keyword)) {
            cate_id = "4003";
        }else if("礼物".equals(keyword)) {
            cate_id = "4601";
        }else {
            cate_id = "1101";
        }
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString(PodListActivity.INT_CATE_ID,cate_id);
        bundle.putString(PodListActivity.CATE_NAME,keyword);
        bundle.putInt(PodListActivity.CATE_CLASS,cate_class);
        intent.putExtra(PodListActivity.BUNDLE_CATE_ID,bundle);
        intent.setClass(getActivity(), PodListActivity.class);
        startActivity(intent);
    }
}
