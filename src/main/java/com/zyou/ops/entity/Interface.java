package com.zyou.ops.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Interface implements Serializable {
    public Integer getIt_id() {
        return it_id;
    }

    public void setIt_id(Integer it_id) {
        this.it_id = it_id;
    }

    public String getIt_address() {
        return it_address;
    }

    public void setIt_address(String it_address) {
        this.it_address = it_address;
    }

    public String getIt_detail() {
        return it_detail;
    }

    public void setIt_detail(String it_detail) {
        this.it_detail = it_detail;
    }

    public Date getIt_create_time() {
        return it_create_time;
    }

    public void setIt_create_time(Date it_create_time) {
        this.it_create_time = it_create_time;
    }

    public Date getIt_update_time() {
        return it_update_time;
    }

    public void setIt_update_time(Date it_update_time) {
        this.it_update_time = it_update_time;
    }

    private Integer it_id;

    private String it_address;

    public Integer getIt_port() {
        return it_port;
    }

    public void setIt_port(Integer it_port) {
        this.it_port = it_port;
    }

    private Integer it_port;

    private String it_detail;


    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date it_create_time;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date it_update_time;


}