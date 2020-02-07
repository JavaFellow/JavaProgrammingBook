package ch09;

import java.io.FileReader;
import java.io.IOException;

public class ExceptionWithThrowsDemo {
    public static void main(String[] args) throws IOException {
        // 尽管下行语句抛出的IOException属于Checked型异常，并且未编写代码处理之，但该语句所在
        // 的方法(此处为main方法)声明了抛出IOException异常，故本程序没有语法错误。
        FileReader reader = new FileReader("D:/TestFile.txt");
    }
}