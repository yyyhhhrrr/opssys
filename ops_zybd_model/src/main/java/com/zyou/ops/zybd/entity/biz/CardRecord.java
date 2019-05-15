package com.zyou.ops.zybd.entity.biz;

import java.io.Serializable;
import java.util.Date;

public class CardRecord implements Serializable {
    private Long bcId;

    private Long bcCompanyid;

    private Long bcClassid;

    private Long bcStudentid;

    private Long bcActionid;

    private String bcActiontype;

    private String bcDeviceid;

    private String bcTimestamp;

    private String bcEnddate;

    private Boolean bcIsdel;

    private Date bcCreatedate;

    private Date bcUpdatedate;

    private String bcReserved1;

    private String bcReserved2;

    private String bcRecordtime;

    private Integer bcWaterintake;

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

    public Long getBcClassid() {
        return bcClassid;
    }

    public void setBcClassid(Long bcClassid) {
        this.bcClassid = bcClassid;
    }

    public Long getBcStudentid() {
        return bcStudentid;
    }

    public void setBcStudentid(Long bcStudentid) {
        this.bcStudentid = bcStudentid;
    }

    public Long getBcActionid() {
        return bcActionid;
    }

    public void setBcActionid(Long bcActionid) {
        this.bcActionid = bcActionid;
    }

    public String getBcActiontype() {
        return bcActiontype;
    }

    public void setBcActiontype(String bcActiontype) {
        this.bcActiontype = bcActiontype == null ? null : bcActiontype.trim();
    }

    public String getBcDeviceid() {
        return bcDeviceid;
    }

    public void setBcDeviceid(String bcDeviceid) {
        this.bcDeviceid = bcDeviceid == null ? null : bcDeviceid.trim();
    }

    public String getBcTimestamp() {
        return bcTimestamp;
    }

    public void setBcTimestamp(String bcTimestamp) {
        this.bcTimestamp = bcTimestamp == null ? null : bcTimestamp.trim();
    }

    public String getBcEnddate() {
        return bcEnddate;
    }

    public void setBcEnddate(String bcEnddate) {
        this.bcEnddate = bcEnddate == null ? null : bcEnddate.trim();
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

    public String getBcRecordtime() {
        return bcRecordtime;
    }

    public void setBcRecordtime(String bcRecordtime) {
        this.bcRecordtime = bcRecordtime == null ? null : bcRecordtime.trim();
    }

    public Integer getBcWaterintake() {
        return bcWaterintake;
    }

    public void setBcWaterintake(Integer bcWaterintake) {
        this.bcWaterintake = bcWaterintake;
    }
}