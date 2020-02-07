import java.util.Scanner;

public class NestedLoopDemo2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;        // 待求解的数
        int i = 2;   // 因子从2开始
        System.out.print("请输入一个整数：");
        n = scanner.nextInt();
        System.out.print(n + " = ");
        while (n > 1) {        // 求得最后一个素因子后，n被自除到了1。
            if (n % i == 0) {  // 判断i是否是n的因子
                int j = 2;
                for (; j < i; j++) {   // 判断i是否是素数
                    if (i % j == 0) {
                        break;            // 结束for语句 (跳至第19行继续执行) 
                    }
                } // for结束
                if (j == i) {            // 若成立则i是素数
                    System.out.print(i + "*");   // 打印素因子i
                    n /= i;         // 每求得一个素因子，将n自除该素因子。
                    i = 2;          // 求得一个素因子后，下次继续从2开始试探。
                }
            } else {
                i++;     // i不是n的因子，继续试探下一个数。
            }
        } // while结束
        System.out.print("\b ");   // 抹去最后一个*字符 (注意\b后有一个空格) 
    }
}
