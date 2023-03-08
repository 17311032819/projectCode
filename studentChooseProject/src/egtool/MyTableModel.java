package egtool;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import com.Bean.Tb_course;
import com.dao.*;

public class MyTableModel extends DefaultTableModel {
	public MyTableModel(){
		CourseOp co=new CourseOp();
		List courselist=co.getAllcourse();
		String[] names = { "课程编号", "课程名称", "课程学分"};
		String[][] data =new String[courselist.size()][names.length];
		int count=0;
	    for(int row=0;row<courselist.size();row++){
	    	count++;
	    	Tb_course course =(Tb_course)courselist.get(row);
	    	
	    	data[row][0]=course.getcourseid()+"";
	    	data[row][1]=course.getcoursename().trim();
	    	data[row][2]=course.getcoursecredit()+"";	    	
	   	 }
	    this.setDataVector(data, names);
     }
}
