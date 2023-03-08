package com.ui.Shop;
import com.Bean.Tb_food;
import com.dao.FoodOp;
import aegtool.ImageEg;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class AddFood extends JFrame implements ActionListener {

    private JLabel lblFoodName;
    private JLabel lblCostPrice;
    private JLabel lblIntroduce;
    private JLabel lblImageLink;
    private JLabel lblFoodType;
    private JLabel lblImage;

    private JTextField txtFoodName;
    private JTextField txtCostPrice;
    private JTextArea txtIntroduce;
    private JTextField txtFoodType;


    private JButton btnadd;
    private JButton btnChoose;
    private JComboBox comboBox;

    String picturePath="";
    Tb_food tb_food=new Tb_food();
    FoodOp foodOp=new FoodOp();



    public static void main(String[] args) {
        ImageEg background=new ImageEg("image1.jpg");
        new AddFood(background).setVisible(true);
    }
    public AddFood(ImageEg background){
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(0, 0, 1050, 1450);
        background.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(background);
        background.setLayout(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);//自动跳至界面最大化
        setTitle("增加菜品");

        lblFoodName=new JLabel("食品名称");
        lblFoodName.setBounds(700,100,100,40);
        lblFoodName.setFont(new Font("微软雅黑",Font.BOLD,20));
        background.add(lblFoodName);

        txtFoodName=new JTextField();
        txtFoodName.setBounds(800,100,400,40);
        txtFoodName.setFont(new Font("微软雅黑",Font.BOLD,20));
        background.add(txtFoodName);

        lblCostPrice=new JLabel("食品价格");
        lblCostPrice.setBounds(700,240,100,40);
        lblCostPrice.setFont(new Font("微软雅黑",Font.BOLD,20));
        background.add(lblCostPrice);


        txtCostPrice=new JTextField();
        txtCostPrice.setBounds(800,240,400,40);
        txtCostPrice.setFont(new Font("微软雅黑",Font.BOLD,20));
        background.add(txtCostPrice);

        lblIntroduce=new JLabel("食品介绍");
        lblIntroduce.setBounds(700,400,100,100);
        lblIntroduce.setFont(new Font("微软雅黑",Font.BOLD,20));
        background.add(lblIntroduce);

        txtIntroduce=new JTextArea();
        txtIntroduce.setBorder(new LineBorder(new Color(127,157,185),1,false));
        txtIntroduce.setBounds(800,400,400,150);
        txtIntroduce.setFont(new Font("微软雅黑",Font.BOLD,20));
        background.add(txtIntroduce);

        lblImageLink=new JLabel("食品图片");
        lblImageLink.setBounds(700,600,100,50);
        lblImageLink.setFont(new Font("微软雅黑",Font.BOLD,20));
        background.add(lblImageLink);

        lblImage=new JLabel();
        lblImage.setBounds(800,600,300,300);
        background.add(lblImage);

        btnChoose=new JButton("请选择");
        btnChoose.setBounds(1100,600,100,40);
        btnChoose.addActionListener(this);
        btnChoose.setFont(new Font("微软雅黑",Font.BOLD,20));
        background.add(btnChoose);

        lblFoodType=new JLabel("食物类型");
        lblFoodType.setBounds(700,1000,100,40);
        lblFoodType.setFont(new Font("微软雅黑",Font.BOLD,20));
        background.add(lblFoodType);

        txtFoodType=new JTextField();
        txtFoodType.setBorder(new LineBorder(new Color(127,157,185),1,false));
        txtFoodType.setBounds(800,1000,400,40);
        txtFoodType.setFont(new Font("微软雅黑",Font.BOLD,20));
        txtFoodType.setEnabled(false);
        background.add(txtFoodType);

        btnadd=new JButton("添加");
        btnadd.addActionListener(this);
        btnadd.setBounds(900,1100,100,40);
        btnadd.setFont(new Font("微软雅黑",Font.BOLD,20));
        background.add(btnadd);

        comboBox = new JComboBox();
        comboBox.setBounds(800, 1000, 420, 40);
        comboBox.addItem("套餐");
        comboBox.addItem("休闲小食");
        comboBox.addItem("缤纷饮料");
        comboBox.addItem("甜品");
        comboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange()==ItemEvent.SELECTED){
                    String userName=comboBox.getSelectedItem().toString();
                    txtFoodType.setText(userName);
                }
            }
        });
        comboBox.setFont(new Font("微软雅黑",Font.BOLD,20));
        background.add(comboBox);
    }
    public void actionPerformed(ActionEvent e){
        if (e.getActionCommand().equals("请选择")){
            JFrame jFrame=new JFrame();
            FileDialog fileDialog=new FileDialog(jFrame,"",FileDialog.LOAD);
            fileDialog.setVisible(true);
            fileDialog.setDirectory("D:\\Java项目\\restaurantOrder\\src\\image\\");
            picturePath= fileDialog.getDirectory()+fileDialog.getFile();

            Icon icon=new ImageIcon(picturePath);
        //按照按钮比例缩放
        Image image1=((ImageIcon) icon).getImage().getScaledInstance(300, 300, java.awt.Image.SCALE_SMOOTH);
        icon=new ImageIcon(image1);
        lblImage.setIcon(icon);
        }
        if (e.getActionCommand().equals("添加")){
            if (txtFoodName.getText().equals("")){
                JOptionPane.showMessageDialog(null,"食物名称不能为空");
            }
           else if (txtFoodType.getText().equals("")){
                JOptionPane.showMessageDialog(null,"食品类型不能为空");
            }
            else  if (txtCostPrice.getText().equals("")){
                JOptionPane.showMessageDialog(null,"食品价格不能为空");
            }
            else  if (txtIntroduce.getText().equals("")){
                JOptionPane.showMessageDialog(null,"食物介绍不能为空");
            }
            else{

                tb_food.setFoodName(txtFoodName.getText().trim());
                tb_food.setCostPrice(Float.parseFloat(txtCostPrice.getText().trim()));
                tb_food.setImageLink(picturePath);
                tb_food.setIntroduce(txtIntroduce.getText().trim());
                tb_food.setShopName("商店");
                tb_food.setPhone("17311032819");
                tb_food.setEmail("3033774629@qq.com");
            }

                if (txtFoodType.getText().equals("套餐")){
                    foodOp.adduserpackage(tb_food);
                    JOptionPane.showMessageDialog(null,"添加成功");
                }
                if (txtFoodType.getText().equals("休闲小食")){
                    foodOp.adduserleisuresnack(tb_food);
                    JOptionPane.showMessageDialog(null,"添加成功");

                }
                if (txtFoodType.getText().equals("缤纷饮料")){
                    foodOp.addusercolordrinks(tb_food);
                    JOptionPane.showMessageDialog(null,"添加成功");

                }
                if (txtFoodType.getText().equals("甜品")){
                    foodOp.addusersweet(tb_food);
                    JOptionPane.showMessageDialog(null,"添加成功");
                }
            }
        }
}