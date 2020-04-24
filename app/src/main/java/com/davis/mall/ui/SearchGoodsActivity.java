package com.davis.mall.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.davis.mall.R;
import com.davis.mall.adapter.BaseQuickAdapter;
import com.davis.mall.adapter.KeywordsAdapter;
import com.davis.mall.interfac.ISearchGoodsActivity;
import com.davis.mall.presenter.SearchGoodsActivityPresenter;
import com.davis.mall.ui.base.BaseActivity;
import com.davis.mall.utils.SPUtils;
import com.davis.mall.utils.SimpleAlertDialogUtil;
import com.davis.mall.utils.StatusBarUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;

public class SearchGoodsActivity extends BaseActivity<SearchGoodsActivityPresenter> implements ISearchGoodsActivity, View.OnClickListener {

    @BindView(R.id.et_search)
    EditText mEtSearch;
    @BindView(R.id.rl_search)
    RelativeLayout mRlSearch;
    @BindView(R.id.tv_remen_tag)
    TextView mTvRemenTag;
    @BindView(R.id.ll_firstline)
    LinearLayout mLlFirstline;
    @BindView(R.id.ll_secondline)
    LinearLayout mLlSecondline;
    @BindView(R.id.tv_recentlykeyword)
    TextView mTvRecentlykeyword;
    @BindView(R.id.rl_researched)
    RelativeLayout mRlResearched;
    @BindView(R.id.rv_searched)
    RecyclerView mRvSearched;
    @BindView(R.id.tv_delete)
    TextView mTvDelete;
    @BindView(R.id.tv_line1_1)
    TextView mTvLine11;
    @BindView(R.id.tv_line1_2)
    TextView mTvLine12;
    @BindView(R.id.tv_line1_3)
    TextView mTvLine13;
    @BindView(R.id.tv_line1_4)
    TextView mTvLine14;
    @BindView(R.id.tv_line1_5)
    TextView mTvLine15;
    @BindView(R.id.tv_line2_1)
    TextView mTvLine21;
    @BindView(R.id.tv_line2_2)
    TextView mTvLine22;
    @BindView(R.id.tv_line2_3)
    TextView mTvLine23;
    @BindView(R.id.tv_line2_4)
    TextView mTvLine24;
    @BindView(R.id.tv_line2_5)
    TextView mTvLine25;
    @BindView(R.id.img_back)
    ImageView mImgView;

    public static String CACHE_KEYWORDS = "cahche_keywords";
    private KeywordsAdapter mKeywordsAdapter;

    @Override
    protected int getLayout() {
        return R.layout.activity_search_goods;
    }

    @Override
    protected void bindView() {
        StatusBarUtil.enableTranslucentStatusBar(this);//启动透明状态栏
        Drawable drawableLeft = getResources().getDrawable(R.drawable.sousuo);
        drawableLeft.setBounds(1, 1, 46, 46);
        mEtSearch.setCompoundDrawables(drawableLeft, null, null, null);
        mEtSearch.setCompoundDrawablePadding(20);
        mEtSearch.setPadding(30, 8, 30, 8);

        mKeywordsAdapter = new KeywordsAdapter(null);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRvSearched.setLayoutManager(layoutManager);
        mRvSearched.setAdapter(mKeywordsAdapter);
    }

    @Override
    protected void bindData() {
        List<String> keywordsAsList = getKeywordsAsList();
        Collections.reverse(keywordsAsList);
        mKeywordsAdapter.setNewData(keywordsAsList);
    }

    private List<String> getKeywordsAsList() {
        String keywords = SPUtils.getString(this, SearchGoodsActivity.CACHE_KEYWORDS);
        if (keywords == null || keywords.isEmpty()) {
            return new ArrayList<>();
        } else {
            List<String> asList = Arrays.asList(keywords.split(","));
            return new ArrayList<>(asList);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private String changeKeywordsListAsString(List<String> keywordsAsList) {
        String[] wordsStrings = new String[keywordsAsList.size()];
        return String.join(",", keywordsAsList.toArray(wordsStrings));
    }

    @Override
    protected void bindLisener() {
        mEtSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {//按下搜索
                    List<String> keywordsAsList = getKeywordsAsList();
                    String addingKeyword = mEtSearch.getText().toString();
                    if (addingKeyword.isEmpty()) {
                        Toast.makeText(SearchGoodsActivity.this, "未输入关键字", Toast.LENGTH_SHORT).show();
                        return true;
                    }

                    checkifSearched(keywordsAsList, addingKeyword);

                    String keywordsString = changeKeywordsListAsString(keywordsAsList);
                    SPUtils.putString(SearchGoodsActivity.this, SearchGoodsActivity.CACHE_KEYWORDS, keywordsString);
                    //回收软键盘
                    ((InputMethodManager) mEtSearch.getContext().getSystemService(Context.INPUT_METHOD_SERVICE))
                            .hideSoftInputFromWindow(SearchGoodsActivity.this.getCurrentFocus()
                                    .getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

                    //界面跳转到商品列表页
                    gotoPodActivity(addingKeyword);
                }
                return false;
            }
        });
        mTvDelete.setOnClickListener(this);
        mTvLine11.setOnClickListener(this);
        mTvLine12.setOnClickListener(this);
        mTvLine13.setOnClickListener(this);
        mTvLine14.setOnClickListener(this);
        mTvLine15.setOnClickListener(this);
        mTvLine21.setOnClickListener(this);
        mTvLine22.setOnClickListener(this);
        mTvLine23.setOnClickListener(this);
        mTvLine24.setOnClickListener(this);
        mTvLine25.setOnClickListener(this);

        mKeywordsAdapter.setOnRecyclerViewItemClickListener(new BaseQuickAdapter.OnRecyclerViewItemClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onItemClick(View view, int position) {
                List<String> adapterData = mKeywordsAdapter.getData();

                String keywording = adapterData.get(position);
                //点击的这条改为最新一条搜索记录
                int wordindex = adapterData.indexOf(keywording);
                adapterData.remove(wordindex);
                adapterData.add(0, keywording);
                mKeywordsAdapter.notifyDataSetChanged();
                gotoPodActivity(keywording);
                //同步到SP存储
                List<String> keywordsAsList = getKeywordsAsList();
                checkifSearched(keywordsAsList,keywording);
                String keywordsString = SearchGoodsActivity.this.changeKeywordsListAsString(keywordsAsList);
                SPUtils.putString(SearchGoodsActivity.this, SearchGoodsActivity.CACHE_KEYWORDS, keywordsString);
            }
        });
        mImgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getBack();
            }
        });
    }

    //如果搜索过就设置为搜索的最新一条记录
    private void checkifSearched(List<String> keywordsAsList, String addingKeyword) {
        for (String keywords : keywordsAsList) {
            if (addingKeyword.equals(keywords)) {
                int wordindex = keywordsAsList.indexOf(keywords);
                keywordsAsList.remove(wordindex);
                break;//在for循环中修改自己后还要以自己元素做判断会造成ConcurrentModificationException
            }
        }
        keywordsAsList.add(addingKeyword);
    }


    @Override
    protected SearchGoodsActivityPresenter createPresenter() {
        return new SearchGoodsActivityPresenter(this);
    }

    public void gotoPodActivity(String addingKeyword) {
        //TODO 通过keyword模糊搜索在后台拿到分类id，这里模拟数据
        String cate_id = "";
        int cate_class = 3;
        if("羽绒服".equals(addingKeyword)) {
            cate_id = "1101";
        }else if("裤装".equals(addingKeyword)) {
            cate_id = "1303";
        }else if("护肤".equals(addingKeyword)) {
            cate_id = "1901";
        }else if("电脑".equals(addingKeyword)) {
            cate_id = "2802";
        }else if("家电".equals(addingKeyword)) {
            cate_id = "3302";
        }else if("珠宝".equals(addingKeyword)) {
            cate_id = "3501";
        }else if("箱包".equals(addingKeyword)) {
            cate_id = "3801";
        }else if("零食".equals(addingKeyword)) {
            cate_id = "4003";
        }else if("玩具".equals(addingKeyword)) {
            cate_id = "4401";
        }else if("鲜花".equals(addingKeyword)) {
            cate_id = "4601";
        }else {
            cate_id = "1101";
        }
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString(PodListActivity.INT_CATE_ID,cate_id);
        bundle.putInt(PodListActivity.CATE_CLASS,cate_class);
        bundle.putString(PodListActivity.CATE_NAME,addingKeyword);
        intent.putExtra(PodListActivity.BUNDLE_CATE_ID,bundle);
        intent.setClass(SearchGoodsActivity.this, PodListActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_line1_1:
            case R.id.tv_line1_2:
            case R.id.tv_line1_3:
            case R.id.tv_line1_4:
            case R.id.tv_line1_5:
            case R.id.tv_line2_1:
            case R.id.tv_line2_2:
            case R.id.tv_line2_3:
            case R.id.tv_line2_4:
            case R.id.tv_line2_5:
                gotoPodActivity(((TextView) view).getText().toString());
                break;
            case R.id.tv_delete:
                SimpleAlertDialogUtil.showConfirmDialog(SearchGoodsActivity.this, "清除搜索记录"
                        , new SimpleAlertDialogUtil.DialogCallBack() {
                            @Override
                            protected void confirmCallback() {
                                SPUtils.removeString(SearchGoodsActivity.this, CACHE_KEYWORDS);
                                mKeywordsAdapter.setNewData(new ArrayList<String>());
                            }
                            @Override
                            protected void cancelCallback() {}
                        });
                break;
        }
    }

}
