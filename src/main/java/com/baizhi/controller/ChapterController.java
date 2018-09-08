package com.baizhi.controller;

import com.baizhi.entity.Chapter;
import com.baizhi.service.ChapterService;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/chapter")
public class ChapterController {
    @Autowired
    private ChapterService chapterService;

    @RequestMapping("/add.do")
    @ResponseBody
    public String add(Chapter chapter) {
        chapterService.insert(chapter);
        return "add";
    }

    @RequestMapping("/down.do")
    public void down(String name, String url, HttpServletRequest request, HttpServletResponse response) {
        //1-1获取项目的webApp路径（文件存储在webAPP）HttpServletRequest
        String realPath = request.getServletContext().getRealPath("/");
        //1-2获取文件路径
        String filePath = realPath + "music/" + url;
        //3-1获取文件对象（响应下载路径）
        File file = new File(filePath);
        //通过元使命获取扩展名
        String extension = FilenameUtils.getExtension(url);
        name = name + "." + extension;
        String a = null;
        try {
            //返回的编码格式：ISO-8859-1，再转为：utf-8
            a = new String(name.getBytes("utf-8"), "ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //2-1发送http请求后，以响应流返回HttpServletResponse
        //2-2响应类型，音频类型：audio/mpeg
        response.setContentType("audio/mpeg");
        //2-3响应头：音频类型tomcat-conf-web.xml(文件的响应类型)
        //响应头的属性：Content-Disposition，福建的形式attachment：下载
        response.setHeader("Content-Disposition", "attachment;filename=" + a);
        try {
            //获取输出流
            ServletOutputStream outputStream = response.getOutputStream();
            //文件转为byte[]，工具类：FileUtiles
            outputStream.write(FileUtils.readFileToByteArray(file));
            //释放资源flush()
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @ResponseBody
    @RequestMapping("/delete.do")
    public String delete(Integer id) {
        chapterService.delete(id);
        return "delete";
    }

    @ResponseBody
    @RequestMapping("/query.do")
    public Chapter query(Integer id) {
        Chapter chapter = chapterService.query(id);
        return chapter;
    }

    //JSON接口
    @ResponseBody
    @RequestMapping("/queryAll.do")
    public List<Chapter> queryAll() {
        try {
            List<Chapter> chapter = chapterService.queryAll();
            return chapter;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("查询所有章节失败！");
        }
    }

    @RequestMapping("/queryBypage.do")
    public Map<String, Object> queryBypage(Integer page, Integer rows) {
        System.out.println("page:" + page + "rows:" + rows);
        Map<String, Object> map = new HashMap<String, Object>();
        int total = 0;
        List<Chapter> list = chapterService.queryAll();
        for (Chapter chapters : list) {
            total++;
        }
        List<Chapter> lists = chapterService.queryBypage(page, rows);
        for (Chapter chapters : list) {
            System.out.println(chapters);
        }
        map.put("total", total);
        map.put("rows", rows);
        map.put("lists", list);
        return map;
    }
}
