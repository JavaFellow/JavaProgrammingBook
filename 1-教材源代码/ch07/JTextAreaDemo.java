package ch07;

import java.awt.GridLayout;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class JTextAreaDemo {
    public static void main(String[] args) {
        BaseFrame f = new BaseFrame("JTextArea 演示");
        f.setLayout(new GridLayout(2, 1, 5, 5));

        JTextArea ta1 = new JTextArea(); // 不带初始文字的文本区
        JTextArea ta2 = new JTextArea("初始文字"); // 带初始文字的文本区
        ta2.setLineWrap(true); // 设置文本区为自动换行

        f.add(ta1); // 直接将ta1加到窗口
        f.add(new JScrollPane(ta2)); // 将ta2作为可滚动面板的显示区，并将后者加到窗口

        f.showMe();
    }
}