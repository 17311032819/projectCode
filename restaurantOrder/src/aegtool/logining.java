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


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���ô���ر�ʱ��ʲô
        setBounds(100, 100, 450, 440);//���ô�����ֵ����꼰�����
        setTitle("ѧ��ѡ�μ��ɼ�����ϵͳ");//���ñ���
        contentPane = new JPanel();//�����������
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));//����Jpanel�ı߿򼰱߾�
        setContentPane(contentPane);//�����������
        contentPane.setLayout(null);//�������Ĳ��ַ�ʽΪ���Բ���
        contentPane.setVisible(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);//�Զ������������
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
                progressBar.setString("��½�ɹ���");
            }
        }.start();
        contentPane.add(progressBar);


    }

}