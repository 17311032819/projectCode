package com.cdvtc.ecommerce.repository;

import com.cdvtc.ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("select oi.product.id as id, count(oi.id) as sales from OrderItem oi group by oi.product.id")
    List<Map<String, Object>> getProductSales();

    @Query("from Product p where p.category.id=:cid")
    List<Product> getProductsByCategoryId(int cid);

    @Query("from Product p where p.name like concat('%',:key,'%') or p.category.name like concat('%',:key,'%')")
    List<Product> getProductsByKey(String key);
}
