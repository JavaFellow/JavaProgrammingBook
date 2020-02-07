package ch07.layout;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import ch07.BaseFrame;
import ch07.ImageFactory;

public class GridBagLayoutDemo {
    public static void main(String[] args) {
        new GridBagLayoutDemo().init();
    }

    void init() {
        BaseFrame f = new BaseFrame("GridBagLayout 演示");
        f.setLayout(new GridBagLayout()); // 设置网格包布局

        JLabel labFace = new JLabel(ImageFactory.create("face.png")); // 头像标签
        JLabel labReg = new JLabel("注册账号");
        JLabel labFindPsw = new JLabel("找回密码");
        JTextField tfId = new JTextField(); // 账号框
        JPasswordField tfPsw = new JPasswordField(); // 密码框
        JCheckBox cbRemPsw = new JCheckBox("记住密码");
        JCheckBox cbAutoLogin = new JCheckBox("自动登录");
        JButton btnExit = new JButton("关闭");
        JButton btnLogin = new JButton("登录");

        GridBagConstraints c = new GridBagConstraints(); // 网格包约束

        /**** 头像标签 ****/
        c.gridx = c.gridy = 0; // 所在网格
        c.gridheight = 3; // 占据3行
        f.add(labFace, c); // 以指定约束添加头像标签

        /**** 账号框 ****/
        c.gridx = 1; // 执行此行前gridy仍为0
        c.gridwidth = 2; // 占据2列
        c.gridheight = 1; // 之前修改了gridheight
        c.weightx = 1.0; // 获得所有水平额外空间
        c.fill = GridBagConstraints.HORIZONTAL; // 只允许改变水平大小
        c.insets = new Insets(0, 0, 4, 0); // 构造外部填充量(上、左、下、右)
        f.add(tfId, c);

        /**** 密码框 ****/
        c.gridy = 1; // gridx仍为1
        f.add(tfPsw, c); // 复用了之前的约束(不推荐)

        /**** 注册账号标签 ****/
        c = new GridBagConstraints(); // 重新构造网格包约束
        c.gridx = 3;
        c.gridy = 0;
        c.insets = new Insets(0, 0, 4, 0);
        f.add(labReg, c);

        /**** 找回密码标签 ****/
        c.gridy = 1;
        f.add(labFindPsw, c);

        /**** 记住密码复选框 ****/
        c.gridx = 1;
        c.gridy = 2;
        f.add(cbRemPsw, c);

        /**** 自动登录复选框 ****/
        c.gridx = 2;
        f.add(cbAutoLogin, c);

        /**** 关闭按钮 ****/
        c.gridx = 2;
        c.gridy = 3;
        c.anchor = GridBagConstraints.SOUTHEAST; // 按钮始终位于网格右下
        c.insets = new Insets(20, 0, 0, 5);
        f.add(btnExit, c);

        /**** 登录按钮 ****/
        c.gridx = 3;
        f.add(btnLogin, c);

        f.showMe();
    }
}