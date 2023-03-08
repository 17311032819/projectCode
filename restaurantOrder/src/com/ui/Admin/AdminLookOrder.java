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
        new FontSize().InitGlobalFont(new Font("΢���ź�", Font.BOLD, 20));
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
        setExtendedState(JFrame.MAXIMIZED_BOTH);//�Զ������������
        setTitle("��������");

        JLabel lblsearch=new JLabel("��ѯ��ʽ");
        lblsearch.setBounds(600,53,200,40);
        background.add(lblsearch);

        JButton btnsearch=new JButton("����");
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
        comboBox.addItem("�������");
        comboBox.addItem("�µ�ʱ��");
        comboBox.addItem("�͵�ʱ��");
        comboBox.addItem("�������");
        comboBox.addItem("��������");
        comboBox.addItem("��������");
        comboBox.addItem("�̼�����");
        comboBox.addItem("����״̬");
        comboBox.addItem("�û�����");
        comboBox.addItem("�û�����");
        comboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange()==ItemEvent.SELECTED){
                    searchRow=comboBox.getSelectedIndex();
                }
            }
        });
        comboBox.setFont(new Font("΢���ź�",Font.BOLD,20));
        background.add(comboBox);

        tableModel= orderModel.OrderModelAdmin(txtsearch.getText().trim());
        table=new JTable(tableModel);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  //��ѡ
        //table.setRowSorter(new TableRowSorter(majorTableModel));//���ÿɽ���������
        table.addMouseListener(new MouseAdapter(){    //����¼�
            public void mouseClicked(MouseEvent e){
                int selectedRow = table.getSelectedRow(); //���ѡ����
                // ����
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

        JRadioButton btnNotFinish=new JRadioButton("�����");
        btnNotFinish.setBounds(1220, 13, 85, 40);
        btnNotFinish.addActionListener(this);
        background.add(btnNotFinish);


        JRadioButton btnHadFinish=new JRadioButton("δ���");
        btnHadFinish.setBounds(1310, 13, 85, 40);
        btnHadFinish.addActionListener(this);
        background.add(btnHadFinish);

        ButtonGroup buttonGroup=new ButtonGroup();
        buttonGroup.add(btnHadFinish);
        buttonGroup.add(btnNotFinish);

        JLabel lblOrderNumner=new JLabel("�������");
        lblOrderNumner.setBounds(1665, 85, 150, 40);
        background.add(lblOrderNumner);

        txtOrderNumner=new JTextField();
        txtOrderNumner.setBounds(1780, 85, 250, 40);
        background.add(txtOrderNumner);

        JLabel lblOrderTime=new JLabel("�µ�ʱ��");
        lblOrderTime.setBounds(1665,145,150,40);
        background.add(lblOrderTime);

        txtOrderTime=new JTextField();
        txtOrderTime.setBounds(1780,145,250,40);
        background.add(txtOrderTime);

        JLabel lblInformation=new JLabel("������Ϣ");
        lblInformation.setBounds(1665, 205, 150, 40);
        background.add(lblInformation);

        txtInformation=new JTextField();
        txtInformation.setBounds(1780, 205, 250, 40);
        background.add(txtInformation);

        JLabel lblOrderPrice=new JLabel("�������");
        lblOrderPrice.setBounds(1665, 265, 150, 40);
        background.add(lblOrderPrice);

        txtOrderPrice=new JTextField();
        txtOrderPrice.setBounds(1780, 265, 250, 40);
        background.add(txtOrderPrice);

        JLabel lblPeopleNumber=new JLabel("����");
        lblPeopleNumber.setBounds(1665,325,150,40);
        background.add(lblPeopleNumber);

        txtPeopleNumber=new JTextField();
        txtPeopleNumber.setBounds(1780,325,250,40);
        background.add(txtPeopleNumber);


        JLabel lblOrderState=new JLabel("����״̬");
        lblOrderState.setBounds(1665,385,150,40);
        background.add(lblOrderState);

        txtOrderState=new JTextField();
        txtOrderState.setBounds(1780,385,250,40);
        background.add(txtOrderState);

        JLabel lblUserName=new JLabel("�û�����");
        lblUserName.setBounds(1665,445,250,40);
        background.add(lblUserName);

        txtUserName=new JTextField();
        txtUserName.setBounds(1780,445,250,40);
        background.add(txtUserName);

        JLabel lblUserEmail=new JLabel("�û�����");
        lblUserEmail.setBounds(1665,505,150,40);
        background.add(lblUserEmail);

        txtUserEmail=new JTextField();
        txtUserEmail.setBounds(1780,505,250,40);
        background.add(txtUserEmail);


        JLabel lblCurAccount=new JLabel(" ��ˮ��");
        lblCurAccount.setBounds(1665, 565, 150, 40);
        background.add(lblCurAccount);

        txtserial=new JTextField();
        txtserial.setBounds(1780, 565, 250, 40);
        background.add(txtserial);

        JLabel lblGrossMargin=new JLabel("�ɱ�");
        lblGrossMargin.setBounds(1665, 625, 150, 40);
        background.add(lblGrossMargin);

        txtOrderCost=new JTextField();
        txtOrderCost.setBounds(1780, 625, 250, 40);
        background.add(txtOrderCost);

        JLabel lblprift=new JLabel("����");
        lblprift.setBounds(1665, 685, 150, 40);
        background.add(lblprift);

        txtprift=new JTextField();
        txtprift.setBounds(1780, 685, 250, 40);
        background.add(txtprift);

        JButton btnDelete=new JButton("��ע");
        btnDelete.setBounds(1850,745,100,40);
        btnDelete.addActionListener(this);
        background.add(btnDelete);

        fillTable();
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("����")){
//            tableModel= orderModel.OrderModelAdmin(txtsearch.getText().trim());
//            table.setModel(tableModel);
//            fillTable();
            System.out.println(searchRow);
            OrderSearch(searchRow,txtsearch.getText().trim());
        }
        if (e.getActionCommand().equals("δ���")){
//            tableModel= orderModel.orderNoHad();
//            table.setModel(tableModel);
            tableModel= orderModel.OrderModelAdmin(txtsearch.getText().trim());
            table.setModel(tableModel);
            OrderNo();
            fillTable();
        }
        if (e.getActionCommand().equals("�����")){
            tableModel= orderModel.OrderModelAdmin(txtsearch.getText().trim());
            table.setModel(tableModel);
            OrderHad();
            fillTable();
        }
        if (e.getActionCommand().equals("ɾ��")){
            int result = JOptionPane.showConfirmDialog(null, "�Ƿ�ɾ��������");
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

            if (state.trim().equals("δ���")){
               tableModel.removeRow(i);
               i--;
               rowall--;
            }
        }
    }

    private void delTrolley() {
        int row = table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(null, "��ѡ��Ҫɾ�����У�");
        } else {
            tableModel.removeRow(row);
        }
        fillTable();
    }
    private void fillTable() {
        int rowNum = table.getRowCount();//��������
        double cost=0;
        double price=0;

        for (int i = 0; i < rowNum; i++) {
            price+=Double.parseDouble((String) tableModel.getValueAt(i,3));
        }
        //�ı���ֵ
        txtprift.setText(String.valueOf(cost));
        txtserial.setText(String.valueOf(price));
    }
}
