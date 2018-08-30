package com.baizhi.controller;
import com.baizhi.entity.Manager;
import com.baizhi.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/manager")
public class ManagerController {
    @Autowired
    private ManagerService managerService;
    @RequestMapping("/login")
    public String login(HttpSession session,String username,String password,String captcha){
        String code= (String) session.getAttribute("code");
        if(code.equals(captcha)) {
           Manager manager= managerService.query(username, password);
            System.out.println(manager);
           session.setAttribute("username", username);
           if(manager==null){
               return "login";
           }
            return "main";
        }
        return "login";
    }
}
