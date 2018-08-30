package com.baizhi.entity;

import com.baizhi.annotation.ChinaName;

public class Manager {
    @ChinaName(name="编号")
    private Integer id;
    @ChinaName(name="用户宁")
    private String username;
    @ChinaName(name="密码")
    private String password;

    @Override
    public String toString() {
        return "Manager{" + "id=" + id + ", username='" + username + '\'' + ", password='" + password + '\'' + '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Manager() {
    }

    public Manager(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
}
