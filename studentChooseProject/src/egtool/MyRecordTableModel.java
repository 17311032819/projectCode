package egtool;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import com.Bean.Tb_course;
import com.dao.*;
public class MyRecordTableModel extends DefaultTableModel{
	String stu_id;
	public MyRecordTableModel(String stu_id){
		this.stu_id = stu_id;
		RecordOp ro = new RecordOp(); //创建一个成绩操作类对象
		List recordlist=ro.getRecordByStuId(stu_id); //获取stu_id这位同学的成绩列表
		String[] names = { "课程名称", "课程成绩", "课程学分"};
		String[][] data =new String[recordlist.size()][names.length];
		int count=0;
	    for(int row=0;row<recordlist.size();row++){
	    	count++;
//	    	Tb_course course =(Tb_course)recordlist.get(row);
	    	List rowList = (List)recordlist.get(row);
	    	
	    	
	    	data[row][0]=rowList.get(0)+"";
	    	data[row][1]=rowList.get(1)+"";
	    	data[row][2]=rowList.get(2)+"";	    	
	   	 }
	    this.setDataVector(data, names);
     }

}
