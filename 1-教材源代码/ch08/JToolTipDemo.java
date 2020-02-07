package ch08;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JToolTip;

import ch07.BaseFrame;
import ch07.ImageFactory;

/**** 继承JToolTip，自定义工具提示 ****/
class MyToolTip extends JToolTip {
    ImageIcon icon = ImageFactory.create("tip.png"); // 工具提示中的图标
    JLabel lab = new JLabel(icon); // 图标不是组件，故放在标签中

    public MyToolTip() { // 构造方法，创建自定义工具提示对象
        lab.setLocation(2, 2); // 设置标签的位置(相对于工具提示)
        lab.setSize(32, 32); // 设置标签的大小
        add(lab); // 加标签到工具提示
    }

    /**** 重写JComponent类的方法，获得工具提示首选大小 ****/
    public Dimension getPreferredSize() {
        return new Dimension(120, 36);
    }

    /**** 重写JComponent类的方法，绘制工具提示的背景和提示文字 ****/
    public void paintComponent(Graphics g) {
        int w = (int) getPreferredSize().getWidth(); // 工具提示宽度
        int h = (int) getPreferredSize().getHeight(); // 工具提示高度
        Color oldColor = g.getColor(); // 得到图形上下文当前颜色
        g.setColor(Color.CYAN); // 设置新的颜色
        g.fillRect(0, 0, w, h); // 填充工具提示的矩形背景
        g.setColor(oldColor); // 还原颜色(否则下行的文字颜色与背景色相同)
        g.drawString(getTipText(), 36, 24); // 绘制工具提示的文字
    }
}

/**** 继承JButton，自定义按钮 ****/
class MyButton extends JButton {
    public JToolTip createToolTip() { // 重写JComponent类的方法
        return new MyToolTip(); // 构造自定义工具提示对象
    }
}

/**** 测试类 ****/
public class JToolTipDemo {
    public static void main(String[] args) {
        BaseFrame f = new BaseFrame("JToolTip 演示");
        f.setLayout(new FlowLayout());

        JButton b1 = new JButton("按钮一"); // 构造按钮
        JButton b2 = new JButton("按钮二");
        MyButton b3 = new MyButton(); // 构造自定义按钮

        b1.setToolTipText("按钮一的提示。"); // 设置按钮的工具提示文字
        b2.setToolTipText("<html><h2>按钮二</h2>的<strike>提示</strike>。</html>");
        b3.setText("按钮三"); // 设置按钮文字(因MyButton中没有相应构造方法)
        b3.setToolTipText("按钮三的提示。"); // 设置按钮三的工具提示文字

        JToolTip tip = new JToolTip(); // 构造工具提示对象
        tip.setTipText("一个工具提示组件"); // 设置工具提示对象的文字
        tip.setToolTipText("工具提示的提示"); // 设置工具提示对象的提示文字

        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(tip); // 加工具提示到窗口
        f.showMe();
    }
}