public class IfDemo {
    public static void main(String[] args) {
        int a = 1, b = 2;
        if (a < b)                         // true
            System.out.print("a<b\t"); // 执行
        if (a > b)                         // false
            System.out.print("a>b\t"); // 不执行
        if (a<b) {                         // true 
            System.out.print("+++\t"); // 执行
            System.out.print("---\t"); // 执行 (属于语句块) 
        }
        if (a>b)                            // false
            System.out.print("***\t");  // 不执行
            // 执行 (缩进对程序运行没有影响，下行不受第4个if控制) 
            System.out.print("///\t");
        if (a>b);                           // false，此if控制的是空语句。
            System.out.print("%%%");     //执行
    }
}
