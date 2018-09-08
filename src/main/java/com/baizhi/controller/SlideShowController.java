package com.baizhi.controller;

import com.baizhi.entity.SlideShow;
import com.baizhi.service.SlideShowService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/slideShow")
public class SlideShowController {
    @Autowired
    private SlideShowService slideShowService;
    @RequestMapping("/add.do")
    @ResponseBody
    public String add(SlideShow slideShow){
        slideShowService.insert(slideShow);
        return "add";
    }
    @ResponseBody
    @RequestMapping("/delete.do")
    public String delete(Integer id){
        slideShowService.delete(id);
        return "delete";
    }
    @RequestMapping("/update.do")
    @ResponseBody
    public String update(SlideShow slideShow){
        slideShowService.update(slideShow);
        return "update";
    }

    //JSON轮播图
    @ResponseBody
    @RequestMapping("/queryAll.do")
    public List<SlideShow> queryAll() {
        try {
            List<SlideShow> slideShows = slideShowService.queryAll();
            return slideShows;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("查询所有萝卜兔失败！");
        }

    }
    @ResponseBody
    @RequestMapping("/querybyPage.do")
    public Map<String,Object> querybyPage(Integer page,Integer rows){
        System.out.println("page:"+page+"rows:"+rows);
        Map<String,Object> map=new HashMap<String,Object>();
        //总条数total
        List<SlideShow> slideShows=slideShowService.queryAll();
        System.out.println("!!!!!!!!!!!" + slideShows.size());
        //当前页apge,每页条数：rows,
        List<SlideShow> pages=slideShowService.queryBypage(page, rows);
        for (SlideShow slideshows : pages) {
            System.out.println("***********************" + slideShows);
        }
        map.put("total", slideShows.size());
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
