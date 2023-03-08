package com.cdvtc.ecommerce.model;

/**
 * 商品分类
 */
public class Category {


    /**
     * 分类编号
     */
    private String c_no;

    /**
     * 分类名称
     */
    private String c_name;
    public String getC_no() {
        return c_no;
    }

    public void setC_no(String c_no) {
        this.c_no = c_no;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

}
