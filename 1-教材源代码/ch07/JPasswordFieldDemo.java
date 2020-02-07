package ch07;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPasswordField;

public class JPasswordFieldDemo {
    public static void main(String[] args) {
        BaseFrame f = new BaseFrame("JPasswordField 演示");

        String[] labStrs = { "默认密码框：", "指定回显字符(西文)：", "指定回显字符(中文)：", "密码可见：" };
        JLabel[] labs = new JLabel[labStrs.length]; // 标签数组

        String[] pswStrs = { "admin", "admin", "admin", "我是密码" }; // 初始密码(可含中文)
        JPasswordField[] pfs = new JPasswordField[pswStrs.length]; // 密码框数组

        f.setLayout(new FlowLayout(FlowLayout.LEFT));// 设置窗口布局为左对齐的流式布局
        for (int i = 0; i < pfs.length; i++) {
            labs[i] = new JLabel(labStrs[i]); // 构造标签
            pfs[i] = new JPasswordField(pswStrs[i], 10); // 构造密码框
            f.add(labs[i]); // 加标签到窗口
            f.add(pfs[i]); // 加密码框到窗口
        }

        pfs[1].setEchoChar('*'); // 设置回显字符(西文)
        pfs[2].setEchoChar('★'); // 设置回显字符(中文)
        pfs[3].setEchoChar('\u0000'); // 取消回显字符，原样显示

        f.showMe();
    }
}
