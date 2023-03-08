package com.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.Bean.Tb_teacher;
import com.db.connectiontomysql;
public class TeacherOp {
	Connection connection=new connectiontomysql().getConnection();//生成连接对象
	PreparedStatement pstmt;
	ResultSet rs;
	//添加教师
	public boolean addTeacher(Tb_teacher teacherInfo){
		boolean flag=false;//标识变量，如是为真，表示添加教师成功
		String insertsql="insert into tb_teacher(teacherId,teacherName,password,majorId,teacherQQ) values(?,?,?,?,?)";
		try {
			pstmt=connection.prepareStatement(insertsql);

			pstmt.setString(1,teacherInfo.getTeacherId());
			pstmt.setString(2,teacherInfo.getTeacherName());
			pstmt.setString(3,teacherInfo.getPassword());
			pstmt.setString(4,teacherInfo.getMajorId());
			pstmt.setString(5,teacherInfo.getMajorQQ());

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

	//列表所有教师
	public List getAllTeacher(){
		List list=new ArrayList();//ArrayList和LinkedList是List的两种实现类
		String sql="select tb_teacher.teacherId,tb_teacher.teacherName,"
				+ "tb_teacher.password,tb_teacher.majorId,"
				+ "tb_major.majorName,tb_teacher.teacherQQ,from tb_teacher,tb_major"
				+ " where tb_teacher.majorId=tb_major.majorId";//多表联合查询命令
		try{
			pstmt=connection.prepareStatement(sql);//生成数据库适配器
			rs=pstmt.executeQuery();//执行查询命令
			String teacherId;
			String teacherName;
			String password;
			String majorId;
			String majorName;
			//循环读取表格中所有数据，并且把专业编号转换为专业名称
			while(rs.next()){
				teacherId=rs.getString(1);
				teacherName=rs.getString(2);
				password=rs.getString(3);
				majorId=rs.getString(4);
				majorName=rs.getString(5);

				Tb_teacher teacher=new Tb_teacher();//生成Tb_teachr对象
				teacher.setTeacherId(teacherId);;
				teacher.setTeacherName(teacherName);;
				teacher.setPassword(password);;
				teacher.setMajorId(majorId);;
				teacher.setMajorName(majorName);;//给对象赋值	
				list.add(teacher);//添加进列表
			}
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return list;
	}
	//按老师编号查询老师信息
	public Tb_teacher getTeacherInfoById(String teacherId){
		Tb_teacher teacher=new Tb_teacher();
		String sql="select tb_teacher.teacherId,tb_teacher.teacherName,"
				+ "tb_teacher.password,tb_teacher.majorId,"
				+ "tb_major.majorName ,tb_teacher.teacherQQ from tb_teacher,tb_major"
				+ " where tb_teacher.majorId=tb_major.majorId and tb_teacher.teacherId=?";
		try{
			pstmt=connection.prepareStatement(sql);
			pstmt.setString(1, teacherId);
			rs=pstmt.executeQuery();
			while(rs.next()){
				teacher.setTeacherId(rs.getString(1));
				teacher.setTeacherName(rs.getString(2));
				teacher.setPassword(rs.getString(3));
				teacher.setMajorId(rs.getString(4));
				teacher.setMajorName(rs.getString(5));
				teacher.setMajorQQ(rs.getString(6));
			}

		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return teacher;
	}

	//修改教师信息
	public boolean modifyTeacher(Tb_teacher teacherInfo){
		int i=0;
		try{
			String updatesql="update tb_teacher set teacherName=?,"
					+"password=?,"
					+"majorId=?"
					+" where teacherId=?";
			pstmt=connection.prepareStatement(updatesql);

			pstmt.setString(1, teacherInfo.getTeacherName());
			pstmt.setString(2, teacherInfo.getPassword());
			pstmt.setString(3, teacherInfo.getMajorId());
			pstmt.setString(4, teacherInfo.getTeacherId());
			i=pstmt.executeUpdate();
		}catch (Exception e) {
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
	//删除教师信息
	public String deleteTeacher(String teacherId){
		String mString="";
		String delsql="delete from tb_teacher where teacherId=?";
		try{
			pstmt=connection.prepareStatement(delsql);
			pstmt.setString(1,teacherId);
			int i=pstmt.executeUpdate();
			if(i>0){
				mString="删除成功！";
			}else{
				mString="删除失败！";
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return mString;
	}

}
