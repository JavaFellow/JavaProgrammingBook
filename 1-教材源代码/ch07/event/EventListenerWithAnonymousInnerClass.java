package ch07.event;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import ch07.BaseFrame;

public class EventListenerWithAnonymousInnerClass {
    JLabel tip = new JLabel("请单击下面的按钮");
    JButton b1 = new JButton("确定");
    JButton b2 = new JButton("取消");

    public static void main(String[] args) {
        new EventListenerWithAnonymousInnerClass().init();
    }

    void init() {
        BaseFrame f = new BaseFrame("使用匿名内部类监听事件");
        f.setLayout(new FlowLayout());

        b1.addActionListener(new ActionListener() { // 以匿名内部类的对象作为参数
            public void actionPerformed(ActionEvent e) { // 重写接口定义的方法
                tip.setText("你单击了【" + b1.getText() + "】按钮");
            }
        });

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tip.setText("你单击了【" + b2.getText() + "】按钮");
            }
        });

        f.add(tip);
        f.add(b1);
        f.add(b2);
        f.showMe();
    }
}