package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/delete.do")
    @ResponseBody
    public String delete(Integer id) {
        userService.delete(id);
        return "success";
    }

    @RequestMapping("/queryByid.do")
    public User queryByid(Integer id) {
        User user = userService.queryByid(id);
        return user;
    }

    @RequestMapping("/queryBypage.do")
    @ResponseBody
    public Map<String, Object> queryBypage(Integer page, Integer rows) {
        System.out.println("page=" + page + "&&" + "rows=" + rows);
        //创建Map对象
        Map<String, Object> map = new HashMap<String, Object>();
        //总条数total
        List<User> userAll = userService.queryAll();
        for (User alluser : userAll) {
            System.out.println("来自控制层的查询所有测试" + alluser);
        }
        //分页：当前页数page,每页展示条数：rows
        List<User> pages = userService.queryBypage(page, rows);
        for (User users : pages) {
            System.out.println("控制层分页查询的测试" + users);
        }
        map.put("total", userAll.size());
        map.put("rows", pages);
        return map;
    }

    //JSON接口
    @ResponseBody
    @RequestMapping("/queryAll.do")
    public List<User> queryAll() {
        try {
            return userService.queryAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("查询所有用户失败！");
        }
    }

    @RequestMapping("/update.do")
    public String update(User user) {
        userService.update(user);
        return "update";
    }

    @RequestMapping("/upload")
    @ResponseBody
    public String upimg(MultipartFile upfile, HttpSession session) {
        String fileName = upfile.getOriginalFilename();
        //String contentType=upfile.getContentType();
        String path = session.getServletContext().getRealPath("/images");
        try {
            upfile.transferTo(new File(path + "/" + fileName));
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return fileName;
    }

    @RequestMapping("/uploadbasic")
    @ResponseBody
    public String upimgbasic(MultipartFile upfile) {
        String fileName = upfile.getOriginalFilename();
        //String contentType=upfile.getContentType();
        try {
            upfile.transferTo(new File("E:/后期项目/finalproject/cmfzwuyc/src/main/webapp/filepoi" + fileName));
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return fileName;
    }
}
