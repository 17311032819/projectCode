package com.cdvtc.ecommerce.dao;

import com.cdvtc.ecommerce.connection.DbCon;
import com.cdvtc.ecommerce.model.Category;
import com.cdvtc.ecommerce.model.Product;
import com.cdvtc.ecommerce.model.shoppingCar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCarDao {
    private Connection con;
    public ShoppingCarDao(){
        this.con= DbCon.getConnection();
    }
    public List<shoppingCar>  getshoppingcarbymno( String m_no){
        List<shoppingCar> shoppingCarList=new ArrayList<>();
        try {

            String query = "select * from goods left join shoppingcar on shoppingcar.g_no=goods.g_no where m_no=?";
            PreparedStatement pst = this.con.prepareStatement(query);
            pst.setString(1, m_no);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                shoppingCar shoppingCar=new shoppingCar();
                shoppingCar.setG_no(rs.getString("g_no"));
                shoppingCar.setG_name(rs.getString("g_name"));
                shoppingCar.setMain_img(rs.getString("main_img"));
                shoppingCar.setG_price(rs.getString("g_price"));
                shoppingCar.setG_quantity(rs.getString("g_quantity"));
                shoppingCarList.add(shoppingCar);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return shoppingCarList;
    }
}
