package com.ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import egtool.MajorTableModel;
import egtool.TableModeByRequired;

public class Selectrecord extends JFrame implements ActionListener {
    //�װ��ѯ����
    private JLabel lblSelectText;
    private JTextField txtSelectText;
    private JButton btnselect;
    private JScrollPane scrollPane;
    private JTable table;
    //��ǩ
    private  JLabel lbRecordID;//�ɼ����
    private  JLabel lbStuID;//ѧ�����
    private  JLabel lbStuName;//ѧ������
    private  JLabel lbCourseID;//�γ̱��
    private  JLabel LbCourseName;//�γ�����
    private  JLabel getLbRecord;//ѧ���ɼ�
    //�ı���
    private JTextField txtRecordId;//�ɼ����
    private JTextField txtStuId;//ѧ�����
    private JTextField txtStuName;//ѧ������
    private JTextField txtCourseId;//�γ̱��
    private JTextField txtCourseName;//�γ�����
    private JTextField txtRecord;//ѧ���ɼ�

    TableModeByRequired tableMajorTableModel;

    public static void main(String[] args) throws SQLException {
        // TODO Auto-generated method stub
        new Selectrecord().setVisible(true);
    }

    public JTable getDataByRequirement(String requirement) throws SQLException {
//        dModel = new TableModeByRequired(requirement);
//        table = new JTable(dModel);
//        return table;
        tableMajorTableModel=new TableModeByRequired(requirement);
        table = new JTable(tableMajorTableModel);
        table.setPreferredScrollableViewportSize(new Dimension(780,200));//���ô˱���ͼ��ѡ��С
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  //��ѡ
        //table.setRowSorter(new TableRowSorter(majorTableModel));//���ÿɽ���������
        table.addMouseListener(new MouseAdapter(){    //����¼�
            public void mouseClicked(MouseEvent e){
                int selectedRow = table.getSelectedRow(); //���ѡ��������
                Object oRecordId = tableMajorTableModel.getValueAt(selectedRow, 0);
                txtRecordId.setText((String)oRecordId);
                Object oStuId= tableMajorTableModel.getValueAt(selectedRow, 1);
                txtStuId.setText((String)oStuId);
                Object oMaster = tableMajorTableModel.getValueAt(selectedRow, 2);
                txtStuName.setText((String)oMaster);
                Object oMasterPhone=tableMajorTableModel.getValueAt(selectedRow, 3);
                txtCourseId.setText((String)oMasterPhone);
                Object oCourseName=tableMajorTableModel.getValueAt(selectedRow, 4);
                txtCourseName.setText((String)oCourseName);
                Object oRecord=tableMajorTableModel.getValueAt(selectedRow, 5);
                txtRecord.setText((String)oRecord);
            }
        });
        return table;
    }

    public Selectrecord() throws SQLException {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 490, 550);
        ImageEg background=new ImageEg("image1.jpg");
        background.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(background);
        background.setLayout(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);//�Զ������������

        setTitle("�ɼ���ѯ");

        lblSelectText = new JLabel("�������ѯͬѧ������");
        lblSelectText.setBounds(20, 50, 150, 30);
        background.add(lblSelectText);

        txtSelectText = new JTextField();
        txtSelectText.setToolTipText("����ȫ��������������ģ����ѯ��");
        txtSelectText.setColumns(30);
        txtSelectText.setBounds(180, 50, 200, 30);
        background.add(txtSelectText);

        btnselect = new JButton("��ѯ");
        btnselect.setBounds(390, 50, 80, 30);
        btnselect.addActionListener(this);
        background.add(btnselect);


        table = getDataByRequirement(txtSelectText.getText().trim());
        scrollPane = new JScrollPane(table);//��ӹ������
        scrollPane.setBounds(20, 85, 450, 207);
        background.add(scrollPane);


        lbRecordID= new JLabel("�ɼ����");
        lbRecordID.setBounds(5,300,100,20);
        lbRecordID.setFont(new Font("����",Font.PLAIN,15));
        background.add(lbRecordID);

        txtRecordId = new JTextField();
        txtRecordId.setBounds(90, 300, 100, 20);
        txtRecordId.setEditable(false);
        background.add(txtRecordId);

        lbStuID= new JLabel("ѧ�����");
        lbStuID.setBounds(5,330,100,20);
        lbStuID.setFont(new Font("����",Font.PLAIN,15));
        background.add(lbStuID);

        txtStuId = new JTextField();
        txtStuId.setBounds(90, 330, 100, 20);
        txtStuId.setEditable(false);
        background.add(txtStuId);

        lbStuName= new JLabel("ѧ������");
        lbStuName.setBounds(5,360,100,20);
        lbStuName.setFont(new Font("����",Font.PLAIN,15));
        background.add(lbStuName);

        txtStuName = new JTextField();
        txtStuName.setBounds(90, 360, 100, 20);
        txtStuName.setEditable(false);
        background.add(txtStuName);

        lbCourseID= new JLabel("�γ̱��");
        lbCourseID.setBounds(250,300,100,20);
        lbCourseID.setFont(new Font("����",Font.PLAIN,15));
        background.add(lbCourseID);

        txtCourseId = new JTextField();
        txtCourseId.setBounds(340, 300, 100, 20);
        txtCourseId.setEditable(false);
        background.add(txtCourseId);

        LbCourseName= new JLabel("�γ�����");
        LbCourseName.setBounds(250,330,100,20);
        LbCourseName.setFont(new Font("����",Font.PLAIN,15));
        background.add(LbCourseName);

        txtCourseName = new JTextField();
        txtCourseName.setBounds(340,330,100,20);
        txtCourseName.setEditable(false);
        background.add(txtCourseName);

        getLbRecord= new JLabel("ѧ���ɼ�");
        getLbRecord.setBounds(250,360,100,20);
        getLbRecord.setFont(new Font("����",Font.PLAIN,15));
        background.add(getLbRecord);

        txtRecord = new JTextField();
        txtRecord.setBounds(340, 360, 100, 20);
        background.add(txtRecord);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("��ѯ")) {
            try {
                tableMajorTableModel.setRowCount(0);
                tableMajorTableModel = new TableModeByRequired(txtSelectText.getText().trim());
                table.setModel(tableMajorTableModel);
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
    }
}