package com.ui.Admin;

import aegtool.FontSize;
import aegtool.ImageEg;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Admin extends JFrame implements ActionListener {
    public static void main(String[] args) {
        new Admin().setVisible(true);
    }

    ImageEg background=new ImageEg("image1.jpg");

    public Admin(){
//        设置全局字体
        new FontSize().InitGlobalFont(new Font("微软雅黑", Font.BOLD, 20));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 550, 450);
        background.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(background);
        background.setLayout(new BorderLayout());
        setExtendedState(JFrame.MAXIMIZED_BOTH);//自动跳至界面最大化
        setTitle("管理员");

        JMenuBar menuBar=new JMenuBar();
        menuBar.setLayout(new GridLayout(20,1));
        JMenu menu1=new JMenu("用户管理  ");
        menu1.setFont(new Font("宋体",Font.BOLD,25));
        JMenu menu2=new JMenu("店铺管理  ");
        menu2.setFont(new Font("宋体",Font.BOLD,25));
        JMenu menu3=new JMenu("订单管理  ");
        menu3.setFont(new Font("宋体",Font.BOLD,25));


        JMenuItem menuItem1=new JMenuItem("查看店铺");
        JMenuItem menuItem2=new JMenuItem("店铺申请处理");
        menuItem1.setFont(new Font("微软雅黑",Font.BOLD,20));
        menuItem2.setFont(new Font("微软雅黑",Font.BOLD,20));
        menuItem1.addActionListener(this);
        menuItem2.addActionListener(this);
        menu2.add(menuItem1);
        menu2.add(menuItem2);

        menu1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new LookUserInformation(background).setVisible(true);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        menu3.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new AdminLookOrder().setVisible(true);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        menuBar.add(menu1);
        menuBar.add(menu2);
        menuBar.add(menu3);
        background.add(menuBar,BorderLayout.WEST);
    }
    public void actionPerformed(ActionEvent e){

        if (e.getActionCommand().equals("查看店铺")){
            System.out.println("查看");
        }
        if (e.getActionCommand().equals("店铺申请处理")){

            System.out.println("处理");
        }
    }
}
