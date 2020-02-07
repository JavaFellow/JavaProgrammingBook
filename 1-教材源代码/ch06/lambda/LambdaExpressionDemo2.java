package ch06.lambda;

@FunctionalInterface
interface InterfaceA { // 函数式接口
    int calc(int m, int n); // 唯一抽象方法
}

public class LambdaExpressionDemo2 { // 测试类
    public static void main(String[] args) {
        InterfaceA a = (m, n) -> m * n; // 将Lambda表达式赋给对应接口的引用

        /**** 通过接口引用显式调用其抽象方法 ****/
        System.out.print(a.calc(1, 2) + "\t");
        System.out.print(a.calc(1 + 2, 2 * 3) + "\t");
        System.out.print(a.calc(a.calc(1, 2), a.calc(3, 4)));
    }
}