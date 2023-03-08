package com.ui;

import aegtool.FontSize;
import aegtool.ImageEg;
import aegtool.Judgeidexit;
import com.Bean.Tb_password;
import com.Password.FindBackPassword;
import com.dao.RememberPasswordOp;
import com.db.connectiontomysql;
import com.ui.Admin.Admin;
import com.ui.User.Users;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Login extends JFrame implements ActionListener  {
    /**
     *
     */
    private static final long serialVersionUID = -2697972101978159177L;
    private JLabel lblUserName;
    private JLabel lblUserPWD;
    private JTextField txtName;
    private JPasswordField passwordField;
    private JRadioButton rbadmin;
    private JRadioButton rbuser;
    private JRadioButton rbshop;
    private JRadioButton rbrider;
    private JCheckBox rememberPassword;
    private JCheckBox zidonglogin;
    private JButton lookBackPassword;
    private JComboBox<String>  cbmajorName;
    

    public String lgrole;
    public String lgname;
    ImageEg background=new ImageEg("image1.jpg");
    String  strMajorName;
    connectiontomysql connectiontomysql=new connectiontomysql();

    int flag=0;
    RememberPasswordOp passwordOp=new RememberPasswordOp();
    Tb_password remember=new Tb_password();
    public static void main(String[] args) {
        new FontSize().InitGlobalFont(new Font("΢���ź�", Font.BOLD, 20));

        Login stuLg=new Login();
        stuLg.setVisible(true);


    }
    //���캯��
    public Login(){
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 550, 450);
        background.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(background);
        background.setLayout(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);//�Զ������������
        setTitle("���ֲ�����¼");

        lblUserName = new JLabel("�û����䣺");
        lblUserName.setBounds(73, 61, 150, 40);
        background.add(lblUserName);

        lblUserPWD = new JLabel("�û����룺");
        lblUserPWD.setBounds(73, 120, 150, 40);
        background.add(lblUserPWD);

        txtName = new JTextField();//   �ı�   �����������
        txtName.setBounds(170, 61, 200, 40);
        background.add(txtName);

        cbmajorName = new JComboBox<String>();
        cbmajorName.setBounds(170, 61, 220, 40);
        background.add(cbmajorName);
        cbmajorName.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                strMajorName = cbmajorName.getSelectedItem().toString();
            }//�����б�
        });
        //���ɶ���
        List list = passwordOp.getuser();
        for(int i=0;i<list.size();i++)
            cbmajorName.addItem(list.get(i).toString());
        this.validate();
//		���������б�
        cbmajorName.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange()==ItemEvent.SELECTED){
                    String admin=cbmajorName.getSelectedItem().toString();
                    txtName.setText(admin);
                    String email=txtName.getText();
                    String password=passwordOp.getPasswordByUserEmail(email);
                    passwordField.setText(password);
                }
            }
        });

        passwordField = new JPasswordField();// �����ı�
        passwordField.setBounds(170, 120, 200, 40);
        background.add(passwordField);

        ButtonGroup bg=new ButtonGroup();
        rbadmin=new JRadioButton("����Ա");
        rbadmin.setBounds(94, 187, 100, 40);
        //rbadmin.setSelected(true);
        background.add(rbadmin);

        rbuser=new JRadioButton("�û�");
        rbuser.setBounds(200, 187, 75, 40);
        background.add(rbuser);

        rbshop=new JRadioButton("�̼�");
        rbshop.setBounds(306, 187, 75, 40);
        background.add(rbshop);

        rbrider=new JRadioButton("����");
        rbrider.setBounds(412, 187, 75, 40);
        background.add(rbrider);

        bg.add(rbadmin);
        bg.add(rbuser);
        bg.add(rbrider);
        bg.add(rbshop);

        JButton btnCancle = new JButton("ע��");
        btnCancle.setBounds(122, 350, 80, 40);
        btnCancle.addActionListener(this);
        background.add(btnCancle);

        JButton btnNewButton = new JButton("��¼");
        btnNewButton.addActionListener(this);
        btnNewButton.setBounds(220, 350, 80, 40);
        background.add(btnNewButton);

        JButton btnReset = new JButton("����");
        btnReset.addActionListener(this);
        btnReset.setBounds(318, 350, 80, 40);
        background.add(btnReset);

        zidonglogin = new JCheckBox("�Զ���¼");
        zidonglogin.setBounds(94, 256, 150, 40);
        zidonglogin.addActionListener(this);
        background.add(zidonglogin);

        rememberPassword = new JCheckBox("��ס����");
        rememberPassword.setBounds(254, 256, 150, 40);
        rememberPassword.addActionListener(this);
        background.add(rememberPassword);

        lookBackPassword = new JButton("�һ�����");
        lookBackPassword.setBounds(414, 256, 150, 40);
        lookBackPassword.addActionListener(this);
        background.add(lookBackPassword);
    }
    public void actionPerformed(ActionEvent e){
        if (e.getActionCommand().equals("��¼")){
            if (rbadmin.isSelected()){
                String pwd=new String(passwordField.getPassword());//����������������
                if(txtName.getText().equals("admin") && pwd.equals("123456")) {
                    lgrole="����Ա";
                    lgname="admin";
                    Admin admin=new Admin();
                    admin.setVisible(true);
                    JOptionPane.showMessageDialog(null,"����Ա��¼�ɹ���");
                }
                else{
                    JOptionPane.showMessageDialog(null, "�û������������");
                    txtName.setText("");
                    passwordField.setText("");
                }

            }

            else  if (rbuser.isSelected()){
                Connection con=(Connection) connectiontomysql.getConnection();
                PreparedStatement pstmt= null;
                try {
                    pstmt = con.prepareStatement("select * from Tb_user where userEmail=? and userPassword=? ");
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                try {
                    pstmt.setString(1, txtName.getText());
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                try {
                    pstmt.setString(2, new String(passwordField.getPassword()));
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                ResultSet rSet= null;//pstmt.executeUpdate()
                try {
                    rSet = pstmt.executeQuery();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                try {
                    if(rSet.next()){

                        new Users().setVisible(true);
                        JOptionPane.showMessageDialog(null,"�û���¼�ɹ�");
                        flag=1;
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"�������");
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

            else  if (rbshop.isSelected()){
                Connection con=(Connection) connectiontomysql.getConnection();
                PreparedStatement pstmt= null;
                try {
                    pstmt = con.prepareStatement("select * from Tb_shop where userEmail=? and userPassword=? ");
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                try {
                    pstmt.setString(1, txtName.getText());
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                try {
                    pstmt.setString(2, new String(passwordField.getPassword()));
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                ResultSet rSet= null;//pstmt.executeUpdate()
                try {
                    rSet = pstmt.executeQuery();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                try {
                    if(rSet.next()){

                        new Users().setVisible(true);
                        JOptionPane.showMessageDialog(null,"�û���¼�ɹ�");
                        flag=1;
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"�������");
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

            else  if (rbrider.isSelected()){
                Connection con=(Connection) connectiontomysql.getConnection();
                PreparedStatement pstmt= null;
                try {
                    pstmt = con.prepareStatement("select * from Tb_rider where userEmail=? and userPassword=? ");
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                try {
                    pstmt.setString(1, txtName.getText());
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                try {
                    pstmt.setString(2, new String(passwordField.getPassword()));
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                ResultSet rSet= null;//pstmt.executeUpdate()
                try {
                    rSet = pstmt.executeQuery();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                try {
                    if(rSet.next()){

                        new Users().setVisible(true);
                        JOptionPane.showMessageDialog(null,"�û���¼�ɹ�");
                        flag=1;
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"�������");
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }


            else {
                JOptionPane.showMessageDialog(null, "��ѡ���¼���");
            }
        }
        else if (e.getActionCommand().equals("����")){
            txtName.setText("");
            passwordField.setText("");
        }

        else if (e.getActionCommand().equals("ע��")){
            System.out.println("zhuce");
        }

        else if (e.getActionCommand().equals("�һ�����")){
            new FindBackPassword(background).setVisible(true);

        }
        if (zidonglogin.isSelected()) {
            System.out.println("�Զ���¼");
        }
        if (rememberPassword.isSelected()&&flag==1){
            if (!new Judgeidexit().judgeUserEmail(txtName.getText().trim()))//���ݿ���û�����ݾʹ洢
            {
                flag=0;
                remember.setUserEmail(txtName.getText().trim());
                String password=new String(passwordField.getPassword());
                remember.setUserpassword(password);
                passwordOp.Addremember(remember);
            }

            else{//�оͲ�����

            }
        }
    }
    public void logining(){

        final JProgressBar progressBar=new JProgressBar();
        progressBar.setBounds(280,800,1750,40);
        progressBar.setStringPainted(true);
        new Thread(){
            public void run(){
                for(int i=0;i<=100;i++){
                    try{
                        Thread.sleep(50);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                    progressBar.setValue(i);
                }
                progressBar.setString("��½�ɹ���");
            }
        }.start();
        background.add(progressBar);
    }

}
