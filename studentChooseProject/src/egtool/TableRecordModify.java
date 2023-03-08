package egtool;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import com.dao.RecordOp;

public class TableRecordModify extends DefaultTableModel {
	String stu_id;
	public TableRecordModify(){
		RecordOp ro = new RecordOp(); //创建一个成绩操作类对象
		List recordlist=ro.getAllRecord();//获取所有学生的这位同学的成绩列表
		String[] names = {"成绩编号","学生编号", "学生姓名","课程编号","课程名称","成绩"};
		String[][] data =new String[recordlist.size()][names.length];
		int count=0;
	    for(int row=0;row<recordlist.size();row++){
	    	count++;
//	    	Tb_course course =(Tb_course)recordlist.get(row);
	    	List rowList = (List)recordlist.get(row);
	    		    	
	    	data[row][0]=rowList.get(0)+"";
	    	data[row][1]=rowList.get(1)+"";
	    	data[row][2]=rowList.get(2)+"";	
	    	data[row][3]=rowList.get(3)+"";
	    	data[row][4]=rowList.get(4)+"";
			data[row][5]=rowList.get(5)+"";
	   	 }
	    this.setDataVector(data, names);
     }

}
