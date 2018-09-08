package com.baizhi.controller;

import com.baizhi.entity.Log;
import com.baizhi.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/log")
public class LogController {
    @Autowired
    private LogService logService;

    @RequestMapping("/add.do")
    public String add(Log log) {
        logService.insert(log);
        return "add";
    }

    @ResponseBody
    @RequestMapping("/queryBypage.do")
    public Map<String, Object> queryBypage(Integer page, Integer rows) {
        System.out.println("page:" + page + "rows:" + rows);
        Map<String, Object> map = new HashMap<String, Object>();
        //总条数：counts
        Integer counts = logService.queryCounts();
        //每页展示的条数rows
        List<Log> logs = logService.queryBypage(page, rows);
        for (Log logList : logs) {
            System.out.println(logList);
        }
        map.put("total", counts);
        map.put("rows", logs);
        return map;
    }
}
