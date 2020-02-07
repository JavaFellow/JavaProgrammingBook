package ch08;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import ch07.BaseFrame;

// 继承第8章的BaseFrame类，并实现ItemListener接口（用于下拉列表的改变事件）
public class SkinSwitcher extends BaseFrame implements ItemListener {
    // 4种观感
    String[] skinNames = { "Metal", "Windows", "Motif", "Nimbus" };
    // 4种观感对应的完整类名
    String[] skinClasses = { "javax.swing.plaf.metal.MetalLookAndFeel", "com.sun.java.swing.plaf.windows.WindowsLookAndFeel", "com.sun.java.swing.plaf.motif.MotifLookAndFeel",
            "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel" };
    JComboBox skinComboBox = new JComboBox(skinNames);// 下拉列表（供用户选择观感）

    SkinSwitcher() {// 构造方法（父类BaseFrame不含无参构造方法）
        super("动态换肤");
        setLayout(new FlowLayout());
        initComponents();
        showMe();
    }

    public static void main(String[] args) {// 程序入口
        new SkinSwitcher();
    }

    void initComponents() {// 构造测试组件
        skinComboBox.addItemListener(this);// 增加事件监听器
        JComponent[] comps = new JComponent[13];
        comps[0] = new JLabel("标签");
        comps[1] = new JButton("按钮");
        comps[2] = new JRadioButton("单选按钮");
        comps[3] = new JCheckBox("复选按钮");
        comps[4] = new JTextField("文本框");
        comps[5] = new JScrollPane(new JTextArea("文本区"));
        JProgressBar pb = new JProgressBar(0, 30);
        pb.setValue(24);
        comps[6] = pb;
        comps[7] = new JScrollBar(JScrollBar.HORIZONTAL);
        comps[8] = new JSlider();
        comps[9] = new JList();
        comps[10] = skinComboBox;
        comps[11] = new JScrollPane(new JTable(3, 3));
        comps[12] = new JScrollPane(new JTree());

        for (Component c : comps)
            add(c); // 添加到窗口
    }

    public void itemStateChanged(ItemEvent e) {// 改变观感
        try {
            // 设置观感
            UIManager.setLookAndFeel(skinClasses[skinComboBox.getSelectedIndex()]);
            SwingUtilities.updateComponentTreeUI(this);// 更新界面
        } catch (UnsupportedLookAndFeelException ex) {
            System.out.println("选择的观感不受支持。");
        } catch (ClassNotFoundException ex) {
            System.out.println("找不到选择的观感类。");
        } catch (InstantiationException ex) {
            System.out.println("初始化观感时出错。");
        } catch (IllegalAccessException ex) {
            System.out.println("选择的观感不可访问。");
        }
    }
}
