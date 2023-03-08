package com.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.Bean.Tb_teacher;
import com.dao.TeacherOp;

public class TeacherInfoManagement extends JFrame implements ActionListener{
//	private JPanel contentPane;
	public String teacherId;
	private JTextField txtTeacherId;
	private JTextField txtTeacherName;
	private JTextField txtMajorName;
	private JPasswordField txtTeacherOldPassword;
	private JPasswordField txtTeacherNewPassword;
	
	private JButton btnCancle;
	private JButton btnModify;
	
	
	Tb_teacher teacher;
	TeacherOp teacherOp=new TeacherOp();
	
	public TeacherInfoManagement(String teacher_Id){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 340, 340);

		setTitle("个人信息管理");
		ImageEg background=new ImageEg("image1.jpg");
		background.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(background);
		background.setLayout(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);//自动跳至界面最大化


		teacherId=teacher_Id;
		teacher=new TeacherOp().getTeacherInfoById(teacherId);
		
		JLabel lblTeacherId = new JLabel("教师编号：");
		lblTeacherId.setBounds(40, 40, 85, 30);
		background.add(lblTeacherId);
		
		txtTeacherId=new JTextField();
		txtTeacherId.setBounds(130,40,150,30);
		txtTeacherId.setEditable(false);
		txtTeacherId.setText(teacher.getTeacherId());
		background.add(txtTeacherId);
		
		JLabel lblTeacherName = new JLabel("教师姓名：");
		lblTeacherName.setBounds(40, 80, 85, 30);
		background.add(lblTeacherName);
		
		txtTeacherName=new JTextField();
		txtTeacherName.setBounds(130,80,150,30);
		txtTeacherName.setText(teacher.getTeacherName());
		background.add(txtTeacherName);
		
		JLabel lblMajorName = new JLabel("所属专业：");
		lblMajorName.setBounds(40, 120, 85, 30);
		background.add(lblMajorName);
		
		txtMajorName=new JTextField();
		txtMajorName.setBounds(130, 120, 150, 30);
		txtMajorName.setEditable(false);
		txtMajorName.setText(teacher.getMajorName());
		background.add(txtMajorName);
		
		JLabel lblTeacherPassword = new JLabel("旧密码：");
		lblTeacherPassword.setBounds(40, 160, 85, 30);
		background.add(lblTeacherPassword);
		
		txtTeacherOldPassword=new JPasswordField();
		txtTeacherOldPassword.setBounds(130,160,150,30);
		txtTeacherOldPassword.setText(teacher.getPassword());
		background.add(txtTeacherOldPassword);
		
		JLabel lblTeacherNewPassword = new JLabel("新密码：");
		lblTeacherNewPassword.setBounds(40, 200, 85, 30);
		background.add(lblTeacherNewPassword);
		
		txtTeacherNewPassword=new JPasswordField();
		txtTeacherNewPassword.setBounds(130,200,150,30);
		background.add(txtTeacherNewPassword);
		
		btnCancle=new JButton("取消");
		btnCancle.setBounds(130,240,70,30);
		btnCancle.addActionListener(this);
		background.add(btnCancle);
		
		btnModify=new JButton("修改");
		btnModify.setBounds(210,240,70,30);
		btnModify.addActionListener(this);
		background.add(btnModify);
		
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand().equals("取消")){
			this.hide();
		}
		if(e.getActionCommand().equals("修改")){
			teacher.setTeacherId(txtTeacherId.getText());
			teacher.setTeacherName(txtTeacherName.getText());
			teacher.setMajorId(teacher.getMajorId());
			String newpwd=new String(txtTeacherNewPassword.getPassword());
			if(newpwd.length()>0){
				teacher.setPassword(new String(txtTeacherNewPassword.getPassword()));
			}
			if(teacherOp.modifyTeacher(teacher)){
				JOptionPane.showMessageDialog(null, "个人信息修改成功！");
			}else{
				JOptionPane.showMessageDialog(null, "修改失败，请联系管理员！");
			}
			
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TeacherInfoManagement("123");

	}
}
