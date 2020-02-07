package ch07;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class JTabbedPaneDemo {
    public static void main(String[] args) {
        BaseFrame f = new BaseFrame("JTabbedPane 演示");
        JTabbedPane tp = new JTabbedPane(JTabbedPane.TOP);

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel(); // 面板p3不包含任何组件
        p1.add(new JButton("按钮一")); // 向面板p1添加2个按钮
        p1.add(new JButton("按钮二"));
        p2.add(new JButton("按钮三"));// 向面板p2添加1个按钮

        tp.addTab("主题", p1); // 将3个面板加到分页面板
        tp.addTab("桌面", p2);
        tp.addTab("设置", p3);
        tp.setSelectedIndex(1); // 显示第2页
        tp.setSize(150, 80);
        tp.setLocation(5, 5);

        f.add(tp);
        f.setSize(280, 140);
        f.showMe();
    }
}
