package com.wsk.service;

import com.wsk.pojo.BoughtShop;

import java.util.List;

/**
 * Created by 吴健军 on 2022/12/01.
 */
public interface BoughtShopService {
    int deleteByPrimaryKey(Integer id);

    int insert(BoughtShop record);

    int insertSelective(BoughtShop record);

    BoughtShop selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BoughtShop record);

    int updateByPrimaryKey(BoughtShop record);

    int getCounts(int uid);

    List<BoughtShop> selectByUid(int uid, int start);
}
