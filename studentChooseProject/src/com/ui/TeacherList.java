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
		table.setPreferredScrollableViewportSize(new Dimension(780,200));//���ô˱���ͼ��ѡ��С					
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  //��ѡ	
		table.setRowSorter(new TableRowSorter(tablemodel));//���ÿɽ���������
		table.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				int selectedRow = table.getSelectedRow(); //���ѡ��������
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
		setTitle("�鿴���н�ʦ");
		ImageEg background=new ImageEg("image1.jpg");
		background.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(background);
		background.setLayout(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);//�Զ������������
		table=getallccourse();//���ɱ��

		JScrollPane s = new JScrollPane(table);//��ӹ������
		s.setBounds(31, 10, 584, 190);
		background.add(s);
		
		lblTeacherId=new JLabel("��ʦ��ţ�");//11
		lblTeacherId.setBounds(46, 246, 72, 30);
		background.add(lblTeacherId);
		
		//txtStuId=new JTextField();//12
		txtTeacherId.setBounds(117, 247, 134, 30);
		txtTeacherId.setEditable(false);
		background.add(txtTeacherId);
		
		btnModify=new JButton("�޸�");
		btnModify.setBounds(371, 370, 70, 35);
		btnModify.addActionListener(this);
		background.add(btnModify);
		
		btnDelete=new JButton("ɾ��");
		btnDelete.setBounds(446, 370, 70, 35);
		btnDelete.addActionListener(this);
		background.add(btnDelete);
		
		btnCancle=new JButton("ȡ��");
		btnCancle.setBounds(521, 370, 70, 35);
		btnCancle.addActionListener(this);
		background.add(btnCancle);

		lblTeacherName = new JLabel("��ʦ������");
		lblTeacherName.setBounds(361, 244, 70, 34);
		background.add(lblTeacherName);
		
		//txtStuName = new JTextField();
		txtTeacherName.setColumns(10);
		txtTeacherName.setBounds(430, 246, 151, 31);
		background.add(txtTeacherName);
		
		lblPassword = new JLabel("��ʦ���룺");
		lblPassword.setBounds(46, 298, 72, 34);
		background.add(lblPassword);
		
		//txtStuPhone = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(117, 299, 134, 33);
		background.add(txtPassword);
		
		lblTeacherMajorId = new JLabel("����רҵ��");
		lblTeacherMajorId.setBounds(366, 297, 72, 34);
		background.add(lblTeacherMajorId);
		
		coboMajorId.setBounds(430, 298, 153, 34);		
		List list=majorOp.getAllMajors();
		coboMajorId.addItem("");
		for(int i=0;i<list.size();i++){
			Tb_major major=(Tb_major)list.get(i);//���������ȡ��list�еİ༶����
			//coboStuClass.addItem(tb_class.getclassname());//���༶����İ༶��������ȡ������ӵ������б���
			coboMajorId.addItem(new Tb_major(major.getmajorId(),major.getmajorName()));
		}
		coboMajorId.addItemListener(new ItemListener() {		
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(e.getStateChange()==ItemEvent.SELECTED){					
					int index=coboMajorId.getSelectedIndex();	
					if(coboMajorId.getSelectedIndex()==-1){
						JOptionPane.showMessageDialog(null, "��ѡ���Ӧ�İ༶");
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
		if(e.getActionCommand().equals("�޸�")){		
			teacherInfo.setTeacherId(txtTeacherId.getText());
			teacherInfo.setTeacherName(txtTeacherName.getText());
			teacherInfo.setPassword(txtPassword.getText());
			Tb_major tbMajor=(Tb_major) coboMajorId.getSelectedItem();
			teacherInfo.setMajorId(tbMajor.getmajorId());
			
			if(teacherOp.modifyTeacher(teacherInfo)){
				JOptionPane.showMessageDialog(this, "��ϲ���޸ĳɹ�����");
				//tablemodel.setRowCount(0);//���ѡ��
				tablemodel.updateModel();//��������TeacherTableModel
				table.setModel(tablemodel);
				table.updateUI();
				txtTeacherId.setText("");
				txtTeacherName.setText("");
				txtPassword.setText("");
				coboMajorId.setSelectedIndex(-1);
			}
		}
		
		if(e.getActionCommand().equals("ɾ��")){
			if(txtTeacherId.getText().equals("")){
				JOptionPane.showMessageDialog(null, "����ѡ��Ҫɾ����ѧ��");
			}
			else{
				int selectedRow = table.getSelectedRow(); //���ѡ��������
				String stuId=(String) tablemodel.getValueAt(selectedRow, 0);//��ȡ����еĵ�һ�е�ֵ��������е�����ֵ��
				String mString=teacherOp.deleteTeacher(stuId);
				JOptionPane.showMessageDialog(this, mString);
//				tablemodel=new TeacherTableModel();
				tablemodel.updateModel();//��������TeacherTableModel
				//����ط���ԭ������������tablemodel�����Ϊ��������model��������ɾ��ѧ�������bug
				table.setModel(tablemodel);
				table.updateUI();
				txtTeacherId.setText("");
				txtTeacherName.setText("");
				txtPassword.setText("");
				coboMajorId.setSelectedIndex(-1);
			}
		}
		if(e.getActionCommand().equals("ȡ��")){
			txtTeacherId.setText("");
			txtTeacherName.setText("");
			txtPassword.setText("");
			coboMajorId.setSelectedIndex(-1);
		}
	}

}
