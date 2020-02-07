public class BreakWithLabelDemo {
    public static void main(String args[]) {
        final int LIMIT = 40;                      // 星号数上限
        int i = 1, j;
        int total = 0;                              // 已打印的星号数
        OUTTER: while (true) { // 外层循环 (加了标号) 
            for (j = 1; j <= 2 * i - 1; j++) { // 内层循环
                System.out.print("*");
                if (++total == LIMIT) {          // 到达上限
                    // 结束外层循环 (注意下行受内层循环控制) 
                    break OUTTER;
                }
            }
            System.out.println();                // 换行
            i++;
        }
    }
}
