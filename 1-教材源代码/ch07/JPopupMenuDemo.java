package ch07;

import java.awt.FlowLayout;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;

public class JPopupMenuDemo {
    public static void main(String[] args) {
        BaseFrame f = new BaseFrame("JPopupMenu 演示");
        JTextField tf = new JTextField("带鼠标右键弹出菜单的文本框...");
        tf.setComponentPopupMenu(createPopupMenu()); // 设置弹出菜单

        f.setLayout(new FlowLayout());
        f.add(tf);
        f.showMe();
    }

    // 创建弹出菜单
    private static JPopupMenu createPopupMenu() {
        String ts[] = { "剪切", "复制", "粘贴", "删除", null, "全选" };
        JPopupMenu pm = new JPopupMenu();// 弹出菜单

        for (String t : ts) {
            if (t != null) {
                pm.add(new JMenuItem(t));// 加菜单项
            } else {
                pm.addSeparator();// 加菜单分隔线
            }
        }
        pm.setPopupSize(80, 120);// 设置弹出菜单大小
        return pm;
    }
}
