package com.Test;

import aegtool.ImageEg;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class AddTableAmount extends JFrame implements ActionListener  {
    private JLabel Previoustable;
    private JLabel Addtable;
    private JTextField txtPrevioustable;
    private JTextField textAddtable;


    public String lgrole;//登录者身份：管理员、教师，学生
    public String lgname;//登录者ID



    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ImageEg ba=new ImageEg("j");
        AddTableAmount stuLg=new AddTableAmount(ba);
        stuLg.setVisible(true);


    }
    //构造函数
    public AddTableAmount(ImageEg background){
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(0, 0, 1050, 1450);
        background.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(background);
        background.setLayout(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);//自动跳至界面最大化
        setTitle("增加菜品");


        Previoustable = new JLabel("先前桌子：");
        //lblUserName.setFont(new Font("宋体", Font.PLAIN, 15));//设置字体
        //Font.PLANIN 普通样式常量
        //Font.BOLD   粗体样式常量
        //Font.ITALIC 斜体样式常量
        Previoustable.setBounds(573, 251, 82, 36);
        background.add(Previoustable);

        Addtable = new JLabel("增加桌子 ：");
        //lblUserPWD.setFont(new Font("宋体", Font.PLAIN, 15));
        Addtable.setBounds(573, 310, 182, 36);
        background.add(Addtable);



        txtPrevioustable = new JTextField();//生成对象
        //txtName.setFont(new Font("宋体", Font.PLAIN, 15));
        txtPrevioustable.setBounds(670, 251, 171, 36);
        background.add(txtPrevioustable);
        txtPrevioustable.setColumns(10);//设置文本框里一行的字符数

        textAddtable = new JTextField();
        textAddtable.setBounds(670, 310, 171, 36);
        background.add(textAddtable);

        JButton btnNewButton = new JButton("确定");
        btnNewButton.addActionListener(this);
        btnNewButton.setBounds(675, 400, 65, 30);
        background.add(btnNewButton);
        btnNewButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub

            }
        });
    }
    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub

    }





}








