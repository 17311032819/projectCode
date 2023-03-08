package com.dao;

import com.Bean.Tb_Order;
import com.Bean.Tb_food;
import com.db.connectiontomysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderOp {
    Connection connection=new connectiontomysql().getConnection();//生成连接对象
    PreparedStatement pstmt;
    ResultSet rs;

    public boolean addOrder(Tb_Order tb_order){
        boolean flag=false;
        String insertsql="insert into orderList values(?,?,?,?,?,?,?,?,?,?)";
        try {
            pstmt=connection.prepareStatement(insertsql);
            pstmt.setString(1, tb_order.getOrderid());
            pstmt.setString(2, tb_order.getStartTime());
            pstmt.setString(3, tb_order.getOverTime());
            pstmt.setFloat(4, tb_order.getOrderPrice());
            pstmt.setString(5, tb_order.getOrderInformation());
            pstmt.setString(6, tb_order.getRiderName());
            pstmt.setString(7, tb_order.getShopName());
            pstmt.setString(8, tb_order.getUserEmail());
            pstmt.setString(9, tb_order.getUserName());
            pstmt.setString(10, tb_order.getOrderstate());
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


    //模糊查找获取数据,like字段
    public List getOrderById(String choice){
        List recordList = new ArrayList();
        String choice1 ="%"+choice+"%";
        String sql="select id,starttime" +
                ",overtime,price,information," +
                "ridername ,shopname,username,useremail ,orderstate from orderList  where id and username like ?";
        try{
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1,choice1);
            rs = pstmt.executeQuery();
            String orderid;
            String orderInformation;
            String orderState;
            float orderPrice;
            String startTime;
            String overTime;
            String shopName;
            String riderName;
            String username;
            String usermail;
            while(rs.next()){
                orderid=rs.getString(1);
                startTime=rs.getString(2);
                overTime=rs.getString(3);
                orderPrice=rs.getFloat(4);
                orderInformation =rs.getString(5);
                riderName=rs.getString(6);
                shopName=rs.getString(7);
                orderState=rs.getString(8);
                username=rs.getString(9);
                usermail=rs.getString(10);

                List row=new ArrayList();
                row.add(orderid);
                row.add(startTime);
                row.add(overTime);
                row.add(orderPrice);
                row.add(orderInformation);
                row.add(riderName);
                row.add(shopName);
                row.add(orderState);
                row.add(username);
                row.add(usermail);
                recordList.add(row);
            }

        }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return recordList;
    }
//    获取未完成的
    public List getNoHad(){
        List list = new ArrayList();
        String sql = "select * from orderlist where orderstate like '未完成'";
        try{
            pstmt = connection.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while(rs.next()){
                list.add(rs.getString(1));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }



}
