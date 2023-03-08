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
		setTitle("班级信息管理");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//设置窗体关闭时做什么
		setBounds(150, 150, 1100, 350);//设置窗体出现的坐标及宽与高

		ImageEg background=new ImageEg("image1.jpg");
		background.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(background);
		background.setLayout(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);//自动跳至界面最大化

		final JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane,BorderLayout.CENTER);
		String[] columnNames={"班级编号","班级名称","班级辅导员","专业名称","辅导员电话"};
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
		background.add(new JLabel("班级编号:"));
		txtclassid = new JTextField("",10);
		background.add(txtclassid);
		background.add(new JLabel("班级名称:"));
		txtclassname = new JTextField("",10);
		background.add(txtclassname);
		background.add(new JLabel("班级辅导员:"));
		txtclassteacher = new JTextField("",10);
		background.add(txtclassteacher);
		background.add(new JLabel("专业名称:"));
		cbmajorid= new JComboBox<String>();
		background.add(cbmajorid);
		List listmajor = classOp.getAllMajorsName();
		for(int i=0;i<listmajor.size();i++)
			cbmajorid.addItem(listmajor.get(i).toString());
		background.add(new JLabel("辅导员电话:"));
		txtteacherphone = new JTextField("",10);
		background.add(txtteacherphone);
		final JButton  updateBtn = new JButton("修改");

		final JButton  delBtn = new JButton("删除");
		updateBtn.addActionListener(this);
		delBtn.addActionListener(this);
		background.add(updateBtn);
		background.add(delBtn);
		validate();
		setVisible(true);
	}

	//修改、删除事件函数
	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand().equals("修改")){
			if(strClassId.length()>0 && txtclassid.getText().length()>0
					&& txtclassname.getText().length()>0 && txtclassteacher.getText().length()>0
					&& txtteacherphone.getText().length()>0){
				int nSure = JOptionPane.showConfirmDialog(this,"确定要修改本条记录？","警告",JOptionPane.YES_NO_OPTION);
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
				JOptionPane.showMessageDialog(null, "请选择需要修改的记录!");
			}
		}
		if(e.getActionCommand().equals("删除")){
			if(strClassId.length()>0){
				int nSure = JOptionPane.showConfirmDialog(this,"确定要删除本条记录？","警告",JOptionPane.YES_NO_OPTION);
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
				JOptionPane.showMessageDialog(null, "请选择需要删除的记录!");
			}
		}

	}

	//表格刷新
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
