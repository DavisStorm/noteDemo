package com.davis.mall.views;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

import androidx.appcompat.widget.AppCompatEditText;

import com.davis.mall.R;
import com.davis.mall.ui.SearchGoodsActivity;

/**
 * @author 王阳
 * @time 2019/11/3  12:58
 * @desc
 */
public class MySearchView extends AppCompatEditText {
    private Context mContext;

    OnClickListener mListener =new OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(mContext, SearchGoodsActivity.class);
            mContext.startActivity(intent);
        }
    };

    public MySearchView(Context context) {
        super(context);
        mContext = context;
        init();
    }

    public MySearchView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init();
    }

    private void init() {
        Drawable drawableLeft = getResources().getDrawable(R.drawable.sousuo);
        Drawable drawableRight = getResources().getDrawable(R.drawable.paizhao);
        drawableLeft.setBounds(1, 1, 46, 46);
        drawableRight.setBounds(1, 1, 56, 56);
        setCompoundDrawables(drawableLeft,null,drawableRight,null);
        setCompoundDrawablePadding(20);
        setPadding(30,8,30,8);
        setSingleLine();
        Drawable drawableSearchbg = getResources().getDrawable(R.drawable.searchbg);
        setBackground(drawableSearchbg);
        setTextColor(getResources().getColor(R.color.BLACK));
        setHintTextColor(getResources().getColor(R.color.DARKGRAY));
        setFocusable(false);
        //设置点击监听器
        setOnClickListener(mListener);
    }
}
