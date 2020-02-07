import java.util.Scanner;   // 引入Scanner类供本程序使用，具体见第6章。

public class BreakDemo {
    public static void main(String[] args) {
        // 构造读入器对象以方便程序在运行时刻输入数据，具体见第11章。
        Scanner scanner = new Scanner(System.in);
        int n;         // 待判断是否为素数的数
        int i = 2;    // 除数从2开始
        System.out.print("请输入一个整数：");    // 打印提示文字
        n = scanner.nextInt();    // 等待键盘输入一个int型数据并赋值给n
        for (; i < n; i++) {       // 用2~n-1逐一试探 (即穷举法) 
            if (n % i == 0) {      // 若某次能除尽
                System.out.println(n + "不是素数。");
                break;    // 结束所在的for语句 (无需再除)，跳至第19行继续执行。
            }
        }
        // 若i被加到了n，说明前面的for语句是由第2个表达式 (i<n) 不成立
        // 而结束的，即2~n-1都不能将n除尽，则n是素数。
        if (i == n) {
            System.out.println(n + "是素数。");
        }
    }
}
