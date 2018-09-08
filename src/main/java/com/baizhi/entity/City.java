package com.baizhi.entity;

import java.io.Serializable;

public class City implements Serializable {
    private Integer id;//number(6) primary key,
    private String name;// varchar(50) not null,
    private String url;// varchar(60) null,
    private String leaf;// char(1) not null,
    private Integer parentId;// number(6),

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLeaf() {
        return leaf;
    }

    public void setLeaf(String leaf) {
        this.leaf = leaf;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return "City [id=" + id + ", name=" + name + ", url=" + url + ", leaf=" + leaf + ", parentId=" + parentId + "]";
    }

    public City(Integer id, String name, String url, String leaf, Integer parentId) {
        super();
        this.id = id;
        this.name = name;
        this.url = url;
        this.leaf = leaf;
        this.parentId = parentId;
    }

    public City() {
        super();
        // TODO Auto-generated constructor stub
    }

}
