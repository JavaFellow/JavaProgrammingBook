package ch07;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

public class JPanelDemo {
    public static void main(String[] args) {
        BaseFrame f = new BaseFrame("JPanel 演示"); // 实例化窗口对象
        JPanel p1 = new JPanel(); // 构造面板对象
        JPanel p2 = new JPanel();

        JButton b1 = new JButton("按钮一"); // 构造按钮对象
        JButton b2 = new JButton("按钮二");
        JButton b3 = new JButton("按钮三");

        p1.add(b1); // 将按钮加入面板
        p1.setSize(80, 60); // 设置面板大小
        p1.setLocation(5, 10); // 设置面板的位置 (相对于父容器)
        p1.setBackground(Color.LIGHT_GRAY); // 设置面板的背景色

        p2.add(b2);
        p2.add(b3);
        p2.setSize(80, 70);
        p2.setLocation(40, 50);
        p2.setBackground(Color.DARK_GRAY);

        f.add(p2); // 将面板加入窗口
        f.add(p1);
        f.showMe();
    }
}
