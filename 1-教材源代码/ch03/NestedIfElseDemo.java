public class NestedIfElseDemo {
    public static void main(String[] args) {
        int a = 1, b = 2, c = 3, d = 4;
        if (a < b)                         // true
            if (c > d)                     // false
                System.out.print("A");
            else
                System.out.print("B");  // 打印B

        if (a < b) {                      // true
            if (c < d)                     // true
                System.out.print("C");  // 打印C
        } else
            System.out.print("D");

        // 依次判断多个条件。一旦某个条件为true，执行完相应语句或语句块后，
        // 退出整个结构。若所有条件都不成立，则执行最后的else控制的语句或语句块。
        // 为方便读者理解，采用了规范的缩进 (因过深，故实际常缩进为第31~38的格式)。
        if (a > b)                             // false
            System.out.print("E");
        else 
            if (a > c)                         // false
                System.out.print("F");
            else 
                if (c < d)                     // true
                    System.out.print("G");  // 打印G
                else
                    System.out.print("H");
        
        // 下面的结构与上一结构完全等价
        if (a > b)                           // false
            System.out.print("E");
        else if (a > c)                     // false
            System.out.print("F");
        else if (c < d)                     // true
            System.out.print("G");        // 打印G
        else
            System.out.print("H");
    }
}
