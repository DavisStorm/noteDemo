package com.davis.mall.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;

import com.davis.mall.R;
import com.davis.mall.utils.StatusBarUtil;
import com.davis.mall.utils.ToolbarUtil;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.tv_toolbar_main_title)
    TextView mTvToolbarMainTitle;
    @BindView(R.id.tb_main)
    Toolbar mTbMain;
    @BindView(R.id.abl_main)
    AppBarLayout mAblMain;
    @BindView(R.id.sdv_launcher)
    SimpleDraweeView mSdvLauncher;
    @BindView(R.id.rl_kuaikan)
    RelativeLayout mRlKuaikan;
    @BindView(R.id.rl_manman)
    RelativeLayout mRlManman;
    @BindView(R.id.rl_zhijia)
    RelativeLayout mRlZhijia;
    @BindView(R.id.rl_wangyi)
    RelativeLayout mRlWangyi;
    @BindView(R.id.tv_history)
    TextView mTvHistory;
    @BindView(R.id.tv_favorite)
    TextView mTvFavorite;
    @BindView(R.id.tv_about)
    TextView mTvAbout;
    @BindView(R.id.dl_left_main)
    DrawerLayout mDlLeftMain;
    @BindView(R.id.framelayout)
    FrameLayout mFramelayout;
    @BindView(R.id.bottomNavigationView)
    BottomNavigationView mBottomNavigationView;
    @BindView(R.id.tool_search_et)
    EditText mToolSearchEt;
    private Unbinder mBind;
    private int FM_COUNT = 5;
    private static final int SOUYE_INDEX = 0;
    private static final int FENLEI_INDEX = 1;
    private static final int FAXIAN_INDEX = 2;
    private static final int GOUWUCHE_INDEX = 3;
    private static final int WODE_INDEX = 4;
    private FragmentPagerAdapter mFragmentPagerAdapter;
    private ShouYeFragment mShouYeFragment;
    private FenLeiFragment mFenLeiFragment;
    private FaXianFragment mFaXianFragment;
    private GouWuCheFragment mGouWuCheFragment;
    private WodeFragment mWodeFragment;
    //定义一个变量，来标识是否退出
    private static boolean isExit=false;

    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg){
            super.handleMessage(msg);
            isExit=false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        Fresco.initialize(MainActivity.this);
        setContentView(R.layout.activity_main);
        mBind = ButterKnife.bind(this);

        //启动透明状态栏
        StatusBarUtil.enableTranslucentStatusBar(this);

        ToolbarUtil.initToolbar(this, mTbMain);
        ToolbarUtil.actionBarDrawerToggle(this, mDlLeftMain, mTbMain);

        //初始化装fragment的适配器
        initAdapter();

        initLisener();

        setFragment(SOUYE_INDEX);

    }

    private void initAdapter() {
        mFragmentPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public int getCount() {
                return FM_COUNT;
            }

            @Override
            public Fragment getItem(int position) {
                Fragment fragment = null;
                switch (position) {
                    case SOUYE_INDEX:
                        if (mShouYeFragment == null) {
                            mShouYeFragment = ShouYeFragment.newInstance();
                        }
                        fragment = mShouYeFragment;
                        break;
                    case FENLEI_INDEX:
                        if (mFenLeiFragment == null) {
                            mFenLeiFragment = FenLeiFragment.newInstance();
                        }
                        fragment = mFenLeiFragment;
                        break;
                    case FAXIAN_INDEX:
                        if (mFaXianFragment == null) {
                            mFaXianFragment = FaXianFragment.newInstance();
                        }
                        fragment = mFaXianFragment;
                        break;
                    case GOUWUCHE_INDEX:
                        if (mGouWuCheFragment == null) {
                            mGouWuCheFragment = GouWuCheFragment.newInstance();
                        }
                        fragment = mGouWuCheFragment;
                        break;
                    case WODE_INDEX:
                        if (mWodeFragment == null) {
                            mWodeFragment = WodeFragment.newInstance();
                        }
                        fragment = mWodeFragment;
                        break;

                }
                return fragment;
            }
        };
    }

    private void initLisener() {
        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //Log.e("MenuItem ", "id: "+item.getItemId());
                //Toast.makeText(MainActivity.this, "id: "+item.getItemId(), Toast.LENGTH_SHORT).show();
                switch (item.getItemId()) {
                    case R.id.tab_souye://首页
                        setFragment(SOUYE_INDEX);
                        searchShow(true);
                        break;
                    case R.id.tab_fenlei://分类
                        setFragment(FENLEI_INDEX);
                        searchShow(true);
                        break;
                    case R.id.tab_faxian://发现
                        setFragment(FAXIAN_INDEX);
                        searchShow(false,"发现");
                        break;
                    case R.id.tab_gouwuche://购物车
                        setFragment(GOUWUCHE_INDEX);
                        searchShow(false,"购物车");
                        break;
                    case R.id.tab_wode://我的
                        setFragment(WODE_INDEX);
                        searchShow(false,"我的");
                        break;
                }
                return true;
            }
        });
        mRlKuaikan.setOnClickListener(this);
        mTvHistory.setOnClickListener(this);

    }

    private void setFragment(int index) {
        //以mFramelayout为容器（挂在了mFramelayout，可以被看见） 初始化适配器index位置的view
        //instantiateItem方法执行会调用getitem方法
        Fragment fm= (Fragment) mFragmentPagerAdapter.instantiateItem(mFramelayout, index);
        //这里设置哪一个fragment在第一个
        mFragmentPagerAdapter.setPrimaryItem(mFramelayout, 0, fm);
        mFragmentPagerAdapter.finishUpdate(mFramelayout);
    }

    public void searchShow(boolean ifShow){
        searchShow(ifShow,"");
    }
    public void searchShow(boolean ifShow,String title){
        mToolSearchEt.setVisibility(ifShow?View.VISIBLE:View.GONE);
        mTvToolbarMainTitle.setVisibility(ifShow?View.GONE:View.VISIBLE);
        mTvToolbarMainTitle.setText(title);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mBind != null) {
            mBind.unbind();
        }
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if(keyCode==KeyEvent.KEYCODE_BACK){
            exit();
            return false;
        }
        return super.onKeyDown(keyCode,event);
    }

    private void exit(){
        if(!isExit){
            isExit=true;
            Toast.makeText(getApplicationContext(),"再按一退出程序",Toast.LENGTH_SHORT).show();
                    //利用handler延迟发送更改状态信息
                    handler.sendEmptyMessageDelayed(0,2000);
        }
        else{
            finish();
            System.exit(0);
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case  R.id.rl_kuaikan:
                intent.setClass(MainActivity.this,TouEventActivity.class);
                break;
            case  R.id.tv_history:
                intent.setClass(MainActivity.this,NoteActivity.class);
                break;

        }
        startActivity(intent);
    }
}
