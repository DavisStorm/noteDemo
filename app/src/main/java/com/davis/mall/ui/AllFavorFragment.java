package com.davis.mall.ui;

import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aspsine.swipetoloadlayout.OnLoadMoreListener;
import com.aspsine.swipetoloadlayout.SwipeToLoadLayout;
import com.davis.mall.R;
import com.davis.mall.adapter.AllFavorAdapter;
import com.davis.mall.bean.AllFavorBean;
import com.davis.mall.interfac.IAllFavorFragment;
import com.davis.mall.presenter.AllFavorFragmentPresenter;
import com.davis.mall.ui.base.BaseFragment;
import com.davis.mall.views.ClassicLoadMoreFooterView;

import java.util.List;

import butterknife.BindView;

/**
 * @author 王阳
 * @time 2019/11/9  22:42
 * @desc
 */
public class AllFavorFragment extends BaseFragment<AllFavorFragmentPresenter> implements IAllFavorFragment, OnLoadMoreListener {

    @BindView(R.id.swipe_target)
    RecyclerView mRev;
    @BindView(R.id.progressbar_loadmore)
    ProgressBar mProgressbarLoadmore;
    @BindView(R.id.ivSuccess_loadmore)
    ImageView mIvSuccessLoadmore;
    @BindView(R.id.tvLoadMore)
    TextView mTvLoadMore;
    @BindView(R.id.swipeToLoadLayout)
    SwipeToLoadLayout mSwipeToLoadLayout;
    @BindView(R.id.swipe_load_more_footer)
    ClassicLoadMoreFooterView mClassicFooter;
    private AllFavorAdapter mAdapter;
    private int curPerpage = 10;

    @Override
    protected int setLayout() {
        return R.layout.fragment_allfavor;
    }

    @Override
    protected void initView() {
        mAdapter = new AllFavorAdapter(null);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRev.setLayoutManager(layoutManager);
        mRev.setAdapter(mAdapter);
    }

    @Override
    protected void bindData() {
        getPresenter().requestAllFavorData(curPerpage);
    }

    @Override
    protected void bindListenter() {
        mSwipeToLoadLayout.setOnLoadMoreListener(this);
    }

    @Override
    protected AllFavorFragmentPresenter createPresenter() {
        return new AllFavorFragmentPresenter(this);
    }

    @Override
    public void onLoadMore() {
        curPerpage = curPerpage + 10;
        getPresenter().requestAllFavorData(curPerpage);
    }

    @Override
    public void requestSuccess(AllFavorBean bean) {
        List<AllFavorBean.DataBean.ListBean> beanList = bean.getData().getList();
        List<AllFavorBean.DataBean.ListBean> adapterOriginalData = mAdapter.getData();
        if (adapterOriginalData != null && beanList != null && adapterOriginalData.size() == beanList.size()) {
            mClassicFooter.whenNoMoreData(true);
        }else {
            mAdapter.setDataWithPartDataChange(beanList,
                    curPerpage - 10, 10);
        }
        mSwipeToLoadLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                mSwipeToLoadLayout.setLoadingMore(false);
            }
        }, 500);
    }

    @Override
    public void requestFailed() {

    }


}
