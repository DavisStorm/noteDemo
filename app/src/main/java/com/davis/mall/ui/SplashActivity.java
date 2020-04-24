package com.davis.mall.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;

import com.davis.mall.R;
import com.davis.particleview2.ParticleView;

public class SplashActivity extends Activity {

    private static final String TAG = "SplashActivity";

    private Handler mHandler = new Handler();

    private ParticleView pvGs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        pvGs = (ParticleView)findViewById(R.id.pv_gs);
        pvGs.startAnim();

        pvGs.setOnParticleAnimListener(new ParticleView.ParticleAnimListener() {
            @Override
            public void onAnimationEnd() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
//                Bundle bundle = ActivityOptionsCompat.makeSceneTransitionAnimation(SplashActivity.this).toBundle();
                startActivity(intent);
                finish();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        //        MobclickAgent.onPageStart(TAG); //手动统计页面
        //        MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //        MobclickAgent.onPageEnd(TAG);
        //        MobclickAgent.onPause(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mHandler != null){
            mHandler.removeCallbacksAndMessages(null);
            mHandler = null;
        }
    }

    /**
     * 屏蔽了返回按键
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
