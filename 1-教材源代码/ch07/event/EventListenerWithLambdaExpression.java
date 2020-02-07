package ch07.event;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;

import ch07.BaseFrame;

public class EventListenerWithLambdaExpression {
    JLabel tip = new JLabel("请单击下面的按钮");
    JButton b1 = new JButton("确定");
    JButton b2 = new JButton("取消");

    public static void main(String[] args) {
        new EventListenerWithLambdaExpression().init();
    }

    void init() {
        BaseFrame f = new BaseFrame("使用Lambda表达式监听事件");
        f.setLayout(new FlowLayout());

        b1.addActionListener(e -> tip.setText("你单击了【" + b1.getText() + "】按钮"));
        b2.addActionListener(e -> tip.setText("你单击了【" + b2.getText() + "】按钮"));

        f.add(tip);
        f.add(b1);
        f.add(b2);
        f.showMe();
    }
}