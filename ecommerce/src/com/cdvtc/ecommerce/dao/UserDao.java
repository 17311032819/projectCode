package com.cdvtc.ecommerce.dao;

import com.cdvtc.ecommerce.connection.DbCon;
import com.cdvtc.ecommerce.model.User;

import java.sql.*;

public class UserDao {
    private Connection con;

    public UserDao() {
        this.con = DbCon.getConnection();
    }

    public User userLogin(String email, String password) {
        User user = null;
        try {
            String query = "select * from member where m_mail=? and m_password=?";
            PreparedStatement pst = this.con.prepareStatement(query);
            pst.setString(1, email);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setM_name(rs.getString("m_name"));
                user.setM_no(rs.getString("m_no"));
                user.setM_phone(rs.getString("m_phone"));
                user.setM_sex(rs.getString("m_sex"));
                user.setM_password(rs.getString("m_password"));
                user.setM_mail(rs.getString("m_mail"));
                user.setM_birth(rs.getDate("m_birth"));
            }

        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
        return user;
    }

    public boolean isUserExisted( String email) {
        try {
            //执行查询并返回结果集
            PreparedStatement pst = this.con.prepareStatement("select * from member where m_mail=?");
            pst.setString(1, email);

            ResultSet rs = pst.executeQuery();

            boolean result = rs.next(); //判断是否查询到数据

            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean addUser(User user) {
        try {
            //获取连接
            Connection con = DbCon.getConnection();

            //执行查询并返回结果集
            PreparedStatement pst = con.prepareStatement("insert into member( m_name, m_mail, m_phone, m_password,m_sex,m_birth) values(?, ?,?,?, ?, ?)");
            pst.setString(1, user.getM_name());
            pst.setString(2, user.getM_mail());
            pst.setString(3, user.getM_phone());
            pst.setString(4, user.getM_password());
            pst.setString(5,user.getM_sex());
            pst.setDate(6, new Date(user.getM_birth().getTime()));

            int result = pst.executeUpdate();

            //释放连接资源


            return result > 0; //大于0表示成功创建一行
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    public User getUserBymno(String m_no){
        User user=new User();
        String query="select * from member where m_no=?";
        try {
            PreparedStatement psmt=this.con.prepareStatement(query);
            psmt.setString(1,m_no);
            ResultSet rs=psmt.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setM_name(rs.getString("m_name"));
                user.setM_no(rs.getString("m_no"));
                user.setM_phone(rs.getString("m_phone"));
                user.setM_sex(rs.getString("m_sex"));
                user.setM_password(rs.getString("m_password"));
                user.setM_mail(rs.getString("m_mail"));
                user.setM_birth(rs.getDate("m_birth"));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return user;
    }

    public static void main(String[] args) {
        UserDao userDao=new UserDao();
        if (userDao.isUserExisted("2235498125@qq.com")){

        }
    }

}
