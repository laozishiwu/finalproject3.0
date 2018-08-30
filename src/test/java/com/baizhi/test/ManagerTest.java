package com.baizhi.test;

import com.baizhi.entity.Manager;
import com.baizhi.service.ManagerService;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

public class ManagerTest extends BaseTest {
    @Resource
    private ManagerService managerService;
    @Test
    public void TestQueryOne(){
       Manager manager= managerService.query("八戒","123456");
       System.out.println(manager);
    }
    @Test
    public void TestQieryAll(){
        List<Manager> list=managerService.queryAll();
        for (Manager mna : list) {
            System.out.println(mna);
        }
    }
}
