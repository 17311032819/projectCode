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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//设置窗体关闭时做什么
		setBounds(150, 150, 350, 300);//设置窗体出现的坐标及宽与高
		setTitle("添加课程界面");//设置标题
		ImageEg background=new ImageEg("image1.jpg");
		background.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(background);
		background.setLayout(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);//自动跳至界面最大化
		
		JLabel lblmessage=new JLabel("请填写课程信息：");
		lblmessage.setBounds(50, 20, 200, 30);
		background.add(lblmessage);
						
		lblcourseid=new JLabel("课程编号：");
		lblcourseid.setBounds(50, 70, 100, 30);
		background.add(lblcourseid);
		
		txtcid=new JTextField();
		txtcid.setBounds(120, 70, 150, 30);
		txtcid.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if(txtcid.getText().trim().equals("")){
					JOptionPane.showMessageDialog(null, "课程编号必填");
				}else{
					if(new Judgeidexit().judgeCourseId(txtcid.getText().trim())){
						course.setcourseid(txtcid.getText().trim());
					}else{
						JOptionPane.showMessageDialog(null, "该课程已经存在！");
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
		
		lblcoursename=new JLabel("课程名称：");
		lblcoursename.setBounds(50, 110, 100, 30);
		background.add(lblcoursename);
		
		txtcname=new JTextField();
		txtcname.setBounds(120, 110, 150, 30);
		background.add(txtcname);
		
		lblcoursecredit=new JLabel("课程学分：");
		lblcoursecredit.setBounds(50, 150, 100, 30);
		background.add(lblcoursecredit);
		
		txtccredit=new JTextField();
		txtccredit.setBounds(120, 150, 150, 30);
		background.add(txtccredit);
		
		btnadd=new JButton("添加");
		btnadd.setBounds(120, 210, 70, 35);
		btnadd.addActionListener(this);
		background.add(btnadd);
		
		btncancle=new JButton("取消");
		btncancle.setBounds(200, 210, 70, 35);
		btncancle.addActionListener(this);
		background.add(btncancle);
		
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand().equals("添加")){
			course.setcourseid(txtcid.getText().trim());
			course.setcoursename(txtcname.getText().trim());
			course.setcoursecredit(Integer.parseInt(txtccredit.getText().trim()));
			if(co.addCourse(course)){
				JOptionPane.showMessageDialog(null, "添加成功");
			}
		}
		
	}
	
}
