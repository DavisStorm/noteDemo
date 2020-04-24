package com.davis.mall.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.davis.mall.db.local.DaoMaster;

/**
 * Created by wyw on 2017/4/11.
 */

public class MySQLiteOpenHelper extends DaoMaster.OpenHelper {
    public MySQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}