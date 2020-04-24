package com.davis.mall.ui;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.davis.mall.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author 王阳
 * @time 2020/1/16  14:01
 * @desc
 */
public class TouEventActivity extends Activity implements View.OnClickListener {//implements View.OnTouchListener
    @BindView(R.id.tv_text)
    TextView mTvText;
    @BindView(R.id.rl_parent)
    RelativeLayout mRlParent;
    @BindView(R.id.rl_big)
    RelativeLayout rl_big;
    @BindView(R.id.img_anim)
    ImageView mImgAnim;
    private Handler mHandler;
    private Animation mAnimation;
    private AnimationSet mSetAnimation;
    private ObjectAnimator mTranslationY;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touchevent);
        ButterKnife.bind(this);
        initLisener();
        creatHandler();//handler线程测试
        createAnim();

    }

    private void createAnim() {
        mAnimation = AnimationUtils.loadAnimation(this, R.anim.tween_anim);
        mAnimation.setFillAfter(true);//设置动画结束后保留结束状态


        // 动态设置补间动画    之组合动画设置
        mSetAnimation = new AnimationSet(true);

        // 特别说明以下情况
        // 因为在下面的旋转动画设置了无限循环(RepeatCount = INFINITE)
        // 所以动画不会结束，而是无限循环
        // 所以组合动画的下面两行设置是无效的
        mSetAnimation.setRepeatMode(Animation.RESTART);
        mSetAnimation.setRepeatCount(1);// 设置了循环一次,但无效

        // 旋转动画
        Animation rotate = new RotateAnimation(0,360,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        rotate.setDuration(1000);
        rotate.setRepeatMode(Animation.RESTART);
        rotate.setRepeatCount(Animation.INFINITE);

        // 平移动画
        Animation translate = new TranslateAnimation(TranslateAnimation.RELATIVE_TO_PARENT,-0.5f,
                TranslateAnimation.RELATIVE_TO_PARENT,0.5f,
                TranslateAnimation.RELATIVE_TO_SELF,0
                ,TranslateAnimation.RELATIVE_TO_SELF,0);
        translate.setDuration(10000);

        // 透明度动画
        Animation alpha = new AlphaAnimation(1,0);
        alpha.setDuration(3000);
        alpha.setStartOffset(7000);

        // 缩放动画
        Animation scale1 = new ScaleAnimation(1,0.5f,1,0.5f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        scale1.setDuration(1000);
        scale1.setStartOffset(4000);

        // 将创建的子动画添加到组合动画里
        mSetAnimation.addAnimation(alpha);
        mSetAnimation.addAnimation(rotate);
        mSetAnimation.addAnimation(translate);
        mSetAnimation.addAnimation(scale1);
        mSetAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        mTranslationY = ObjectAnimator.ofFloat(mImgAnim, "translationY", 200F);
        mTranslationY.setDuration(500);

    }

    private void creatHandler() {
        MyThread myThread = new MyThread();
        myThread.start();
        SystemClock.sleep(300);
        mHandler = new Handler(myThread.looper) {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                switch (msg.what) {
                    case 1:
                        Log.e("handleMessage", "handleMessage1:" + msg.obj);
                        break;
                    case 2:
                        Log.e("handleMessage", "handleMessage2:" + msg.obj);
                        break;
                }
            }
        };

    }

    private void initLisener() {
        mTvText.setOnClickListener(this);
        mRlParent.setOnClickListener(this);
        rl_big.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_text://
                Log.e("onClick", "onClick:tv_text");//点击事件测试
                break;
            case R.id.rl_parent:
                //                Message message = new Message();
                //                message.what=1;
                //                message.obj = Thread.currentThread().getName();
                //                mHandler.sendMessage(message);
//                mImgAnim.startAnimation(mSetAnimation);
                mTranslationY.start();
                Log.e("onClick", "onClick:rl_parent");
                break;
            case R.id.rl_big:
                Log.e("onClick", "onClick:rl_big");
                break;
        }
    }

    class MyThread extends Thread {
        Looper looper;

        @Override
        public void run() {
            super.run();
            Looper.prepare();
            looper = Looper.myLooper();
            Looper.loop();
        }
    }

}
