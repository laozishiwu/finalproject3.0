package com.baizhi.service;

import com.baizhi.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {
    //查询一个
    User queryByid(Integer id);

    //查询所有
    List<User> queryAll();

    //分页查询所有
    List<User> queryBypage(@Param("page") Integer page, @Param("rows") Integer rows);

    //模糊查询name
    List<User> queryLikename(String dhamaname);

    //修改
    void update(User user);

    //删除
    void delete(Integer id);
}
