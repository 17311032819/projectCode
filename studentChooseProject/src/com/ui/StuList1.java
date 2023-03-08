package com.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
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
import javax.swing.table.TableRowSorter;

import com.Bean.Tb_class;
import com.Bean.Tb_stuinfo;
import com.dao.ClassOp;
import com.dao.StuinfoOp;

import egtool.StuTableModel;

public class StuList1 extends JFrame implements ActionListener{

	//private JPanel contentPane;
	private JLabel lblStuId;
	private JLabel lblStuName;
	private JLabel lblStuSex;
	private JLabel lblStuPhone;
	private JLabel lblStuClassId;
	private JTextField txtStuId=new JTextField();
	private JTextField txtStuName=new JTextField();
	private JTextField txtStuPhone=new JTextField();
	private JButton btnModify;
	private JButton btnDelete;
	private JButton btnCancle;
	private JComboBox coboStuSex = new JComboBox();
	private JComboBox coboStuClass=new JComboBox();
	StuTableModel tablemodel=new StuTableModel();
	private JTable table;
	//    private JPanel contentPane;
	Tb_stuinfo stuInfo=new Tb_stuinfo();
	ClassOp cOp=new ClassOp();
	StuinfoOp stuOp=new StuinfoOp();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StuList1 frame = new StuList1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StuList1() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 634, 447);
		setTitle("查看所有学生");
		ImageEg background=new ImageEg("image1.jpg");
		background.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(background);
		background.setLayout(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);//自动跳至界面最大化
		table=getallccourse();


		JScrollPane s = new JScrollPane(table);//添加滚动面板
		s.setBounds(10, 10, 584, 190);
		background.add(s);

		lblStuId=new JLabel("学生编号：");//11
		lblStuId.setBounds(10, 225, 72, 30);
		background.add(lblStuId);

		//txtStuId=new JTextField();//12
		txtStuId.setBounds(81, 226, 134, 30);
		txtStuId.setEditable(false);
		background.add(txtStuId);

		btnModify=new JButton("修改");
		btnModify.setBounds(327, 350, 70, 35);
		btnModify.addActionListener(this);
		background.add(btnModify);

		btnDelete=new JButton("删除");
		btnDelete.setBounds(402, 350, 70, 35);
		btnDelete.addActionListener(this);
		background.add(btnDelete);

		btnCancle=new JButton("取消");
		btnCancle.setBounds(477, 350, 70, 35);
		btnCancle.addActionListener(this);
		background.add(btnCancle);

		lblStuName = new JLabel("学生姓名：");
		lblStuName.setBounds(240, 223, 70, 34);
		background.add(lblStuName);

		//txtStuName = new JTextField();
		txtStuName.setColumns(10);
		txtStuName.setBounds(313, 226, 102, 30);
		background.add(txtStuName);

		lblStuSex = new JLabel("学生性别：");
		lblStuSex.setBounds(425, 221, 70, 34);
		background.add(lblStuSex);
		String[] listData = new String[]{"男", "女"};
		DefaultComboBoxModel dfc=new DefaultComboBoxModel(listData);
		coboStuSex.setModel(dfc);
		//coboStuSex = new JComboBox();
		coboStuSex.setSelectedIndex(0);
		coboStuSex.setBounds(494, 222, 53, 32);
		coboStuSex.setSelectedIndex(0);
		background.add(coboStuSex);

		lblStuPhone = new JLabel("学生电话：");
		lblStuPhone.setBounds(10, 277, 72, 34);
		background.add(lblStuPhone);

		//txtStuPhone = new JTextField();
		txtStuPhone.setColumns(10);
		txtStuPhone.setBounds(81, 278, 134, 33);
		background.add(txtStuPhone);

		lblStuClassId = new JLabel("学生班级：");
		lblStuClassId.setBounds(312, 277, 72, 34);
		background.add(lblStuClassId);


		coboStuClass.setBounds(394, 277, 153, 34);
		List list=cOp.getallclass();
		for(int i=0;i<list.size();i++){
			Tb_class tb_class=(Tb_class)list.get(i);//按序号依次取出list中的班级对象
			//coboStuClass.addItem(tb_class.getclassname());//将班级对象的班级名称属性取出来添加到下拉列表中
			coboStuClass.addItem(new Tb_class(tb_class.getclassid(),tb_class.getclassname()));
		}
		coboStuClass.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {//下拉列表监听
				// TODO Auto-generated method stub
				if(e.getStateChange()==ItemEvent.SELECTED){
					int index=coboStuClass.getSelectedIndex();
					if(coboStuClass.getSelectedIndex()==-1){
						JOptionPane.showMessageDialog(null, "请选择对应的班级");
					}else{
						Tb_class tc=(Tb_class) coboStuClass.getSelectedItem();
						//stuinfo.setstu_classid(tc.getclassid());
					}
				}
			}
		});
		background.add(coboStuClass);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("修改")){
			stuInfo.setstu_id(txtStuId.getText());
			stuInfo.setstu_name(txtStuName.getText());
			stuInfo.setstu_phone(txtStuPhone.getText());
			stuInfo.setstu_sex(coboStuSex.getSelectedItem().toString());
			Tb_class tbClass=(Tb_class) coboStuClass.getSelectedItem();
			stuInfo.setstu_classid(tbClass.getclassid());

			if(stuOp.modifyStuInfo(stuInfo)){
				JOptionPane.showMessageDialog(this, "恭喜你修改成功啦！");
				//tablemodel.setRowCount(0);//清空选择
				tablemodel.updateModel();//重新生成StuTableModel
				table.setModel(tablemodel);
				table.updateUI();
				txtStuId.setText("");
				txtStuName.setText("");
				txtStuPhone.setText("");
				coboStuSex.setSelectedIndex(-1);
				coboStuClass.setSelectedIndex(-1);
			}
		}

		if(e.getActionCommand().equals("删除")){
			if(txtStuId.getText().equals("")){
				JOptionPane.showMessageDialog(null, "请先选择要删除的学生");
			}
			else{
				int selectedRow = table.getSelectedRow(); //获得选中行索引
				String stuId=(String) tablemodel.getValueAt(selectedRow, 0);//获取点击行的第一列的值（即点击行的主键值）
				String mString=stuOp.deleteStuInfo(stuId);
				JOptionPane.showMessageDialog(this, mString);
//				tablemodel.setRowCount(0);
//				tablemodel=new StuTableModel();
				tablemodel.updateModel();//重新设置StuTableModel
				//这个地方由原来的重新生成tablemodel对象改为重新设置model对象，修正删除学生报错的bug
				table.setModel(tablemodel);
				table.updateUI();
				txtStuId.setText("");
				txtStuName.setText("");
				txtStuPhone.setText("");
				coboStuSex.setSelectedIndex(-1);
				coboStuClass.setSelectedIndex(-1);
			}
		}
		if(e.getActionCommand().equals("取消")){
			txtStuId.setText("");
			txtStuName.setText("");
			txtStuPhone.setText("");
			coboStuSex.setSelectedIndex(-1);
			coboStuClass.setSelectedIndex(-1);
		}
	}

	public JTable getallccourse(){
		table = new JTable(tablemodel);
		table.setPreferredScrollableViewportSize(new Dimension(780,200));//设置此表视图首选大小
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  //单选
		table.setRowSorter(new TableRowSorter(tablemodel));//设置可进行行排序
		table.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				int selectedRow = table.getSelectedRow(); //获得选中行索引
				txtStuId.setText((String)tablemodel.getValueAt(selectedRow, 0));
				Object oName = tablemodel.getValueAt(selectedRow, 1);
				txtStuName.setText((String)oName);
				String sex = (String) tablemodel.getValueAt(selectedRow, 2);
				if(sex.equals("男")){
					coboStuSex.setSelectedIndex(0);
				}else if(sex.equals("女")){
					coboStuSex.setSelectedIndex(1);
				}else{
					coboStuSex.setSelectedIndex(-1);
				}
				Object phone = tablemodel.getValueAt(selectedRow, 3);
				txtStuPhone.setText((String)phone);

				String className = (String) tablemodel.getValueAt(selectedRow, 4);
				List list=cOp.getallclass();//获取所有班级
				for(int i=0;i<list.size();i++){
					Tb_class tb_class=(Tb_class) list.get(i);
					if(tb_class.getclassname().equals(className)){
						coboStuClass.setSelectedIndex(i);
						break;
					}
				}
			}
		});
		return table;
	}

}
