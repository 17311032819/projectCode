package com.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.Bean.Tb_stuinfo;
import com.db.connectiontomysql;
public class StuinfoOp {
	Connection connection=new connectiontomysql().getConnection();//�������Ӷ���
	PreparedStatement pstmt;
	ResultSet rs;
	//���ѧ��	
	public boolean addStu(Tb_stuinfo stuinfo){
		boolean flag=false;//��ʶ����������Ϊ�棬��ʾ��ӿγ̳ɹ�
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

	//�б�����ѧ��
	public List getallstus(){
		List list=new ArrayList();//ArrayList��LinkedList��List������ʵ����
		String sql="select tb_stuinfo.stuId,tb_stuinfo.stuName,"
				+ "tb_stuinfo.stuSex,tb_stuinfo.stuPhone,"
				+ "tb_class.className from tb_stuinfo,tb_class"
				+ " where tb_stuinfo.classId=tb_class.classId";//������ϲ�ѯ����
		try{
			pstmt=connection.prepareStatement(sql);//�������ݿ�������
			rs=pstmt.executeQuery();//ִ�в�ѯ����
			String stu_id;
			String stu_name;
			String stu_sex;
			String stu_phone;
			String stu_classname;
			//ѭ����ȡ������������ݣ����ҰѰ༶���ת��Ϊ�༶����
			while(rs.next()){
				stu_id=rs.getString(1);
				stu_name=rs.getString(2);
				stu_sex=rs.getString(3);
				stu_phone=rs.getString(4);
				stu_classname=rs.getString(5);

				Tb_stuinfo stu=new Tb_stuinfo();//����Tb_stuinfo����
				stu.setstu_id(stu_id);
				stu.setstu_name(stu_name);
				stu.setstu_sex(stu_sex);
				stu.setstu_phone(stu_phone);
				stu.setstu_classname(stu_classname);//������ֵ	
				list.add(stu);//��ӽ��б�
			}
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return list;
	}
	//��ѯ��¼ѧ����Ϣ
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


	//��ѯ��¼ѧ����Ϣ



	//�޸�ѧ����Ϣ
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
	//ɾ��ѧ����Ϣ
	public String deleteStuInfo(String stuId){
		String mString="";
		String delsql="delete from tb_stuinfo where stuId=?";
		try{
			pstmt=connection.prepareStatement(delsql);
			pstmt.setString(1, stuId);
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
