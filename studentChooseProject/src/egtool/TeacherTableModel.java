package egtool;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import com.Bean.Tb_teacher;
import com.dao.TeacherOp;

public class TeacherTableModel extends DefaultTableModel {
	public TeacherTableModel(){
		this.updateModel();
	}
	
	public void updateModel() {
		TeacherOp teacherOp=new TeacherOp();
		List teacherList=teacherOp.getAllTeacher();
		String[] names = { "教师编号", "教师姓名","密码","所属专业名称"};//一维数组构造表头
		String[][] data =new String[teacherList.size()][names.length];//二维数组构建数据二维表
		int count=0;
	    for(int row=0;row<teacherList.size();row++){//row表示行索引值从0开始
	    	count++;
	    	Tb_teacher teacherInfo =(Tb_teacher)teacherList.get(row);//获取一行转换为Tb_stuinfo对象
	    	//给二维数组赋值
	    	data[row][0]=teacherInfo.getTeacherId()+"";
	    	data[row][1]=teacherInfo.getTeacherName();
	    	data[row][2]=teacherInfo.getPassword();
	    	data[row][3]=teacherInfo.getMajorName();
	   	 }
	    this.setDataVector(data, names);//指定一维数组及二维数组给数据模板
	}

}
