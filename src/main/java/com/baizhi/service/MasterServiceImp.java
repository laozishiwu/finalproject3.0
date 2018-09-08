package com.baizhi.service;

import com.baizhi.dao.MasterDao;
import com.baizhi.entity.Master;
import com.baizhi.log.LogAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MasterServiceImp implements MasterService {
    @Autowired
    private MasterDao masterDao;

    @Override
    @LogAnnotation(name = "添加大师信息")
    public void insert(Master master) {
        masterDao.insert(master);
    }

    @Override
    @LogAnnotation(name = "删除大师")
    public void delete(Integer id) {
        masterDao.delete(id);
    }

    @Override
    public List<Master> queryAll() {
        List<Master> masters = masterDao.queryAll();
        for (Master masterlist : masters) {
            System.out.println("来自service查询所有的测试" + masterlist);
        }
        return masters;
    }

    @Override
    public List<Master> queryBypage(Integer page, Integer rows) {
        int beginIndex = (page - 1) * rows;
        List<Master> masters = masterDao.queryBypage(beginIndex, rows);
        for (Master masterlist : masters) {
            System.out.println("service分页查询的测试" + masterlist);
        }
        return masters;
    }

    @Override
    public List<Master> queryByname(String name) {
        List<Master> masters = masterDao.queryByname(name);
        for (Master masterlist : masters) {
            System.out.println("service模糊查询的测试：" + masterlist);
        }
        return masters;
    }

    @Override
    public void deletes(int[] ids) {
        masterDao.deletes(ids);
    }
}
