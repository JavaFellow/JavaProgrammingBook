package ch05;

import java.lang.Integer; // 系统会自动引入java.lang包下的类，故此行可以省略
import java.util.Date;
import javax.swing.*; // 引入javax.swing包下的所有类，不推荐
import javax.swing.border.*; // 上行不会引入swing的子包 (如border) 下的类，故要单独引入
import java.awt.Color;
import ch05.demo.PackageDemo; // 引入自己定义的类

public class ImportDemo {
    Integer i = new Integer(5);
    Object o = new Object(); // Object类位于java.lang包下，无需引入
    Date d1 = new Date(); // java.util包下的Date类

    // java.sql包下的Date类，与java.util包下的Date类重名，故使用完全限定名
    java.sql.Date d2 = new java.sql.Date(0);

    // javax.swing包下的JButton类
    JButton b = new JButton("确定按钮");

    // javax.swing.border包下的LineBorder类
    LineBorder border = new LineBorder(Color.BLUE);

    // ch05.demo包下的PackageDemo类
    PackageDemo demo = new PackageDemo();
}
