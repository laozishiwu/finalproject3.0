package com.baizhi.service;

import com.baizhi.entity.Log;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LogService {
    //添加
    void insert(Log log);

    //分页查询所有
    List<Log> queryBypage(@Param("page") Integer page, @Param("rows") Integer rows);

    //查询数量
    Integer queryCounts();
}
