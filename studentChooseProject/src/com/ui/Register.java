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
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//���ô���ر�ʱ��ʲô
        setBounds(100, 100, 450, 300);//���ô�����ֵ����꼰�����
        setTitle("ע��");//���ñ���
        ImageEg background=new ImageEg("image1.jpg");
        background.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(background);
        background.setLayout(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);//�Զ������������


        txttitle=new JTextField("ѡ��������");
        txttitle.setFont(new Font("����", Font.PLAIN, 25));
        txttitle.setBounds(80,70,200,40);
        txttitle.setEnabled(false);
        background.add(txttitle);

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

        if(e.getActionCommand().equals("ѧ  ��")){
            StuAdd stuAdd=new StuAdd();
            stuAdd.setVisible(true);
        }
        if(e.getActionCommand().equals("��  ʦ")){
            TeacherAdd teacherAdd=new TeacherAdd();
            teacherAdd.setVisible(true);
        }

    }
}
