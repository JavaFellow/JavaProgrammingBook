public class BitShiftDemo {
    public static void main(String[] args) {
        int a = 3, b;
        b = a << 1;          // b=6，a不变
        printBits(a);
        printBits(b);
        a = a << 4;          // a=3*16=48
        printBits(a);
        a = -0xFFFF;        // a=-65535
        printBits(a);
        a >>= 1;             // a=-32768
        printBits(a);
        b = a;              // b=-32768
        a >>>= 24;         // 将a当做无符号数右移24位，a=255
        printBits(a);
        a = b;              // a=-32768
        a >>>= 56;         // 56的低5位为24 (即56%32)，故与第14行等价
        printBits(a);
        a <<= -126;        // -126 (补码) 的低5位为2，故相当于将a*4
        printBits(a);
    }

    static void printBits(int n) { // 打印n的二进制形式的方法 (详见第6章) 
        int mask = 0x80000000;       // 做掩码用，最高位=1，低31位均为0
        int i = 1;                      // 循环计数器
        System.out.print(n + "\t→ ");
        while (i <= 32) {     // 循环32次 (int型占32位)，详见第4章
            // n与mask按位与，结果是否为0 (32位均为0) 取决于n的最高位
            // 若结果为0 (说明n的最高位为0)，则打印0，否则 (n的最高位为1) 打印1
            System.out.print((n & mask) == 0 ? "0" : "1");
            // 每4位打印一个逗号以分隔二进制数 (最后一个逗号不打印) 
            System.out.print((i % 4 == 0) && (i != 32) ? "," : "");
            mask >>>= 1;         // 修改掩码 (高位的1向右移)，以测试n的下一位
            i++;                   // 修改循环计数器
        }
        System.out.println();  // 注意此行不受循环控制
    }
}
