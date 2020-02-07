package ch07.event;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.beans.EventHandler;

import javax.swing.JButton;
import javax.swing.JLabel;

import ch07.BaseFrame;

public class EventHandlerDemo {
    JLabel tips = new JLabel("请点击下面的按钮");// 构造各组件
    JButton b1 = new JButton("确定");
    JButton b2 = new JButton("取消");

    public static void main(String[] args) {
        EventHandlerDemo demo = new EventHandlerDemo();
        demo.initUI();
    }

    void initUI() { // 初始化界面
        BaseFrame f = new BaseFrame("事件处理模型演示");
        f.setLayout(new FlowLayout());

        // 为组件增加动作事件监听器（当前对象就是一种动作事件监听器）
        b1.addActionListener(EventHandler.create(ActionListener.class, tips, "text", "source.text", "actionPerformed"));
        b2.addActionListener(EventHandler.create(ActionListener.class, tips, "text", "source.text", "actionPerformed"));

        f.add(tips);// 添加组件
        f.add(b1);
        f.add(b2);
        f.showMe();
    }
}