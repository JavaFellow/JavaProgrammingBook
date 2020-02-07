package ch07;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class JScrollPaneDemo {
    public static void main(String[] args) {
        BaseFrame f = new BaseFrame("JScrollPane 演示");

        JPanel p = new JPanel(); // 创建面板对象p
        JScrollPane sp = new JScrollPane(p);// 创建可滚动面板对象(以p作为其显示区)

        sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        int count = 2; // 按钮个数 (第2次运行改为5)
        JButton[] btns = new JButton[count];
        for (int i = 0; i < btns.length; i++) {
            btns[i] = new JButton("按钮 " + (i + 1));// 创建按钮对象并设置文字
            p.add(btns[i]); // 注意：是加到p，而非sp
        }

        sp.setLocation(5, 5);
        sp.setSize(200, 70);

        f.setSize(260, 140); // 重新设置窗口大小
        f.add(sp); // 将可滚动面板对象添加到窗口f
        f.showMe();
    }
}