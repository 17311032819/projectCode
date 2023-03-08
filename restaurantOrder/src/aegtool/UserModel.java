package aegtool;

import com.Bean.Tb_user;
import com.dao.OrderOp;
import com.dao.UserOp;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class UserModel {
    public DefaultTableModel UserModel(){
        DefaultTableModel tableModel;
        UserOp userOp=new UserOp();

        List list=userOp.getallusers();
        String[] head={
                "用户姓名","用户邮箱"
        };
        String[][] Data =new String[list.size()][head.length];
        for(int i=0;i<list.size();i++){

            Tb_user tb_user= (Tb_user) list.get(i);
//            2021530211457   349.0

            Data[i][0]=tb_user.getUserName()+"";
            Data[i][1]=tb_user.getUserEmail()+"";
        }
        tableModel=new DefaultTableModel(Data,head);
        return tableModel;

    }
}
