package com.db;

import java.sql.*;

public class Db {
	public Connection sqlcon;
	public Connection getConnection(){		
		//����������
				//String driver = "com.mysql.jdbc.Driver";
				//String driver="com.mysql.cj.jdbc.Driver";
				//URLָ��Ҫ���ʵ����ݿ���mydata
				String url = "jdbc:mysql://localhost:3306/studentsms";
				//String url="jdbc:mysql://localhost:3306/studentsms?characterEncoding=utf-8&serverTimezone=UTC";
				//MySQL����ʱ���û���
				String user = "root";
				//MySQL����ʱ������
				String password = "123456";
				//������ѯ�����
				try {
					//������������
					Class.forName("com.mysql.cj.jdbc.Driver");
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
		Connection connection=new Db().getConnection();
		System.out.println("ok");

	}

}
