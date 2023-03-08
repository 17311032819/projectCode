package com.ui.User;

import aegtool.FontSize;
import aegtool.OrderModel;
import com.Bean.Tb_Order;
import com.dao.OrderOp;
import com.dao.UserOp;
import aegtool.ImageEg;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import static java.lang.Integer.parseInt;

public class UserOrderShop extends JFrame implements ActionListener {
    private JLabel lblShopTrolley;
    private JLabel lblNumber;
    private JLabel lblTotalMoney;

    private JTextField txtFoodName;
    private JTextField txtFoodPrice;
    private JTextArea txtIntroduce;
    private JTextField textStartPrice;
    private JTextField textUp;
    private JTextField txtNumber;
    private JTextField txtTotalMoney;
    private JTable table;
    private JTable table1;
    private JButton btnadd;
    private JButton btnAccount;
    private JButton btnDel;

    private JScrollPane scrollPane;
    private DefaultTableModel tableModel;
    private JScrollPane scrollPane1;
    private DefaultTableModel tableModel1;
    ImageEg background;

    OrderModel orderModel=new OrderModel();
    Tb_Order tb_order=new Tb_Order();
    OrderOp orderOp=new OrderOp();
    float totalMoney = 0;
    String userEmail="";
    String shopName;

    public UserOrderShop( String userEmail,String shopName) {
        this.userEmail=userEmail;
        this.shopName=shopName;
        background=Users.background;
        background.removeAll();
        // TODO Auto-generated method stub
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(0, 0, 550, 450);
        background.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(background);
        background.setLayout(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);//�Զ������������

        setTitle("���ֲ�����¼");

        JButton btnpackage=new JButton("�ײ�");
        btnpackage.setBounds(400,200,150,40);
        btnpackage.addActionListener(this);
        background.add(btnpackage);

        JButton btnLeisure=new JButton("����Сʳ");
        btnLeisure.setBounds(400,250,150,40);
        btnLeisure.addActionListener(this);
        background.add(btnLeisure);

        JButton btnColorDrinks=new JButton("�ͷ�����");
        btnColorDrinks.setBounds(400,300,150,40);
        btnColorDrinks.addActionListener(this);
        background.add(btnColorDrinks);

        JButton btnSweet=new JButton("��Ʒ");
        btnSweet.setBounds(400,350,150,40);
        btnSweet.addActionListener(this);
        background.add(btnSweet);


        JLabel lblFoodname=new JLabel("ʳƷ����");
        lblFoodname.setBounds(1870, 155, 175, 30);
        background.add(lblFoodname);

        JLabel lblPrice=new JLabel("ʳƷ�۸�");
        lblPrice.setBounds(1870, 195, 175, 30);
        background.add(lblPrice);

        JLabel lblUp=new JLabel("��");
        lblUp.setBounds(1190, 35, 25, 30);
        background.add(lblUp);

        JLabel lblFoodPrice=new JLabel("ʳƷ����");
        lblFoodPrice.setBounds(1870, 235, 175, 30);
        background.add(lblFoodPrice);

        lblNumber=new JLabel("������");
        lblNumber.setBounds(1870,685,175,30);
        background.add(lblNumber);

        lblTotalMoney=new JLabel("�ܽ��");
        lblTotalMoney.setBounds(1870,745,175,30);
        background.add(lblTotalMoney);

        btnadd=new JButton("���빺�ﳵ");
        btnadd.setBounds(1890,500,200,50);
        btnadd.addActionListener(this);
        background.add(btnadd);

        btnAccount=new JButton("ȥ����");
        btnAccount.addActionListener(this);
        btnAccount.setBounds(1890,805,200,50);
        background.add(btnAccount);

        btnDel=new JButton("ɾ  ��");
        btnDel.setBounds(1890,900,200,50);
        btnDel.addActionListener(this);
        background.add(btnDel);

        txtNumber=new JTextField();
        txtNumber.setBounds(1965,685,175,30);
        background.add(txtNumber);

        txtTotalMoney=new JTextField();
        txtTotalMoney.setBounds(1965,745,175,30);
        background.add(txtTotalMoney);


        textStartPrice=new JTextField();
        textStartPrice.setBounds(1100, 35, 55, 30);
        background.add(textStartPrice);

        textUp=new JTextField();
        textUp.setBounds(1230, 35, 55, 30);
        background.add(textUp);

        txtFoodName=new JTextField();
        txtFoodName.setBounds(1965, 155, 175, 30);
        txtFoodName.setEditable(false);
        background.add(txtFoodName);

        txtFoodPrice=new JTextField();
        txtFoodPrice.setBounds(1965, 195, 175, 30);
        txtFoodPrice.setEditable(false);
        background.add(txtFoodPrice);

        txtIntroduce=new JTextArea();
        txtIntroduce.setBounds(1965, 235, 175, 100);
        txtIntroduce.setBorder(new LineBorder(new Color(127,157,185),1,false));

        txtIntroduce.setEditable(false);
        background.add(txtIntroduce);

        JLabel lblPicture=new JLabel("ͼƬ");
        lblPicture.setBounds(1870, 305, 100, 100);
        background.add(lblPicture);
        tableModel=orderModel.OrderModelPackage();
        table=new JTable(orderModel.OrderModelPackage());
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                int selectedRow = table.getSelectedRow(); //���ѡ��������
                txtFoodName.setText((String) tableModel.getValueAt(selectedRow, 0));
                txtFoodPrice.setText((String)tableModel.getValueAt(selectedRow, 1));
                txtIntroduce.setText((String)tableModel.getValueAt(selectedRow, 2));
            }
        });
        scrollPane=new JScrollPane(table);
        table.setRowHeight(22);
        scrollPane.setBounds(600,100,1200,400);
        background.add(scrollPane);


        lblShopTrolley=new JLabel("���ﳵ");
        lblShopTrolley.setBounds(600,420,1200,400);
        background.add(lblShopTrolley);

        String[] head={
                "ʳƷ����","ʳƷ�۸�","ʳƷ����","����"
        };
        Object[][] datas={

        };
        tableModel1=new DefaultTableModel(datas,head);
        table1=new JTable(tableModel1);
        scrollPane1=new JScrollPane(table1);
        table1.setRowHeight(22);
        scrollPane1.setBounds(600,650,1200,400);
        background.add(scrollPane1);

    }


    public  void actionPerformed(ActionEvent e){

        if (e.getActionCommand().equals("�ײ�")){
            tableModel=new OrderModel().OrderModelPackage();
            table.setModel(tableModel);
        }
        if (e.getActionCommand().equals("����Сʳ")){
            tableModel=new OrderModel().OrderModelLeisureSnack();
            table.setModel(tableModel);
        }
        if (e.getActionCommand().equals("�ͷ�����")){
            tableModel=new OrderModel().OrderModelColorDrinks();
            table.setModel(tableModel);
        }
        if (e.getActionCommand().equals("��Ʒ")){
            tableModel=new OrderModel().OrderModelSweet();
           table.setModel(tableModel);
        }
        if (e.getActionCommand().equals("���빺�ﳵ")){
           addShopTrolley();
        }
        if (e.getActionCommand().equals("ɾ  ��")){
            delTrolley();
        }
        if (e.getActionCommand().equals("ȥ����")){
            int rowNum = table1.getRowCount();//��������
            if (rowNum == 0) {
                JOptionPane.showMessageDialog(null, "���������Ʒ���ٽ��㣡");
                return;
            }
            Calendar now = Calendar.getInstance();
            String id= String.valueOf(now.get(Calendar.YEAR))+String.valueOf((now.get(Calendar.MONTH)+1))+String.valueOf(now.get(Calendar.DAY_OF_MONTH))+
                    String.valueOf(now.get(Calendar.HOUR_OF_DAY))+String.valueOf(now.get(Calendar.MINUTE))+ String.valueOf(now.get(Calendar.SECOND));
            tb_order.setOrderid(id+totalMoney);
            String time=String.valueOf(now.get(Calendar.YEAR))+"-"+String.valueOf((now.get(Calendar.MONTH)+1))+"-"+String.valueOf(now.get(Calendar.DAY_OF_MONTH))+"-"+
                    String.valueOf(now.get(Calendar.HOUR_OF_DAY))+"-"+String.valueOf(now.get(Calendar.MINUTE))+"-"+ String.valueOf(now.get(Calendar.SECOND));
            float a= 1;
            int b=1;
            String username=new UserOp().getUserNameByUserEmail(userEmail);
            tb_order.setUserEmail(userEmail);
            tb_order.setUserName(username);
            tb_order.setStartTime(time);
            tb_order.setOverTime("");
            tb_order.setOrderInformation(introduce());
            tb_order.setOrderstate("δ���");
            tb_order.setOrderPrice(totalMoney);
            tb_order.setShopName(shopName);
            tb_order.setRiderName("");
            orderOp.addOrder(tb_order);

            JOptionPane.showMessageDialog(null,"����ɹ�");
        }
    }

    private String introduce(){

        String introduce="";
        int  rowNum = table1.getRowCount();//��������
        for (int i = 0; i < rowNum; i++) {
            introduce=introduce+(i+1)+"."+tableModel1.getValueAt(i,0)+"*"+tableModel1.getValueAt(i,3)+"  "+tableModel1.getValueAt(i, 2);
        }
        return introduce;
    }

    private void addShopTrolley() {
        DefaultTableModel dtm = (DefaultTableModel) table1.getModel();
        //��ȡѡ�е���
        int row = table.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(null, "��ѡ��һ���ײ�");
            return;
        }
        //�ڱ��й��ﳵtable����ʾ���������
        int i = 0, flag = 0;//����Ƿ��Ѿ�����
        int rowNum = table1.getRowCount();
        for (i = 0; i < rowNum; i++) {
            if (table.getValueAt(row, 0)
                    .equals(table1.getValueAt(i, 0))) {
                flag = 1;
                break;
            }
        }
        if (flag == 0) {
            Vector v = new Vector();
            v.add((String) table.getValueAt(row, 0));
            v.add((String) table.getValueAt(row, 1));
            v.add((String) table.getValueAt(row, 2));
            v.add("1");
            dtm.addRow(v);
        } else {

            int goodsNum = Integer
                    .parseInt((String) table1.getValueAt(i, 3)) + 1;//��ȡ��ǰ����
            float goodsPrice = Float.parseFloat((String) table1.getValueAt(
                    i, 1));//��ȡ��ǰ����

            goodsPrice = goodsPrice
                    + Float.parseFloat((String) table1.getValueAt(i, 1));//��ȡ�����޸��Ժ���ܼ�
            this.table1.setValueAt(Integer.toString(goodsNum), i, 3);
            this.table1.setValueAt(Float.toString(goodsPrice), i, 1);
        }
        fillTable();
    }

    private void fillTable() {
        //�޸���Ʒ�������ܽ��
        int rowNum = table1.getRowCount();//��������
        int totalNum = 0;//������
        //�ܽ��
        //�ۼ����������ܽ��
        for (int i = 0; i < rowNum; i++) {
            totalNum += parseInt((String) table1.getValueAt(i, 3));
            totalMoney += Float.parseFloat((String) table1.getValueAt(i, 1));
        }
        //�ı���ֵ
        this.txtNumber.setText(Integer.toString(totalNum));
        this.txtTotalMoney.setText(Float.toString(totalMoney));
    }

    private void delTrolley() {
        int row = table1.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(null, "��ѡ��Ҫɾ�����У�");
        } else {
            DefaultTableModel dtm = (DefaultTableModel) table1.getModel();
            //ɾ��ѡ�����
            dtm.removeRow(row);
        }
        fillTable();
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
       new FontSize().InitGlobalFont(new Font("΢���ź�", Font.BOLD, 20));
        new UserOrderShop("3033774629@qq.com","���ֲ���").setVisible(true);
    }
}
