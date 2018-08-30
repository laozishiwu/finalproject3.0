package com.baizhi.test;

import com.baizhi.dao.SlideShowDao;
import com.baizhi.entity.SlideShow;
import com.baizhi.service.SlideShowService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class SlideShowTest extends BaseTest {
    @Autowired
    private SlideShowService slideShowService;
    @Test
    public void testAdd(){
        SlideShow slideShow=new SlideShow(6,"老夫聊发少年狂","img/car08.jpg","会挽雕弓如满月，西北望，射天狼！",new Date(),"on");
        slideShowService.insert(slideShow);
    }
    @Test
    public void testDelete(){
        slideShowService.delete(1);
    }
    @Test
    public void testUpdate(){
        SlideShow slideShow=new SlideShow(1,"老骥伏枥","img/car01.jpg","老骥伏枥，志在千里",new Date(),"off");
        slideShowService.update(slideShow);
    }
    @Test
    public void testqueryAll(){
        List<SlideShow> slideShowList=slideShowService.queryAll();
        for (SlideShow slideshows:slideShowList) {
            System.out.println(slideshows);
        }
    }
    @Test
    public void testquerybyPage(){
        List<SlideShow> slideShowList=slideShowService.queryBypage(1,6);
        for (SlideShow slideshows:slideShowList) {
            System.out.println(slideshows);
        }
    }
}
