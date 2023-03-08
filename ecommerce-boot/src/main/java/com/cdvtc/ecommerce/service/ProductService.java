package com.cdvtc.ecommerce.service;

import com.cdvtc.ecommerce.model.Product;
import com.cdvtc.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    /**
     * 获取商品销量Map
     * @return Map<Integer, Integer> key:商品编号， value:销量
     */
    private Map<Integer, Integer> getSalesMap() {
        Map<Integer, Integer> salesMap = new HashMap<>();
        List<Map<String, Object>> salesList = productRepository.getProductSales();
        for(Map<String, Object>item : salesList) {
            salesMap.put(Integer.parseInt(item.get("id").toString()), Integer.parseInt(item.get("sales").toString()));
        }

        return salesMap;
    }

    public List<Product> getAllProduct(){
        List<Product> products = productRepository.findAll();

        Map<Integer, Integer> salesMap = getSalesMap();
        for(Product product: products) {
            Integer sales = salesMap.get(product.getId());
            product.setSales(sales!=null ? sales : 0);
        }

        return products;
    }

    public List<Product> getProducts(Integer categoryId){
        return productRepository.getProductsByCategoryId(categoryId);
    }

    public List<Product> getProducts(String key){
        return productRepository.getProductsByKey(key);
    }

    public Product getProductById(int id) {
        return productRepository.findById(id).get();
    }
}
