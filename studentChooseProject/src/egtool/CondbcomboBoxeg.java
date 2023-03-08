package egtool;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.db.connectiontomysql;
import com.ui.ImageEg;

public class CondbcomboBoxeg extends JFrame{
	private JTextField txtname;
//	private JPanel contentPane;
	private JComboBox cobpower;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CondbcomboBoxeg().setVisible(true);
	}
	public CondbcomboBoxeg(){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//���ô���ر�ʱ��ʲô
		setBounds(100, 100, 450, 300);//���ô�����ֵ����꼰�����
		setTitle("�û���¼123");//���ñ���
		ImageEg background=new ImageEg("image1.jpg");
		background.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(background);
		background.setLayout(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);//�Զ������������

		JLabel lblcobs=new JLabel();
		lblcobs.setBounds(40, 50, 110, 21);
		lblcobs.setText("ѡ��Ŀγ�����:");
		background.add(lblcobs);
		
		txtname=new JTextField();
		txtname.setBounds(132, 50, 207, 21);
		background.add(txtname);
		
		JLabel lblcob=new JLabel();
		lblcob.setBounds(40, 120, 110, 21);
		lblcob.setText("��ѡ��γ�����:");
		background.add(lblcob);
		
		cobpower = new JComboBox();
		cobpower.setBounds(132, 120, 207, 21);
		try{
			Connection con=new connectiontomysql().getConnection();
			PreparedStatement pstmt=con.prepareStatement("select * from tb_course");
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				String usern=rs.getString(2);
				cobpower.addItem(usern);				
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		cobpower.addItemListener(new ItemListener() {		
			@Override
			public void itemStateChanged(ItemEvent e ) {
				// TODO Auto-generated method stub
				if(e.getStateChange()==ItemEvent.SELECTED){
					txtname.setText(cobpower.getSelectedItem().toString());
					/*if(cobpower.getSelectedItem().toString().equals("2")){
						
					}*/
				}
			}
		});

		background.add(cobpower);
	}

}
