package egtool;
import java.sql.SQLException;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import com.dao.RecordOp;

public  class TableModeByRequired extends DefaultTableModel {
    public TableModeByRequired(String requirement) throws SQLException{
        List list=new RecordOp().getsearchRecordList(requirement);
        String names[]={"�ɼ����","ѧ�����","ѧ������","�γ̱��","�γ�����","�ɼ�"};
        String Data[][]=new String[list.size()][names.length];
        for(int i=0;i<list.size();i++){
            List listRow=(List)list.get(i);
            Data[i][0]=listRow.get(0)+"";
            Data[i][1]=listRow.get(1)+"";
            Data[i][2]=listRow.get(2)+"";
            Data[i][3]=listRow.get(3)+"";
            Data[i][4]=listRow.get(4)+"";
            Data[i][5]=listRow.get(5)+"";
        }
        this.setDataVector(Data, names);
    }
}
