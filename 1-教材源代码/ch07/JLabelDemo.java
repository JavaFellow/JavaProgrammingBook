package ch07;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class JLabelDemo {
    public static void main(String[] args) {
        BaseFrame f = new BaseFrame("JLabel 演示");
        f.setLayout(new GridLayout(3, 1)); // 设置窗口为网格布局(3行1列)

        JLabel l1 = new JLabel("普通标签");

        JLabel l2 = new JLabel("指定字体并靠右下对齐的标签");
        l2.setFont(new Font("方正姚体", Font.BOLD, 18)); // 设置标签字体
        l2.setOpaque(true); // 设置标签不透明(否则设置其背景色无效)
        l2.setBackground(Color.LIGHT_GRAY); // 设置标签背景色
        l2.setForeground(Color.WHITE); // 设置标签前景色(文字颜色)
        l2.setHorizontalAlignment(SwingConstants.RIGHT); // 水平居右
        l2.setVerticalAlignment(SwingConstants.BOTTOM); // 垂直居下

        String s = "<html>带<font size=6>HTML</font><i>标记的</i><sub>标签</sub></html>";
        JLabel l3 = new JLabel(s);// 创建带HTML标记的标签

        f.add(l1);
        f.add(l2);
        f.add(l3);
        f.showMe();
    }
}
