package com.baizhi.test;

import com.baizhi.entity.Manager;
import com.baizhi.service.ManagerService;
import org.junit.Test;

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
    public void TestQueryAll() {
        List<Manager> list=managerService.queryAll();
        for (Manager mna : list) {
            System.out.println(mna);
        }
    }

    @Test
    public void TestAdd() {
        Manager manager = new Manager(3, "闰土", "123456");
        managerService.insert(manager);
    }

    @Test
    public void Testupdate() {
        Manager manager = new Manager(3, "闰土", "222222");
        managerService.update(manager);
    }

    @Test
    public void TestQieryByPage() {
        List<Manager> list = managerService.queryBypage(1, 6);
        for (Manager mna : list) {
            System.out.println(mna);
        }
    }

    @Test
    public void TestQieryByname() {
        List<Manager> list = managerService.queryByname("闰土");
        for (Manager mna : list) {
            System.out.println(mna);
        }
    }

    @Test
    public void TestQieryByid() {
        Manager list = managerService.queryByid(1);
    }

    @Test
    public void Testdeletes() {
        int[] ids = {11, 12};
        managerService.deletes(ids);
    }
}