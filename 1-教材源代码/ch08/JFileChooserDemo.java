package ch08;

import java.awt.BorderLayout;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;

import ch07.BaseFrame;

public class JFileChooserDemo {
    public static void main(String[] args) {
        BaseFrame f = new BaseFrame("JFileChooser 演示");
        JLabel tip = new JLabel();

        JFileChooser fc = new JFileChooser("H:/images"); // 指定初始路径
        // 设置文件过滤器(根据文件扩展名)
        fc.setFileFilter(new FileNameExtensionFilter("图片文件", "bmp", "jpg", "png", "gif"));
        fc.setFileHidingEnabled(false); // 显示隐藏文件
        fc.setMultiSelectionEnabled(true); // 允许多选
        fc.setDialogTitle("请选择图片(可多选)"); // 设置对话框标题栏文字

        f.setLayout(new BorderLayout());
        f.add(tip, BorderLayout.CENTER);
        f.setLocationRelativeTo(null);
        f.showMe(); // 显示窗口

        int click = fc.showOpenDialog(f); // 显示文件选择器对话框
        String result = "<html>";
        if (click == JFileChooser.APPROVE_OPTION) { // 点击打开
            File[] files = fc.getSelectedFiles(); // 得到选择的所有文件
            result += "您选择了以下文件：<ol>";
            for (File file : files) {
                result = result + "<li>" + file.getName() + "</li>"; // 得到文件名
            }
            result += "</ol>";
        } else if (click == JFileChooser.CANCEL_OPTION) { // 点击取消
            result += "您取消了选择。";
        }
        result += "</html>";
        tip.setText(result); // 设置标签文字
    }
}
