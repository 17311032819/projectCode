package egtool;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import com.dao.RecordOp;

public class TableRecordModify extends DefaultTableModel {
	String stu_id;
	public TableRecordModify(){
		RecordOp ro = new RecordOp(); //����һ���ɼ����������
		List recordlist=ro.getAllRecord();//��ȡ����ѧ������λͬѧ�ĳɼ��б�
		String[] names = {"�ɼ����","ѧ�����", "ѧ������","�γ̱��","�γ�����","�ɼ�"};
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
