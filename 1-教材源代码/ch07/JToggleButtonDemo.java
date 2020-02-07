package ch07;

import java.awt.FlowLayout;

import javax.swing.JToggleButton;

public class JToggleButtonDemo {
    public static void main(String[] args) {
        BaseFrame f = new BaseFrame("JToggleButton 演示");
        JToggleButton[] tbs = new JToggleButton[4]; // 开关按钮数组

        tbs[0] = new JToggleButton(); // 不带文字和图片的开关按钮
        tbs[0].setText("按钮一状态为：" + tbs[0].isSelected()); // 设置文字

        tbs[1] = new JToggleButton("", true); // 初始开启的开关按钮
        tbs[1].setText("按钮二状态为：" + tbs[1].isSelected());

        tbs[2] = new JToggleButton();
        tbs[2].setSelected(true); // 开启按钮
        tbs[2].setText("按钮三状态为：" + tbs[2].isSelected());

        // 指定文字、图片和初始状态
        tbs[3] = new JToggleButton("按钮四", ImageFactory.create("off.png"), false);
        tbs[3].setSelectedIcon(ImageFactory.create("on.png")); // 设置开启时的替换图片
        tbs[3].setFocusable(false); // 不绘制焦点

        f.setLayout(new FlowLayout());
        for (int i = 0; i < tbs.length; i++) {
            f.add(tbs[i]); // 加开关按钮到窗口
        }
        f.showMe();
    }
}
