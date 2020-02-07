package ch07;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class BorderDemo {
    Font font = new Font("宋体", Font.PLAIN, 12); // 标签字体

    public static void main(String[] args) {
        new BorderDemo().init();
    }

    /**** 初始化窗口 ****/
    public void init() {
        BaseFrame f = new BaseFrame("Border 演示");
        f.setLayout(new GridLayout(4, 3, 5, 5));

        Border[] b = new Border[12]; // 边框数组

        b[0] = BorderFactory.createLineBorder(Color.BLACK); // 线边框
        b[1] = BorderFactory.createEtchedBorder(EtchedBorder.RAISED); // 蚀刻边框
        b[2] = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        b[3] = BorderFactory.createRaisedBevelBorder(); // 斜面边框
        b[4] = BorderFactory.createLoweredBevelBorder();
        b[5] = BorderFactory.createEmptyBorder(); // 空边框

        this.addBorder(f, b[0], "线边框");
        this.addBorder(f, b[1], "凸起的蚀刻边框");
        this.addBorder(f, b[2], "凹入的蚀刻边框");
        this.addBorder(f, b[3], "凸起的斜面边框");
        this.addBorder(f, b[4], "凹入的斜面边框");
        this.addBorder(f, b[5], "空边框");

        ImageIcon icon = ImageFactory.create("wave.gif");
        b[6] = BorderFactory.createMatteBorder(-1, -1, -1, -1, icon); // 衬边边框
        b[7] = BorderFactory.createMatteBorder(1, 1, 1, 5, Color.RED);
        this.addBorder(f, b[6], "图标衬边边框");
        this.addBorder(f, b[7], "颜色衬边边框");

        b[8] = BorderFactory.createTitledBorder("标题"); // 标题边框
        this.addBorder(f, b[8], "默认的标题边框");

        b[9] = BorderFactory.createTitledBorder(b[2], "右上标题");
        ((TitledBorder) b[9]).setTitleJustification(TitledBorder.RIGHT); // 标题对齐方式
        ((TitledBorder) b[9]).setTitlePosition(TitledBorder.ABOVE_TOP); // 标题位置
        this.addBorder(f, b[9], "指定标题位置的凹入蚀刻边框");

        b[10] = BorderFactory.createCompoundBorder(b[3], b[4]); // 组合边框
        this.addBorder(f, b[10], "组合边框(2个斜面边框)");

        Border lineBorder = BorderFactory.createLineBorder(Color.RED);
        b[11] = BorderFactory.createCompoundBorder(lineBorder, b[10]); // 组合边框
        this.addBorder(f, b[11], "组合边框(前一边框加线边框)");

        f.showMe();
    }

    /**** 将文字为t的标签加入面板p、设置p的边框为b、加p到容器c ****/
    void addBorder(Container c, Border b, String t) {
        JPanel p = new JPanel(new GridLayout(1, 1)); // 让标签占满面板p
        JLabel lab = new JLabel(t, SwingConstants.CENTER);
        lab.setFont(font);
        p.add(lab);
        p.setBorder(b);
        c.add(p);
    }
}
