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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//���ô���ر�ʱ��ʲô
		setBounds(100, 100, 650, 400);//���ô�����ֵ����꼰�����
		setTitle("��ӭ��"+lgrole+","+lgname);//���ñ���
		contentPane = new JPanel();//��ȡ�������---�װ�
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));//���ö����ı߾�
		setContentPane(contentPane);//�����������
		contentPane.setLayout(new BorderLayout(0,0));//�������Ĳ��ַ�ʽΪ���Բ���
		setVisible(true);

		ImageEg imageEg=new ImageEg("image1.jpg");
		contentPane.add(imageEg);
		setExtendedState(JFrame.MAXIMIZED_BOTH);//�Զ������������

		JMenuBar menuBar=new JMenuBar();//���˵���
		setJMenuBar(menuBar);

		JMenu majorop=new JMenu("רҵ����");
		majorop.setFont(new Font("����", Font.PLAIN, 15));
		menuBar.add(majorop);
		majorop.setMnemonic('M');//�����ȼ�

		JMenuItem mImajoradd=new JMenuItem("���רҵ");
		mImajoradd.addActionListener(this);
		majorop.add(mImajoradd);

		JMenuItem mImajorlist=new JMenuItem("����רҵ");
		mImajorlist.addActionListener(this);
		majorop.add(mImajorlist);

		JMenu classop=new JMenu("�༶����");
		classop.setFont(new Font("����", Font.PLAIN, 15));
		menuBar.add(classop);
		classop.setMnemonic('C');

		JMenuItem mIclassadd=new JMenuItem("��Ӱ༶");
		mIclassadd.addActionListener(this);
		classop.add(mIclassadd);

		JMenuItem mIclasslist=new JMenuItem("����༶");
		mIclasslist.addActionListener(this);
		classop.add(mIclasslist);

		JMenu teacherOp=new JMenu("��ʦ����");
		teacherOp.setFont(new Font("����", Font.PLAIN, 15));
		menuBar.add(teacherOp);
		teacherOp.setMnemonic('T');

		JMenuItem mIteacheradd=new JMenuItem("�����ʦ");
		mIteacheradd.addActionListener(this);
		teacherOp.add(mIteacheradd);

		JMenuItem mIteacherlist=new JMenuItem("������ʦ");
		mIteacherlist.addActionListener(this);
		teacherOp.add(mIteacherlist);

		JMenu studentOp=new JMenu("ѧ������");
		studentOp.setFont(new Font("����", Font.PLAIN, 15));
		menuBar.add(studentOp);
		teacherOp.setMnemonic('S');

		JMenuItem mIstudentadd=new JMenuItem("���ѧ��");
		mIstudentadd.addActionListener(this);
		studentOp.add(mIstudentadd);

		JMenuItem mIstudentlist=new JMenuItem("����ѧ��");
		mIstudentlist.addActionListener(this);
		studentOp.add(mIstudentlist);

		JMenu courseop=new JMenu("�γ̹���");
		courseop.setFont(new Font("����", Font.PLAIN, 15));
		menuBar.add(courseop);
		courseop.setMnemonic('K');//�����ȼ�

		JMenuItem mIcourseadd=new JMenuItem("��ӿγ�");
		mIcourseadd.addActionListener(this);
		courseop.add(mIcourseadd);

		JMenuItem mIcourselist=new JMenuItem("����γ�");
		mIcourselist.addActionListener(this);
		courseop.add(mIcourselist);

		JMenu selectCourse=new JMenu("ѡ�ι���");
		selectCourse.setFont(new Font("����", Font.PLAIN, 15));
		menuBar.add(selectCourse);
		selectCourse.setMnemonic('X');

		JMenuItem mIselectcourse=new JMenuItem("��Ӳ�����ѡ��");
		mIselectcourse.addActionListener(this);
		selectCourse.add(mIselectcourse);
		
		/*JMenuItem mIlistselectcourse=new JMenuItem("����ѡ��");
		mIlistselectcourse.addActionListener(this);
		selectCourse.add(mIlistselectcourse);*/

		JMenu teacherinfoOp=new JMenu("��ʦ������Ϣ����");
		teacherinfoOp.setFont(new Font("����", Font.PLAIN, 15));
		menuBar.add(teacherinfoOp);
		teacherinfoOp.setMnemonic('T');

		JMenuItem mIinfo=new JMenuItem("�����ʦ������Ϣ");
		mIinfo.addActionListener(this);
		teacherinfoOp.add(mIinfo);

		JMenu stuInfoOp=new JMenu("ѧ��������Ϣ����");
		stuInfoOp.setFont(new Font("����", Font.PLAIN, 15));
		menuBar.add(stuInfoOp);
		stuInfoOp.setMnemonic('I');

		JMenuItem mIstuinfo=new JMenuItem("����ѧ��������Ϣ");
		mIstuinfo.addActionListener(this);
		stuInfoOp.add(mIstuinfo);

		JMenu recordop=new JMenu("�ɼ�����");
		recordop.setFont(new Font("����", Font.PLAIN, 15));
		menuBar.add(recordop);
		recordop.setMnemonic('R');

		JMenuItem mIaddrecord=new JMenuItem("��ӳɼ�");
		mIaddrecord.addActionListener(this);
		recordop.add(mIaddrecord);

		JMenuItem mIlistrecord=new JMenuItem("����ɼ�");
		mIlistrecord.addActionListener(this);
		recordop.add(mIlistrecord);

		JMenuItem mIselectrecord=new JMenuItem("��ѯ�ɼ�");
		mIselectrecord.addActionListener(this);
		recordop.add(mIselectrecord);

		if(lgrole.equals("����Ա")){
			selectCourse.setVisible(false);
			//selectCourse.setEnabled(false);
			//recordop.setEnabled(false);
			recordop.setVisible(false);
			teacherinfoOp.setVisible(false);
			stuInfoOp.setVisible(false);
		}
		if(lgrole.equals("��ʦ")){
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
		if(lgrole.equals("ͬѧ")){
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
		if(e.getActionCommand().equals("���רҵ")){
			Major_AddFm major_AddFm=new Major_AddFm();
			major_AddFm.setVisible(true);
		}
		if(e.getActionCommand().equals("����רҵ")){
			MajorList majorList=new MajorList();
			majorList.setVisible(true);
		}
		if(e.getActionCommand().equals("��Ӱ༶")){
			ClassAdd cAdd=new ClassAdd();
			cAdd.setVisible(true);
		}
		if(e.getActionCommand().equals("����༶")){
			ClassManagement cm=new ClassManagement();
			cm.setVisible(true);
		}
		if(e.getActionCommand().equals("�����ʦ")){
			TeacherAdd teacherAdd=new TeacherAdd();
			teacherAdd.setVisible(true);
		}
		if(e.getActionCommand().equals("������ʦ")){
			TeacherList teacherList=new TeacherList();
			teacherList.setVisible(true);
		}
		if(e.getActionCommand().equals("��ӿγ�")){
			CourseAdd aCourse=new CourseAdd();
			aCourse.setVisible(true);
		}

		if(e.getActionCommand().equals("����γ�")){
			CourseList courseList=new CourseList();
			courseList.setVisible(true);
		}
		if(e.getActionCommand().equals("���ѧ��")){
			StuAdd stuAdd=new StuAdd();
			stuAdd.setVisible(true);
		}
		if(e.getActionCommand().equals("����ѧ��")){
			StuList1 stuList=new StuList1();
			stuList.setVisible(true);
		}
		if(e.getActionCommand().equals("��Ӳ�����ѡ��")){
			//StudentAddCourse studentAddCourse=new StudentAddCourse(stuId, courseName)
			StuSelectCourse stuSelectCourse=new StuSelectCourse(lgname);
		}
		if(e.getActionCommand().equals("����ѧ��������Ϣ")){
			StuInfoManagement stuInfoManagement=new StuInfoManagement(lgname);

			stuInfoManagement.setVisible(true);
		}
		if(e.getActionCommand().equals("�����ʦ������Ϣ")){
			TeacherInfoManagement teacherInfoManagement=new TeacherInfoManagement(lgname);

		}
		if(e.getActionCommand().equals("��ӳɼ�")){
			RecordAdd recordAdd=new RecordAdd();
		}
		if(e.getActionCommand().equals("��ѯ�ɼ�")){
			try {
				Selectrecord queryScore=new Selectrecord();
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}
		}
		if(e.getActionCommand().equals("����ɼ�")){
		RecordManagement recordManagement=new RecordManagement();
		}
	}


}
