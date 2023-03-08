package com.ui;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.Bean.Tb_class;
import com.dao.ClassOp;

import egtool.Judgeidexit;

public class ClassAdd extends JFrame implements ActionListener{

	private JLabel lblclassid;
	private JLabel lblclassname;
	private JLabel lblclassteacher;
	private JLabel lblmajorName;
	private JLabel lblteacherphone;
	private JTextField txtclassid;
	private JTextField txtclassname;
	private JTextField txtclassteacher;
	private JTextField txtteacherphone;
	private JButton btnadd;
	private JButton btncancle;
	Tb_class tb_class=new Tb_class();
	ClassOp classOp=new ClassOp();
	String  strMajorName;
	private JComboBox<String>  cbmajorName;



	public ClassAdd(){

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//���ô���ر�ʱ��ʲô
		setBounds(150, 150, 350, 350);//���ô�����ֵ����꼰�����
		ImageEg background=new ImageEg("image1.jpg");
		background.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(background);
		background.setLayout(null);

		setVisible(true);
		setExtendedState(JFrame.MAXIMIZED_BOTH);//�Զ������������

		setTitle("��Ӱ༶����");//���ñ���
		
		JLabel lblmessage=new JLabel("����д�༶��Ϣ��");
		lblmessage.setBounds(50, 20, 200, 30);
		background.add(lblmessage);
						
		lblclassid=new JLabel("�༶��ţ�");
		lblclassid.setBounds(50, 70, 100, 30);
		background.add(lblclassid);
		
		txtclassid=new JTextField();
		txtclassid.setBounds(130, 70, 150, 30);
		txtclassid.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if(txtclassid.getText().trim().equals("")){
					JOptionPane.showMessageDialog(null, "�༶��ű���");
				}else{
					if(new Judgeidexit().judgeClassId(txtclassid.getText().trim())){
						tb_class.setclassid(txtclassid.getText().trim());
					}else{
						JOptionPane.showMessageDialog(null, "�ð༶�Ѿ����ڣ�");
						txtclassid.setText("");
					}
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		background.add(txtclassid);
		
		lblclassname=new JLabel("�༶���ƣ�");
		lblclassname.setBounds(50, 110, 100, 30);
		background.add(lblclassname);
		
		txtclassname=new JTextField();
		txtclassname.setBounds(130, 110, 150, 30);
		background.add(txtclassname);
		
		lblclassteacher=new JLabel("�༶����Ա��");
		lblclassteacher.setBounds(50, 150, 100, 30);
		background.add(lblclassteacher);
		
		txtclassteacher=new JTextField();
		txtclassteacher.setBounds(130, 150, 150, 30);
		background.add(txtclassteacher);
		
		lblmajorName = new JLabel("רҵ���ƣ�");
		lblmajorName.setBounds(50, 190, 100, 30);
		background.add(lblmajorName);
		
		cbmajorName = new JComboBox<String>();
		cbmajorName.setBounds(130, 190, 150, 30);
		background.add(cbmajorName);
		cbmajorName.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				strMajorName = cbmajorName.getSelectedItem().toString();
			}
		});

		lblteacherphone=new JLabel();
		lblteacherphone.setText("����Ա�绰");
		lblteacherphone.setBounds(50, 230, 100, 30);
		background.add(lblteacherphone);
		
		txtteacherphone=new JTextField();
		txtteacherphone.setBounds(130, 230, 150, 30);
		background.add(txtteacherphone);


		btnadd=new JButton("���");
		btnadd.setBounds(140, 270, 70, 35);
		btnadd.addActionListener(this);
		background.add(btnadd);
		
		btncancle=new JButton("ȡ��");
		btncancle.setBounds(210, 270, 70, 35);
		btncancle.addActionListener(this);
		background.add(btncancle);
		
		List list = classOp.getAllMajorsName();
		for(int i=0;i<list.size();i++)
			cbmajorName.addItem(list.get(i).toString());
		this.validate();
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand().equals("���")){
			
			tb_class.setclassid(txtclassid.getText().trim().toString());
			tb_class.setclassname(txtclassname.getText().trim());
			tb_class.setclassteacher(txtclassteacher.getText().trim());
			tb_class.setteacherphone(txtteacherphone.getText().trim());
            String strMajorId = classOp.getIdByName(strMajorName);
            tb_class.setmajorid(strMajorId);
			if(classOp.addClass(tb_class)){
				JOptionPane.showMessageDialog(null, "��Ӱ༶�ɹ�");
			}
			else{
				JOptionPane.showMessageDialog(null, "��Ӱ༶ʧ��");
			}
	    }
   }

	public static void main(String[] args) {
		ClassAdd classAdd=new ClassAdd();
		classAdd.setVisible(true);
	}
}
