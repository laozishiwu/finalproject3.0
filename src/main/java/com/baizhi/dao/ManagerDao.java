package com.baizhi.dao;

import com.baizhi.entity.Manager;
import org.apache.ibatis.annotations.Param;

import java.util.List;
public interface ManagerDao {
    //登录查询
    Manager query(@Param("username")String username,@Param("password")String password);
    //查询所有
    List<Manager> queryAll();
}
