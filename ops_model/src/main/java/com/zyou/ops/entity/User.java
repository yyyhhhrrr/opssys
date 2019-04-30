package com.zyou.ops.entity;




import java.io.Serializable;


public class User implements Serializable {


    public Integer getUs_id() {
        return us_id;
    }

    public void setUs_id(Integer us_id) {
        this.us_id = us_id;
    }

    public String getUs_username() {
        return us_username;
    }

    public void setUs_username(String us_username) {
        this.us_username = us_username;
    }

    public String getUs_password() {
        return us_password;
    }

    public void setUs_password(String us_password) {
        this.us_password = us_password;
    }

    private Integer us_id;

    private String us_username;

    private String us_password;

    @Override
    public String toString() {
        return "User{" +
                "us_id=" + us_id +
                ", us_username='" + us_username + '\'' +
                ", us_password='" + us_password + '\'' +
                '}';
    }
}