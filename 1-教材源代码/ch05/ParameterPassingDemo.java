package ch05;

class Student { // 下面的测试类将使用此类
    private int age;

    public int getAge() { // age的getter
        return age;
    }

    public void setAge(int age) { // age的setter
        this.age = age;
    }

    public Student(int age) { // 构造方法
        this.age = age;
    }
}

public class ParameterPassingDemo { // 测试类(也是主类)
    public static void main(String[] args) {
        ParameterPassingDemo demo = new ParameterPassingDemo(); // 创建测试类的对象
        int a = 2; // 调用m1时作为实参
        Student s1 = new Student(18); // 调用m2时作为实参

        /**** 调用m1 ****/
        System.out.print("m1-->\t调用前：a=" + a + "\t");
        demo.m1(a);
        System.out.println("\t调用后：a=" + a); // a未变

        /**** 调用m2 ****/
        System.out.print("m2-->\t调用前：s1=" + s1.hashCode() + "\t");
        System.out.println("age=" + s1.getAge());
        demo.m2(s1);
        System.out.print("\t调用后：s1=" + s1.hashCode() + "\t"); // s1未变(仍指向原来对象)
        System.out.println("age=" + s1.getAge()); // age变了(对象的字段被修改了)
    }

    private void m1(int a) { // 基本类型的参数：传值
        a++; // 修改形参不会影响传入的实参
    }

    private void m2(Student s2) { // 对象类型的参数：传引用
        System.out.print("\t调用中：s2=" + s2.hashCode() + "\t"); // s2与s1指向同一对象
        s2.setAge(s2.getAge() + 10); // 修改形参s2指向的对象的字段
        s2 = new Student(18); // 使形参s2指向另一对象(实参s1仍指向原对象)
        System.out.println("s2=" + s2.hashCode()); // s2变了
    }
}