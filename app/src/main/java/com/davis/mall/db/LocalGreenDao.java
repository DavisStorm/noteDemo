package com.davis.mall.db;

import android.content.Context;
import android.widget.Toast;

import com.davis.mall.MallApplication;
import com.davis.mall.db.local.DaoMaster;
import com.davis.mall.db.local.DaoSession;
import com.davis.mall.db.local.UnitDao;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by wyw on 2017/4/11.
 */

public class LocalGreenDao {
    private static LocalGreenDao instance;
    private DaoMaster daoMaster;
    private DaoSession daoSession;
    private static final String DATABASE_NAME = "userdata.db";
    private Context mContext;

    public LocalGreenDao(Context mContext) {
        getDaoSession();
        this.mContext = mContext;
    }

    public static LocalGreenDao getInstance() {
        if (instance == null) {
            instance = new LocalGreenDao(MallApplication.getContext());
        }
        return instance;
    }


    private DaoMaster obtainMaster(Context context, String dbName) {
        //改
        return new DaoMaster(new MySQLiteOpenHelper(context, dbName, null).getWritableDatabase());
//        return new DaoMaster(new MySQLiteOpenHelper(context, dbName, null).getWritableDatabase());
    }

    private DaoMaster getDaoMaster(Context context, String dbName) {
        if (dbName == null)
            return null;
        if (daoMaster == null) {
            daoMaster = obtainMaster(context, dbName);
        }
        return daoMaster;
    }

    /**
     * 取得DaoSession
     *
     * @return
     */
    public DaoSession getDaoSession(String dbName) {

        if (daoSession == null) {
            daoSession = getDaoMaster(MallApplication.getContext(), dbName).newSession();
        }
        return daoSession;
    }

    /**
     * 默认操作localdata数据库
     */
    public DaoSession getDaoSession() {

        if (daoSession == null) {
            daoSession = getDaoMaster(MallApplication.getContext(), DATABASE_NAME).newSession();
        }
        return daoSession;
    }


    /**
     * 保存省市县信息
     */
    public void insertUnit() {
        Toast.makeText(MallApplication.getContext(),"正在加载本地数据...", Toast.LENGTH_SHORT).show();
        new Thread(new Runnable() {
            @Override
            public void run() {
                UnitDao unitDao = daoSession.getUnitDao();
                try {
                    unitDao.deleteAll();
                    InputStream inputStream = mContext.getAssets().open("unit.txt");
                    List<Unit> units = new Gson().fromJson(new InputStreamReader(inputStream), new TypeToken<List<Unit>>() {
                    }.getType());
                    unitDao.insertInTx(units);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }).start();
    }

    /**
     * 查询所有的省
     */
    public List<Unit> queryProvinces() {
        return daoSession.getUnitDao().queryBuilder().where(UnitDao.Properties.UParent.eq("1")).list();
//        return localRealm.where(Unit.class).equalTo("uParent", "1").findAll();
    }

    /**
     * 查询所有的省 查找指定省
     * 江苏省 tid 1435
     */
    public Unit queryProvince(int tId) {
        return daoSession.getUnitDao().queryBuilder().where(UnitDao.Properties.UParent.eq("1"),
                UnitDao.Properties.TId.eq(String.valueOf(tId))).list().get(0);
//        return localRealm.where(Unit.class).equalTo("uParent", "1").equalTo("tId", String.valueOf(tId)).findAll().get(0);
    }

    /**
     * 查询省下面的市
     *
     * @param uParent 省的tId值
     */
    public List<Unit> queryCitys(String uParent) {
        return daoSession.getUnitDao().queryBuilder().
                where(UnitDao.Properties.UParent.eq(uParent)).list();
//        return localRealm.where(Unit.class).equalTo("uParent", String.valueOf(uParent)).findAll();
    }

    public List<Unit> queryCitys(int uParent) {
        return daoSession.getUnitDao().queryBuilder().
                where(UnitDao.Properties.UParent.eq(String.valueOf(uParent))).list();
//        return localRealm.where(Unit.class).equalTo("uParent", String.valueOf(uParent)).findAll();
    }

    /**
     * 查询省下面的市 县
     */
    public List<Unit> queryCitysOrCountries(String uParent) {
        return daoSession.getUnitDao().queryBuilder().where(UnitDao.Properties.UParent.eq(uParent)).list();
//        return localRealm.where(Unit.class).equalTo("uParent", uParent).findAll();
    }


}
