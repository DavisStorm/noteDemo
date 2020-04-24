package com.davis.mall.ui.note;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.davis.mall.R;
import com.davis.mall.adapter.BaseRecycleViewAdapter;
import com.google.android.material.internal.FlowLayout;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DIYListViewActivity extends AppCompatActivity {

    @BindView(R.id.rv_category)
    RecyclerView rvCategory;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        ButterKnife.bind(this);
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        String[] stringArray = getResources().getStringArray(R.array.DIY_list);
        rvCategory.setAdapter(new BaseRecycleViewAdapter(Arrays.asList(stringArray), new BaseRecycleViewAdapter.OnClickLisener() {
            @Override
            public void OnClick(int layoutPosition) {
                Intent intent = new Intent();
                switch (layoutPosition){
                    case 0:
                        intent.setClass(DIYListViewActivity.this,DIYViewActivity.class);
                        break;
                    case 1:
                        intent.setClass(DIYListViewActivity.this, FlowLayoutActivity.class);
                        break;
                    case 2:
                        intent.setClass(DIYListViewActivity.this,DIYViewActivity.class);
                        break;
                    case 3:
                        intent.setClass(DIYListViewActivity.this,DIYViewActivity.class);
                        break;
                }
                startActivity(intent);
            }
        }));
    }
}
