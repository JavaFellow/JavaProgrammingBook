package ch07;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;

public class JCheckBoxDemo {
    public static void main(String[] args) {
        BaseFrame f = new BaseFrame("JCheckBox 演示");
        f.setLayout(new FlowLayout());

        String[] s1 = { "音乐", "体育", "网络", "旅游", "摄影" };
        String[] s2 = { "CPU", "显卡", "内存", "硬盘" };

        JCheckBox[] hobbies = new JCheckBox[s1.length];
        JCheckBox[] hardwares = new JCheckBox[s2.length];

        for (int i = 0; i < hobbies.length; i++) {
            hobbies[i] = new JCheckBox(s1[i]); // 构造复选按钮对象
            f.add(hobbies[i]); // 加复选按钮到窗口
        }

        ImageIcon unchecked = ImageFactory.create("unchecked.png");
        ImageIcon checked = ImageFactory.create("checked.png");
        for (int i = 0; i < hardwares.length; i++) {
            hardwares[i] = new JCheckBox(s2[i]);
            hardwares[i].setIcon(unchecked);
            hardwares[i].setSelectedIcon(checked);
            f.add(hardwares[i]);
        }

        f.showMe();
    }
}
