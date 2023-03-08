package com.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.Bean.Tb_major;
import com.dao.MajorOp;

import egtool.Judgeidexit;

public class Major_AddFm extends JFrame implements ActionListener {


	private JLabel lblMajorId;
	private JLabel lblMajorName;
	private JLabel lblMajorMaster;
	private JLabel lblMasjorMasterPhone;
	private JTextField txtMajorId;
	private JTextField txtMajorName;
	private JTextField txtMasjorMaster;
	private JTextField txtMasjorMasterPhone;
	private JButton btnadd;
	private JButton btncancle;
	
	Tb_major major=new Tb_major();
	MajorOp majorOp=new MajorOp();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Major_AddFm frame = new Major_AddFm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Major_AddFm() {
		ImageEg background=new ImageEg("image1.jpg");
		background.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(background);
		background.setLayout(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);//自动跳至界面最大化
		setTitle("添加专业");
		
		JLabel lblmessage=new JLabel("请填写专业信息：");
		lblmessage.setBounds(50, 20, 200, 30);
		background.add(lblmessage);
						
		lblMajorId=new JLabel("专业编号：");
		lblMajorId.setBounds(50, 70, 100, 30);
		background.add(lblMajorId);
		
		txtMajorId=new JTextField();
		txtMajorId.setBounds(120, 70, 150, 30);
		txtMajorId.addFocusListener(new FocusListener() {		
			@Override
			public void focusLost(FocusEvent e) {
				//专业编号必填检测
				if(txtMajorId.getText().trim().equals("")){
					JOptionPane.showMessageDialog(null, "专业编号必填");
				}
				else{
					//专业编号不能重复，查重
					if(new Judgeidexit().judgeMajorId(txtMajorId.getText().trim())){
						major.setmajorId(txtMajorId.getText().trim());
					}else{
						JOptionPane.showMessageDialog(null, "该专业已经存在！");
						txtMajorId.setText("");
					}	
				}
			}			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				txtMajorId.setText("");
			}
		});
		background.add(txtMajorId);
		
		lblMajorName=new JLabel("专业名称 ：");
		lblMajorName.setBounds(50, 110, 100, 30);
		background.add(lblMajorName);
		
		txtMajorName=new JTextField();
		txtMajorName.setBounds(120, 110, 150, 30);
		background.add(txtMajorName);
		
		lblMajorMaster=new JLabel("专业主任：");
		lblMajorMaster.setBounds(50, 150, 100, 30);
		background.add(lblMajorMaster);
		
		txtMasjorMaster=new JTextField();
		txtMasjorMaster.setBounds(120, 150, 150, 30);
		background.add(txtMasjorMaster);
		
		lblMasjorMasterPhone=new JLabel("联系电话：");
		lblMasjorMasterPhone.setBounds(50, 190, 100, 30);
		background.add(lblMasjorMasterPhone);
		
		txtMasjorMasterPhone=new JTextField();
		txtMasjorMasterPhone.setBounds(120, 190, 150, 30);
		background.add(txtMasjorMasterPhone);
			
		btnadd=new JButton("添加");
		btnadd.setBounds(120, 240, 70, 35);
		btnadd.addActionListener(this);
		background.add(btnadd);
		
		btncancle=new JButton("取消");
		btncancle.setBounds(200, 240, 70, 35);
		btncancle.addActionListener(this);
		background.add(btncancle);
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand().equals("添加")){
			major.setmajorId(txtMajorId.getText().trim());
			major.setmajorName(txtMajorName.getText().trim());
			major.setmajorMaster(txtMasjorMaster.getText().trim());
			major.setmajorMasterPhone(txtMasjorMasterPhone.getText().trim());
			if(majorOp.addMajor(major)){
				JOptionPane.showMessageDialog(null, "添加专业成功！");
			}else{
				JOptionPane.showMessageDialog(null, "添加专业失败！");
			}
		}
		
	}

}
