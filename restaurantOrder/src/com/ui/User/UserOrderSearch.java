package com.ui.User;

import aegtool.ImageEg;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class UserOrderSearch extends JFrame implements ActionListener  {
    /**
     *
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ImageEg background=new ImageEg("image1.jpg");
        new UserOrderSearch(background).setVisible(true);
    }
    //���캯��
    public UserOrderSearch(ImageEg background){
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 1050, 1450);
        background.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(background);
        background.setLayout(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);//�Զ������������
        setTitle("���ֲ������");


        JButton btnTable1 = new JButton("1����");
        btnTable1.setBounds(410, 10, 410, 300);
        btnTable1.addActionListener(this);
        background.add(btnTable1);

        JButton btnTable2 = new JButton("2����");
        btnTable2.addActionListener(this);
        btnTable2.setBounds(950, 10,410,300 );
        background.add(btnTable2);

        JButton btnTable3 = new JButton("3����");
        btnTable3.addActionListener(this);
        btnTable3.setBounds(1490, 10, 410, 300);
        background.add(btnTable3);


        JButton btnTable4 = new JButton("4����");
        btnTable4.addActionListener(this);
        btnTable4.setBounds(410, 400, 410, 300);
        background.add(btnTable4);


        JButton btnTable5 = new JButton("5����");
        btnTable5.addActionListener(this);
        btnTable5.setBounds(950, 400, 410, 300);
        background.add(btnTable5);

        JButton btnTable6 = new JButton("6����");
        btnTable6.addActionListener(this);
        btnTable6.setBounds(1490, 400, 410, 300);
        background.add(btnTable6);

        JButton btnTable7 = new JButton("7����");
        btnTable7.addActionListener(this);
        btnTable7.setBounds(410, 790, 410, 300);
        background.add(btnTable7);

        JButton btnTable8 = new JButton("8����");
        btnTable8.addActionListener(this);
        btnTable8.setBounds(950, 790, 410, 300);
        background.add(btnTable8);

        JButton btnTable9 = new JButton("9����");
        btnTable9.addActionListener(this);
        btnTable9.setBounds(1490, 790, 410, 300);
        background.add(btnTable9);


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("1����")){
            System.out.println(1);
        }
        if (e.getActionCommand().equals("2����")){
            System.out.println(2);
        }
        if (e.getActionCommand().equals("3����")){
            System.out.println(3);
        }
        if (e.getActionCommand().equals("4����")){
            System.out.println(4);
        }
        if (e.getActionCommand().equals("5����")){
            System.out.println(5);
        }
        if (e.getActionCommand().equals("6����")){
            System.out.println(6);
        }
        if (e.getActionCommand().equals("7����")){
            System.out.println(7);
        }
        if (e.getActionCommand().equals("8����")){
            System.out.println(8);
        }
        if (e.getActionCommand().equals("9����")){
            System.out.println(9);
        }


    }

}


