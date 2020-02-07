package ch06.nested;

public class StaticNestedClassDemo { // 外部类
    private int id = 001;
    private static String name = "Daniel";

    static class Person { // 静态嵌套类
        private String address = "AHPU";
        public String mail = "admin@gmail.com";
        public static int age = 33; // 静态嵌套类内可以定义静态字段

        public void display() {
            System.out.println(id); // 非法(不能直接访问外部类的非静态成员)
            System.out.println(name); // 合法(直接访问外部类的静态成员)
            System.out.println(address); // 合法(访问本类成员)
        }
    } // 静态嵌套类Person定义结束

    public void test() {
        display(); // 非法(外部类不能直接访问嵌套类的成员)
        Person.display(); // 非法(不能通过类名访问非静态成员)
        Person p = new Person();
        p.display(); // 合法(外部类通过对象访问嵌套类的非静态成员)
        System.out.println(address); // 非法(原因同第20行)
        System.out.println(mail); // 非法(原因同第20行)
        System.out.println(p.address); // 合法
        System.out.println(p.mail); // 合法
        System.out.println(Person.age); // 合法
    }
} // 外部类StaticNestedClassDemo定义结束

class AnotherClass { // 另一个顶层类
    void test() {
        Person p1 = new Person(); // 非法(Person不是AnotherClass类的嵌套类)
        StaticNestedClassDemo.Person p2 = new StaticNestedClassDemo.Person(); // 合法
    }
} // 顶层类AnotherClass定义结束
