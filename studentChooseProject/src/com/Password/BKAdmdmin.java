package com.Password;

import com.dao.GetBackPasswordOp;
import com.ui.ImageEg;
import com.ui.Rand;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import javax.swing.border.EmptyBorder;

public class BKAdmdmin extends JFrame implements ActionListener{
//    private JPanel contentPane;
    private JLabel lblUserName;
    private JLabel lblVerificationCode;
    private JTextField txtName;
    private JLabel lblVC;
    private JTextField VC;
    private JTextField txtVC;
    private JLabel lblUserPWD;
    private  JTextField passwordField;
    String rand="";
    public static void main(String[] args) {


    }
    public void BKAdmdmin(){

        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);//���ô���ر�ʱ��ʲô
        setBounds(150, 150, 350, 350);//���ô�����ֵ����꼰�����
        setTitle("����Ա�һ�����");//���ñ���
        ImageEg background=new ImageEg("image1.jpg");
        background.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(background);
        background.setLayout(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);//�Զ������������


        lblUserName = new JLabel("�û�������");
        lblUserName.setFont(new Font("����", Font.PLAIN, 15));//��������
        //Font.PLANIN ��ͨ��ʽ����
        //Font.BOLD   ������ʽ����
        //Font.ITALIC б����ʽ����
        lblUserName.setBounds(43, 1, 82, 36);
        background.add(lblUserName);

        lblUserPWD = new JLabel("��֤�룺");
        lblUserPWD.setFont(new Font("����", Font.PLAIN, 15));
        lblUserPWD.setBounds(43, 60, 82, 36);
        background.add(lblUserPWD);

        lblVerificationCode = new JLabel("���룺");
        lblVerificationCode.setFont(new Font("����", Font.PLAIN, 15));
        lblVerificationCode.setBounds(43, 120, 82, 36);
        background.add(lblVerificationCode);

        txtName = new JTextField();//���ɶ���
        txtName.setFont(new Font("����", Font.PLAIN, 15));
        txtName.setBounds(140, 1, 171, 36);
        background.add(txtName);
        txtName.setColumns(10);//�����ı�����һ�е��ַ���

        passwordField = new JTextField();
        passwordField.setBounds(140, 121, 171, 36);
        background.add(passwordField);

        txtVC = new JTextField();//���ɶ���
        txtVC.setFont(new Font("����", Font.PLAIN, 15));
        txtVC.setBounds(140, 60, 171, 36);
        background.add(txtVC);
        VC = new JTextField();//���ɶ���
        VC.setFont(new Font("����", Font.CENTER_BASELINE, 15));
        VC.setBounds(175, 181, 101, 36);
        background.add(VC);
        VC.setColumns(10);//�����ı�����һ�е��ַ���
//		VC.setEnabled(false);
        rand= Rand.getCharAndNumr(6);
        VC.setText(rand);

        JButton btnNewButton = new JButton("�һ�����");
        btnNewButton.setFont(new Font("����", Font.PLAIN, 15));
        btnNewButton.addActionListener(this);
        btnNewButton.setBounds(140, 256, 150, 30);
        background.add(btnNewButton);

    }
    public void actionPerformed(ActionEvent e){

        if(e.getActionCommand().equals("�һ�����")) {
        passwordField.setText("123456");
        }
    }

}
