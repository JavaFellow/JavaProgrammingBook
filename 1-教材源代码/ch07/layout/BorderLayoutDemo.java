package ch07.layout;

import java.awt.BorderLayout;

import javax.swing.JButton;

import ch07.BaseFrame;

public class BorderLayoutDemo {
    public static void main(String[] args) {
        new BorderLayoutDemo().init();
    }

    void init() {
        BaseFrame f = new BaseFrame("BorderLayout 演示");
        f.setLayout(new BorderLayout()); // 设置边界布局

        JButton b1 = new JButton("东");
        JButton b2 = new JButton("西");
        JButton b3 = new JButton("南");
        JButton b4 = new JButton("北");
        JButton b5 = new JButton("中");

        f.add(b1, BorderLayout.EAST);
        f.add(b2, BorderLayout.WEST);
        f.add(b3, BorderLayout.SOUTH);
        f.add(b4, BorderLayout.NORTH);
        f.add(b5); // 未指定区域，默认添加到中心

        f.showMe();
    }
}
