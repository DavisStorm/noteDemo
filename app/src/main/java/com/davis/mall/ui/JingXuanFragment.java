package com.davis.mall.ui;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aspsine.swipetoloadlayout.OnLoadMoreListener;
import com.aspsine.swipetoloadlayout.SwipeToLoadLayout;
import com.davis.mall.R;
import com.davis.mall.adapter.BaseQuickAdapter;
import com.davis.mall.adapter.PodListRvAdapter;
import com.davis.mall.bean.PODDetaliBean;
import com.davis.mall.interfac.IJingXuanFragment;
import com.davis.mall.presenter.JingXuanFragmentPresenter;
import com.davis.mall.ui.base.BaseFragment;
import com.davis.mall.views.ClassicLoadMoreFooterView;

import java.util.List;

import butterknife.BindView;

/**
 * @author 王阳
 * @time 2019/11/9  22:42
 * @desc
 */
public class JingXuanFragment extends BaseFragment<JingXuanFragmentPresenter> implements IJingXuanFragment, OnLoadMoreListener {

    @BindView(R.id.swipe_target)
    RecyclerView mSwipeTarget;
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
    private PodListRvAdapter mPodListRvAdapter;
    private int curPerpage = 10;

    @Override
    protected int setLayout() {
        return R.layout.fragment_jingxuan;
    }

    @Override
    protected void initView() {
        GridLayoutManager manager = new GridLayoutManager(getActivity(), 2);
        manager.setOrientation(GridLayout.VERTICAL);
        mSwipeTarget.setLayoutManager(manager);
        mPodListRvAdapter = new PodListRvAdapter(getActivity(), null);
        mSwipeTarget.setAdapter(mPodListRvAdapter);
        getPresenter().getTuijianPodList(curPerpage);
    }

    @Override
    protected void bindData() {

    }

    @Override
    protected void bindListenter() {
        mSwipeToLoadLayout.setOnLoadMoreListener(this);
        mPodListRvAdapter.setOnRecyclerViewItemClickListener(new BaseQuickAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                int cate_id = mPodListRvAdapter.getData().get(position).getCate_id();
                Intent intent = new Intent();
                intent.putExtra(PODDetailActivity.CATE_ID_FOR_RESULT, cate_id);
                intent.setClass(getActivity(), PODDetailActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected JingXuanFragmentPresenter createPresenter() {
        return new JingXuanFragmentPresenter(this);
    }


    @Override
    public void onLoadMore() {
        curPerpage = curPerpage + 10;
        getPresenter().getTuijianPodList(curPerpage);
    }

    @Override
    public void onSwiperRefresh(PODDetaliBean pODDetaliBean) {
        Log.e("requestSuccess", "requestSuccess: " + pODDetaliBean.toString());
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
        }, 500);
    }
}
