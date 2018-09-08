package com.baizhi.dao;

import com.baizhi.entity.Chapter;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ChapterDao {
    //添加
    void insert(Chapter chapter);

    //删除
    void delete(Integer id);

    //查询一个
    Chapter query(Integer id);

    //查询所有
    List<Chapter> queryAll();

    //分页查询
    List<Chapter> queryBypage(@Param("beginIndex") Integer beginIndex, @Param("rows") Integer rows);
}
