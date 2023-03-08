package com.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.Bean.Tb_stuinfo;
import com.Bean.Tb_record;
import com.db.connectiontomysql;
public class RecordOp {
	Connection connection=new connectiontomysql().getConnection();//生成连接对象
	PreparedStatement pstmt;
	ResultSet rs;

	//获取没有成绩的列表（空记录）
	public List getNullRecordList(){
		List recordList = new ArrayList();
		String sql="select tb_record.id,tb_record.stuId,"
				+ "tb_stuinfo.stuname,tb_record.courseId,"
				+ "tb_course.courseName,tb_record.record"
				+ " from tb_stuinfo,tb_course,tb_record"
				+ " where tb_record.stuId=tb_stuinfo.stuid"
				+ " and tb_record.courseId=tb_course.courseId"
				+ " and tb_record.record is null";
		try{
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();
			int recordId;
			String stuId;
			String stuName;
			String courseId;
			String courseName;
			int record;
			while(rs.next()){
				recordId=rs.getInt(1);
				stuId=rs.getString(2);
				stuName=rs.getString(3);
				courseId=rs.getString(4);
				courseName=rs.getString(5);
				record=rs.getInt(6);

				List row=new ArrayList();
				row.add(recordId);
				row.add(stuId);
				row.add(stuName);
				row.add(courseId);
				row.add(courseName);
				row.add(record);

				recordList.add(row);

			}

		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return recordList;
	}

	//模糊查找获取数据,like字段
	public List getsearchRecordList(String choice){
		List recordList = new ArrayList();
		String choice1 =choice+"%";
		String sql="select tb_record.id,tb_record.stuId,tb_stuinfo.stuname" +
				",tb_record.courseId,tb_course.courseName,tb_record.record " +
				"from tb_stuinfo,tb_course,tb_record where tb_record.courseId=tb_course.courseId and tb_stuinfo.stuid=tb_record.stuId " +
				" and tb_stuinfo.stuname like ?";
		try{
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1,choice1);
			rs = pstmt.executeQuery();
			int recordId;
			String stuId;
			String stuName;
			String courseId;
			String courseName;
			int record;
			while(rs.next()){
				recordId=rs.getInt(1);
				stuId=rs.getString(2);
				stuName=rs.getString(3);
				courseId=rs.getString(4);
				courseName=rs.getString(5);
				record=rs.getInt(6);

				List row=new ArrayList();
				row.add(recordId);
				row.add(stuId);
				row.add(stuName);
				row.add(courseId);
				row.add(courseName);
				row.add(record);
				recordList.add(row);
			}

		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return recordList;
	}




	//修改成绩
	public boolean modifyRecord(Tb_record record){
		boolean flag=false;
		String modifySql="update tb_record set stuId=?,courseId=?,record=? where id=?";
		try{
			pstmt=connection.prepareStatement(modifySql);
			pstmt.setString(1, record.getStuId());
			pstmt.setString(2, record.getCourseId());
			pstmt.setInt(3, record.getRecord());
			pstmt.setInt(4, record.getId());
			if(pstmt.executeUpdate()>0){
				flag=true;
			}else{
				flag=false;
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return flag;
	}



	public List getrealityRecord(){ //获取已被写入成绩的数据
		List recordList = new ArrayList();
		String sql="select tb_record.id,tb_record.stuId,"
				+ "tb_stuinfo.stuname,tb_record.courseId,"
				+ "tb_course.courseName,tb_record.record"
				+ " from tb_stuinfo,tb_course,tb_record"
				+ " where tb_record.stuId=tb_stuinfo.stuid"
				+ " and tb_record.courseId=tb_course.courseId"
				+ " and tb_record.record is not null";
		try{
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();
			int recordId;//编号
			String stuId;
			String stuName;
			String courseId;
			String courseName;
			int record;
			while(rs.next()){
				recordId=rs.getInt(1);
				stuId=rs.getString(2);
				stuName=rs.getString(3);
				courseId=rs.getString(4);
				courseName=rs.getString(5);
				record=rs.getInt(6);

				List row=new ArrayList();
				//判断成绩是否大于0，
				row.add(recordId);
				row.add(stuId);
				row.add(stuName);
				row.add(courseId);
				row.add(courseName);
				row.add(record);
				recordList.add(row);

			}

		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return recordList;
	}

	public List getAllRecord(){ //获取已被写入成绩的数据
		List recordList = new ArrayList();
		String sql="select tb_record.id,tb_record.stuId,"
				+ "tb_stuinfo.stuname,tb_record.courseId,"
				+ "tb_course.courseName,tb_record.record"
				+ " from tb_stuinfo,tb_course,tb_record"
				+ " where tb_record.stuId=tb_stuinfo.stuid"
				+ " and tb_record.courseId=tb_course.courseId"
				;
		try{
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();
			int recordId;//编号
			String stuId;
			String stuName;
			String courseId;
			String courseName;
			int record;
			while(rs.next()){
				recordId=rs.getInt(1);
				stuId=rs.getString(2);
				stuName=rs.getString(3);
				courseId=rs.getString(4);
				courseName=rs.getString(5);
				record=rs.getInt(6);

				List row=new ArrayList();
				//判断成绩是否大于0，
				row.add(recordId);
				row.add(stuId);
				row.add(stuName);
				row.add(courseId);
				row.add(courseName);
				row.add(record);
				recordList.add(row);

			}

		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return recordList;
	}



	public int delRecordByStuIdCoursename(String stuid, String coursename) //通过学号、课程名称删除选课记录，错误返回-1
	{
		String del = "DELETE FROM tb_record WHERE stuId = ? AND courseId = (SELECT courseId FROM tb_course WHERE tb_course.coursename = ?) ";
		try {
			pstmt = connection.prepareStatement(del);
			pstmt.setString(1, stuid);
			pstmt.setString(2, coursename);
			return pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
	}

	public int getRecordNumByStuId(String stuid) //通过学号获取学生已选课程数量，错误返回-1
	{
		String count = "SELECT * FROM tb_record WHERE stuId = ?";

		try {
			pstmt = connection.prepareStatement(count);
			pstmt.setString(1, stuid);


			rs = pstmt.executeQuery();
			int num = 0;
			while(rs.next())
			{
				num++;
			}
			return num;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}


	}
	//通过课程名字获取选课记录
	public int getRecordByStuIdCoursename(String stu_id, String coursename) //通过学号、课程姓名查询学生是否已选该课程，查询记录为空返回0，否则返回1，错误返回-1
	{
		String query = "SELECT * FROM tb_record WHERE stuId = ? AND courseId = (SELECT courseId FROM tb_course WHERE tb_course.coursename=?)";

		try {
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, stu_id);
			pstmt.setString(2, coursename);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				return 1;
			}else
			{
				return 0;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}



	}

	public int addRecord(String stu_id, String coursename) //通过学号、课程名添加选课信息成功返回1，否则返回0
	{
		String addQuery = "INSERT INTO tb_record (stuId, courseId) VALUES (?,(SELECT courseId FROM tb_course WHERE tb_course.coursename=?))";

		try {
			pstmt = connection.prepareStatement(addQuery);
			pstmt.setString(1, stu_id);
			pstmt.setString(2, coursename);
			int row = pstmt.executeUpdate();
			return row;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}



	}

	public List getRecordByStuId(String stu_id) //通过学号获取已选课程列表
	{
		List stuRec = new ArrayList();
		String query = "SELECT tb_course.coursename," +
				" tb_record.record,tb_course.coursecredit" +
				" FROM tb_record INNER JOIN tb_course " +
				"ON tb_record.courseId = tb_course.courseId " +
				"WHERE tb_record.stuId = ?";
		try {

			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, stu_id);
			rs = pstmt.executeQuery();
			String courseName;
			int courseRec;
			int courseCredit;
			while(rs.next())
			{
				courseName = rs.getString(1);
				courseRec = rs.getInt(2);
				courseCredit = rs.getInt(3);

				List row = new ArrayList();
				row.add(courseName);
				row.add(courseRec);
				row.add(courseCredit);

				stuRec.add(row);
			}


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return stuRec;
	}

}
