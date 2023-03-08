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


	public String lgrole;//登录者身份：管理员、教师，学生
	public String lgname;//登录者ID

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
	//构造函数
	public StuLogin(){



		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置窗体关闭时做什么
		setBounds(100, 100, 450, 440);//设置窗体出现的坐标及宽与高
		setTitle("学生选课及成绩管理系统");//设置标题
		contentPane = new JPanel();//生成内容面板
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));//设置Jpanel的边框及边距
		setContentPane(contentPane);//设置内容面板
		contentPane.setLayout(null);//设置它的布局方式为绝对布局
		contentPane.setVisible(true);

//		VC.setBounds(175, 181, 101, 36);

		rand=code.Code();//生成验证码图片
		rand1=rand[0]+rand[1]+rand[2]+rand[3];
	    icon=new ImageIcon("src//image//code.jpg");
	    label=new JLabel(icon);//加入jlabal
		label.setBounds(175, 181, 141, 46);
		contentPane.add(label);

		label.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
			code.Code();
				Icon icon= null;
				try {
					icon = new ImageIcon(ImageIO.read(new File("src//image//code.jpg")));
				} catch (IOException ioException) {
					ioException.printStackTrace();//用这种方式重置
				}
				label.setIcon(icon);
			}
		});

		lblUserName = new JLabel("用户姓名：");
		lblUserName.setFont(new Font("宋体", Font.PLAIN, 15));//设置字体
		//Font.PLANIN 普通样式常量
		//Font.BOLD   粗体样式常量
		//Font.ITALIC 斜体样式常量
		lblUserName.setBounds(43, 1, 82, 36);
		contentPane.add(lblUserName);

		lblUserPWD = new JLabel("用户密码：");
		lblUserPWD.setFont(new Font("宋体", Font.PLAIN, 15));
		lblUserPWD.setBounds(43, 60, 82, 36);
		contentPane.add(lblUserPWD);

		txtName = new JTextField();//生成对象
		txtName.setFont(new Font("宋体", Font.PLAIN, 15));
		txtName.setBounds(140, 1, 171, 36);
		contentPane.add(txtName);
		txtName.setColumns(10);//设置文本框里一行的字符数

		passwordField = new JPasswordField();
		passwordField.setBounds(140, 60, 171, 36);
		contentPane.add(passwordField);

		txtVC = new JTextField();//生成对象
		txtVC.setFont(new Font("宋体", Font.PLAIN, 15));
		txtVC.setBounds(140, 121, 171, 36);
		contentPane.add(txtVC);
		txtVC.setColumns(10);//设置文本框里一行的字符数

		lblVerificationCode = new JLabel("验证码：");
		lblVerificationCode.setFont(new Font("宋体", Font.PLAIN, 15));
		lblVerificationCode.setBounds(43, 120, 82, 36);
		contentPane.add(lblVerificationCode);


		ButtonGroup bg=new ButtonGroup();//添加组管理组件
		rbadmin=new JRadioButton("管理员");
		rbadmin.setBounds(73, 236, 75, 36);
		//rbadmin.setSelected(true);
		contentPane.add(rbadmin);
		rbteacher=new JRadioButton("老师");
		rbteacher.setBounds(160, 236, 75, 36);
		contentPane.add(rbteacher);
		rbstu=new JRadioButton("学生");
		rbstu.setBounds(240, 236, 75, 36);
		contentPane.add(rbstu);
		bg.add(rbadmin);//将三个单选按钮添加进组管理器中
		bg.add(rbteacher);
		bg.add(rbstu);

		rememberPassword=new JCheckBox("记住密码");
		rememberPassword.setBounds(73, 271, 75, 36);
		rememberPassword.addActionListener(this);
		contentPane.add(rememberPassword);
		//rbadmin.setSelected(true);

		login=new JCheckBox("自动登录");
		login.setBounds(152, 271, 75, 36);
		login.addActionListener(this);
		contentPane.add(login);
		//rbadmin.setSelected(true);

		//		txtName.setBounds(140, 1, 171, 36);

//	 下拉列表，与用户文本框重合
		cbmajorName = new JComboBox<String>();
		cbmajorName.setBounds(140, 1, 192, 36);
		contentPane.add(cbmajorName);
		cbmajorName.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				strMajorName = cbmajorName.getSelectedItem().toString();
			}//下拉列表
		});

		//生成对象
		List list = passwordOp.getuser();
		for(int i=0;i<list.size();i++)
			cbmajorName.addItem(list.get(i).toString());
		this.validate();
//		监听下拉列表
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
		btnNewButton = new JButton("登录");
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 15));
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(275, 296, 75, 30);
		contentPane.add(btnNewButton);

		JButton  btnCanle= new JButton("注册");
		btnCanle.setFont(new Font("宋体", Font.PLAIN, 15));
		btnCanle.addActionListener(this);
		btnCanle.setBounds(355, 296, 75, 30);
		contentPane.add(btnCanle);

		JButton  btnGetBackPassword= new JButton("找回密码");
		btnGetBackPassword.setFont(new Font("宋体", Font.PLAIN, 15));
		btnGetBackPassword.addActionListener(this);
		btnGetBackPassword.setBounds(300, 360, 100, 30);
		contentPane.add(btnGetBackPassword);

	}

	public void actionPerformed(ActionEvent e){

		if(e.getActionCommand().equals("登录")){
			try{
				if(rbadmin.isSelected()){
					String pwd=new String(passwordField.getPassword());//接收密码框里的内容
					if(txtName.getText().equals("admin") && pwd.equals("123456")&& txtVC.getText().equals(rand1)) {

						lgrole="管理员";
						lgname="admin";
						MainFrame mf=new MainFrame(lgrole,lgname);
						mf.setVisible(true);
						flag=1;
					}else{
						JOptionPane.showMessageDialog(null, "用户名或密码错误！");
						txtName.setText("");
						passwordField.setText("");
						txtVC.setText("");    //赋空
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
						JOptionPane.showMessageDialog(null, "老师登录成功了");
						//this.setVisible(false);
						this.setVisible(false);
						flag=1;
						lgrole="老师";
						lgname=txtName.getText();
						MainFrame mf=new MainFrame(lgrole,lgname);
						mf.setVisible(true);
					}
					else{
						JOptionPane.showMessageDialog(null, "用户名或密码错误！");
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
						JOptionPane.showMessageDialog(null, "同学登录成功了");
						//this.setVisible(false);
						this.setVisible(false);
						flag=1;
						lgrole="同学";
						lgname=txtName.getText();
						MainFrame mf=new MainFrame(lgrole,lgname);
						mf.setVisible(true);
					}else{
						JOptionPane.showMessageDialog(null, "用户名或密码错误！");
						txtName.setText("");
						passwordField.setText("");
						txtVC.setText("");

						code.Code();
						icon = new ImageIcon(ImageIO.read(new File("src//image//code.jpg")));
						label.setIcon(icon);
					}
				}

				else {
					JOptionPane.showMessageDialog(null, "请选择登录身份");
				}
			}
			catch (Exception er) {
				// TODO: handle exception
				er.printStackTrace();
			}
		}

		//注册入口
		else if(e.getActionCommand().equals("注册")){

			Register register=new Register();
			register.setVisible(true);

		}
		//找回密码
		else if(e.getActionCommand().equals("找回密码")){
			getBackPassword help=new getBackPassword();
			help.setVisible(true);
		}
		//记住密码
		if(rememberPassword.isSelected()&&flag==1){
			if (new Judgeidexit().judgename(txtName.getText().trim()))//数据库里没有数据就存储
			{
				remember.setRbname(txtName.getText().trim());
				String password=new String(passwordField.getPassword());
				remember.setRbpassword(password);
				passwordOp.Addremember(remember);
			}
			else{//有就不操作

			}
		}
		if(login.isSelected())//自动登录，执行登录那一套操作
		{
			try{
				if(rbadmin.isSelected()){
					String pwd=new String(passwordField.getPassword());
					if(txtName.getText().equals("admin") && pwd.equals("123456")&& txtVC.getText().equals(rand)) {


						this.setVisible(false);
						lgrole="管理员";
						lgname="admin";

						MainFrame mf=new MainFrame(lgrole,lgname);
						mf.setVisible(true);
						flag=1;
					}else{
						JOptionPane.showMessageDialog(null, "用户名，验证码或密码错误！");
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
						JOptionPane.showMessageDialog(null, "老师登录成功了");
						//this.setVisible(false);
						this.setVisible(false);
						flag=1;
						lgrole="老师";
						lgname=txtName.getText();
						MainFrame mf=new MainFrame(lgrole,lgname);
						mf.setVisible(true);
					}
					else{
						JOptionPane.showMessageDialog(null, "用户名，验证码或密码错误！");
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
						JOptionPane.showMessageDialog(null, "同学登录成功了");
						//this.setVisible(false);
						this.setVisible(false);
						flag=1;
						lgrole="同学";
						lgname=txtName.getText();
						MainFrame mf=new MainFrame(lgrole,lgname);
						mf.setVisible(true);
					}else{
						JOptionPane.showMessageDialog(null, "用户名，验证码或密码错误！");
						txtName.setText("");
						passwordField.setText("");
						txtVC.setText("");
						code.Code();
						icon = new ImageIcon(ImageIO.read(new File("src//image//code.jpg")));
						label.setIcon(icon);
					}
				}


				else {
					JOptionPane.showMessageDialog(null, "请选择登录身份");
				}
			}
			catch (Exception er) {
				// TODO: handle exception
				er.printStackTrace();
			}
		}
	}
}
