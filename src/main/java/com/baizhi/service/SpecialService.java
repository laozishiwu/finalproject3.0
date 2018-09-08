package com.baizhi.service;

import com.baizhi.entity.Special;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SpecialService {
    //添加
    void insert(Special special);

    //删除
    void delete(Integer id);

    //修改
    void update(Special special);

    //查询一个
    Special query(Integer id);

    //查询所有
    List<Special> queryAll();

    //分页查询
    List<Special> queryBypage(@Param("page") Integer page, @Param("rows") Integer rows);
}