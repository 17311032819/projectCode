package egtool;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import com.Bean.Tb_course;
import com.Bean.Tb_stuinfo;
import com.dao.CourseOp;
import com.dao.StuinfoOp;

public class StuTableModel extends DefaultTableModel {
	public StuTableModel(){
		this.updateModel();
	}
	
	public void updateModel() {
		StuinfoOp stuinfoOp=new StuinfoOp();
		List courselist=stuinfoOp.getallstus();
		String[] names = { "学生编号", "学生姓名","学生性别","学生电话","学生班级"};//一维数组构造表头
		String[][] data =new String[courselist.size()][names.length];//二维数组构建数据二维表
		int count=0;
	    for(int row=0;row<courselist.size();row++){//row表示行索引值从0开始
	    	count++;
	    	Tb_stuinfo stuinfo =(Tb_stuinfo)courselist.get(row);//获取一行转换为Tb_stuinfo对象
	    	//给二维数组赋值
	    	data[row][0]=stuinfo.getstu_id()+"";
	    	data[row][1]=stuinfo.getstu_name();
	    	data[row][2]=stuinfo.getstu_sex();
	    	data[row][3]=stuinfo.getstu_phone();
	    	data[row][4]=stuinfo.getstu_classname();
	   	 }
	    this.setDataVector(data, names);//指定一维数组及二维数组给数据模板
	}

}
