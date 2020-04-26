package com.davis.mall.ui.note;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.davis.mall.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FlowLayoutActivity extends AppCompatActivity {

    @BindView(R.id.et_search)
    EditText etSearch;
    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.flowlayout)
    FlowLayout flowlayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flowlayout);
        ButterKnife.bind(this);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                tv.post(new Runnable() {
                    @Override
                    public void run() {
                        tv.setText("hjkgh机构和国家和高科技");
                    }
                });
            }
        }).start();
    }
}
