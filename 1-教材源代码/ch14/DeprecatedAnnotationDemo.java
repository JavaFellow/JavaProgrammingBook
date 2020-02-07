package ch14;

import java.util.Date;

public class DeprecatedAnnotationDemo {
    public static void main(String[] args) {
        // 构造方法Date(int year, int month, int day)已被标记为过时
        Date d = new Date(2019 - 1900, 3, 12);
        System.out.println(d.toString());
    }
}