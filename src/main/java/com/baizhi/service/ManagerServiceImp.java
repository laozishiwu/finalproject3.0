package com.baizhi.service;

import com.baizhi.dao.ManagerDao;
import com.baizhi.entity.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Transactional
@Service
public class ManagerServiceImp implements ManagerService{
    @Autowired
    private ManagerDao managerDao;
    @Override
    public Manager query(String username, String password) {
        Manager m=managerDao.query(username,password);
        return m;
    }

    @Override
    public List<Manager> queryAll() {
        List<Manager> list=managerDao.queryAll();
        for (Manager m:list) {
            System.out.println(m);
        }
        return list;
    }
}
