package com.db;

import java.sql.*;
public class connectiontomysql {
	public static Connection sqlcon;//�������Ӷ���
	public Connection getConnection(){
		//����������
		String driver = "com.mysql.cj.jdbc.Driver";
		//URLָ��Ҫ���ʵ����ݿ���mydata
		String url = "jdbc:mysql://localhost:3306/student";
		//MySQL����ʱ���û���
		String user = "root";
		//MySQL����ʱ������
		String password = "gengbeibei123";
		//������ѯ�����
		try {
			//������������
			Class.forName(driver);
			//1.getConnection()����������MySQL���ݿ⣡��
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
