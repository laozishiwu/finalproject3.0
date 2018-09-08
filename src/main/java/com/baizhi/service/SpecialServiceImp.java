package com.baizhi.service;

import com.baizhi.dao.SpecialDao;
import com.baizhi.entity.Special;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SpecialServiceImp implements SpecialService {
    @Autowired
    private SpecialDao specialDao;

    @Override
    public void insert(Special special) {
        specialDao.insert(special);
    }

    @Override
    public void delete(Integer id) {
        specialDao.delete(id);
    }

    @Override
    public void update(Special special) {
        specialDao.update(special);
    }

    @Override
    public Special query(Integer id) {
        Special special = specialDao.query(id);
        return special;
    }

    @Override
    public List<Special> queryAll() {
        List<Special> specials = specialDao.queryAll();
        for (Special speciallist : specials) {
            System.out.println(speciallist);
        }
        return specials;
    }

    @Override
    public List<Special> queryBypage(Integer page, Integer rows) {
        System.out.println("page:" + page + "$$$$$$$" + "rows:" + rows);
        int beginIndex = (page - 1) * rows;
        System.out.println(page + "@@@@@@@@" + rows);
        List<Special> specials = specialDao.queryBypage(beginIndex, rows);
        for (Special speciallist : specials) {
            System.out.println(speciallist);
        }
        return specials;
    }
}
