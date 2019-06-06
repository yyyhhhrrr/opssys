package com.zyou.ops.zybd.entity.biz;

import java.util.Date;

public class UserTask {
    private Long bu_id;

    private String bu_type;

    private String bu_name;

    private Long bu_modelId;

    private Integer bu_gold;

    private String bu_content;

    private Integer bu_taskSource;

    private Long bu_classId;

    private Long bu_sender;

    private Date bu_endDate;

    private Boolean bu_isDel;

    private Date bu_createDate;

    private Date bu_updateDate;

    private String bu_reserved1;

    private String bu_reserved2;

    private Long bu_studentId;

    private Integer bu_grade;

    private Integer bu_day;

    private String bu_taskURL;

    public Long getBu_id() {
        return bu_id;
    }

    public void setBu_id(Long bu_id) {
        this.bu_id = bu_id;
    }

    public String getBu_type() {
        return bu_type;
    }

    public void setBu_type(String bu_type) {
        this.bu_type = bu_type;
    }

    public String getBu_name() {
        return bu_name;
    }

    public void setBu_name(String bu_name) {
        this.bu_name = bu_name;
    }

    public Long getBu_modelId() {
        return bu_modelId;
    }

    public void setBu_modelId(Long bu_modelId) {
        this.bu_modelId = bu_modelId;
    }

    public Integer getBu_gold() {
        return bu_gold;
    }

    public void setBu_gold(Integer bu_gold) {
        this.bu_gold = bu_gold;
    }

    public String getBu_content() {
        return bu_content;
    }

    public void setBu_content(String bu_content) {
        this.bu_content = bu_content;
    }

    public Integer getBu_taskSource() {
        return bu_taskSource;
    }

    public void setBu_taskSource(Integer bu_taskSource) {
        this.bu_taskSource = bu_taskSource;
    }

    public Long getBu_classId() {
        return bu_classId;
    }

    public void setBu_classId(Long bu_classId) {
        this.bu_classId = bu_classId;
    }

    public Long getBu_sender() {
        return bu_sender;
    }

    public void setBu_sender(Long bu_sender) {
        this.bu_sender = bu_sender;
    }

    public Date getBu_endDate() {
        return bu_endDate;
    }

    public void setBu_endDate(Date bu_endDate) {
        this.bu_endDate = bu_endDate;
    }

    public Boolean getBu_isDel() {
        return bu_isDel;
    }

    public void setBu_isDel(Boolean bu_isDel) {
        this.bu_isDel = bu_isDel;
    }

    public Date getBu_createDate() {
        return bu_createDate;
    }

    public void setBu_createDate(Date bu_createDate) {
        this.bu_createDate = bu_createDate;
    }

    public Date getBu_updateDate() {
        return bu_updateDate;
    }

    public void setBu_updateDate(Date bu_updateDate) {
        this.bu_updateDate = bu_updateDate;
    }

    public String getBu_reserved1() {
        return bu_reserved1;
    }

    public void setBu_reserved1(String bu_reserved1) {
        this.bu_reserved1 = bu_reserved1;
    }

    public String getBu_reserved2() {
        return bu_reserved2;
    }

    public void setBu_reserved2(String bu_reserved2) {
        this.bu_reserved2 = bu_reserved2;
    }

    public Long getBu_studentId() {
        return bu_studentId;
    }

    public void setBu_studentId(Long bu_studentId) {
        this.bu_studentId = bu_studentId;
    }

    public Integer getBu_grade() {
        return bu_grade;
    }

    public void setBu_grade(Integer bu_grade) {
        this.bu_grade = bu_grade;
    }

    public Integer getBu_day() {
        return bu_day;
    }

    public void setBu_day(Integer bu_day) {
        this.bu_day = bu_day;
    }

    public String getBu_taskURL() {
        return bu_taskURL;
    }

    public void setBu_taskURL(String bu_taskURL) {
        this.bu_taskURL = bu_taskURL;
    }

    public UserTask() {
    }

    public UserTask(String bu_type, String bu_name, String bu_content, Integer bu_grade) {
        this.bu_type = bu_type;
        this.bu_name = bu_name;
        this.bu_content = bu_content;
        this.bu_grade = bu_grade;
    }
}