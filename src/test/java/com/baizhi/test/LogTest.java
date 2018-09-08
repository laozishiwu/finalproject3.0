package com.baizhi.test;

import com.baizhi.entity.Log;
import com.baizhi.service.LogService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class LogTest extends BaseTest {
    @Autowired
    private LogService logService;

    @Test
    public void testAdd() {
        Log log = new Log(1, "冯•卡门", "添加日志控制类！", new Date(), "测试！");
        logService.insert(log);
    }

    @Test
    public void testQueryBypage() {
        List<Log> logList = logService.queryBypage(1, 3);
        for (Log logs : logList) {
            System.out.println(logs);
        }
    }

    @Test
    public void testqueryCounts() {
        Integer counts = logService.queryCounts();
        System.out.println("counts:" + counts);
    }
}
