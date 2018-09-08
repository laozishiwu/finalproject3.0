package com.baizhi.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Article implements Serializable {
    private Integer id;
    private String title;
    private String img;
    private String content;
    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date publishtime;
    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createtime;
    private String status;
    private Master master;

    @Override
    public String toString() {
        return "Article{" + "id=" + id + ", title='" + title + '\'' + ", img='" + img + '\'' + ", content='" + content + '\'' + ", publishtime=" + publishtime + ", createtime=" + createtime + ", status='" + status + '\'' + ", master=" + master + '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPublishtime() {
        return publishtime;
    }

    public void setPublishtime(Date publishtime) {
        this.publishtime = publishtime;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Master getMaster() {
        return master;
    }

    public void setMaster(Master master) {
        this.master = master;
    }

    public Article(Integer id, String title, String img, String content, Date publishtime, Date createtime, String status, Master master) {
        this.id = id;
        this.title = title;
        this.img = img;
        this.content = content;
        this.publishtime = publishtime;
        this.createtime = createtime;
        this.status = status;
        this.master = master;
    }

    public Article() {
    }
}
