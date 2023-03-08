package com.ui.Admin;

import aegtool.FontSize;
import aegtool.OrderModel;
import aegtool.ImageEg;
import com.sun.prism.Image;
import com.ui.User.Users;

import java.awt.*;
import java.awt.event.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import static java.lang.Integer.parseInt;

public class AdminLookOrder extends JFrame implements ActionListener {

    private JTextField  txtOrderNumner;
    private JTextField  txtInformation;
    private JTextField  txtOrderCost;
    private JTextField txtOrderPrice;
    private JTextField txtPeopleNumber;
    private JTextField txtOrderState;
    private JTextField txtsearch;
    private JTextField txtserial;
    private JTextField txtprift;
    private JTextField txtOrderTime;
    private JTextField txtUserName;
    private JTextField txtUserEmail;
    private JTable table;
    private JScrollPane scrollPane;
    private DefaultTableModel tableModel;
    OrderModel orderModel=new OrderModel();
    private JComboBox comboBox;
    int searchRow=0;

ImageEg background;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        new FontSize().InitGlobalFont(new Font("微软雅黑", Font.BOLD, 20));
        ImageEg ba=new ImageEg("image1.jpg");
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AdminLookOrder frame = new AdminLookOrder();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    /**
     * Create the frame.
     */
    public AdminLookOrder() {
        background= Users.background;
        background.removeAll();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(0, 0, 1050, 1450);
        background.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(background);
        background.setLayout(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);//自动跳至界面最大化
        setTitle("订单管理");

        JLabel lblsearch=new JLabel("查询方式");
        lblsearch.setBounds(600,53,200,40);
        background.add(lblsearch);

        JButton btnsearch=new JButton("搜索");
        btnsearch.setBounds(1100,13,100,40);
        btnsearch.addActionListener(this);
        background.add(btnsearch);

        txtsearch=new JTextField();
        txtsearch.setBounds(850,13,250,40);
        txtsearch.addActionListener(this);
        background.add(txtsearch);
//        int a=cbmajorName.getSelectedIndex();
//        System.out.println(a);
        comboBox = new JComboBox();
        comboBox.setBounds(850,53,250,40);
        comboBox.addItem("订单编号");
        comboBox.addItem("下单时间");
        comboBox.addItem("送到时间");
        comboBox.addItem("订单金额");
        comboBox.addItem("订单内容");
        comboBox.addItem("骑手名称");
        comboBox.addItem("商家名称");
        comboBox.addItem("订单状态");
        comboBox.addItem("用户姓名");
        comboBox.addItem("用户邮箱");
        comboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange()==ItemEvent.SELECTED){
                    searchRow=comboBox.getSelectedIndex();
                }
            }
        });
        comboBox.setFont(new Font("微软雅黑",Font.BOLD,20));
        background.add(comboBox);

        tableModel= orderModel.OrderModelAdmin(txtsearch.getText().trim());
        table=new JTable(tableModel);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  //单选
        //table.setRowSorter(new TableRowSorter(majorTableModel));//设置可进行行排序
        table.addMouseListener(new MouseAdapter(){    //鼠标事件
            public void mouseClicked(MouseEvent e){
                int selectedRow = table.getSelectedRow(); //获得选中行
                // 索引
                txtOrderNumner.setText((String) tableModel.getValueAt(selectedRow,0));
                txtOrderTime.setText((String) tableModel.getValueAt(selectedRow,1));
                txtOrderState.setText((String) tableModel.getValueAt(selectedRow,6));
                txtInformation.setText((String) tableModel.getValueAt(selectedRow,2));
                txtOrderPrice.setText((String) tableModel.getValueAt(selectedRow,3));
                txtOrderCost.setText((String) tableModel.getValueAt(selectedRow,5));
                txtPeopleNumber.setText((String) tableModel.getValueAt(selectedRow,4));
                txtUserName.setText((String) tableModel.getValueAt(selectedRow,7));
                txtUserEmail.setText((String) tableModel.getValueAt(selectedRow,8));
            }
        });
        table.setRowHeight(22);
        scrollPane=new JScrollPane(table);
        scrollPane.setBounds(400, 165, 1200, 1000);
        background.add(scrollPane);

        JRadioButton btnNotFinish=new JRadioButton("已完成");
        btnNotFinish.setBounds(1220, 13, 85, 40);
        btnNotFinish.addActionListener(this);
        background.add(btnNotFinish);


        JRadioButton btnHadFinish=new JRadioButton("未完成");
        btnHadFinish.setBounds(1310, 13, 85, 40);
        btnHadFinish.addActionListener(this);
        background.add(btnHadFinish);

        ButtonGroup buttonGroup=new ButtonGroup();
        buttonGroup.add(btnHadFinish);
        buttonGroup.add(btnNotFinish);

        JLabel lblOrderNumner=new JLabel("订单编号");
        lblOrderNumner.setBounds(1665, 85, 150, 40);
        background.add(lblOrderNumner);

        txtOrderNumner=new JTextField();
        txtOrderNumner.setBounds(1780, 85, 250, 40);
        background.add(txtOrderNumner);

        JLabel lblOrderTime=new JLabel("下单时间");
        lblOrderTime.setBounds(1665,145,150,40);
        background.add(lblOrderTime);

        txtOrderTime=new JTextField();
        txtOrderTime.setBounds(1780,145,250,40);
        background.add(txtOrderTime);

        JLabel lblInformation=new JLabel("订单信息");
        lblInformation.setBounds(1665, 205, 150, 40);
        background.add(lblInformation);

        txtInformation=new JTextField();
        txtInformation.setBounds(1780, 205, 250, 40);
        background.add(txtInformation);

        JLabel lblOrderPrice=new JLabel("订单金额");
        lblOrderPrice.setBounds(1665, 265, 150, 40);
        background.add(lblOrderPrice);

        txtOrderPrice=new JTextField();
        txtOrderPrice.setBounds(1780, 265, 250, 40);
        background.add(txtOrderPrice);

        JLabel lblPeopleNumber=new JLabel("人数");
        lblPeopleNumber.setBounds(1665,325,150,40);
        background.add(lblPeopleNumber);

        txtPeopleNumber=new JTextField();
        txtPeopleNumber.setBounds(1780,325,250,40);
        background.add(txtPeopleNumber);


        JLabel lblOrderState=new JLabel("订单状态");
        lblOrderState.setBounds(1665,385,150,40);
        background.add(lblOrderState);

        txtOrderState=new JTextField();
        txtOrderState.setBounds(1780,385,250,40);
        background.add(txtOrderState);

        JLabel lblUserName=new JLabel("用户姓名");
        lblUserName.setBounds(1665,445,250,40);
        background.add(lblUserName);

        txtUserName=new JTextField();
        txtUserName.setBounds(1780,445,250,40);
        background.add(txtUserName);

        JLabel lblUserEmail=new JLabel("用户邮箱");
        lblUserEmail.setBounds(1665,505,150,40);
        background.add(lblUserEmail);

        txtUserEmail=new JTextField();
        txtUserEmail.setBounds(1780,505,250,40);
        background.add(txtUserEmail);


        JLabel lblCurAccount=new JLabel(" 流水：");
        lblCurAccount.setBounds(1665, 565, 150, 40);
        background.add(lblCurAccount);

        txtserial=new JTextField();
        txtserial.setBounds(1780, 565, 250, 40);
        background.add(txtserial);

        JLabel lblGrossMargin=new JLabel("成本");
        lblGrossMargin.setBounds(1665, 625, 150, 40);
        background.add(lblGrossMargin);

        txtOrderCost=new JTextField();
        txtOrderCost.setBounds(1780, 625, 250, 40);
        background.add(txtOrderCost);

        JLabel lblprift=new JLabel("利润");
        lblprift.setBounds(1665, 685, 150, 40);
        background.add(lblprift);

        txtprift=new JTextField();
        txtprift.setBounds(1780, 685, 250, 40);
        background.add(txtprift);

        JButton btnDelete=new JButton("备注");
        btnDelete.setBounds(1850,745,100,40);
        btnDelete.addActionListener(this);
        background.add(btnDelete);

        fillTable();
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("搜索")){
//            tableModel= orderModel.OrderModelAdmin(txtsearch.getText().trim());
//            table.setModel(tableModel);
//            fillTable();
            System.out.println(searchRow);
            OrderSearch(searchRow,txtsearch.getText().trim());
        }
        if (e.getActionCommand().equals("未完成")){
//            tableModel= orderModel.orderNoHad();
//            table.setModel(tableModel);
            tableModel= orderModel.OrderModelAdmin(txtsearch.getText().trim());
            table.setModel(tableModel);
            OrderNo();
            fillTable();
        }
        if (e.getActionCommand().equals("已完成")){
            tableModel= orderModel.OrderModelAdmin(txtsearch.getText().trim());
            table.setModel(tableModel);
            OrderHad();
            fillTable();
        }
        if (e.getActionCommand().equals("删除")){
            int result = JOptionPane.showConfirmDialog(null, "是否删除订单？");
            //System.out.println(result);
            if (result == 0)
                this.dispose();
            System.out.println("hggj");
        }
    }
    public void OrderSearch(int seachRow,String search){
        int rowall=table.getRowCount();

        for (int i = 0; i <rowall; i++) {
            String state= (String) tableModel.getValueAt(i,seachRow);

                Pattern pattern=Pattern.compile(search);
                Matcher matcher=pattern.matcher(state);
                boolean isFind=matcher.find();
                if (isFind==false){
                    tableModel.removeRow(i);
                    i--;
                    rowall--;
                }
        }
    }
    public void OrderNo(){
        int rowall=table.getRowCount();
        for (int i = 0; i <rowall; i++) {
            String state= (String) tableModel.getValueAt(i,9);
            if (state.trim().equals("")){
                tableModel.removeRow(i);
                i--;
                rowall--;
            }
        }
    }

    public void OrderHad(){
        int rowall=table.getRowCount();
        System.out.println(rowall);
        for (int i = 0; i <rowall; i++) {
            String state= tableModel.getValueAt(i,9).toString();

            if (state.trim().equals("未完成")){
               tableModel.removeRow(i);
               i--;
               rowall--;
            }
        }
    }

    private void delTrolley() {
        int row = table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(null, "请选择要删除的行！");
        } else {
            tableModel.removeRow(row);
        }
        fillTable();
    }
    private void fillTable() {
        int rowNum = table.getRowCount();//计算行数
        double cost=0;
        double price=0;

        for (int i = 0; i < rowNum; i++) {
            price+=Double.parseDouble((String) tableModel.getValueAt(i,3));
        }
        //文本框赋值
        txtprift.setText(String.valueOf(cost));
        txtserial.setText(String.valueOf(price));
    }
}
