package ch07;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class JTextFieldDemo {
    public static void main(String[] args) {
        BaseFrame f = new BaseFrame("JTextField 演示");

        JTextField tf1 = new JTextField("文本框一的初始文字");// 指定初始文字

        JTextField tf2 = new JTextField(12);// 指定列数
        tf2.setText("文本框二"); // 设置初始文字
        tf2.setHorizontalAlignment(SwingConstants.RIGHT); // 文字居右
        tf2.setBackground(Color.BLUE); // 设置文本框背景色
        tf2.setForeground(Color.YELLOW); // 设置文字颜色(前景色)

        JTextField tf3 = new JTextField("文本框三", 10);// 造指定初始文字和列数
        tf3.setFont(new Font("微软雅黑", Font.ITALIC, 24)); // 设置字体
        tf3.setHorizontalAlignment(SwingConstants.CENTER); // 文字居中

        f.setLayout(new FlowLayout());
        f.add(tf1); // 加文本框到窗口
        f.add(tf2);
        f.add(tf3);

        f.showMe();

        tf3.requestFocus(); // 文本框三获得键盘焦点
        tf3.select(1, 3); // 选中部分文字(在窗口显示及文本框获得焦点后有效)
    }
}
