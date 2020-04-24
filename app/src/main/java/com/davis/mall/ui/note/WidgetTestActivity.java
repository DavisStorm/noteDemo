package com.davis.mall.ui.note;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;

import com.davis.mall.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by CZY on 2018/10/18.
 */

public class WidgetTestActivity extends Activity {

    @BindView(R.id.lv_widget_name)
    ListView lvWidgetName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widget_test);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.widget_names));
        lvWidgetName.setAdapter(arrayAdapter);
        lvWidgetName.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        startActivity(new Intent(WidgetTestActivity.this, DemoActivity.class));
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                }
            }
        });
    }
}
