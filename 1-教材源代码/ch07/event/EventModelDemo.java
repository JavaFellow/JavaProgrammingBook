package ch07.event;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import ch07.BaseFrame;

/**** 本类实现了JDK内建的监听器接口，故本类的对象就是一种监听器 ****/
public class EventModelDemo implements ActionListener {
    JLabel tip = new JLabel("请单击下面的按钮");
    JButton b1 = new JButton("确定");
    JButton b2 = new JButton("取消");

    public static void main(String[] args) {
        new EventModelDemo().init();
    }

    void init() {
        BaseFrame f = new BaseFrame("事件处理模型演示");
        f.setLayout(new FlowLayout());

        b1.addActionListener(this); // 以当前对象作为按钮的事件监听器
        b2.addActionListener(this);

        f.add(tip);
        f.add(b1);
        f.add(b2);

        f.showMe();
    }

    /**** 重写ActionListener接口的actionPerformed方法 ****/
    public void actionPerformed(ActionEvent e) { // 参数为事件对象
        if (e.getSource() == b1) { // 得到并判断事件源
            tip.setText("你单击了【" + b1.getText() + "】按钮");
        } else if (e.getSource() == b2) {
            tip.setText("你单击了【" + b2.getText() + "】按钮");
        }
    }
}
