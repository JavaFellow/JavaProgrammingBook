public class ConstructorDemo { // 用以测试Person类中构造方法的测试类
    boolean isFirstPrint = true; // 是否首次调用print方法

    public static void main(String[] args) { // 程序入口
        // Person p = new Person(); // 非法：系统不会为Person类提供默认构造方法

        // 调用不同构造方法创建Person类的对象，并赋给Person类型的变量
        Person p1 = new Person("Tom");
        Person p2 = new Person("Andy", "100200200109081234");
        Person p3 = new Person("Chris", 24, "30040019990401000X");

        // 创建本测试类的对象demo，以调用其print方法。
        // 本测试类没有编写任何构造方法，则系统自动提供默认构造方法。
        ConstructorDemo demo = new ConstructorDemo();

        demo.print("P1", p1);// 以“对象名.方法名(实参表)”的形式调用对象的方法

        p1.setAge(30); // 修改p1对象的年龄
        demo.print("P1", p1);

        p2.name = "Jack"; // 以“对象名.字段名”的形式访问对象的字段
        p2.id = "200200198011084321"; // 修改p2对象的身份证
        p2.setAge(25);
        demo.print("P2", p2);

        demo.print("P3", p3);

        // 直接将创建的对象作为print方法的第2个实参，
        // 该对象没有赋给Person类型的变量，只能使用一次，称为“匿名对象”。
        demo.print("Anonymous", new Person("Joe"));

        System.out.println();
        p1.sleep(15);
        p1.sleep(30);
        p1.sleep(10);
    }

    // 打印形参p指定的Person对象的信息 (形参tag用作标记对象以便观察结果)
    void print(String tag, Person p) {
        if (isFirstPrint) { // 若首次打印，则打印表头
            System.out.printf("%-10s %-10s %-5s %s\n", "tag", "name", "age", "id");
            System.out.print("----------------------------------------------\n");
            isFirstPrint = false;
        }
        System.out.printf("%-10s %-10s %-5d %s\n", tag, p.name, p.age, p.id);
    }
}
