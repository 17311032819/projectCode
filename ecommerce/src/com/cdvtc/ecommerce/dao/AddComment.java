package com.cdvtc.ecommerce.dao;

import com.cdvtc.ecommerce.connection.DbCon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddComment {

    private Connection con;


    public AddComment() {
        this.con = DbCon.getConnection();
    }

    public boolean updateComment(String ono, String comment) {
        boolean flag=false;
        try {
            String query = "update details set comment=? where o_no=?";
            //执行查询并返回结果集
            PreparedStatement pst = this.con.prepareStatement(query);
            pst.setString(1, comment);
            pst.setString(2, ono);
            if (pst.executeUpdate()>0){
                flag=true;
            }
            else {
                flag=false;
            }


            //释放连接资源
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.print(e.getMessage());
        }
        return flag;
    }

}
