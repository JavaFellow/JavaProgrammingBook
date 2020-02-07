package ch05;

public class FinalAndStaticDemo {
    static final int MIN = 1; // static经常与final组合使用
    final static int MAX = 10; // static与final的顺序可以交换
    int m; // 实例字段(或称对象字段)，每个对象的实例字段都有独立的内存空间，彼此互不影响。
    static int n = 5; // 静态字段(或称类字段)，供所有对象共享。
    private static FinalAndStaticDemo demo1; // 私有静态字段

    /**** 静态语句块(位于方法外) ****/
    static {
        System.out.print("执行静态语句块1。");
        demo1 = new FinalAndStaticDemo(10); // 静态语句块中可以调用构造方法
    }

    FinalAndStaticDemo(int m) { // 构造方法
        this.m = m;
    }

    private void m1() { // 实例方法(或称对象方法)
        System.out.print("执行方法m1。");
        m2(); // 非静态方法中可以访问静态方法和字段
        m3(); // 非静态方法中可以访问非静态方法和字段
    }

    private static void m2() { // 静态方法(或称类方法)
        System.out.print("执行方法m2。");
    }

    private void m3() { // 实例方法
        System.out.print("执行方法m3。");
        final FinalAndStaticDemo d = new FinalAndStaticDemo(5); // final常量
        // d = new FinalAndStaticDemo(5); // 语法错误(不能修改final常量d)
        d.m = 40; // 但可以修改d指向对象的字段
    }

    /**** main方法总是静态的，以便虚拟机无需创建对象便能调用该方法启动程序 ****/
    public static void main(String[] args) {
        m2(); // 静态方法中可以访问静态方法和字段

        FinalAndStaticDemo demo2 = new FinalAndStaticDemo(20);
        demo2.m1(); // 静态方法中不能直接访问非静态方法和字段，必须通过对象。
        demo2.m2(); // 可以通过对象访问静态方法和字段(但不推荐)

        demo1.m = demo1.m + 1; // 修改实例字段(不会影响其他对象)
        System.out.print("\ndemo1.m=" + demo1.m + "\t"); // 打印11
        System.out.println("demo2.m=" + demo2.m); // 打印20

        demo1.n = demo1.n + 1; // 修改类字段(会影响其他对象)
        System.out.print("demo1.n=" + demo1.n + "\t"); // 打印6
        System.out.println("demo2.n=" + demo2.n); // 打印6
    }

    /**** 类可以包含多个静态语句块，依次执行 ****/
    static {
        System.out.print("执行静态语句块2。\n");
    }
}