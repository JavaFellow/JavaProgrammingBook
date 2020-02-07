package ch07;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class FontDemo {
    /**** 得到系统中所有中文字体的名称 ****/
    public static List<String> getChineseFontNames() {
        // 得到本地图形环境(请查阅GraphicsEnvironment类的API)
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] fonts = ge.getAvailableFontFamilyNames(); // 得到所有的字体系列
        List<String> names = new ArrayList<String>(); // 元素为字符串的线性表(详见第13章)
        for (String f : fonts) {
            if (f.charAt(0) > 0x80) { // 过滤掉非中文字体
                names.add(f); // 加入线性表
            }
        }
        return names;
    }

    public static void main(String[] args) {
        BaseFrame f = new BaseFrame("Font 演示");
        f.setLayout(new GridLayout(4, 5, 2, 2)); // 4行5列

        List<String> names = getChineseFontNames();
        for (int i = 0; i < Math.min(names.size(), 20); i++) { // 最多显示20个字体
            Font font = new Font(names.get(i), Font.PLAIN, 36); // 创建字体对象
            JLabel lab = new JLabel(names.get(i)); // 以字体名称作为标签文字
            lab.setFont(font); // 设置标签字体
            lab.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            f.add(lab);
        }
        f.showMe();
    }
}
