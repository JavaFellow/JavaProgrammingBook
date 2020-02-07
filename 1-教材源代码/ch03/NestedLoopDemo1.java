public class NestedLoopDemo1 {
    public static void main(String[] args) {
        int a, b, c;       // 分别存放大、中、小马的匹数
        System.out.println("大马\t中马\t小马");
        System.out.println("--------------------");
        for (a = 0; a <= 33; a++) {     // 穷举 (大马最多33匹) 
            for (b = 0; b <= 50; b++) {     // 中马最多50匹
                c = 100 - a - b;               // 计算小马匹数
                // 若正好100担 (注意c/2是整除，故应加上c是2的倍数的限制) 
                if (3 * a + 2 * b + c / 2 == 100 && c % 2 == 0) {
                    System.out.println(a + "\t" + b + "\t" + c);
                }  // if语句结束
            }  // 内层for语句结束
        }  // 外层for语句结束
    }
}
