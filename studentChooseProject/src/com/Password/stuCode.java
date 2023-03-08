package com.Password;

import com.Bean.Tb_stuinfo;
import com.dao.StuinfoOp;
import com.ui.ImageEg;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class stuCode extends JFrame implements ActionListener {
    public static void main(String[] args) {
        new stuCode().setVisible(true);
    }

    private JLabel lblName;
    private JTextField txtName;
    Tb_stuinfo stuinfo=new Tb_stuinfo();
    StuinfoOp stuinfoOp=new StuinfoOp();
    public stuCode(){
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);//���ô���ر�ʱ��ʲô
        setBounds(150, 150, 350, 350);//���ô�����ֵ����꼰�����
        setTitle("�����˺�");//���ñ���
        ImageEg background=new ImageEg("image1.jpg");
        background.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(background);
        background.setLayout(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);//�Զ������������
        setVisible(true);

        lblName =new JLabel("�����������");
        lblName.setBounds(400,300,90,36);
        background.add(lblName);


        txtName=new JTextField();
        txtName.setBounds(500,300,200,36);
        background.add(txtName);

        JButton btnnext=new JButton("��һ��");
        btnnext.setBounds(710,300,100,36);
        btnnext.addActionListener(this);
        background.add(btnnext);
    }


    public void actionPerformed(ActionEvent e){

        if (e.getActionCommand().equals("��һ��")){
            String stuId=new String();
            stuId=txtName.getText();
            String qq=new String();
            stuinfo=stuinfoOp.getStuByStuId(stuId);
            qq=stuinfo.getstu_QQ();
            SendEmail sendEmail=new SendEmail();
            //����Ҫ���͵�����
            sendEmail.setReceiveMailAccount(qq);
            //����6λ��֤��
            Random random=new Random();
            String str="";
            for(int i=0;i<6;i++) {
                int n=random.nextInt(10);
                str+=n;
            }
            sendEmail.setInfo(str);
            try {
                sendEmail.Send();
            } catch (Exception er) {
                er.printStackTrace();
            }
            BAStudent baStudent=new BAStudent();
            baStudent.BAStudent(stuId,str);
        }

    }

}
