package ch08;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import ch07.BaseFrame;
import ch07.ImageFactory;

public class JOptionPaneDemo {
    public static void main(String[] args) {
        BaseFrame f = new BaseFrame("JOptionPane 演示");
        ImageIcon icon = ImageFactory.create("mail.png");
        String[] btnsText = { "好，删除！", "不，以后再说。" }; // 按钮文字
        String[] groups = { "同事", "家人", "同学" }; // 下拉列表文字

        // 消息对话框
        JOptionPane.showMessageDialog(f, "邮件发送失败。", "发送邮件", JOptionPane.ERROR_MESSAGE);
        // 消息对话框(自定义图标)
        JOptionPane.showMessageDialog(f, "收到一封新邮件。", "收到邮件", JOptionPane.INFORMATION_MESSAGE, icon);
        // 确认对话框
        JOptionPane.showConfirmDialog(f, "确认要删除该邮件吗？", "删除邮件", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        // 选项对话框(自定义按钮文字)
        JOptionPane.showOptionDialog(f, "确认要删除该邮件吗？", "删除邮件", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, btnsText, btnsText[1]);
        // 输入对话框(文本框)
        JOptionPane.showInputDialog(f, "请输入收件人地址：", "name@gmail.com");
        // 输入对话框(下拉列表)
        JOptionPane.showInputDialog(f, "请选择联系人分类：", "选择分类", JOptionPane.PLAIN_MESSAGE, null, groups, groups[1]);

        f.showMe();
    }
}
