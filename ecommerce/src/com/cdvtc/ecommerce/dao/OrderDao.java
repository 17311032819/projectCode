package com.cdvtc.ecommerce.dao;

import com.cdvtc.ecommerce.connection.DbCon;
import com.cdvtc.ecommerce.model.Order;
import com.cdvtc.ecommerce.model.shoppingCar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDao {
    private Connection con;
    public OrderDao(){
        this.con= DbCon.getConnection();
    }
    public List<Order> getOrdersBymno(String m_no){
        List<Order> orderList=new ArrayList<>();
        try {

            String query = "select * from `order` left join details on `order`.o_no=details.o_no where m_no=?";
            PreparedStatement pst = this.con.prepareStatement(query);
            pst.setString(1, m_no);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Order order=new Order();
                order.setAdress(rs.getString("address"));
                order.setO_no(rs.getString("o_no"));
                order.setDate(rs.getTimestamp("o_time"));
                order.setO_state(rs.getString("o_state"));
                order.setM_no(rs.getString("m_no"));
                order.setG_no(rs.getString("g_no"));
                order.setG_name(rs.getString("g_name"));
                order.setPrice(rs.getFloat("g_price"));
                order.setComment(rs.getString("comment"));
                order.setNumber(rs.getInt("number"));
                order.setStar(rs.getString("star"));
                orderList.add(order);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orderList;
    }

    public Order getOrderByo_no(String ono){
        Order order=new Order();
        try {

            String query = "select * from `order` left join details on `order`.o_no=details.o_no where details.o_no=?";
            PreparedStatement pst = this.con.prepareStatement(query);
            pst.setString(1, ono);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                order.setAdress(rs.getString("address"));
                order.setO_no(rs.getString("o_no"));
                order.setDate(rs.getTimestamp("o_time"));
                order.setO_state(rs.getString("o_state"));
                order.setM_no(rs.getString("m_no"));
                order.setG_no(rs.getString("g_no"));
                order.setG_name(rs.getString("g_name"));
                order.setPrice(rs.getFloat("g_price"));
                order.setComment(rs.getString("comment"));
                order.setNumber(rs.getInt("number"));
                order.setStar(rs.getString("star"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return order;
    }

    public static void main(String[] args) {
        OrderDao orderDao=new OrderDao();
        Order order=new Order();
        order=orderDao.getOrderByo_no("1004");
        System.out.println(order);
    }
}
