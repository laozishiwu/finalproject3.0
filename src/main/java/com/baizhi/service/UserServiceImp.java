package com.baizhi.service;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import com.baizhi.log.LogAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User queryByid(Integer id) {
        User user = userDao.queryByid(id);
        return user;
    }

    @Override
    public List<User> queryAll() {
        List<User> users = userDao.queryAll();
        for (User userlist : users) {
            System.out.println("来自业务层的查询所有测试：" + userlist);
        }
        return users;
    }

    @Override
    public List<User> queryBypage(Integer page, Integer rows) {
        int beginIndex = (page - 1) * rows;
        List<User> users = userDao.queryBypage(beginIndex, rows);
        for (User userlist : users) {
            System.out.println("来自业务层的分页查询所有测试：" + userlist);
        }
        return users;
    }

    @Override
    public List<User> queryLikename(String dhamaname) {
        List<User> users = userDao.queryLikename(dhamaname);
        for (User userlist : users) {
            System.out.println("来自业务层的模糊查询所有测试：" + userlist);
        }
        return users;
    }

    @Override
    @LogAnnotation(name = "修改用户信息")
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    @LogAnnotation(name = "删除用户信息")
    public void delete(Integer id) {
        userDao.delete(id);
    }
}
