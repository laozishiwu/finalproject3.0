package com.baizhi.entity;

import java.io.Serializable;

public class Master implements Serializable {
    private Integer id;
    private String name;
    private String dharmaname;
    private String status;
    private String phone;
    private String photo;

    @Override
    public String toString() {
        return "Master{" + "id=" + id + ", name='" + name + '\'' + ", dharmaname='" + dharmaname + '\'' + ", status='" + status + '\'' + ", phone='" + phone + '\'' + ", photo='" + photo + '\'' + '}';
    }

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

    public String getDharmaname() {
        return dharmaname;
    }

    public void setDharmaname(String dharmaname) {
        this.dharmaname = dharmaname;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Master(Integer id, String name, String dharmaname, String status, String phone, String photo) {
        this.id = id;
        this.name = name;
        this.dharmaname = dharmaname;
        this.status = status;
        this.phone = phone;
        this.photo = photo;
    }

    public Master() {
    }
}
