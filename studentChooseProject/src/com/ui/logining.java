package  com.ui;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;

public class logining extends JFrame {
//    private  JPanel contentPane;
    private  JProgressBar jProgressBar;

    public static void main(String[] args) {
        logining logining=new logining();
        logining.setVisible(true);
    }
    public   logining(){


        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        ImageEg background=new ImageEg("image1.jpg");
        background.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(background);
        background.setLayout(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);//�Զ������������


        this.setContentPane(background);
        background.setLayout(null);//�������Ĳ��ַ�ʽΪ���Բ���
        final JProgressBar progressBar=new JProgressBar();
        progressBar.setBounds(40,800,1350,20);
        progressBar.setStringPainted(true);
        new Thread(){
            public void run(){
                for(int i=0;i<=100;i++){
                    try{
                        Thread.sleep(10);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                    progressBar.setValue(i);
                }
                progressBar.setString("��½�ɹ���");
            }
        }.start();
        background.add(progressBar);
        this.setVisible(true);

    }

}