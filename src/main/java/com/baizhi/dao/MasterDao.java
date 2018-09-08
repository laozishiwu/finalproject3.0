package com.baizhi.dao;

import com.baizhi.entity.Master;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MasterDao {
    //添加
    void insert(Master master);

    //删除
    void delete(Integer id);

    //查询所有
    List<Master> queryAll();

    //分页查询所有
    List<Master> queryBypage(@Param("beginIndex") Integer beginIndex, @Param("rows") Integer rows);

    //模糊查询
    List<Master> queryByname(@Param("name") String name);

    //批量删除
    void deletes(@Param("ids") int[] ids);
}
