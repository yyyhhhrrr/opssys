package com.zyou.ops.entity;

import java.io.Serializable;

public class StudentTask implements Serializable {
    private Integer st_id;

    private Integer st_type;

    private Integer st_class_type;

    private String st_name;

    private String st_content;

    public Integer getSt_id() {
        return st_id;
    }

    public void setSt_id(Integer st_id) {
        this.st_id = st_id;
    }

    public Integer getSt_type() {
        return st_type;
    }

    public void setSt_type(Integer st_type) {
        this.st_type = st_type;
    }

    public Integer getSt_class_type() {
        return st_class_type;
    }

    public void setSt_class_type(Integer st_class_type) {
        this.st_class_type = st_class_type;
    }

    public String getSt_name() {
        return st_name;
    }

    public void setSt_name(String st_name) {
        this.st_name = st_name==null? null:st_name.trim();
    }

    public String getSt_content() {
        return st_content;
    }

    public void setSt_content(String st_content) {
        this.st_content = st_content==null?null:st_content.trim();
    }

    @Override
    public String toString() {
        return "StudentTask{" +
                "st_id=" + st_id +
                ", st_type=" + st_type +
                ", st_class_type=" + st_class_type +
                ", st_name='" + st_name + '\'' +
                ", st_content='" + st_content + '\'' +
                '}';
    }
}