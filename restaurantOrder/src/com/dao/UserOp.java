package com.dao;

import com.Bean.Tb_user;
import com.db.connectiontomysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserOp {
	Connection connection=new connectiontomysql().getConnection();//�������Ӷ���
	PreparedStatement pstmt;
	ResultSet rs;
	//��Ӱ༶
	public boolean adduser(Tb_user tb_user){
		boolean flag=false;
		String insertsql="insert into tb_user values(?,?,?,?,?,?,?)";
		try {
				pstmt=connection.prepareStatement(insertsql);				
				pstmt.setString(1, tb_user.getUserName());
				pstmt.setString(2, tb_user.getUserPassword());
			    pstmt.setString(3, tb_user.getPhone());
			pstmt.setString(4, tb_user.getUserEmail());
			pstmt.setString(5, tb_user.getLocation1());
			pstmt.setString(6, tb_user.getLocation2());
			pstmt.setString(7, tb_user.getLocation3());

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

	public List getallusers(){//
		List list=new ArrayList();//ArrayList��LinkedList��List������ʵ����
		String sql="select username,userEmail,phone,location1,location2,location3 from tb_user "
				;//������ϲ�ѯ����
		try{
			pstmt=connection.prepareStatement(sql);//�������ݿ�������
			rs=pstmt.executeQuery();//ִ�в�ѯ����
			String username;
			String useremail;
			String phone;
			String location1;
			String location2;
			String location3;

			//ѭ����ȡ������������ݣ����ҰѰ༶���ת��Ϊ�༶����
			while(rs.next()){
				username=rs.getString(1);
				useremail=rs.getString(2);

				phone=rs.getString(3);
				location1=rs.getString(4);
				location2=rs.getString(5);
				location3=rs.getString(6);
				Tb_user tb_user=new Tb_user();//����Tb_stuinfo����
				tb_user.setUserName(username);
				tb_user.setUserEmail(useremail);
				tb_user.setUserEmail(phone);
				tb_user.setUserEmail(location1);
				tb_user.setUserEmail(location2);
				tb_user.setUserEmail(location3);
				//������ֵ
				list.add(tb_user);//��ӽ��б�
			}
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return list;
	}

	public String getUserNameByUserEmail(String userEmail){
		String userName="";
		String sql = "select userName from tb_user where userEmail=?";
		try{
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1,userEmail);
			rs = pstmt.executeQuery();
			if(rs.next())
				userName  =rs.getString(1);
		}catch(Exception e){
			e.printStackTrace();
		}
		return userName;
	}
	
	public boolean updateClass(String strClassId, Tb_user tb_user)
	{
		boolean flag=false;
		String  updatesql = "update tb_user set userName=?,userPassword=?,userEmail=? where userName=?";
		try{
			pstmt = connection.prepareStatement(updatesql);
			pstmt.setString(1, tb_user.getUserName());
			pstmt.setString(2, tb_user.getUserPassword());
			pstmt.setString(3, tb_user.getUserEmail());


			if(pstmt.executeUpdate()>0){
				flag=true;
			}
			else{
				flag=false;
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return flag;
	}
	
	//ɾ���༶
	public boolean deleteClass(String strClassId){
		boolean flag=false;
		String deletesql = "delete from tb_class where classId=?";
		try{
			pstmt=connection.prepareStatement(deletesql);
			pstmt.setString(1,strClassId);
			if(pstmt.executeUpdate()>0){
				flag=true;
			}else{
				flag=false;
			}		
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return flag;
	}

	
	
	//��ȡרҵ����
	public List getAllMajorsName(){
		List list = new ArrayList();
		String sql = "select majorName from tb_major";
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
	
	
	public String getIdByName(String strMajorName){
		String majorId="";
		String sql = "select majorId from tb_major where majorName=?";
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
	

}
