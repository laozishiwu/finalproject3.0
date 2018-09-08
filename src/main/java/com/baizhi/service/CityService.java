package com.baizhi.service;

import com.baizhi.entity.City;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CityService {
    //添加
    void addCity(City city);

    //删除
    void removeCity(Integer id);

    //修改
    void modifyCity(City city);

    //查询一个-----id
    City findCity(Integer id);

    //查询一个-----name
    City findCityByname(String name);

    //查询所有
    List<City> findAll();

    //根据名字模糊查询name
    City findLikename(String name);

    //查询某工资区间的员工
    //List<City> querySalaries(@Param("downSalary")Integer downSalary,@Param("upSalary")Integer upSalary);
    //批量删除
    void removeBachAcc(@Param("ids") int[] ids);

    //分页查询
    List<City> findBypage(@Param("beginIndex") Integer beginIndex, @Param("pageSize") Integer pageSize);
}
