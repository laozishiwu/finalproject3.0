package com.baizhi.service;

import com.baizhi.entity.SlideShow;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SlideShowService {
    //添加
    void insert(SlideShow slideShow);
    //删除
    void delete(Integer id);
    //修改（状态）
    void update(SlideShow slideShow);
    //查询所有（分页）
    List<SlideShow> queryBypage(@Param("page")Integer page, @Param("rows")Integer rows);

    List<SlideShow> queryAll();
}
