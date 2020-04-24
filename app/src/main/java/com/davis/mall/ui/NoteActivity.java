package com.davis.mall.ui;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.davis.mall.R;
import com.davis.mall.adapter.APICategoryAdapter;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NoteActivity extends Activity {
    @BindView(R.id.rc_Category)
    RecyclerView rcCategory;
    private List<String> strings;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        ButterKnife.bind(this);
        BindData();
    }

    private void BindData() {
        rcCategory.setLayoutManager(new GridLayoutManager(this, 3));
        strings = Arrays.asList(getResources().getStringArray(R.array.api_category));
        rcCategory.setAdapter(new APICategoryAdapter(this, strings));
    }
}
