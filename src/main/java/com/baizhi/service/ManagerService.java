package com.baizhi.service;

import com.baizhi.entity.Manager;

import java.util.List;
public interface ManagerService {
    //登录查询
    Manager query(String username,String password);
    //查询所有
    List<Manager> queryAll();
}
