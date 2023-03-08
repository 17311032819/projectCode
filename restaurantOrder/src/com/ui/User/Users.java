package com.ui.User;

import aegtool.FontSize;
import aegtool.ImageEg;
import com.Test.AddTableAmount;
import com.ui.Admin.AdminLookOrder;
import com.ui.Shop.AddFood;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Users extends JFrame implements ActionListener {
    public static ImageEg background=new ImageEg("image1.jpg");

    public static void main(String[] args) {
        new FontSize().InitGlobalFont(new Font("微软雅黑", Font.BOLD, 20));

        new Users().setVisible(true);
    }
    public Users(){
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 550, 450);
        background.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(background);
        background.setLayout(new BorderLayout());
        setExtendedState(JFrame.MAXIMIZED_BOTH);//自动跳至界面最大化
        setTitle("用户");

        JMenuBar menuBar=new JMenuBar();
        menuBar.setLayout(new GridLayout(20,1));
        JMenu menu1=new JMenu("餐厅点餐  ");
        menu1.setFont(new Font("宋体",Font.BOLD,25));
        JMenu menu2=new JMenu("菜品管理  ");
        menu2.setFont(new Font("宋体",Font.BOLD,25));
        JMenu menu3=new JMenu("订单管理  ");
        menu3.setFont(new Font("宋体",Font.BOLD,25));
        JMenu menu4=new JMenu("评论管理");
        menu4.setFont(new Font("宋体",Font.BOLD,25));
        JMenu menu5=new JMenu("桌子管理");
        menu5.setFont(new Font("宋体",Font.BOLD,25));

        JMenuItem menuItem1=new JMenuItem("删除菜品");
        JMenuItem menuItem2=new JMenuItem("添加菜品");
        menuItem1.setFont(new Font("微软雅黑",Font.BOLD,20));
        menuItem2.setFont(new Font("微软雅黑",Font.BOLD,20));
        menuItem1.addActionListener(this);
        menuItem2.addActionListener(this);
        menu2.add(menuItem1);
        menu2.add(menuItem2);

        menu1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new UserOrderShop("3033774629@qq.com","快乐餐厅").setVisible(true);
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
        menu5.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new AddTableAmount(background).setVisible(true);

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
        menuBar.add(menu5);
        background.add(menuBar,BorderLayout.WEST);

    }
    public void actionPerformed(ActionEvent e){

        if (e.getActionCommand().equals("删除菜品")){

        }
        if (e.getActionCommand().equals("添加菜品")){
            new AddFood(background).setVisible(true);
        }
    }
}
