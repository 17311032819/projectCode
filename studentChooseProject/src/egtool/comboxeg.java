package egtool;

import com.ui.ImageEg;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * 
 * @author liwei
 * @date 2020��3��29�� ����4:06:33
 * @disdescription ������
 *
 */
public class comboxeg extends JFrame {
	private JTextField txtname;//��ȡ�����б���ѡ��ֵ
//	private JPanel contentPane;//���
	private JComboBox cobpower;//�����б��
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new comboxeg().setVisible(true);

	}
	
	public comboxeg(){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//���ô���ر�ʱ��ʲô
		setBounds(100, 100, 450, 300);//���ô�����ֵ����꼰�����
		setTitle("�����б��ʾ��");//���ñ���
		ImageEg background=new ImageEg("image1.jpg");
		background.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(background);
		background.setLayout(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);//�Զ������������

		
		txtname=new JTextField();
		txtname.setBounds(132, 50, 207, 21);
		background.add(txtname);
		
		cobpower = new JComboBox();	
		String[] listData = new String[]{"C����", "C#", "java", "python"};
		DefaultComboBoxModel dfc=new DefaultComboBoxModel(listData);
		cobpower.setModel(dfc);
		//cobpower.setModel(new DefaultComboBoxModel(new String[] {"1", "2"}));
		cobpower.setBounds(132, 100, 207, 21);
		cobpower.addItemListener(new ItemListener(){
			@Override	
			public void itemStateChanged(ItemEvent e ){
				// TODO Auto-generated method stub
				if(e.getStateChange()==ItemEvent.SELECTED){
					txtname.setText(cobpower.getSelectedItem().toString());
				}
		    }
		});
		background.add(cobpower);
	}

}
