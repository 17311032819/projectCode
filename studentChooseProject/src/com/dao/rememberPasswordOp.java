package com.dao;
import com.Bean.Tb_major;
import com.Bean.TB_password;
import com.db.connectiontomysql;
import com.ui.StuAdd;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class rememberPasswordOp {
    Connection connection = new connectiontomysql().getConnection();//生成连接对象
    PreparedStatement pstmt;
    ResultSet rs;

    public boolean Addremember(TB_password tb_user) {
        boolean flag = false;//标识变量，如是为真，表示添加专业成功
        String insertsql = "insert into tb_user values(?,?)";
        try {
            pstmt = connection.prepareStatement(insertsql);

            pstmt.setString(1, tb_user.getRbname());
            pstmt.setString(2, tb_user.getRbpassword());


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
        String sql = "select name from tb_user";
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

    public String getIdByName(String name){
        String password="";
        String sql = "select password from tb_user where name=?";
        try{
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1,name);
            rs = pstmt.executeQuery();
            if(rs.next())
                password  =rs.getString(1);
        }catch(Exception e){
            e.printStackTrace();
        }
        return password;
    }

}
