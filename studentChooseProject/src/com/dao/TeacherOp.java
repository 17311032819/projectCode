package com.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.Bean.Tb_teacher;
import com.db.connectiontomysql;
public class TeacherOp {
	Connection connection=new connectiontomysql().getConnection();//�������Ӷ���
	PreparedStatement pstmt;
	ResultSet rs;
	//��ӽ�ʦ
	public boolean addTeacher(Tb_teacher teacherInfo){
		boolean flag=false;//��ʶ����������Ϊ�棬��ʾ��ӽ�ʦ�ɹ�
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

	//�б����н�ʦ
	public List getAllTeacher(){
		List list=new ArrayList();//ArrayList��LinkedList��List������ʵ����
		String sql="select tb_teacher.teacherId,tb_teacher.teacherName,"
				+ "tb_teacher.password,tb_teacher.majorId,"
				+ "tb_major.majorName,tb_teacher.teacherQQ,from tb_teacher,tb_major"
				+ " where tb_teacher.majorId=tb_major.majorId";//������ϲ�ѯ����
		try{
			pstmt=connection.prepareStatement(sql);//�������ݿ�������
			rs=pstmt.executeQuery();//ִ�в�ѯ����
			String teacherId;
			String teacherName;
			String password;
			String majorId;
			String majorName;
			//ѭ����ȡ������������ݣ����Ұ�רҵ���ת��Ϊרҵ����
			while(rs.next()){
				teacherId=rs.getString(1);
				teacherName=rs.getString(2);
				password=rs.getString(3);
				majorId=rs.getString(4);
				majorName=rs.getString(5);

				Tb_teacher teacher=new Tb_teacher();//����Tb_teachr����
				teacher.setTeacherId(teacherId);;
				teacher.setTeacherName(teacherName);;
				teacher.setPassword(password);;
				teacher.setMajorId(majorId);;
				teacher.setMajorName(majorName);;//������ֵ	
				list.add(teacher);//��ӽ��б�
			}
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return list;
	}
	//����ʦ��Ų�ѯ��ʦ��Ϣ
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

	//�޸Ľ�ʦ��Ϣ
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
	//ɾ����ʦ��Ϣ
	public String deleteTeacher(String teacherId){
		String mString="";
		String delsql="delete from tb_teacher where teacherId=?";
		try{
			pstmt=connection.prepareStatement(delsql);
			pstmt.setString(1,teacherId);
			int i=pstmt.executeUpdate();
			if(i>0){
				mString="ɾ���ɹ���";
			}else{
				mString="ɾ��ʧ�ܣ�";
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return mString;
	}

}
