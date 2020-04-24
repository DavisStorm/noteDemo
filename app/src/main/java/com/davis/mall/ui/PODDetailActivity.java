package com.davis.mall.ui;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.davis.mall.R;
import com.davis.mall.adapter.ImageHorizRvAdapter;
import com.davis.mall.adapter.PODDetailPageAdapter;
import com.davis.mall.bean.PODDetaliBean;
import com.davis.mall.interfac.IPODDetailActivity;
import com.davis.mall.presenter.PODDetailActivityPresenter;
import com.davis.mall.ui.base.BaseActivity;
import com.davis.mall.utils.StatusBarUtil;
import com.davis.mall.utils.StringUtil;
import com.davis.mall.utils.ToolbarUtil;
import com.davis.mall.views.WrapContentHeightViewPager;
import com.google.android.material.appbar.AppBarLayout;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;

/**
 * @author 王阳
 * @time 2019/12/19  6:07
 * @desc
 */
public class PODDetailActivity extends BaseActivity<PODDetailActivityPresenter> implements IPODDetailActivity, View.OnClickListener {
    @BindView(R.id.tv_label)
    TextView mTvLabel;
    @BindView(R.id.tv_view_count)
    TextView mTvViewCount;
    @BindView(R.id.fl_toolbar_label)
    FrameLayout mFlToolbarLabel;
    @BindView(R.id.tb_kuai_kan_all_chapter)
    Toolbar mTbKuaiKanAllChapter;
    @BindView(R.id.abl_kuai_kan_all_chapter)
    AppBarLayout mAblKuaiKanAllChapter;
    @BindView(R.id.vp)
    ViewPager mVp;
    @BindView(R.id.tv_shangp)
    TextView mTvShangp;
    @BindView(R.id.tv_xiangqing)
    TextView mTvXiangqing;
    @BindView(R.id.tv_pingjia)
    TextView mTvPingjia;
//    @BindView(R.id.tv_tuijian)
//    TextView mTvTuijian;
    @BindView(R.id.ll_tb_container)
    LinearLayout mLlTbContainer;
    @BindView(R.id.tv_kexuan)
    TextView mTvKexuan;
    @BindView(R.id.rv_kuanxing)
    RecyclerView mRvKuanxing;
    @BindView(R.id.nestscrollview)
    NestedScrollView mNestscrollview;
    @BindView(R.id.vp_fm)
    WrapContentHeightViewPager mVpFm;
    @BindView(R.id.rl_kuanxing)
    RelativeLayout mRlKuanxing;
    @BindView(R.id.diliverline)
    View mDiliverline;
    @BindView(R.id.img_bottom_contact)
    ImageView mImgBottomContact;
    @BindView(R.id.img_bottom_dianpu)
    ImageView mImgBottomDianpu;
    @BindView(R.id.img_bottom_gouwuche)
    ImageView mImgBottomGouwuche;
    @BindView(R.id.btn_add_car)
    Button mBtnAddCar;
    @BindView(R.id.btn_buy_imediatly)
    Button mBtnBuyImediatly;
    @BindView(R.id.rl_gouwuche)
    RelativeLayout rl_gouwuche;

    private PODDetailPageAdapter mPageAdapter;
    private ImageHorizRvAdapter mMImageHorizRvAdapter;

    private int FM_COUNT = 3;
//    private int FM_COUNT = 4;
    private static final int SHANGPIN_INDEX = 0;
    private static final int XIANGQING_INDEX = 1;
    private static final int PINGJIA_INDEX = 2;
//    private static final int TUIJIAN_INDEX = 3;
    public static final String CATE_ID_FOR_RESULT = "CATE_ID_FOR_RESULT";
    private FragmentPagerAdapter mFragmentPagerAdapter;
    private PODDetail_SHANGPINFragment mSHANGPINFragment;
    private PODDetail_XIANGQINGFragment mXIANGQINGFragment;
    private PODDetail_PINGJIAFragment mPINGJIAFragment;
//    private PODDetail_TUIJIANFragment mTUIJIANFragment;
    private String[] mStringsColors;
    private NestedScrollView.OnScrollChangeListener mOnScrollChangeListener;
    private List<String> mStringsResult;
    private PODDetaliBean.DataBean.ListBean infoBean;

    @Override
    protected int getLayout() {
        return R.layout.activity_pod_detail;
    }

    @Override
    protected void bindView() {
        //启动透明状态栏
        StatusBarUtil.enableTranslucentStatusBar(this);
        ToolbarUtil.initToolbar(this, mTbKuaiKanAllChapter);

        mPageAdapter = new PODDetailPageAdapter(this, null);
        mVp.setAdapter(mPageAdapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRvKuanxing.setLayoutManager(layoutManager);
        mMImageHorizRvAdapter = new ImageHorizRvAdapter(this,
                null, new ImageHorizRvAdapter.onItemClickListener() {
            @Override
            public void onItemClicked(int selectedPosition, int selectingPosition) {
                mVp.setCurrentItem(selectingPosition);
                if (mStringsColors != null && mStringsColors.length > 0 && mSHANGPINFragment != null) {
                    mSHANGPINFragment.setColorChoosen(mStringsColors[selectingPosition], selectingPosition);
                }

            }
        });
        mRvKuanxing.setAdapter(mMImageHorizRvAdapter);

        //初始化装fragment的适配器
        initAdapter();

        mVpFm.setAdapter(mFragmentPagerAdapter);

        setFragment(SHANGPIN_INDEX);

    }

    private void initAdapter() {
        mFragmentPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public int getCount() {
                return FM_COUNT;
            }

            @Override
            public Fragment getItem(int position) {
                Fragment fragment = null;
                switch (position) {
                    case SHANGPIN_INDEX:
                        if (mSHANGPINFragment == null) {
                            //监听器回调取值
                            mSHANGPINFragment = PODDetail_SHANGPINFragment.newInstance(PODDetailActivity.this);
                            int[] ints = new int[2];
                            mImgBottomGouwuche.getLocationInWindow(ints);
                            mSHANGPINFragment.setCarImgLocation(ints);
                        }
                        fragment = mSHANGPINFragment;
                        break;
                    case XIANGQING_INDEX:
                        if (mXIANGQINGFragment == null) {
                            mXIANGQINGFragment = PODDetail_XIANGQINGFragment.newInstance();
                            mXIANGQINGFragment.setData(infoBean);
                        }
                        fragment = mXIANGQINGFragment;
                        break;
                    case PINGJIA_INDEX:
                        if (mPINGJIAFragment == null) {
                            mPINGJIAFragment = PODDetail_PINGJIAFragment.newInstance();
                            mPINGJIAFragment.setData(infoBean);
                        }
                        fragment = mPINGJIAFragment;
                        break;
//                    case TUIJIAN_INDEX:
//                        if (mTUIJIANFragment == null) {
//                            mTUIJIANFragment = PODDetail_TUIJIANFragment.newInstance();
//                            mTUIJIANFragment.setData(infoBean);
//                        }
//                        fragment = mTUIJIANFragment;
//                        break;
                }
                return fragment;
            }
        };
    }

    @Override
    protected void bindData() {
        int cate_id = getIntent().getIntExtra(CATE_ID_FOR_RESULT, 0);
        getPresenter().getPODDetailData(cate_id);
    }

    @Override
    protected void bindLisener() {
        mVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                if (mStringsResult != null && mStringsResult.size() > 0) {
                    mTvViewCount.setText((position + 1) + "/" + mStringsResult.size());
                }
                mMImageHorizRvAdapter.setSelectedPosition(position);//因为联动会走两遍,数据到时不会错
                if (mStringsColors != null && mStringsColors.length > 0 && mSHANGPINFragment != null) {
                    mSHANGPINFragment.setColorChoosen(mStringsColors[position], position);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        mTvShangp.setOnClickListener(this);
        mTvXiangqing.setOnClickListener(this);
        mTvPingjia.setOnClickListener(this);
//        mTvTuijian.setOnClickListener(this);
        mOnScrollChangeListener = new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView nestedScrollView, int x, int y, int oldX, int oldY) {
                Log.e("onScrollChange", "int x=" + x + ", int y=" + y + ", int oldX=" + oldX + ", int oldY=" + oldY);
                if (y > 0 && mVpFm.getCurrentItem() == SHANGPIN_INDEX) {
                    mLlTbContainer.setVisibility(View.VISIBLE);
                } else if (mVpFm.getCurrentItem() != SHANGPIN_INDEX) {
                } else {
                    mLlTbContainer.setVisibility(View.GONE);
                }

            }
        };

        mNestscrollview.setOnScrollChangeListener(mOnScrollChangeListener);
        mVpFm.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case SHANGPIN_INDEX:
                        mVp.setVisibility(View.VISIBLE);
                        mRlKuanxing.setVisibility(View.VISIBLE);
                        mDiliverline.setVisibility(View.VISIBLE);
                        mFlToolbarLabel.setVisibility(View.VISIBLE);
                        mLlTbContainer.setVisibility(View.GONE);
                        mTbKuaiKanAllChapter.setBackgroundColor(getColor(R.color.TRANSPARENT));
                        labelChangeWhenScroll(SHANGPIN_INDEX);
                        break;
                    case XIANGQING_INDEX:
                        whenBannerHide();
                        labelChangeWhenScroll(XIANGQING_INDEX);
                        break;
                    case PINGJIA_INDEX:
                        whenBannerHide();
                        labelChangeWhenScroll(PINGJIA_INDEX);
                        break;
//                    case TUIJIAN_INDEX:
//                        whenBannerHide();
//                        labelChangeWhenScroll(TUIJIAN_INDEX);
//                        break;

                }
                //显示scrollview的头部
                mNestscrollview.scrollTo(0, 0);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        mTbKuaiKanAllChapter.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mBtnAddCar.setOnClickListener(this);
        mBtnBuyImediatly.setOnClickListener(this);
        rl_gouwuche.setOnClickListener(this);
    }

    private void whenBannerHide() {
        mVp.setVisibility(View.GONE);
        mRlKuanxing.setVisibility(View.GONE);
        mDiliverline.setVisibility(View.GONE);
        mFlToolbarLabel.setVisibility(View.GONE);
        mLlTbContainer.setVisibility(View.VISIBLE);
        mTbKuaiKanAllChapter.setBackgroundColor(getColor(R.color.ToolbarLight));
    }

    private void labelChangeWhenScroll(int position) {
        Drawable choosenDrawable = getResources().getDrawable(R.drawable.pod_chosen_tab_bg);
        switch (position) {
            case SHANGPIN_INDEX:
                mTvShangp.setBackground(choosenDrawable);
                mTvXiangqing.setBackground(null);
                mTvPingjia.setBackground(null);
//                mTvTuijian.setBackground(null);
                break;
            case XIANGQING_INDEX:
                mTvXiangqing.setBackground(choosenDrawable);
                mTvShangp.setBackground(null);
                mTvPingjia.setBackground(null);
//                mTvTuijian.setBackground(null);
                break;
            case PINGJIA_INDEX:
                mTvPingjia.setBackground(choosenDrawable);
                mTvShangp.setBackground(null);
                mTvXiangqing.setBackground(null);
//                mTvTuijian.setBackground(null);
                break;
//            case TUIJIAN_INDEX:
//                mTvTuijian.setBackground(choosenDrawable);
//                mTvShangp.setBackground(null);
//                mTvXiangqing.setBackground(null);
//                mTvPingjia.setBackground(null);
//                break;
        }

    }


    @Override
    protected PODDetailActivityPresenter createPresenter() {
        return new PODDetailActivityPresenter(this);
    }

    private void setFragment(int index) {
        mVpFm.setCurrentItem(index);
    }

    @Override
    public void onClick(View item) {
        switch (item.getId()) {
            case R.id.tv_shangp:
                setFragment(SHANGPIN_INDEX);
                break;
            case R.id.tv_xiangqing://
                setFragment(XIANGQING_INDEX);
                break;
            case R.id.tv_pingjia://
                setFragment(PINGJIA_INDEX);
                break;
//            case R.id.tv_tuijian://
//                setFragment(TUIJIAN_INDEX);
//                break;
            case R.id.btn_add_car://
                if (mSHANGPINFragment != null) {
                    mSHANGPINFragment.showAddCarDialog();
                }
                break;
            case R.id.btn_buy_imediatly://
                break;
            case R.id.rl_gouwuche://
                Intent intent = new Intent();
                intent.setClass(this,GouWuCarActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onYixuanDialogColorChange(int position) {
        mVp.setCurrentItem(position);
    }

    @Override
    public void requestPODDetaliSuccess(PODDetaliBean pODDetaliBean) {

        PODDetaliBean.DataBean data = pODDetaliBean.getData();
        List<PODDetaliBean.DataBean.ListBean> list = data.getList();
        if (list != null && list.size() > 0) {
            infoBean = list.get(0);
        }
        if (infoBean != null) {
            String bannerImages = infoBean.getBannerImages();
            String[] stringsUrl = StringUtil.splitStringByJInghao(bannerImages);
            mStringsResult = Arrays.asList(stringsUrl);
            mPageAdapter.setData(mStringsResult);
            mMImageHorizRvAdapter.setNewData(mStringsResult);

            //获取款型对应颜色数据(在这里意识到我之前理解的款型和颜色两个数据，其实是一个数据---颜色，所以丢弃款型这个数据，只用颜色)
            mStringsColors = StringUtil.splitStringByJInghao(infoBean.getPod_colors());
            mTvKexuan.setText(mStringsResult.size() + "色可选");
            mTvViewCount.setText("1/" + mStringsResult.size());
            if (mSHANGPINFragment == null) {
                mSHANGPINFragment = PODDetail_SHANGPINFragment.newInstance(PODDetailActivity.this);
            }
            mSHANGPINFragment.setData(infoBean);
            int[] ints = new int[2];
            mImgBottomGouwuche.getLocationInWindow(ints);
            mSHANGPINFragment.setCarImgLocation(ints);
            if (mXIANGQINGFragment == null) {
                mXIANGQINGFragment = PODDetail_XIANGQINGFragment.newInstance();
            }
            mXIANGQINGFragment.setData(infoBean);
            if (mPINGJIAFragment == null) {
                mPINGJIAFragment = PODDetail_PINGJIAFragment.newInstance();

            }
            mPINGJIAFragment.setData(infoBean);
//            if (mTUIJIANFragment == null) {
//                mTUIJIANFragment = PODDetail_TUIJIANFragment.newInstance();
//            }
//            mTUIJIANFragment.setData(infoBean);

        } else {
            Toast.makeText(PODDetailActivity.this, "网络异常", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void jumpToPingjia() {
        mVpFm.setCurrentItem(PINGJIA_INDEX);
    }

}
