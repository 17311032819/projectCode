package com.Test;

import aegtool.ImageEg;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;



public class ChangePassword extends JFrame implements ActionListener  {
    /**
     *
     */
    private static final long serialVersionUID = -2697972101978159177L;
    private JLabel lblUserName;
    private JLabel lblUserName1;
    private JLabel lblUserName0;
    private JTextField txtName;
    private JTextField txtName1;
    private JTextField txtName0;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ChangePassword stuLg=new ChangePassword ();
        stuLg.setVisible(true);


    }
    //���캯��
    public ChangePassword(){
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 1050, 1450);
        ImageEg background=new ImageEg("image1.jpg");
        background.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(background);
        background.setLayout(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);//�Զ������������
        setTitle("�޸�����");


        lblUserName = new JLabel("ԭ����");
        lblUserName.setFont(new Font("����", Font.PLAIN, 15));
        lblUserName.setBounds(73, 61, 82, 36);
        background.add(lblUserName);

        txtName = new JTextField("");//   �ı�   �����������
        txtName.setFont(new Font("����", Font.PLAIN, 15));
        txtName.setBounds(120, 61, 171, 36);
        background.add(txtName);
        txtName.setColumns(10);



        lblUserName1 = new JLabel("������");
        lblUserName1.setFont(new Font("����", Font.PLAIN, 15));
        lblUserName1.setBounds(73, 130, 82, 36);
        background.add(lblUserName1);


        txtName1 = new JTextField("");//   �ı�   �����������
        txtName1.setFont(new Font("����", Font.PLAIN, 15));
        txtName1.setBounds(120, 130, 171, 36);
        background.add(txtName1);
        txtName1.setColumns(10);


        lblUserName0 = new JLabel("ȷ��������");
        lblUserName0.setFont(new Font("����", Font.PLAIN, 15));
        lblUserName0.setBounds(40, 222, 82, 36);
        background.add(lblUserName0);

        txtName0 = new JTextField("");//   �ı�   �����������
        txtName0.setFont(new Font("����", Font.PLAIN, 15));
        txtName0.setBounds(120, 222, 171, 36);
        background.add(txtName0);
        txtName0.setColumns(10);

        JButton btnNewButton = new JButton("ȷ���޸�");
        btnNewButton.addActionListener(this);
        btnNewButton.setBounds(275, 335, 100, 30);
        background.add(btnNewButton);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals("ȷ���޸�")){
            System.out.println("ȷ���޸�");
        }
    }
}

