package com.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.Bean.Tb_stuinfo;
import com.db.connectiontomysql;
public class StuinfoOp {
	Connection connection=new connectiontomysql().getConnection();//生成连接对象
	PreparedStatement pstmt;
	ResultSet rs;
	//添加学生	
	public boolean addStu(Tb_stuinfo stuinfo){
		boolean flag=false;//标识变量，如是为真，表示添加课程成功
		String insertsql="insert into tb_stuinfo(stuId,stuName,stuSex,classId,stuPhone,stuQQ) values(?,?,?,?,?,?)";
		try {
			pstmt=connection.prepareStatement(insertsql);

			pstmt.setString(1,stuinfo.getstu_id());
			pstmt.setString(2,stuinfo.getstu_name());
			pstmt.setString(3,stuinfo.getstu_sex());
			pstmt.setString(4, stuinfo.getstu_classid());
			pstmt.setString(5, stuinfo.getstu_phone());
			pstmt.setString(6, stuinfo.getstu_QQ());

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

	//列表所有学生
	public List getallstus(){
		List list=new ArrayList();//ArrayList和LinkedList是List的两种实现类
		String sql="select tb_stuinfo.stuId,tb_stuinfo.stuName,"
				+ "tb_stuinfo.stuSex,tb_stuinfo.stuPhone,"
				+ "tb_class.className from tb_stuinfo,tb_class"
				+ " where tb_stuinfo.classId=tb_class.classId";//多表联合查询命令
		try{
			pstmt=connection.prepareStatement(sql);//生成数据库适配器
			rs=pstmt.executeQuery();//执行查询命令
			String stu_id;
			String stu_name;
			String stu_sex;
			String stu_phone;
			String stu_classname;
			//循环读取表格中所有数据，并且把班级编号转换为班级名称
			while(rs.next()){
				stu_id=rs.getString(1);
				stu_name=rs.getString(2);
				stu_sex=rs.getString(3);
				stu_phone=rs.getString(4);
				stu_classname=rs.getString(5);

				Tb_stuinfo stu=new Tb_stuinfo();//生成Tb_stuinfo对象
				stu.setstu_id(stu_id);
				stu.setstu_name(stu_name);
				stu.setstu_sex(stu_sex);
				stu.setstu_phone(stu_phone);
				stu.setstu_classname(stu_classname);//给对象赋值	
				list.add(stu);//添加进列表
			}
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return list;
	}
	//查询登录学生信息
	public Tb_stuinfo getStuByStuId(String stu_id){
		Tb_stuinfo stuinfo=new Tb_stuinfo();
		try{
			String sql="select * from tb_stuinfo where tb_stuinfo.stuId=?";
			pstmt=connection.prepareStatement(sql);
			pstmt.setString(1, stu_id);
			rs=pstmt.executeQuery();
			while(rs.next()){
				stuinfo.setstu_id(rs.getString(1));
				stuinfo.setstu_name(rs.getString(2));
				stuinfo.setstu_sex(rs.getString(3));
				stuinfo.setstu_phone(rs.getString(4));
				stuinfo.setstu_classid(rs.getString(5));
				stuinfo.setstu_password(rs.getString(6));
				stuinfo.setstu_QQ(rs.getString(7));
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return stuinfo;
	}


	//查询登录学生信息



	//修改学生信息
	public boolean modifyStuInfo(Tb_stuinfo stuInfo){
		int i=0;
		try{
			String updatesql="update tb_stuinfo set stuName=?,"
					+"stuSex=?,"
					+"stuPhone=?,"
					+"classId=?,"
					+"password=?"
					+" where stuId=?";
			pstmt=connection.prepareStatement(updatesql);

			pstmt.setString(1, stuInfo.getstu_name());
			pstmt.setString(2, stuInfo.getstu_sex());
			pstmt.setString(3, stuInfo.getstu_phone());
			pstmt.setString(4, stuInfo.getstu_classid());
			pstmt.setString(5, stuInfo.getstu_password());
			pstmt.setString(6, stuInfo.getstu_id());
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
	//删除学生信息
	public String deleteStuInfo(String stuId){
		String mString="";
		String delsql="delete from tb_stuinfo where stuId=?";
		try{
			pstmt=connection.prepareStatement(delsql);
			pstmt.setString(1, stuId);
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

	public String getNameById(String strClassId){
		String className="";
		String sql = "select className from tb_class where classId=?";
		try{
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1,strClassId);
			rs = pstmt.executeQuery();
			if(rs.next())
				className  =rs.getString(1);
		}catch(Exception e){
			e.printStackTrace();
		}
		return className;
	}
}
