package com.wsk.service;

import com.wsk.pojo.UserInformation;

import java.util.List;

/**
 * Created by 吴健军 on 2022/12/01.
 */
public interface UserInformationService {
    int deleteByPrimaryKey(Integer id);

    int insert(UserInformation record);

    int insertSelective(UserInformation record);

    UserInformation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserInformation record);

    int updateByPrimaryKey(UserInformation record);

    int selectIdByPhone(String phone);

    List<UserInformation> getAllForeach(List<Integer> list);
}
