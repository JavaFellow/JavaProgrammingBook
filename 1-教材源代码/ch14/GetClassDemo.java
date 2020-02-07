package ch14;

import java.util.HashSet;

enum BOOL { // 枚举
    YES, NO
};

public class GetClassDemo {
    public static void main(String[] args) {
        Class<?>[] classes = new Class[10];
        classes[0] = "Hi".getClass(); // 字符串
        classes[1] = System.out.getClass(); // I/O流
        classes[2] = new GetClassDemo().getClass(); // 当前类
        classes[3] = BOOL.NO.getClass(); // 枚举
        classes[4] = new int[5].getClass(); // 基本类型的一维数组
        classes[5] = new long[2][5].getClass(); // 基本类型的二维数组
        classes[6] = new String[5].getClass(); // 对象数组
        classes[7] = new HashSet<String>().getClass(); // 泛型容器
        classes[8] = classes[0].getClass(); // Class
        classes[9] = classes.getClass(); // Class数组

        for (int i = 0; i < classes.length / 2; i++) {
            System.out.printf("%-2s: %-24s", 2 * i + 1, classes[i].getName());
            System.out.printf("%-2s: %-24s\n", 2 * i + 2, classes[i + 1].getName());
        }
    }
}