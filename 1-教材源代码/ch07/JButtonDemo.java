package ch07;

import java.awt.GridLayout;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class JButtonDemo {
    public static void main(String[] args) {
        BaseFrame f = new BaseFrame("JButton 演示");
        f.setLayout(new GridLayout(3, 3, 5, 5));

        JButton[] btns = new JButton[9]; // 按钮数组
        for (int i = 0; i < btns.length; i++) {
            btns[i] = new JButton(); // 创建没有文字和图片的按钮
            f.add(btns[i]); // 加按钮到窗口
        }
        btns[0].setText("普通按钮");// 设置按钮文字
        btns[1].setText("<html><u>E</u>=MC<sup>2</sup></html>");

        btns[2].setText("带快捷键的按钮 (C) ");
        btns[2].setMnemonic(KeyEvent.VK_C); // 设置快捷键字符
        int k = btns[2].getText().indexOf(KeyEvent.VK_C); // 查找字符
        btns[2].setDisplayedMnemonicIndex(k); // 设置显示的快捷键字符

        btns[3].setText("禁用的按钮");
        btns[3].setEnabled(false);

        btns[4].setText("不带边框的按钮");
        btns[4].setBorder(null); // 设置边框为空

        btns[5].setText("不绘制内容区的按钮");
        btns[5].setContentAreaFilled(false); // 不绘制按钮内容区

        btns[6].setText("不绘制焦点的按钮");
        btns[6].setFocusable(false); // 不绘制按钮焦点

        btns[7].setText("带图片的按钮");
        ImageIcon image = ImageFactory.create("ok.png");
        btns[7].setIcon(image); // 设置按钮图标

        btns[8].setContentAreaFilled(false);
        btns[8].setIcon(image);
        f.showMe();
    }
}
