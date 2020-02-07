package ch13;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class RegisteValidation extends JFrame {
    void init() {
        String[] labTexts = { "用户名称", "登录密码", "确认密码", "手机号码", "E-mail" };
        int count = labTexts.length;
        JLabel[] labs = new JLabel[count];
        JTextField[] tfs = new JTextField[count];
        JPanel[] panels = new JPanel[count];

        setLayout(new GridLayout(count + 1, 0));
        for (int i = 0; i < count; i++) {
            labs[i] = new JLabel(labTexts[i]);
            tfs[i] = (i == 1 || i == 2) ? new JPasswordField(16) : new JTextField(16);
            panels[i] = new JPanel(new FlowLayout(FlowLayout.TRAILING));
            panels[i].add(labs[i]);
            panels[i].add(tfs[i]);
            add(panels[i]);
        }

        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.TRAILING));
        JButton btnOk = new JButton("注册");
        btnPanel.add(btnOk);
        add(btnPanel);

        String[] regExps = { "^\\w{6,12}$", "^\\w{6,12}$", "^\\w{6,12}$", "^[1][3-9][0-9]{9}$", "^[\\w-]+(\\.[\\w-]+)*@[\\w-]+(\\.[\\w-]+)+$" };
        String[] errors = { "只能使用字母和数字，且长度必须介于6至12", "格式错误。" };
        btnOk.addActionListener(e -> {
            String msg;
            int i = 0;
            for (; i < count; i++) { // 校验各输入项格式
                String input = tfs[i].getText().trim();
                if (!Pattern.matches(regExps[i], input)) { // 不匹配
                    msg = "【" + labTexts[i] + "】" + (i <= 2 ? errors[0] : errors[1]);
                    JOptionPane.showMessageDialog(this, msg, "错误", JOptionPane.WARNING_MESSAGE);
                    tfs[i].requestFocus();
                    tfs[i].selectAll();
                    break;
                }
            }
            if (i == count && !tfs[2].getText().trim().equals(tfs[1].getText().trim())) {
                JOptionPane.showMessageDialog(this, "确认密码必须与登录密码一致。", "错误", JOptionPane.WARNING_MESSAGE);
                tfs[2].requestFocus();
                tfs[2].selectAll();
            }
        });

        setTitle("用户注册校验");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(270, 250);
        setVisible(true);
    }

    public static void main(String[] args) {
        new RegisteValidation().init();
    }
}