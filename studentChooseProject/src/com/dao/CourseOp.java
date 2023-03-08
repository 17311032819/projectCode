package com.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.Bean.Tb_course;
import com.db.connectiontomysql;
import com.ui.CourseAdd;

public class CourseOp {
	Connection connection=new connectiontomysql().getConnection();//�������Ӷ���
	PreparedStatement pstmt;
	ResultSet rs;
	//��ӿγ�
	
	public boolean addCourse(Tb_course course){
		boolean flag=false;//��ʶ����������Ϊ�棬��ʾ��ӿγ̳ɹ�
		String insertsql="insert into tb_course values(?,?,?)";
		try {
				pstmt=connection.prepareStatement(insertsql);				
				pstmt.setString(1,course.getcourseid());
				pstmt.setString(2,course.getcoursename());
				pstmt.setInt(3,course.getcoursecredit());				
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
	
	//��ȡ���пγ��б�
	public List getAllcourse() {
		
		List list = new ArrayList();
		try {
			String selectsql = "select * from tb_course";			
			pstmt=connection.prepareStatement(selectsql);
			//pstmt.setInt(1, cc);
			rs=pstmt.executeQuery();			
			String courseid;
			String coursename;
			int coursecredit;
			//ѭ��ȡ���γ̼�¼�������б���
			while(rs.next()){
				courseid=rs.getString(1);
				coursename=rs.getString(2);
				coursecredit=rs.getInt(3);				
				Tb_course course=new Tb_course();
				course.setcourseid(courseid);
				course.setcoursename(coursename);
				course.setcoursecredit(coursecredit);
				
				list.add(course);
			}		
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	//��ѧ��������ѯ�γ�
	public List getcoursebycredit(int cc){
		List list = new ArrayList();
		try {
			String selectsql = "select * from tb_course where coursecredit=?";			
			pstmt=connection.prepareStatement(selectsql);
			pstmt.setInt(1, cc);
			rs=pstmt.executeQuery();			
			String courseid;
			String coursename;
			int coursecredit;
			//ѭ��ȡ���γ̼�¼�������б���
			while(rs.next()){
				courseid=rs.getString(1);
				coursename=rs.getString(2);
				coursecredit=rs.getInt(3);				
				Tb_course course=new Tb_course();
				course.setcourseid(courseid);
				course.setcoursename(coursename);
				course.setcoursecredit(coursecredit);
				
				list.add(course);
			}		
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		
	}
	//���γ�����ģ����ѯ
	public List getcoursebyname(String cname){
		List list=new ArrayList();
		//���ģ����ѯ
		
		return list;
	}
	//�޸Ŀγ���Ϣ
	public boolean modifycourse(Tb_course course){
		int i=0;
		try{
			String updatesql="update tb_course set coursename=?,"
					+"coursecredit=?"
					+" where courseid=?";						
			pstmt=connection.prepareStatement(updatesql);
			
			pstmt.setString(1, course.getcoursename());
			pstmt.setInt(2, course.getcoursecredit());
			pstmt.setString(3, course.getcourseid());
			i=pstmt.executeUpdate();
			}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			if(i>0){
				return true;
			}
			else {
				return false;
			}
	}
	//ɾ���γ���Ϣ
	public boolean deletecourse(Tb_course course){
		boolean flag=false;
		int i;
		String delsql="delete from tb_course where courseid=?";
		try{
			pstmt=connection.prepareStatement(delsql);
			pstmt.setString(1, course.getcourseid());
			i=pstmt.executeUpdate();
			if(i>0){
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
	
}
