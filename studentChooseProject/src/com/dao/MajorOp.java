
//专业添加，管理
package com.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.Bean.Tb_course;
import com.Bean.Tb_major;
import com.Bean.Tb_stuinfo;
import com.db.connectiontomysql;
public class MajorOp {
	Connection connection=new connectiontomysql().getConnection();
	PreparedStatement pstmt;
	ResultSet rs;
	//添加专业	
	public boolean addMajor(Tb_major major){
		boolean flag=false;//标识变量，如是为真，表示添加专业成功
		String insertsql="insert into tb_major values(?,?,?,?)";
		try {
				pstmt=connection.prepareStatement(insertsql);
				
				pstmt.setString(1,major.getmajorId());
				pstmt.setString(2,major.getmajorName());
				pstmt.setString(3,major.getmajorMaster());
				pstmt.setString(4,major.getmajorMasterPhone());
				
				if(pstmt.executeUpdate()>0){//更新成功，影响的函数大于1行
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
	public Tb_major geMajorById(String majorId){
		Tb_major major=new Tb_major();
		String sql="select * from tb_major where majorId=?";
		try{
			pstmt=connection.prepareStatement(sql);
			pstmt.setString(1, majorId);
			rs=pstmt.executeQuery();
			while(rs.next()){
				major.setmajorId(rs.getString(1));
				major.setmajorName(rs.getString(2));
				major.setmajorMaster(rs.getString(3));
				major.setmajorMasterPhone(rs.getString(4));
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return major;
	}
	
	//列表所有专业信息
	public List getAllMajors(){		
		List list=new ArrayList();//ArrayList和LinkedList是List的两种实现类
		String sql="select * from tb_major";
		try{
			pstmt=connection.prepareStatement(sql);//生成数据库适配器
			rs=pstmt.executeQuery();//执行查询命令
			String majorId;
			String majorName;
			String majorMaster;
			String majorMasterPhone;
			//循环读取表格中所有数据
			while(rs.next()){//遍历下一条数据
				majorId=rs.getString(1);
				majorName=rs.getString(2);
				majorMaster=rs.getString(3);
				majorMasterPhone=rs.getString(4);

				Tb_major major=new Tb_major();//生成Tb_major对象
				major.setmajorId(majorId);
				major.setmajorName(majorName);
				major.setmajorMaster(majorMaster);
				major.setmajorMasterPhone(majorMasterPhone);

				list.add(major);//添加进列表
			}			
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}		
		return list;
	}
		
	//修改专业信息
	public boolean modifyMojor(Tb_major major){
		int i=0;
		try{
			String updatesql="update tb_major set majorName=?,"
					+"majorMaster=?,"
					+"majorMasterPhone=?"
					+" where majorId=?";						
			pstmt=connection.prepareStatement(updatesql);
			
			pstmt.setString(1, major.getmajorName());
			pstmt.setString(2, major.getmajorMaster());
			pstmt.setString(3, major.getmajorMasterPhone());
			pstmt.setString(4, major.getmajorId());
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
	//删除专业信息
	public String deleteMajor(Tb_major major){
		String mString="";
		boolean flag=true;
		String selectsql="select * from tb_class where majorid=?";
		try{
			pstmt=connection.prepareStatement(selectsql);
			pstmt.setString(1, major.getmajorId());
			rs=pstmt.executeQuery();
			while(rs.next()){
				flag=false;
				mString="要删除的专业下存在班级，不能删除，抱歉！";
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		if(flag){
			String delsql="delete from tb_major where majorId=?";
			try{
				pstmt=connection.prepareStatement(delsql);
				pstmt.setString(1, major.getmajorId());
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
		}
		return mString;
	}
}
