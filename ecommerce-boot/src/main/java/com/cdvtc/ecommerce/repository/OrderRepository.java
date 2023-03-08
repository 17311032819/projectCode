package com.cdvtc.ecommerce.repository;

import com.cdvtc.ecommerce.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Query("from Order o where o.user.id=:userId and o.status>=0 order by o.id desc")
    List<Order> getOrdersByUserId(Integer userId);


    @Modifying // 注意：修改数据时必需加此注解
    @Query("update Order o set o.status=-1 where o.id=:orderId")
    void cancelOrder(Integer orderId);
}
