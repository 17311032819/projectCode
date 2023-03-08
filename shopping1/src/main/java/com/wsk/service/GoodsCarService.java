package com.wsk.service;

import com.wsk.pojo.GoodsCar;

import java.util.List;
/**
 * Created by 吴健军 on 2022/12/01.
 */
public interface GoodsCarService {
    int deleteByPrimaryKey(Integer id);

    int insert(GoodsCar record);

    int insertSelective(GoodsCar record);

    GoodsCar selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GoodsCar record);

    int updateByPrimaryKey(GoodsCar record);

    List<GoodsCar> selectByUid(int uid);

    int deleteByUid(Integer uid);
}
