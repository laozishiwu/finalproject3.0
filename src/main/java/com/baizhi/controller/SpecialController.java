package com.baizhi.controller;

import com.baizhi.entity.Special;
import com.baizhi.service.SpecialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/special")
public class SpecialController {
    @Autowired
    private SpecialService specialService;

    @ResponseBody
    @RequestMapping("/add.do")
    public String add(Special special) {
        specialService.insert(special);
        return "add";
    }

    @ResponseBody
    @RequestMapping("/delete.do")
    public String delete(Integer id) {
        specialService.delete(id);
        return "delete";
    }

    @ResponseBody
    @RequestMapping("/update.do")
    public String update(Special special) {
        specialService.update(special);
        return "update";
    }

    @RequestMapping("/query.do")
    public String query(Integer id) {
        Special special = specialService.query(id);
        return "query";
    }

    @RequestMapping("/queryAll.do")
    public String queryAll() {
        List<Special> specials = specialService.queryAll();
        for (Special specialist : specials) {
            System.out.println(specialist);
        }
        return "queryAll";
    }

    //JSON接口
    @ResponseBody
    @RequestMapping("/queryall.do")
    public List<Special> queryall() {
        try {
            List<Special> specials = specialService.queryAll();
            for (Special specialist : specials) {
                System.out.println(specialist);
            }
            return specials;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("查询专辑所有失败！");
        }
    }

    @ResponseBody
    @RequestMapping("/queryBypage.do")
    public Map<String, Object> queryBypage(Integer page, Integer rows) {
        System.out.println("page:" + page + "rows:" + rows);
        Map<String, Object> map = new HashMap<String, Object>();
        //总条数： total=0;
        List<Special> specials = specialService.queryAll();
        List<Special> specialpage = specialService.queryBypage(page, rows);
        for (Special speciales : specialpage) {
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!" + speciales);
        }
        map.put("total", specials.size());
        map.put("rows", specialpage);
        return map;
    }
}
