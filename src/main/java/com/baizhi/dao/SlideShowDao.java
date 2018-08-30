package com.baizhi.dao;

import com.baizhi.entity.SlideShow;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SlideShowDao {
    //添加
    void insert(SlideShow slideShow);
    //删除
    void delete(Integer id);
    //修改（状态）
    void update(SlideShow slideShow);
    //查询所有
    List<SlideShow> queryAll();
    //查询所有（分页）
    List<SlideShow> queryBypage(@Param("beginIndex")Integer beginIndex,@Param("rows")Integer rows);
}
