package com.baizhi.test;

import com.baizhi.entity.Menu;
import com.baizhi.service.MenuService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MenuTest extends BaseTest {
    @Autowired
    private MenuService menuService;
    @Test
    public void testQueryAll(){
       List<Menu> menuList=menuService.queryAll();
        for (Menu menus:menuList) {
            System.out.println(menus);
        }
    }
}
