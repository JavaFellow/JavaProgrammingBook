package ch06.nested;

public class LocalInnerClassDemo { // 外部类
    private int x = 10; // 外部类的字段

    public void test() {
        int y = 20; // 局部变量

        class Inner { // 局部内部类
            private int a = 40; // 局部内部类的字段

            public void print() {
                System.out.println(x); // 合法(可以直接访问外部类的成员)
                System.out.println(y); // 合法(可以直接访问所在方法的局部变量)
                y = 20; // 非法(不能修改所在方法的局部变量)
            }
        }

        Inner innerObj = new Inner(); // 合法(同一方法体内可见Inner类)
        System.out.println(innerObj.a); // 合法
    }

    public void test2() {
        Inner innerObj = new Inner(); // 非法(此处Inner类不可见)
    }
}