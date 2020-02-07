package ch07.layout;

import java.awt.FlowLayout;

import javax.swing.JButton;

import ch07.BaseFrame;

public class FlowLayoutDemo {
    public static void main(String[] args) {
        new FlowLayoutDemo().init();
    }

    void init() {
        BaseFrame f = new BaseFrame("FlowLayout 演示");
        f.setLayout(new FlowLayout()); // 设置流式布局

        JButton[] btns = new JButton[8];
        for (int i = 0; i < btns.length; i++) {
            f.add(new JButton("按钮 " + (i + 1)));
        }
        f.showMe();
    }
}
