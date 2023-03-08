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
		String[] names = { "��ʦ���", "��ʦ����","����","����רҵ����"};//һά���鹹���ͷ
		String[][] data =new String[teacherList.size()][names.length];//��ά���鹹�����ݶ�ά��
		int count=0;
	    for(int row=0;row<teacherList.size();row++){//row��ʾ������ֵ��0��ʼ
	    	count++;
	    	Tb_teacher teacherInfo =(Tb_teacher)teacherList.get(row);//��ȡһ��ת��ΪTb_stuinfo����
	    	//����ά���鸳ֵ
	    	data[row][0]=teacherInfo.getTeacherId()+"";
	    	data[row][1]=teacherInfo.getTeacherName();
	    	data[row][2]=teacherInfo.getPassword();
	    	data[row][3]=teacherInfo.getMajorName();
	   	 }
	    this.setDataVector(data, names);//ָ��һά���鼰��ά���������ģ��
	}

}
