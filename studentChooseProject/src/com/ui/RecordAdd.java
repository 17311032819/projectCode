package com.ui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import com.Bean.Tb_record;
import com.dao.RecordOp;

import egtool.MajorTableModel;
import egtool.TableRecordModify;

public class RecordAdd extends JFrame implements ActionListener {


	private JLabel lblRecordId;
	private JLabel lblStuId;
	private JLabel lblStuName;
	private JLabel lblCourseId;
	private JLabel lblCourseName;
	private JLabel lblRecord;

	private JTextField txtRecordId;
	private JTextField txtStuId;
	private JTextField txtStuName;
	private JTextField txtCourseId;
	private JTextField txtCourseName;
	private JTextField txtRecord;

	private JButton btnModify;
	private JButton btnCancle;

	TableRecordModify tableRecordModify;
	JTable table;
	RecordOp recordOp=new RecordOp();

	public static void main(String[] args) {
		RecordAdd recordAdd=new RecordAdd();
		recordAdd.setVisible(true);
	}

	public RecordAdd(){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 490, 430);
		ImageEg background=new ImageEg("image1.jpg");
		background.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(background);
		background.setLayout(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);//�Զ������������

		table=getAllRecord();//���ɱ��		


		JScrollPane s = new JScrollPane(table);//��ӹ������
		s.setBounds(5, 5, 450, 210);
		background.add(s);

		lblRecordId=new JLabel("�ɼ���ţ�");
		lblRecordId.setBounds(5, 225, 75, 30);
		background.add(lblRecordId);

		txtRecordId=new JTextField();
		txtRecordId.setBounds(80, 225, 145, 30);
		txtRecordId.setEditable(false);
		background.add(txtRecordId);

		lblStuId=new JLabel("ѧ����� ��");
		lblStuId.setBounds(235, 225, 75, 30);
		background.add(lblStuId);

		txtStuId=new JTextField();
		txtStuId.setBounds(310, 225, 145, 30);
		txtStuId.setEditable(false);
		background.add(txtStuId);

		lblStuName=new JLabel("ѧ��������");
		lblStuName.setBounds(5, 265, 75, 30);
		background.add(lblStuName);

		txtStuName=new JTextField();
		txtStuName.setBounds(80, 265, 145, 30);
		txtStuName.setEditable(false);
		background.add(txtStuName);

		lblCourseId=new JLabel("�γ̱�ţ�");
		lblCourseId.setBounds(235, 265, 75, 30);
		background.add(lblCourseId);

		txtCourseId=new JTextField();
		txtCourseId.setBounds(310, 265, 145, 30);
		txtCourseId.setEditable(false);
		background.add(txtCourseId);

		lblCourseName=new JLabel("�γ����ƣ�");
		lblCourseName.setBounds(5, 305, 75, 30);
		background.add(lblCourseName);

		txtCourseName=new JTextField();
		txtCourseName.setBounds(80, 305, 145, 30);
		txtCourseName.setEditable(false);
		background.add(txtCourseName);

		lblRecord=new JLabel("�γ̳ɼ���");
		lblRecord.setBounds(235, 305, 75, 30);
		background.add(lblRecord);

		txtRecord=new JTextField();
		txtRecord.setBounds(310, 305, 145, 30);

		background.add(txtRecord);

		btnCancle=new JButton("ȡ��");
		btnCancle.setBounds(275, 345, 70, 35);
		btnCancle.addActionListener(this);
		background.add(btnCancle);

		btnModify=new JButton("�޸�");
		btnModify.setBounds(385, 345, 70, 35);
		btnModify.addActionListener(this);
		background.add(btnModify);
		setVisible(true);

	}
	public JTable getAllRecord(){
		tableRecordModify=new TableRecordModify();
		table = new JTable(tableRecordModify);
		table.setPreferredScrollableViewportSize(new Dimension(780,200));//���ô˱���ͼ��ѡ��С					
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  //��ѡ	
		//table.setRowSorter(new TableRowSorter(majorTableModel));//���ÿɽ���������
		table.addMouseListener(new MouseAdapter(){    //����¼�
			public void mouseClicked(MouseEvent e){
				int selectedRow = table.getSelectedRow(); //���ѡ��������
				txtRecordId.setText((String)tableRecordModify.getValueAt(selectedRow, 0));
				Object oStuId = tableRecordModify.getValueAt(selectedRow, 1);
				txtStuId.setText((String)oStuId);
				Object oStuName = tableRecordModify.getValueAt(selectedRow, 2);
				txtStuName.setText((String)oStuName);
				Object oCourseId=tableRecordModify.getValueAt(selectedRow, 3);
				txtCourseId.setText((String)oCourseId);
				Object oCourseName=tableRecordModify.getValueAt(selectedRow, 4);
				txtCourseName.setText((String)oCourseName);
			}
		});
		return table;
	}
	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand().equals("�޸�")){
			Tb_record record=new Tb_record();
			record.setId(Integer.parseInt(txtRecordId.getText().trim()));
			record.setCourseId(txtCourseId.getText());
			record.setStuId(txtStuId.getText());
			if(txtRecord.getText().equals("")){
				JOptionPane.showMessageDialog(null, "��Ϊѡ����ӳɼ���");
			}else{
				record.setRecord(Integer.parseInt(txtRecord.getText().trim()));
			}
			if(recordOp.modifyRecord(record)){
				JOptionPane.showMessageDialog(null, "ѡ�γɼ���ӳɹ���");
				tableRecordModify.setRowCount(0);
				tableRecordModify=new TableRecordModify();
				table.setModel(tableRecordModify);
				txtRecordId.setText("");
				txtStuId.setText("");
				txtStuName.setText("");
				txtCourseId.setText("");
				txtCourseName.setText("");
				txtRecord.setText("");
			}
		}
	}

}
