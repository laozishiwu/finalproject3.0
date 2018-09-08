package com.baizhi.test;

import com.baizhi.entity.Chapter;
import com.baizhi.entity.Special;
import com.baizhi.service.SpecialService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SpecialTest extends BaseTest {
    @Autowired
    private SpecialService specialService;

    @Test
    public void testAdd() {
        List<Chapter> children = new ArrayList<Chapter>();
        Special special = new Special(4, "广陵散", 35, "/img/car01.jpg", 5, "嵇康", "嵇康", "葡萄美酒夜光杯，欲饮琵琶马上催！", new Date(), new Date(), "up", children);
        specialService.insert(special);
    }

    @Test
    public void testDelete() {
        specialService.delete(1);
    }

    @Test
    public void testUpdate() {
        List<Chapter> children = new ArrayList<Chapter>();
        Special special = new Special(1, "广陵散", 35, "/img/car01.jpg", 5, "嵇康", "嵇康", "葡萄美酒夜光杯，欲饮琵琶马上催！", new Date(), new Date(), "up", children);
        specialService.update(special);
    }

    @Test
    public void testQuery() {
        Special special = specialService.query(6);
    }

    @Test
    public void testQueryALL() {
        List<Special> special = specialService.queryAll();
        for (Special specials : special) {
            System.out.println(specials);
        }
    }

    @Test
    public void testQueryBypage() {
        List<Special> special = specialService.queryBypage(1, 3);
        for (Special specials : special) {
            System.out.println(specials);
        }
    }
}
