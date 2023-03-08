package com.ui.Rider;

import aegtool.FontSize;
import aegtool.ImageEg;
import com.ui.Admin.Admin;
import com.ui.Admin.AdminLookOrder;
import com.ui.Admin.LookUserInformation;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Riders extends JFrame implements ActionListener {
    public static void main(String[] args) {
        new Riders().setVisible(true);
    }

    ImageEg background=new ImageEg("image1.jpg");

    public Riders(){
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
        JMenu menu1=new JMenu("接单");
        JMenu menu2=new JMenu("我的订单");
        JMenu menu3=new JMenu("个人信息管理");
        JMenu menu4=new JMenu("我的账户");


        menu1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

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
        menu4.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

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
        menuBar.add(menu4);
        background.add(menuBar,BorderLayout.WEST);
    }
    public void actionPerformed(ActionEvent e){

    }
}
