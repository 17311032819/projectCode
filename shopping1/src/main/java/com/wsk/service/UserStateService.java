package com.wsk.service;

import com.wsk.pojo.UserState;

/**
 * Created by 吴健军 on 2022/12/01.
 */
public interface UserStateService {
    int deleteByPrimaryKey(Integer id);

    int insert(UserState record);

    int insertSelective(UserState record);

    UserState selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserState record);

    int updateByPrimaryKey(UserState record);

    UserState selectByUid(int uid);
}
