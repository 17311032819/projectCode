package com.Test;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Test {

    public static void main(String[] args) {
        File picFile = new File("D:\\Java项目\\restaurantOrder\\src\\image\\aa.jpg"); // 图片文件路径
        BufferedImage image = null;
        try {
            image = ImageIO.read(picFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int width = image.getWidth();// 图片宽度
        int height = image.getHeight();// 图片高度
        System.out.println("width=" + width);
        System.out.println("height=" + height);
    }

}
