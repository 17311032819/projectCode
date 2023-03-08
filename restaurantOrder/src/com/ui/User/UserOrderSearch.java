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
    //¹¹Ôìº¯Êý
    public UserOrderSearch(ImageEg background){
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 1050, 1450);
        background.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(background);
        background.setLayout(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);//×Ô¶¯ÌøÖÁ½çÃæ×î´ó»¯
        setTitle("¿ìÀÖ²ÍÌüµã²Í");


        JButton btnTable1 = new JButton("1ºÅ×À");
        btnTable1.setBounds(410, 10, 410, 300);
        btnTable1.addActionListener(this);
        background.add(btnTable1);

        JButton btnTable2 = new JButton("2ºÅ×À");
        btnTable2.addActionListener(this);
        btnTable2.setBounds(950, 10,410,300 );
        background.add(btnTable2);

        JButton btnTable3 = new JButton("3ºÅ×À");
        btnTable3.addActionListener(this);
        btnTable3.setBounds(1490, 10, 410, 300);
        background.add(btnTable3);


        JButton btnTable4 = new JButton("4ºÅ×À");
        btnTable4.addActionListener(this);
        btnTable4.setBounds(410, 400, 410, 300);
        background.add(btnTable4);


        JButton btnTable5 = new JButton("5ºÅ×À");
        btnTable5.addActionListener(this);
        btnTable5.setBounds(950, 400, 410, 300);
        background.add(btnTable5);

        JButton btnTable6 = new JButton("6ºÅ×À");
        btnTable6.addActionListener(this);
        btnTable6.setBounds(1490, 400, 410, 300);
        background.add(btnTable6);

        JButton btnTable7 = new JButton("7ºÅ×À");
        btnTable7.addActionListener(this);
        btnTable7.setBounds(410, 790, 410, 300);
        background.add(btnTable7);

        JButton btnTable8 = new JButton("8ºÅ×À");
        btnTable8.addActionListener(this);
        btnTable8.setBounds(950, 790, 410, 300);
        background.add(btnTable8);

        JButton btnTable9 = new JButton("9ºÅ×À");
        btnTable9.addActionListener(this);
        btnTable9.setBounds(1490, 790, 410, 300);
        background.add(btnTable9);


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("1ºÅ×À")){
            System.out.println(1);
        }
        if (e.getActionCommand().equals("2ºÅ×À")){
            System.out.println(2);
        }
        if (e.getActionCommand().equals("3ºÅ×À")){
            System.out.println(3);
        }
        if (e.getActionCommand().equals("4ºÅ×À")){
            System.out.println(4);
        }
        if (e.getActionCommand().equals("5ºÅ×À")){
            System.out.println(5);
        }
        if (e.getActionCommand().equals("6ºÅ×À")){
            System.out.println(6);
        }
        if (e.getActionCommand().equals("7ºÅ×À")){
            System.out.println(7);
        }
        if (e.getActionCommand().equals("8ºÅ×À")){
            System.out.println(8);
        }
        if (e.getActionCommand().equals("9ºÅ×À")){
            System.out.println(9);
        }


    }

}


