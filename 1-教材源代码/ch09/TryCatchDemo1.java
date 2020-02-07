package ch09;

public class TryCatchDemo1 {
    public static void main(String[] args) {
        System.out.println("----try-catch结构演示----");
        try {
            System.out.println("本行语句不会发生任何异常，也可以放在try中。");
            System.out.println("10/0=" + 10 / 0); // 会发生异常
            System.out.println("上行语句发生了异常，我不会被打印。");
        } catch (ArithmeticException e) { // 捕获和处理异常
            System.out.println("做除法运算时，发生了算术异常(数为0)！");
        }
        System.out.println("我不属于try-catch结构，发不发生异常与我无关。");
    }
}