package ch07;

import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

public class JProgressBarDemo {
    public static void main(String[] args) {
        BaseFrame f = new BaseFrame("JProgressBar 演示");

        JProgressBar pb1 = new JProgressBar(); // 默认进度条
        pb1.setMinimum(0); // 设置最小值
        pb1.setMaximum(100); // 设置最大值
        pb1.setValue(75); // 设置当前值，进度=(75-0)/(100-0)，即75%
        pb1.setLocation(5, 5);
        pb1.setSize(130, 20);

        JProgressBar pb2 = new JProgressBar(-20, 20); // 指定了最小/大值的进度条
        pb2.setValue(-10);
        int min = pb2.getMinimum(); // 得到最小值
        int max = pb2.getMaximum(); // 得到最大值
        int value = pb2.getValue(); // 得到当前值
        pb2.setString("已下载：" + (value - min) * 100 / (max - min) + " %"); // 自定义进度文字
        pb2.setStringPainted(true); // 显示进度文字
        pb2.setLocation(5, 85);
        pb2.setSize(160, 20);

        JProgressBar pb3 = new JProgressBar(SwingConstants.VERTICAL); // 指定了方向的进度条
        pb3.setIndeterminate(true); // 设置进度条为不确定的(任务完成情况未知，动画循环显示)
        pb3.setString("不确定的进度条");
        pb3.setStringPainted(true);
        pb3.setLocation(180, 5);
        pb3.setSize(20, 100);

        f.add(pb1); // 加进度条到窗口
        f.add(pb2);
        f.add(pb3);

        f.showMe();
    }
}