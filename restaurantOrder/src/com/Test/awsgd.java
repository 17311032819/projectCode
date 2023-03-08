package com.Test;

import aegtool.OrderModel;
import aegtool.UserModel;
import aegtool.ImageEg;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class awsgd extends JFrame {
    ImageEg background=new ImageEg("image1.jpg");
    JTable table=new JTable();
    JScrollPane scrollPane=new JScrollPane();
    OrderModel orderModel=new OrderModel();

    public static void main(String[] args) {
        awsgd awsgd=new awsgd();
        awsgd.setVisible(true);
    }


    public awsgd(){
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 550, 450);
        background.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(background);
        background.setLayout(new BorderLayout());
        setExtendedState(JFrame.MAXIMIZED_BOTH);//自动跳至界面最大化
        setTitle("用户");

        table=new JTable(new UserModel().UserModel());
        scrollPane=new JScrollPane(table);
        scrollPane.setBounds(100,100,200,200);
        background.add(scrollPane);

    }
}
