package ch06.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

class Student {
    int age; // 年龄

    public Student(int age) { // 构造方法
        this.age = age;
    }
}

public class LambdaExpressionDemo { // 测试类
    Student[] arrA, arrB; // 学生数组

    /**** 构造并初始化学生数组 ****/
    void buildStudents(int count) {
        arrA = new Student[count];
        arrB = new Student[count];

        Random rand = new Random(); // 随机数对象
        for (int i = 0; i < count; i++) {
            int a = 18 + rand.nextInt(20); // 随机产生[18, 37]的年龄
            arrA[i] = new Student(a); // 两个数组使用相同的年龄
            arrB[i] = new Student(a);
        }
    }

    /**** 对学生数组按年龄排序 ****/
    void sortStudents() {
        Arrays.sort(arrA, new Comparator() { // 方式1：使用匿名内部类
            public int compare(Object o1, Object o2) {
                return ((Student) o1).age - ((Student) o2).age;
            }
        });

        Arrays.sort(arrB, (Object o1, Object o2) -> { // 方式2：使用Lambda表达式
            return ((Student) o1).age - ((Student) o2).age;
        });
    }

    /**** 打印学生数组的年龄 ****/
    void printAges(String title, Student[] ss) {
        System.out.print(title + ": ");
        for (Student s : ss) {
            System.out.printf("%-4d", s.age);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LambdaExpressionDemo demo = new LambdaExpressionDemo();
        demo.buildStudents(10);
        demo.sortStudents();
        demo.printAges("方式1", demo.arrA);
        demo.printAges("方式2", demo.arrB);
    }
}
