package com.davis.mall.views;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.viewpager.widget.ViewPager;

import com.davis.mall.R;
import com.davis.mall.adapter.MySimpleAdapter;
import com.davis.mall.adapter.MyViewPagerAdapter;
import com.davis.mall.db.LocalGreenDao;
import com.davis.mall.db.Unit;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by mnkj004 on 2017/11/2.
 */

public class AddressDialog extends Dialog implements AdapterView.OnItemClickListener {

    private Context context;
    private ViewPager viewPager;
    private ArrayList<View> views;
    private MyViewPagerAdapter pagerAdapter;
    private TabLayout tabs;
    private List<HashMap<String, String>> list;
    private ArrayList<String> titles;
    private int mCurrentPosition;
    private List<Unit> provinces;
    private List<Unit> citys;
    private List<Unit> citysOrCountries;
    private Unit defaultProvince;
    private TextView cancelText;
    private TextView sureText;
    private IOnDecideListener listener;


    public AddressDialog(Context context) {
        super(context, R.style.my_dialog);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        setContentView(R.layout.layout_camera_control);
        hideVirtualKey();
        //按空白处隐藏对话框
        setCanceledOnTouchOutside(true);
        //初始化dialog界面 初始化viewpager中的每个view
        initDataAndViews();
        //设置dialog位置
        initLocation();

        initListener();
        //默认选择江苏省
        initDefaultProvince();


    }

    //当用户划出虚拟按键后，自动再隐藏方法
    private void hideVirtualKey() {
        getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
            @Override
            public void onSystemUiVisibilityChange(int visibility) {
                int uiOptions = View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                        //布局位于状态栏下方
                        View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
//                        全屏
//                        View.SYSTEM_UI_FLAG_FULLSCREEN |
                        //隐藏导航栏
                        View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                        View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
                if (Build.VERSION.SDK_INT >= 19) {
                    uiOptions |= 0x00001000;
                } else {
                    uiOptions |= View.SYSTEM_UI_FLAG_LOW_PROFILE;
                }
                getWindow().getDecorView().setSystemUiVisibility(uiOptions);
            }
        });
    }

    public void setOnDecideListener(IOnDecideListener listener) {
        this.listener = listener;
    }


    private void initDataAndViews() {
        views = new ArrayList<>();
        titles = new ArrayList<>();
        provinces = LocalGreenDao.getInstance().queryProvinces();
        defaultProvince = LocalGreenDao.getInstance().queryProvince(3613);
        titles.add(defaultProvince.getUName());

        if (provinces != null && provinces.size() > 0) {
            initListView(provinces);
            List<Unit> citys = LocalGreenDao.getInstance().queryCitys(defaultProvince.getTId());
            if (citys.size() > 0) {
                titles.add(citys.get(0).getUName());
                initListView(citys);
                List<Unit> countrys = LocalGreenDao.getInstance().queryCitysOrCountries(citys.get(0).getTId());
                if (countrys.size() > 0) {
                    titles.add(countrys.get(0).getUName());
                    initListView(countrys);
                    /*//根据县的第一条查询镇的数据，下面添加的虚拟数据
                    List<Unit> towns = LocalGreenDao.getInstance().queryCitysOrCountries(countrys.get(0).getTId());
                    if (towns.size() <= 0) {
                        towns = new ArrayList<>();
                        Unit unit1 = new Unit(0, "南河镇", null, null, null, null, null);
                        Unit unit2 = new Unit(0, "东坝镇", null, null, null, null, null);
                        towns.add(unit1);
                        towns.add(unit2);
                    }
                    titles.add(towns.get(0).getUName());
                    initListView(towns);*/

                }
            }
        }

    }


    private void initDefaultProvince() {
        ListView listView = (ListView) views.get(0).findViewById(R.id.listview);
        for (int i = 0; i < provinces.size(); i++) {
            if (provinces.get(i).getUName().equals(defaultProvince.getUName())) {
                listView.performItemClick(null, i, 0);
                listView.setSelection(i);
                viewPager.setCurrentItem(0);
            }
        }
    }

    private void initLocation() {
        pagerAdapter = new MyViewPagerAdapter(views, titles);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(pagerAdapter);
        tabs = (TabLayout) findViewById(R.id.tabs);
        cancelText = (TextView) findViewById(R.id.cancel);
        sureText = (TextView) findViewById(R.id.sure);
        Window dialogWindow = getWindow();
        dialogWindow.setGravity(Gravity.BOTTOM);
        dialogWindow.setWindowAnimations(R.style.dialogstyle); // 添加动画
        WindowManager.LayoutParams lp = dialogWindow.getAttributes(); // 获取对话框当前的参数值
        lp.x = 0; // 新位置X坐标
        lp.y = -20; // 新位置Y坐标
        lp.width = (int) context.getResources().getDisplayMetrics().widthPixels; // 宽度
        View view = getLayoutInflater().from(context).inflate(R.layout.layout_camera_control, null);
        view.measure(0, 0);
        lp.height = view.getMeasuredHeight();
        lp.alpha = 9f; // 透明度
        dialogWindow.setAttributes(lp);
        viewPager.setOffscreenPageLimit(3);
        tabs.setupWithViewPager(viewPager);
    }

    //初始化listview并准备添加到viewpager中
    private void initListView(List<Unit> unit) {
        View view1 = LayoutInflater.from(context).inflate(R.layout.dialog_listview, null);
        ListView listView = (ListView) view1.findViewById(R.id.listview);
        listView.setOnItemClickListener(this);
        createListData(unit);
        listView.setAdapter(new MySimpleAdapter(context, list, R.layout.address_dialog_listview, new String[]{"tv"}, new int[]{R.id.tv}));
        views.add(view1);
    }

    private void createListData(List<Unit> units) {
        list = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> stringMap;
        for (int i = 0; i < units.size(); i++) {
            stringMap = new HashMap<>();
            stringMap.put("tv", units.get(i).getUName());
            list.add(stringMap);
        }
    }

    private void initListener() {
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                mCurrentPosition = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        cancelText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onCancel(v);
            }
        });
        sureText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onSure(v, titles.get(0), titles.get(1), titles.get(2));
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ((MySimpleAdapter) parent.getAdapter()).setFlag(position);
        if (((MySimpleAdapter) parent.getAdapter()).getCount() != 0) {
            titles.set(mCurrentPosition, ((HashMap<String, String>) parent.getAdapter().getItem(position)).get("tv"));
        } else {
            titles.set(mCurrentPosition, "");
        }
        pagerAdapter.notifyDataSetChanged();
        if (mCurrentPosition == 0) {
            citys = LocalGreenDao.getInstance().queryCitys(provinces.get(position).getTId());
            initNextListView(citys);
        } else if (mCurrentPosition == 1) {
            citysOrCountries = LocalGreenDao.getInstance().queryCitysOrCountries(citys.get(position).getTId());
            initNextListView(citysOrCountries);
        } /*else if (mCurrentPosition == 2) {
            List<Unit> towns = LocalGreenDao.getInstance().queryCitysOrCountries(citysOrCountries.get(0).getTId());
            if (towns.size() <= 0) {
                towns = new ArrayList<>();
                Unit unit1 = new Unit(0, "南河镇" + position, null, null, null, null, null);
                Unit unit2 = new Unit(0, "东坝镇" + position, null, null, null, null, null);
                towns.add(unit1);
                towns.add(unit2);
            }
            initNextListView(towns);
        }*/ else {
            mCurrentPosition = viewPager.getCurrentItem();
            viewPager.setCurrentItem(mCurrentPosition + 1);
        }
    }

    private void initNextListView(List<Unit> units) {
        createListData(units);
        ListView listView = (ListView) views.get(mCurrentPosition + 1).findViewById(R.id.listview);
        listView.setAdapter(new MySimpleAdapter(context, list, R.layout.address_dialog_listview, new String[]{"tv"}, new int[]{R.id.tv}));
        mCurrentPosition++;
        listView.performItemClick(null, 0, 0);
    }

    public interface IOnDecideListener {
        void onCancel(View v);

        void onSure(View v, String province, String city, String district);
    }
}
