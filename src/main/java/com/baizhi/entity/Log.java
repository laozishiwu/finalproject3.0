package com.baizhi.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Log implements Serializable {
    private Integer id;
    private String manager;
    private String content;
    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date operatetime;
    private String operatetype;

    public Log() {
    }

    @Override
    public String toString() {
        return "Log{" + "id=" + id + ", manager='" + manager + '\'' + ", content='" + content + '\'' + ", operatetime=" + operatetime + ", operatetype='" + operatetype + '\'' + '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getOperatetime() {
        return operatetime;
    }

    public void setOperatetime(Date operatetime) {
        this.operatetime = operatetime;
    }

    public String getOperatetype() {
        return operatetype;
    }

    public void setOperatetype(String operatetype) {
        this.operatetype = operatetype;
    }

    public Log(Integer id, String manager, String content, Date operatetime, String operatetype) {
        this.id = id;
        this.manager = manager;
        this.content = content;
        this.operatetime = operatetime;
        this.operatetype = operatetype;
    }
}
