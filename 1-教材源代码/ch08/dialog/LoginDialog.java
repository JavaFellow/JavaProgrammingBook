package ch08.dialog;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import ch07.ImageFactory;

public class LoginDialog extends JDialog { // 继承JDialog类
    JLabel nameLab = new JLabel("用户名：");
    JLabel pswLab = new JLabel("密　码：");
    JTextField nameTf = new JTextField();
    JPasswordField pswPf = new JPasswordField();
    JButton cancelBtn = new JButton("取消");
    JButton loginBtn = new JButton("登录");

    public LoginDialog(JFrame parent) { // 构造方法
        super(parent, "登录", true); // 显式调用父类构造方法，创建模态对话框
        setLayout(null); // 设置对话框为空布局
        nameLab.setSize(60, 20); // 设置各组件的大小及位置
        nameLab.setLocation(10, 10);
        nameTf.setSize(110, 20);
        nameTf.setLocation(70, 10);
        pswLab.setSize(60, 20);
        pswLab.setLocation(10, 40);
        pswPf.setSize(110, 20);
        pswPf.setLocation(70, 40);
        cancelBtn.setSize(60, 20);
        cancelBtn.setLocation(50, 70);
        loginBtn.setSize(60, 20);
        loginBtn.setLocation(120, 70);

        add(nameLab); // 加各组件到对话框
        add(nameTf);
        add(pswLab);
        add(pswPf);
        add(cancelBtn);
        add(loginBtn);

        setIconImage(ImageFactory.create("login.png").getImage()); // 设置对话框图标
    }
}