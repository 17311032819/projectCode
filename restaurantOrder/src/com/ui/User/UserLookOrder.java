package com.ui.User;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class UserLookOrder extends JFrame implements ActionListener {

    private JTextField txtTableNumner;
    private JTextField txtfoodName;
    private JTextField txtOrderprice;
    private JTextField txtOrderState;

    private JPanel contentPane;
    private JTable table;
    JScrollPane jScrollPane;

    DefaultTableModel defaultTableModel;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UserLookOrder frame = new UserLookOrder();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public JTable table() {
        // TODO Auto-generated method stub
        String[] head={
                "桌号","菜品","订单金额","订单状态"
        };
        Object[][] datas={
                {"001","吮指原味鸡","23","完成"},{"002","薯条","23","完成"}
        };
        defaultTableModel=new DefaultTableModel(datas,head);
        table = new JTable(defaultTableModel);
        table.setPreferredScrollableViewportSize(new Dimension(780,200));//设置此表视图首选大小
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  //单选
        //table.setRowSorter(new TableRowSorter(majorTableModel));//设置可进行行排序
        table.addMouseListener(new MouseAdapter(){    //鼠标事件
            public void mouseClicked(MouseEvent e){
                int selectedRow = table.getSelectedRow(); //获得选中行

                Object tableNumber= defaultTableModel.getValueAt(selectedRow, 0);
                txtTableNumner.setText((String)tableNumber);
                Object foodName = defaultTableModel.getValueAt(selectedRow, 1);
                txtfoodName.setText((String)foodName);
                Object orderPrice=defaultTableModel.getValueAt(selectedRow, 2);
                txtOrderprice.setText((String)orderPrice);
                Object orderState=defaultTableModel.getValueAt(selectedRow, 3);
                txtOrderState.setText((String)orderState);
            }
        });
        return table;

    }

    /**
     * Create the frame.
     */
    public UserLookOrder() {
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setBounds(600, 600, 885, 800);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        setTitle("查看订单");

        //table=getAllMajor();//生成表格
        contentPane.setLayout(null);
        contentPane.setLayout(null);

        table=table();
        jScrollPane=new JScrollPane(table);
        jScrollPane.setBounds(5, 65, 650, 407);
        contentPane.add(jScrollPane);

        JLabel lblOrderNumner=new JLabel("桌  号：");
        lblOrderNumner.setBounds(665, 85, 75, 30);
        contentPane.add(lblOrderNumner);

        txtTableNumner=new JTextField();
        txtTableNumner.setBounds(725, 85, 85, 30);
        contentPane.add(txtTableNumner);

        JLabel lblInformation=new JLabel("菜  品：");
        lblInformation.setBounds(665, 125, 75, 30);
        contentPane.add(lblInformation);

        txtfoodName=new JTextField();
        txtfoodName.setBounds(725, 125, 85, 30);
        contentPane.add(txtfoodName);

        JLabel lblOrderCost=new JLabel("订单金额：");
        lblOrderCost.setBounds(665, 165, 75, 30);
        contentPane.add(lblOrderCost);

        txtOrderprice=new JTextField();
        txtOrderprice.setBounds(725, 165, 85, 30);
        contentPane.add(txtOrderprice);


        JLabel lblOrderState=new JLabel("订单状态：");
        lblOrderState.setBounds(665, 205, 75, 30);
        contentPane.add(lblOrderState);

        txtOrderState=new JTextField();
        txtOrderState.setBounds(725, 205, 85, 30);
        contentPane.add(txtOrderState);

        JButton btnchargeback=new JButton("退单");
        btnchargeback.setBounds(665, 245, 75, 30);
        btnchargeback.addActionListener(this);
        contentPane.add(btnchargeback);


    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getActionCommand().equals("退单")){
            System.out.println("退单");
        }
    }

}
