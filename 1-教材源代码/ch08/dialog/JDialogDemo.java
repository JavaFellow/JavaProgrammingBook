package ch08.dialog;

import java.awt.BorderLayout;

import javax.swing.JLabel;

import ch07.BaseFrame;

public class JDialogDemo { // 测试类
    public static void main(String[] args) {
        BaseFrame f = new BaseFrame("JDialog 演示");
        JLabel tip = new JLabel();

        f.setLayout(new BorderLayout());
        f.add(tip, BorderLayout.NORTH);
        f.setLocationRelativeTo(null); // 窗口居中
        f.showMe();

        LoginDialog d = new LoginDialog(f); // 创建对话框
        d.setSize(200, 130); // 设置对话框大小
        d.setLocationRelativeTo(f); // 设置对话框位于父窗口中心
        d.setVisible(true); // 显示对话框，对话框关闭前，程序将阻塞于此

        tip.setText("关闭了登录对话框"); // 修改标签文字
    }
}