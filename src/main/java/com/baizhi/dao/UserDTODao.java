package com.baizhi.dao;

import com.baizhi.entity.UserDTO;

import java.util.List;

public interface UserDTODao {
    UserDTO queryByweek(Integer week);

    List<UserDTO> queryByLocation(String sex);
}
