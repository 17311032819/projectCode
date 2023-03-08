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
 * @date 2020年3月29日 下午4:06:33
 * @disdescription 类描述
 *
 */
public class comboxeg extends JFrame {
	private JTextField txtname;//获取下拉列表框的选项值
//	private JPanel contentPane;//面板
	private JComboBox cobpower;//下拉列表框
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new comboxeg().setVisible(true);

	}
	
	public comboxeg(){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//设置窗体关闭时做什么
		setBounds(100, 100, 450, 300);//设置窗体出现的坐标及宽与高
		setTitle("下拉列表框示例");//设置标题
		ImageEg background=new ImageEg("image1.jpg");
		background.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(background);
		background.setLayout(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);//自动跳至界面最大化

		
		txtname=new JTextField();
		txtname.setBounds(132, 50, 207, 21);
		background.add(txtname);
		
		cobpower = new JComboBox();	
		String[] listData = new String[]{"C语言", "C#", "java", "python"};
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
