package ch08;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JColorChooser;
import javax.swing.JLabel;

import ch07.BaseFrame;

public class JColorChooserDemo {
    public static void main(String[] args) {
        BaseFrame f = new BaseFrame("JColorChooser 演示");
        JLabel tip = new JLabel();

        f.setLayout(new BorderLayout());
        f.add(tip, BorderLayout.CENTER);
        f.setLocationRelativeTo(null);
        f.showMe();

        /**** 显示颜色选择器对话框，对话框关闭前，程序将阻塞在下行 ****/
        Color c = JColorChooser.showDialog(f, "选择颜色", Color.BLUE);
        if (c != null) { // 点击确定按钮
            tip.setText("您选择的颜色是(RGB)：" + c.getRed() + "，" + c.getGreen() + "，" + c.getBlue() + "。");
        } else { // 点击取消按钮或关闭对话框
            tip.setText("您没有选择颜色。");
        }
    }
}
