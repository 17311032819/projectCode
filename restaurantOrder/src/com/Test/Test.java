package com.Test;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Test {

    public static void main(String[] args) {
        File picFile = new File("D:\\Java��Ŀ\\restaurantOrder\\src\\image\\aa.jpg"); // ͼƬ�ļ�·��
        BufferedImage image = null;
        try {
            image = ImageIO.read(picFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int width = image.getWidth();// ͼƬ���
        int height = image.getHeight();// ͼƬ�߶�
        System.out.println("width=" + width);
        System.out.println("height=" + height);
    }

}
