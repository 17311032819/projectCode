package com.Password;


import com.dao.RememberPasswordOp;
import com.email.SendCode;
import aegtool.FontSize;
import aegtool.ImageEg;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import static com.email.CheckCode.getCheckCode;


public class FindBackPassword extends JFrame implements ActionListener  {
    private JLabel lblAuthCode;
    private JLabel lblPhone;
    private JLabel lblPassword;

    private JTextField txtAuthCode;
    private JTextField txtPhone;
    private JTextField txtPassword;
    String code=getCheckCode();
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new FontSize().InitGlobalFont(new Font("΢���ź�", Font.BOLD, 20));

        ImageEg background=new ImageEg("image1.jpg");

        FindBackPassword stuLg=new FindBackPassword(background);
        stuLg.setVisible(true);
    }
    //���캯��
    public FindBackPassword(ImageEg background){
        background.removeAll();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 1050, 1450);

        background.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(background);
        background.setLayout(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);//�Զ������������
        setTitle("���ֲ������");

        lblPhone=new JLabel("��������");
        lblPhone.setBounds(500,100,200,50);
        background.add(lblPhone);


        txtPhone=new JTextField();
        txtPhone.setBounds(700,100,250,50);
        background.add(txtPhone);

        JButton btnSend=new JButton("������֤��");
        btnSend.setBounds(960,100,200,50);
        btnSend.addActionListener(this);
        background.add(btnSend);



        lblAuthCode = new JLabel("������֤�룺");
        lblAuthCode.setBounds(500, 200, 200, 50);
        background.add(lblAuthCode);



        txtAuthCode = new JTextField();//���ɶ���
        //txtName.setFont(new Font("����", Font.PLAIN, 15));
        txtAuthCode.setBounds(700, 200, 250, 50);
        background.add(txtAuthCode);


        JButton btnNewButton = new JButton("ȷ��");
        btnNewButton.addActionListener(this);

        lblPassword=new JLabel("���������");
        lblPassword.setBounds(500,300,200,50);
        lblPassword.setVisible(false);
        background.add(lblPassword);

        txtPassword=new JTextField();
        txtPassword.setBounds(700,300,250,50);
        txtPassword.setVisible(false);
        background.add(txtPassword);

        btnNewButton.setBounds(780, 500, 100, 50);
        background.add(btnNewButton);


    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
//        3306236228@qq.com  3033774629@qq.com
        if (e.getActionCommand().equals("������֤��")){
            if (qq(txtPhone.getText())==true){
                try {
                   code= new SendCode().sendCode(txtPhone.getText().trim());
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }

            }
            else {
                JOptionPane.showMessageDialog(null,"������ȷ����");
            }
        }
        if (e.getActionCommand().equals("ȷ��")){
           if (code.equals(txtAuthCode.getText().trim())){
               lblPassword.setVisible(true);
               txtPassword.setVisible(true);
               try {
                   Thread.sleep(2000);
               } catch (InterruptedException interruptedException) {
                   interruptedException.printStackTrace();
               }
               RememberPasswordOp rememberPasswordOp=new RememberPasswordOp();
               String password=rememberPasswordOp.getPasswordByUserEmail2(txtPhone.getText().trim());
               txtPassword.setText(password);
            }
           else{
               JOptionPane.showMessageDialog(null,"��֤�����");
               code=getCheckCode();
           }
        }
    }

    public boolean qq(String qq){
        boolean isQQ=false;
        String regex = "[1-9][0-9]{4,9}\\@[q][q]\\.[c][o][m]";
        if(qq.trim().matches(regex)){
            isQQ=true;
        }
        return isQQ;
    }

}

