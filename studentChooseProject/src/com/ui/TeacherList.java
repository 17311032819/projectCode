package com.ui;

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

import com.Bean.Tb_major;
import com.Bean.Tb_teacher;
import com.dao.MajorOp;
import com.dao.TeacherOp;

import egtool.TeacherTableModel;

public class TeacherList extends JFrame implements ActionListener{

	private JLabel lblTeacherId;
	private JLabel lblTeacherName;
	private JLabel lblPassword;
	private JLabel lblTeacherMajorId;
	private JTextField txtTeacherId=new JTextField();
	private JTextField txtTeacherName=new JTextField();
	private JTextField txtPassword=new JTextField();
	private JButton btnModify;
	private JButton btnDelete;
	private JButton btnCancle;
	private JComboBox coboMajorId=new JComboBox();
	TeacherTableModel tablemodel=new TeacherTableModel();
	private JTable table;
//    private JPanel contentPane;
    Tb_teacher teacherInfo=new Tb_teacher();
    MajorOp majorOp=new MajorOp();
    TeacherOp teacherOp=new TeacherOp();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TeacherList();

	}
	public JTable getallccourse(){		
		table = new JTable(tablemodel);
		table.setPreferredScrollableViewportSize(new Dimension(780,200));//设置此表视图首选大小					
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  //单选	
		table.setRowSorter(new TableRowSorter(tablemodel));//设置可进行行排序
		table.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				int selectedRow = table.getSelectedRow(); //获得选中行索引
				txtTeacherId.setText((String)tablemodel.getValueAt(selectedRow, 0));
				Object oName = tablemodel.getValueAt(selectedRow, 1);		               
                txtTeacherName.setText((String)oName);
                String password = (String) tablemodel.getValueAt(selectedRow, 2);
                txtPassword.setText(password);
                String majorName = (String) tablemodel.getValueAt(selectedRow, 3);
                List list=majorOp.getAllMajors();
                for(int i=0;i<list.size();i++){
                	Tb_major tb_major=(Tb_major) list.get(i);
                	if(tb_major.getmajorName().equals(majorName)){
                		coboMajorId.setSelectedIndex(i+1);
                		break;
                	}
                }
			}
		});
		return table;    
	}
	public TeacherList(){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 668, 486);
		setTitle("查看所有教师");
		ImageEg background=new ImageEg("image1.jpg");
		background.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(background);
		background.setLayout(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);//自动跳至界面最大化
		table=getallccourse();//生成表格

		JScrollPane s = new JScrollPane(table);//添加滚动面板
		s.setBounds(31, 10, 584, 190);
		background.add(s);
		
		lblTeacherId=new JLabel("教师编号：");//11
		lblTeacherId.setBounds(46, 246, 72, 30);
		background.add(lblTeacherId);
		
		//txtStuId=new JTextField();//12
		txtTeacherId.setBounds(117, 247, 134, 30);
		txtTeacherId.setEditable(false);
		background.add(txtTeacherId);
		
		btnModify=new JButton("修改");
		btnModify.setBounds(371, 370, 70, 35);
		btnModify.addActionListener(this);
		background.add(btnModify);
		
		btnDelete=new JButton("删除");
		btnDelete.setBounds(446, 370, 70, 35);
		btnDelete.addActionListener(this);
		background.add(btnDelete);
		
		btnCancle=new JButton("取消");
		btnCancle.setBounds(521, 370, 70, 35);
		btnCancle.addActionListener(this);
		background.add(btnCancle);

		lblTeacherName = new JLabel("教师姓名：");
		lblTeacherName.setBounds(361, 244, 70, 34);
		background.add(lblTeacherName);
		
		//txtStuName = new JTextField();
		txtTeacherName.setColumns(10);
		txtTeacherName.setBounds(430, 246, 151, 31);
		background.add(txtTeacherName);
		
		lblPassword = new JLabel("教师密码：");
		lblPassword.setBounds(46, 298, 72, 34);
		background.add(lblPassword);
		
		//txtStuPhone = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(117, 299, 134, 33);
		background.add(txtPassword);
		
		lblTeacherMajorId = new JLabel("所属专业：");
		lblTeacherMajorId.setBounds(366, 297, 72, 34);
		background.add(lblTeacherMajorId);
		
		coboMajorId.setBounds(430, 298, 153, 34);		
		List list=majorOp.getAllMajors();
		coboMajorId.addItem("");
		for(int i=0;i<list.size();i++){
			Tb_major major=(Tb_major)list.get(i);//按序号依次取出list中的班级对象
			//coboStuClass.addItem(tb_class.getclassname());//将班级对象的班级名称属性取出来添加到下拉列表中
			coboMajorId.addItem(new Tb_major(major.getmajorId(),major.getmajorName()));
		}
		coboMajorId.addItemListener(new ItemListener() {		
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(e.getStateChange()==ItemEvent.SELECTED){					
					int index=coboMajorId.getSelectedIndex();	
					if(coboMajorId.getSelectedIndex()==-1){
						JOptionPane.showMessageDialog(null, "请选择对应的班级");
					}else{
						Tb_major tc=(Tb_major) coboMajorId.getSelectedItem();					
					}									
				}
			}
		});
		background.add(coboMajorId);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("修改")){		
			teacherInfo.setTeacherId(txtTeacherId.getText());
			teacherInfo.setTeacherName(txtTeacherName.getText());
			teacherInfo.setPassword(txtPassword.getText());
			Tb_major tbMajor=(Tb_major) coboMajorId.getSelectedItem();
			teacherInfo.setMajorId(tbMajor.getmajorId());
			
			if(teacherOp.modifyTeacher(teacherInfo)){
				JOptionPane.showMessageDialog(this, "恭喜你修改成功啦！");
				//tablemodel.setRowCount(0);//清空选择
				tablemodel.updateModel();//重新生成TeacherTableModel
				table.setModel(tablemodel);
				table.updateUI();
				txtTeacherId.setText("");
				txtTeacherName.setText("");
				txtPassword.setText("");
				coboMajorId.setSelectedIndex(-1);
			}
		}
		
		if(e.getActionCommand().equals("删除")){
			if(txtTeacherId.getText().equals("")){
				JOptionPane.showMessageDialog(null, "请先选择要删除的学生");
			}
			else{
				int selectedRow = table.getSelectedRow(); //获得选中行索引
				String stuId=(String) tablemodel.getValueAt(selectedRow, 0);//获取点击行的第一列的值（即点击行的主键值）
				String mString=teacherOp.deleteTeacher(stuId);
				JOptionPane.showMessageDialog(this, mString);
//				tablemodel=new TeacherTableModel();
				tablemodel.updateModel();//重新设置TeacherTableModel
				//这个地方由原来的重新生成tablemodel对象改为重新设置model对象，修正删除学生报错的bug
				table.setModel(tablemodel);
				table.updateUI();
				txtTeacherId.setText("");
				txtTeacherName.setText("");
				txtPassword.setText("");
				coboMajorId.setSelectedIndex(-1);
			}
		}
		if(e.getActionCommand().equals("取消")){
			txtTeacherId.setText("");
			txtTeacherName.setText("");
			txtPassword.setText("");
			coboMajorId.setSelectedIndex(-1);
		}
	}

}
