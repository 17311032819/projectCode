package com.ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import com.Password.*;

public class getBackPassword extends JFrame implements ActionListener {


    private JTextField txttitle;
    public static void main(String[] args) {
        getBackPassword help=new getBackPassword();
        help.setVisible(true);
    }
    public getBackPassword() {
        ImageEg background=new ImageEg("image1.jpg");
        background.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(background);
        background.setLayout(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);//�Զ������������
        setTitle("�һ�����");

        txttitle=new JTextField("ѡ��������");
        txttitle.setFont(new Font("����", Font.PLAIN, 25));
        txttitle.setBounds(80,20,200,40);
        txttitle.setEnabled(false);
        background.add(txttitle);


        JButton ID1=new JButton("����Ա");
        ID1.setFont(new Font("����", Font.PLAIN, 15));
        ID1.addActionListener(this);
        ID1.setBounds(100, 70, 95, 30);
        background.add(ID1);

        JButton ID2=new JButton("��  ʦ");
        ID2.setFont(new Font("����", Font.PLAIN, 15));
        ID2.addActionListener(this);
        ID2.setBounds(100, 110, 95, 30);
        background.add(ID2);


        JButton ID3=new JButton("ѧ  ��");
        ID3.setFont(new Font("����", Font.PLAIN, 15));
        ID3.addActionListener(this);
        ID3.setBounds(100, 150, 95, 30);
        background.add(ID3);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals("����Ա")){
            BKAdmdmin admin=new BKAdmdmin();
            admin.BKAdmdmin();
        }
        if(e.getActionCommand().equals("ѧ  ��")){
           stuCode stucode=new stuCode();
           stucode.setVisible(true);
        }
        if(e.getActionCommand().equals("��  ʦ")){
           teacherCode teachercode =new teacherCode();
           teachercode.setVisible(true);
        }

    }
}
