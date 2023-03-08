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

import com.Bean.Tb_class;
import com.Bean.Tb_course;
import com.Bean.Tb_stuinfo;
import com.dao.ClassOp;
import com.dao.CourseOp;
import com.dao.StuinfoOp;

import egtool.Judgeidexit;

public class StuAdd extends JFrame implements ActionListener {

	private JLabel lblstuid;
	private JLabel lblstuname;
	private JLabel lblstusex;
	private JLabel lblstuclassname;
	private JLabel lblstuphone;
	private JLabel lblstuqq;
	private JTextField txtstuid;
	private JTextField txtstuname;
	private JTextField txtstuqq;
	private JComboBox cobostusex=new JComboBox();
	private JComboBox cobostuclass=new JComboBox();;
	private JTextField txtstuphone;
	
	private JButton btnadd;
	private JButton btncancle;
	Tb_stuinfo stuinfo=new Tb_stuinfo();
	StuinfoOp stuinfoOp=new StuinfoOp();
	ClassOp cOp=new ClassOp();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new StuAdd();

	}
	public StuAdd(){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//设置窗体关闭时做什么
		setBounds(150, 150, 424, 422);//设置窗体出现的坐标及宽与高
		setTitle("添加学生界面");//设置标题
		ImageEg background=new ImageEg("image1.jpg");
		background.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(background);
		background.setLayout(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);//自动跳至界面最大化

		JLabel lblmessage=new JLabel("请填写学生信息：");
		lblmessage.setBounds(50, 20, 200, 30);
		background.add(lblmessage);
						
		lblstuid=new JLabel("学生学号：");
		lblstuid.setBounds(50, 70, 100, 30);
		background.add(lblstuid);
		
		txtstuid=new JTextField();
		txtstuid.setBounds(120, 70, 150, 30);
		background.add(txtstuid);
		txtstuid.addFocusListener(new FocusListener() {		
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if(txtstuid.getText().trim().equals("")){
					JOptionPane.showMessageDialog(null, "学生学号必填");
				}
				else{
					
					if(new Judgeidexit().judgeStuId(txtstuid.getText().trim())){
						stuinfo.setstu_id(txtstuid.getText().trim());
					}else{
						JOptionPane.showMessageDialog(null, "该学生已经存在！");
						txtstuid.setText("");
					}	
				}
			}			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				txtstuid.setText("");
			}
		});
		background.add(txtstuid);
		
		lblstuname=new JLabel("学生姓名 ：");
		lblstuname.setBounds(50, 110, 100, 30);
		background.add(lblstuname);
		
		txtstuname=new JTextField();
		txtstuname.setBounds(120, 110, 150, 30);
		background.add(txtstuname);
		
		lblstusex=new JLabel("学生性别：");
		lblstusex.setBounds(50, 150, 100, 30);
		background.add(lblstusex);
		
		cobostusex.setBounds(120, 150, 150, 30);
		String[] listData = new String[]{"","男", "女"};
		DefaultComboBoxModel dfc=new DefaultComboBoxModel(listData);
		cobostusex.setModel(dfc);
		stuinfo.setstu_sex("男");
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
		
		lblstuclassname=new JLabel("学生班级：");
		lblstuclassname.setBounds(50, 190, 100, 30);
		background.add(lblstuclassname);
		
		cobostuclass.setBounds(120, 190, 150, 30);		
		List list=cOp.getallclass();
		cobostuclass.addItem("");//添加空白项
		for(int i=0;i<list.size();i++){
			Tb_class tb_class=(Tb_class)list.get(i);//按序号依次取出list中的班级对象
			//cobostuclass.addItem(tb_class.getclassname());//将班级对象的班级名称属性取出来添加到下拉列表中
			cobostuclass.addItem(new Tb_class(tb_class.getclassid(),tb_class.getclassname()));
		}
		cobostuclass.addItemListener(new ItemListener() {		
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(e.getStateChange()==ItemEvent.SELECTED){					
					int index=cobostuclass.getSelectedIndex();	
					if(cobostuclass.getSelectedIndex()==0){
						JOptionPane.showMessageDialog(null, "请选择对应的班级");
					}else{
						Tb_class tc=(Tb_class)list.get(index-1);					
						stuinfo.setstu_classid(tc.getclassid());						
					}									
				}
			}
		});
		background.add(cobostuclass);
		
		lblstuphone=new JLabel("学生电话：");
		lblstuphone.setBounds(50, 230, 100, 30);
		background.add(lblstuphone);
		
		txtstuphone=new JTextField();
		txtstuphone.setBounds(120, 230, 150, 30);
		background.add(txtstuphone);

		lblstuqq=new JLabel("学生qq邮箱");
		lblstuqq.setBounds(50,270,100,30);
		background.add(lblstuqq);

		txtstuqq=new JTextField();
		txtstuqq.setBounds(120,270,150,30);
		background.add(txtstuqq);
		
		btnadd=new JButton("添加");
		btnadd.setBounds(120, 310, 70, 35);
		btnadd.addActionListener(this);
		background.add(btnadd);
		
		btncancle=new JButton("取消");
		btncancle.setBounds(200, 310, 70, 35);
		btncancle.addActionListener(this);
		background.add(btncancle);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand().equals("添加")){
			if(stuinfo.getstu_classid()==null){
				JOptionPane.showMessageDialog(null, "请选择学生所属班级");				
			}
			stuinfo.setstu_name(txtstuname.getText().trim());
			stuinfo.setstu_phone(txtstuphone.getText().trim());
			stuinfo.setstu_QQ(txtstuqq.getText().trim());
			if(stuinfoOp.addStu(stuinfo)){
				JOptionPane.showMessageDialog(null, "添加学生成功");
			}
			
		}
		
	}

}
