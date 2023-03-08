package com.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.Bean.Tb_class;
import com.Bean.Tb_course;
import com.db.connectiontomysql;

public class ClassOp {
	Connection connection=new connectiontomysql().getConnection();//生成连接对象
	PreparedStatement pstmt;
	ResultSet rs;
	//添加班级
	public boolean addClass(Tb_class tb_class){
		boolean flag=false;
		String insertsql="insert into tb_class values(?,?,?,?,?)";
		try {
				pstmt=connection.prepareStatement(insertsql);				
				pstmt.setString(1,tb_class.getclassid());
				pstmt.setString(2,tb_class.getclassname());
				pstmt.setString(3,tb_class.getclassteacher());
				pstmt.setString(4,tb_class.getmajorid());
				pstmt.setString(5,tb_class.getteacherphone());
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
	
	public boolean updateClass(String strClassId,Tb_class tb_class)
	{
		boolean flag=false;
		String  updatesql = "update tb_class set classId=?,className=?,classTeacher=?,majorId=?,classTeacherPhone=? where classId=?";
		try{
			pstmt = connection.prepareStatement(updatesql);
			pstmt.setString(1,tb_class.getclassid());
			pstmt.setString(2, tb_class.getclassname());
			pstmt.setString(3, tb_class.getclassteacher());
			pstmt.setString(4, tb_class.getmajorid());
			pstmt.setString(5, tb_class.getteacherphone());
			pstmt.setString(6, strClassId);
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
	
	//删除班级
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
	
	//获取所有班级
	public List<Tb_class> getallclass(){
		List<Tb_class> list=new ArrayList();
		try {
			String selectsql = "select classId,className,classTeacher,majorName,classTeacherPhone"
					+ "         from tb_class inner join tb_major on tb_class.majorId = tb_major.majorId";			
			pstmt=connection.prepareStatement(selectsql);
			rs=pstmt.executeQuery();			
			String classid;
			String classname;
			String classteacher;
			String majorName;
			String teacherphone;
			//循环取出课程记录，加入列表中
			while(rs.next()){
				classid=rs.getString(1);
				classname=rs.getString(2);
				classteacher=rs.getString(3);
				majorName = rs.getString(4);
				teacherphone=rs.getString(5);
				Tb_class tb_class=new Tb_class();
				tb_class.setclassid(classid);
				tb_class.setclassname(classname);
				tb_class.setclassteacher(classteacher);
				tb_class.setmajorName(majorName);
				tb_class.setteacherphone(teacherphone);				
				list.add(tb_class);
			}		
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return list;		
	}
	
	
	//获取专业名称
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
