package com.Test;

import aegtool.ImageEg;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class AddTableAmount extends JFrame implements ActionListener  {
    private JLabel Previoustable;
    private JLabel Addtable;
    private JTextField txtPrevioustable;
    private JTextField textAddtable;


    public String lgrole;//��¼����ݣ�����Ա����ʦ��ѧ��
    public String lgname;//��¼��ID



    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ImageEg ba=new ImageEg("j");
        AddTableAmount stuLg=new AddTableAmount(ba);
        stuLg.setVisible(true);


    }
    //���캯��
    public AddTableAmount(ImageEg background){
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(0, 0, 1050, 1450);
        background.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(background);
        background.setLayout(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);//�Զ������������
        setTitle("���Ӳ�Ʒ");


        Previoustable = new JLabel("��ǰ���ӣ�");
        //lblUserName.setFont(new Font("����", Font.PLAIN, 15));//��������
        //Font.PLANIN ��ͨ��ʽ����
        //Font.BOLD   ������ʽ����
        //Font.ITALIC б����ʽ����
        Previoustable.setBounds(573, 251, 82, 36);
        background.add(Previoustable);

        Addtable = new JLabel("�������� ��");
        //lblUserPWD.setFont(new Font("����", Font.PLAIN, 15));
        Addtable.setBounds(573, 310, 182, 36);
        background.add(Addtable);



        txtPrevioustable = new JTextField();//���ɶ���
        //txtName.setFont(new Font("����", Font.PLAIN, 15));
        txtPrevioustable.setBounds(670, 251, 171, 36);
        background.add(txtPrevioustable);
        txtPrevioustable.setColumns(10);//�����ı�����һ�е��ַ���

        textAddtable = new JTextField();
        textAddtable.setBounds(670, 310, 171, 36);
        background.add(textAddtable);

        JButton btnNewButton = new JButton("ȷ��");
        btnNewButton.addActionListener(this);
        btnNewButton.setBounds(675, 400, 65, 30);
        background.add(btnNewButton);
        btnNewButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub

            }
        });
    }
    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub

    }





}








