package ch07;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;

public class JMenuDemo {
    public static void main(String[] args) {
        BaseFrame f = new BaseFrame("JMenuBar/JMenu/JMenuItem 演示");
        JMenuBar bar = new JMenuBar(); // 菜单栏

        JMenu menuFile = new JMenu("文件(F)"); // 菜单
        menuFile.setMnemonic(KeyEvent.VK_F); // 设置菜单的快捷键字符

        JMenuItem mi1 = new JMenuItem("新建"); // 菜单项
        JMenuItem mi2 = new JMenuItem("打开(O)", KeyEvent.VK_O);
        JMenuItem mi3 = new JMenuItem("保存", ImageFactory.create("save.png"));
        mi3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.ALT_MASK));

        menuFile.add(mi1); // 加菜单项到菜单
        menuFile.add(mi2);
        menuFile.addSeparator(); // 加菜单分隔条
        menuFile.add(mi3);

        JMenu saveAsMenu = new JMenu("另存为"); // 带子菜单的菜单项(注意类型是JMenu)
        JMenuItem mi4 = new JMenuItem("文本文件");
        mi4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.CTRL_MASK));
        JMenuItem mi5 = new JMenuItem("图片文件");
        saveAsMenu.add(mi4); // 添加子菜单项
        saveAsMenu.add(mi5);

        menuFile.add(saveAsMenu); // 菜单中可以再加入菜单，从而形成多级菜单
        menuFile.addSeparator();

        JRadioButtonMenuItem mi6 = new JRadioButtonMenuItem("宋体"); // 单选菜单项
        JRadioButtonMenuItem mi7 = new JRadioButtonMenuItem("楷体", true);
        JRadioButtonMenuItem mi8 = new JRadioButtonMenuItem("隶书");
        ButtonGroup bg = new ButtonGroup(); // 按钮组
        bg.add(mi6); // 3个单选菜单项加入同一个按钮组
        bg.add(mi7);
        bg.add(mi8);
        menuFile.add(mi6);
        menuFile.add(mi7);
        menuFile.add(mi8);
        menuFile.addSeparator();

        JCheckBoxMenuItem mi9 = new JCheckBoxMenuItem("粗体", true); // 复选菜单项
        JCheckBoxMenuItem mi10 = new JCheckBoxMenuItem("斜体", true);
        menuFile.add(mi9);
        menuFile.add(mi10);

        bar.add(menuFile); // 加菜单到菜单栏
        bar.add(new JMenu("编辑")); // 加另一个菜单(无任何菜单项)到菜单栏

        f.setJMenuBar(bar); // 设置窗口的菜单栏
        f.showMe();
    }
}