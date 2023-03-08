package com.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.Bean.Tb_class;
import com.dao.ClassOp;

public class ClassManagement extends JFrame implements ActionListener {

	private DefaultTableModel tableModel;
	private JTable table;
	private JTextField txtclassid;
	private JTextField txtclassname;
	private JTextField txtclassteacher;
	private JTextField txtteacherphone;
	private JComboBox<String>  cbmajorid;
	ClassOp classOp=new ClassOp();
	String  strClassId="";
	Tb_class tb_class = new Tb_class();

	public static void main(String[] args) {
		ClassManagement classManagement=new ClassManagement();
		classManagement.setVisible(true);
	}

	public ClassManagement()
	{
		super();
		setTitle("�༶��Ϣ����");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//���ô���ر�ʱ��ʲô
		setBounds(150, 150, 1100, 350);//���ô�����ֵ����꼰�����

		ImageEg background=new ImageEg("image1.jpg");
		background.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(background);
		background.setLayout(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);//�Զ������������

		final JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane,BorderLayout.CENTER);
		String[] columnNames={"�༶���","�༶����","�༶����Ա","רҵ����","����Ա�绰"};
		tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(columnNames);
		freshTable();
		table = new JTable(tableModel);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				int selectedRow = table.getSelectedRow();
				txtclassid.setText(table.getValueAt(selectedRow, 0).toString());
				strClassId = txtclassid.getText().toString();
				txtclassname.setText(table.getValueAt(selectedRow, 1).toString());
				txtclassteacher.setText(table.getValueAt(selectedRow, 2).toString());
				cbmajorid.setSelectedItem(table.getValueAt(selectedRow, 3));
				txtteacherphone.setText(table.getValueAt(selectedRow, 4).toString());
			}
		});
		scrollPane.setViewportView(table);
		final JPanel panel = new JPanel();
		background.setLayout(new FlowLayout(FlowLayout.LEFT));
		getContentPane().add(panel,BorderLayout.SOUTH);
		background.add(new JLabel("�༶���:"));
		txtclassid = new JTextField("",10);
		background.add(txtclassid);
		background.add(new JLabel("�༶����:"));
		txtclassname = new JTextField("",10);
		background.add(txtclassname);
		background.add(new JLabel("�༶����Ա:"));
		txtclassteacher = new JTextField("",10);
		background.add(txtclassteacher);
		background.add(new JLabel("רҵ����:"));
		cbmajorid= new JComboBox<String>();
		background.add(cbmajorid);
		List listmajor = classOp.getAllMajorsName();
		for(int i=0;i<listmajor.size();i++)
			cbmajorid.addItem(listmajor.get(i).toString());
		background.add(new JLabel("����Ա�绰:"));
		txtteacherphone = new JTextField("",10);
		background.add(txtteacherphone);
		final JButton  updateBtn = new JButton("�޸�");

		final JButton  delBtn = new JButton("ɾ��");
		updateBtn.addActionListener(this);
		delBtn.addActionListener(this);
		background.add(updateBtn);
		background.add(delBtn);
		validate();
		setVisible(true);
	}

	//�޸ġ�ɾ���¼�����
	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand().equals("�޸�")){
			if(strClassId.length()>0 && txtclassid.getText().length()>0
					&& txtclassname.getText().length()>0 && txtclassteacher.getText().length()>0
					&& txtteacherphone.getText().length()>0){
				int nSure = JOptionPane.showConfirmDialog(this,"ȷ��Ҫ�޸ı�����¼��","����",JOptionPane.YES_NO_OPTION);
				if(nSure==JOptionPane.YES_OPTION){
					tb_class.setclassid(txtclassid.getText().toString());
					tb_class.setclassname(txtclassname.getText().toString());
					tb_class.setclassteacher(txtclassteacher.getText().toString());
					String strMajorId = classOp.getIdByName(cbmajorid.getSelectedItem().toString());
					tb_class.setmajorid(strMajorId);;
					tb_class.setteacherphone(txtteacherphone.getText().toString());
					boolean flag = false;
					flag = classOp.updateClass(strClassId, tb_class);
					if(flag){
						while(tableModel.getRowCount()>0){
							tableModel.removeRow(0);
						}
						freshTable();
					}
				}
			}
			else{
				JOptionPane.showMessageDialog(null, "��ѡ����Ҫ�޸ĵļ�¼!");
			}
		}
		if(e.getActionCommand().equals("ɾ��")){
			if(strClassId.length()>0){
				int nSure = JOptionPane.showConfirmDialog(this,"ȷ��Ҫɾ��������¼��","����",JOptionPane.YES_NO_OPTION);
				if(nSure==JOptionPane.YES_OPTION){
					boolean flag = false;
					flag = classOp.deleteClass(strClassId);
					if(flag){
						while(tableModel.getRowCount()>0)
							tableModel.removeRow(0);
						freshTable();
					}
				}
			}
			else{
				JOptionPane.showMessageDialog(null, "��ѡ����Ҫɾ���ļ�¼!");
			}
		}

	}

	//���ˢ��
	public void freshTable(){
		List<Tb_class> list = classOp.getallclass();
		for(int i=0;i<list.size();i++){
			Vector<String> vecclassinfo = new Vector<String>();
			Tb_class tb_class = list.get(i);
			vecclassinfo.add(tb_class.getclassid());
			vecclassinfo.add(tb_class.getclassname());
			vecclassinfo.add(tb_class.getclassteacher());
			vecclassinfo.add(tb_class.getmajorName());
			vecclassinfo.add(tb_class.getteacherphone());
			tableModel.insertRow(i, vecclassinfo);
		}
	}


}
