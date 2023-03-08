package com.cdvtc.ecommerce.repository;

import com.cdvtc.ecommerce.BaseTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class OrderRepositoryTest extends BaseTest {
    @Autowired
    private OrderRepository orderRepository;

    @Test
    void getOrdersByUserId() {
        assertNotNull(orderRepository.getOrdersByUserId(1));
    }
}
