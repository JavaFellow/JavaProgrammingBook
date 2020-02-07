package ch10;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args) {
        /**** 从命令行窗口读入数据 ****/
        try (Scanner s = new Scanner(System.in)) { // Scanner实现了Closeable接口
            System.out.print("输入int：");
            System.out.println("--> " + s.nextInt()); // 读入int型
            System.out.print("输入long(16进制)：");
            System.out.println("--> " + s.nextLong(16)); // 读入long型
            System.out.print("输入float：");
            System.out.println("--> " + s.nextFloat()); // 读入float型
            System.out.print("输入字符串：");
            System.out.println("--> " + s.next());
        } catch (InputMismatchException e) {
            System.out.println("输入的数据不是指定类型！");
        }

        /**** 从文件读入数据 ****/
        String src = "D:/source.txt"; // 要读取的文件
        try (Scanner s = new Scanner(new FileReader(src))) {
            s.useDelimiter("\\s*,+\\s*|\\s+"); // 设置分隔符(逗号、空格、跳格、换行符等)
            System.out.print("int型标记：");
            while (s.hasNext()) { // 若有下一个标记
                if (s.hasNextInt(16)) { // 若下一标记是16进制int型
                    System.out.print(s.nextInt(16) + " "); // 读取标记并输出
                } else {
                    s.next(); // 否则继续读取(若无此行则陷入死循环)
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("要读取的文件不存在！");
        }
    }
}