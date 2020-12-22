package com.davis.mall.ui;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.davis.mall.R;
import com.davis.mall.adapter.RvCategoryAdapter;
import com.davis.mall.adapter.RvDetailAdapter;
import com.davis.mall.bean.CategoryBannerBean;
import com.davis.mall.bean.CategoryBean;
import com.davis.mall.bean.CategoryMuluBean;
import com.davis.mall.interfac.IFenLeiFragment;
import com.davis.mall.presenter.FenLeiFragmentPresenter;
import com.davis.mall.ui.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * @author 王阳
 * @time 2019/11/2  0:30
 * @desc
 */
public class FenLeiFragment extends BaseFragment<FenLeiFragmentPresenter> implements IFenLeiFragment,RvDetailAdapter.RvDetailOnItemClickLisener {

    private static FenLeiFragment fragment;
    @BindView(R.id.rv_category)
    RecyclerView mRvCategory;
    @BindView(R.id.rv_detail_list)
    RecyclerView mRvDetailList;
    private RvDetailAdapter mCatogeryDetailAdapter;
    private RvCategoryAdapter mCatogeryAdapter;
    private List<CategoryMuluBean.DataBean.ListBean> mListBeans;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    protected int setLayout() {
        return R.layout.fm_fenlei;
    }

    @Override
    protected void initView() {
        //左边recycleview初始化
        mCatogeryAdapter = new RvCategoryAdapter(null);
        LinearLayoutManager manager1 = new LinearLayoutManager(getActivity());
        manager1.setOrientation(LinearLayoutManager.VERTICAL);
        mRvCategory.setLayoutManager(manager1);
        mRvCategory.setAdapter(mCatogeryAdapter);

        //右边recycleview初始化
        final LinearLayoutManager manager2 = new LinearLayoutManager(getActivity());
        manager2.setOrientation(LinearLayoutManager.VERTICAL);
        mRvDetailList.setLayoutManager(manager2);
        mCatogeryDetailAdapter = new RvDetailAdapter(getActivity(),null);
        mRvDetailList.setAdapter(mCatogeryDetailAdapter);
    }


    @Override
    protected void bindData() {
        //只加载一次
        if(mListBeans==null) {
            getPresenter().getleftRvList();
            getPresenter().getBannerList();
            getPresenter().getCategoryRightList("14");//默认初始化第一个
        }
    }

    @Override
    protected void bindListenter() {
        mCatogeryAdapter.setOnItemClick(new RvCategoryAdapter.OnTextViewClickLisener(){
            @Override
            public void changItemSelectedBg(int selectedPosition, int curPosition) {
                //如果curPosition对应的item已经被滑动出屏幕，这里获取的curView就为空，会报空指针异常
                TextView curView = (TextView) mRvCategory.getLayoutManager().findViewByPosition(curPosition);
                if(curView!=null) {//这个组件用户看不到时为空，因为adapter要在滑动到看见它为止才会初始化
                    curView.setBackgroundColor(getResources().getColor(R.color.pageBackground));
                    curView.setTextSize(14);
                    curView.setTypeface(Typeface.DEFAULT, Typeface.NORMAL);
                }

                TextView selectedView = (TextView) mRvCategory.getLayoutManager().findViewByPosition(selectedPosition);
                selectedView.setBackgroundColor(getResources().getColor(R.color.WHITE));
                selectedView.setTextSize(18);
                selectedView.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
            }
            @Override
            public void onClick(int position) {
                if(mListBeans!=null&&mListBeans.size()>0) {
                    Log.e("changItemSelectedBg", "excute："+position);
                    getPresenter().getCategoryRightList(mListBeans.get(position).getId()+"");
                }
            }
        });
        mCatogeryDetailAdapter.setOnItemClick(this);
    }

    @Override
    protected FenLeiFragmentPresenter createPresenter() {
        return new FenLeiFragmentPresenter(this);
    }

    public static FenLeiFragment newInstance() {
        if (fragment == null) {
            fragment = new FenLeiFragment();
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
    public void requestSuccess1(CategoryMuluBean categoryBean) {
        mListBeans = categoryBean.getData().getList();
        mCatogeryAdapter.setNewData(categoryBean.getData().getList() ==null? new ArrayList<>():categoryBean.getData().getList());
    }

    @Override
    public void requestSuccess2(CategoryBannerBean categoryBannerBean) {
        mCatogeryDetailAdapter.setHeadViewData(categoryBannerBean.getData());
    }

    @Override
    public void requestSuccess3(CategoryBean categoryBean) {
        mCatogeryDetailAdapter.setData(categoryBean.getData().getTree());
    }

    @Override
    public void onContentItemClick(String cate_id,int cate_class,String name) {

        //这里因为数据库录入数据过于麻烦，1级分类下的数据都一样
        switch (mCatogeryAdapter.curPosition) {
            case 0 :
                cate_id = "1101";
                break;
            case 1 :
                cate_id = "1601";
                break;
            case 2 :
                cate_id = "1901";
                break;
            case 3 :
                cate_id = "2802";
                break;
            case 4 :
                cate_id = "2802";
                break;
            case 5 :
                cate_id = "3302";
                break;
            case 6 :
                cate_id = "3501";
                break;
            case 7 :
                cate_id = "3801";
                break;
            case 8 :
                cate_id = "4003";
                break;
            case 9 :
                cate_id = "4401";
                break;
            case 10 :
                cate_id = "4503";
                break;
            case 11 :
                cate_id = "4601";
                break;
            case 12 :
                cate_id = "4801";
                break;
        }


        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString(PodListActivity.INT_CATE_ID,cate_id);
        bundle.putString(PodListActivity.CATE_NAME,name);
        bundle.putInt(PodListActivity.CATE_CLASS,cate_class);
        intent.putExtra(PodListActivity.BUNDLE_CATE_ID,bundle);
        intent.setClass(getActivity(), PodListActivity.class);
        startActivity(intent);
    }

    @Override
    public void onHeadClick(String position) {
        //TODO 头部广告的点击
    }
}
