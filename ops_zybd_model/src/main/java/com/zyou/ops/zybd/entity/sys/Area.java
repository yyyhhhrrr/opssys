package com.zyou.ops.zybd.entity.sys;

import java.io.Serializable;
import java.util.Date;

public class Area implements Serializable {
    private Integer saId;

    private Integer saParentid;

    private String saParentids;

    private String saName;

    private String saNumber;

    private Integer saLevel;

    private Boolean saIsdel;

    private Date saCreatedate;

    private Date saUpdatedate;

    private String saReserved1;

    private String saReserved2;

    public Integer getSaId() {
        return saId;
    }

    public void setSaId(Integer saId) {
        this.saId = saId;
    }

    public Integer getSaParentid() {
        return saParentid;
    }

    public void setSaParentid(Integer saParentid) {
        this.saParentid = saParentid;
    }

    public String getSaParentids() {
        return saParentids;
    }

    public void setSaParentids(String saParentids) {
        this.saParentids = saParentids == null ? null : saParentids.trim();
    }

    public String getSaName() {
        return saName;
    }

    public void setSaName(String saName) {
        this.saName = saName == null ? null : saName.trim();
    }

    public String getSaNumber() {
        return saNumber;
    }

    public void setSaNumber(String saNumber) {
        this.saNumber = saNumber == null ? null : saNumber.trim();
    }

    public Integer getSaLevel() {
        return saLevel;
    }

    public void setSaLevel(Integer saLevel) {
        this.saLevel = saLevel;
    }

    public Boolean getSaIsdel() {
        return saIsdel;
    }

    public void setSaIsdel(Boolean saIsdel) {
        this.saIsdel = saIsdel;
    }

    public Date getSaCreatedate() {
        return saCreatedate;
    }

    public void setSaCreatedate(Date saCreatedate) {
        this.saCreatedate = saCreatedate;
    }

    public Date getSaUpdatedate() {
        return saUpdatedate;
    }

    public void setSaUpdatedate(Date saUpdatedate) {
        this.saUpdatedate = saUpdatedate;
    }

    public String getSaReserved1() {
        return saReserved1;
    }

    public void setSaReserved1(String saReserved1) {
        this.saReserved1 = saReserved1 == null ? null : saReserved1.trim();
    }

    public String getSaReserved2() {
        return saReserved2;
    }

    public void setSaReserved2(String saReserved2) {
        this.saReserved2 = saReserved2 == null ? null : saReserved2.trim();
    }
}