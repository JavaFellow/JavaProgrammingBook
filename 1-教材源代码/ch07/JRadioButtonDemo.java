package ch07;

import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;

public class JRadioButtonDemo {
    public static void main(String[] args) {
        BaseFrame f = new BaseFrame("JRadioButton 演示");
        f.setLayout(new GridLayout(5, 1));

        ButtonGroup sexGroup = new ButtonGroup(); // 性别按钮组
        ButtonGroup majorGroup = new ButtonGroup(); // 专业按钮组

        String[] texts = { "男", "女", "英语", "计算机", "数学" };// 各单选按钮的文字
        JRadioButton[] rbs = new JRadioButton[texts.length];// 单选按钮数组
        ImageIcon unchecked = ImageFactory.create("unchecked.png"); // 未选中时图标
        ImageIcon checked = ImageFactory.create("checked.png"); // 选中时图标

        for (int i = 0; i < rbs.length; i++) {
            rbs[i] = new JRadioButton(texts[i]); // 创建单选按钮
            if (i >= 2) { // 设置后3个单选按钮的默认图标和被选中时的图标
                rbs[i].setIcon(unchecked);
                rbs[i].setSelectedIcon(checked);
            }
            f.add(rbs[i]); // 将单选按钮加入窗口
        }

        sexGroup.add(rbs[0]); // 将前2个单选按钮加入性别组
        sexGroup.add(rbs[1]);
        majorGroup.add(rbs[2]); // 将后3个单选按钮加入专业组
        majorGroup.add(rbs[3]);
        majorGroup.add(rbs[4]);

        rbs[2].setSelected(true); // 试图选中同一组中的多个单选按钮
        rbs[3].setSelected(true);

        f.showMe();
    }
}
