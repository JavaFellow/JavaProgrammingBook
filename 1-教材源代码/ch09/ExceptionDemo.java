package ch09;

import java.io.FileReader;

public class ExceptionDemo {
    public static void main(String[] args) {
        FileReader reader = new FileReader("D:/TestFile.txt"); // 有语法错误
    }
}