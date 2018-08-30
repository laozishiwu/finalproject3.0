package com.baizhi.service;

import com.baizhi.dao.SlideShowDao;
import com.baizhi.entity.SlideShow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SlideShowServiceImp implements SlideShowService{
    @Autowired
    private SlideShowDao slideShowDao;
    @Override
    public void insert(SlideShow slideShow) {
        slideShowDao.insert(slideShow);
    }

    @Override
    public void delete(Integer id) {
        slideShowDao.delete(id);
    }

    @Override
    public void update(SlideShow slideShow) {
        slideShowDao.update(slideShow);
    }

    @Override
    public List<SlideShow> queryBypage(Integer page, Integer rows) {
        int beginIndex=(page-1)*rows;
        List<SlideShow> slideShowList=slideShowDao.queryBypage(beginIndex,rows);
        for (SlideShow slideShows:slideShowList) {
            System.out.println(slideShows);
        }
        return slideShowList;
    }

    @Override
    public List<SlideShow> queryAll() {
        List<SlideShow> slideShows=slideShowDao.queryAll();
        for (SlideShow slideShowlist:slideShows) {
            System.out.println(slideShowlist);
        }
        return slideShows;
    }
}
