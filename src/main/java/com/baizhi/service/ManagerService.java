package com.baizhi.service;

import com.baizhi.entity.Manager;
import org.apache.ibatis.annotations.Param;

import java.util.List;
public interface ManagerService {
    //登录查询
    Manager query(String username,String password);
    //查询所有
    List<Manager> queryAll();

    //添加
    void insert(Manager manager);

    void delete(Integer id);

    //修改
    void update(Manager manager);

    //分页查询
    List<Manager> queryBypage(@Param("page") Integer page, @Param("rows") Integer rows);

    //查询一个
    Manager queryByid(Integer id);

    //模糊查询
    List<Manager> queryByname(String username);

    //批量删除
    void deletes(int[] ids);
}
