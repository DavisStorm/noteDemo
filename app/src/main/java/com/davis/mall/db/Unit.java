package com.davis.mall.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Unit {
//public class Unit extends RealmObject {

//    @PrimaryKey

    //    private long uId;//主键
//    @Id
    private String tId;//同主键id
    private String uName;//省名字
    private String uCode;//行政id
    private String uParent;//父id
    private String uStrid;
    private String uOrder;
    @Generated(hash = 1680525917)
    public Unit(String tId, String uName, String uCode, String uParent,
            String uStrid, String uOrder) {
        this.tId = tId;
        this.uName = uName;
        this.uCode = uCode;
        this.uParent = uParent;
        this.uStrid = uStrid;
        this.uOrder = uOrder;
    }
    @Generated(hash = 1236212320)
    public Unit() {
    }
    public String getTId() {
        return this.tId;
    }
    public void setTId(String tId) {
        this.tId = tId;
    }
    public String getUName() {
        return this.uName;
    }
    public void setUName(String uName) {
        this.uName = uName;
    }
    public String getUCode() {
        return this.uCode;
    }
    public void setUCode(String uCode) {
        this.uCode = uCode;
    }
    public String getUParent() {
        return this.uParent;
    }
    public void setUParent(String uParent) {
        this.uParent = uParent;
    }
    public String getUStrid() {
        return this.uStrid;
    }
    public void setUStrid(String uStrid) {
        this.uStrid = uStrid;
    }
    public String getUOrder() {
        return this.uOrder;
    }
    public void setUOrder(String uOrder) {
        this.uOrder = uOrder;
    }

}
