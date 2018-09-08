package com.baizhi.controller;

import com.alibaba.fastjson.JSONObject;
import com.baizhi.entity.UserDTO;
import com.baizhi.service.UserDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/userDTO")
public class UserDTOController {
    @Autowired
    private UserDTOService userDTOService;

    @ResponseBody
    @RequestMapping("/queryByweek.do")
    public JSONObject queryByweek() {
        JSONObject jsonObject = new JSONObject();
        Integer[] weeks = {1, 2, 3};
        List<UserDTO> userDTOList = userDTOService.queryByweek(weeks);
        List<Integer> count = new ArrayList<>();
        List<Integer> week = new ArrayList<>();
        for (UserDTO userDTO : userDTOList) {
            count.add(userDTO.getCount());
            week.add(userDTO.getWeek());
            System.out.println("#########" + userDTO);
        }
        jsonObject.put("count", count);
        jsonObject.put("week", week);
        System.out.println("count:" + count + "%%%%%%%%%%%%%%" + "week:" + week);
        return jsonObject;
    }

    @ResponseBody
    @RequestMapping("/queryBylocation.do")
    public JSONObject queryBylocation() {
        List<UserDTO> 男 = userDTOService.queryByLocation("男");
        System.out.println("男生控制层的测试：" + 男);
        List<UserDTO> 女 = userDTOService.queryByLocation("女");
        System.out.println("女生控制层的测试：" + 女);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("男", 男);
        jsonObject.put("女", 女);
        return jsonObject;
    }

    @ResponseBody
    @RequestMapping("/bar.do")
    public Map<String, Object> bar() {

        Map<String, Object> map = new HashMap<>();

//      查询三次数据库   5  15 20 做数据汇总
        List<String> strs = new ArrayList<>();
        strs.add("近1周");
        strs.add("近2周");
        strs.add("近3周");


        List<Integer> mans = new ArrayList<>();
        mans.add(5);
        mans.add(15);
        mans.add(20);


        List<Integer> womens = new ArrayList<>();
        womens.add(10);
        womens.add(17);
        womens.add(20);

        map.put("xAxis", strs);
        map.put("men", mans);
        map.put("womens", womens);

        return map;
    }

    @ResponseBody
    @RequestMapping("/map")
    public Map<String, Object> map() {
        Map<String, Object> map = new HashMap<>();
        //男生的地区分布
        List<Object> mans = new ArrayList<>();
        mans.add(userDTOService.queryByLocation("男"));
        //女生的地区分布
        List<Object> womens = new ArrayList<>();
        womens.add(userDTOService.queryByLocation("女"));
        map.put("man", mans);
        map.put("womens", womens);
        return map;
    }
}
