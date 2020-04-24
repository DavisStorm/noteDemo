package com.davis.mall.ui.note;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.davis.mall.R;
import com.davis.mall.views.CircleProgressBar;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author 王阳
 * @time 2020/2/14  15:57
 * @desc
 */
public class DIYViewActivity extends Activity {

    @BindView(R.id.progressbar_circle)
    CircleProgressBar mProgressbarCircle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diyview);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        mProgressbarCircle.setAngle((float)0.55);
    }
}
