package ch07;

import java.awt.GridLayout;
import java.util.Hashtable;

import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;

public class JSliderDemo {
    public static void main(String[] args) {
        BaseFrame f = new BaseFrame("JSlider 演示");
        f.setLayout(new GridLayout(3, 1, 0, 5));

        JSlider s1 = new JSlider(); // 默认的滑块条
        s1.setExtent(20); // 设置滑块大小
        s1.setValue(90); // 设置滑块位置(无效，能选取到的最大值为80)

        JSlider s2 = new JSlider(SwingConstants.HORIZONTAL); // 指定了方向的滑块条
        s2.setMinimum(-10); // 设置最小值
        s2.setMaximum(20); // 设置最大值
        s2.setValue(-5);
        s2.setMajorTickSpacing(10); // 设置主刻度
        s2.setMinorTickSpacing(1); // 设置次刻度
        s2.setPaintTicks(true); // 绘制刻度
        s2.setPaintLabels(true); // 绘制描述标签

        JSlider s3 = new JSlider(SwingConstants.HORIZONTAL, 0, 10, 3);
        s3.setMajorTickSpacing(5);
        s3.setPaintTicks(true);
        s3.setPaintLabels(true);
        s3.setSnapToTicks(true); // 滑块吸附到刻度

        Hashtable labs = new Hashtable(); // Hashtable是Dictionary的子类
        int min = s3.getMinimum(); // 得到滑块条最小值
        int max = s3.getMaximum(); // 得到滑块条最大值
        labs.put(min, new JLabel("最长续航"));
        labs.put((max - min) / 2, new JLabel("平衡"));
        labs.put(max, new JLabel("最佳性能"));
        s3.setLabelTable(labs); // 设置描述标签的键值对集合

        f.add(s1);// 加滑块条到窗口
        f.add(s2);
        f.add(s3);

        f.showMe();
    }
}