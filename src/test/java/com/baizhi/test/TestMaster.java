package com.baizhi.test;

import com.baizhi.entity.Master;
import com.baizhi.service.MasterService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TestMaster extends BaseTest {
    @Autowired
    private MasterService masterService;

    @Test
    public void testAdd() {
        Master master = new Master(1, "法海", "法海大师", "on", "123456", "/img/4.png");
        masterService.insert(master);
    }

    @Test
    public void testdelete() {
        Master master = new Master(1, "法海", "法海大师", "on", "123456", "/img/4.png");
        masterService.delete(12);
    }

    @Test
    public void testQueryAll() {
        List<Master> masterlist = masterService.queryAll();
        for (Master masters : masterlist) {
            System.out.println(masters);
        }
    }

    @Test
    public void testQueryByname() {
        List<Master> masterlist = masterService.queryByname("虚竹");
        for (Master masters : masterlist) {
            System.out.println(masters);
        }
    }

    @Test
    public void testQueryBypage() {
        List<Master> masterlist = masterService.queryBypage(1, 3);
        for (Master masters : masterlist) {
            System.out.println(masters);
        }
    }

    @Test
    public void testdeletes() {
        int[] ids = {11, 12};
        masterService.deletes(ids);
    }
}
