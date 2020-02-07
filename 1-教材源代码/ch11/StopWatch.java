package ch11;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StopWatch extends JFrame {
    JLabel contentLab = new JLabel("00 : 00 : 00.00"); // 计时内容标签
    long begin, elapsed, total; // 开始时间、当前逝去时间、总逝去时间
    boolean b = false; // 是否刷新时间

    /**** 初始化UI ****/
    private void init() {
        setLayout(new BorderLayout());

        JButton startBtn = new JButton("开始");
        JButton pauseBtn = new JButton("暂停");
        JButton resumeBtn = new JButton("继续");
        JButton resetBtn = new JButton("复位");

        pauseBtn.setEnabled(false); // 设置各按钮的初始状态
        resumeBtn.setEnabled(false);
        resetBtn.setEnabled(false);

        JPanel top = new JPanel();
        top.add(startBtn);
        top.add(pauseBtn);
        top.add(resumeBtn);
        top.add(resetBtn);
        add(top, BorderLayout.NORTH);

        contentLab.setFont(new Font("Tohoma", Font.BOLD, 40));
        contentLab.setHorizontalAlignment(JLabel.CENTER);
        add(contentLab, BorderLayout.CENTER);

        /**** 按钮点击事件处理 ****/
        startBtn.addActionListener(e -> {
            b = true; // 刷新时间
            total = 0; // 总逝去时间清零
            begin = System.currentTimeMillis(); // 修改开始时间
            startBtn.setEnabled(false); // 修改各按钮的状态
            pauseBtn.setEnabled(true);
            resetBtn.setEnabled(true);
        });
        pauseBtn.addActionListener(e -> {
            b = false; // 停止刷新时间
            total += elapsed; // 累加到总逝去时间
            pauseBtn.setEnabled(false);
            resumeBtn.setEnabled(true);
        });
        resumeBtn.addActionListener(e -> {
            b = true;
            begin = System.currentTimeMillis();
            pauseBtn.setEnabled(true);
            resumeBtn.setEnabled(false);
        });
        resetBtn.addActionListener(e -> {
            b = false;
            contentLab.setText("00 : 00 : 00.00");
            startBtn.setEnabled(true);
            pauseBtn.setEnabled(false);
            resumeBtn.setEnabled(false);
            resetBtn.setEnabled(false);
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 200);
        setVisible(true);
    }

    public void on() {
        new Thread(() -> { // 创建线程对象(参数为Lambda表达式)
            while (true) { // 死循环
                if (b) { // 刷新时间
                    elapsed = System.currentTimeMillis() - begin; // 计算当前逝去的时间
                    int h = (int) ((total + elapsed) / (60 * 60 * 1000)); // 计算各分量
                    int m = (int) ((total + elapsed) % (60 * 60 * 1000) / (60 * 1000));
                    int s = (int) ((total + elapsed) % (60 * 1000) / 1000);
                    int ms = (int) ((total + elapsed) % 1000 / (1000 / 24));
                    contentLab.setText(String.format("%02d : %02d : %02d.%02d", h, m, s, ms));
                }
                try {
                    Thread.sleep(1000 / 24); // 休眠1/24秒
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start(); // 启动线程
    }

    public static void main(String[] args) {
        StopWatch t = new StopWatch();
        t.init();
        t.on();
    }
}