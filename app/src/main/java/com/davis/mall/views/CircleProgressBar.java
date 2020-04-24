package com.davis.mall.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;

import androidx.annotation.Nullable;

import com.davis.mall.R;

import me.jessyan.autosize.utils.LogUtils;

/**
 * @author 王阳
 * @time 2020/2/14  17:47
 * @desc
 */
public class CircleProgressBar extends View implements Animation.AnimationListener {

    private float mRingWidth;
    private int mRingColor;
    private float mRadius;
    private Paint mRingPaint;
    private float mProgressRingWidth;
    private int mProgressRingStartColor;
    private int mProgressRingEndColor;
    private Paint mProgressRingPaint;
    private int[] arcColors;
    /**
     * 进度条圆环渐变shader
     */
    private Shader mProgressRingShader;
    private int mResultWidth;
    /**
     * 进度动画
     */
    private BarAnimation barAnimation;
    /**
     * 抖动（缩放）动画
     */
    private ScaleAnimation scaleAnimation;
    /**
     * 是否正在改变
     */
    private boolean isAnimation = false;

    /**
     * 圆环转过的角度
     */
    private float mSweepAngle = 1;
    /**
     * 之前的角度
     */
    private float mOldAngle = 0;
    /**
     * 新的角度
     */
    private float mNewAngle = 0;

    public CircleProgressBar(Context context) {
        super(context,null);
    }

    public CircleProgressBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs,0);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CircleProgressBar);
        mRingWidth = typedArray.getDimension(R.styleable.CircleProgressBar_ring_width, 0);
        mRingColor = typedArray.getColor(R.styleable.CircleProgressBar_ring_color, Color.parseColor("#CBCBCB"));
        mRadius = typedArray.getDimension(R.styleable.CircleProgressBar_radius, 0);

        mProgressRingWidth = typedArray.getDimension(R.styleable.CircleProgressBar_progress_ring_width, 0);
        mProgressRingStartColor = typedArray.getColor(R.styleable.CircleProgressBar_progress_ring_start_color, Color.parseColor("#f90aa9"));
        mProgressRingEndColor = typedArray.getColor(R.styleable.CircleProgressBar_progress_ring_end_color, Color.parseColor("#931c80"));

        typedArray.recycle();
        init();

    }

    public CircleProgressBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr,0);
    }

    public CircleProgressBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private void init() {
        mRingPaint = new Paint();
        mRingPaint.setAntiAlias(true);//抗锯齿
        mRingPaint.setColor(mRingColor);
        mRingPaint.setStyle(Paint.Style.STROKE);

        arcColors = new int[]{mProgressRingStartColor, mProgressRingEndColor};
        mProgressRingPaint = new Paint();
        mProgressRingPaint.setAntiAlias(true);
        mProgressRingPaint.setStyle(Paint.Style.STROKE);
        mProgressRingPaint.setStrokeWidth(mProgressRingWidth);
        mProgressRingPaint.setStrokeCap(Paint.Cap.ROUND);// 圆形线帽

        barAnimation = new BarAnimation();
        barAnimation.setAnimationListener(this);

        scaleAnimation = new ScaleAnimation();
        scaleAnimation.setDuration(100);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    /**
     * 设置新的角度
     * newAngle:角度
     */
    public void setAngle(final float newAngle) {
        setAngle(newAngle, false);
    }

    /**
     * 设置新的角度
     */
    public void setAngle(final float newAngle,boolean isScale) {
        LogUtils.e(""+(!isAnimation));
        if (!isAnimation) {
            LogUtils.e(""+isScale);
            if(isScale){
                scaleAnimation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        changeAngle(newAngle);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                startAnimation(scaleAnimation);
            }else{
                LogUtils.e("changeAngle: start");
                changeAngle(newAngle);
            }
        }
    }


    private void changeAngle(float newAngle){
        LogUtils.e("newAngle:"+newAngle);
        LogUtils.e("mOldAngle:"+mOldAngle);
        LogUtils.e("mNewAngle:"+mNewAngle);
        mOldAngle = mNewAngle;
        mNewAngle = newAngle;
        int duration = (int) (Math.abs(mNewAngle - mOldAngle) * 15);
        LogUtils.e("duration:"+duration);
        barAnimation.setDuration(duration);
        barAnimation.setInterpolator(new DecelerateInterpolator());
        startAnimation(barAnimation);
    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        //圆的宽度
        mResultWidth = width<height?width:height;
        //环的宽度为圆半径的1/5，那么实际上在drawCircle的半径参数应该为圆半径减去环宽度的一半（也就是圆半径的1/10）
        mRadius = mRadius == 0 ? mResultWidth/2: mRadius;//默认整个圆的宽度
        float radius = mRadius*9/10;
        mRingWidth = mRingWidth == 0 ? mResultWidth/2/5 : mRingWidth;//默认环的宽度为圆半径的1/5
        mRingPaint.setStrokeWidth(mRingWidth);
        LogUtils.e("mRadius:"+mRadius+" mRingWidth:"+mRingWidth);
        canvas.drawCircle(width/2,height/2,radius,mRingPaint);

        if(mProgressRingShader==null) {
            mProgressRingShader = new SweepGradient(width / 2, height / 2, arcColors, null);
            mProgressRingPaint.setShader(mProgressRingShader);
        }
        mProgressRingWidth = mProgressRingWidth==0?mRingWidth:mProgressRingWidth;
        mProgressRingPaint.setStrokeWidth(mProgressRingWidth);
        //计算进度环的矩形框参数
        float left = (width / 2 - mResultWidth /2) + (mRingWidth / 2);//加号左部分为圆左边的宽度，右边为圆环宽度的一半
        float top = (height / 2 - mResultWidth /2) + (mRingWidth / 2);
        float right = (width / 2 - mResultWidth /2) + (mResultWidth -mRingWidth / 2);
        float bottom = (height / 2 - mResultWidth /2) + (mResultWidth -mRingWidth / 2);
        //解决颜色渐变问题
        canvas.save();
        //旋转画布90度+笔头半径转过的角度
        double radian = radianToAngle(radius);
        double degrees = Math.toDegrees(-2 * Math.PI / 360 * (90 + radian));// 90度+
        //逆时针旋转90度
        canvas.rotate((float)degrees, width/2, height/2);
        LogUtils.e("onDraw mOldAngle:"+mOldAngle);
        LogUtils.e("onDraw mSweepAngle:"+mSweepAngle);
        canvas.drawArc(new RectF(left,top, right,bottom),(float)radian, mOldAngle + mSweepAngle, false, mProgressRingPaint);
        super.onDraw(canvas);
    }

    /**
     * 已知圆半径和切线长求弧长公式
     */
    private double radianToAngle(float radius) {
        double aa = mProgressRingWidth / 2 / radius;
        double asin = Math.asin(aa);
        double radian = Math.toDegrees(asin);
        return radian;
    }
    /**
     * 抖动（缩放动画）
     */
    public class ScaleAnimation extends Animation {
        private int centerX;
        private int centerY;

        public ScaleAnimation() {
        }

        @Override
        public void initialize(int width, int height, int parentWidth,
                               int parentHeight) {
            super.initialize(width, height, parentWidth, parentHeight);
            centerX = width / 2;
            centerY = height / 2;
        }

        @Override
        protected void applyTransformation(float interpolatedTime, Transformation t) {
            super.applyTransformation(interpolatedTime, t);

            if (interpolatedTime < 0.25f) {
                // 1-1.1
                float ss = interpolatedTime * 0.4f + 1f;
                Matrix matrix = t.getMatrix();
                matrix.setScale(ss, ss, centerX, centerY);
            } else if (interpolatedTime >= 0.25f && interpolatedTime < 0.5f) {
                // 1.1-1
                float ss = (0.5f - interpolatedTime) * 0.4f + 1f;
                Matrix matrix = t.getMatrix();
                matrix.setScale(ss, ss, centerX, centerY);
            } else if (interpolatedTime >= 0.5f && interpolatedTime < 0.75f) {
                // 1-0.9
                float ss = (0.75f - interpolatedTime) * 0.4f + 0.9f;
                Matrix matrix = t.getMatrix();
                matrix.setScale(ss, ss, centerX, centerY);
            } else if (interpolatedTime >= 0.75f && interpolatedTime <= 1f) {
                // 0.9-1
                float ss = interpolatedTime * 0.4f + 0.6f;
                Matrix matrix = t.getMatrix();
                matrix.setScale(ss, ss, centerX, centerY);
            }
        }
    }

    /**
     * 进度条动画
     */
    public class BarAnimation extends Animation {


        public BarAnimation() {
        }

        /**
         * 然后调用postInvalidate()不停的绘制view。
         */
        @Override
        protected void applyTransformation(float interpolatedTime,
                                           Transformation t) {

            super.applyTransformation(interpolatedTime, t);
            LogUtils.e("BarAnimation:mNewAngle:"+mNewAngle);
            LogUtils.e("BarAnimation:mOldAngle:"+mOldAngle);
            if (mNewAngle - mOldAngle >= 0) {
                // 正向
                mSweepAngle = interpolatedTime * (mNewAngle - mOldAngle);
                LogUtils.e("BarAnimation:mSweepAngle正向:"+mSweepAngle);
            } else {
                // 逆向
                mSweepAngle = interpolatedTime * (mNewAngle - mOldAngle);
                LogUtils.e("BarAnimation:mSweepAngle逆向:"+mSweepAngle);
            }
            LogUtils.e("applyTransformation:");
            postInvalidate();
        }
    }

    @Override
    public void onAnimationStart(Animation animation) {
        isAnimation = true;
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        isAnimation = false;

    }

    @Override
    public void onAnimationRepeat(Animation animation) {
        // TODO Auto-generated method stub
    }

}
