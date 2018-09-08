package com.baizhi.controller;

import com.baizhi.entity.Master;
import com.baizhi.service.MasterService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/master")
public class MasterController {
    @Autowired
    private MasterService masterService;

    @ResponseBody
    @RequestMapping("/add.do")
    public String add(MultipartFile imgfile, HttpSession session, Master master) {
        String filename = imgfile.getOriginalFilename();
        String root = session.getServletContext().getRealPath("/");
        File masterimg = new File(root, "masterimg");
        if (!masterimg.exists()) {
            masterimg.mkdir();
        }
        try {
            imgfile.transferTo(new File(masterimg, filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        master.setPhoto(filename);
        masterService.insert(master);
        System.out.println("控制层添加法师：" + master);

        return "add";
    }

    @ResponseBody
    @RequestMapping("/delete.do")
    public String delete(Integer id) {
        masterService.delete(id);
        return "delete";
    }

    @ResponseBody
    @RequestMapping("/queryAll.do")
    public List<Master> queryAll() {
        try {
            return masterService.queryAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("查询大师所有失败！");
        }
    }

    @ResponseBody
    @RequestMapping("/queryBypage.do")
    public Map<String, Object> queryBypage(Integer page, Integer rows) {
        System.out.println("page:" + page + "rows:" + rows);
        Map<String, Object> map = new HashMap<String, Object>();
        //总条数：total
        List<Master> masters = masterService.queryAll();
        for (Master mastor : masters) {
            System.out.println("控制层的查询所有测试" + masters);
        }
        //分页数据pages
        List<Master> pages = masterService.queryBypage(page, rows);
        for (Master mastors : pages) {
            System.out.println("控制层的分页查询测试" + mastors);
        }
        map.put("total", masters.size());
        map.put("rows", pages);
        return map;
    }

    @RequestMapping(value = "/uploadFile.do")
    @ResponseBody
    public void addBanner(String status, String content, String title, MultipartFile imgPath, HttpServletRequest request) {

        /*
         * 1.指定上传位置
         * 2.防止文件重名
         * 3.上传文件到指定文件夹
         *
         *   webapps   暂时 存放到项目中   分布式的文件存储系统
         *
         * */
//        项目的绝对路径 D:\source\final-project\cmfz\src\main\webapp\
        String realPath = request.getServletContext().getRealPath("/");
        String uploadFilePath = realPath + "upload";
        File file = new File(uploadFilePath);
        if (!file.exists()) {
            file.mkdir();
        }
//            1.jpg
        String originalFilename = imgPath.getOriginalFilename();

        String uuid = UUID.randomUUID().toString();
//              jpg
        String extension = FilenameUtils.getExtension(originalFilename);
//        newName
        String newName = uuid + "." + extension;
        try {
            imgPath.transferTo(new File(uploadFilePath, newName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*入库 url  406430cf-f5b0-4571-a36d-9fae0265b1a6.png   /*/

    }
}
