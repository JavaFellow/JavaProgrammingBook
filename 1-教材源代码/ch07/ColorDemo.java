package ch07;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;

public class ColorDemo {
    public static void main(String[] args) {
        BaseFrame f = new BaseFrame("Color 演示");
        f.setLayout(new GridLayout(4, 4, 2, 2));

        JLabel[] labs = new JLabel[16];
        for (int i = 0; i < labs.length; i++) {
            int rgb = 255 - i * 17; // 16阶灰度颜色
            labs[i] = new JLabel();
            labs[i].setOpaque(true); // 设置标签背景不透明
            labs[i].setBackground(new Color(rgb, rgb, rgb)); // 设置标签背景色
            f.add(labs[i]);
        }
        f.showMe();
    }
}
