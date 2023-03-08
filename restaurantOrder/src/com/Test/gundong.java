package com.Test;
//文件名：Demo4.java
import aegtool.FontSize;
import aegtool.ImageEg;
//文件名：Demo4.java
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class gundong extends JFrame {
    MyJPanel mp;
    int index;
    ImageIcon[] imgs = {
            new ImageIcon("src/image/1.jpg"),
            new ImageIcon("src/image/2.jpg"),
            new ImageIcon("src/image/3.jpg"),
            new ImageIcon("src/image/4.jpg"),
            new ImageIcon("src/image/5.jpg"),
            new ImageIcon("src/image/6.jpg"),
            new ImageIcon("src/image/7.jpg"),
            new ImageIcon("src/image/8.jpg"),
    };
    public gundong() {
        mp = new MyJPanel();
        ImageEg background=new ImageEg("");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 550, 450);
        background.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(background);
        background.setLayout(new BorderLayout());
        setExtendedState(JFrame.MAXIMIZED_BOTH);//自动跳至界面最大化
        background.add(mp);
        setTitle("管理员");
        background.setVisible(true);
        Timer timer = new Timer(500,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mp.repaint();
            }
        });
        timer.start();
    }
    public static void main(String[] args) {
        new gundong().setVisible(true
        );
    }
    class MyJPanel extends JPanel{
        @Override
        public void paint(Graphics g) {

            super.paint(g);
            super.setBounds(600,400,300,500);
            g.drawImage(imgs[index%imgs.length].getImage(), 100, 100,this);
            index++;
        }
    }
}
