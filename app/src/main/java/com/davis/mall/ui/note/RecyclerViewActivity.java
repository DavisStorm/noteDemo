package com.davis.mall.ui.note;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.davis.mall.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerViewActivity extends AppCompatActivity {

    @BindView(R.id.rv_category)
    RecyclerView rvCategory;
    private String[] strings = new String[]{};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        ButterKnife.bind(this);
        strings = getResources().getStringArray(R.array.Recyclerview_list);
        rvCategory.setLayoutManager(new LinearLayoutManager(this));//默认垂直布局
        rvCategory.setAdapter(new CategoryAdapter());
        rvCategory.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
//        rvCategory.setItemAnimator(new DefaultItemAnimator());//设置增加或删除条目的动画
    }

    class CategoryAdapter extends RecyclerView.Adapter<VHolder> {

        @NonNull
        @Override
        public VHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            TextView textView = new TextView(parent.getContext());
            textView.setPadding(40, 20, 0, 20);
            textView.setId(R.id.rv_tv_1);
            return new VHolder(textView);
        }

        @Override
        public void onBindViewHolder(@NonNull VHolder holder, int position) {
            holder.tv.setText(strings[position]);
        }

        @Override
        public int getItemCount() {
            return strings.length;
        }
    }

    class VHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tv;

        public VHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.rv_tv_1);
            tv.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.rv_tv_1) {
                Intent intent = new Intent();
                switch (getLayoutPosition()) {
                    case 0://RecycleView.Adapter
                        intent.setClass(RecyclerViewActivity.this,RecycleViewAdapterActivity.class);
                        break;
                    case 1:
                        break;
                }
                startActivity(intent);
            }
        }
    }
}
