package ch07;

import java.awt.Adjustable;

import javax.swing.JScrollBar;

public class JScrollBarDemo {
    public static void main(String[] args) {
        BaseFrame f = new BaseFrame("JScrollBar 演示");

        JScrollBar sb1 = new JScrollBar(Adjustable.HORIZONTAL); // 水平方向的滚动条
        sb1.setValue(30); // 设置滑块位置
        sb1.setLocation(5, 5);
        sb1.setSize(300, 30);

        JScrollBar sb2 = new JScrollBar(Adjustable.HORIZONTAL);
        sb2.setVisibleAmount(10); // 设置滑块大小
        sb2.setMinimum(-10); // 设置最小值
        sb2.setMaximum(20); // 设置最大值
        sb2.setValue(10);
        sb2.setLocation(5, 85);
        sb2.setSize(300, 30);

        // 指定了方向、初始值、滑块大小、最小值、最大值的滚动条
        JScrollBar sb3 = new JScrollBar(Adjustable.VERTICAL, 20, 30, 0, 50);
        sb3.setBlockIncrement(10); // 设置块增量大小(点击滑块两侧的空白区域时)
        sb3.setUnitIncrement(5); // 设置单位增量大小(点击两端的箭头时)
        sb3.setLocation(350, 5);
        sb3.setSize(20, 110);

        f.add(sb1); // 加滚动条到窗口
        f.add(sb2);
        f.add(sb3);

        f.showMe();
    }
}