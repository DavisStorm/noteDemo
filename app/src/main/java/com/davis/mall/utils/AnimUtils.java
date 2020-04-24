package com.davis.mall.utils;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;

import com.davis.mall.interfac.Animationlisener;
import com.davis.mall.views.CircleImageView;

/**
 * @author 王阳
 * @time 2020/1/22  13:10
 * @desc
 */
public class AnimUtils {
    public static void startAddCarAnim(Activity activity, final Bitmap bp, int[] startLocation, int[] endLocation, final Animationlisener lisener){
        ViewGroup rootView = (ViewGroup) activity.getWindow().getDecorView();
        final CircleImageView imageView = new CircleImageView(activity);
        rootView.addView(imageView);
        imageView.setImageBitmap(bp);
//        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(100, 100);
        params.leftMargin = startLocation[0];
        params.topMargin = startLocation[1];
        imageView.setLayoutParams(params);

        AnimationSet set = new AnimationSet(false);
        TranslateAnimation translateXAnimation = new TranslateAnimation(0, endLocation[0]-startLocation[0], 0, 0);
        translateXAnimation.setInterpolator(new LinearInterpolator());
        translateXAnimation.setFillAfter(true);
        translateXAnimation.setRepeatCount(0);
        TranslateAnimation translateYAnimation = new TranslateAnimation(0, 0, 0, endLocation[1]-startLocation[1]);
        translateYAnimation.setInterpolator(new AccelerateInterpolator());
        translateYAnimation.setFillAfter(true);
        translateYAnimation.setRepeatCount(0);
        set.addAnimation(translateXAnimation);
        set.addAnimation(translateYAnimation);
        set.setDuration(500);
        set.setFillAfter(false);
        set.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                imageView.setVisibility(View.VISIBLE);
            }
            @Override
            public void onAnimationEnd(Animation animation) {
                imageView.setVisibility(View.GONE);
                if (lisener != null) {
                    lisener.onAnimEnd();
                }

            }
            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        imageView.startAnimation(set);
    }
}
