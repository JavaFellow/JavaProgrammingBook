package ch14;

public class ForNameDemo {
    public static void main(String[] args) {
        try {
            Class<?> c1 = Class.forName("java.lang.Integer"); // 必须使用完全限定名
            Class<?> c2 = Class.forName("ch07.layout.ChatFrame");
            Class<?> c3 = Class.forName("[D"); // Double型一维数组
            Class<?> c4 = Class.forName("[[[Ljava.lang.String;"); // String型三维数组

            System.out.printf("c1: %-24s", c1.getName());
            System.out.printf("c2: %-24s\n", c2.getName());
            System.out.printf("c3: %-24s", c3.getName());
            System.out.printf("c4: %-24s\n", c4.getName());

            Class<?> c5 = Class.forName("xyz.abc.ClassName"); // 抛出异常
            System.out.printf("c5: %-24s", c5.getName());
        } catch (ClassNotFoundException e) { // Checked型异常
            System.out.println("找不到名为 " + e.getMessage() + " 的类。");
        }
    }
}