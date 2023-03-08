package com.wsk.service;

import com.wsk.pojo.ShopPicture;

import java.util.List;

/**
 * Created by 吴健军 on 2022/12/01.
 */
public interface ShopPictureService {
    int deleteByPrimaryKey(Integer id);

    int insert(ShopPicture record);

    int insertSelective(ShopPicture record);

    ShopPicture selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ShopPicture record);

    int updateByPrimaryKey(ShopPicture record);

    ShopPicture selectBySidOnlyOne(Integer sid);

    List<ShopPicture> selectBySid(Integer sid);
}
