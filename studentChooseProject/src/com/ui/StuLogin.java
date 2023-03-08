package com.ui;

import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.Bean.TB_password;
import com.dao.rememberPasswordOp;
import com.db.connectiontomysql;
import egtool.Judgeidexit;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.List;

import static java.lang.Thread.sleep;

public class StuLogin extends JFrame implements ActionListener  {
	private JPanel contentPane;
	private JLabel lblUserName;
	private JLabel lblUserPWD;
	private JLabel lblVerificationCode;
	private JLabel label;
	private JTextField txtName;
	private JTextField txtVC;
	private JTextField VC;
	private JPasswordField passwordField;
	private JRadioButton rbadmin;
	private JRadioButton rbteacher;
	private JRadioButton rbstu;
	private JCheckBox rememberPassword;
	private JCheckBox login;
	JButton btnNewButton;
	String  strMajorName;
	private JComboBox<String>  cbmajorName;

	String[] rand=new String[4];
	String rand1="";
	int flag=0;


	public String lgrole;//��¼����ݣ�����Ա����ʦ��ѧ��
	public String lgname;//��¼��ID

	connectiontomysql connectiontomysql=new connectiontomysql();
	TB_password remember=new TB_password();
	rememberPasswordOp passwordOp=new rememberPasswordOp();
	Code code=new Code();
	Icon icon;



	public static void main(String[] args) {

		// TODO Auto-generated method stub
		StuLogin stuLg=new StuLogin();
		stuLg.setVisible(true);
	}
	//���캯��
	public StuLogin(){



		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���ô���ر�ʱ��ʲô
		setBounds(100, 100, 450, 440);//���ô�����ֵ����꼰�����
		setTitle("ѧ��ѡ�μ��ɼ�����ϵͳ");//���ñ���
		contentPane = new JPanel();//�����������
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));//����Jpanel�ı߿򼰱߾�
		setContentPane(contentPane);//�����������
		contentPane.setLayout(null);//�������Ĳ��ַ�ʽΪ���Բ���
		contentPane.setVisible(true);

//		VC.setBounds(175, 181, 101, 36);

		rand=code.Code();//������֤��ͼƬ
		rand1=rand[0]+rand[1]+rand[2]+rand[3];
	    icon=new ImageIcon("src//image//code.jpg");
	    label=new JLabel(icon);//����jlabal
		label.setBounds(175, 181, 141, 46);
		contentPane.add(label);

		label.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
			code.Code();
				Icon icon= null;
				try {
					icon = new ImageIcon(ImageIO.read(new File("src//image//code.jpg")));
				} catch (IOException ioException) {
					ioException.printStackTrace();//�����ַ�ʽ����
				}
				label.setIcon(icon);
			}
		});

		lblUserName = new JLabel("�û�������");
		lblUserName.setFont(new Font("����", Font.PLAIN, 15));//��������
		//Font.PLANIN ��ͨ��ʽ����
		//Font.BOLD   ������ʽ����
		//Font.ITALIC б����ʽ����
		lblUserName.setBounds(43, 1, 82, 36);
		contentPane.add(lblUserName);

		lblUserPWD = new JLabel("�û����룺");
		lblUserPWD.setFont(new Font("����", Font.PLAIN, 15));
		lblUserPWD.setBounds(43, 60, 82, 36);
		contentPane.add(lblUserPWD);

		txtName = new JTextField();//���ɶ���
		txtName.setFont(new Font("����", Font.PLAIN, 15));
		txtName.setBounds(140, 1, 171, 36);
		contentPane.add(txtName);
		txtName.setColumns(10);//�����ı�����һ�е��ַ���

		passwordField = new JPasswordField();
		passwordField.setBounds(140, 60, 171, 36);
		contentPane.add(passwordField);

		txtVC = new JTextField();//���ɶ���
		txtVC.setFont(new Font("����", Font.PLAIN, 15));
		txtVC.setBounds(140, 121, 171, 36);
		contentPane.add(txtVC);
		txtVC.setColumns(10);//�����ı�����һ�е��ַ���

		lblVerificationCode = new JLabel("��֤�룺");
		lblVerificationCode.setFont(new Font("����", Font.PLAIN, 15));
		lblVerificationCode.setBounds(43, 120, 82, 36);
		contentPane.add(lblVerificationCode);


		ButtonGroup bg=new ButtonGroup();//�����������
		rbadmin=new JRadioButton("����Ա");
		rbadmin.setBounds(73, 236, 75, 36);
		//rbadmin.setSelected(true);
		contentPane.add(rbadmin);
		rbteacher=new JRadioButton("��ʦ");
		rbteacher.setBounds(160, 236, 75, 36);
		contentPane.add(rbteacher);
		rbstu=new JRadioButton("ѧ��");
		rbstu.setBounds(240, 236, 75, 36);
		contentPane.add(rbstu);
		bg.add(rbadmin);//��������ѡ��ť��ӽ����������
		bg.add(rbteacher);
		bg.add(rbstu);

		rememberPassword=new JCheckBox("��ס����");
		rememberPassword.setBounds(73, 271, 75, 36);
		rememberPassword.addActionListener(this);
		contentPane.add(rememberPassword);
		//rbadmin.setSelected(true);

		login=new JCheckBox("�Զ���¼");
		login.setBounds(152, 271, 75, 36);
		login.addActionListener(this);
		contentPane.add(login);
		//rbadmin.setSelected(true);

		//		txtName.setBounds(140, 1, 171, 36);

//	 �����б����û��ı����غ�
		cbmajorName = new JComboBox<String>();
		cbmajorName.setBounds(140, 1, 192, 36);
		contentPane.add(cbmajorName);
		cbmajorName.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				strMajorName = cbmajorName.getSelectedItem().toString();
			}//�����б�
		});

		//���ɶ���
		List list = passwordOp.getuser();
		for(int i=0;i<list.size();i++)
			cbmajorName.addItem(list.get(i).toString());
		this.validate();
//		���������б�
		cbmajorName.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange()==ItemEvent.SELECTED){

					String admin=cbmajorName.getSelectedItem().toString();
					txtName.setText(admin);
					String name=txtName.getText();
					String password=passwordOp.getIdByName(name);
					passwordField.setText(password);
				}
			}
		});
		btnNewButton = new JButton("��¼");
		btnNewButton.setFont(new Font("����", Font.PLAIN, 15));
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(275, 296, 75, 30);
		contentPane.add(btnNewButton);

		JButton  btnCanle= new JButton("ע��");
		btnCanle.setFont(new Font("����", Font.PLAIN, 15));
		btnCanle.addActionListener(this);
		btnCanle.setBounds(355, 296, 75, 30);
		contentPane.add(btnCanle);

		JButton  btnGetBackPassword= new JButton("�һ�����");
		btnGetBackPassword.setFont(new Font("����", Font.PLAIN, 15));
		btnGetBackPassword.addActionListener(this);
		btnGetBackPassword.setBounds(300, 360, 100, 30);
		contentPane.add(btnGetBackPassword);

	}

	public void actionPerformed(ActionEvent e){

		if(e.getActionCommand().equals("��¼")){
			try{
				if(rbadmin.isSelected()){
					String pwd=new String(passwordField.getPassword());//����������������
					if(txtName.getText().equals("admin") && pwd.equals("123456")&& txtVC.getText().equals(rand1)) {

						lgrole="����Ա";
						lgname="admin";
						MainFrame mf=new MainFrame(lgrole,lgname);
						mf.setVisible(true);
						flag=1;
					}else{
						JOptionPane.showMessageDialog(null, "�û������������");
						txtName.setText("");
						passwordField.setText("");
						txtVC.setText("");    //����
						code.Code();
						icon = new ImageIcon(ImageIO.read(new File("src//image//code.jpg")));
						label.setIcon(icon);



					}
				}else if(rbteacher.isSelected()){
					Connection con=(Connection) connectiontomysql.getConnection();
					PreparedStatement pstmt=con.prepareStatement("select * from tb_teacher where teacherid=? and password=? ");
					pstmt.setString(1, txtName.getText());
					pstmt.setString(2, new String(passwordField.getPassword()));
					ResultSet rSet=pstmt.executeQuery();//pstmt.executeUpdate()
					if(rSet.next()&& txtVC.getText().equals(rand1)){
						JOptionPane.showMessageDialog(null, "��ʦ��¼�ɹ���");
						//this.setVisible(false);
						this.setVisible(false);
						flag=1;
						lgrole="��ʦ";
						lgname=txtName.getText();
						MainFrame mf=new MainFrame(lgrole,lgname);
						mf.setVisible(true);
					}
					else{
						JOptionPane.showMessageDialog(null, "�û������������");
						txtName.setText("");
						passwordField.setText("");
						txtVC.setText("");

						code.Code();
						icon = new ImageIcon(ImageIO.read(new File("src//image//code.jpg")));
						label.setIcon(icon);

					}
				}
				else if(rbstu.isSelected()){
					Connection con=(Connection) connectiontomysql.getConnection();
					PreparedStatement pstmt=con.prepareStatement("select * from tb_stuinfo where stuid=? and password=? ");
					pstmt.setString(1, txtName.getText());
					pstmt.setString(2, new String(passwordField.getPassword()));
					ResultSet rSet=pstmt.executeQuery();//pstmt.executeUpdate()
					//int a=pstmt.executeUpdate();
					if(rSet.next()&& txtVC.getText().equals(rand1)){
						JOptionPane.showMessageDialog(null, "ͬѧ��¼�ɹ���");
						//this.setVisible(false);
						this.setVisible(false);
						flag=1;
						lgrole="ͬѧ";
						lgname=txtName.getText();
						MainFrame mf=new MainFrame(lgrole,lgname);
						mf.setVisible(true);
					}else{
						JOptionPane.showMessageDialog(null, "�û������������");
						txtName.setText("");
						passwordField.setText("");
						txtVC.setText("");

						code.Code();
						icon = new ImageIcon(ImageIO.read(new File("src//image//code.jpg")));
						label.setIcon(icon);
					}
				}

				else {
					JOptionPane.showMessageDialog(null, "��ѡ���¼���");
				}
			}
			catch (Exception er) {
				// TODO: handle exception
				er.printStackTrace();
			}
		}

		//ע�����
		else if(e.getActionCommand().equals("ע��")){

			Register register=new Register();
			register.setVisible(true);

		}
		//�һ�����
		else if(e.getActionCommand().equals("�һ�����")){
			getBackPassword help=new getBackPassword();
			help.setVisible(true);
		}
		//��ס����
		if(rememberPassword.isSelected()&&flag==1){
			if (new Judgeidexit().judgename(txtName.getText().trim()))//���ݿ���û�����ݾʹ洢
			{
				remember.setRbname(txtName.getText().trim());
				String password=new String(passwordField.getPassword());
				remember.setRbpassword(password);
				passwordOp.Addremember(remember);
			}
			else{//�оͲ�����

			}
		}
		if(login.isSelected())//�Զ���¼��ִ�е�¼��һ�ײ���
		{
			try{
				if(rbadmin.isSelected()){
					String pwd=new String(passwordField.getPassword());
					if(txtName.getText().equals("admin") && pwd.equals("123456")&& txtVC.getText().equals(rand)) {


						this.setVisible(false);
						lgrole="����Ա";
						lgname="admin";

						MainFrame mf=new MainFrame(lgrole,lgname);
						mf.setVisible(true);
						flag=1;
					}else{
						JOptionPane.showMessageDialog(null, "�û�������֤����������");
						txtName.setText("");
						passwordField.setText("");
						txtVC.setText("");
						code.Code();
						icon = new ImageIcon(ImageIO.read(new File("src//image//code.jpg")));
						label.setIcon(icon);

					}
				}else if(rbteacher.isSelected()){
					Connection con=(Connection) connectiontomysql.getConnection();
					PreparedStatement pstmt=con.prepareStatement("select * from tb_teacher where teacherid=? and password=? ");
					pstmt.setString(1, txtName.getText());
					pstmt.setString(2, new String(passwordField.getPassword()));
					ResultSet rSet=pstmt.executeQuery();//pstmt.executeUpdate()
					if(rSet.next()&& txtVC.getText().equals(rand)){
						JOptionPane.showMessageDialog(null, "��ʦ��¼�ɹ���");
						//this.setVisible(false);
						this.setVisible(false);
						flag=1;
						lgrole="��ʦ";
						lgname=txtName.getText();
						MainFrame mf=new MainFrame(lgrole,lgname);
						mf.setVisible(true);
					}
					else{
						JOptionPane.showMessageDialog(null, "�û�������֤����������");
						txtName.setText("");
						passwordField.setText("");
						txtVC.setText("");
						code.Code();
						icon = new ImageIcon(ImageIO.read(new File("src//image//code.jpg")));
						label.setIcon(icon);

					}
				}
				else if(rbstu.isSelected()){
					Connection con=(Connection) connectiontomysql.getConnection();
					PreparedStatement pstmt=con.prepareStatement("select * from tb_stuinfo where stuid=? and password=? ");
					pstmt.setString(1, txtName.getText());
					pstmt.setString(2, new String(passwordField.getPassword()));
					ResultSet rSet=pstmt.executeQuery();//pstmt.executeUpdate()
					//int a=pstmt.executeUpdate();
					if(rSet.next()&& txtVC.getText().equals(rand)){
						JOptionPane.showMessageDialog(null, "ͬѧ��¼�ɹ���");
						//this.setVisible(false);
						this.setVisible(false);
						flag=1;
						lgrole="ͬѧ";
						lgname=txtName.getText();
						MainFrame mf=new MainFrame(lgrole,lgname);
						mf.setVisible(true);
					}else{
						JOptionPane.showMessageDialog(null, "�û�������֤����������");
						txtName.setText("");
						passwordField.setText("");
						txtVC.setText("");
						code.Code();
						icon = new ImageIcon(ImageIO.read(new File("src//image//code.jpg")));
						label.setIcon(icon);
					}
				}


				else {
					JOptionPane.showMessageDialog(null, "��ѡ���¼���");
				}
			}
			catch (Exception er) {
				// TODO: handle exception
				er.printStackTrace();
			}
		}
	}
}
