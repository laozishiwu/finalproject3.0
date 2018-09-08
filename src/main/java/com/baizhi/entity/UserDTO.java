package com.baizhi.entity;

import java.io.Serializable;

public class UserDTO implements Serializable {
    private Integer count;
    private Integer week;
    private String name;
    private Integer value;

    public UserDTO(String name, int value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return "UserDTO{" + "count=" + count + ", week=" + week + ", name='" + name + '\'' + ", value=" + value + '}';
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getWeek() {
        return week;
    }

    public void setWeek(Integer week) {
        this.week = week;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public UserDTO(Integer count, Integer week, String name, Integer value) {
        this.count = count;
        this.week = week;
        this.name = name;
        this.value = value;
    }

    public UserDTO() {
    }
}
