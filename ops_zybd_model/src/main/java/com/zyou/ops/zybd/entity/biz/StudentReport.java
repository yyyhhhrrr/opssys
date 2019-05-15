package com.zyou.ops.zybd.entity.biz;

import java.io.Serializable;
import java.util.Date;

public class StudentReport implements Serializable {
    private Integer ssId;

    private String ssDate;

    private String ssCompanyid;

    private String ssCompanyname;

    private Integer ssClassid;

    private String ssClassname;

    private String ssStudentid;

    private String ssStudentname;

    private Integer ssGoodmood;

    private Integer ssBadmood;

    private Integer ssWater;

    private Integer ssDinner;

    private Integer ssSleep;

    private Integer ssWash;

    private Integer ssShit;

    private Integer ssUrine;

    private Integer ssLeave;

    private Date ssCreateDate;

    public Integer getSsId() {
        return ssId;
    }

    public void setSsId(Integer ssId) {
        this.ssId = ssId;
    }

    public String getSsDate() {
        return ssDate;
    }

    public void setSsDate(String ssDate) {
        this.ssDate = ssDate == null ? null : ssDate.trim();
    }

    public String getSsCompanyid() {
        return ssCompanyid;
    }

    public void setSsCompanyid(String ssCompanyid) {
        this.ssCompanyid = ssCompanyid == null ? null : ssCompanyid.trim();
    }

    public String getSsCompanyname() {
        return ssCompanyname;
    }

    public void setSsCompanyname(String ssCompanyname) {
        this.ssCompanyname = ssCompanyname == null ? null : ssCompanyname.trim();
    }

    public Integer getSsClassid() {
        return ssClassid;
    }

    public void setSsClassid(Integer ssClassid) {
        this.ssClassid = ssClassid;
    }

    public String getSsClassname() {
        return ssClassname;
    }

    public void setSsClassname(String ssClassname) {
        this.ssClassname = ssClassname == null ? null : ssClassname.trim();
    }

    public String getSsStudentid() {
        return ssStudentid;
    }

    public void setSsStudentid(String ssStudentid) {
        this.ssStudentid = ssStudentid == null ? null : ssStudentid.trim();
    }

    public String getSsStudentname() {
        return ssStudentname;
    }

    public void setSsStudentname(String ssStudentname) {
        this.ssStudentname = ssStudentname == null ? null : ssStudentname.trim();
    }

    public Integer getSsGoodmood() {
        return ssGoodmood;
    }

    public void setSsGoodmood(Integer ssGoodmood) {
        this.ssGoodmood = ssGoodmood;
    }

    public Integer getSsBadmood() {
        return ssBadmood;
    }

    public void setSsBadmood(Integer ssBadmood) {
        this.ssBadmood = ssBadmood;
    }

    public Integer getSsWater() {
        return ssWater;
    }

    public void setSsWater(Integer ssWater) {
        this.ssWater = ssWater;
    }

    public Integer getSsDinner() {
        return ssDinner;
    }

    public void setSsDinner(Integer ssDinner) {
        this.ssDinner = ssDinner;
    }

    public Integer getSsSleep() {
        return ssSleep;
    }

    public void setSsSleep(Integer ssSleep) {
        this.ssSleep = ssSleep;
    }

    public Integer getSsWash() {
        return ssWash;
    }

    public void setSsWash(Integer ssWash) {
        this.ssWash = ssWash;
    }

    public Integer getSsShit() {
        return ssShit;
    }

    public void setSsShit(Integer ssShit) {
        this.ssShit = ssShit;
    }

    public Integer getSsUrine() {
        return ssUrine;
    }

    public void setSsUrine(Integer ssUrine) {
        this.ssUrine = ssUrine;
    }

    public Integer getSsLeave() {
        return ssLeave;
    }

    public void setSsLeave(Integer ssLeave) {
        this.ssLeave = ssLeave;
    }

    public Date getSsCreateDate() {
        return ssCreateDate;
    }

    public void setSsCreateDate(Date ssCreateDate) {
        this.ssCreateDate = ssCreateDate;
    }
}