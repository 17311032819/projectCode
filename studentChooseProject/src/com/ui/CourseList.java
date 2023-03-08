package com.ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableRowSorter;

import com.Bean.Tb_course;
import com.dao.CourseOp;
import java.awt.event.*;
import egtool.*;


public class CourseList extends JFrame implements ActionListener {
	MyTableModel defaultModel;
    private JTable table;

    
    private JTextField txtcourseID;
	private JTextField txtcourseName;
	private JTextField txtcoursecredit;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CourseList().setVisible(true);

	}
	public JTable getallccourse(){		
		defaultModel=new MyTableModel();
		table = new JTable(defaultModel);
		table.setPreferredScrollableViewportSize(new Dimension(780,200));//���ô˱���ͼ��ѡ��С					
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  //��ѡ
		//table.setRowSorter(new TableRowSorter(defaultModel));//�����������������������������������Դ���º��޸ģ������Զ�ˢ����ʾ
		
		table.addMouseListener(new MouseAdapter(){    //����¼�
		            public void mouseClicked(MouseEvent e){			         	
		                int selectedRow = table.getSelectedRow(); //���ѡ��������	        
		                txtcourseID.setText((String)defaultModel.getValueAt(selectedRow, 0));
		                Object ob = defaultModel.getValueAt(selectedRow, 1);		               
		                txtcourseName.setText((String)ob);
		                Object oc = defaultModel.getValueAt(selectedRow, 2);
		                txtcoursecredit.setText((String)oc);
		            }
		        });
		        //table.updateUI();
		 return table;    
	}
	
	public CourseList(){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 260, 465, 405);
		setTitle("�鿴���пγ�");
		ImageEg background=new ImageEg("image1.jpg");
		background.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(background);
		background.setLayout(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);//�Զ������������
		
		table=getallccourse();
		
		JScrollPane s = new JScrollPane(table);
		s.setBounds(5, 5, 424, 207);

		background.add(s);
		
		JLabel label = new JLabel("�γ̱��");
		label.setBounds(25, 225, 98, 15);
		background.add(label);
		
		txtcourseID = new JTextField();
		txtcourseID.setEditable(false);
		txtcourseID.setBounds(180, 222, 210, 21);
		background.add(txtcourseID);
		txtcourseID.setColumns(10);
		
		JLabel label_1 = new JLabel("�γ�����");
		label_1.setBounds(25, 255, 98, 15);
		background.add(label_1);
		
		txtcourseName = new JTextField();
		txtcourseName.setBounds(180, 252, 210, 21);
		background.add(txtcourseName);
		txtcourseName.setColumns(10);
		
		JLabel label_2 = new JLabel("�γ�ѧ��");
		label_2.setBounds(25, 290, 98, 15);
		background.add(label_2);
		
		txtcoursecredit = new JTextField();
		txtcoursecredit.setBounds(180, 283, 210, 21);
		background.add(txtcoursecredit);
		txtcoursecredit.setColumns(10);
		
		JButton btncancle = new JButton("ȡ��");
		btncancle.addActionListener(this);
		btncancle.setBounds(150, 333, 75, 23);
		background.add(btncancle);
				
		JButton btnmodify = new JButton("�޸�");
		btnmodify.addActionListener(this);
		btnmodify.setBounds(230, 333, 75, 23);
		background.add(btnmodify);
		
		JButton btndelete=new JButton("ɾ��");
		btndelete.addActionListener(this);
		btndelete.setBounds(310,333,75,23);
		background.add(btndelete);
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand().equals("�޸�")){
			Tb_course course=new Tb_course();
			course.setcourseid(txtcourseID.getText());
			course.setcoursename(txtcourseName.getText());
			course.setcoursecredit(Integer.parseInt(txtcoursecredit.getText()));
			CourseOp co=new CourseOp();
			if(co.modifycourse(course)){
				JOptionPane.showMessageDialog(this, "��ϲ���޸ĳɹ�����");
				defaultModel.setRowCount(0);//���ѡ��
				defaultModel=new MyTableModel();//��������defaultModel
				table.setModel(defaultModel);				
			}
		}
		if(e.getActionCommand().equals("ɾ��")){
			Tb_course course=new Tb_course();
			if(txtcourseID.getText().equals("")){
				JOptionPane.showMessageDialog(null, "����ѡ��Ҫɾ����������");
			}
			else{
				course.setcourseid(txtcourseID.getText());
			
				course.setcoursename(txtcourseName.getText());
				course.setcoursecredit(Integer.parseInt(txtcoursecredit.getText()));
				CourseOp co=new CourseOp();
				if(co.deletecourse(course)){
					JOptionPane.showMessageDialog(this, "��ϲ��ɾ���ɹ�����");
					defaultModel.setRowCount(0);//���ѡ��
					defaultModel=new MyTableModel();//��������defaultModel
					table.setModel(defaultModel);				
				}
			}
		}
		
	}
	

}
