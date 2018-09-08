package com.baizhi.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class SlideShow implements Serializable {
    private Integer id;
    private String title;
    private String imgPath;
    private String content;
    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date upTime;
    private String status;

    @Override
    public String toString() {
        return "slideShow{" + "id=" + id + ", title='" + title + '\'' + ", imgPath='" + imgPath + '\'' + ", content='" + content + '\'' + ", upTime=" + upTime + ", status='" + status + '\'' + '}';
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

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getUpTime() {
        return upTime;
    }

    public void setUpTime(Date upTime) {
        this.upTime = upTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public SlideShow(Integer id, String title, String imgPath, String content, Date upTime, String status) {
        this.id = id;
        this.title = title;
        this.imgPath = imgPath;
        this.content = content;
        this.upTime = upTime;
        this.status = status;
    }

    public SlideShow() {
    }

    public void setId(String uuid) {
    }
}
