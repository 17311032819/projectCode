package com.dao;
import com.Bean.Tb_password;
import com.db.connectiontomysql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RememberPasswordOp {
    Connection connection = new connectiontomysql().getConnection();//生成连接对象
    PreparedStatement pstmt;
    ResultSet rs;

    public boolean Addremember(Tb_password tb_password) {
        boolean flag = false;//标识变量，如是为真，表示添加专业成功
        String insertsql = "insert into userrememberpassword values(?,?)";
        try {
            pstmt = connection.prepareStatement(insertsql);

            pstmt.setString(1, tb_password.getUserEmail());
            pstmt.setString(2, tb_password.getUserpassword());
            if (pstmt.executeUpdate() > 0) {
                flag = true;
            } else {
                flag = false;
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return flag;
    }

    public List getuser() {
        List list = new ArrayList();
        String sql = "select userEmail from userrememberpassword";
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

    public String getPasswordByUserEmail(String userEmail){
        String password="";
        String sql = "select userpassword from userrememberpassword where userEmail=?";
        try{
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1,userEmail);
            rs = pstmt.executeQuery();
            if(rs.next())
                password  =rs.getString(1);
        }catch(Exception e){
            e.printStackTrace();
        }
        return password;
    }
    public String getPasswordByUserEmail2(String userEmail){
        String password="";
        String sql = "select userpassword from tb_user where userEmail=?";
        try{
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1,userEmail);
            rs = pstmt.executeQuery();
            if(rs.next())
                password  =rs.getString(1);
        }catch(Exception e){
            e.printStackTrace();
        }
        return password;
    }

}
