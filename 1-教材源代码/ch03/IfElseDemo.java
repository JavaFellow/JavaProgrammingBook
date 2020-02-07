public class IfElseDemo {
    public static void main(String[] args) {
        int a = 1, b = 2;
        if (a > b)                         // false
            System.out.print("a>b\t"); // 1条语句可以不加花括号
        else
            System.out.print("a<=b\t");// 执行 (此行受else控制) 

        if (a < b) {                       // true
            System.out.print("+++\t"); // if与else之间的多条语句必须加花括号
            System.out.print("---\t");
        } else;                             // 加了分号并不会有语法错误
            System.out.print("***\t");  // 执行 (此行不受else控制) 

        if (a > b)                         // false
            System.out.print("@@@\t");
        else {
            System.out.print("%%%\t");  // else控制多条语句也必须加花括号
            System.out.print("!!!\t");
        }
    }
}
