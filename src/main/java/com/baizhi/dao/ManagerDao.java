package com.baizhi.dao;

import com.baizhi.entity.Manager;
import org.apache.ibatis.annotations.Param;

import java.util.List;
public interface ManagerDao {
    //登录查询
    Manager query(@Param("username")String username,@Param("password")String password);
    //查询所有
    List<Manager> queryAll();

    //添加
    void insert(Manager manager);

    //删除
    void delete(Integer id);

    //修改
    void update(Manager manager);

    //分页查询
    List<Manager> queryBypage(@Param("beginIndex") Integer beginIndex, @Param("rows") Integer rows);

    //查询一个
    Manager queryByid(Integer id);

    //模糊查询
    List<Manager> queryByname(String username);

    //批量删除
    void deletes(@Param("ids") int[] ids);
}
