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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���ô���ر�ʱ��ʲô
		setBounds(100, 100, 550, 400);//���ô�����ֵ����꼰�����
		setTitle("ʾ������������");//���ñ���
		ImageEg background=new ImageEg("image1.jpg");
		background.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(background);
		background.setLayout(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);//�Զ������������


		JMenuBar mJMenuBar=new JMenuBar();
		setJMenuBar(mJMenuBar);
		
		JMenu jmfile=new JMenu("File");
		mJMenuBar.add(jmfile);
		jmfile.setMnemonic('F');//�����ȼ�alt+'F'���Դ�����˵�
		
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
