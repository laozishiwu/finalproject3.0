package com.baizhi.service;

import com.baizhi.dao.LogDao;
import com.baizhi.entity.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LogServiceImp implements LogService {
    @Autowired
    private LogDao logDao;

    @Override
    public void insert(Log log) {
        logDao.insert(log);
    }

    @Override
    public List<Log> queryBypage(Integer page, Integer rows) {
        int beginIndex = (page - 1) * rows;
        List<Log> logList = logDao.queryBypage(beginIndex, rows);
        for (Log logs : logList) {
            System.out.println("logs:" + logs);
        }
        return logList;
    }

    @Override
    public Integer queryCounts() {
        Integer count = logDao.queryCounts();
        return count;
    }
}
