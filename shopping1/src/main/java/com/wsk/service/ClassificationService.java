package com.wsk.service;

import com.wsk.pojo.Classification;

import java.util.List;

/**
 * Created by 吴健军 on 2022/12/01.
 */
public interface ClassificationService {
    int deleteByPrimaryKey(Integer id);

    int insert(Classification record);

    int insertSelective(Classification record);

    Classification selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Classification record);

    int updateByPrimaryKey(Classification record);

    List<Classification> selectByAid(int aid);
}
