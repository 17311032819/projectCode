package com.ui.Shop;

import com.ui.Admin.AdminLookOrder;
import aegtool.FontSize;
import aegtool.ImageEg;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ShopBoss extends JFrame implements ActionListener {
    public static void main(String[] args) {

        new ShopBoss().setVisible(true);
    }

    ImageEg background=new ImageEg("image1.jpg");

    public ShopBoss(){
//        ����ȫ������
        new FontSize().InitGlobalFont(new Font("΢���ź�", Font.BOLD, 20));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 550, 450);
        background.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(background);
        background.setLayout(new BorderLayout());
        setExtendedState(JFrame.MAXIMIZED_BOTH);//�Զ������������
        setTitle("����");

        JMenuBar menuBar=new JMenuBar();
        menuBar.setLayout(new GridLayout(20,1));
        JMenu menu1=new JMenu("��Ʒ����  ");
        JMenu menu2=new JMenu("�鿴��������  ");
        JMenu menu3=new JMenu("��������  ");


        JMenuItem menuItem1=new JMenuItem("ɾ����Ʒ");
        JMenuItem menuItem2=new JMenuItem("��Ӳ�Ʒ");
        menuItem1.setFont(new Font("΢���ź�",Font.BOLD,20));
        menuItem2.setFont(new Font("΢���ź�",Font.BOLD,20));
        menuItem1.addActionListener(this);
        menuItem2.addActionListener(this);
        menu1.add(menuItem1);
        menu1.add(menuItem2);

        menu2.addMouseListener(new MouseListener() {
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

        if (e.getActionCommand().equals("ɾ����Ʒ")){

        }
        if (e.getActionCommand().equals("��Ӳ�Ʒ")){
            new AddFood(background).setVisible(true);
        }
    }
}
