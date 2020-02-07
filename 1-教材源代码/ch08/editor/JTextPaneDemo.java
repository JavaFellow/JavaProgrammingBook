package ch08.editor;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import ch07.BaseFrame;
import ch07.ImageFactory;

public class JTextPaneDemo {
    /**** 聊天消息、字体、字号 ****/
    String[] msgs = { "你对TOM说：", "[09:10:50]\n", "\t新年快乐！给你发了张贺卡，快看看吧！\n", "\nTOM对你说：", "[09:10:55]\n\t", "Thanks, U 2." };
    String[] fontName = { "仿宋", "Arial", "微软雅黑", "楷体_GB2312", "Georgia", "微软雅黑" };
    int[] fontSize = { 20, 12, 12, 16, 14, 20 };

    /**** 粗体、斜体、下划线、前景色、背景色 ****/
    boolean[] bold = { true, false, true, false, false, true };
    boolean[] italic = { false, true, false, true, false, true };
    boolean[] underline = { false, true, false, false, false, false };
    Color[] foreColor = { Color.RED, Color.DARK_GRAY, Color.BLUE, Color.MAGENTA, Color.BLACK, Color.WHITE };
    Color[] bgColor = { Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.GRAY };

    /**** 初始化文档内容 ****/
    void initDocument(JTextPane tp) throws BadLocationException {
        SimpleAttributeSet style; // 描述文字格式/风格的属性集合(如粗、斜体等)
        StyledDocument doc = tp.getStyledDocument(); // 得到文本面板对应的文档对象
        for (int i = 0; i < msgs.length; i++) {
            style = new SimpleAttributeSet(); // 重新构造属性集合
            StyleConstants.setFontFamily(style, fontName[i]); // 设置字体
            StyleConstants.setFontSize(style, fontSize[i]); // 设置字号
            StyleConstants.setBold(style, bold[i]); // 设置粗体
            StyleConstants.setItalic(style, italic[i]); // 设置斜体
            StyleConstants.setUnderline(style, underline[i]); // 设置下划线
            StyleConstants.setForeground(style, foreColor[i]); // 设置前景色
            StyleConstants.setBackground(style, bgColor[i]); // 设置背景色
            // 将文字插入到文档的指定位置(此处为最末尾)，此API声明抛出BadLocationException异常
            doc.insertString(doc.getLength(), msgs[i], style); //
        }
        tp.setCaretPosition(doc.getLength()); // 设置光标位置(此处为最末尾)
        tp.insertIcon(ImageFactory.create("smile.gif")); // 插入图片
        tp.setCaretPosition(37); // 设置光标位置(此处为文档中第37个字符之后)
        tp.insertComponent(new JButton("单击查看")); // 插入按钮
    }

    void init() throws BadLocationException {
        BaseFrame f = new BaseFrame("JTextPane 演示");

        JTextPane tp = new JTextPane(); // 构造文本面板对象
        JScrollPane sp = new JScrollPane(tp); // 将文本面板置于可滚动面板中
        sp.setLocation(5, 5);
        sp.setSize(420, 150);
        initDocument(tp); // 初始化文档内容

        f.add(sp);
        f.showMe();
    }

    public static void main(String[] args) throws BadLocationException {
        new JTextPaneDemo().init();
    }
}