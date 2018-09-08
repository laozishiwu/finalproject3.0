package com.baizhi.test;

import com.alibaba.fastjson.JSONObject;
import com.baizhi.entity.UserDTO;
import com.baizhi.service.UserDTOService;
import io.goeasy.GoEasy;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class GoeasyTest extends BaseTest {
    @Autowired
    private UserDTOService userDTOService;

    @Test
    public void testqueryByweek() throws InterruptedException {
        JSONObject jsonObject = new JSONObject();
        while (true) {
            //坚挺数据库用户表变化，反复查询用户标的信息查看是否有新增的用户
            Integer[] weeks = {1, 2, 3};
            List<UserDTO> userDTOList = userDTOService.queryByweek(weeks);
            List<Integer> count = new ArrayList<>();
            List<Integer> week = new ArrayList<>();
            for (UserDTO userDTO : userDTOList) {
                count.add(userDTO.getCount());
                week.add(userDTO.getWeek());
            }
            jsonObject.put("count", count);
            jsonObject.put("week", week);
            System.out.println(jsonObject);
            String toJSONString = JSONObject.toJSONString(jsonObject);
            GoEasy goEasy = new GoEasy("https://rest-hangzhou.goeasy.io/publish", "BC-dd14a5c8eccc4763ad8232ac89e2db87");
            goEasy.publish("wuyongchao", toJSONString);
            Thread.sleep(3 * 1000);
        }

    }
}
