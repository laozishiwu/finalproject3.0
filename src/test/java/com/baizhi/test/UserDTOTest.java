package com.baizhi.test;

import com.baizhi.entity.UserDTO;
import com.baizhi.service.UserDTOService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserDTOTest extends BaseTest {
    @Autowired
    private UserDTOService userDTOService;

    @Test
    public void testqueryByweek() {
        List<UserDTO> use = userDTOService.queryByweek(1, 2, 3);
        for (UserDTO users : use) {
            System.out.println(users);
        }
    }

    @Test
    public void testqueryBylocation() {
        List<UserDTO> userDTOList = userDTOService.queryByLocation("男");
        for (UserDTO userDTOs : userDTOList) {
            System.out.println(userDTOs);
        }
    }
}
