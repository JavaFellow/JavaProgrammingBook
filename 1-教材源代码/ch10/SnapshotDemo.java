package ch10;

import java.awt.BorderLayout;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**** 提供保存快照和恢复快照方法的类 ****/
class Snapshot {
    String file = "D:/Snapshot.dat"; // 快照文件

    void save(MyFrame f) { // 写出快照
        try (FileOutputStream fout = new FileOutputStream(file); ObjectOutputStream out = new ObjectOutputStream(fout)) {
            out.writeObject(f); // 序列化
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("写出快照时发生了I/O错误！");
        }
    }

    MyFrame load() { // 读入快照
        MyFrame f = null; // 存放恢复的窗口
        try (FileInputStream fin = new FileInputStream(file); ObjectInputStream in = new ObjectInputStream(fin)) {
            f = (MyFrame) in.readObject(); // 反序列化并造型
        } catch (ClassNotFoundException | IOException e) { // readObject方法可能抛出第1个异常
            System.out.println("读入快照时发生了I/O错误！");
        }
        return f; // 返回窗口对象
    }
}

/**** 继承窗口类并实现Serializable接口，以便实例化此类的对象 ****/
class MyFrame extends JFrame implements Serializable {
    JButton saveBtn = new JButton("保存快照");
    JButton loadBtn = new JButton("恢复快照");
    JPanel panel = new JPanel();
    JTextArea ta = new JTextArea("初始文字");
    JScrollPane sp = new JScrollPane(ta);
    transient Snapshot snapshot = new Snapshot(); // 不序列化此字段

    public void setSnapshot(Snapshot snapshot) { // snapshot字段的setter
        this.snapshot = snapshot;
    }

    MyFrame() { // 构造方法
        init();
        saveBtn.addActionListener(e -> snapshot.save(this)); // 点击保存快照按钮
        loadBtn.addActionListener(e -> { // 点击恢复快照按钮
            MyFrame f = snapshot.load();
            f.setSnapshot(new Snapshot()); // 此行不可少(因未序列化MyFrame的snapshot字段)
            f.setVisible(true); // 显示恢复的窗口
            this.dispose(); // 关闭原来的窗口
        });
    }

    void init() { // 初始化窗口内的组件
        setLayout(new BorderLayout());
        ta.setLineWrap(true);
        add(sp, BorderLayout.CENTER);
        panel.add(saveBtn);
        panel.add(loadBtn);
        add(panel, BorderLayout.SOUTH);
        setTitle("程序快照机");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(220, 140);
    }
}

public class SnapshotDemo { // 测试类
    public static void main(String[] args) {
        new MyFrame().setVisible(true);
    }
}