package ch05;

import java.util.Date; // 引入日期类

public class GCDemo {
    public static void main(String[] args) {
        // 判断首个命令行参数是否为GC
        boolean gc = args.length > 0 && args[0].equalsIgnoreCase("GC");

        Runtime rt = Runtime.getRuntime(); // 获得运行时环境
        System.out.println("循环前可用内存：" + rt.freeMemory() / 1024 + " KB");

        final int TOTAL = 100000; // 循环总次数
        Date[] ds = new Date[TOTAL]; // 初始化数组

        for (int i = 0; i < TOTAL; i++) {
            ds[i] = new Date(); // 初始化数组元素
            process(ds[i]); // 处理日期对象

            // ds[i] = null; // 将使用完的对象显式赋为null

            if (gc && (i % 9999 == 0)) { // 每循环10000次请求一次垃圾回收
                System.gc();
            }

            if (i == 80000 - 1) { // 第80000次循环
                System.out.println("第80000次循环时可用内存：" + rt.freeMemory() / 1024 + " KB");
                break;
            }
        }
    }

    private static void process(Date d) {
        // ... // 处理日期对象d
    }
}
