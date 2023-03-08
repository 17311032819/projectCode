package com.cdvtc.ecommerce.service;

import com.cdvtc.ecommerce.model.Order;
import com.cdvtc.ecommerce.model.OrderItem;
import com.cdvtc.ecommerce.model.Product;
import com.cdvtc.ecommerce.repository.OrderItemRepository;
import com.cdvtc.ecommerce.repository.OrderRepository;
import com.cdvtc.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public boolean addOrder(Order order){
        order.setDate(new Date()); //设置订单时间为当前时间
        order.setStatus((short) 1); // 设置订单初始状态
        // 保存订单
        Order o = orderRepository.save(order);
        //保持订单明细
        for(OrderItem oi: o.getOrderItems()) {
            oi.setOrder(o);
            orderItemRepository.save(oi);
        }

        // 更新产品库存
        for(OrderItem oi: o.getOrderItems()) {
            Product product = oi.getProduct();
            product.setStock(product.getStock()-oi.getQuantity());
            productRepository.save(product);
        }

        return true;
    }

    @Transactional
    public void cancelOrder(Integer orderId) {
        orderRepository.cancelOrder(orderId);
    }

    public List<Order> getOrders(Integer userId) {
        return orderRepository.getOrdersByUserId(userId);
    }

}
