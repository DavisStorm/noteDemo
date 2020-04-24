package com.davis.mall.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.davis.mall.MallApplication;
import com.davis.mall.R;
import com.davis.mall.bean.AddGouWuCheBean;
import com.davis.mall.bean.AddressBean;
import com.davis.mall.bean.GouWuCheBean;
import com.davis.mall.bean.PODDetaliBean;
import com.davis.mall.interfac.Animationlisener;
import com.davis.mall.interfac.IPODDetailActivity;
import com.davis.mall.interfac.IPODDetail_SHANGPINFragment;
import com.davis.mall.presenter.PODDetail_SHANGPINFragmentPresenter;
import com.davis.mall.ui.base.BaseFragment;
import com.davis.mall.utils.AnimUtils;
import com.davis.mall.utils.StringUtil;
import com.davis.mall.views.AddressDialog;
import com.davis.mall.views.AddressPickDialog;
import com.davis.mall.views.BuyPickDialog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;

/**
 * @author 王阳
 * @time 2019/11/2  0:30
 * @desc
 */
public class PODDetail_SHANGPINFragment extends BaseFragment<PODDetail_SHANGPINFragmentPresenter> implements IPODDetail_SHANGPINFragment,View.OnClickListener {

    private static PODDetail_SHANGPINFragment fragment;
    @BindView(R.id.tv_rmb)
    TextView mTvRmb;
    @BindView(R.id.tv_pricemain)
    TextView mTvPricemain;
    @BindView(R.id.tv_pricecent)
    TextView mTvPricecent;
    @BindView(R.id.img_love)
    ImageView mImgLove;
    @BindView(R.id.tv_love)
    TextView mTvLove;
    @BindView(R.id.rl_guanzhu)
    RelativeLayout mRlGuanzhu;
    @BindView(R.id.img_cutnotice)
    ImageView mImgCutnotice;
    @BindView(R.id.tv_cutnotice)
    TextView mTvCutnotice;
    @BindView(R.id.rl_jiangjia)
    RelativeLayout mRlJiangjia;
    @BindView(R.id.rl_price)
    RelativeLayout mRlPrice;
    @BindView(R.id.tv_tv_name)
    TextView mTvTvName;
    @BindView(R.id.tv_lingquan)
    TextView mTvLingquan;
    @BindView(R.id.tv_duomaiyouhui)
    TextView mTvDuomaiyouhui;
    @BindView(R.id.rl_youhui)
    LinearLayout mRlYouhui;
    @BindView(R.id.tv_tv_yixuan)
    TextView mTvTvYixuan;
    @BindView(R.id.rl_yixuan)
    LinearLayout mRlYixuan;
    @BindView(R.id.img_location)
    ImageView mImgLocation;
    @BindView(R.id.tv_address)
    TextView mTvAddress;
    @BindView(R.id.tv_xianhuo)
    TextView mTvXianhuo;
    @BindView(R.id.tv_delivertime)
    TextView mTvDelivertime;
    @BindView(R.id.rl_address)
    RelativeLayout mRlAddress;
    @BindView(R.id.ll_songzhi)
    LinearLayout mLlSongzhi;
    @BindView(R.id.tv_yunfei)
    TextView mTvYunfei;
    @BindView(R.id.tv_mianyunfei)
    TextView mTvMianyunfei;
    @BindView(R.id.tv_pingjia)
    TextView mTvPingjia;
    @BindView(R.id.tv_haopd)
    TextView mTvHaopd;
    @BindView(R.id.rl_pingjia)
    RelativeLayout mRlPingjia;
    @BindView(R.id.img_pj_icon)
    ImageView mImgPjIcon;
    @BindView(R.id.tv_pj_name)
    TextView mTvPjName;
    @BindView(R.id.rg_pj_ratingbar)
    RatingBar mRgPjRatingbar;
    @BindView(R.id.tv_pj_content)
    TextView mTvPjContent;
    @BindView(R.id.tv_pj_kuanshi)
    TextView mTvPjKuanshi;
    @BindView(R.id.rl_pingjiafirst)
    RelativeLayout mRlPingjiafirst;
    @BindView(R.id.img_pj_icon2)
    ImageView mImgPjIcon2;
    @BindView(R.id.tv_pj_name2)
    TextView mTvPjName2;
    @BindView(R.id.rg_pj_ratingbar2)
    RatingBar mRgPjRatingbar2;
    @BindView(R.id.tv_pj_content2)
    TextView mTvPjContent2;
    @BindView(R.id.tb_pj_kuanshi2)
    TextView mTbPjKuanshi2;
    @BindView(R.id.rl_pingjia2)
    RelativeLayout mRlPingjia2;
    @BindView(R.id.btn_checkallpj)
    Button mBtnCheckallpj;
    @BindView(R.id.tv_youhui_car)
    TextView mTvYouhuiCar;
    @BindView(R.id.tv_youhui_morepod)
    TextView mTvYouhuiMorepod;
    @BindView(R.id.ll_pingjia)
    LinearLayout mLlPingjia;
    private List<String> mStringsKuanxinList;
    private List<String> mStringsColorsList;
    private List<String> mStringsChimaList;
    private List<String> imagesUrlList;
    private AddressDialog addressDialog;
    private AddressPickDialog mAddressPickDialog;
    private boolean mNoSavedAddress;
    private String mWholeAddress;
    private BuyPickDialog mBuyPickDialog;
    private String mYixuanString;
    private static IPODDetailActivity callback;
    private PODDetaliBean.DataBean.ListBean mBean;
    private int[] caiImgLocation;

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0 :
                    excuteAnim((Bitmap) msg.obj);
                    break;
            }
        }
    };

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    protected int setLayout() {
        return R.layout.fm_poddetail_shangpin;
    }

    @Override
    protected void initView() {
        addressDialog = new AddressDialog(getActivity());
        addressDialog.setOnDecideListener(new AddressDialog.IOnDecideListener() {
            @Override
            public void onCancel(View v) {
                addressDialog.dismiss();
            }

            @Override
            public void onSure(View v, String province, String city, String district) {
                mWholeAddress = province + city + district;
                mTvAddress.setText(mWholeAddress);
                addressDialog.dismiss();
                mAddressPickDialog.clearChoosedOne();
            }
        });
    }

    @Override
    protected void bindData() {
        getPresenter().getSavedAddressByUser_id();
    }

    @Override
    protected void bindListenter() {
        mLlSongzhi.setOnClickListener(this);
        mRlYixuan.setOnClickListener(this);
        mLlPingjia.setOnClickListener(this);
        mBtnCheckallpj.setOnClickListener(this);
    }

    @Override
    protected PODDetail_SHANGPINFragmentPresenter createPresenter() {
        return new PODDetail_SHANGPINFragmentPresenter(this);
    }

    public static PODDetail_SHANGPINFragment newInstance(IPODDetailActivity iPODDetailActivity) {
        if (fragment == null) {
            fragment = new PODDetail_SHANGPINFragment();
        }
        callback = iPODDetailActivity;
        return fragment;

    }

    @Override
    public void setMenuVisibility(boolean menuVisible) {//menuVisible true 相当于Fragment的onResume
        super.setMenuVisibility(menuVisible);           //menuVisible false 相当于Fragment的onPause
        if (this.getView() != null) {
            this.getView().setVisibility(menuVisible ? View.VISIBLE : View.GONE); //设置自己是否可见
        }
    }


    public void setData(PODDetaliBean.DataBean.ListBean bean) {
        //对应banner，构建对应颜色型号数据
        mBean=bean;
        String pod_kuanxin = bean.getPod_kuanxin();
        String pod_colors = bean.getPod_colors();
        String pod_chima = bean.getPod_chima();
        String bannerImages = bean.getBannerImages();
        String[] stringskuanxin = StringUtil.splitStringByJInghao(pod_kuanxin);
        String[] stringscolors = StringUtil.splitStringByJInghao(pod_colors);
        String[] stringschima = StringUtil.splitStringByJInghao(pod_chima);
        String[] imagesUrl = StringUtil.splitStringByJInghao(bannerImages);
        mStringsKuanxinList = new ArrayList<>(Arrays.asList(stringskuanxin));
        mStringsColorsList = new ArrayList<>(Arrays.asList(stringscolors));
        mStringsChimaList = new ArrayList<>(Arrays.asList(stringschima));
        imagesUrlList = new ArrayList<>(Arrays.asList(imagesUrl));

        mTvPricemain.setText(bean.getPrice()+"");
        mTvTvName.setText(bean.getNamepod());
        if(TextUtils.isEmpty(bean.getYouhui_card())) {
            mTvLingquan.setVisibility(View.GONE);
            mTvYouhuiCar.setVisibility(View.GONE);
        }else {
            mTvYouhuiCar.setText(bean.getYouhui_card());
        }
        if(TextUtils.isEmpty(bean.getYouhui_morepod())) {
            mTvDuomaiyouhui.setVisibility(View.GONE);
            mTvYouhuiMorepod.setVisibility(View.GONE);
        }else {
            mTvYouhuiMorepod.setText(bean.getYouhui_card());
        }
        mYixuanString = mStringsColorsList.get(0) + "，" + mStringsChimaList.get(0) + "，1件";
        mTvTvYixuan.setText(mYixuanString);
        mTvMianyunfei.setText(bean.getIfBaoyou());

        mBuyPickDialog = new BuyPickDialog(getActivity(), mStringsColorsList,mStringsChimaList,imagesUrlList);
        mBuyPickDialog.setOnBtnListener(new BuyPickDialog.MyClickLisener() {
            @Override
            public void onAddCar(View v) {
                //TODO 数据加到购物车
                if (!MallApplication.IF_LOGIN_IN) {
                    Toast.makeText(getActivity(), "请先登录", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent();
                    intent.setClass(getActivity(),LoginActivity.class);
                    startActivity(intent);
                    return;
                }
                if(mBean==null) {
                    Toast.makeText(getActivity(),"数据未加载",Toast.LENGTH_LONG).show();
                    return;
                }
                AddGouWuCheBean dataBean = createDataBean();
                getPresenter().addCar(dataBean);
            }

            @Override
            public void onBuyDirect(View v) {
                //TODO 带数据跳转填写订单
            }

            @Override
            protected void onColorItemClick(int position) {
                callback.onYixuanDialogColorChange(position);
            }

            @Override
            protected void onSizeItemClick(int position) {
                setSizeChoosen(position);
            }

            @Override
            public void onAmountChange(int amount) {
                setAmountChange(amount);
            }
        });
        mBuyPickDialog.setData(mYixuanString);
    }

    private AddGouWuCheBean createDataBean() {
        AddGouWuCheBean bean = new AddGouWuCheBean();
        bean.setNamepod(mBean.getNamepod());
        bean.setCate_id(mBean.getCate_id());
        bean.setDianpu_id(mBean.getStore_id());
        bean.setIfBaoyou(mBean.getIfBaoyou());
        bean.setPrice(mBean.getPrice());
        bean.setStore_name(mBean.getStore_name());
        if (MallApplication.IF_LOGIN_IN) {
            bean.setUser_id(Integer.valueOf(MallApplication.getUSER().getUser_id()));
        } else {
            Toast.makeText(getActivity(), "请先登录", Toast.LENGTH_LONG).show();
            Intent intent = new Intent();
            intent.setClass(getActivity(),LoginActivity.class);
            startActivity(intent);
        }
        bean.setYouhui_type(mBean.getYouhui_type());
        if(mBean.getYouhui_type()==1) {
            bean.setYouhui_name(mBean.getYouhui_morepod());
        }else if(mBean.getYouhui_type()==2) {
            bean.setYouhui_name(mBean.getYouhui_card());
        }
        bean.setPod_color(mBuyPickDialog.getselectedColor());
        bean.setPod_chima(mBuyPickDialog.getselectedSize());
        bean.setPod_num(mBuyPickDialog.getselectedNum());
        bean.setImages(mBuyPickDialog.getselectedImage());
        return bean;

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_songzhi :
                if(mAddressPickDialog==null || mNoSavedAddress) {//用户无保存的地址、或者未加载地址成功
                    addressDialog.show();
                }else {
                    mAddressPickDialog.show();
                }
                break;
            case R.id.rl_yixuan :
                if(mBuyPickDialog!=null) {
                    mBuyPickDialog.show();
                }
                break;
            case R.id.ll_pingjia :
            case R.id.btn_checkallpj :
                callback.jumpToPingjia();
                break;
        }
    }

    @Override
    public void requestAddressByUser_id(AddressBean addressBean) {
        AddressBean.DataBean data = addressBean.getData();
        List<AddressBean.DataBean.ListBean> listData=null;
        if(data!=null) {
            listData = data.getList();
        }
        if(listData!=null&&listData.size()>0) {
            mNoSavedAddress = false;
            //默认地址
            for (AddressBean.DataBean.ListBean bean : listData) {
                if(bean.getIfmoren()==1) {
                    mTvAddress.setText(bean.getSheng()
                            + bean.getShi()+ bean.getXian_or_qu() + bean.getXiangxi_part_address());
                }
            }
            mAddressPickDialog = new AddressPickDialog(getActivity(), listData);
            mAddressPickDialog.setOnMyOnClickLisener(new AddressPickDialog.MyClickLisener(){

                @Override
                protected void onBtnClicked() {
                    mAddressPickDialog.dismiss();
                    addressDialog.show();
                }

                @Override
                protected void onItemClicked(String wholeAddress) {
                    mAddressPickDialog.dismiss();
                    mWholeAddress = wholeAddress;
                    mTvAddress.setText(wholeAddress);
                }
            });
        }else {
            mNoSavedAddress = true;
        }

    }

    @Override
    public void addCarSuccessful(GouWuCheBean addressBean) {
        if(addressBean.getData().getErr_code()==0) {//加入成功，执行动画
            mBuyPickDialog.dismiss();
            final String url = mBuyPickDialog.getselectedImage();
            //开线程 Glide下载图片
            new Thread(){
                @Override
                public void run() {
                    Bitmap bmp = null;
                    try {
                        bmp = Glide.with(PODDetail_SHANGPINFragment.this.getActivity())
                                .asBitmap().load(url).submit(200, 200).get();
                    } catch (Exception e) {
                        Log.d("Thread bitmap", "run: "+e.getMessage());
                    }
                    Message message = new Message();
                    message.what=0;
                    message.obj = bmp;
                    handler.sendMessage(message);
                }
            }.start();

        }
    }

    private void excuteAnim(Bitmap bp) {
        WindowManager windowManager = getActivity().getWindow().getWindowManager();
        Display defaultDisplay = windowManager.getDefaultDisplay();
        int height = defaultDisplay.getHeight();
        int width = defaultDisplay.getWidth();
        AnimUtils.startAddCarAnim(getActivity(), bp, new int[]{width/2, height/2},
                caiImgLocation, new Animationlisener() {
                    @Override
                    public void onAnimEnd() {
                        //更新购物车显示数量
                        Log.e("onAnimEnd", "onAnimEnd: ");
                    }
                });
    }


    public void setColorChoosen(String stringsColor,int position) {
        String yixuanText = (String) mTvTvYixuan.getText();
        String[] stringsYiXuan = yixuanText.split("，");
        stringsYiXuan[0] = stringsColor;
        String yixuanTextResult = StringUtil.fromStringArray(stringsYiXuan,"，");
        mTvTvYixuan.setText(yixuanTextResult);
        mBuyPickDialog.setColorindex(position);
    }


    public void setSizeChoosen(int position) {
        String sizeString = mStringsChimaList.get(position);
        String yixuanText = (String) mTvTvYixuan.getText();
        String[] stringsYiXuan = yixuanText.split("，");
        stringsYiXuan[1] = sizeString;
        String yixuanTextResult = StringUtil.fromStringArray(stringsYiXuan,"，");
        mTvTvYixuan.setText(yixuanTextResult);
    }
    public void setAmountChange(int amountChange) {
        String yixuanText = (String) mTvTvYixuan.getText();
        String[] stringsYiXuan = yixuanText.split("，");
        stringsYiXuan[2] = amountChange+"件";
        String yixuanTextResult = StringUtil.fromStringArray(stringsYiXuan,"，");
        mTvTvYixuan.setText(yixuanTextResult);
    }

    public void showAddCarDialog() {
        if(mBuyPickDialog!=null) {
            mBuyPickDialog.show();
        }
    }

    public void setCarImgLocation(int[] ints) {
        caiImgLocation = ints;
    }
}
