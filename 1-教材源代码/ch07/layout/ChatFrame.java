package ch07.layout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import ch07.BaseFrame;
import ch07.ImageFactory;

public class ChatFrame {
    /**** 改变GUI的观感(LookAndFeel)，请自行查阅相关API文档 ****/
    static {
        try {
            UIManager.setLookAndFeel(NimbusLookAndFeel.class.getName());
        } catch (Exception e) { // 上行调用的API可能抛出异常(具体见第10章)
            System.out.println("不支持的观感");
            System.exit(-1);
        }
    }

    public static void main(String[] args) {
        new ChatFrame().init();
    }

    void init() {
        BaseFrame f = new BaseFrame("仿QQ聊天窗口");

        /**** 向窗口添加2个子面板 ****/
        JPanel topPan = new JPanel(); // 外层顶部面板
        JPanel centerPan = new JPanel(); // 外层中间面板
        f.setLayout(new BorderLayout()); // 窗口用边框布局
        f.add(topPan, BorderLayout.NORTH);
        f.add(centerPan, BorderLayout.CENTER);

        /**** 向顶部面板添加3个子面板 ****/
        topPan.setLayout(new GridBagLayout()); // 顶部面板用网格包布局
        JLabel faceLab = new JLabel(ImageFactory.create("face.png"));// 头像
        JLabel nameLab = new JLabel("昵称"); // 昵称
        // 顶部面板中的图标栏
        JPanel topToolPan = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = c.gridy = 0; // 左上角网格
        c.gridheight = 2; // 头像占2行
        topPan.add(faceLab, c); // 添加头像

        c.gridx = 1; // 昵称所在网格
        c.gridy = 0;
        c.gridheight = 1; // 之前该字段为2
        c.weightx = 1.0; // 获得全部的水平方向改变量
        c.fill = GridBagConstraints.HORIZONTAL; // 只改变水平大小
        topPan.add(nameLab, c); // 添加昵称

        c.gridx = c.gridy = 1; // 顶部面板中的图标栏所在网格
        topPan.add(topToolPan, c);

        /**** 向外层顶部面板中的图标栏添加若干按钮 ****/
        JButton[] topBtns = new JButton[5];
        for (int i = 0; i < topBtns.length; i++) {
            topBtns[i] = new JButton(ImageFactory.create("top_" + (i + 1) + ".png"));
            topBtns[i].setBorder(null);
            topBtns[i].setContentAreaFilled(false);
            topToolPan.add(topBtns[i]);
        }

        /**** 向外层中间面板添加2个子面板 ****/
        centerPan.setLayout(new BorderLayout());
        // 外层中间面板的中间子面板(为分割面板)
        JSplitPane centerCenterPan = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        JPanel centerRightPan = new JPanel(); // 外层中间面板的右侧子面板
        centerPan.add(centerCenterPan, BorderLayout.CENTER);
        centerPan.add(centerRightPan, BorderLayout.EAST);

        /**** 向分割面板添加2个子面板 ****/
        JPanel centerTopPan = new JPanel(); // 分割面板上部
        JPanel centerBottomPan = new JPanel(); // 分割面板下部
        centerCenterPan.setResizeWeight(1.0); // 下部高度不变
        centerCenterPan.setTopComponent(centerTopPan);
        centerCenterPan.setBottomComponent(centerBottomPan);

        /**** 向分割面板上部添加2个子组件 ****/
        centerTopPan.setLayout(new BorderLayout());
        JLabel tipLab = new JLabel("交谈中请勿轻信汇款信息。"); // 提示标签
        JScrollPane historyPan = new JScrollPane(new JTextArea("消息历史记录..."));
        centerTopPan.add(tipLab, BorderLayout.NORTH);
        centerTopPan.add(historyPan, BorderLayout.CENTER);

        /**** 向分割面板下部添加3个子组件 ****/
        centerBottomPan.setLayout(new BorderLayout());
        JPanel centerToolPan = new JPanel(); // 工具栏
        JScrollPane chatPan = new JScrollPane(new JTextArea("聊天消息..."));
        JPanel btnsPan = new JPanel(); // 2个按钮所在的面板
        centerBottomPan.add(centerToolPan, BorderLayout.NORTH);
        centerBottomPan.add(chatPan, BorderLayout.CENTER);
        centerBottomPan.add(btnsPan, BorderLayout.SOUTH);

        /**** 向分割面板下部的工具栏添加2个子组件 ****/
        centerToolPan.setLayout(new BorderLayout());
        JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10)); // 放置若干按钮
        JButton[] centerBtns = new JButton[5];
        for (int i = 0; i < centerBtns.length; i++) {
            centerBtns[i] = new JButton(ImageFactory.create("center_" + (i + 1) + ".png"));
            centerBtns[i].setBorder(null);
            centerBtns[i].setContentAreaFilled(false);
            p.add(centerBtns[i]); // 添加按钮
        }
        centerToolPan.add(p, BorderLayout.CENTER);
        centerToolPan.add(new JToggleButton("消息记录"), BorderLayout.EAST);

        /**** 向分割面板下部的按钮面板添加按钮 ****/
        btnsPan.setLayout(new FlowLayout(FlowLayout.RIGHT)); // 右对齐的流式布局
        btnsPan.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT); // 组件从右到左
        btnsPan.add(new JButton("发送"));
        btnsPan.add(new JButton("关闭"));

        /**** 向外层中间面板的右侧面板添加2个子组件 ****/
        centerRightPan.setLayout(new GridLayout(2, 1)); // 2行1列
        JLabel qqShowLab = new JLabel("QQ秀图片区");
        JLabel videoLab = new JLabel("视频聊天区");
        centerRightPan.add(qqShowLab);
        centerRightPan.add(videoLab);

        f.setSize(600, 400);
        f.showMe();

        centerCenterPan.setDividerLocation(0.4); // 分割面板上下部比例
        this.showBorder(f.getContentPane()); // 显示面板等容器的边框
    }

    /**** 为便于观察容器，显示相关容器和组件的边框 ****/
    void showBorder(Container p) {
        for (Component c : p.getComponents()) { // 遍历容器所含子组件
            // 只显示面板、分隔面板和标签的边框
            if (c instanceof JPanel || c instanceof JSplitPane || c instanceof JLabel) {
                JComponent jc = (JComponent) c;
                Border b1 = BorderFactory.createEmptyBorder(2, 2, 2, 2);
                Border b2 = BorderFactory.createLineBorder(Color.GRAY);
                Border b = BorderFactory.createCompoundBorder(b1, b2);
                jc.setBorder(b);
            }
            if (c instanceof Container) {
                showBorder((Container) c); // 递归显示子容器边框
            }
        }
    }
}