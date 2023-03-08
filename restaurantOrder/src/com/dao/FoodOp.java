package com.dao;

import com.Bean.Tb_food;
import com.Bean.Tb_user;
import com.db.connectiontomysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FoodOp {

    Connection connection=new connectiontomysql().getConnection();//生成连接对象
    PreparedStatement pstmt;
    ResultSet rs;
    //添加食品
    public boolean adduserpackage(Tb_food tb_food){
        boolean flag=false;
        String insertsql="insert into package values(?,?,?,?,?,?,?)";
        try {
            pstmt=connection.prepareStatement(insertsql);
            pstmt.setString(1, tb_food.getFoodName());
            pstmt.setFloat(2, tb_food.getCostPrice());
            pstmt.setString(3, tb_food.getIntroduce());
            pstmt.setString(4, tb_food.getImageLink());
            pstmt.setString(5, tb_food.getShopName());
            pstmt.setString(6,tb_food.getEmail());
            pstmt.setString(7,tb_food.getPhone());



            if(pstmt.executeUpdate()>0){
                flag=true;
            }
            else{
                flag=false;
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return flag;
    }
    public boolean addusersweet(Tb_food tb_food){
        boolean flag=false;
        String insertsql="insert into package values(?,?,?,?,?,?,?)";
        try {
            pstmt=connection.prepareStatement(insertsql);
            pstmt.setString(1, tb_food.getFoodName());
            pstmt.setFloat(2, tb_food.getCostPrice());
            pstmt.setString(3, tb_food.getIntroduce());
            pstmt.setString(4, tb_food.getImageLink());
            pstmt.setString(5, tb_food.getShopName());
            pstmt.setString(6,tb_food.getEmail());
            pstmt.setString(7,tb_food.getPhone());

            if(pstmt.executeUpdate()>0){
                flag=true;
            }
            else{
                flag=false;
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return flag;
    }
    public boolean addusercolordrinks(Tb_food tb_food){
        boolean flag=false;
        String insertsql="insert into package values(?,?,?,?,?,?,?)";
        try {
            pstmt=connection.prepareStatement(insertsql);
            pstmt.setString(1, tb_food.getFoodName());
            pstmt.setFloat(2, tb_food.getCostPrice());
            pstmt.setString(3, tb_food.getIntroduce());
            pstmt.setString(4, tb_food.getImageLink());
            pstmt.setString(5, tb_food.getShopName());
            pstmt.setString(6,tb_food.getEmail());
            pstmt.setString(7,tb_food.getPhone());



            if(pstmt.executeUpdate()>0){
                flag=true;
            }
            else{
                flag=false;
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return flag;
    }
    public boolean adduserleisuresnack(Tb_food tb_food){
        boolean flag=false;
        String insertsql="insert into package values(?,?,?,?,?,?,?)";
        try {
            pstmt=connection.prepareStatement(insertsql);
            pstmt.setString(1, tb_food.getFoodName());
            pstmt.setFloat(2, tb_food.getCostPrice());
            pstmt.setString(3, tb_food.getIntroduce());
            pstmt.setString(4, tb_food.getImageLink());
            pstmt.setString(5, tb_food.getShopName());
            pstmt.setString(6,tb_food.getEmail());
            pstmt.setString(7,tb_food.getPhone());



            if(pstmt.executeUpdate()>0){
                flag=true;
            }
            else{
                flag=false;
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return flag;
    }

    public List getFoodPackage() {
        List list = new ArrayList();
        try {
//            String selectsql = "select * from package";
            String selectsql="select foodname,costPrice,"
                    + "introduce,"
                    + "shopname,"+"shopemail,"+"shopphone"
                    + " from package"
                    ;
            pstmt=connection.prepareStatement(selectsql);
            //pstmt.setInt(1, cc);
            rs=pstmt.executeQuery();
            String foodName;
            float costPrice;
            String introduce;
            String shopName;
            String shopEmail;
            String shopPhone;
            //循环取出课程记录，加入列表中
            while(rs.next()){
                foodName=rs.getString(1);
                costPrice=rs.getFloat(2);
                introduce=rs.getString(3);
                shopName=rs.getString(4);
                shopEmail=rs.getString(5);
                shopPhone=rs.getString(6);
                Tb_food tb_food=new Tb_food();
                tb_food.setFoodName(foodName);
                tb_food.setCostPrice(costPrice);
                tb_food.setIntroduce(introduce);
                tb_food.setShopName(shopName);
                tb_food.setEmail(shopEmail);
                tb_food.setPhone(shopPhone);
                list.add(tb_food);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public List getFoodSweet() {
        List list = new ArrayList();
        try {
//            String selectsql = "select * from package";
            String selectsql="select foodname,costPrice,"
                    + "introduce,"
                    + "shopname"+"shopemail"+"shopphone"
                    + " from sweet"
                    ;
            pstmt=connection.prepareStatement(selectsql);
            //pstmt.setInt(1, cc);
            rs=pstmt.executeQuery();
            String foodName;
            float costPrice;
            String introduce;
            String shopName;
            String shopEmail;
            String shopPhone;
            //循环取出课程记录，加入列表中
            while(rs.next()){
                foodName=rs.getString(1);
                costPrice=rs.getFloat(2);
                introduce=rs.getString(3);
                shopName=rs.getString(4);
                shopEmail=rs.getString(5);
                shopPhone=rs.getString(6);
                Tb_food tb_food=new Tb_food();
                tb_food.setFoodName(foodName);
                tb_food.setCostPrice(costPrice);
                tb_food.setIntroduce(introduce);
                tb_food.setShopName(shopName);
                tb_food.setEmail(shopEmail);
                tb_food.setPhone(shopPhone);
                list.add(tb_food);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public List getFoodLeisureSnack() {
        List list = new ArrayList();
        try {
//            String selectsql = "select * from package";
            String selectsql="select foodname,costPrice,"
                    + "introduce,"
                    + "shopname"+"shopemail"+"shopphone"
                    + " from leisureSnack"
                    ;
            pstmt=connection.prepareStatement(selectsql);
            //pstmt.setInt(1, cc);
            rs=pstmt.executeQuery();
            String foodName;
            float costPrice;
            String introduce;
            String shopName;
            String shopEmail;
            String shopPhone;
            //循环取出课程记录，加入列表中
            while(rs.next()){
                foodName=rs.getString(1);
                costPrice=rs.getFloat(2);
                introduce=rs.getString(3);
                shopName=rs.getString(4);
                shopEmail=rs.getString(5);
                shopPhone=rs.getString(6);
                Tb_food tb_food=new Tb_food();
                tb_food.setFoodName(foodName);
                tb_food.setCostPrice(costPrice);
                tb_food.setIntroduce(introduce);
                tb_food.setShopName(shopName);
                tb_food.setEmail(shopEmail);
                tb_food.setPhone(shopPhone);
                list.add(tb_food);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public List getFoodColorDrinks() {
        List list = new ArrayList();
        try {
//            String selectsql = "select * from package";
            String selectsql="select foodname,costPrice,"
                    + "introduce,"
                    + "shopname"+"shopemail"+"shopphone"
                    + " from colorDrinks"
                    ;
            pstmt=connection.prepareStatement(selectsql);
            //pstmt.setInt(1, cc);
            rs=pstmt.executeQuery();
            String foodName;
            float costPrice;
            String introduce;
            String shopName;
            String shopEmail;
            String shopPhone;
            //循环取出课程记录，加入列表中
            while(rs.next()){
                foodName=rs.getString(1);
                costPrice=rs.getFloat(2);
                introduce=rs.getString(3);
                shopName=rs.getString(4);
                shopEmail=rs.getString(5);
                shopPhone=rs.getString(6);
                Tb_food tb_food=new Tb_food();
                tb_food.setFoodName(foodName);
                tb_food.setCostPrice(costPrice);
                tb_food.setIntroduce(introduce);
                tb_food.setShopName(shopName);
                tb_food.setEmail(shopEmail);
                tb_food.setPhone(shopPhone);
                list.add(tb_food);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}
