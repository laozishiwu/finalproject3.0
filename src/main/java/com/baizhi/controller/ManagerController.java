package com.baizhi.controller;

import com.baizhi.entity.Manager;
import com.baizhi.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/manager")
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    @RequestMapping("/login.do")
    public String login(HttpSession session,String username,String password,String captcha){
        String code= (String) session.getAttribute("code");
        if(code.equals(captcha)) {
           Manager manager= managerService.query(username, password);
            System.out.println(manager);
            session.setAttribute("manager", manager);
           session.setAttribute("username", username);
           if(manager==null){
               return "back/login";
           }
            return "back/main";
        }
        return "back/login";
    }

    @RequestMapping("/loginout.do")
    public String loginout() {
        return "redirect:back/login";
    }

    @ResponseBody
    @RequestMapping("/queryByid.do")
    public Manager queryByid(Integer id) {
        Manager manager = managerService.queryByid(id);
        return manager;
    }

    @ResponseBody
    @RequestMapping("/queryBypage.do")
    public Map<String, Object> queryBypage(Integer page, Integer rows, HttpSession session) {
        //创建HashMap()集合
        Map<String, Object> map = new HashMap<String, Object>();
        //总数：total
        List<Manager> managers = managerService.queryAll();
        session.setAttribute("managers", managers);
        //每页展示条数rows
        List<Manager> managerPage = managerService.queryBypage(page, rows);
        for (Manager managersx : managerPage) {
            System.out.println(managersx);
        }
        //添加到Map()集合
        map.put("total", managers.size());
        map.put("rows", managerPage);
        return map;
    }

    @RequestMapping("/update.do")
    public String update(Manager manager) {
        managerService.update(manager);
        return "back/main";
    }

    @RequestMapping("/queryByname.do")
    public String queryByname(String username) {
        List<Manager> managers = managerService.queryByname(username);
        return "other/main";
    }

    @RequestMapping("/deletes.do")
    public String queryByname(int[] ids) {
        managerService.deletes(ids);
        return "other/main";
    }

    @RequestMapping("/delete.do")
    public String querydelete(Integer id) {
        managerService.delete(id);
        return "other/main";
    }

    @ResponseBody
    @RequestMapping("/queryAll.do")
    public List<Manager> queryAll() {
        try {
            return managerService.queryAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("查询所有关礼杰失败！");
        }
    }
}
