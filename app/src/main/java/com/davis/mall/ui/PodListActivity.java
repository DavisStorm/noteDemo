package com.davis.mall.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aspsine.swipetoloadlayout.OnLoadMoreListener;
import com.aspsine.swipetoloadlayout.OnRefreshListener;
import com.aspsine.swipetoloadlayout.SwipeToLoadLayout;
import com.davis.mall.R;
import com.davis.mall.adapter.BaseQuickAdapter;
import com.davis.mall.adapter.FuwuzekouRvAdapter;
import com.davis.mall.adapter.PingpaiRvAdapter;
import com.davis.mall.adapter.PodListRvAdapter;
import com.davis.mall.bean.FUWUZEKOUbEAN;
import com.davis.mall.bean.PODDetaliBean;
import com.davis.mall.bean.PingpaiBean;
import com.davis.mall.interfac.IPodListActivity;
import com.davis.mall.presenter.PodListActivityPresenter;
import com.davis.mall.ui.base.BaseActivity;
import com.davis.mall.utils.StatusBarUtil;
import com.davis.mall.views.ClassicLoadMoreFooterView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;

/**
 * @author 王阳
 * @time 2019/12/19  0:53
 * @desc
 */
public class PodListActivity extends BaseActivity<PodListActivityPresenter> implements IPodListActivity, View.OnClickListener, OnRefreshListener, OnLoadMoreListener {
    public static String INT_CATE_ID = "int_cate_id";
    public static String CATE_NAME = "";
    public static String BUNDLE_CATE_ID = "bundle_cate_id";
    public static String CATE_CLASS = "cate_class";
    @BindView(R.id.img_back)
    ImageView mImgBack;
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.img_search)
    ImageView mImgSearch;
    @BindView(R.id.rl_search)
    RelativeLayout mRlSearch;
    @BindView(R.id.ll_order_keyword)
    LinearLayout mLlOrderKeyword;
    @BindView(R.id.v_divider)
    View mVDivider;
    @BindView(R.id.swipe_target)
    RecyclerView mRvPodList;
    @BindView(R.id.tv_first)
    TextView mTvFirst;
    @BindView(R.id.tv_second)
    TextView mTvSecond;
    @BindView(R.id.tv_third)
    TextView mTvThird;
    @BindView(R.id.tv_forth)
    TextView mTvForth;
    @BindView(R.id.swipeToLoadLayout)
    SwipeToLoadLayout mSwipeToLoadLayout;
    @BindView(R.id.ivArrow)
    ImageView mIvArrow;
    @BindView(R.id.ivSuccess_refresh)
    ImageView mIvSuccessRefresh;
    @BindView(R.id.progressbar_refresh)
    ProgressBar mProgressbarRefresh;
    @BindView(R.id.tvRefresh)
    TextView mTvRefresh;
    @BindView(R.id.progressbar_loadmore)
    ProgressBar mProgressbarLoadmore;
    @BindView(R.id.ivSuccess_loadmore)
    ImageView mIvSuccessLoadmore;
    @BindView(R.id.tvLoadMore)
    TextView mTvLoadMore;
    @BindView(R.id.dl_left_main)
    DrawerLayout mDlLeftMain;
    @BindView(R.id.ll_draw)
    LinearLayout ll_draw;
    @BindView(R.id.tv_fuwuzekou)
    TextView mTvFuwuzekou;
    @BindView(R.id.rv_fuwuzekou)
    RecyclerView mRvFuwuzekou;
    @BindView(R.id.tv_jiagequjian)
    TextView mTvJiagequjian;
    @BindView(R.id.et_price_start)
    EditText mEtPriceStart;
    @BindView(R.id.et_price_end)
    EditText mEtPriceEnd;
    @BindView(R.id.tv_pingpai)
    TextView mTvPingpai;
    @BindView(R.id.rv_pingpai)
    RecyclerView mRvPingpai;
    @BindView(R.id.btn_reset)
    Button mBtnReset;
    @BindView(R.id.btn_saixuan_confirm)
    Button mBtnSaixuanConfirm;
    @BindView(R.id.swipe_load_more_footer)
    ClassicLoadMoreFooterView mClassicFooter;
    private String mCate_id;
    private int mCate_class;
    private PodListRvAdapter mPodListRvAdapter;
    private PopupWindow mWindow;
    private String currentOrder = "favNum";
    private int curPerpage = 10;
    private FuwuzekouRvAdapter mFuwuzekouadapter;
    HashMap<Integer, Integer> pinPaiHash = new HashMap<>();
    private PingpaiRvAdapter mPingpaiadapter;
    private ArrayList<String> mMPingpaiSelected;
    private ArrayList<String> mMFuwuzekouaSelected;
    private String mPriceStart;
    private String mPriceEnd;
    private ArrayList<String> mMPingpaiSelectedId;
    private String orderString = "DESC";

    @Override
    protected int getLayout() {
        return R.layout.activity_podlist;
    }

    @Override
    protected void bindView() {
        StatusBarUtil.enableTranslucentStatusBar(this);
        Bundle bundle = getIntent().getBundleExtra(BUNDLE_CATE_ID);
        mCate_id = bundle.getString(INT_CATE_ID);
        mCate_class = bundle.getInt(CATE_CLASS);
        mTvTitle.setText(bundle.getString(CATE_NAME));

        GridLayoutManager manager = new GridLayoutManager(this, 2);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mRvPodList.setLayoutManager(manager);
        mPodListRvAdapter = new PodListRvAdapter(this, null);
        mRvPodList.setAdapter(mPodListRvAdapter);

        //设置popupwindow
        View contentView = LayoutInflater.from(this).inflate(R.layout.popupwindow_simple_text, null, false);
        WindowManager windowManager = getWindow().getWindowManager();
        int width = windowManager.getDefaultDisplay().getWidth();
        mWindow = new PopupWindow(contentView, width, 241, true);
        mWindow.setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        mWindow.setOutsideTouchable(true);
        mWindow.setTouchable(true);

        contentView.findViewById(R.id.tv_hot).setOnClickListener(this);
        contentView.findViewById(R.id.tv_new).setOnClickListener(this);

        //设置侧滑菜单栏在状态栏之下
        Resources resources = getResources();
        int resourceId = resources.getIdentifier("status_bar_height", "dimen", "android");
        int height = resources.getDimensionPixelSize(resourceId);
        DrawerLayout.LayoutParams layoutParams = (DrawerLayout.LayoutParams) ll_draw.getLayoutParams();
        layoutParams.topMargin = height;
        ll_draw.setLayoutParams(layoutParams);

    }

    @Override
    protected void bindData() {

        mSwipeToLoadLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                mSwipeToLoadLayout.setRefreshing(true);
            }
        }, 100);
        getPresenter().getPodList(mCate_id, 10, "[\""+currentOrder+" "+orderString+"\"]", mPriceStart, mPriceEnd, mMPingpaiSelectedId);
        getPresenter().getFuwuZekouList();

        getPresenter().getPinpai(getFenzhiIdByCateId());
    }

    private int getFenzhiIdByCateId() {
        pinPaiHash.put(1101, 1);
        pinPaiHash.put(1601, 2);
        pinPaiHash.put(1901, 14);
        pinPaiHash.put(2802, 16);
        pinPaiHash.put(3302, 18);
        pinPaiHash.put(3501, 20);
        pinPaiHash.put(3801, 22);
        pinPaiHash.put(4003, 24);
        pinPaiHash.put(4401, 26);
        pinPaiHash.put(4503, 29);
        pinPaiHash.put(4601, 31);
        pinPaiHash.put(4801, 33);
        return pinPaiHash.get(Integer.valueOf(mCate_id));
    }

    @Override
    protected void bindLisener() {
        mTvFirst.setOnClickListener(this);
        mTvSecond.setOnClickListener(this);
        mTvForth.setOnClickListener(this);
        mTvThird.setOnClickListener(this);

        mSwipeToLoadLayout.setOnLoadMoreListener(this);
        mSwipeToLoadLayout.setOnRefreshListener(this);

        mWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                Drawable drawable = getResources().getDrawable(R.drawable.spread);
                mTvFirst.setCompoundDrawablesWithIntrinsicBounds(null, null, drawable, null);
                String tag = (String) mTvFirst.getTag();
                TextView tvHot = mWindow.getContentView().findViewById(R.id.tv_hot);
                TextView tvNew = mWindow.getContentView().findViewById(R.id.tv_new);
                tvHot.setTextColor(getResources().getColor("1".equals(tag) ? R.color.RED : R.color.BLACK));
                tvNew.setTextColor(getResources().getColor("1".equals(tag) ? R.color.BLACK : R.color.RED));
                mTvFirst.setText("1".equals(tag) ? "最热" : "最新");
            }
        });
        mPodListRvAdapter.setOnRecyclerViewItemClickListener(new BaseQuickAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                int cate_id = mPodListRvAdapter.getData().get(position).getCate_id();
                Intent intent = new Intent();
                intent.putExtra(PODDetailActivity.CATE_ID_FOR_RESULT, cate_id);
                intent.setClass(PodListActivity.this, PODDetailActivity.class);
                startActivity(intent);
            }
        });
        mBtnSaixuanConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO 品牌只能搜索一个
                mMFuwuzekouaSelected = mFuwuzekouadapter.getCurrentSelected();
                mMPingpaiSelected = mPingpaiadapter.getCurrentSelected();
                mMPingpaiSelectedId = mPingpaiadapter.getCurrentSelectedId();
                mPriceStart = mEtPriceStart.getText().toString();
                mPriceEnd = mEtPriceEnd.getText().toString();
                if (mDlLeftMain.isDrawerOpen(GravityCompat.END)) {
                    mDlLeftMain.closeDrawer(GravityCompat.END);
                }
                getPresenter().getPodList(mCate_id, 10, "[\"" + currentOrder + " "+orderString+"\"]",
                        mPriceStart, mPriceEnd, mMPingpaiSelectedId);
            }
        });
        mBtnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFuwuzekouadapter.onReset();
                mPingpaiadapter.onReset();
                mEtPriceStart.setText("");
                mEtPriceEnd.setText("");
                mPriceStart = "";
                mPriceEnd = "";
                mMPingpaiSelected = new ArrayList<>();
                mMPingpaiSelectedId = new ArrayList<>();
            }
        });
        mImgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getBack();
            }
        });
        mImgSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(PodListActivity.this,SearchGoodsActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onRefresh() {
        getPresenter().getPodList(mCate_id, 10, "[\"" + currentOrder + " "+orderString+"\"]", mPriceStart, mPriceEnd, mMPingpaiSelectedId);
        mTvFirst.setTag("2");
        TextView tvHot = mWindow.getContentView().findViewById(R.id.tv_hot);
        TextView tvNew = mWindow.getContentView().findViewById(R.id.tv_new);
        tvHot.setTextColor(getResources().getColor(R.color.BLACK));
        tvNew.setTextColor(getResources().getColor(R.color.RED));
        mTvFirst.setText("最新");
    }

    @Override
    public void onLoadMore() {
        curPerpage = curPerpage + 10;
        getPresenter().getPodListMore(mCate_id, curPerpage, "[\"" + currentOrder + " "+orderString+"\"]", mPriceStart, mPriceEnd, mMPingpaiSelectedId);
    }

    @Override
    protected PodListActivityPresenter createPresenter() {
        return new PodListActivityPresenter(this);
    }


    @Override
    public void onSwiperRefresh(PODDetaliBean pODDetaliBean) {
        Log.e("requestSuccess", "requestSuccess: " + pODDetaliBean.toString());
        mPodListRvAdapter.setData(pODDetaliBean.getData().getList());

        mSwipeToLoadLayout.post(new Runnable() {
            @Override
            public void run() {
                mSwipeToLoadLayout.setRefreshing(false);
            }
        });

    }

    @Override
    public void onSwiperLoadMore(PODDetaliBean pODDetaliBean) {
        List<PODDetaliBean.DataBean.ListBean> beanList = pODDetaliBean.getData().getList();

        List<PODDetaliBean.DataBean.ListBean> adapterOriginalData = mPodListRvAdapter.getData();
        if (adapterOriginalData != null && beanList != null && adapterOriginalData.size() == beanList.size()) {
            mClassicFooter.whenNoMoreData(true);
        }else {
            mPodListRvAdapter.setDataWithPartDataChange(beanList,
                    curPerpage - 10, 10);
        }
        mSwipeToLoadLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                mSwipeToLoadLayout.setLoadingMore(false);
            }
        },500);
    }

    @Override
    public void getFuwuZEkouSuccess(FUWUZEKOUbEAN fUWUZEKOUbEAN) {
        FUWUZEKOUbEAN.DataBean data = fUWUZEKOUbEAN.getData();
        List<FUWUZEKOUbEAN.DataBean.ListBean> dataList = data.getList();

        GridLayoutManager manager = new GridLayoutManager(this, 3);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mRvFuwuzekou.setLayoutManager(manager);
        mFuwuzekouadapter = new FuwuzekouRvAdapter(this, dataList);
        mRvFuwuzekou.setAdapter(mFuwuzekouadapter);
    }

    @Override
    public void getPingpaiSuccess(PingpaiBean pingpaiBean) {
        PingpaiBean.DataBean data = pingpaiBean.getData();
        List<PingpaiBean.DataBean.TreeBean> tree = data.getTree();

        GridLayoutManager manager = new GridLayoutManager(this, 3);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mRvPingpai.setLayoutManager(manager);
        mPingpaiadapter = new PingpaiRvAdapter(this, tree);
        mRvPingpai.setAdapter(mPingpaiadapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_first:
                Drawable drawable = getResources().getDrawable(R.drawable.gather);
                mTvFirst.setCompoundDrawablesWithIntrinsicBounds(null, null, drawable, null);
                mWindow.showAsDropDown(mTvFirst, 0, 0);
                break;
            case R.id.tv_second:
                toptabitemclick(2);
                currentOrder = "sold_num";
                curPerpage = 10;
                getPresenter().getPodList(mCate_id, curPerpage, "[\"" + currentOrder + " "+orderString+"\"]", mPriceStart, mPriceEnd, mMPingpaiSelectedId);
                orderString = "DESC";
                break;
            case R.id.tv_third:
                toptabitemclick(3);
                currentOrder = "price";
                curPerpage = 10;
                String tag = (String) mTvThird.getTag();
                if(tag.equals("up")) {
                    orderString = "ASC";
                    getPresenter().getPodList(mCate_id, curPerpage, "[\"" + currentOrder + " "+orderString+"\"]", mPriceStart, mPriceEnd, mMPingpaiSelectedId);
                    mTvThird.setTag("low");
                }else {
                    orderString = "DESC";
                    getPresenter().getPodList(mCate_id, curPerpage, "[\"" + currentOrder + " "+orderString+"\"]", mPriceStart, mPriceEnd, mMPingpaiSelectedId);
                    mTvThird.setTag("up");
                }
                break;
            case R.id.tv_forth:
                if (mDlLeftMain.isDrawerOpen(GravityCompat.END)) {
                    mDlLeftMain.closeDrawer(GravityCompat.END);
                } else {
                    mDlLeftMain.openDrawer(GravityCompat.END);
                }
                break;
            case R.id.tv_hot:
                TextView view = (TextView) v;
                view.setTextColor(getResources().getColor(R.color.RED));
                mTvFirst.setTag("1");
                toptabitemclick(1);
                mWindow.dismiss();
                currentOrder = "favNum";
                curPerpage = 10;
                orderString = "DESC";
                mBtnReset.performClick();
                getPresenter().getPodList(mCate_id, curPerpage, "[\"" + currentOrder + " "+orderString+"\"]", mPriceStart, mPriceEnd, mMPingpaiSelectedId);

                break;
            case R.id.tv_new:
                TextView view2 = (TextView) v;
                view2.setTextColor(getResources().getColor(R.color.RED));
                mTvFirst.setTag("2");
                toptabitemclick(1);
                mWindow.dismiss();
                currentOrder = "update_time";
                curPerpage = 10;
                mBtnReset.performClick();
                getPresenter().getPodList(mCate_id, curPerpage, "[\"" + currentOrder + " "+orderString+"\"]", mPriceStart, mPriceEnd, mMPingpaiSelectedId);
                break;
        }
    }

    private void toptabitemclick(int position) {
        int colorBLACK = getResources().getColor(R.color.BLACK);
        int colorRed = getResources().getColor(R.color.RED);
        mTvFirst.setTextColor(position == 1 ? colorRed : colorBLACK);
        mTvSecond.setTextColor(position == 2 ? colorRed : colorBLACK);
        mTvThird.setTextColor(position == 3 ? colorRed : colorBLACK);
        mTvForth.setTextColor(position == 4 ? colorRed : colorBLACK);
        if(position ==2 || position==3) {
            TextView tvHot = mWindow.getContentView().findViewById(R.id.tv_hot);
            TextView tvNew = mWindow.getContentView().findViewById(R.id.tv_new);
            tvHot.setTextColor(position == 1 ? colorRed : colorBLACK);
            tvNew.setTextColor(position == 1 ? colorRed : colorBLACK);
        }
    }
}
