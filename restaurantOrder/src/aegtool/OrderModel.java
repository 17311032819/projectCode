package aegtool;

import com.Bean.Tb_Order;
import com.Bean.Tb_food;
import com.dao.FoodOp;
import com.dao.OrderOp;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class OrderModel {
    public DefaultTableModel OrderModelPackage(){
        DefaultTableModel tableModel;

        FoodOp foodOp=new FoodOp();
        List courselist=foodOp.getFoodPackage();
        String[] head = { "食品名称", "食品价格", "食品介绍","商家名称","商家邮箱","商家电话"};
        String[][] data =new String[courselist.size()][head.length];
        int count=0;
        for(int row=0;row<courselist.size();row++){
            count++;
            Tb_food tb_food =(Tb_food) courselist.get(row);

            data[row][0]=tb_food.getFoodName()+"";
            data[row][1]= String.valueOf(tb_food.getCostPrice());
            data[row][2]=tb_food.getIntroduce()+"";
            data[row][3]=tb_food.getShopName()+"";
            data[row][4]=tb_food.getEmail()+"";
            data[row][5]=tb_food.getPhone()+"";
        }
        tableModel=new DefaultTableModel(data,head);
        return tableModel;

    }
    public DefaultTableModel OrderModelLeisureSnack(){
        DefaultTableModel tableModel;

        FoodOp foodOp=new FoodOp();
        List courselist=foodOp.getFoodLeisureSnack();
        String[] head = { "食品名称", "食品价格", "食品介绍","商家名称","商家邮箱","商家电话"};
        String[][] data =new String[courselist.size()][head.length];
        int count=0;
        for(int row=0;row<courselist.size();row++){
            count++;
            Tb_food tb_food =(Tb_food) courselist.get(row);

            data[row][0]=tb_food.getFoodName()+"";
            data[row][1]= String.valueOf(tb_food.getCostPrice());
            data[row][2]=tb_food.getIntroduce()+"";
            data[row][3]=tb_food.getShopName()+"";
            data[row][4]=tb_food.getEmail()+"";
            data[row][5]=tb_food.getPhone()+"";
        }
        tableModel=new DefaultTableModel(data,head);
        return tableModel;

    }public DefaultTableModel OrderModelColorDrinks(){
        DefaultTableModel tableModel;

        FoodOp foodOp=new FoodOp();
        List courselist=foodOp.getFoodLeisureSnack();
        String[] head = { "食品名称", "食品价格", "食品介绍","商家名称","商家邮箱","商家电话"};
        String[][] data =new String[courselist.size()][head.length];
        int count=0;
        for(int row=0;row<courselist.size();row++){
            count++;
            Tb_food tb_food =(Tb_food) courselist.get(row);

            data[row][0]=tb_food.getFoodName()+"";
            data[row][1]= String.valueOf(tb_food.getCostPrice());
            data[row][2]=tb_food.getIntroduce()+"";
            data[row][3]=tb_food.getShopName()+"";
            data[row][4]=tb_food.getEmail()+"";
            data[row][5]=tb_food.getPhone()+"";
        }
        tableModel=new DefaultTableModel(data,head);
        return tableModel;

    }
    public DefaultTableModel OrderModelSweet(){
        DefaultTableModel tableModel;

        FoodOp foodOp=new FoodOp();
        List courselist=foodOp.getFoodSweet();
        String[] head = { "食品名称", "食品价格", "食品介绍","商家名称","商家邮箱","商家电话"};
        String[][] data =new String[courselist.size()][head.length];
        int count=0;
        for(int row=0;row<courselist.size();row++){
            count++;
            Tb_food tb_food =(Tb_food) courselist.get(row);

            data[row][0]=tb_food.getFoodName()+"";
            data[row][1]= String.valueOf(tb_food.getCostPrice());
            data[row][2]=tb_food.getIntroduce()+"";
            data[row][3]=tb_food.getShopName()+"";
            data[row][4]=tb_food.getEmail()+"";
            data[row][5]=tb_food.getPhone()+"";
        }
        tableModel=new DefaultTableModel(data,head);
        return tableModel;

    }

    public DefaultTableModel OrderModelAdmin(String id){
        DefaultTableModel tableModel;
        OrderOp orderOp=new OrderOp();

        List list=orderOp.getOrderById(id);
        String[] head={
                "订单编号","下单时间","送到时间","订单金额","订单内容","骑手名称","商家名称","订单状态","用户姓名","用户邮箱"
        };
        String[][] Data =new String[list.size()][head.length];
        for(int i=0;i<list.size();i++){

//            2021530211457   349.
            List listRow= (List) list.get(i);
            Data[i][0]=listRow.get(0)+"";
            Data[i][1]=listRow.get(1)+"";
            Data[i][2]=listRow.get(2)+"";
            Data[i][3]=listRow.get(3)+"";
            Data[i][4]=listRow.get(4)+"";
            Data[i][5]=listRow.get(5)+"";
            Data[i][6]=listRow.get(6)+"";
            Data[i][7]=listRow.get(9)+"";
            Data[i][8]=listRow.get(7)+"";
            Data[i][9]=listRow.get(8)+"";

        }
        tableModel=new DefaultTableModel(Data,head);
        return tableModel;

    }


}
