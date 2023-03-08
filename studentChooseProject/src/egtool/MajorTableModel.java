package egtool;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import com.Bean.Tb_major;
import com.Bean.Tb_stuinfo;
import com.dao.MajorOp;
import com.dao.StuinfoOp;

public class MajorTableModel extends DefaultTableModel{
	public MajorTableModel(){
		MajorOp majorOp=new MajorOp();
		List majorList=majorOp.getAllMajors();
		String[] majorNames = { "专业编号", "专业名称","专业主任","联系电话"};//一维数组构造表头
		String[][] majorData =new String[majorList.size()][majorNames.length];//二维数组构建数据二维表
		int count=0;
		
	    for(int row=0;row<majorList.size();row++){//row表示行索引值从0开始
	    	count++;
	    	Tb_major major =(Tb_major)majorList.get(row);//获取一行转换为Tb_major对象
	    	//给二维数组赋值
	    	majorData[row][0]=major.getmajorId();
	    	majorData[row][1]=major.getmajorName();
	    	majorData[row][2]=major.getmajorMaster();
	    	majorData[row][3]=major.getmajorMasterPhone();
	   	 }
	    this.setDataVector(majorData, majorNames);//指定一维数组及二维数组给数据模板
	}

}
