public class MethodDemo {
    static void doNothing() { // 不返回任何值，且方法体为空。
    }

    public static void main(String[] args) { // 入口方法
        int a = 2, b = 4, c = 6;
        long max;

        // 直接调用位于main之后的方法，并将调用结果作为表达式的一部分。
        max = getMax(a, b); // a、b为实参 (b的值会被自动转为long型)
        System.out.print("max(a, b)=" + max + "   ");
        max = getMax(a * b, b); // 表达式作为实参
        System.out.print("max(a*b, b)=" + max + "   ");

        // 方法调用作为实参，因getMax的第一个形参要求是int型，
        // 而对应的实参是long型，系统无法自动转换，故需要强制转换。
        max = getMax((int) getMax(a, b * b), 8 + c);
        System.out.print("max(a, b*b, 8+c)=" + max);
        doNothing(); // 调用无参方法
    }

    static long getMax(int a, long b) { // 被调方法
        if (a > b) {
            return (a); // 结束getMax方法，并将a的值带回，等价于 return a;
        }
        return b; // 确保每条分支都返回值，请思考此行为何可以不放在else结构中？
    }
}
