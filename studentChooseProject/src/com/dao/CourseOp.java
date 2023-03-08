package com.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.Bean.Tb_course;
import com.db.connectiontomysql;
import com.ui.CourseAdd;

public class CourseOp {
	Connection connection=new connectiontomysql().getConnection();//生成连接对象
	PreparedStatement pstmt;
	ResultSet rs;
	//添加课程
	
	public boolean addCourse(Tb_course course){
		boolean flag=false;//标识变量，如是为真，表示添加课程成功
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
	
	//获取所有课程列表
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
			//循环取出课程记录，加入列表中
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
	//按学分条件查询课程
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
			//循环取出课程记录，加入列表中
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
	//按课程名称模糊查询
	public List getcoursebyname(String cname){
		List list=new ArrayList();
		//添加模糊查询
		
		return list;
	}
	//修改课程信息
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
	//删除课程信息
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
