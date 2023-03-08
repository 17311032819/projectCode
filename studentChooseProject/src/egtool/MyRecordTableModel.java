package egtool;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import com.Bean.Tb_course;
import com.dao.*;
public class MyRecordTableModel extends DefaultTableModel{
	String stu_id;
	public MyRecordTableModel(String stu_id){
		this.stu_id = stu_id;
		RecordOp ro = new RecordOp(); //����һ���ɼ����������
		List recordlist=ro.getRecordByStuId(stu_id); //��ȡstu_id��λͬѧ�ĳɼ��б�
		String[] names = { "�γ�����", "�γ̳ɼ�", "�γ�ѧ��"};
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
