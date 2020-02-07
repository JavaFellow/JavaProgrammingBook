package ch07;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

public class JToolBarDemo {
    public static void main(String[] args) {
        BaseFrame f = new BaseFrame("JToolBar 演示");

        JToolBar bar = new JToolBar("导航", SwingConstants.HORIZONTAL);
        String[] icons = { "first.png", "pre.png", "next.png", "last.png" };
        JButton[] btns = new JButton[icons.length];

        for (int i = 0; i < btns.length; i++) {
            ImageIcon icon = ImageFactory.create(icons[i]);
            btns[i] = new JButton();
            btns[i].setIcon(icon);
            bar.add(btns[i]); // 将按钮加到工具栏
        }
        bar.addSeparator(); // 加分隔线到工具栏末尾
        bar.add(new JLabel("搜索：")); // 将标签加到工具栏
        bar.add(new JTextField()); // 将文本框加到工具栏
        bar.setFloatable(true); // 设置工具栏为可浮动

        f.setLayout(new BorderLayout()); // 设置窗口为边界布局
        f.add(bar, BorderLayout.NORTH); // 将工具栏加到窗口北侧
        f.showMe();
    }
}
