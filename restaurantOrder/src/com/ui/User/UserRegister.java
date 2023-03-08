package com.ui.User;

import aegtool.Judgeidexit;
import com.Bean.Tb_user;
import com.dao.UserOp;
import com.email.SendCode;
import aegtool.ImageEg;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import static com.email.CheckCode.getCheckCode;

public class UserRegister extends JFrame implements ActionListener  {
    private JLabel lblUserName;
    private JLabel lblUserPWD;
    private JTextField txtName;
    private JPasswordField passwordField;
    private JTextField txtUserEmail;
    private JTextField txtCode;
    private JButton btnRegister;
    private JTextField location1;
    private JTextField location2;
    private JTextField location3;
    Tb_user tb_user=new Tb_user();
    UserOp userOp=new UserOp();
    String code=getCheckCode();
    private JTextField txtPhone;
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        UserRegister stuLg=new UserRegister();
        stuLg.setVisible(true);
    }
    //���캯��
    public UserRegister(){
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 550, 450);
        ImageEg background=new ImageEg("image1.jpg");
        background.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(background);
        background.setLayout(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);//�Զ������������
        setTitle("���ֲ�����¼");

        setTitle("ע��");//���ñ���

        lblUserName = new JLabel("�û�����");
        //lblUserName.setFont(new Font("����", Font.PLAIN, 15));//��������
        //Font.PLANIN ��ͨ��ʽ����
        //Font.BOLD   ������ʽ����
        //Font.ITALIC б����ʽ����
        lblUserName.setBounds(73, 31, 82, 36);
        background.add(lblUserName);

        lblUserPWD = new JLabel("�û�����");
        //lblUserPWD.setFont(new Font("����", Font.PLAIN, 15));
        lblUserPWD.setBounds(73, 90, 82, 36);
        background.add(lblUserPWD);

        JLabel lblUserEmail = new JLabel("�û�����");

        lblUserEmail.setBounds(73, 150, 82, 36);
        background.add(lblUserEmail);

        JLabel lblPhone=new JLabel("�û��绰");
        lblPhone.setBounds(73,210,82,36);
        background.add(lblPhone);

        JLabel lbllocation1=new JLabel("�û���ַ1");
        lbllocation1.setBounds(73,270,82,36);
        background.add(lbllocation1);


        JLabel lbllocation2=new JLabel("�û���ַ2");
        lbllocation2.setBounds(73,330,82,36);
        background.add(lbllocation2);

        JLabel lbllocation3=new JLabel("�û���ַ3");
        lbllocation3.setBounds(73,390,82,36);
        background.add(lbllocation3);

        txtName = new JTextField();//���ɶ���
        //txtName.setFont(new Font("����", Font.PLAIN, 15));
        txtName.setBounds(170, 31, 171, 36);
        background.add(txtName);
        txtName.setColumns(10);//�����ı�����һ�е��ַ���

        passwordField = new JPasswordField();
        passwordField.setBounds(170, 90, 171, 36);
        background.add(passwordField);

        txtUserEmail = new JTextField();
        txtUserEmail.setBounds(170, 150, 171, 36);
        background.add(txtUserEmail);

        JButton btnCode=new JButton("������֤��");
        btnCode.setBounds(345,150,100,30);
        btnCode.addActionListener(this);
        background.add(btnCode);

        JLabel lblCode=new JLabel("��֤��");
        lblCode.setBounds(73, 450, 82, 36);
        background.add(lblCode);

        txtPhone=new JTextField();
        txtPhone.setBounds(170,210,171,36);
        background.add(txtPhone);

        location1=new JTextField("����");
        location1.setBounds(170,270,171,36);
        background.add(location1);

        location2=new JTextField("�ɲ���");
        location2.setBounds(170,330,171,36);
        background.add(location2);

        location3=new JTextField("�ɲ���");
        location3.setBounds(170,390,171,36);
        background.add(location3);




        txtCode=new JTextField();
        txtCode.setBounds(170,450,171,36);
        background.add(txtCode);

        btnRegister = new JButton("ע��");
        btnRegister.addActionListener(this);
        btnRegister.setBounds(175, 506, 65, 30);
        background.add(btnRegister);
    }
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

        if (e.getActionCommand().equals("������֤��")){
            if (new Judgeidexit().judgeUserEmail(txtUserEmail.getText().trim())){

                String regex = "[1-9][0-9]{4,9}\\@[q][q]\\.[c][o][m]";
                if(txtUserEmail.getText().trim().matches(regex)){//�ж��Ƿ�Ϊqq����
                    try {
                        code= new SendCode().sendCode(txtUserEmail.getText());
                    } catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                    }
                }else {
                    JOptionPane.showMessageDialog(null,"������ȷ�����ʽ");
                    txtUserEmail.setText("");
                }
            }
            else{
                JOptionPane.showMessageDialog(null,"�������Ѿ�ע�����");
                txtUserEmail.setText("");
            }
            }
        if (e.getActionCommand().equals("ע��")){
            if (txtName.getText().trim().equals("")){
                JOptionPane.showMessageDialog(null,"�û�������Ϊ��");
            }
           else if (txtUserEmail.getText().trim().equals("")){
                JOptionPane.showMessageDialog(null,"���䲻��Ϊ��");
            }
            else if (passwordField.getPassword().equals("")){
                JOptionPane.showMessageDialog(null,"���벻��Ϊ��");
            }
            else if (code.equals(txtCode.getText().trim())){

                    tb_user.setUserName(txtName.getText().trim());
                    String password=new String(passwordField.getPassword());
                    tb_user.setUserPassword(password);
                    tb_user.setUserEmail(txtUserEmail.getText().trim());
                    tb_user.setPhone(txtPhone.getText().trim());
                tb_user.setLocation1(location1.getText().trim());
                tb_user.setLocation2(location2.getText().trim());
                tb_user.setLocation3(location3.getText().trim());

                    userOp.adduser(tb_user);
                    JOptionPane.showMessageDialog(null,"ע��ɹ�");
            }
            else {
                JOptionPane.showMessageDialog(null,"��֤�����");
                code=getCheckCode();
            }
        }
    }

}







