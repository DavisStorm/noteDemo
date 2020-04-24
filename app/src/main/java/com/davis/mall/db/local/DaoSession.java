package com.davis.mall.db.local;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.davis.mall.db.Unit;

import com.davis.mall.db.local.UnitDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig unitDaoConfig;

    private final UnitDao unitDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        unitDaoConfig = daoConfigMap.get(UnitDao.class).clone();
        unitDaoConfig.initIdentityScope(type);

        unitDao = new UnitDao(unitDaoConfig, this);

        registerDao(Unit.class, unitDao);
    }
    
    public void clear() {
        unitDaoConfig.clearIdentityScope();
    }

    public UnitDao getUnitDao() {
        return unitDao;
    }

}
