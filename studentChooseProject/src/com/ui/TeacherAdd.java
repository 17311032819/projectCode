package com.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.Bean.Tb_course;
import com.Bean.Tb_major;
import com.Bean.Tb_teacher;
import com.dao.ClassOp;
import com.dao.CourseOp;
import com.dao.MajorOp;
import com.dao.TeacherOp;

import egtool.Judgeidexit;


public class TeacherAdd extends JFrame implements ActionListener {

//	private JPanel contentPane;
	private JLabel lblTeacherId;
	private JLabel lblTeacherName;
	private JLabel lblPassword;
	private JLabel lblTeacherMajor;
	private JTextField txtTeacherId;
	private JTextField txtTeacherName;
	private JComboBox coboMajorId=new JComboBox();
	private JLabel lblTeacherQQ;
	private JTextField txtTeacherQQ;
	
	private JButton btnadd;
	private JButton btncancle;
	Tb_teacher teacherInfo=new Tb_teacher();
	TeacherOp teacherInfoOp=new TeacherOp();
	MajorOp majorOp=new MajorOp();
	private JTextField txtPassword;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TeacherAdd();

	}
	public TeacherAdd(){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//���ô���ر�ʱ��ʲô
		setBounds(150, 150, 461, 452);//���ô�����ֵ����꼰�����
		setTitle("��ӽ�ʦ����");//���ñ���
		ImageEg background=new ImageEg("image1.jpg");
		background.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(background);
		background.setLayout(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);//�Զ������������

		JLabel lblmessage=new JLabel("\u8BF7\u586B\u5199\u6559\u5E08\u4FE1\u606F\uFF1A");
		lblmessage.setBounds(50, 20, 200, 30);
		background.add(lblmessage);
						
		lblTeacherId=new JLabel("��ʦ��ţ�");
		lblTeacherId.setBounds(50, 70, 70, 30);
		background.add(lblTeacherId);
		
		txtTeacherId=new JTextField();
		txtTeacherId.setBounds(120, 70, 150, 30);
		txtTeacherId.addFocusListener(new FocusListener() {		
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if(txtTeacherId.getText().trim().equals("")){
					JOptionPane.showMessageDialog(null, "��ʦ��ű���");
				}
				else{
					
					if(new Judgeidexit().judgeTeacherId(txtTeacherId.getText().trim())){
						teacherInfo.setTeacherId(txtTeacherId.getText().trim());
					}else{
						JOptionPane.showMessageDialog(null, "�ý�ʦ�Ѿ����ڣ�");
						txtTeacherId.setText("");
					}	
				}
			}			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				txtTeacherId.setText("");
			}
		});
		background.add(txtTeacherId);


		lblTeacherName=new JLabel("��ʦ������");
		lblTeacherName.setBounds(50, 110, 70, 30);
		background.add(lblTeacherName);
		
		txtTeacherName=new JTextField();
		txtTeacherName.setBounds(120, 110, 150, 30);
		background.add(txtTeacherName);
		
		lblPassword=new JLabel("��ʦ���룺");
		lblPassword.setBounds(50, 150, 70, 30);
		background.add(lblPassword);
		
		lblTeacherMajor=new JLabel("����רҵ��");
		lblTeacherMajor.setBounds(50, 201, 70, 30);
		background.add(lblTeacherMajor);
		
		coboMajorId.setBounds(120, 201, 150, 30);		
		List list=majorOp.getAllMajors();
		coboMajorId.addItem("");//��ӿհ���
		for(int i=0;i<list.size();i++){
			Tb_major major=(Tb_major)list.get(i);//���������ȡ��list�е�רҵ����
			coboMajorId.addItem(new Tb_major(major.getmajorId(),major.getmajorName()));//��רҵ�����רҵ��������ȡ������ӵ������б���
		}
		coboMajorId.addItemListener(new ItemListener() {		
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(e.getStateChange()==ItemEvent.SELECTED){					
					int index=coboMajorId.getSelectedIndex();	
					if(coboMajorId.getSelectedIndex()==0){
						JOptionPane.showMessageDialog(null, "��ѡ���Ӧ��רҵ");
					}else{
						Tb_major major=(Tb_major)list.get(index-1);					
						teacherInfo.setMajorId(major.getmajorId());						
					}									
				}
			}
		});
		background.add(coboMajorId);

		lblTeacherQQ=new JLabel("QQ����");
		lblTeacherQQ.setBounds(50,250,70,30);
		background.add(lblTeacherQQ);


		txtTeacherQQ=new JTextField();
		txtTeacherQQ.setBounds(120,250,150,30);
		background.add(txtTeacherQQ);



		btnadd=new JButton("���");
		btnadd.setBounds(120, 290, 70, 35);
		btnadd.addActionListener(this);
		background.add(btnadd);
		
		btncancle=new JButton("ȡ��");
		btncancle.setBounds(200, 290, 70, 35);
		btncancle.addActionListener(this);
		background.add(btncancle);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(120, 150, 150, 30);
		background.add(txtPassword);
		txtPassword.setColumns(10);
		setVisible(true);
		
	}
	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand().equals("���")){
			if(teacherInfo.getMajorId()==null){
				JOptionPane.showMessageDialog(null, "��ѡ���ʦ����רҵ");
				return;
			}
			Tb_major major=(Tb_major) coboMajorId.getSelectedItem();
			teacherInfo.setMajorId(major.getmajorId());
			teacherInfo.setTeacherName(txtTeacherName.getText().trim());
			teacherInfo.setPassword(txtPassword.getText().trim());
			teacherInfo.setMajorQQ(txtTeacherQQ.getText().trim());
			if(teacherInfoOp.addTeacher(teacherInfo)){
				JOptionPane.showMessageDialog(null, "��ӽ�ʦ�ɹ�");
			}
			
		}
		
	}

}
