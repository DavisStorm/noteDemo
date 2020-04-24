package com.davis.mall.ui.note;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.davis.mall.R;
import com.davis.mall.adapter.BaseQuickAdapter;
import com.davis.mall.utils.BaseViewHolder;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * View Animation可以在xml里写了直接在控件里应用，也可以通过AnimationUtil.loadAnimation获取再加载,也可以直接new TranslateAnimation(0.0f, 400f, 0.0f, 400f)
 * Value Animation通过ValueAnimator或者ObjectAnimation创建，也可以用xml编写,在res目录下面新建一个animator文件夹,AnimatorInflater.loadAnimator
 * 简单的表示为    ValueAnimator.ofInt().addUpdateLisener(tv.layout(x,y))
 * 简单的表示为    ObjectAnimator.ofFloat(textview, "alpha", 1f, 0f);
* */

public class AnimationListActivity extends AppCompatActivity {
    @BindView(R.id.rv_container)
    RecyclerView rvContainer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animlist);
        ButterKnife.bind(this);
        String[] strings = getResources().getStringArray(R.array.Animlist);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rvContainer.setLayoutManager(manager);
        rvContainer.setAdapter(new BaseQuickAdapter<String>(R.layout.view_item_tv, Arrays.asList(strings)) {
            @Override
            protected void convert(final BaseViewHolder helper, String text) {
                TextView tv = helper.convertView.findViewById(R.id.tv);
                tv.setText(text);
                tv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        switch (helper.getLayoutPosition()){
                            case 0://布局写补间动画scale,rotate,translate,alpha,set
                                startActivity(new Intent(AnimationListActivity.this, Animatio1Activity.class));
                                break;
                            case 1://动画加interpolator
                                startActivity(new Intent(AnimationListActivity.this, Animatio2Activity.class));
                                break;
                            case 2:
                                startActivity(new Intent(AnimationListActivity.this, Animatio2Activity.class));
                                break;
                            case 3:
                                startActivity(new Intent(AnimationListActivity.this, Animatio2Activity.class));
                                break;
                            case 4:
                                startActivity(new Intent(AnimationListActivity.this, Animatio2Activity.class));
                                break;
                            case 5:
                                startActivity(new Intent(AnimationListActivity.this, Animatio2Activity.class));
                                break;
                            case 6:
                                startActivity(new Intent(AnimationListActivity.this, Animatio2Activity.class));
                                break;
                        }
                    }
                });
            }
        });
    }
}
