package com.ui.User;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class UserLookOrder extends JFrame implements ActionListener {

    private JTextField txtTableNumner;
    private JTextField txtfoodName;
    private JTextField txtOrderprice;
    private JTextField txtOrderState;

    private JPanel contentPane;
    private JTable table;
    JScrollPane jScrollPane;

    DefaultTableModel defaultTableModel;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UserLookOrder frame = new UserLookOrder();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public JTable table() {
        // TODO Auto-generated method stub
        String[] head={
                "����","��Ʒ","�������","����״̬"
        };
        Object[][] datas={
                {"001","˱ָԭζ��","23","���"},{"002","����","23","���"}
        };
        defaultTableModel=new DefaultTableModel(datas,head);
        table = new JTable(defaultTableModel);
        table.setPreferredScrollableViewportSize(new Dimension(780,200));//���ô˱���ͼ��ѡ��С
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  //��ѡ
        //table.setRowSorter(new TableRowSorter(majorTableModel));//���ÿɽ���������
        table.addMouseListener(new MouseAdapter(){    //����¼�
            public void mouseClicked(MouseEvent e){
                int selectedRow = table.getSelectedRow(); //���ѡ����

                Object tableNumber= defaultTableModel.getValueAt(selectedRow, 0);
                txtTableNumner.setText((String)tableNumber);
                Object foodName = defaultTableModel.getValueAt(selectedRow, 1);
                txtfoodName.setText((String)foodName);
                Object orderPrice=defaultTableModel.getValueAt(selectedRow, 2);
                txtOrderprice.setText((String)orderPrice);
                Object orderState=defaultTableModel.getValueAt(selectedRow, 3);
                txtOrderState.setText((String)orderState);
            }
        });
        return table;

    }

    /**
     * Create the frame.
     */
    public UserLookOrder() {
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setBounds(600, 600, 885, 800);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        setTitle("�鿴����");

        //table=getAllMajor();//���ɱ��
        contentPane.setLayout(null);
        contentPane.setLayout(null);

        table=table();
        jScrollPane=new JScrollPane(table);
        jScrollPane.setBounds(5, 65, 650, 407);
        contentPane.add(jScrollPane);

        JLabel lblOrderNumner=new JLabel("��  �ţ�");
        lblOrderNumner.setBounds(665, 85, 75, 30);
        contentPane.add(lblOrderNumner);

        txtTableNumner=new JTextField();
        txtTableNumner.setBounds(725, 85, 85, 30);
        contentPane.add(txtTableNumner);

        JLabel lblInformation=new JLabel("��  Ʒ��");
        lblInformation.setBounds(665, 125, 75, 30);
        contentPane.add(lblInformation);

        txtfoodName=new JTextField();
        txtfoodName.setBounds(725, 125, 85, 30);
        contentPane.add(txtfoodName);

        JLabel lblOrderCost=new JLabel("������");
        lblOrderCost.setBounds(665, 165, 75, 30);
        contentPane.add(lblOrderCost);

        txtOrderprice=new JTextField();
        txtOrderprice.setBounds(725, 165, 85, 30);
        contentPane.add(txtOrderprice);


        JLabel lblOrderState=new JLabel("����״̬��");
        lblOrderState.setBounds(665, 205, 75, 30);
        contentPane.add(lblOrderState);

        txtOrderState=new JTextField();
        txtOrderState.setBounds(725, 205, 85, 30);
        contentPane.add(txtOrderState);

        JButton btnchargeback=new JButton("�˵�");
        btnchargeback.setBounds(665, 245, 75, 30);
        btnchargeback.addActionListener(this);
        contentPane.add(btnchargeback);


    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getActionCommand().equals("�˵�")){
            System.out.println("�˵�");
        }
    }

}
