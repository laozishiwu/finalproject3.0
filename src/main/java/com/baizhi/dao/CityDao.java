package com.baizhi.dao;

import com.baizhi.entity.City;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CityDao {
    //添加
    void insertCity(City city);

    //删除
    void deleteCity(Integer id);

    //修改
    void updateCity(City city);

    //查询一个-----id
    City queryCity(Integer id);

    //查询一个-----name
    City queryCityByname(String name);

    //查询所有
    List<City> queryAll();

    //根据名字模糊查询name
    City queryLikename(String name);

    //查询某工资区间的员工
    //List<City> querySalaries(@Param("downSalary")Integer downSalary,@Param("upSalary")Integer upSalary);
    //批量删除
    void deleteBachAcc(@Param("ids") int[] ids);

    //分页查询
    List<City> queryBypage(@Param("beginIndex") Integer beginIndex, @Param("pageSize") Integer pageSize);
}
