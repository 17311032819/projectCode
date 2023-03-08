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
		String[] names = { "ѧ�����", "ѧ������","ѧ���Ա�","ѧ���绰","ѧ���༶"};//һά���鹹���ͷ
		String[][] data =new String[courselist.size()][names.length];//��ά���鹹�����ݶ�ά��
		int count=0;
	    for(int row=0;row<courselist.size();row++){//row��ʾ������ֵ��0��ʼ
	    	count++;
	    	Tb_stuinfo stuinfo =(Tb_stuinfo)courselist.get(row);//��ȡһ��ת��ΪTb_stuinfo����
	    	//����ά���鸳ֵ
	    	data[row][0]=stuinfo.getstu_id()+"";
	    	data[row][1]=stuinfo.getstu_name();
	    	data[row][2]=stuinfo.getstu_sex();
	    	data[row][3]=stuinfo.getstu_phone();
	    	data[row][4]=stuinfo.getstu_classname();
	   	 }
	    this.setDataVector(data, names);//ָ��һά���鼰��ά���������ģ��
	}

}
