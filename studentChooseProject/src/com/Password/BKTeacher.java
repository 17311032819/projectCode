package com.Password;

import com.dao.GetBackPasswordOp;
import com.ui.ImageEg;
import com.ui.Rand;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import javax.swing.border.EmptyBorder;

public class BKTeacher extends JFrame implements ActionListener{
//    private JPanel contentPane;
    private JLabel lblUserName;
    private JLabel lblVerificationCode;
    private JTextField txtName;
    private JLabel lblVC;
    private JTextField VC;
    private JTextField txtVC;
    private JLabel lblUserPWD;
    private  JTextField passwordField;

    String stuid=new String();
    String str="";
    public static void main(String[] args) {


    }
    public void BKTeacher(String stuId,String code){
        str=code;
        stuid=stuId;

        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);//设置窗体关闭时做什么
        setBounds(150, 150, 350, 350);//设置窗体出现的坐标及宽与高
        setTitle("添加班级界面");//设置标题
        ImageEg background=new ImageEg("image1.jpg");
        background.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(background);
        background.setLayout(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);//自动跳至界面最大化
        setVisible(true);

        lblUserName = new JLabel("用户姓名：");
        lblUserName.setFont(new Font("宋体", Font.PLAIN, 15));//设置字体
        //Font.PLANIN 普通样式常量
        //Font.BOLD   粗体样式常量
        //Font.ITALIC 斜体样式常量
        lblUserName.setBounds(43, 1, 82, 36);
        background.add(lblUserName);

        lblUserPWD = new JLabel("验证码：");
        lblUserPWD.setFont(new Font("宋体", Font.PLAIN, 15));
        lblUserPWD.setBounds(43, 60, 82, 36);
        background.add(lblUserPWD);

        lblVerificationCode = new JLabel("密码：");
        lblVerificationCode.setFont(new Font("宋体", Font.PLAIN, 15));
        lblVerificationCode.setBounds(43, 120, 82, 36);
        background.add(lblVerificationCode);

        txtName = new JTextField();//生成对象
        txtName.setFont(new Font("宋体", Font.PLAIN, 15));
        txtName.setBounds(140, 1, 171, 36);
        background.add(txtName);
        txtName.setColumns(10);//设置文本框里一行的字符数

        passwordField = new JTextField();
        passwordField.setBounds(140, 121, 171, 36);
        background.add(passwordField);

        txtVC = new JTextField();//生成对象
        txtVC.setFont(new Font("宋体", Font.PLAIN, 15));
        txtVC.setBounds(140, 60, 171, 36);
        background.add(txtVC);



        JButton btnNewButton = new JButton("找回密码");
        btnNewButton.setFont(new Font("宋体", Font.PLAIN, 15));
        btnNewButton.addActionListener(this);
        btnNewButton.setBounds(140, 256, 150, 30);
        background.add(btnNewButton);

    }
    public void actionPerformed(ActionEvent e){

        if(e.getActionCommand().equals("找回密码")){

            if(txtName.getText().equals(stuid)) {

                if (txtVC.getText().equals(str)) {
                    GetBackPasswordOp getBackPasswordOp = new GetBackPasswordOp();
                    String password = getBackPasswordOp.getIdByName2(txtName.getText());
                    passwordField.setText(password);
                    JOptionPane.showMessageDialog(null, "找回密码成功");

                } else {
                    JOptionPane.showMessageDialog(null, "验证码错误");
                    txtVC.setText("");

                }
            }
            else {
                JOptionPane.showMessageDialog(null,"两次输入需要找回的账号不一致，确认一下吧！");
                teacherCode teachercode=new teacherCode();
                teachercode.setVisible(true);
            }
        }
    }

}
