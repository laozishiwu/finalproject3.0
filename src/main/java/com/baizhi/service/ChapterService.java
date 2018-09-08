package com.baizhi.service;

import com.baizhi.entity.Chapter;

import java.util.List;

public interface ChapterService {
    //添加
    void insert(Chapter chapter);

    //删除
    void delete(Integer id);

    //查询一个
    Chapter query(Integer id);

    //查询所有
    List<Chapter> queryAll();

    //分页查询
    List<Chapter> queryBypage(Integer page, Integer rows);
}
