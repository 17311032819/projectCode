package com.wsk.bean;

import java.util.Date;

public class OrdersBean {

    private int ofid;
    private int uid;
    private int sid;
    private int quantity;
    private String name;
    private String image;
    private double price;
    private int gid;//商品明细表id

    @Override
    public String toString() {
        return "OrdersBean{" +
                "ofid=" + ofid +
                ", uid=" + uid +
                ", sid=" + sid +
                ", quantity=" + quantity +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", price=" + price +
                ", gid=" + gid +
                '}';
    }

    public int getOfid() {
        return ofid;
    }

    public void setOfid(int ofid) {
        this.ofid = ofid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }
}
