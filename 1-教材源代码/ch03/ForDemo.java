public class ForDemo {
    public static void main(String[] args) {
        int f1 = 1, f2 = 1;                // 相邻的两项
        for (int i = 1; i <= 9; i++) {  // 循环9次 (每次求两项) 
            // 为对齐结果，使用了格式化打印方法，与C语言的
            // printf库函数类似，具体见第14章。
            System.out.printf("F%-2d=%-8d", 2 * i - 1, f1);
            System.out.printf("F%-2d=%-8d", 2 * i, f2);
            if (i % 3 == 0) {        // 每打印6项换行
                System.out.println();
            }
            f1 = f1 + f2;             // 计算下一项 (此行与下行不能交换顺序) 
            f2 = f2 + f1;             // 继续计算下一项
        }
    }
}
