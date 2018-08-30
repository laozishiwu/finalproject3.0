package com.baizhi.controller;

import com.baizhi.entity.SlideShow;
import com.baizhi.service.SlideShowService;
import com.baizhi.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @ResponseBody
    @RequestMapping("/querybyPage.do")
    public Map<String,Object> querybyPage(Integer page,Integer rows){
        System.out.println("page:"+page+"rows:"+rows);
        Map<String,Object> map=new HashMap<String,Object>();
        //总条数
        int total=0;
        List<SlideShow> slideShows=slideShowService.queryAll();
        for (SlideShow slides:slideShows) {
            total++;
        }
        //当前页apge,每页条数：rows,
        List<SlideShow> pages=slideShowService.queryBypage(page, rows);
        map.put("total",total);
        map.put("rows",rows);
        return map;
    }
    @RequestMapping(value = "/uploadFile.do")
    @ResponseBody
    public SlideShow uploadFile(MultipartFile srcFile, HttpSession session) throws Exception{
        SlideShow viewpager=new SlideShow();
        String uuid = UUIDUtil.getUUID();
        viewpager.setId(uuid);
        String filename = srcFile.getOriginalFilename();
        // 将上传的文件保存到服务器
        String src = "/main/shouye";
        String realPath = session.getServletContext().getRealPath(src);// 获取真实路径
        // 将上传文件保存到服务器指定位置
        srcFile.transferTo(new File(realPath+"/"+filename));
        src+="/"+filename;
        viewpager.setImgPath(src);
        slideShowService.insert(viewpager);
        return viewpager;
    }

    @RequestMapping(value = "/uploadFile2.do")
    @ResponseBody
    public String uploadFile2(SlideShow viewpager){
        slideShowService.update(viewpager);
        return "success";
    }
}
