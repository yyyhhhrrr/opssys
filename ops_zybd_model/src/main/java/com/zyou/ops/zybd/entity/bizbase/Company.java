package com.zyou.ops.zybd.entity.bizbase;

import java.io.Serializable;
import java.util.Date;

public class Company implements Serializable {
    private Long bcId;

    private Long bcProvinceid;

    private Long bcCityid;

    private Long bcAreaid;

    private String bcNumber;

    private String bcName;

    private String bcManager;

    private String bcTel;

    private String bcAddress;

    private String bcType;

    private String bcBizness;

    private Boolean bcIsdel;

    private Date bcCreatedate;

    private Date bcUpdatedate;

    private String bcReserved1;

    private String bcReserved2;

    public Long getBcId() {
        return bcId;
    }

    public void setBcId(Long bcId) {
        this.bcId = bcId;
    }

    public Long getBcProvinceid() {
        return bcProvinceid;
    }

    public void setBcProvinceid(Long bcProvinceid) {
        this.bcProvinceid = bcProvinceid;
    }

    public Long getBcCityid() {
        return bcCityid;
    }

    public void setBcCityid(Long bcCityid) {
        this.bcCityid = bcCityid;
    }

    public Long getBcAreaid() {
        return bcAreaid;
    }

    public void setBcAreaid(Long bcAreaid) {
        this.bcAreaid = bcAreaid;
    }

    public String getBcNumber() {
        return bcNumber;
    }

    public void setBcNumber(String bcNumber) {
        this.bcNumber = bcNumber == null ? null : bcNumber.trim();
    }

    public String getBcName() {
        return bcName;
    }

    public void setBcName(String bcName) {
        this.bcName = bcName == null ? null : bcName.trim();
    }

    public String getBcManager() {
        return bcManager;
    }

    public void setBcManager(String bcManager) {
        this.bcManager = bcManager == null ? null : bcManager.trim();
    }

    public String getBcTel() {
        return bcTel;
    }

    public void setBcTel(String bcTel) {
        this.bcTel = bcTel == null ? null : bcTel.trim();
    }

    public String getBcAddress() {
        return bcAddress;
    }

    public void setBcAddress(String bcAddress) {
        this.bcAddress = bcAddress == null ? null : bcAddress.trim();
    }

    public String getBcType() {
        return bcType;
    }

    public void setBcType(String bcType) {
        this.bcType = bcType == null ? null : bcType.trim();
    }

    public String getBcBizness() {
        return bcBizness;
    }

    public void setBcBizness(String bcBizness) {
        this.bcBizness = bcBizness == null ? null : bcBizness.trim();
    }

    public Boolean getBcIsdel() {
        return bcIsdel;
    }

    public void setBcIsdel(Boolean bcIsdel) {
        this.bcIsdel = bcIsdel;
    }

    public Date getBcCreatedate() {
        return bcCreatedate;
    }

    public void setBcCreatedate(Date bcCreatedate) {
        this.bcCreatedate = bcCreatedate;
    }

    public Date getBcUpdatedate() {
        return bcUpdatedate;
    }

    public void setBcUpdatedate(Date bcUpdatedate) {
        this.bcUpdatedate = bcUpdatedate;
    }

    public String getBcReserved1() {
        return bcReserved1;
    }

    public void setBcReserved1(String bcReserved1) {
        this.bcReserved1 = bcReserved1 == null ? null : bcReserved1.trim();
    }

    public String getBcReserved2() {
        return bcReserved2;
    }

    public void setBcReserved2(String bcReserved2) {
        this.bcReserved2 = bcReserved2 == null ? null : bcReserved2.trim();
    }
}