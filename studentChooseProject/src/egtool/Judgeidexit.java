package egtool;
import java.sql.*;

import com.db.connectiontomysql;


public class Judgeidexit {
	//判断专业编号是否存在，在添加专业时查重
	public boolean judgeMajorId(String majorId){
		boolean flag=true;
		try{
			Connection con=new connectiontomysql().getConnection();
			String sql="select * from tb_major where majorid=?";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1, majorId);
			ResultSet rSet=pstmt.executeQuery();
			if(rSet.next()){
				flag=false;
			}else{
				flag=true;
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return flag;
	}
	public boolean judgeStuId(String stuid){
		boolean flag=true;
		try{
			Connection con=new connectiontomysql().getConnection();
			String sql="select * from tb_stuinfo where stuid=?";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1, stuid);
			ResultSet rSet=pstmt.executeQuery();
			if(rSet.next()){
				flag=false;
			}else{
				flag=true;
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return flag;
		
	}
	public boolean judgeTeacherId(String teacherid){
		boolean flag=true;
		try{
			Connection con=new connectiontomysql().getConnection();
			String sql="select * from tb_teacher where teacherid=?";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1, teacherid);
			ResultSet rSet=pstmt.executeQuery();
			if(rSet.next()){
				flag=false;
			}else{
				flag=true;
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return flag;
		
	}
	public boolean judgeCourseId(String courseid){
		boolean flag=true;
		try{
			Connection con=new connectiontomysql().getConnection();
			String sql="select * from tb_course where courseId=?";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1, courseid);
			ResultSet rSet=pstmt.executeQuery();
			if(rSet.next()){
				flag=false;
			}else{
				flag=true;
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return flag;
		
	}
	public boolean judgeClassId(String classid){
		boolean flag=true;
		try{
			Connection con=new connectiontomysql().getConnection();
			String sql="select * from tb_class where classId=?";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1, classid);
			ResultSet rSet=pstmt.executeQuery();
			if(rSet.next()){
				flag=false;
			}else{
				flag=true;
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return flag;
	}

	public boolean judgename(String name){//查重用户
		boolean flag=true;
		try{
			Connection con=new connectiontomysql().getConnection();
			String sql="select * from tb_user where name=?";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1,name);
			ResultSet rSet=pstmt.executeQuery();
			if(rSet.next()){
				flag=false;
			}else{
				flag=true;
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return flag;
	}
}
