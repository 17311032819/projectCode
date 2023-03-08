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
		table.setPreferredScrollableViewportSize(new Dimension(780,200));//设置此表视图首选大小					
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  //单选
		//table.setRowSorter(new TableRowSorter(defaultModel));//设置行排序器，如果设置行排序器，数据源更新后（修改）不能自动刷新显示
		
		table.addMouseListener(new MouseAdapter(){    //鼠标事件
		            public void mouseClicked(MouseEvent e){			         	
		                int selectedRow = table.getSelectedRow(); //获得选中行索引	        
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
		setTitle("查看所有课程");
		ImageEg background=new ImageEg("image1.jpg");
		background.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(background);
		background.setLayout(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);//自动跳至界面最大化
		
		table=getallccourse();
		
		JScrollPane s = new JScrollPane(table);
		s.setBounds(5, 5, 424, 207);

		background.add(s);
		
		JLabel label = new JLabel("课程编号");
		label.setBounds(25, 225, 98, 15);
		background.add(label);
		
		txtcourseID = new JTextField();
		txtcourseID.setEditable(false);
		txtcourseID.setBounds(180, 222, 210, 21);
		background.add(txtcourseID);
		txtcourseID.setColumns(10);
		
		JLabel label_1 = new JLabel("课程名称");
		label_1.setBounds(25, 255, 98, 15);
		background.add(label_1);
		
		txtcourseName = new JTextField();
		txtcourseName.setBounds(180, 252, 210, 21);
		background.add(txtcourseName);
		txtcourseName.setColumns(10);
		
		JLabel label_2 = new JLabel("课程学分");
		label_2.setBounds(25, 290, 98, 15);
		background.add(label_2);
		
		txtcoursecredit = new JTextField();
		txtcoursecredit.setBounds(180, 283, 210, 21);
		background.add(txtcoursecredit);
		txtcoursecredit.setColumns(10);
		
		JButton btncancle = new JButton("取消");
		btncancle.addActionListener(this);
		btncancle.setBounds(150, 333, 75, 23);
		background.add(btncancle);
				
		JButton btnmodify = new JButton("修改");
		btnmodify.addActionListener(this);
		btnmodify.setBounds(230, 333, 75, 23);
		background.add(btnmodify);
		
		JButton btndelete=new JButton("删除");
		btndelete.addActionListener(this);
		btndelete.setBounds(310,333,75,23);
		background.add(btndelete);
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand().equals("修改")){
			Tb_course course=new Tb_course();
			course.setcourseid(txtcourseID.getText());
			course.setcoursename(txtcourseName.getText());
			course.setcoursecredit(Integer.parseInt(txtcoursecredit.getText()));
			CourseOp co=new CourseOp();
			if(co.modifycourse(course)){
				JOptionPane.showMessageDialog(this, "恭喜你修改成功啦！");
				defaultModel.setRowCount(0);//清空选择
				defaultModel=new MyTableModel();//重新生成defaultModel
				table.setModel(defaultModel);				
			}
		}
		if(e.getActionCommand().equals("删除")){
			Tb_course course=new Tb_course();
			if(txtcourseID.getText().equals("")){
				JOptionPane.showMessageDialog(null, "请先选择要删除的数据行");
			}
			else{
				course.setcourseid(txtcourseID.getText());
			
				course.setcoursename(txtcourseName.getText());
				course.setcoursecredit(Integer.parseInt(txtcoursecredit.getText()));
				CourseOp co=new CourseOp();
				if(co.deletecourse(course)){
					JOptionPane.showMessageDialog(this, "恭喜你删除成功啦！");
					defaultModel.setRowCount(0);//清空选择
					defaultModel=new MyTableModel();//重新生成defaultModel
					table.setModel(defaultModel);				
				}
			}
		}
		
	}
	

}
