package com.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.Bean.Tb_stuinfo;
import com.Bean.Tb_record;
import com.db.connectiontomysql;
public class RecordOp {
	Connection connection=new connectiontomysql().getConnection();//�������Ӷ���
	PreparedStatement pstmt;
	ResultSet rs;

	//��ȡû�гɼ����б��ռ�¼��
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

	//ģ�����һ�ȡ����,like�ֶ�
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




	//�޸ĳɼ�
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



	public List getrealityRecord(){ //��ȡ�ѱ�д��ɼ�������
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
			int recordId;//���
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
				//�жϳɼ��Ƿ����0��
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

	public List getAllRecord(){ //��ȡ�ѱ�д��ɼ�������
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
			int recordId;//���
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
				//�жϳɼ��Ƿ����0��
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



	public int delRecordByStuIdCoursename(String stuid, String coursename) //ͨ��ѧ�š��γ�����ɾ��ѡ�μ�¼�����󷵻�-1
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

	public int getRecordNumByStuId(String stuid) //ͨ��ѧ�Ż�ȡѧ����ѡ�γ����������󷵻�-1
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
	//ͨ���γ����ֻ�ȡѡ�μ�¼
	public int getRecordByStuIdCoursename(String stu_id, String coursename) //ͨ��ѧ�š��γ�������ѯѧ���Ƿ���ѡ�ÿγ̣���ѯ��¼Ϊ�շ���0�����򷵻�1�����󷵻�-1
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

	public int addRecord(String stu_id, String coursename) //ͨ��ѧ�š��γ������ѡ����Ϣ�ɹ�����1�����򷵻�0
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

	public List getRecordByStuId(String stu_id) //ͨ��ѧ�Ż�ȡ��ѡ�γ��б�
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
