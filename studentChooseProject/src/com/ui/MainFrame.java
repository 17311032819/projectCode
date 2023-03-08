package com.ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class MainFrame extends JFrame implements ActionListener{
	private JPanel contentPane;
	public String lgrole;
	public String lgname;

	public static void main(String[] args) {
		new MainFrame("h","gt").setVisible(true);
	}
	public  MainFrame(String logrole,String logname){
		lgrole=logrole;
		lgname=logname;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//设置窗体关闭时做什么
		setBounds(100, 100, 650, 400);//设置窗体出现的坐标及宽与高
		setTitle("欢迎："+lgrole+","+lgname);//设置标题
		contentPane = new JPanel();//获取内容面板---底板
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));//设置对象间的边距
		setContentPane(contentPane);//设置内容面板
		contentPane.setLayout(new BorderLayout(0,0));//设置它的布局方式为绝对布局
		setVisible(true);

		ImageEg imageEg=new ImageEg("image1.jpg");
		contentPane.add(imageEg);
		setExtendedState(JFrame.MAXIMIZED_BOTH);//自动跳至界面最大化

		JMenuBar menuBar=new JMenuBar();//主菜单栏
		setJMenuBar(menuBar);

		JMenu majorop=new JMenu("专业管理");
		majorop.setFont(new Font("宋体", Font.PLAIN, 15));
		menuBar.add(majorop);
		majorop.setMnemonic('M');//设置热键

		JMenuItem mImajoradd=new JMenuItem("添加专业");
		mImajoradd.addActionListener(this);
		majorop.add(mImajoradd);

		JMenuItem mImajorlist=new JMenuItem("管理专业");
		mImajorlist.addActionListener(this);
		majorop.add(mImajorlist);

		JMenu classop=new JMenu("班级管理");
		classop.setFont(new Font("宋体", Font.PLAIN, 15));
		menuBar.add(classop);
		classop.setMnemonic('C');

		JMenuItem mIclassadd=new JMenuItem("添加班级");
		mIclassadd.addActionListener(this);
		classop.add(mIclassadd);

		JMenuItem mIclasslist=new JMenuItem("管理班级");
		mIclasslist.addActionListener(this);
		classop.add(mIclasslist);

		JMenu teacherOp=new JMenu("老师管理");
		teacherOp.setFont(new Font("宋体", Font.PLAIN, 15));
		menuBar.add(teacherOp);
		teacherOp.setMnemonic('T');

		JMenuItem mIteacheradd=new JMenuItem("添加老师");
		mIteacheradd.addActionListener(this);
		teacherOp.add(mIteacheradd);

		JMenuItem mIteacherlist=new JMenuItem("管理老师");
		mIteacherlist.addActionListener(this);
		teacherOp.add(mIteacherlist);

		JMenu studentOp=new JMenu("学生管理");
		studentOp.setFont(new Font("宋体", Font.PLAIN, 15));
		menuBar.add(studentOp);
		teacherOp.setMnemonic('S');

		JMenuItem mIstudentadd=new JMenuItem("添加学生");
		mIstudentadd.addActionListener(this);
		studentOp.add(mIstudentadd);

		JMenuItem mIstudentlist=new JMenuItem("管理学生");
		mIstudentlist.addActionListener(this);
		studentOp.add(mIstudentlist);

		JMenu courseop=new JMenu("课程管理");
		courseop.setFont(new Font("宋体", Font.PLAIN, 15));
		menuBar.add(courseop);
		courseop.setMnemonic('K');//设置热键

		JMenuItem mIcourseadd=new JMenuItem("添加课程");
		mIcourseadd.addActionListener(this);
		courseop.add(mIcourseadd);

		JMenuItem mIcourselist=new JMenuItem("管理课程");
		mIcourselist.addActionListener(this);
		courseop.add(mIcourselist);

		JMenu selectCourse=new JMenu("选课管理");
		selectCourse.setFont(new Font("宋体", Font.PLAIN, 15));
		menuBar.add(selectCourse);
		selectCourse.setMnemonic('X');

		JMenuItem mIselectcourse=new JMenuItem("添加并管理选课");
		mIselectcourse.addActionListener(this);
		selectCourse.add(mIselectcourse);
		
		/*JMenuItem mIlistselectcourse=new JMenuItem("管理选课");
		mIlistselectcourse.addActionListener(this);
		selectCourse.add(mIlistselectcourse);*/

		JMenu teacherinfoOp=new JMenu("教师个人信息管理");
		teacherinfoOp.setFont(new Font("宋体", Font.PLAIN, 15));
		menuBar.add(teacherinfoOp);
		teacherinfoOp.setMnemonic('T');

		JMenuItem mIinfo=new JMenuItem("管理教师个人信息");
		mIinfo.addActionListener(this);
		teacherinfoOp.add(mIinfo);

		JMenu stuInfoOp=new JMenu("学生个人信息管理");
		stuInfoOp.setFont(new Font("宋体", Font.PLAIN, 15));
		menuBar.add(stuInfoOp);
		stuInfoOp.setMnemonic('I');

		JMenuItem mIstuinfo=new JMenuItem("管理学生个人信息");
		mIstuinfo.addActionListener(this);
		stuInfoOp.add(mIstuinfo);

		JMenu recordop=new JMenu("成绩管理");
		recordop.setFont(new Font("宋体", Font.PLAIN, 15));
		menuBar.add(recordop);
		recordop.setMnemonic('R');

		JMenuItem mIaddrecord=new JMenuItem("添加成绩");
		mIaddrecord.addActionListener(this);
		recordop.add(mIaddrecord);

		JMenuItem mIlistrecord=new JMenuItem("管理成绩");
		mIlistrecord.addActionListener(this);
		recordop.add(mIlistrecord);

		JMenuItem mIselectrecord=new JMenuItem("查询成绩");
		mIselectrecord.addActionListener(this);
		recordop.add(mIselectrecord);

		if(lgrole.equals("管理员")){
			selectCourse.setVisible(false);
			//selectCourse.setEnabled(false);
			//recordop.setEnabled(false);
			recordop.setVisible(false);
			teacherinfoOp.setVisible(false);
			stuInfoOp.setVisible(false);
		}
		if(lgrole.equals("老师")){
			/*majorop.setEnabled(false);
			classop.setEnabled(false);
			courseop.setEnabled(false);
			studentOp.setEnabled(false);			
			selectCourse.setEnabled(false);	*/
			majorop.setVisible(false);
			classop.setVisible(false);
			courseop.setVisible(false);
			studentOp.setVisible(false);
			teacherOp.setVisible(false);
			selectCourse.setVisible(false);
			stuInfoOp.setVisible(false);
		}
		if(lgrole.equals("同学")){
			/*majorop.setEnabled(false);
			classop.setEnabled(false);
			courseop.setEnabled(false);
			studentOp.setEnabled(false);
			teacherOp.setEnabled(false);
			recordop.setEnabled(false);*/
			majorop.setVisible(false);
			classop.setVisible(false);
			courseop.setVisible(false);
			studentOp.setVisible(false);
			teacherOp.setVisible(false);
			teacherinfoOp.setVisible(false);
			recordop.setVisible(false);
		}

	}
	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand().equals("添加专业")){
			Major_AddFm major_AddFm=new Major_AddFm();
			major_AddFm.setVisible(true);
		}
		if(e.getActionCommand().equals("管理专业")){
			MajorList majorList=new MajorList();
			majorList.setVisible(true);
		}
		if(e.getActionCommand().equals("添加班级")){
			ClassAdd cAdd=new ClassAdd();
			cAdd.setVisible(true);
		}
		if(e.getActionCommand().equals("管理班级")){
			ClassManagement cm=new ClassManagement();
			cm.setVisible(true);
		}
		if(e.getActionCommand().equals("添加老师")){
			TeacherAdd teacherAdd=new TeacherAdd();
			teacherAdd.setVisible(true);
		}
		if(e.getActionCommand().equals("管理老师")){
			TeacherList teacherList=new TeacherList();
			teacherList.setVisible(true);
		}
		if(e.getActionCommand().equals("添加课程")){
			CourseAdd aCourse=new CourseAdd();
			aCourse.setVisible(true);
		}

		if(e.getActionCommand().equals("管理课程")){
			CourseList courseList=new CourseList();
			courseList.setVisible(true);
		}
		if(e.getActionCommand().equals("添加学生")){
			StuAdd stuAdd=new StuAdd();
			stuAdd.setVisible(true);
		}
		if(e.getActionCommand().equals("管理学生")){
			StuList1 stuList=new StuList1();
			stuList.setVisible(true);
		}
		if(e.getActionCommand().equals("添加并管理选课")){
			//StudentAddCourse studentAddCourse=new StudentAddCourse(stuId, courseName)
			StuSelectCourse stuSelectCourse=new StuSelectCourse(lgname);
		}
		if(e.getActionCommand().equals("管理学生个人信息")){
			StuInfoManagement stuInfoManagement=new StuInfoManagement(lgname);

			stuInfoManagement.setVisible(true);
		}
		if(e.getActionCommand().equals("管理教师个人信息")){
			TeacherInfoManagement teacherInfoManagement=new TeacherInfoManagement(lgname);

		}
		if(e.getActionCommand().equals("添加成绩")){
			RecordAdd recordAdd=new RecordAdd();
		}
		if(e.getActionCommand().equals("查询成绩")){
			try {
				Selectrecord queryScore=new Selectrecord();
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}
		}
		if(e.getActionCommand().equals("管理成绩")){
		RecordManagement recordManagement=new RecordManagement();
		}
	}


}
