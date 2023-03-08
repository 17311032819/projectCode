package com.ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import com.Password.*;

public class Register extends JFrame implements ActionListener {


    private JTextField txttitle;
    public static void main(String[] args) {
        Register register=new Register();
        register.setVisible(true);
    }
    public Register() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//设置窗体关闭时做什么
        setBounds(100, 100, 450, 300);//设置窗体出现的坐标及宽与高
        setTitle("注册");//设置标题
        ImageEg background=new ImageEg("image1.jpg");
        background.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(background);
        background.setLayout(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);//自动跳至界面最大化


        txttitle=new JTextField("选择你的身份");
        txttitle.setFont(new Font("宋体", Font.PLAIN, 25));
        txttitle.setBounds(80,70,200,40);
        txttitle.setEnabled(false);
        background.add(txttitle);

        JButton ID2=new JButton("老  师");
        ID2.setFont(new Font("宋体", Font.PLAIN, 15));
        ID2.addActionListener(this);
        ID2.setBounds(100, 110, 95, 30);
        background.add(ID2);

        JButton ID3=new JButton("学  生");
        ID3.setFont(new Font("宋体", Font.PLAIN, 15));
        ID3.addActionListener(this);
        ID3.setBounds(100, 150, 95, 30);
        background.add(ID3);
    }
    public void actionPerformed(ActionEvent e){

        if(e.getActionCommand().equals("学  生")){
            StuAdd stuAdd=new StuAdd();
            stuAdd.setVisible(true);
        }
        if(e.getActionCommand().equals("老  师")){
            TeacherAdd teacherAdd=new TeacherAdd();
            teacherAdd.setVisible(true);
        }

    }
}
