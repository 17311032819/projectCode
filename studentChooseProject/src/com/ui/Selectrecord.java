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
    //底板查询功能
    private JLabel lblSelectText;
    private JTextField txtSelectText;
    private JButton btnselect;
    private JScrollPane scrollPane;
    private JTable table;
    //标签
    private  JLabel lbRecordID;//成绩编号
    private  JLabel lbStuID;//学生编号
    private  JLabel lbStuName;//学生名字
    private  JLabel lbCourseID;//课程编号
    private  JLabel LbCourseName;//课程名字
    private  JLabel getLbRecord;//学生成绩
    //文本框
    private JTextField txtRecordId;//成绩编号
    private JTextField txtStuId;//学生编号
    private JTextField txtStuName;//学生名字
    private JTextField txtCourseId;//课程编号
    private JTextField txtCourseName;//课程名字
    private JTextField txtRecord;//学生成绩

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
        table.setPreferredScrollableViewportSize(new Dimension(780,200));//设置此表视图首选大小
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  //单选
        //table.setRowSorter(new TableRowSorter(majorTableModel));//设置可进行行排序
        table.addMouseListener(new MouseAdapter(){    //鼠标事件
            public void mouseClicked(MouseEvent e){
                int selectedRow = table.getSelectedRow(); //获得选中行索引
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
        setExtendedState(JFrame.MAXIMIZED_BOTH);//自动跳至界面最大化

        setTitle("成绩查询");

        lblSelectText = new JLabel("请输入查询同学姓名：");
        lblSelectText.setBounds(20, 50, 150, 30);
        background.add(lblSelectText);

        txtSelectText = new JTextField();
        txtSelectText.setToolTipText("不必全输入姓名，可以模糊查询！");
        txtSelectText.setColumns(30);
        txtSelectText.setBounds(180, 50, 200, 30);
        background.add(txtSelectText);

        btnselect = new JButton("查询");
        btnselect.setBounds(390, 50, 80, 30);
        btnselect.addActionListener(this);
        background.add(btnselect);


        table = getDataByRequirement(txtSelectText.getText().trim());
        scrollPane = new JScrollPane(table);//添加滚动面板
        scrollPane.setBounds(20, 85, 450, 207);
        background.add(scrollPane);


        lbRecordID= new JLabel("成绩编号");
        lbRecordID.setBounds(5,300,100,20);
        lbRecordID.setFont(new Font("楷体",Font.PLAIN,15));
        background.add(lbRecordID);

        txtRecordId = new JTextField();
        txtRecordId.setBounds(90, 300, 100, 20);
        txtRecordId.setEditable(false);
        background.add(txtRecordId);

        lbStuID= new JLabel("学生编号");
        lbStuID.setBounds(5,330,100,20);
        lbStuID.setFont(new Font("楷体",Font.PLAIN,15));
        background.add(lbStuID);

        txtStuId = new JTextField();
        txtStuId.setBounds(90, 330, 100, 20);
        txtStuId.setEditable(false);
        background.add(txtStuId);

        lbStuName= new JLabel("学生姓名");
        lbStuName.setBounds(5,360,100,20);
        lbStuName.setFont(new Font("楷体",Font.PLAIN,15));
        background.add(lbStuName);

        txtStuName = new JTextField();
        txtStuName.setBounds(90, 360, 100, 20);
        txtStuName.setEditable(false);
        background.add(txtStuName);

        lbCourseID= new JLabel("课程编号");
        lbCourseID.setBounds(250,300,100,20);
        lbCourseID.setFont(new Font("楷体",Font.PLAIN,15));
        background.add(lbCourseID);

        txtCourseId = new JTextField();
        txtCourseId.setBounds(340, 300, 100, 20);
        txtCourseId.setEditable(false);
        background.add(txtCourseId);

        LbCourseName= new JLabel("课程名称");
        LbCourseName.setBounds(250,330,100,20);
        LbCourseName.setFont(new Font("楷体",Font.PLAIN,15));
        background.add(LbCourseName);

        txtCourseName = new JTextField();
        txtCourseName.setBounds(340,330,100,20);
        txtCourseName.setEditable(false);
        background.add(txtCourseName);

        getLbRecord= new JLabel("学生成绩");
        getLbRecord.setBounds(250,360,100,20);
        getLbRecord.setFont(new Font("楷体",Font.PLAIN,15));
        background.add(getLbRecord);

        txtRecord = new JTextField();
        txtRecord.setBounds(340, 360, 100, 20);
        background.add(txtRecord);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("查询")) {
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