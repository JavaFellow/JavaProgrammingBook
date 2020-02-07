package ch09;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TryCatchDemo2 {
    public static void main(String[] args) {
        try {
            // 下面的语句会抛出FileNotFoundException异常(父类为IOException)
            FileReader reader = new FileReader("D:/TestFile.txt");
        } catch (IOException e) { // 先捕获父类异常
            System.out.println("发生了I/O错误！");
        } catch (FileNotFoundException e) { // 语法错误(不可到达的catch块)
            System.out.println("找不到相应的文件！");
        }
    }
}