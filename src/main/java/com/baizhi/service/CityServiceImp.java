package com.baizhi.service;

import com.baizhi.dao.CityDao;
import com.baizhi.entity.City;
import com.baizhi.log.LogAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CityServiceImp implements CityService {
    @Autowired
    private CityDao cityDao;

    //添加
    @Override
    @LogAnnotation(name = "添加城市信息！")
    @Transactional(propagation = Propagation.REQUIRED)
    public void addCity(City city) {
        cityDao.insertCity(city);
    }

    //删除
    @Override
    @LogAnnotation(name = "删除城市信息！")
    @Transactional(propagation = Propagation.REQUIRED)
    public void removeCity(Integer id) {
        cityDao.deleteCity(id);
    }

    //修改
    @Override
    @LogAnnotation(name = "修改城市信息！")
    @Transactional(propagation = Propagation.REQUIRED)
    public void modifyCity(City employee) {
        cityDao.updateCity(employee);
    }

    //查询一个
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public City findCity(Integer id) {
        City employee = cityDao.queryCity(id);
        return employee;
    }

    //查询所有
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<City> findAll() {
        List<City> emp = cityDao.queryAll();
        for (City employee : emp) {
            System.out.println(employee);
        }
        return emp;
    }

    //name
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public City findLikename(String name) {
        City emp = cityDao.queryLikename(name);
        System.out.println(emp);
        return emp;
    }

    //分页查询
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<City> findBypage(Integer currentPage, Integer pageSize) {
        pageSize = 365;
        if (currentPage == null) {
            currentPage = 1;
            System.out.println("&&&&&&&&&&&&&&&&&&&&&&" + currentPage);
        }
        System.out.println(currentPage + "*************" + pageSize);
        Integer beginIndex = (currentPage - 1) * pageSize;
        System.out.println(beginIndex + "&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        List<City> emp = cityDao.queryBypage(beginIndex, pageSize);
        for (City employee : emp) {
            System.out.println(employee);
        }
        return emp;
    }

    //批量删除
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void removeBachAcc(int[] ids) {
        cityDao.deleteBachAcc(ids);
    }

    //查询一个-----name
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public City findCityByname(String name) {
        City emp = cityDao.queryCityByname(name);
        return emp;
    }

}
