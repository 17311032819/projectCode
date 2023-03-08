package com.wsk.service;

import com.wsk.pojo.Specific;

import java.util.List;

/**
 * Created by 吴健军 on 2022/12/01.
 */
public interface SpecificeService {
    int deleteByPrimaryKey(Integer id);

    int insert(Specific record);

    int insertSelective(Specific record);

    Specific selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Specific record);

    int updateByPrimaryKey(Specific record);

    List<Specific> selectByCid(int cid);
}
