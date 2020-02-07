package ch06.lambda;

interface Convertable {
    int convert(String s, int radix);
}

interface Comparable {
    int compare(String s);
}

interface Comparable2 {
    int compare(String a, String b);
}

interface Printable {
    void print(Object o);
}

interface StudentFactory {
    Student create(int age); // 注意返回类型必须是Student
}

public class MethodReferenceDemo { // 测试类
    /**** 测试数据 ****/
    static String sa = "China", sb = "America";
    static int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

    public static void main(String[] args) {
        /**** 引用静态方法，等价于：(s, r) -> Integer.valueOf(s, r) ****/
        Convertable m1 = Integer::valueOf;
        System.out.printf("1: %d\n", m1.convert("1F", 16));

        /**** 通过对象名引用实例方法，等价于：sb -> sa.compareTo(sb) ****/
        Comparable m2 = sa::compareTo;
        System.out.printf("2: %s %s %s\n", sa, m2.compare(sb) > 0 ? ">" : "<=", sb);

        /**** 通过类名引用实例方法，等价于：(sa, sb) -> sa.compareTo(sb) ****/
        Comparable2 m3 = String::compareTo;
        System.out.printf("3: %s %s %s\n", sa, m3.compare(sa, sb) > 0 ? ">" : "<=", sb);

        /**** 引用构造方法，等价于：age -> new Student(age) ****/
        StudentFactory m4 = Student::new;
        System.out.printf("4: age = %d\n\n", m4.create(18).age);

        /**** 通过对象名引用实例方法，第48行第2个方法引用等价于：o -> System.out.print(o) ****/
        Printable m;
        for (int i = 0; i < a.length; i++) {
            m = (i % 3 == 2) ? (System.out::println) : (System.out::print);
            m.print(a[i] + " ");
        }
    }
}