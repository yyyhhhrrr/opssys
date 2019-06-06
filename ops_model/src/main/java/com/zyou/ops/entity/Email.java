package com.zyou.ops.entity;

import java.io.Serializable;
import java.util.List;

public class Email implements Serializable {
    private Integer email_id;

    private String email_address;

    private String email_username;

    private List<Task> taskList;

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

    public Integer getEmail_id() {
        return email_id;
    }

    public void setEmail_id(Integer email_id) {
        this.email_id = email_id;
    }

    public String getEmail_address() {
        return email_address;
    }

    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }

    public String getEmail_username() {
        return email_username;
    }

    public void setEmail_username(String email_username) {
        this.email_username = email_username;
    }

    @Override
    public String toString() {
        return "Email{" +
                "email_id=" + email_id +
                ", email_address='" + email_address + '\'' +
                ", email_username='" + email_username + '\'' +
                ", taskList=" + taskList +
                '}';
    }
}