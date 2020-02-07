public class WhileDemo1 {
    public static void main(String[] args) {
        int factorial = 1;    // 存放累乘积的变量初始化为1
        int n = 6, i = 2;     // i作为循环变量 (也称循环计数器) 
        while (i <= n) {      // 计算2*...*n
            factorial *= i;   // 累乘
            i++;                 // 修改i，以便下一次累乘。
        }
        System.out.println(n + " 的阶乘 = " + factorial);
    }
}
