package ch07;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JFrameDemo extends JFrame { // 继承JFrame类
    public static void main(String[] args) {
        JFrameDemo win = new JFrameDemo(); // 构造窗口对象
        JButton b = new JButton("我是一个按钮"); // 构造按钮对象

        win.setLayout(new FlowLayout()); // 设置窗口采用流式布局
        win.add(b); // 将按钮加入窗口
        win.setTitle("我的第一个GUI程序"); // 设置标题栏文字
        win.setSize(400, 100); // 设置窗口大小
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置窗口的关闭行为
        win.setVisible(true); // 让窗口可见
    }
}