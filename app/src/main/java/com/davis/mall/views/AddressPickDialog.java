package com.davis.mall.views;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.davis.mall.R;
import com.davis.mall.adapter.BaseQuickAdapter;
import com.davis.mall.bean.AddressBean;
import com.davis.mall.utils.BaseViewHolder;

import java.util.List;

public class AddressPickDialog extends Dialog  {

    private Context context;
    private RecyclerView mRv;
    private List<AddressBean.DataBean.ListBean> mData;
    private BaseQuickAdapter<AddressBean.DataBean.ListBean> mBaseQuickAdapter;
    private Button mBtn;
    private MyClickLisener mMyClickLisener;

    public AddressPickDialog(Context context, List<AddressBean.DataBean.ListBean> data) {
        super(context, R.style.my_dialog);
        this.context = context;
        this.mData = data;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        setContentView(R.layout.layout_dialog_chooseaddress);
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
        mRv = findViewById(R.id.rv);
        mBaseQuickAdapter = new BaseQuickAdapter<AddressBean.DataBean.ListBean>(R.layout.layout_dialog_chooseaddress_rvitem, mData) {
            @Override
            protected void convert(final BaseViewHolder helper, AddressBean.DataBean.ListBean item) {
                final String wholeAddress = item.getSheng() + item.getShi()
                        + item.getXian_or_qu() + item.getXiangxi_part_address();
                helper.setText(R.id.tv_address_des, wholeAddress);
                TextView view = helper.getView(R.id.tv_address_des);
                if (item.getIfmoren() == 1) {
                    Drawable drawableLeft = context.getResources().getDrawable(
                            R.drawable.gou);
                    view.setCompoundDrawablesWithIntrinsicBounds(drawableLeft,
                            null, null, null);
                    view.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
                }else {
                    Drawable drawableLeft = context.getResources().getDrawable(
                            R.drawable.location_black);
                    view.setCompoundDrawablesWithIntrinsicBounds(drawableLeft,
                            null, null, null);
                    view.setTypeface(Typeface.DEFAULT, Typeface.NORMAL);
                }
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int position = helper.getPosition();
                        for (AddressBean.DataBean.ListBean  itembean: mData) {
                            int index = mData.indexOf(itembean);
                            if(index == position) {
                                itembean.setIfmoren(1);
                            }else {
                                itembean.setIfmoren(0);
                            }
                        }
                        mMyClickLisener.onItemClicked(wholeAddress);
                        notifyDataSetChanged();
                    }
                });
            }
        };
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayout.VERTICAL);
        mRv.setLayoutManager(layoutManager);
        mRv.setAdapter(mBaseQuickAdapter);
    }


    private void initLocation() {
        Window dialogWindow = getWindow();
        dialogWindow.setGravity(Gravity.BOTTOM);
        dialogWindow.setWindowAnimations(R.style.dialogstyle); // 添加动画
        WindowManager.LayoutParams lp = dialogWindow.getAttributes(); // 获取对话框当前的参数值
        lp.x = 0; // 新位置X坐标
        lp.y = -20; // 新位置Y坐标
        lp.width = (int) context.getResources().getDisplayMetrics().widthPixels; // 宽度
        View view = getLayoutInflater().from(context).inflate(R.layout.layout_dialog_chooseaddress, null);
        view.measure(0, 0);
        lp.height = view.getMeasuredHeight();
        lp.alpha = 9f; // 透明度
        dialogWindow.setAttributes(lp);
    }

    private void initListener() {
        mBtn = findViewById(R.id.btn_choose_otheraddress);
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMyClickLisener.onBtnClicked();
            }
        });

    }
    public void setData(List<AddressBean.DataBean.ListBean> data) {
        mBaseQuickAdapter.setNewData(data);//无用，不知为何
    }

    public void clearChoosedOne() {
        for (AddressBean.DataBean.ListBean  itembean: mData) {
            itembean.setIfmoren(0);
        }
        mBaseQuickAdapter.notifyDataSetChanged();
    }

    public abstract static class MyClickLisener{
        protected abstract void onBtnClicked();
        protected abstract void onItemClicked(String wholeAddress);
    }
    public void setOnMyOnClickLisener(MyClickLisener lisener){
        this.mMyClickLisener=lisener;
    }
}
