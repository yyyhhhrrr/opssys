package com.zyou.ops.entity;

import java.io.Serializable;
import java.util.Date;

public class SShMessage implements Serializable {
    private Integer ssh_id;

    private Integer ssh_ip_id;

    private String ssh_username;

    private String ssh_pwd;

    private Date ssh_create_time;

    private Date ssh_update_time;

    private ServerIp serverIp;

    public ServerIp getServerIp() {
        return serverIp;
    }

    public void setServerIp(ServerIp serverIp) {
        this.serverIp = serverIp;
    }

    public Integer getSsh_id() {
        return ssh_id;
    }

    public void setSsh_id(Integer ssh_id) {
        this.ssh_id = ssh_id;
    }

    public Integer getSsh_ip_id() {
        return ssh_ip_id;
    }

    public void setSsh_ip_id(Integer ssh_ip_id) {
        this.ssh_ip_id = ssh_ip_id;
    }

    public String getSsh_username() {
        return ssh_username;
    }

    public void setSsh_username(String ssh_username) {
        this.ssh_username = ssh_username;
    }

    public String getSsh_pwd() {
        return ssh_pwd;
    }

    public void setSsh_pwd(String ssh_pwd) {
        this.ssh_pwd = ssh_pwd;
    }

    public Date getSsh_create_time() {
        return ssh_create_time;
    }

    public void setSsh_create_time(Date ssh_create_time) {
        this.ssh_create_time = ssh_create_time;
    }

    public Date getSsh_update_time() {
        return ssh_update_time;
    }

    public void setSsh_update_time(Date ssh_update_time) {
        this.ssh_update_time = ssh_update_time;
    }

    @Override
    public String toString() {
        return "SShMessage{" +
                "ssh_id=" + ssh_id +
                ", ssh_ip_id=" + ssh_ip_id +
                ", ssh_username='" + ssh_username + '\'' +
                ", ssh_pwd='" + ssh_pwd + '\'' +
                ", ssh_create_time=" + ssh_create_time +
                ", ssh_update_time=" + ssh_update_time +
                '}';
    }
}