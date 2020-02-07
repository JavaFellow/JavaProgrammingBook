public class DoWhileDemo {
    public static void main(String[] args) {
        long n = 987654321;        // 要逆序输出的整数
        do {
            System.out.print(n % 10);   // 打印个位数
            n /= 10;                        // 整除 (去掉个位数) 
        } while (n != 0);                 // n被除到0时，结束循环。
    }
}
