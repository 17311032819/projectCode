package com.cdvtc.ecommerce.model;

public class shoppingCar {

    //    ��Ʒ��ͼ
    private String main_img;

    //    ��Ʒ���
    private String g_no;


    //    ��Ʒ��
    private String g_name;

    //    ��Ʒ���
    private String g_quantity;


    //    ��Ʒ�۸�
    private String g_price;

    public String getMain_img() {
        return main_img;
    }

    public void setMain_img(String main_img) {
        this.main_img = main_img;
    }

    public String getG_no() {
        return g_no;
    }

    public void setG_no(String g_no) {
        this.g_no = g_no;
    }

    public String getG_name() {
        return g_name;
    }

    public void setG_name(String g_name) {
        this.g_name = g_name;
    }

    public String getG_quantity() {
        return g_quantity;
    }

    public void setG_quantity(String g_quantity) {
        this.g_quantity = g_quantity;
    }

    public String getG_price() {
        return g_price;
    }

    public void setG_price(String g_price) {
        this.g_price = g_price;
    }
}
