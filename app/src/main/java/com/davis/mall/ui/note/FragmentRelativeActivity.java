package com.davis.mall.ui.note;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.davis.mall.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author 王阳
 * @time 2020/2/24  1:22
 * @desc
 */
public class FragmentRelativeActivity extends Activity implements View.OnClickListener{

    @BindView(R.id.tv_point_one)
    TextView mTvPointOne;
    @BindView(R.id.tv_point_one_one)
    TextView mTvPointOneOne;
    @BindView(R.id.tv_point_one_two)
    TextView mTvPointOneTwo;
    @BindView(R.id.point_one_two_line1)
    TextView mPointOneTwoLine1;
    @BindView(R.id.point_one_two_line2)
    TextView mPointOneTwoLine2;
    @BindView(R.id.point_one_two_line3)
    TextView mPointOneTwoLine3;
    @BindView(R.id.point_one_two_line4)
    TextView mPointOneTwoLine4;
    @BindView(R.id.point_one_two_line5)
    TextView mPointOneTwoLine5;
    @BindView(R.id.btn_fragmentTransaction)
    Button mBtnFragmentTransaction;
    @BindView(R.id.rl_fragmentTransaction)
    LinearLayout mRlFragmentTransaction;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_relative);
        ButterKnife.bind(this);
        initLisener();
    }

    private void initLisener() {
        mBtnFragmentTransaction.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_fragmentTransaction:
                Intent intent = new Intent();
//                Intent intent = new Intent(FragmentRelativeActivity.this, FragmentTransactionTell.class);
                intent.setClass(FragmentRelativeActivity.this,FragmentTransactionTell.class);
                startActivity(intent);
                break;
        }
    }
}
