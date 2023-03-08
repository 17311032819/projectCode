package egtool;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.ui.CourseAdd;
import com.ui.ImageEg;

public class Mf extends JFrame implements ActionListener {
//	private JPanel contentPane;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Mf();

	}
	public Mf(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置窗体关闭时做什么
		setBounds(100, 100, 550, 400);//设置窗体出现的坐标及宽与高
		setTitle("示例主操作界面");//设置标题
		ImageEg background=new ImageEg("image1.jpg");
		background.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(background);
		background.setLayout(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);//自动跳至界面最大化


		JMenuBar mJMenuBar=new JMenuBar();
		setJMenuBar(mJMenuBar);
		
		JMenu jmfile=new JMenu("File");
		mJMenuBar.add(jmfile);
		jmfile.setMnemonic('F');//设置热键alt+'F'可以打开这个菜单
		
		JMenuItem jMenuItemnew=new JMenuItem("New");
		jMenuItemnew.addActionListener(this);
		jmfile.add(jMenuItemnew);	
	}
	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand().equals("New")){
			CourseAdd cAdd=new CourseAdd();
			cAdd.setVisible(true);
		}		
	}

}
