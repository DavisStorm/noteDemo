package com.davis.mall.views;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.davis.mall.R;
import com.davis.mall.adapter.BaseQuickAdapter;
import com.davis.mall.utils.BaseViewHolder;
import com.davis.mall.utils.StringUtil;

import java.util.ArrayList;
import java.util.List;

public class BuyPickDialog extends Dialog {

    private Context context;
    private List<String> mColorData;
    private List<String> mSizeData;
    private List<String> imgUrlList;
    private MyClickLisener mMyClickLisener;
    private AmountView mAmountView;
    private ImageView mMiv;
    private TextView mTv_price_main;
    private RecyclerView mRv_color;
    private RecyclerView mRv_size;
    private AmountView mAmount_view;
    private TextView mBtn_add_car;
    private TextView mBtn_buy;
    private String[] yixuanStrings;
    private BaseQuickAdapter<String> mColorAdapter;
    private BaseQuickAdapter<String> mSizeAdapter;
    private int colorindex = 0;
    private int sizeindex = 0;
    private int num = 1;

    public BuyPickDialog(Context context, List<String> stringsColorsList, List<String> stringsChimaList, List<String> imgUrlList) {
        super(context, R.style.my_dialog);
        this.context = context;
        this.mColorData = new ArrayList<>(stringsColorsList);
        this.mSizeData = new ArrayList<>(stringsChimaList);
        this.imgUrlList = new ArrayList<>(imgUrlList);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        setContentView(R.layout.layout_dialog_buypick);
        hideVirtualKey();
        //按空白处隐藏对话框
        setCanceledOnTouchOutside(true);
        //初始化dialog界面
        initData();
        //设置dialog位置
        initLocation();

        initListener();

    }

    //当用户划出虚拟按键后，自动再隐藏方法
    private void hideVirtualKey() {
        getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
            @Override
            public void onSystemUiVisibilityChange(int visibility) {
                int uiOptions = View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                        //布局位于状态栏下方
                        View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                        //                        全屏
                        //                        View.SYSTEM_UI_FLAG_FULLSCREEN |
                        //隐藏导航栏
                        View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                        View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
                if (Build.VERSION.SDK_INT >= 19) {
                    uiOptions |= 0x00001000;
                } else {
                    uiOptions |= View.SYSTEM_UI_FLAG_LOW_PROFILE;
                }
                getWindow().getDecorView().setSystemUiVisibility(uiOptions);
            }
        });
    }


    private void initData() {
        mMiv = findViewById(R.id.img);
        mTv_price_main = findViewById(R.id.tv_price_main);
        mAmount_view = findViewById(R.id.amount_view);
        mBtn_add_car = findViewById(R.id.btn_add_car);
        mBtn_buy = findViewById(R.id.btn_buy);
        mRv_color = findViewById(R.id.rv_color);
        mRv_size = findViewById(R.id.rv_size);

        //初始化数量
        mAmountView = findViewById(R.id.amount_view);
        mAmountView.setGoods_storage(100);


        GridLayoutManager layoutManager1 = new GridLayoutManager(context,3);
        layoutManager1.setOrientation(LinearLayoutManager.VERTICAL);
        mRv_color.setLayoutManager(layoutManager1);

        mColorAdapter = new BaseQuickAdapter<String>(R.layout.dialog_rv_textview, mColorData) {
            @Override
            protected void convert(final BaseViewHolder helper, String color) {
                helper.setText(R.id.tv_content,color);
                TextView tvColor = helper.getView(R.id.tv_content);
                if(helper.getAdapterPosition() == colorindex) {
                    Drawable drawable = context.getResources().getDrawable(R.drawable.bg_btn_round_redsolid);
                    tvColor.setBackground(drawable);
                    Glide.with(context).load(imgUrlList.get(colorindex)).into(mMiv);
                }else {
                    Drawable drawable = context.getResources().getDrawable(R.drawable.bg_btn_round_greysolid);
                    tvColor.setBackground(drawable);
                }
                tvColor.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        colorindex = helper.getAdapterPosition();
                        mMyClickLisener.onColorItemClick(colorindex);
                        notifyDataSetChanged();
                    }
                });
            }
        };
        mRv_color.setAdapter(mColorAdapter);

        GridLayoutManager layoutManager2 = new GridLayoutManager(context,4);
        layoutManager2.setOrientation(LinearLayoutManager.VERTICAL);
        mRv_size.setLayoutManager(layoutManager2);
        mSizeAdapter = new BaseQuickAdapter<String>(R.layout.dialog_rv_textview, mSizeData) {
            @Override
            protected void convert(final BaseViewHolder helper, String size) {
                helper.setText(R.id.tv_content,size);

                TextView tvColor = helper.getView(R.id.tv_content);
                if(helper.getAdapterPosition() == sizeindex) {
                    Drawable drawable = context.getResources().getDrawable(R.drawable.bg_btn_round_redsolid);
                    tvColor.setBackground(drawable);
                }else {
                    Drawable drawable = context.getResources().getDrawable(R.drawable.bg_btn_round_greysolid);
                    tvColor.setBackground(drawable);
                }
                tvColor.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        sizeindex = helper.getAdapterPosition();
                        mMyClickLisener.onSizeItemClick(sizeindex);
                        notifyDataSetChanged();
                    }
                });
            }
        };
        mRv_size.setAdapter(mSizeAdapter);

    }


    private void initLocation() {
        Window dialogWindow = getWindow();
        dialogWindow.setGravity(Gravity.BOTTOM);
        dialogWindow.setWindowAnimations(R.style.dialogstyle); // 添加动画
        WindowManager.LayoutParams lp = dialogWindow.getAttributes(); // 获取对话框当前的参数值
        lp.x = 0; // 新位置X坐标
        lp.y = -20; // 新位置Y坐标
        lp.width = (int) context.getResources().getDisplayMetrics().widthPixels; // 宽度
        View view = getLayoutInflater().from(context).inflate(R.layout.layout_dialog_buypick, null);
        view.measure(0, 0);
        lp.height = view.getMeasuredHeight();
        lp.alpha = 9f; // 透明度
        dialogWindow.setAttributes(lp);
    }

    private void initListener() {

        mAmount_view.setOnAmountChangeListener(new AmountView.OnAmountChangeListener() {
            @Override
            public void onAmountChange(View view, int amount) {
                mMyClickLisener.onAmountChange(amount);
            }
        });
        mBtn_add_car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMyClickLisener.onAddCar(v);
            }
        });
        mBtn_buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMyClickLisener.onBuyDirect(v);
            }
        });
    }

    public void setData(String yixuanString) {
        yixuanStrings= StringUtil.splitString(yixuanString, "，");
        if(mColorAdapter!=null&&mSizeAdapter!=null) {
            mColorAdapter.notifyDataSetChanged();
            mSizeAdapter.notifyDataSetChanged();
        }
    }
    public void setColorindex(int position) {
        colorindex = position;
        if(mColorAdapter!=null) {//防止第一次显示dialog时还没走oncreate这里mColorAdapter为空，既然会走oncreate方法就会自动执行notifyDataSetChanged
            mColorAdapter.notifyDataSetChanged();
        }
    }


    public abstract static class MyClickLisener {
        protected abstract void onAddCar(View v);
        protected abstract void onBuyDirect(View v);
        protected abstract void onColorItemClick(int position);
        protected abstract void onSizeItemClick(int position);
        public abstract void onAmountChange(int amount);
    }

    public void setOnBtnListener(MyClickLisener lisener) {
        this.mMyClickLisener = lisener;
    }

    public String getselectedColor(){
        if(mColorData!=null&&mColorData.size()>0) {
            return mColorData.get(colorindex);
        }
        return "";
    }
    public String getselectedSize(){
        if(mSizeData!=null&&mSizeData.size()>0) {
            return mSizeData.get(sizeindex);
        }
        return "";
    }
    public String getselectedImage(){
        if(imgUrlList!=null&&imgUrlList.size()>0) {
            return imgUrlList.get(colorindex);
        }
        return "";
    }
    public int getselectedNum(){
        return mAmount_view.getNum();
    }

}
