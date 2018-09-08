package com.baizhi.service;

import com.baizhi.entity.UserDTO;

import java.util.List;

public interface UserDTOService {
    //最近一周，两周，三周注册的用户数量
    List<UserDTO> queryByweek(Integer... weeks);

    //性别为男，女的用户，不同地区的注册数量
    List<UserDTO> queryByLocation(String sex);
}
