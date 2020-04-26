package com.davis.mall.ui.note;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.davis.mall.R;
import com.davis.mall.adapter.BaseQuickAdapter;
import com.davis.mall.utils.BaseViewHolder;
import com.google.android.material.tabs.TabLayout;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecycleViewLayoutManagerActivity extends AppCompatActivity {
    @BindView(R.id.rv)
    RecyclerView rv;
    @BindView(R.id.tl)
    TabLayout tl;
    private String[] content ={"我是张三","我是李你好","我是王五你好","我是李四你好","我是王五你好五你好",
            "我是张三","我是好","我是五你好五你好","我是李四你好","我是王五五你好",
            "我是张三","我是你好","我是王五你好五你好","我是李四你好","我是王五你好五你好",
            "我是张三","我是李你好","我是王五你好","我是李四你好","我是王五你好五你好",
            "我是张三","我是好","我是五你好五你好","我是李四你好","我是王五五你好",
            "我是张三","我是你好","我是王五你好五你好","我是李四你好","我是王五你好五你好",};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycleviewa_layoutmanager);
        ButterKnife.bind(this);

        tl.addTab(tl.newTab().setCustomView(getATextView("LinearLayoutManager")));
        tl.addTab(tl.newTab().setCustomView(getATextView("GridLayoutManager")));
        tl.addTab(tl.newTab().setCustomView(getATextView("StaggeredGridLayoutManager")));
        tl.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tl.getSelectedTabPosition()) {
                    case 0:
                        rv.setLayoutManager(new LinearLayoutManager(RecycleViewLayoutManagerActivity.this));
                        break;
                    case 1:
                        rv.setLayoutManager(new GridLayoutManager(RecycleViewLayoutManagerActivity.this, 3));
                        break;
                    case 2:
                        rv.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        rv.setLayoutManager(new LinearLayoutManager(RecycleViewLayoutManagerActivity.this));
        rv.setAdapter(new BaseQuickAdapter<String>(R.layout.simple_list_item_1,makeData()) {
            @Override
            protected void convert(BaseViewHolder helper, String item) {
                helper.setText(R.id.text1,item);
            }
        });
    }

    private List<String> makeData() {
        return Arrays.asList(content);
    }

    private TextView getATextView(String content) {
        TextView textView = new TextView(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        params.setMargins(0,0,0,8);
        textView.setLayoutParams(params);
        textView.setText(content);
        textView.setTextSize(12);
        textView.setGravity(Gravity.CENTER_VERTICAL);
        textView.setBackgroundColor(getColor(R.color.MEDIUMORCHID));
        return textView;
    }
}
