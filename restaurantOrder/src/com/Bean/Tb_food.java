package com.Bean;

public class Tb_food {
    private String foodName;
    private float costPrice;
    private String introduce;
    private String imageLink;
    private String shopName;
    private String phone;
    private String email;
    public Tb_food(){

    }
    public String getFoodName(){
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }
    public float getCostPrice(){
        return costPrice;
    }

    public void setCostPrice(float costPrice) {
        this.costPrice = costPrice;
    }

    public String getIntroduce(){
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone(){
        return  phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
