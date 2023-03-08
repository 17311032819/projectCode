package com.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import com.Bean.*;
import com.dao.*;

import egtool.Judgeidexit;

public  class  CourseAdd extends JFrame implements ActionListener{
	private JLabel lblcourseid;
	private JLabel lblcoursename;
	private JLabel lblcoursecredit;
	private JTextField txtcid;
	private JTextField txtcname;
	private JTextField txtccredit;
	private JButton btnadd;
	private JButton btncancle;
	Tb_course course=new Tb_course();
	CourseOp co=new CourseOp();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 new CourseAdd().setVisible(true);
	}
		
	public CourseAdd(){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//���ô���ر�ʱ��ʲô
		setBounds(150, 150, 350, 300);//���ô�����ֵ����꼰�����
		setTitle("��ӿγ̽���");//���ñ���
		ImageEg background=new ImageEg("image1.jpg");
		background.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(background);
		background.setLayout(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);//�Զ������������
		
		JLabel lblmessage=new JLabel("����д�γ���Ϣ��");
		lblmessage.setBounds(50, 20, 200, 30);
		background.add(lblmessage);
						
		lblcourseid=new JLabel("�γ̱�ţ�");
		lblcourseid.setBounds(50, 70, 100, 30);
		background.add(lblcourseid);
		
		txtcid=new JTextField();
		txtcid.setBounds(120, 70, 150, 30);
		txtcid.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if(txtcid.getText().trim().equals("")){
					JOptionPane.showMessageDialog(null, "�γ̱�ű���");
				}else{
					if(new Judgeidexit().judgeCourseId(txtcid.getText().trim())){
						course.setcourseid(txtcid.getText().trim());
					}else{
						JOptionPane.showMessageDialog(null, "�ÿγ��Ѿ����ڣ�");
						txtcid.setText("");
					}
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		background.add(txtcid);
		
		lblcoursename=new JLabel("�γ����ƣ�");
		lblcoursename.setBounds(50, 110, 100, 30);
		background.add(lblcoursename);
		
		txtcname=new JTextField();
		txtcname.setBounds(120, 110, 150, 30);
		background.add(txtcname);
		
		lblcoursecredit=new JLabel("�γ�ѧ�֣�");
		lblcoursecredit.setBounds(50, 150, 100, 30);
		background.add(lblcoursecredit);
		
		txtccredit=new JTextField();
		txtccredit.setBounds(120, 150, 150, 30);
		background.add(txtccredit);
		
		btnadd=new JButton("���");
		btnadd.setBounds(120, 210, 70, 35);
		btnadd.addActionListener(this);
		background.add(btnadd);
		
		btncancle=new JButton("ȡ��");
		btncancle.setBounds(200, 210, 70, 35);
		btncancle.addActionListener(this);
		background.add(btncancle);
		
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand().equals("���")){
			course.setcourseid(txtcid.getText().trim());
			course.setcoursename(txtcname.getText().trim());
			course.setcoursecredit(Integer.parseInt(txtccredit.getText().trim()));
			if(co.addCourse(course)){
				JOptionPane.showMessageDialog(null, "��ӳɹ�");
			}
		}
		
	}
	
}
