package com.baizhi.test;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class UserTest extends BaseTest {
    @Autowired
    private UserService userService;

    @Test
    public void testQueryByid() {
        User user = userService.queryByid(1);
        System.out.println(user);
    }

    @Test
    public void testQueryBypage() {
        List<User> user = userService.queryBypage(1, 6);
        for (User userlist : user) {
            System.out.println(userlist);
        }
    }

    @Test
    public void testQueryLikename() {
        List<User> user = userService.queryLikename("虚竹");
        for (User userlist : user) {
            System.out.println(userlist);
        }
    }

    @Test
    public void testQueryAll() {
        List<User> user = userService.queryAll();
        for (User userlist : user) {
            System.out.println(userlist);
        }
    }

    @Test
    public void testupdate() {
        User user = new User(1, "虚竹子", "虚竹子上师", "/img/car01.jpg", "男", "少林寺", "放下屠刀立地成佛！", "123456", "123457", "null", "on", new Date());
        userService.update(user);

    }
}
