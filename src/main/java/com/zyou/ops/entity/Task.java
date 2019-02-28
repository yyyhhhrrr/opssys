package com.zyou.ops.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class Task implements Serializable {
    public Integer getTsk_id() {
        return tsk_id;
    }

    public void setTsk_id(Integer tsk_id) {
        this.tsk_id = tsk_id;
    }

    public Integer getTsk_ip_id() {
        return tsk_ip_id;
    }

    public void setTsk_ip_id(Integer tsk_ip_id) {
        this.tsk_ip_id = tsk_ip_id;
    }

    public Integer getTsk_it_id() {
        return tsk_it_id;
    }

    public void setTsk_it_id(Integer tsk_it_id) {
        this.tsk_it_id = tsk_it_id;
    }

    public String getTsk_pm_method() {
        return tsk_pm_method;
    }

    public void setTsk_pm_method(String tsk_pm_method) {
        this.tsk_pm_method = tsk_pm_method;
    }

    public String getTsk_pm_header() {
        return tsk_pm_header;
    }

    public void setTsk_pm_header(String tsk_pm_header) {
        this.tsk_pm_header = tsk_pm_header;
    }

    public String getTsk_pm_json() {
        return tsk_pm_json;
    }

    public void setTsk_pm_json(String tsk_pm_json) {
        this.tsk_pm_json = tsk_pm_json;
    }

    public String getTsk_pm_result() {
        return tsk_pm_result;
    }

    public void setTsk_pm_result(String tsk_pm_result) {
        this.tsk_pm_result = tsk_pm_result;
    }

    public Integer getTsk_time() {
        return tsk_time;
    }

    public void setTsk_time(Integer tsk_time) {
        this.tsk_time = tsk_time;
    }

    public String getTsk_detail() {
        return tsk_detail;
    }

    public void setTsk_detail(String tsk_detail) {
        this.tsk_detail = tsk_detail;
    }

    public Date getTsk_create_time() {
        return tsk_create_time;
    }

    public void setTsk_create_time(Date tsk_create_time) {
        this.tsk_create_time = tsk_create_time;
    }

    public Date getTsk_update_time() {
        return tsk_update_time;
    }

    public void setTsk_update_time(Date tsk_update_time) {
        this.tsk_update_time = tsk_update_time;
    }

    private Integer tsk_id;

    private Integer tsk_ip_id;

    private Integer tsk_it_id;

    private String tsk_pm_method;

    private String tsk_pm_header;

    private String tsk_pm_json;

    private String tsk_pm_result;

    private Integer tsk_time;

    private String tsk_detail;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date tsk_create_time;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date tsk_update_time;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    private Boolean status;

    private ServerIp serverIp;

    public ServerIp getServerIp() {
        return serverIp;
    }

    public void setServerIp(ServerIp serverIp) {
        this.serverIp = serverIp;
    }

    public Interface getAnInterface() {
        return anInterface;
    }

    public void setAnInterface(Interface anInterface) {
        this.anInterface = anInterface;
    }

    private Interface anInterface;


}