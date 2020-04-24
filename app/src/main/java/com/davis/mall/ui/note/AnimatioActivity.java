package com.davis.mall.ui.note;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.davis.mall.R;
import com.davis.mall.adapter.BaseQuickAdapter;
import com.davis.mall.utils.BaseViewHolder;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;

public abstract class AnimatioActivity extends AppCompatActivity {

    @BindView(R.id.img)
    ImageView img;
    @BindView(R.id.rv_control)
    RecyclerView rvControl;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        GridLayoutManager manager = new GridLayoutManager(this, 3);
        rvControl.setLayoutManager(manager);
        rvControl.setAdapter(new BaseQuickAdapter<String>(R.layout.view_item_button, Arrays.asList(getList())) {
            @Override
            protected void convert(final BaseViewHolder helper, String text) {
                Button btn = helper.convertView.findViewById(R.id.btn);
                btn.setText(text);
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startAnimation(helper.getLayoutPosition());
                    }
                });
            }
        });
        init();
    }

    public int getLayoutId(){
        return R.layout.activity_animation;
    };

    protected void init(){};

    protected abstract String[] getList();

    protected abstract void startAnimation(int position);
}
