public class ContinueDemo {
    public static void main(String[] args) {
        int a, b, c;       // 分别存放百、十、个位。
        System.out.print("所有的水仙花数：");
        for (int n = 100; n < 1000; n++) {    // 穷举
            c = n % 10;                            // 个位
            b = n / 10 % 10;                      // 十位
            a = n / 100;// 百位
            if (a * a * a + b * b * b + c * c * c != n) { // 若不相等
                continue;     // 直接试探下一个数 (略过本行之后的循环体) 
            }
            // 本行属于循环体。能执行到本行，说明前面的if条件不成立 (即相等)。
            System.out.print(n + "  ");
        }
    }
}
