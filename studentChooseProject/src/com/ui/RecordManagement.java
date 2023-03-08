package com.ui;

import com.Bean.Tb_record;
import com.dao.RecordOp;
import egtool.TableRecordModify;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RecordManagement extends JFrame implements ActionListener {//修改成绩记录，只有在添加记录后，此处才会显示


    private JLabel lblRecordId1;
    private JLabel lblStuId1;
    private JLabel lblStuName1;
    private JLabel lblCourseId1;
    private JLabel lblCourseName1;
    private JLabel lblRecord1;

    private JTextField txtRecordId;
    private JTextField txtStuId;
    private JTextField txtStuName;
    private JTextField txtCourseId;
    private JTextField txtCourseName;
    private JTextField txtRecord;

    private JButton btnModify;
    private JButton btnCancle;

    TableRecordModify tableRecordModify;
    JTable table;
    RecordOp recordOp=new RecordOp();

    public static void main(String[] args) {
        RecordManagement recordManagement=new RecordManagement();
        recordManagement.setVisible(true);
    }

    public RecordManagement(){
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 490, 430);
        ImageEg background=new ImageEg("image1.jpg");
        background.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(background);
        background.setLayout(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);//自动跳至界面最大化

        setTitle("管理成绩窗口");

        table=getAllRecord();//生成表格

        JScrollPane s = new JScrollPane(table);//添加滚动面板
        s.setBounds(5, 5, 450, 210);
        background.add(s);

        lblRecordId1=new JLabel("成绩编号：");
        lblRecordId1.setBounds(5, 225, 75, 30);
        background.add(lblRecordId1);

        txtRecordId=new JTextField();
        txtRecordId.setBounds(80, 225, 145, 30);
        txtRecordId.setEditable(false);
        background.add(txtRecordId);

        lblStuId1=new JLabel("学生编号：");
        lblStuId1.setBounds(235, 225, 75, 30);
        background.add(lblStuId1);

        txtStuId=new JTextField();
        txtStuId.setBounds(310, 225, 145, 30);
        txtStuId.setEditable(false);
        background.add(txtStuId);

        lblStuName1=new JLabel("学生姓名：");
        lblStuName1.setBounds(5, 265, 75, 30);
        background.add(lblStuName1);

        txtStuName=new JTextField();
        txtStuName.setBounds(80, 265, 145, 30);
        txtStuName.setEditable(false);
        background.add(txtStuName);

        lblCourseId1=new JLabel("课程编号：");
        lblCourseId1.setBounds(235, 265, 75, 30);
        background.add(lblCourseId1);

        txtCourseId=new JTextField();
        txtCourseId.setBounds(310, 265, 145, 30);
        txtCourseId.setEditable(false);
        background.add(txtCourseId);

        lblCourseName1=new JLabel("课程名称：");
        lblCourseName1.setBounds(5, 305, 75, 30);
        background.add(lblCourseName1);

        txtCourseName=new JTextField();
        txtCourseName.setBounds(80, 305, 145, 30);
        txtCourseName.setEditable(false);
        background.add(txtCourseName);

        lblRecord1=new JLabel("课程成绩：");
        lblRecord1.setBounds(235, 305, 75, 30);
        background.add(lblRecord1);

        txtRecord=new JTextField();
        txtRecord.setBounds(310, 305, 145, 30);
        background.add(txtRecord);

        btnCancle=new JButton("取消");
        btnCancle.setBounds(275, 345, 70, 35);
        btnCancle.addActionListener(this);
        background.add(btnCancle);

        btnModify=new JButton("修改");
        btnModify.setBounds(385, 345, 70, 35);
        btnModify.addActionListener(this);
        background.add(btnModify);
        setVisible(true);

    }
    public JTable getAllRecord(){
        String choice ="0";
        tableRecordModify=new TableRecordModify();
        table = new JTable(tableRecordModify);
        table.setPreferredScrollableViewportSize(new Dimension(780,200));//设置此表视图首选大小
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  //单选
        //table.setRowSorter(new TableRowSorter(majorTableModel));//设置可进行行排序
        table.addMouseListener(new MouseAdapter(){    //鼠标事件
            public void mouseClicked(MouseEvent e){
                int selectedRow = table.getSelectedRow(); //获得选中行索引
                txtRecordId.setText((String)tableRecordModify.getValueAt(selectedRow, 0));
                Object oStuId = tableRecordModify.getValueAt(selectedRow, 1);
                txtStuId.setText((String)oStuId);
                Object oStuName = tableRecordModify.getValueAt(selectedRow, 2);
                txtStuName.setText((String)oStuName);
                Object oCourseId=tableRecordModify.getValueAt(selectedRow, 3);
                txtCourseId.setText((String)oCourseId);
                Object oCourseName=tableRecordModify.getValueAt(selectedRow, 4);
                txtCourseName.setText((String)oCourseName);
                Object orecod=tableRecordModify.getValueAt(selectedRow,5);
                txtRecord.setText((String) orecod);
            }
        });
        return table;
    }
    public void actionPerformed(ActionEvent e){
        String choice="0";
        if(e.getActionCommand().equals("修改")){
            Tb_record record=new Tb_record();
            record.setId(Integer.parseInt(txtRecordId.getText().trim()));
            record.setCourseId(txtCourseId.getText());
            record.setStuId(txtStuId.getText());
            if(txtRecord.getText().equals("")){
                JOptionPane.showMessageDialog(null, "请为选课内容添加成绩！");
            }else{
                record.setRecord(Integer.parseInt(txtRecord.getText().trim()));
            }
            if(recordOp.modifyRecord(record)){

                JOptionPane.showMessageDialog(null, "选课成绩修改成功！");
                tableRecordModify.setRowCount(0);
                tableRecordModify=new TableRecordModify();
                table.setModel(tableRecordModify);
                txtRecordId.setText("");
                txtStuId.setText("");
                txtStuName.setText("");
                txtCourseId.setText("");
                txtCourseName.setText("");
                txtRecord.setText("");
                //此处需要重新刷新表格，输入修改后的信息
            }
        }
    }
}
