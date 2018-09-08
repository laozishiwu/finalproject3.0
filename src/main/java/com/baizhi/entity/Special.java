package com.baizhi.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Special implements Serializable {
    private Integer id;
    private String title;
    private Integer count;
    private String coverImg;
    private Integer score;
    private String author;
    private String broadCast;
    private String brief;
    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date creattime;
    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date publishtime;
    private String status;
    private List<Chapter> children;

    @Override
    public String toString() {
        return "Special{" + "id=" + id + ", title='" + title + '\'' + ", count=" + count + ", coverImg='" + coverImg + '\'' + ", score=" + score + ", author='" + author + '\'' + ", broadCast='" + broadCast + '\'' + ", brief='" + brief + '\'' + ", creattime=" + creattime + ", publishtime=" + publishtime + ", status='" + status + '\'' + ", children=" + children + '}';
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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBroadCast() {
        return broadCast;
    }

    public void setBroadCast(String broadCast) {
        this.broadCast = broadCast;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public Date getCreattime() {
        return creattime;
    }

    public void setCreattime(Date creattime) {
        this.creattime = creattime;
    }

    public Date getPublishtime() {
        return publishtime;
    }

    public void setPublishtime(Date publishtime) {
        this.publishtime = publishtime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Chapter> getChildren() {
        return children;
    }

    public void setChildren(List<Chapter> children) {
        this.children = children;
    }

    public Special(Integer id, String title, Integer count, String coverImg, Integer score, String author, String broadCast, String brief, Date creattime, Date publishtime, String status, List<Chapter> children) {
        this.id = id;
        this.title = title;
        this.count = count;
        this.coverImg = coverImg;
        this.score = score;
        this.author = author;
        this.broadCast = broadCast;
        this.brief = brief;
        this.creattime = creattime;
        this.publishtime = publishtime;
        this.status = status;
        this.children = children;
    }

    public Special() {
    }
}
