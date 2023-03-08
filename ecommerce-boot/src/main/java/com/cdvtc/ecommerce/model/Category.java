package com.cdvtc.ecommerce.model;

import javax.persistence.*;
import java.util.List;

/**
 * 商品分类
 */
@Entity
public class Category {
    /**
     * 分类编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * 分类名称
     */
    private String name;

    @OneToMany
    private List<Product> products;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
