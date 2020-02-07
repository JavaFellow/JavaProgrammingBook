package ch07;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class JSplitPaneDemo {
    public static void main(String[] args) {
        BaseFrame f = new BaseFrame("JSplitPane 演示");

        /**** 第1个分割面板 ****/
        JSplitPane sp1 = new JSplitPane();
        sp1.setOrientation(JSplitPane.HORIZONTAL_SPLIT); // 设置分割方向
        sp1.setOneTouchExpandable(true); // 带一键展开功能
        sp1.setDividerLocation(100); // 设置分割条位置
        sp1.setLocation(5, 5);
        sp1.setSize(200, 125);

        /**** 第2个分割面板 ****/
        JSplitPane sp2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        JPanel p = new JPanel(); // 创建面板
        p.add(new JButton("按钮一")); // 加入按钮
        p.add(new JButton("按钮二"));
        sp2.setLeftComponent(p); // 将p设置到sp2的上部
        sp2.setRightComponent(new JButton("按钮三"));
        sp2.setRightComponent(new JButton("按钮四"));// 将覆盖按钮三

        sp1.setRightComponent(sp2);// 将sp2设置到sp1的右部
        f.add(sp1); // 将sp1加入窗口
        f.showMe();

        sp2.setDividerLocation(0.8);// 设置sp2的上部子面板所占比例
    }
}