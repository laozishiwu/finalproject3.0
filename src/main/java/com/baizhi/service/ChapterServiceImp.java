package com.baizhi.service;

import com.baizhi.dao.ChapterDao;
import com.baizhi.entity.Chapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChapterServiceImp implements ChapterService {
    @Autowired
    private ChapterDao chapterDao;

    @Override
    public void insert(Chapter chapter) {
        chapterDao.insert(chapter);
    }

    @Override
    public void delete(Integer id) {
        chapterDao.delete(id);
    }

    @Override
    public Chapter query(Integer id) {
        Chapter chapter = chapterDao.query(id);
        return chapter;
    }

    @Override
    public List<Chapter> queryAll() {
        List<Chapter> listChapter = chapterDao.queryAll();
        for (Chapter chapters : listChapter) {
            System.out.println(chapters);
        }
        return listChapter;
    }

    @Override
    public List<Chapter> queryBypage(Integer page, Integer rows) {
        int beginIndex = (page - 1) * rows;
        List<Chapter> listChapter = chapterDao.queryBypage(beginIndex, rows);
        for (Chapter chapters : listChapter) {
            System.out.println(chapters);
        }
        return listChapter;
    }
}
