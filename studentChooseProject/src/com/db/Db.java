package com.db;

import java.sql.*;

public class Db {
	public Connection sqlcon;
	public Connection getConnection(){		
		//驱动程序名
				//String driver = "com.mysql.jdbc.Driver";
				//String driver="com.mysql.cj.jdbc.Driver";
				//URL指向要访问的数据库名mydata
				String url = "jdbc:mysql://localhost:3306/studentsms";
				//String url="jdbc:mysql://localhost:3306/studentsms?characterEncoding=utf-8&serverTimezone=UTC";
				//MySQL配置时的用户名
				String user = "root";
				//MySQL配置时的密码
				String password = "123456";
				//遍历查询结果集
				try {
					//加载驱动程序
					Class.forName("com.mysql.cj.jdbc.Driver");
					//1.getConnection()方法，连接MySQL数据库！！
					sqlcon = DriverManager.getConnection(url,user,password);
					
					//con.useSSL=false
				}catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
						
					}
		return sqlcon;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection=new Db().getConnection();
		System.out.println("ok");

	}

}
