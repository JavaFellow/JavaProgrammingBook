public class WhileDemo2 {
    public static void main(String[] args) {
        double pi = 0;           // 存放累加和的变量初始化为0
        double item = 1;        // 当前项 (含符号，第1项为1) 
        int deno = 1;            // 当前项的分母 (第1项分母为1) 
        int sign = 1;            // 当前项的符号 (第1项符号为正) 
        // 调用了Math类的abs方法求当前项的绝对值
        while (Math.abs(item) > 1e-6) {   // 与指数形式的浮点数进行比较
            pi += item;       // 累加
            sign = -sign;     // 计算下一项的符号 (正负交替) 
            deno += 2;        // 计算下一项的分母
            item = sign * 1.0 / deno;    // 计算下一项 (注意sign/deno为整除) 
        }
        pi *= 4;        // 公式计算的是π/4
        System.out.print("PI = " + pi + "   满足要求的最后一项 = ");
        // while语句结束后，item是满足要求的最后一项的下一项，故要重新计算其前一项
        System.out.print((-sign) * 1 + "/" + (deno - 2));
    }
}
