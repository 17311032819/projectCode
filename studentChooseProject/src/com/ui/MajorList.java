package com.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
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
import javax.swing.table.TableRowSorter;

import com.Bean.Tb_course;
import com.Bean.Tb_major;
import com.dao.CourseOp;
import com.dao.MajorOp;

import egtool.Judgeidexit;
import egtool.MajorTableModel;
import egtool.MyTableModel;

public class MajorList extends JFrame implements ActionListener {
	private JLabel lblMajorId;
	private JLabel lblMajorName;
	private JLabel lblMajorMaster;
	private JLabel lblMasjorMasterPhone;
	private JTextField txtMajorId;
	private JTextField txtMajorName;
	private JTextField txtMasjorMaster;
	private JTextField txtMasjorMasterPhone;
	private JButton btnModify;
	private JButton btnDelete;
	private JButton btnCancle;
	private JTable table;
	Tb_major major=new Tb_major();
	MajorOp majorOp=new MajorOp();
	MajorTableModel majorTableModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MajorList frame = new MajorList();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public JTable getAllMajor(){
		majorTableModel=new MajorTableModel();
		table = new JTable(majorTableModel);
		table.setPreferredScrollableViewportSize(new Dimension(780,200));//���ô˱���ͼ��ѡ��С					
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  //��ѡ	
		//table.setRowSorter(new TableRowSorter(majorTableModel));//���ÿɽ���������
		table.addMouseListener(new MouseAdapter(){    //����¼�
            public void mouseClicked(MouseEvent e){			         	
                int selectedRow = table.getSelectedRow(); //���ѡ��������	        
                txtMajorId.setText((String)majorTableModel.getValueAt(selectedRow, 0));
                Object oName = majorTableModel.getValueAt(selectedRow, 1);		               
                txtMajorName.setText((String)oName);
                Object oMaster = majorTableModel.getValueAt(selectedRow, 2);
                txtMasjorMaster.setText((String)oMaster);
                Object oMasterPhone=majorTableModel.getValueAt(selectedRow, 3);
                txtMasjorMasterPhone.setText((String)oMasterPhone);            
            }
        });
		return table; 
	}

	/**
	 * Create the frame.
	 */
	public MajorList() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 485, 400);
		ImageEg background=new ImageEg("image1.jpg");
		background.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(background);
		background.setLayout(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);//�Զ������������
		setTitle("רҵ����");
		
		table=getAllMajor();//���ɱ��
		
		JScrollPane s = new JScrollPane(table);//��ӹ������
		s.setBounds(5, 5, 450, 207);		
		background.add(s);
		
		lblMajorId=new JLabel("רҵ��ţ�");
		lblMajorId.setBounds(5, 225, 75, 30);
		background.add(lblMajorId);
		
		txtMajorId=new JTextField();
		txtMajorId.setBounds(80, 225, 145, 30);
		txtMajorId.setEditable(false);
		background.add(txtMajorId);
		
		lblMajorName=new JLabel("רҵ���� ��");
		lblMajorName.setBounds(235, 225, 75, 30);
		background.add(lblMajorName);
		
		txtMajorName=new JTextField();
		txtMajorName.setBounds(310, 225, 145, 30);
		background.add(txtMajorName);
		
		lblMajorMaster=new JLabel("רҵ���Σ�");
		lblMajorMaster.setBounds(5, 265, 75, 30);
		background.add(lblMajorMaster);
		
		txtMasjorMaster=new JTextField();
		txtMasjorMaster.setBounds(80, 265, 145, 30);
		background.add(txtMasjorMaster);
		
		lblMasjorMasterPhone=new JLabel("��ϵ�绰��");
		lblMasjorMasterPhone.setBounds(235, 265, 75, 30);
		background.add(lblMasjorMasterPhone);
		
		txtMasjorMasterPhone=new JTextField();
		txtMasjorMasterPhone.setBounds(310, 265, 145, 30);
		background.add(txtMasjorMasterPhone);
			
		btnModify=new JButton("�޸�");
		btnModify.setBounds(235, 310, 70, 35);
		btnModify.addActionListener(this);
		background.add(btnModify);
		
		btnDelete=new JButton("ɾ��");
		btnDelete.setBounds(310, 310, 70, 35);
		btnDelete.addActionListener(this);
		background.add(btnDelete);
		
		btnCancle=new JButton("ȡ��");
		btnCancle.setBounds(385, 310, 70, 35);
		btnCancle.addActionListener(this);
		background.add(btnCancle);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand().equals("�޸�")){		
			major.setmajorId(txtMajorId.getText());
			major.setmajorName(txtMajorName.getText());
			major.setmajorMaster(txtMasjorMaster.getText());
			major.setmajorMasterPhone(txtMasjorMasterPhone.getText());
			
			if(majorOp.modifyMojor(major)){
				JOptionPane.showMessageDialog(this, "��ϲ���޸ĳɹ�����");
				majorTableModel.setRowCount(0);//���ѡ��
				majorTableModel=new MajorTableModel();//��������majorTableModel
				table.setModel(majorTableModel);
				txtMajorId.setText("");
				txtMajorName.setText("");
				txtMasjorMaster.setText("");
				txtMasjorMasterPhone.setText("");
			}
		}
		if(e.getActionCommand().equals("ɾ��")){
			if(txtMajorId.getText().equals("")){
				JOptionPane.showMessageDialog(null, "����ѡ��Ҫɾ����רҵ");
			}
			else{
				major.setmajorId(txtMajorId.getText());	
				major.setmajorName(txtMajorName.getText());
				major.setmajorMaster(txtMasjorMaster.getText());
				String mString=majorOp.deleteMajor(major);
				JOptionPane.showMessageDialog(this, mString);
				//majorTableModel=new MajorTableModel();
				majorTableModel.setRowCount(0);//���ѡ��
				majorTableModel=new MajorTableModel();//��������majorTableModel
				table.setModel(majorTableModel);
				txtMajorId.setText("");
				txtMajorName.setText("");
				txtMasjorMaster.setText("");
				txtMasjorMasterPhone.setText("");
			}
		}		
		if(e.getActionCommand().equals("ȡ��")){
			txtMajorId.setText("");
			txtMajorName.setText("");
			txtMasjorMaster.setText("");
			txtMasjorMasterPhone.setText("");
		}
		
	}
	

}
