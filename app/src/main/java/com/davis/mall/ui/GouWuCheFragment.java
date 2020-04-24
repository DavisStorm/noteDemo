package com.davis.mall.ui;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.davis.mall.MallApplication;
import com.davis.mall.R;
import com.davis.mall.adapter.GouWuCheAdapter;
import com.davis.mall.bean.GouWuCheBean;
import com.davis.mall.bean.GouwWuCheOuterBean;
import com.davis.mall.interfac.IGouWuCheFragment;
import com.davis.mall.presenter.GouWuCheFragmentPresenter;
import com.davis.mall.ui.base.BaseFragment;
import com.davis.mall.utils.Constance;
import com.davis.mall.utils.SimpleAlertDialogUtil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import butterknife.BindView;

import static android.app.Activity.RESULT_OK;

/**
 * @author 王阳
 * @time 2019/11/2  0:30
 * @desc
 */
public class GouWuCheFragment extends BaseFragment<GouWuCheFragmentPresenter> implements IGouWuCheFragment, View.OnClickListener, GouWuCheAdapter.OnSumChangeLisener {


    private static GouWuCheFragment fragment;
    @BindView(R.id.rv_gouwu)
    RecyclerView mRvGouwu;
    @BindView(R.id.rb_ifchooseAll)
    CheckBox rbIfchooseAll;
    @BindView(R.id.rl_choose_icon)
    RelativeLayout mRlChooseIcon;
    @BindView(R.id.tv_heji)
    TextView mTvHeji;
    @BindView(R.id.tv_heji_rmb)
    TextView mTvHejiRmb;
    @BindView(R.id.tv_heji_price_main)
    TextView mTvHejiPriceMain;
    @BindView(R.id.tv_youhui)
    TextView mTvYouhui;
    @BindView(R.id.tv_youhui_rmb)
    TextView mTvYouhuiRmb;
    @BindView(R.id.tv_youhui_price_main)
    TextView mTvYouhuiPriceMain;
    @BindView(R.id.btn_jiesuan)
    Button mBtnJiesuan;
    @BindView(R.id.btn_edit)
    Button mBtnEdit;
    @BindView(R.id.rl_jiesuan)
    RelativeLayout mRlJiesuan;
    @BindView(R.id.btn_complete)
    Button mBtnComplete;
    @BindView(R.id.btn_delete)
    Button mBtnDelete;
    @BindView(R.id.rl_delete)
    RelativeLayout mRlDelete;
    private GouWuCheAdapter mAdapter;
    private LinearLayoutManager mLayoutManager;
    private ArrayList<Object> mTransformBean;


    @Override
    protected int setLayout() {
        return R.layout.fm_gouwuche;
    }

    @Override
    protected void initView() {
        if (mTransformBean == null) {
            mAdapter = new GouWuCheAdapter(getActivity(), null, this);
            mLayoutManager = new LinearLayoutManager(getActivity());
            mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            mRvGouwu.setLayoutManager(mLayoutManager);
            mRvGouwu.setAdapter(mAdapter);
        }
    }

    @Override
    protected void bindData() {
        if (MallApplication.IF_LOGIN_IN) {
            getPresenter().getGouWuCheByUserId(MallApplication.getUSER().getUser_id());
        } else {
            Toast.makeText(getActivity(), "请先登录", Toast.LENGTH_LONG).show();
            Intent intent = new Intent();
            intent.setClass(getActivity(),LoginActivity.class);
            startActivityForResult(intent, Constance.REQUEST_CODE);
        }
        onDelete();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode== RESULT_OK) {
            switch (requestCode) {
                case Constance.REQUEST_CODE:
                    lazyload();
                    break;
            }
        }

    }

    @Override
    protected void bindListenter() {
        mBtnEdit.setOnClickListener(this);
        mBtnComplete.setOnClickListener(this);
        mBtnDelete.setOnClickListener(this);
        rbIfchooseAll.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                ArrayList<Object> data = mAdapter.getData();
                if(data==null && data.size()==0) {
                    return;
                }
                GouwWuCheOuterBean outterBean = (GouwWuCheOuterBean) data.get(0);
                int podnum = 0; //已选商品数量
                int totalSum = 0;
                for (int i = 0; i < data.size(); i++) {
                    Object item = data.get(i);
                    if(isChecked) {//选择所有商品，修改adapter内mdata的值
                        if(item instanceof GouWuCheBean.DataBean.ListBean) {
                            GouWuCheBean.DataBean.ListBean bean = (GouWuCheBean.DataBean.ListBean) item;
                            podnum += bean.getPod_num();
                            totalSum += bean.getPrice()*bean.getPod_num();
                        }
                    }else {
                        //一个商品都不选，修改adapter内mdata的值
                        if(item instanceof GouwWuCheOuterBean){
                            outterBean = (GouwWuCheOuterBean) item;
                            outterBean.setSelected_num(0);
                            outterBean.setYouhui_sum(0);
                        }
                    }
                    if(item instanceof GouWuCheBean.DataBean.ListBean) {
                        GouWuCheBean.DataBean.ListBean bean = (GouWuCheBean.DataBean.ListBean) item;
                        bean.setIfSelected(isChecked);
                    }else if(item instanceof GouwWuCheOuterBean) {
                        outterBean.setSelected_num(podnum); //计算选中商品的数量
                        if(podnum==2) {//计算优惠金额
                            int cutSum = totalSum - (int) Math.floor(totalSum * 0.8);
                            outterBean.setYouhui_sum(cutSum);
                        }else if(podnum>=3) {
                            int cutSum = totalSum - (int) Math.floor(totalSum * 0.7);
                            outterBean.setYouhui_sum(cutSum);
                        }else {
                            outterBean.setYouhui_sum(0);
                        }
                        outterBean = (GouwWuCheOuterBean) item;
                        podnum = 0;
                    }
                }
                mAdapter.notifyDataSetChanged();
                countTotalSum(data);
            }
        });

    }

    @Override
    protected GouWuCheFragmentPresenter createPresenter() {
        return new GouWuCheFragmentPresenter(this);
    }

    public static GouWuCheFragment newInstance() {
        if (fragment == null) {
            fragment = new GouWuCheFragment();
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
    public void requestSuccess(GouWuCheBean gouWuCheBean) {
        mTransformBean = transformBean(gouWuCheBean);
        mAdapter.setData(mTransformBean);
    }

    private ArrayList<Object> transformBean(GouWuCheBean gouWuCheBean) {
        List<GouWuCheBean.DataBean.ListBean> list = gouWuCheBean.getData().getList();
        if (list == null) {
            return new ArrayList<>();
        }
        boolean ifcontin = true;
        ArrayList<Object> resultList = new ArrayList<>();
        while (ifcontin) {
            GouwWuCheOuterBean gouwWuCheOuterBean;
            if (list.size() > 0) {

                GouWuCheBean.DataBean.ListBean bean = list.get(0);
                gouwWuCheOuterBean = new GouwWuCheOuterBean();
                gouwWuCheOuterBean.setDianpu_id(bean.getDianpu_id());
                gouwWuCheOuterBean.setStore_name(bean.getStore_name());
                gouwWuCheOuterBean.setYouhui_name(bean.getYouhui_name());
                gouwWuCheOuterBean.setYouhui_type(bean.getYouhui_type());
                int i_num = 1;
                gouwWuCheOuterBean.setDianpu_pod_num(i_num);

                resultList.add(gouwWuCheOuterBean);
                resultList.add(bean);
                list.remove(bean);

                Iterator<GouWuCheBean.DataBean.ListBean> iterator = list.iterator();

                while (iterator.hasNext()) {
                    GouWuCheBean.DataBean.ListBean innerNext = iterator.next();
                    if (innerNext.getDianpu_id() == gouwWuCheOuterBean.getDianpu_id()) {
                        i_num++;
                        gouwWuCheOuterBean.setDianpu_pod_num(i_num);
                        resultList.add(innerNext);
                        iterator.remove();
                    }
                }

            } else {
                ifcontin = false;
            }
        }
        return resultList;

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_edit:
                mRlJiesuan.setVisibility(View.GONE);
                mRlDelete.setVisibility(View.VISIBLE);
                break;
            case R.id.btn_complete:
                mRlJiesuan.setVisibility(View.VISIBLE);
                mRlDelete.setVisibility(View.GONE);
                break;
            case R.id.btn_delete:
                SimpleAlertDialogUtil.showConfirmDialog(getActivity(), "是否确定删除", new SimpleAlertDialogUtil.DialogCallBack() {
                    @Override
                    protected void confirmCallback() {
                        mAdapter.startDelete();
                    }

                    @Override
                    protected void cancelCallback() {
                    }
                });
                break;
        }
    }

    @Override
    public void onSumChange(int position, ArrayList<Object> data) {
        View view = mLayoutManager.findViewByPosition(position);
        TextView tvYman = null;
        if (view != null) {
            tvYman = view.findViewById(R.id.tv_yiman);
        }
        //计算出每个店铺的优惠价格
        int totalSum = 0;//这个店铺已选总金额
        int cutSum = 0;//这个店铺优惠的金额
        int selectedNum = 0;//这个店铺下有几件商品被选中
        if (data.size() > position + 1) {//说明这个店铺下有商品
            for (int i = position + 1; i < data.size(); i++) {
                Object item = data.get(i);
                if (item instanceof GouWuCheBean.DataBean.ListBean) {
                    GouWuCheBean.DataBean.ListBean itembean = (GouWuCheBean.DataBean.ListBean) item;
                    boolean ifSelected = itembean.isIfSelected();
                    if (ifSelected) {
                        totalSum += itembean.getPrice() * itembean.getPod_num();
                        selectedNum = selectedNum + itembean.getPod_num();
                    }
                } else if (item instanceof GouwWuCheOuterBean) {
                    break;
                }
            }
        }
        GouwWuCheOuterBean dianpiBean = new GouwWuCheOuterBean();
        if (data.get(position)!=null && data.get(position) instanceof GouwWuCheOuterBean) {
            dianpiBean = (GouwWuCheOuterBean) data.get(position);
        }
        if (dianpiBean.getYouhui_type() == 1) {//多买多优惠
            if (selectedNum == 2) {
                cutSum = totalSum - (int) Math.floor(totalSum * 0.8);
                if (tvYman != null) {//这里为什么要判断为空呢？因为当这个item还没有显示到窗口的时候，得到tvYman是null，所以我们需要在adapter的onAttatch...方法中再处理
                    tvYman.setText("已满2件，已减" + cutSum + "元");
                }
            } else if (selectedNum >= 3) {
                cutSum = totalSum - (int) Math.floor(totalSum * 0.7);
                if (tvYman != null) {
                    tvYman.setText("已满3件，已减" + cutSum + "元");
                }
            } else {
                if (tvYman != null) {
                    tvYman.setText("2件8折，3件7折");
                }
            }
        } else if (dianpiBean.getYouhui_type() == 2) {//满减
            if (totalSum >= 300) {
                cutSum = 50;
                if (tvYman != null) {
                    tvYman.setText("已满300，已减50");
                }
            } else {
                if (tvYman != null) {
                    tvYman.setText("满300减50");
                }
            }
        }
        //同步adapter数据
        dianpiBean.setYouhui_sum(cutSum);
        dianpiBean.setSelected_num(selectedNum);

        //计算总价和总优惠
        countTotalSum(data);
    }

    private void countTotalSum(ArrayList<Object> data) {//计算总价和总优惠
        int allPodSum = 0;//优惠前总金额
        int allPodCutSum = 0;//已优惠的金额
        for (int i = 0; i < data.size(); i++) {
            Object item = data.get(i);
            if (item instanceof GouwWuCheOuterBean) {
                GouwWuCheOuterBean beanOtter = (GouwWuCheOuterBean) item;
                allPodCutSum += beanOtter.getYouhui_sum();
            } else if (item instanceof GouWuCheBean.DataBean.ListBean) {
                GouWuCheBean.DataBean.ListBean beanInner = (GouWuCheBean.DataBean.ListBean) item;
                if (beanInner.isIfSelected()) {
                    allPodSum += beanInner.getPrice() * beanInner.getPod_num();

                }
            }
        }
        mTvHejiPriceMain.setText((allPodSum - allPodCutSum) + ".00");
        mTvYouhuiPriceMain.setText(allPodCutSum + ".00");
    }

    @Override
    public void onDelete() {
        mTvHejiPriceMain.setText("0.00");
        mTvYouhuiPriceMain.setText("0.00");
    }

}
