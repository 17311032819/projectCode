package com.ui;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Code {

    public static void main(String[] args) {
        Code code=new Code();
        String[] rand=new String[4];
        rand=code.Code();
        for (int i = 0; i < 4; i++) {
            System.out.println(rand[i]);
        }
    }

    public String[] Code() {
        BufferedImage bufferedImage=new BufferedImage(150,50,BufferedImage.TYPE_INT_RGB);

//       Graphics graphics=bufferedImage.getGraphics();//获取图片画笔，创建bufferedImage时已经创号画笔
        Graphics2D graphics=(Graphics2D) bufferedImage.getGraphics();
        //运用Graphics 函数的子函数功能多一点
        graphics.setColor(Color.white);


        graphics.fillRect(0,0,150,50);

        graphics.setColor(Color.black);
        graphics.setFont(new Font("楷体",Font.BOLD,30));
        int x=20,y=20;//随机数字初始位置横坐标
        Random random=new Random();

        String[] rand=new String[4];
        for (int i = 0; i < 4; i++) {
            int jd=random.nextInt(91)-45;//获得角度-45到45
            double hd=jd*Math.PI/180;
            rand[i]=Rand.getCharAndNumr(1);
            graphics.rotate(hd,x,y);//在原有位置旋转
            graphics.drawString(rand[i],x,30);
            graphics.rotate(-hd,x,y);//旋转后恢复位置不然转的角度过大
            x+=20;
        }
        int x1,x2,y2,y1;
        for (int i = 0; i < 5; i++) {
            graphics.setColor(getRandomColor());
            x1=random.nextInt(30);//设置线条两个点的坐标
            x2=random.nextInt(30)+120;
            y1=random.nextInt(50);
            y2=random.nextInt(50);
            graphics.drawLine(x1,y1,x2,y2);
        }

        try {
            ImageIO.write(bufferedImage,"jpg",new File("src//image//code.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }


        return rand;
    }
    public Color getRandomColor(){//获得随机颜色
        Random random=new Random();
        int R=random.nextInt(255),G=random.nextInt(255),B=random.nextInt(255);
        return new Color(R,G,B);
    }

}
