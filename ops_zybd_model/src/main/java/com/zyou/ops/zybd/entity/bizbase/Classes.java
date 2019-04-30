package com.zyou.ops.zybd.entity.bizbase;

import java.util.Date;

public class Classes {
    private Long bcId;

    private Long bcCompanyid;

    private String bcName;

    private Integer bcGrade;

    private Integer bcType;

    private Boolean bcIsdel;

    private Date bcCreatedate;

    private Date bcUpdatedate;

    private String bcReserved1;

    private String bcReserved2;

    private Byte bcGraduated;

    public Long getBcId() {
        return bcId;
    }

    public void setBcId(Long bcId) {
        this.bcId = bcId;
    }

    public Long getBcCompanyid() {
        return bcCompanyid;
    }

    public void setBcCompanyid(Long bcCompanyid) {
        this.bcCompanyid = bcCompanyid;
    }

    public String getBcName() {
        return bcName;
    }

    public void setBcName(String bcName) {
        this.bcName = bcName == null ? null : bcName.trim();
    }

    public Integer getBcGrade() {
        return bcGrade;
    }

    public void setBcGrade(Integer bcGrade) {
        this.bcGrade = bcGrade;
    }

    public Integer getBcType() {
        return bcType;
    }

    public void setBcType(Integer bcType) {
        this.bcType = bcType;
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

    public Byte getBcGraduated() {
        return bcGraduated;
    }

    public void setBcGraduated(Byte bcGraduated) {
        this.bcGraduated = bcGraduated;
    }
}