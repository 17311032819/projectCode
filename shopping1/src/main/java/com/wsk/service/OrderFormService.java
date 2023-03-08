package com.wsk.service;

import com.wsk.bean.OrdersBean;
import com.wsk.pojo.OrderForm;

import java.util.List;

/**
 * Created by 吴健军 on 2022/12/01.
 */
public interface OrderFormService {
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
