package ch13;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class TextSearcher extends JFrame {
    public TextSearcher() {
        init();
    }

    private void init() {
        JTextPane tp = new JTextPane(); // 待搜索的文本面板
        JPanel p = new JPanel();
        JTextField tf = new JTextField(12); // 关键词文本框
        JButton btn = new JButton("搜索");
        p.add(new JLabel("搜索："));
        p.add(tf);
        p.add(btn);

        setLayout(new BorderLayout());
        add(new JScrollPane(tp), BorderLayout.CENTER);
        add(p, BorderLayout.SOUTH);

        btn.addActionListener(e -> { // 处理按钮点击事件
            String keyword = tf.getText().trim(); // 获得关键词
            int length = keyword.length(); // 关键词长度
            if (length < 1) {
                return;
            }

            int count = 0; // 匹配计数
            String content = tp.getText(); // 获得待搜索的文本
            int index = content.indexOf(keyword); // 第1次搜索
            int start; // 文本面板选中内容的开始索引

            tp.requestFocus();
            while (index != -1) { // 找到
                start = index - count * (length - 1);
                tp.select(start, start + length); // 选中找到的关键词
                tp.insertComponent(new JButton(keyword)); // 每次用一个按钮替换一个关键词
                index = content.indexOf(keyword, index + length); // 继续搜索
                count++;
            }
            setTitle("匹配到 " + count + " 项");
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 200);
        setVisible(true);
    }

    public static void main(String args[]) {
        new TextSearcher().init();
    }
}