package com.dao;

import com.db.connectiontomysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class GetBackPasswordOp {
    Connection connection=new connectiontomysql().getConnection();//生成连接对象
    PreparedStatement pstmt;
    ResultSet rs;

    public String getIdByName(String strMajorName){
        String majorId="";
        String sql = "select password from tb_stuinfo where stuid=?";
        try{
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1,strMajorName);
            rs = pstmt.executeQuery();
            if(rs.next())
                majorId  =rs.getString(1);
        }catch(Exception e){
            e.printStackTrace();
        }
        return majorId;
    }

    public String getIdByName2(String strTeacherName){
        String majorId="";
        String sql = "select password from tb_teacher where teacherid=?";
        try{
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1,strTeacherName);
            rs = pstmt.executeQuery();
            if(rs.next())
                majorId  =rs.getString(1);
        }catch(Exception e){
            e.printStackTrace();
        }
        return majorId;
    }
}
