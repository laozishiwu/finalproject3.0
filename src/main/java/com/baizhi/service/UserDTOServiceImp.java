package com.baizhi.service;

import com.baizhi.dao.UserDTODao;
import com.baizhi.entity.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class UserDTOServiceImp implements UserDTOService {
    @Autowired
    private UserDTODao userDTODao;

    //查看最近几周注册用户数量
    @Override
    public List<UserDTO> queryByweek(Integer... weeks) {
        List<UserDTO> countsTime = new ArrayList<UserDTO>();
        for (Integer week : weeks) {
            UserDTO userDTO = userDTODao.queryByweek(week);
            userDTO.setWeek(week);
            countsTime.add(userDTO);
        }
        return countsTime;
    }

    @Override
    public List<UserDTO> queryByLocation(String sex) {
        List<UserDTO> userDTOList = userDTODao.queryByLocation(sex);
        for (UserDTO user : userDTOList) {
            System.out.println(user);
        }
        return userDTOList;
    }
}
