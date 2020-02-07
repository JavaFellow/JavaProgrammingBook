package ch07.event;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import ch07.BaseFrame;

public class EventListenerWithInnerClass {
    JLabel tip = new JLabel("请单击下面的按钮");
    JButton b1 = new JButton("确定");
    JButton b2 = new JButton("取消");

    public static void main(String[] args) {
        new EventListenerWithInnerClass().init();
    }

    void init() {
        BaseFrame f = new BaseFrame("使用内部类监听事件");
        f.setLayout(new FlowLayout());

        MyActionListener listener = new MyActionListener(); // 构造事件监听器对象
        b1.setActionCommand("OK"); // 设置组件的动作命令字符串(以便将来判断事件源)
        b1.addActionListener(listener); // 设置事件监听器对象
        b2.setActionCommand("CANCEL");
        b2.addActionListener(listener);

        f.add(tip);
        f.add(b1);
        f.add(b2);
        f.showMe();
    }

    /**** 编写实现了事件监听器接口的内部类作为事件监听器 ****/
    class MyActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) { // 重写接口定义的方法
            switch (e.getActionCommand().toUpperCase()) { // 判断事件源的另一种方式
                case "OK":
                    tip.setText("你单击了【" + b1.getText() + "】按钮");
                    break;
                case "CANCEL":
                    tip.setText("你单击了【" + b2.getText() + "】按钮");
                    break;
                default:
                    tip.setText("未知事件源");
            }
        }
    }
}