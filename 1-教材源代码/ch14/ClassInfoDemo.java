package ch14;

import java.util.ArrayDeque;
import java.util.Deque;

public class ClassInfoDemo {
    public static void main(String[] args) {
        String className = "javax.swing.JFrame"; // 完全限定名
        Class<?> cls = null;
        try {
            cls = Class.forName(className);
        } catch (ClassNotFoundException e) {
            System.out.println("找不到名为 " + e.getMessage() + " 的类。");
            System.exit(-1);
        }

        System.out.printf("类：%s.%s\n", cls.getPackage().getName(), cls.getSimpleName());
        System.out.print("实现的接口：");
        for (Class<?> i : cls.getInterfaces()) { // 得到实现的所有接口
            System.out.print(i.getSimpleName() + " ");
        }

        /**** 用栈(实际为双端队列)存放父类，直至Object类(最先输出) ****/
        Deque<Class<?>> stack = new ArrayDeque<>();
        stack.push(cls); // 压入cls

        Class<?> parent = cls.getSuperclass(); // 得到cls的直接父类
        while (parent != null) { // 若父类存在
            stack.push(parent); // 压入父类
            parent = parent.getSuperclass(); // 继续得到父类的父类(直至根类Object)
        }

        System.out.println("\n继承树(上层为父类)：");
        int level = 0; // 继承深度
        while (!stack.isEmpty()) { // 栈非空
            Class<?> c = stack.pop(); // 弹出栈顶
            for (int i = 0; i < 4 * (2 * level - 1); i++) { // 控制缩进
                System.out.print(" ");
            }
            if (level > 0) {
                System.out.print("|__ ");
            }
            System.out.println(c.getName()); // 输出完整类名
            level++;
        }
    }
}