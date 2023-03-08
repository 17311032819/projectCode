package com.Password;

import com.Bean.Tb_stuinfo;
import com.Bean.Tb_teacher;
import com.dao.StuinfoOp;
import com.dao.TeacherOp;
import com.ui.ImageEg;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class teacherCode extends JFrame implements ActionListener {
    public static void main(String[] args) {
        new stuCode().setVisible(true);
    }

    private JLabel lblName;
    private JTextField txtName;
    Tb_teacher teacher=new Tb_teacher();
    TeacherOp teacherOp=new TeacherOp();
    public teacherCode(){
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
            String ID=new String();
            ID=txtName.getText();
            String qq=new String();
            teacher=teacherOp.getTeacherInfoById(ID);
            qq=teacher.getMajorQQ();
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
            BKTeacher teacher=new BKTeacher();
            teacher.BKTeacher(ID,str);
        }

    }

}
