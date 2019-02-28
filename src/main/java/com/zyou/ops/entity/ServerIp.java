package com.zyou.ops.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


public class ServerIp implements Serializable {
    public Integer getSv_id() {
        return sv_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServerIp serverIp = (ServerIp) o;
        return Objects.equals(sv_id, serverIp.sv_id) &&
                Objects.equals(sv_ip, serverIp.sv_ip) &&
                Objects.equals(sv_ip_private, serverIp.sv_ip_private) &&
                Objects.equals(sv_os, serverIp.sv_os) &&
                Objects.equals(sv_cpu, serverIp.sv_cpu) &&
                Objects.equals(sv_memory, serverIp.sv_memory) &&
                Objects.equals(sv_disk, serverIp.sv_disk) &&
                Objects.equals(sv_bandwidth, serverIp.sv_bandwidth) &&
                Objects.equals(sv_detail, serverIp.sv_detail) &&
                Objects.equals(sv_create_time, serverIp.sv_create_time) &&
                Objects.equals(sv_update_time, serverIp.sv_update_time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sv_id, sv_ip, sv_ip_private, sv_os, sv_cpu, sv_memory, sv_disk, sv_bandwidth, sv_detail, sv_create_time, sv_update_time);
    }

    public void setSv_id(Integer sv_id) {
        this.sv_id = sv_id;
    }

    public String getSv_ip() {
        return sv_ip;
    }

    public void setSv_ip(String sv_ip) {
        this.sv_ip = sv_ip;
    }

    public String getSv_ip_private() {
        return sv_ip_private;
    }

    public void setSv_ip_private(String sv_ip_private) {
        this.sv_ip_private = sv_ip_private;
    }

    public String getSv_os() {
        return sv_os;
    }

    public void setSv_os(String sv_os) {
        this.sv_os = sv_os;
    }

    public String getSv_cpu() {
        return sv_cpu;
    }

    public void setSv_cpu(String sv_cpu) {
        this.sv_cpu = sv_cpu;
    }

    public String getSv_memory() {
        return sv_memory;
    }

    public void setSv_memory(String sv_memory) {
        this.sv_memory = sv_memory;
    }

    public String getSv_disk() {
        return sv_disk;
    }

    public void setSv_disk(String sv_disk) {
        this.sv_disk = sv_disk;
    }

    public String getSv_bandwidth() {
        return sv_bandwidth;
    }

    public void setSv_bandwidth(String sv_bandwidth) {
        this.sv_bandwidth = sv_bandwidth;
    }

    public String getSv_detail() {
        return sv_detail;
    }

    public void setSv_detail(String sv_detail) {
        this.sv_detail = sv_detail;
    }

    public Date getSv_create_time() {
        return sv_create_time;
    }

    public void setSv_create_time(Date sv_create_time) {
        this.sv_create_time = sv_create_time;
    }

    public Date getSv_update_time() {
        return sv_update_time;
    }

    public void setSv_update_time(Date sv_update_time) {
        this.sv_update_time = sv_update_time;
    }

    private Integer sv_id; // id

    private String sv_ip; // 服务器外网Ip

    private String sv_ip_private; // 服务器内网Ip

    private String sv_os; // 操作系统

    private String sv_cpu; // CPU信息

    private String sv_memory; // 内存信息

    private String sv_disk; // 磁盘信息

    private String sv_bandwidth; // 带宽

    private String sv_detail; // 详细描述
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date sv_create_time; // 创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date sv_update_time; // 更新时回




}