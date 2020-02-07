package ch09;

public class NestedTryCatchDemo {
    public static void main(String[] args) {
        try {
            try { // 位于try块中的try-catch结构
                int a = 2 / 0;
            } catch (ArithmeticException e) {
                System.out.println("计算a时除数为零！");
            }
            int b = 2 / 0;
            System.out.println("********");
        } catch (ArithmeticException e) {
            System.out.println("计算b时除数为零！");
            try { // 位于catch块中的try-catch-finally结构
                System.out.println("^^^^^^^^");
                int c = 2 / 0;
            } catch (ArithmeticException ex) {
                System.out.println("计算c时除数为零！");
            } finally {
                try { // 位于finally块中的try-catch结构
                    System.out.println("%%%%%%%%");
                    int d = 2 / 0;
                    System.out.println("@@@@@@@@");
                } catch (ArithmeticException ex) {
                    System.out.println("计算d时除数为零！");
                }
            }
            System.out.println("########");
        }
        System.out.println("~~~~~~~~");
    }
}