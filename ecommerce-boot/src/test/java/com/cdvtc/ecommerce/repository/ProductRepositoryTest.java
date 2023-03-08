package com.cdvtc.ecommerce.repository;

import com.cdvtc.ecommerce.BaseTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest extends BaseTest {
    @Autowired
    private ProductRepository productRepository;

    @Test
    void getProductSales() {
        List<Map<String, Object>> salesList = productRepository.getProductSales();
        assertNotNull(salesList);
    }
}
