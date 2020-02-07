package ch06.nested;

class OuterClass { // 外部类
    private int x = 100; // 私有字段

    class InnerClass { // 内部类InnerClass
        private int y = 50;
        static final int m = 2; // 合法(可以在内部类中定义final的静态字段)
        static int n = 1; // 非法(不能在内部类中定义非final的静态字段)

        private void display() {
            System.out.println(x); // 合法(内部类中可以直接访问外部类的私有成员)
            System.out.println(y); // 合法
            System.out.println(this.x); // 非法(此处的this指InnerClass而非OuterClass类的对象)
            System.out.println(this.y); // 合法
        }
    } // 内部类InnerClass定义结束

    class InnerClass2 { // 内部类InnerClass2
        InnerClass inner = new InnerClass();

        public void show() {
            System.out.println(y);// 非法(必须通过内部类的对象访问其非静态成员)
            System.out.println(InnerClass.m); // 合法(通过内部类的类名访问其静态字段)
            System.out.println(inner.y); // 合法(可以在内部类外访问内部类的私有成员)
            inner.display(); // 合法
        }
    } // 内部类InnerClass2定义结束

    void test() { // 外部类的方法
        InnerClass inner = new InnerClass();
        System.out.println(y); // 非法
        System.out.println(inner.y); // 合法
        inner.display(); // 合法

        InnerClass2 inner2 = new InnerClass2();
        inner2.show(); // 合法
    }
} // 外部类OuterClass定义结束

public class InnerClassDemo { // 顶层类
    public static void main(String[] args) {
        OuterClass outer = new OuterClass(); // 创建外部类对象
        outer.test(); // 合法

        OuterClass.InnerClass2 inner = outer.new InnerClass2(); // 创建内部类对象
        inner.show(); // 合法
    }
} // 顶层类定义结束
