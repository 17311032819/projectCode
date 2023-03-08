package aegtool;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class logining extends JFrame {
    private  JPanel contentPane;
    private  JProgressBar jProgressBar;

    public static void main(String[] args) {
        ImageEg ba=new ImageEg("im");
        logining logining=new logining();
        logining.setVisible(true);
    }
    public logining(){


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置窗体关闭时做什么
        setBounds(100, 100, 450, 440);//设置窗体出现的坐标及宽与高
        setTitle("学生选课及成绩管理系统");//设置标题
        contentPane = new JPanel();//生成内容面板
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));//设置Jpanel的边框及边距
        setContentPane(contentPane);//设置内容面板
        contentPane.setLayout(null);//设置它的布局方式为绝对布局
        contentPane.setVisible(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);//自动跳至界面最大化
        contentPane.setVisible(true);

        final JProgressBar progressBar=new JProgressBar();
        progressBar.setBounds(280,800,1750,40);
        progressBar.setStringPainted(true);
        new Thread(){
            public void run(){
                for(int i=0;i<=100;i++){
                    try{
                        Thread.sleep(50);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                    progressBar.setValue(i);
                }
                progressBar.setString("登陆成功！");
            }
        }.start();
        contentPane.add(progressBar);


    }

}