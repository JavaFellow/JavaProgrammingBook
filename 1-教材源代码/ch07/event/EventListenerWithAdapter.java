package ch07.event;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

import ch07.BaseFrame;

// MouseAdapter类实现了MouseListener、MouseWheelListener和MouseMotionListener接口
public class EventListenerWithAdapter extends MouseAdapter {
    JLabel canvas = new JLabel(); // 写字区
    Graphics g = null; // 图形上下文 (请自行查阅API)

    public static void main(String[] args) {
        new EventListenerWithAdapter().init();
    }

    void init() {
        BaseFrame f = new BaseFrame("继承默认适配器类监听事件");
        f.setLayout(new BorderLayout());

        canvas.addMouseListener(this); // 为组件添加多个事件监听器
        canvas.addMouseMotionListener(this);
        canvas.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        f.add(new JLabel("用鼠标在下面写字"), BorderLayout.NORTH);
        f.add(canvas, BorderLayout.CENTER);
        f.setSize(420, 140);
        f.setResizable(false); // 禁止调整窗口大小(否则要重新设置g)
        f.showMe();

        g = canvas.getGraphics(); // 获取组件的图形上下文，注意在组件显示之后获取，否则为null
        g.setColor(Color.RED); // 设置绘制颜色
    }

    /**** 重写鼠标按下事件对应的方法 ****/
    public void mousePressed(MouseEvent e) {
        g.fillOval(e.getX(), e.getY(), 3, 3); // 绘制椭圆代表鼠标当前坐标点
    }

    /**** 重写鼠标拖曳事件对应的方法 ****/
    public void mouseDragged(MouseEvent e) {
        g.fillOval(e.getX(), e.getY(), 3, 3);
    }

    /**** 对其余事件不感兴趣，因此不用重写对应的方法 ****/
}