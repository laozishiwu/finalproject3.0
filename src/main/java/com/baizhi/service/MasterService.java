package com.baizhi.service;

import com.baizhi.entity.Master;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MasterService {
    //添加
    void insert(Master master);

    //删除
    void delete(Integer id);

    //查询所有
    List<Master> queryAll();

    //分页查询所有
    List<Master> queryBypage(@Param("page") Integer page, @Param("rows") Integer rows);

    //模糊查询
    List<Master> queryByname(@Param("name") String name);

    //批量删除
    void deletes(@Param("ids") int[] ids);
}
