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
        new FontSize().InitGlobalFont(new Font("微软雅黑", Font.BOLD, 20));

        Login stuLg=new Login();
        stuLg.setVisible(true);


    }
    //构造函数
    public Login(){
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 550, 450);
        background.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(background);
        background.setLayout(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);//自动跳至界面最大化
        setTitle("快乐餐厅登录");

        lblUserName = new JLabel("用户邮箱：");
        lblUserName.setBounds(73, 61, 150, 40);
        background.add(lblUserName);

        lblUserPWD = new JLabel("用户密码：");
        lblUserPWD.setBounds(73, 120, 150, 40);
        background.add(lblUserPWD);

        txtName = new JTextField();//   文本   生成这个对象
        txtName.setBounds(170, 61, 200, 40);
        background.add(txtName);

        cbmajorName = new JComboBox<String>();
        cbmajorName.setBounds(170, 61, 220, 40);
        background.add(cbmajorName);
        cbmajorName.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                strMajorName = cbmajorName.getSelectedItem().toString();
            }//下拉列表
        });
        //生成对象
        List list = passwordOp.getuser();
        for(int i=0;i<list.size();i++)
            cbmajorName.addItem(list.get(i).toString());
        this.validate();
//		监听下拉列表
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

        passwordField = new JPasswordField();// 密码文本
        passwordField.setBounds(170, 120, 200, 40);
        background.add(passwordField);

        ButtonGroup bg=new ButtonGroup();
        rbadmin=new JRadioButton("管理员");
        rbadmin.setBounds(94, 187, 100, 40);
        //rbadmin.setSelected(true);
        background.add(rbadmin);

        rbuser=new JRadioButton("用户");
        rbuser.setBounds(200, 187, 75, 40);
        background.add(rbuser);

        rbshop=new JRadioButton("商家");
        rbshop.setBounds(306, 187, 75, 40);
        background.add(rbshop);

        rbrider=new JRadioButton("骑手");
        rbrider.setBounds(412, 187, 75, 40);
        background.add(rbrider);

        bg.add(rbadmin);
        bg.add(rbuser);
        bg.add(rbrider);
        bg.add(rbshop);

        JButton btnCancle = new JButton("注册");
        btnCancle.setBounds(122, 350, 80, 40);
        btnCancle.addActionListener(this);
        background.add(btnCancle);

        JButton btnNewButton = new JButton("登录");
        btnNewButton.addActionListener(this);
        btnNewButton.setBounds(220, 350, 80, 40);
        background.add(btnNewButton);

        JButton btnReset = new JButton("重置");
        btnReset.addActionListener(this);
        btnReset.setBounds(318, 350, 80, 40);
        background.add(btnReset);

        zidonglogin = new JCheckBox("自动登录");
        zidonglogin.setBounds(94, 256, 150, 40);
        zidonglogin.addActionListener(this);
        background.add(zidonglogin);

        rememberPassword = new JCheckBox("记住密码");
        rememberPassword.setBounds(254, 256, 150, 40);
        rememberPassword.addActionListener(this);
        background.add(rememberPassword);

        lookBackPassword = new JButton("找回密码");
        lookBackPassword.setBounds(414, 256, 150, 40);
        lookBackPassword.addActionListener(this);
        background.add(lookBackPassword);
    }
    public void actionPerformed(ActionEvent e){
        if (e.getActionCommand().equals("登录")){
            if (rbadmin.isSelected()){
                String pwd=new String(passwordField.getPassword());//接收密码框里的内容
                if(txtName.getText().equals("admin") && pwd.equals("123456")) {
                    lgrole="管理员";
                    lgname="admin";
                    Admin admin=new Admin();
                    admin.setVisible(true);
                    JOptionPane.showMessageDialog(null,"管理员登录成功了");
                }
                else{
                    JOptionPane.showMessageDialog(null, "用户名或密码错误！");
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
                        JOptionPane.showMessageDialog(null,"用户登录成功");
                        flag=1;
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"密码错误");
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
                        JOptionPane.showMessageDialog(null,"用户登录成功");
                        flag=1;
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"密码错误");
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
                        JOptionPane.showMessageDialog(null,"用户登录成功");
                        flag=1;
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"密码错误");
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }


            else {
                JOptionPane.showMessageDialog(null, "请选择登录身份");
            }
        }
        else if (e.getActionCommand().equals("重置")){
            txtName.setText("");
            passwordField.setText("");
        }

        else if (e.getActionCommand().equals("注册")){
            System.out.println("zhuce");
        }

        else if (e.getActionCommand().equals("找回密码")){
            new FindBackPassword(background).setVisible(true);

        }
        if (zidonglogin.isSelected()) {
            System.out.println("自动登录");
        }
        if (rememberPassword.isSelected()&&flag==1){
            if (!new Judgeidexit().judgeUserEmail(txtName.getText().trim()))//数据库里没有数据就存储
            {
                flag=0;
                remember.setUserEmail(txtName.getText().trim());
                String password=new String(passwordField.getPassword());
                remember.setUserpassword(password);
                passwordOp.Addremember(remember);
            }

            else{//有就不操作

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
                progressBar.setString("登陆成功！");
            }
        }.start();
        background.add(progressBar);
    }

}
