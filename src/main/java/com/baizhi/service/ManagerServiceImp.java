package com.baizhi.service;

import com.baizhi.dao.ManagerDao;
import com.baizhi.entity.Manager;
import com.baizhi.log.LogAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.jws.WebService;
import java.util.List;
@Transactional
@Service
@WebService
public class ManagerServiceImp implements ManagerService{
    @Autowired
    private ManagerDao managerDao;
    @Override
    @LogAnnotation(name = "管理者的登录行为")
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

    @Override
    @LogAnnotation(name = "注册行为！")
    public void insert(Manager manager) {
        managerDao.insert(manager);
    }

    @Override
    public void delete(Integer id) {
        managerDao.delete(id);
    }

    @Override
    public void update(Manager manager) {
        managerDao.update(manager);
    }

    @Override
    public List<Manager> queryBypage(Integer page, Integer rows) {
        int beginIndex = (page - 1) * rows;
        List<Manager> managers = managerDao.queryBypage(beginIndex, rows);
        for (Manager managerlist : managers) {
            System.out.println("来自业务层对管理者分页查询的测试：" + managerlist);
        }
        return managers;
    }

    @Override
    public Manager queryByid(Integer id) {
        Manager manager = managerDao.queryByid(id);
        return manager;
    }

    @Override
    public List<Manager> queryByname(String username) {
        List<Manager> managers = managerDao.queryByname(username);
        for (Manager managerlist : managers) {
            System.out.println("来自业务层对管理者模糊查询的测试：" + managerlist);
        }
        return managers;
    }

    @Override
    public void deletes(int[] ids) {
        managerDao.deletes(ids);
    }
}
