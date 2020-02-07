package ch07;

import javax.swing.JFrame;

public class BaseFrame extends JFrame {
    public BaseFrame(String title) {// 构造方法
        super.setLayout(null); // 为窗口设置空布局(其内组件采用像素绝对定位)
        super.setTitle(title);
        super.setSize(300, 200);
        super.setLocationRelativeTo(null); // 让窗口居中
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void showMe() { // 让窗口可见
        super.setVisible(true);
    }
}