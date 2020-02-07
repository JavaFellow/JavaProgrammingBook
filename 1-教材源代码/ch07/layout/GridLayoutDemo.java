package ch07.layout;

import java.awt.GridLayout;

import javax.swing.JButton;

import ch07.BaseFrame;

public class GridLayoutDemo {
    public static void main(String[] args) {
        new GridLayoutDemo().init();
    }

    void init() {
        int row = 5, col = 4; // 行列数
        BaseFrame f = new BaseFrame("GridLayout 演示");
        f.setLayout(new GridLayout(row, col, 2, 2)); // 设置网格布局

        for (int i = 0; i < row * col; i++) {
            f.add(new JButton("" + (i + 1))); // 添加按钮到网格的下一个位置
        }
        f.showMe();
    }
}
