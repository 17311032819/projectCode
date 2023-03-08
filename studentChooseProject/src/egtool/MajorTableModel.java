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
		String[] majorNames = { "רҵ���", "רҵ����","רҵ����","��ϵ�绰"};//һά���鹹���ͷ
		String[][] majorData =new String[majorList.size()][majorNames.length];//��ά���鹹�����ݶ�ά��
		int count=0;
		
	    for(int row=0;row<majorList.size();row++){//row��ʾ������ֵ��0��ʼ
	    	count++;
	    	Tb_major major =(Tb_major)majorList.get(row);//��ȡһ��ת��ΪTb_major����
	    	//����ά���鸳ֵ
	    	majorData[row][0]=major.getmajorId();
	    	majorData[row][1]=major.getmajorName();
	    	majorData[row][2]=major.getmajorMaster();
	    	majorData[row][3]=major.getmajorMasterPhone();
	   	 }
	    this.setDataVector(majorData, majorNames);//ָ��һά���鼰��ά���������ģ��
	}

}
