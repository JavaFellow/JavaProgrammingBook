package ch14;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;

/**** JButton类间接实现了Serializable接口，因而本演示类是可序列化的 ****/
@SuppressWarnings("serial")
public class SuppressWarningsAnnotationDemo extends JButton {
    @SuppressWarnings("deprecation") // 忽略m1中已过时代码的警告
    public void m1() {
        Date d = new Date(113, 5, 2); // 调用了已过时的方法
        System.out.println(d.toString());
    }

    @SuppressWarnings(value = { "deprecation", "unused" })
    public void m2() {
        // 使用了已过时的类，且声明了变量names但从未使用。
        java.io.StringBufferInputStream names = new java.io.StringBufferInputStream("test");
    }

    @SuppressWarnings({ "static-access", "rawtypes", "unchecked" })
    public void m3() {
        System.out.println("abc".valueOf(3.14)); // valueOf是String类的静态方法
        List list = new ArrayList(); // 未指定泛型
        list.add("e1"); // 操作原始类型的容器对象
    }

    @SuppressWarnings(value = "unused")
    public void m4() {
        if (true) {
            System.out.println("YES");
        } else { // 此else控制的语句永远不可达
            System.out.println("NO");
        }
    }
}