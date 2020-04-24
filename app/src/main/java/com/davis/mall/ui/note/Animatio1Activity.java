package com.davis.mall.ui.note;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.davis.mall.R;

public class Animatio1Activity extends AnimatioActivity {


    @Override
    protected String[] getList() {
        return getResources().getStringArray(R.array.Anim1);
    }
    @Override
    protected void startAnimation(int position) {
        Animation animation = null;
        switch (position){
            case 0://scale
                 animation = AnimationUtils.loadAnimation(this, R.anim.anim_scale);
                break;
            case 1://rotate
                animation = AnimationUtils.loadAnimation(this,R.anim.anim_rotate);
                break;
            case 2://translate
                animation = AnimationUtils.loadAnimation(this,R.anim.anim_trans);
                break;
            case 3://alpha
                animation = AnimationUtils.loadAnimation(this,R.anim.anim_alpha);
                break;
            case 4://set
                animation = AnimationUtils.loadAnimation(this,R.anim.anim_set);
                break;
            case 5://scale2
                animation = AnimationUtils.loadAnimation(this, R.anim.anim_scale2);
                break;
        }
        img.startAnimation(animation);
    }
}
