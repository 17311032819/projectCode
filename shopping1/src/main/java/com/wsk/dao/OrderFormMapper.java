package com.wsk.dao;

import com.wsk.bean.OrdersBean;
import com.wsk.pojo.GoodsCar;
import com.wsk.pojo.OrderForm;

import java.util.List;

public interface OrderFormMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderForm record);

    int insertSelective(OrderForm record);

    OrderForm selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderForm record);

    int updateByPrimaryKey(OrderForm record);

    int getCounts(int uid);

    List<OrdersBean> selectByUid1(int uid);

    List<OrderForm> selectByUid(int uid, int start);
}