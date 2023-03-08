package aegtool;


import javax.swing.*;
import java.awt.*;

public class ImageEg extends JPanel{
    private Image image;
    private  ImageIcon image1;
    public ImageEg(String picture) {
        super();
        //super����ǳ��࣬�����࣬super()�����ǵ��ø���Ĺ��췽����ʵ����superָ�������ʵ����
        //��������з��� fun(),����super.fun()������
        setOpaque(true);
        //��������͸����͸����trueֵΪ��͸��
        image1 = new ImageIcon("src//image//"+picture);
        image=image1.getImage();
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.WHITE);
        if (image!= null) {
            int height = image.getHeight(this);
            int width = image.getWidth(this);
            if (height != -1 && height > getHeight())
                height = getHeight();
            if (width != -1 && width > getWidth())
                width = getWidth();
            int x = (int) (((double) (getWidth() - width)) / 2.0);
            int y = (int) (((double) (getHeight() - height)) / 2.0);
            g.drawImage(image, x, y, width, height, this);
        }
    }
    public static void main(String[] args) {
        JFrame frame=new JFrame();
        frame.setSize(500, 500);
        ImageEg pI=new ImageEg("image1.jpg");
        frame.add(pI);
        frame.setVisible(true);
    }

}