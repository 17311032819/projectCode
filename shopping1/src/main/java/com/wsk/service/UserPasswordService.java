package com.wsk.service;

import com.wsk.pojo.UserPassword;

/**
 * Created by 吴健军 on 2022/12/01.
 */
public interface UserPasswordService {
    int deleteByPrimaryKey(Integer id);

    int insert(UserPassword record);

    int insertSelective(UserPassword record);

    UserPassword selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserPassword record);

    int updateByPrimaryKey(UserPassword record);

    int updateByUid(UserPassword record);


    UserPassword selectByUid(Integer uid);
}
