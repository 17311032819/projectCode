package com.ui.Admin;

import aegtool.UserModel;
import aegtool.ImageEg;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
public class LookUserInformation extends JFrame implements ActionListener {

    private JTextField txtUserName;
    private JTextField txtTableNumber;
    private JTextField txtEmail;
    private JTextField txtOrderState;

    private JTable table;
    private JScrollPane scrollPane;
    private DefaultTableModel tableModel;


    /**
     * Launch the application.
     */
    public static void main(String[] args) {

        ImageEg b=new ImageEg("jbh");
        new LookUserInformation(b).setVisible(true);
    }
    public JTable table3() {
        // TODO Auto-generated method stub
        tableModel=new UserModel().UserModel();
        table=new JTable(tableModel);
        table.setRowHeight(25);
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                int selectedRow = table.getSelectedRow(); //���ѡ��������
                Object userName = tableModel.getValueAt(selectedRow, 0);
                txtUserName.setText((String)userName);
                Object userEmail = tableModel.getValueAt(selectedRow, 1);
                txtEmail.setText((String)userEmail);
            }
        });

        return table;


    }

    /**
     * Create the frame.
     */
    public LookUserInformation(ImageEg background) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(0, 0, 1050, 1450);
        background.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(background);
        background.setLayout(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);//�Զ������������
        setTitle("�鿴�û���Ϣ");

        //table=getAllMajor();//���ɱ��

        scrollPane = new JScrollPane(table3());//��ӹ������
        scrollPane.setBounds(195, 15, 1550, 1207);
        background.add(scrollPane);


        JLabel lblUserName=new JLabel("��   ����");
        lblUserName.setBounds(1765, 85, 125, 30);
        lblUserName.setFont(new Font("΢���ź�",Font.BOLD,20));
        background.add(lblUserName);

        txtUserName=new JTextField();
        txtUserName.setBounds(1825, 85, 285, 30);
        txtUserName.setFont(new Font("΢���ź�",Font.BOLD,20));
        background.add(txtUserName);

        JLabel lblTableNumber=new JLabel("��   �ţ�");
        lblTableNumber.setBounds(1765, 125, 125, 30);
        lblTableNumber.setFont(new Font("΢���ź�",Font.BOLD,20));
        background.add(lblTableNumber);

        txtTableNumber=new JTextField();
        txtTableNumber.setBounds(1825, 125, 285, 30);
        txtTableNumber.setFont(new Font("΢���ź�",Font.BOLD,20));
        background.add(txtTableNumber);

        JLabel lblEmail=new JLabel("��   �䣺");
        lblEmail.setBounds(1765, 165, 125, 30);
        lblEmail.setFont(new Font("΢���ź�",Font.BOLD,20));
        background.add(lblEmail);

        txtEmail=new JTextField();
        txtEmail.setBounds(1825, 165, 285, 30);
        txtEmail.setFont(new Font("΢���ź�",Font.BOLD,20));
        background.add(txtEmail);

        JLabel lblOrderState=new JLabel("����״̬��");
        lblOrderState.setBounds(1765, 205, 125, 30);
        lblOrderState.setFont(new Font("΢���ź�",Font.BOLD,20));
        background.add(lblOrderState);

        txtOrderState=new JTextField();
        txtOrderState.setBounds(1825, 205, 285, 30);
        txtOrderState.setFont(new Font("΢���ź�",Font.BOLD,20));
        background.add(txtOrderState);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }


}
