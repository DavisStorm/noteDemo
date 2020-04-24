package com.davis.mall.db.local;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.davis.mall.db.Unit;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "UNIT".
*/
public class UnitDao extends AbstractDao<Unit, Void> {

    public static final String TABLENAME = "UNIT";

    /**
     * Properties of entity Unit.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property TId = new Property(0, String.class, "tId", false, "T_ID");
        public final static Property UName = new Property(1, String.class, "uName", false, "U_NAME");
        public final static Property UCode = new Property(2, String.class, "uCode", false, "U_CODE");
        public final static Property UParent = new Property(3, String.class, "uParent", false, "U_PARENT");
        public final static Property UStrid = new Property(4, String.class, "uStrid", false, "U_STRID");
        public final static Property UOrder = new Property(5, String.class, "uOrder", false, "U_ORDER");
    }


    public UnitDao(DaoConfig config) {
        super(config);
    }
    
    public UnitDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"UNIT\" (" + //
                "\"T_ID\" TEXT," + // 0: tId
                "\"U_NAME\" TEXT," + // 1: uName
                "\"U_CODE\" TEXT," + // 2: uCode
                "\"U_PARENT\" TEXT," + // 3: uParent
                "\"U_STRID\" TEXT," + // 4: uStrid
                "\"U_ORDER\" TEXT);"); // 5: uOrder
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"UNIT\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Unit entity) {
        stmt.clearBindings();
 
        String tId = entity.getTId();
        if (tId != null) {
            stmt.bindString(1, tId);
        }
 
        String uName = entity.getUName();
        if (uName != null) {
            stmt.bindString(2, uName);
        }
 
        String uCode = entity.getUCode();
        if (uCode != null) {
            stmt.bindString(3, uCode);
        }
 
        String uParent = entity.getUParent();
        if (uParent != null) {
            stmt.bindString(4, uParent);
        }
 
        String uStrid = entity.getUStrid();
        if (uStrid != null) {
            stmt.bindString(5, uStrid);
        }
 
        String uOrder = entity.getUOrder();
        if (uOrder != null) {
            stmt.bindString(6, uOrder);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Unit entity) {
        stmt.clearBindings();
 
        String tId = entity.getTId();
        if (tId != null) {
            stmt.bindString(1, tId);
        }
 
        String uName = entity.getUName();
        if (uName != null) {
            stmt.bindString(2, uName);
        }
 
        String uCode = entity.getUCode();
        if (uCode != null) {
            stmt.bindString(3, uCode);
        }
 
        String uParent = entity.getUParent();
        if (uParent != null) {
            stmt.bindString(4, uParent);
        }
 
        String uStrid = entity.getUStrid();
        if (uStrid != null) {
            stmt.bindString(5, uStrid);
        }
 
        String uOrder = entity.getUOrder();
        if (uOrder != null) {
            stmt.bindString(6, uOrder);
        }
    }

    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    @Override
    public Unit readEntity(Cursor cursor, int offset) {
        Unit entity = new Unit( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // tId
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // uName
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // uCode
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // uParent
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // uStrid
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5) // uOrder
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Unit entity, int offset) {
        entity.setTId(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setUName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setUCode(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setUParent(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setUStrid(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setUOrder(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
     }
    
    @Override
    protected final Void updateKeyAfterInsert(Unit entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    @Override
    public Void getKey(Unit entity) {
        return null;
    }

    @Override
    public boolean hasKey(Unit entity) {
        // TODO
        return false;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}