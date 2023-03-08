package com.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.Bean.Tb_stuinfo;
import com.dao.StuinfoOp;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

public class StuInfoManagement extends JFrame implements ActionListener {

//	private JPanel contentPane;
	private JTextField txtStuId;
	private JTextField txtStuName;
	private JComboBox cobostusex;
	private JTextField txtStuPhone;
	private JTextField txtStuClassName;
	private JPasswordField txtStuPassword;
	private JPasswordField txtStuNewPassword;
	Tb_stuinfo stuinfo;
	StuinfoOp stuinfoOp=new StuinfoOp();
	public String lgname;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//new TeacherAdd();
		new StuInfoManagement("19302030101").setVisible(true);

	}
	/**
	 * Create the frame.
	 */
	public StuInfoManagement(String stuId) {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 320, 420);

		setTitle("个人信息管理");
		ImageEg background=new ImageEg("image1.jpg");
		background.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(background);
		background.setLayout(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);//自动跳至界面最大化

		lgname=stuId;

		stuinfo=stuinfoOp.getStuByStuId(lgname);

		JLabel lblStuId = new JLabel("学生学号：");
		lblStuId.setBounds(40, 40, 60, 20);
		background.add(lblStuId);

		txtStuId=new JTextField();
		txtStuId.setBounds(105,40,150,20);
		txtStuId.setEditable(false);
		txtStuId.setText(stuinfo.getstu_id());
		background.add(txtStuId);


		JLabel lblStuName = new JLabel("学生姓名：");
		lblStuName.setBounds(40, 80, 60, 20);
		background.add(lblStuName);

		txtStuName = new JTextField();
		txtStuName.setBounds(105, 80, 150, 20);
		txtStuName.setText(stuinfo.getstu_name());
		background.add(txtStuName);

		JLabel lblStuSex=new JLabel("学生性别：");
		lblStuSex.setBounds(40,120,60,20);
		background.add(lblStuSex);

		cobostusex=new JComboBox();
		cobostusex.setBounds(105, 120, 150, 20);
		String[] listData = new String[]{"","女","男" };
		DefaultComboBoxModel dfc=new DefaultComboBoxModel(listData);
		cobostusex.setModel(dfc);
		if(stuinfo.getstu_sex().equals("男")){
			cobostusex.setSelectedIndex(2);
		}else {
			cobostusex.setSelectedIndex(1);
		}
		//stuinfo.setstu_sex(stuinfo.getstu_sex());
		cobostusex.addItemListener(new ItemListener(){
			@Override
			public void itemStateChanged(ItemEvent e ){
				// TODO Auto-generated method stub
				if(e.getStateChange()==ItemEvent.SELECTED){
					stuinfo.setstu_sex(cobostusex.getSelectedItem().toString());
					//txtname.setText(cobpower.getSelectedItem().toString());
				}
			}
		});
		background.add(cobostusex);

		JLabel lblStuPhone=new JLabel("学生电话：");
		lblStuPhone.setBounds(40,160,60,20);
		background.add(lblStuPhone);

		txtStuPhone=new JTextField();
		txtStuPhone.setBounds(105,160,150,20);
		txtStuPhone.setText(stuinfo.getstu_phone());
		background.add(txtStuPhone);

		JLabel lblStuClassName=new JLabel("学生班级：");
		lblStuClassName.setBounds(40,200,60,20);
		background.add(lblStuClassName);

		txtStuClassName=new JTextField();
		txtStuClassName.setBounds(105,200,150,20);
		txtStuClassName.setEditable(false);
		txtStuClassName.setText(stuinfoOp.getNameById(stuinfo.getstu_classid()));
		background.add(txtStuClassName);

		JLabel lblStuPassword=new JLabel("旧密码：");
		lblStuPassword.setBounds(40,240,60,20);
		background.add(lblStuPassword);

		txtStuPassword=new JPasswordField();
		txtStuPassword.setBounds(105,240,150,20);
		txtStuPassword.setText(stuinfo.getstu_password());
		background.add(txtStuPassword);

		JLabel lblStuNewPassword=new JLabel("新密码：");
		lblStuNewPassword.setBounds(40,280,60,20);
		background.add(lblStuNewPassword);

		txtStuNewPassword=new JPasswordField();
		txtStuNewPassword.setBounds(105,280,150,20);
		background.add(txtStuNewPassword);

		JButton btnCancle = new JButton("取消");
		btnCancle.setBounds(105, 320, 75, 30);
		background.add(btnCancle);
		btnCancle.addActionListener(this);

		JButton btnModify = new JButton("修改");
		btnModify.setBounds(180, 320, 75, 30);
		background.add(btnModify);
		btnModify.addActionListener(this);

		setVisible(true);
	}
	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand().equals("取消")){
			this.hide();
		}
		if(e.getActionCommand().equals("修改")){
			//stuinfo.setstu_id(txtStuId.getText());			
			stuinfo.setstu_name(txtStuName.getText());
			stuinfo.setstu_phone(txtStuPhone.getText());
			if(new String(txtStuNewPassword.getPassword()).length()>0){
				stuinfo.setstu_password(new String(txtStuNewPassword.getPassword()));
			}

			if(stuinfoOp.modifyStuInfo(stuinfo)){
				JOptionPane.showMessageDialog(null, "个人信息修改成功！");
			}else{
				JOptionPane.showMessageDialog(null, "修改失败，请联系管理员！");
			}
		}
	}
}
