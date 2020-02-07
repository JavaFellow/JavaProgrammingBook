package ch07;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ImageIconDemo {
    public static void main(String[] args) throws IOException {
        BaseFrame f = new BaseFrame("ImageIcon 演示");

        String dir = "D:/MyJavaSource/images/"; // 图片文件所在目录(绝对路径)
        int count = 4; // 标签个数
        JLabel[] labs = new JLabel[count]; // 标签数组
        ImageIcon[] imgs = new ImageIcon[count]; // 图片数组

        /**** 方式1：根据文件名创建图片 ****/
        imgs[0] = new ImageIcon(dir + "clock.png");

        /**** 方式2：根据URL创建图片 ****/
        // 获得本类的类加载器对象，请查阅java.lang.ClassLoader的API文档
        ClassLoader loader = ImageIconDemo.class.getClassLoader();
        // 根据相对路径(Eclipse工程的src目录)创建图片文件的URL对象
        URL u1 = loader.getResource("images/java.png");
        imgs[1] = new ImageIcon(u1); // 根据URL创建图片

        /**** 方式3：根据java.awt.Image(AWT中的图片类)创建图片 ****/
        URL u2 = loader.getResource("images/apple.png");
        imgs[2] = new ImageIcon(Toolkit.getDefaultToolkit().createImage(u2));

        /**** 方式4：根据字节数组创建图片 ****/
        File file = new File(dir + "android.png"); // 创建图片文件
        FileInputStream in = new FileInputStream(file); // 创建文件输入流
        int fileLength = (int) file.length(); // 得到图片文件长度
        byte[] bytes = new byte[fileLength]; // 构造字节数组
        in.read(bytes, 0, fileLength); // 将图片文件读入字节数组
        imgs[3] = new ImageIcon(bytes); // 根据字节数组创建图片
        in.close(); // 关闭文件输入流

        f.setLayout(new GridLayout(2, 2, 5, 5));// 设置窗口布局(2行2列，行列间隔均为5)
        for (int i = 0; i < count; i++) {
            labs[i] = new JLabel(imgs[i]); // 创建带图片的标签
            labs[i].setOpaque(true);
            labs[i].setBackground(Color.WHITE); // 白色背景
            f.add(labs[i]); // 将标签加入窗口
        }

        /**** 设置标签文字及对齐方式 ****/
        String s = "宽：" + imgs[2].getIconWidth() + "，高：" + imgs[2].getIconHeight();
        labs[2].setText(s); // 设置标签文字
        labs[2].setHorizontalTextPosition(SwingConstants.CENTER);
        labs[2].setVerticalTextPosition(SwingConstants.BOTTOM);

        f.setIconImage(new ImageIcon(dir + "pc.png").getImage()); // 设置窗口图标
        f.showMe();
    }
}
