package com.davis.mall.ui.note;

import android.graphics.Path;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.TextView;

import com.davis.mall.R;

public class Animatio2Activity extends AnimatioActivity {

    @Override
    protected String[] getList() {
        return getResources().getStringArray(R.array.Anim2);
    }

    public int getLayoutId(){
        return R.layout.activity_animation2;
    };

    @Override
    protected void init() {
        TextView tv_intro = findViewById(R.id.tv_intro);
        tv_intro.setText("插值器：根据时间计算动画完成度，Interpolator负责控制动画变化的速率，使得基本的动画效果能够以匀速、加速、减速、抛物线速率等各种速率变化");
    }

    @Override
    protected void startAnimation(int position) {
        Animation animation = null;
        switch (position){
            case 0://scale
                 animation = AnimationUtils.loadAnimation(this, R.anim.anim_trans_intepolate);
                animation.setInterpolator(new Interpolator() {//自定义
                    @Override
                    public float getInterpolation(float input) {//(make the return value between 0 and 1,or less than 0,or more than 1)
                        return (float)(Math.cos((input + 1) * Math.PI) / 2.0f) + 0.5f;
                    }
                });
                break;
            case 1://AccelerateDecelerateInterpolator
                animation = AnimationUtils.loadAnimation(this,R.anim.anim_trans_intepolate);
                animation.setInterpolator(new AccelerateDecelerateInterpolator());
                break;
            case 2://AnticipateInterpolator
                animation = AnimationUtils.loadAnimation(this,R.anim.anim_trans_intepolate);
                animation.setInterpolator(new AnticipateInterpolator());
                break;
            case 3://PathInterpolator
                animation = AnimationUtils.loadAnimation(this,R.anim.anim_trans_intepolate);
                Path path = new Path();
                path.moveTo(0,0);
                path.quadTo(0.2f,0.5f,1f,1f);//贝塞尔曲线
                path.moveTo(0.2f,0.5f);
                animation.setInterpolator(new PathInterpolator(path));//the path(x,y) x y should be within (0,0) to (1,1)
                break;
            case 4://BounceInterpolator  动画结束的时候弹起
                animation = AnimationUtils.loadAnimation(this,R.anim.anim_trans_intepolate);
                animation.setInterpolator(new BounceInterpolator());
                break;
            case 5://LinearInterpolator
                animation = AnimationUtils.loadAnimation(this, R.anim.anim_trans_intepolate);
                animation.setInterpolator(new LinearInterpolator());
                break;
            case 6://OvershootInterpolator
                animation = AnimationUtils.loadAnimation(this, R.anim.anim_trans_intepolate);
                animation.setInterpolator(new OvershootInterpolator());
                break;
            case 7://AnticipateOvershootInterpolator
                animation = AnimationUtils.loadAnimation(this, R.anim.anim_trans_intepolate);
                animation.setInterpolator(new AnticipateOvershootInterpolator());
                break;
            case 8://AccelerateInterpolator
                animation = AnimationUtils.loadAnimation(this, R.anim.anim_trans_intepolate);
                animation.setInterpolator(new AccelerateInterpolator());
                break;
            case 9://DecelerateInterpolator
                animation = AnimationUtils.loadAnimation(this, R.anim.anim_trans_intepolate);
                animation.setInterpolator(new DecelerateInterpolator());
                break;
            case 10://CycleInterpolator
                animation = AnimationUtils.loadAnimation(this, R.anim.anim_trans_intepolate);
                animation.setInterpolator(new CycleInterpolator(3));//Repeats the animation for a specified number of cycles
                break;
        }
        img.startAnimation(animation);
    }
}
