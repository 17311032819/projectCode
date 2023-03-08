package com.ui;
import javax.swing.*;

import com.dao.RecordOp;

import egtool.MyRecordTableModel;
import egtool.MyTableModel;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
public class StuSelectCourse extends JFrame implements ActionListener {
	public String stuId;
	public MyTableModel defaultModel=new MyTableModel();
	public MyRecordTableModel recordModel=new MyRecordTableModel(stuId);
	private JScrollPane jsp_table_all;
	private JTable jt_all=new JTable(defaultModel);
	private JScrollPane jsp_table_selected;
	private JTable jt_selected= new JTable(recordModel);
	private JPanel content;
	private JLabel jlb_selectedCourse;
	private JLabel jlb_allCourse;
	private JLabel jlb_coursename;
	private JLabel jlb_score;
	private JLabel jlb_credit;
	private JTextField jtf_coursename;
	private JTextField jtf_score;
	private JTextField jtf_credit;
	private JButton jbt_del_course;
	JTextField jTxtCourseId;
	JTextField jTxtCourseName;
	JTextField jTxtCourseCredit;
	
	
	
	public static void main(String[] args)
	{
		new StuSelectCourse("19302030102");
	}
	
	public JTable getAllCourse() //��ʾ���пγ�
	{		
		//defaultModel = new MyTableModel();
		//jt_all = new JTable(defaultModel);
		jt_all.setPreferredScrollableViewportSize(new Dimension(780,200));//���ô˱���ͼ��ѡ��С					
		jt_all.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  //��ѡ
			
		jt_all.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{				
				int row = jt_all.getSelectedRow();
				jTxtCourseId.setText((String)(jt_all.getValueAt(row, 0)));
				jTxtCourseName.setText((String)(jt_all.getValueAt(row, 1)));
				jTxtCourseCredit.setText((String)(jt_all.getValueAt(row, 2)));
							
			}
		});
		
		return jt_all;
	}
	
	public JTable getById() //��ʾѧ����ѡ�γ̺ͳɼ�
	{
		recordModel = new MyRecordTableModel(stuId);
		jt_selected = new JTable(recordModel);
//		jt_selected.setEnabled(false);
		jt_selected.setPreferredScrollableViewportSize(new Dimension(780,200));//���ô˱���ͼ��ѡ��С					
		jt_selected.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  //��ѡ
		
		jt_selected.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				int row = jt_selected.getSelectedRow();
				jtf_coursename.setText((String)jt_selected.getValueAt(row, 0));
				jtf_score.setText((String)jt_selected.getValueAt(row, 1));
				jtf_credit.setText((String)jt_selected.getValueAt(row, 2));
			}
		});
		
		return jt_selected;
	}
	
	StuSelectCourse(String stuid)
	{
		stuId = stuid;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300,100,720,570);
		setBackground(Color.GRAY);
		setLayout(null);
		setTitle("ѧ��ѡ�μ�����");

		jlb_allCourse = new JLabel("���пγ�");
		jlb_allCourse.setBounds(5, 5, 100, 15);
		add(jlb_allCourse);
		
		
		jsp_table_all = new JScrollPane(getAllCourse());
		jsp_table_all.setBounds(5, 20, 690, 180);
		add(jsp_table_all);
		
		JLabel jLabelinfo=new JLabel("��ѡ��\"���пγ�\"�е�һ�ſγ̣�");
		jLabelinfo.setBounds(5, 210, 230, 30);
		add(jLabelinfo);
		
		JLabel jLabelCourSeId=new JLabel("�γ̱�ţ�");
		jLabelCourSeId.setBounds(5, 240, 70, 30);
		add(jLabelCourSeId);
		
		jTxtCourseId=new JTextField();
		jTxtCourseId.setBounds(80, 240, 100, 30);
		add(jTxtCourseId);
		
		JLabel jLabelCourseName=new JLabel("�γ����ƣ�");
		jLabelCourseName.setBounds(185, 240, 70, 30);
		add(jLabelCourseName);
		
		jTxtCourseName=new JTextField();
		jTxtCourseName.setBounds(260, 240, 100, 30);
		add(jTxtCourseName);
		
		JLabel jLabelCourseCredit=new JLabel("�γ�ѧ�֣�");
		jLabelCourseCredit.setBounds(365, 240, 70, 30);
		add(jLabelCourseCredit);
		
		jTxtCourseCredit=new JTextField();
		jTxtCourseCredit.setBounds(440, 240, 100, 30);
		add(jTxtCourseCredit);
		
		JButton jButtonAddSelectCourse=new JButton("���ѡ��");
		jButtonAddSelectCourse.setBounds(550, 240, 100, 30);
		jButtonAddSelectCourse.addActionListener(this);
		add(jButtonAddSelectCourse);
				
		
		jlb_selectedCourse = new JLabel(stuid+": ����ѡ�γ�");
		jlb_selectedCourse.setBounds(5, 270, 200, 20);
		add(jlb_selectedCourse);
		
		jsp_table_selected = new JScrollPane(getById());
		jsp_table_selected.setBounds(5, 290, 690, 150);;
		add(jsp_table_selected);
		
		content = new JPanel();
		content.setBackground(Color.LIGHT_GRAY);
		content.setBounds(5,445,690,80);
		content.setLayout(new FlowLayout());

		
		jlb_coursename = new JLabel("�γ����ƣ�");
		jlb_score = new JLabel("�γ̳ɼ���");
		jlb_credit = new JLabel("�γ�ѧ�֣�");
		jtf_coursename = new JTextField(10);
		jtf_coursename.setEditable(false);
		jtf_score = new JTextField(2);
		jtf_score.setEditable(false);
		jtf_credit = new JTextField(2);
		jtf_credit.setEditable(false);
		
		jbt_del_course = new JButton("ɾ��ѡ��");
		jbt_del_course.addActionListener(this);
		
		content.add(jlb_coursename);
		content.add(jtf_coursename);
		content.add(jlb_score);
		content.add(jtf_score);
		content.add(jlb_credit);
		content.add(jtf_credit);
		content.add(jbt_del_course);
				
		add(content);
		
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("���ѡ��")){
			addCourse();
		}
		if(e.getActionCommand().equals("ɾ��ѡ��"))
		{
			delCourse();
			recordModel = new MyRecordTableModel(stuId) ;
			jt_selected.setModel(recordModel);
		}
	}
	
	public void delCourse()
	{
		if((Integer.parseInt(jtf_score.getText()))!=0)
		{
			JOptionPane.showMessageDialog(null,"���гɼ��Ŀγ̲���ɾ��","����", 0);
		}else
		{
			RecordOp ro = new RecordOp();
			ro.delRecordByStuIdCoursename(stuId, jtf_coursename.getText());
			recordModel = new MyRecordTableModel(stuId) ;
			jt_selected.setModel(recordModel);
		}
	}
	public void addCourse()
	{
		RecordOp ro = new RecordOp();
		if(ro.getRecordNumByStuId(stuId)>=3)
		{
			JOptionPane.showMessageDialog(null,"�ѳ�������ѡ3�ſγ�","����", 0);
		}else
		{
			if(ro.getRecordByStuIdCoursename(stuId, jTxtCourseName.getText())==0)
			{
				int result = ro.addRecord(stuId, jTxtCourseName.getText());
				if(result==1)
				{
					JOptionPane.showMessageDialog(null, "ѡ�γɹ�");
					recordModel = new MyRecordTableModel(stuId) ;
					jt_selected.setModel(recordModel);
				}else
				{
					JOptionPane.showMessageDialog(null,"ѡ��ʧ�ܣ��������Ա��ϵ","����", 0);
				}
			}else
			{
				JOptionPane.showMessageDialog(null,"�Ѿ�ѡ��ÿγ�","����", 0);
			}
		}
	}
}
