package com.wsk.service;

import com.wsk.pojo.UserCollection;

import java.util.List;

/**
 * Created by 吴健军 on 2022/12/01.
 */
public interface UserCollectionService {
    int deleteByPrimaryKey(Integer id);

    int insert(UserCollection record);

    int insertSelective(UserCollection record);

    UserCollection selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserCollection record);

    int updateByPrimaryKey(UserCollection record);

    int getCounts(int uid);

    List<UserCollection> selectByUid(int uid, int start);
}
