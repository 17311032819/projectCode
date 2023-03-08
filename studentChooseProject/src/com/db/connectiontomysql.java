package com.db;

import java.sql.*;
public class connectiontomysql {
	public static Connection sqlcon;//声明连接对象
	public Connection getConnection(){
		//驱动程序名
		String driver = "com.mysql.cj.jdbc.Driver";
		//URL指向要访问的数据库名mydata
		String url = "jdbc:mysql://localhost:3306/student";
		//MySQL配置时的用户名
		String user = "root";
		//MySQL配置时的密码
		String password = "gengbeibei123";
		//遍历查询结果集
		try {
			//加载驱动程序
			Class.forName(driver);
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
		connectiontomysql ctosql=new connectiontomysql();
		sqlcon=ctosql.getConnection();
		//sqlcon=ctosql.getConnection();
		System.out.print("ok");
	}

}
