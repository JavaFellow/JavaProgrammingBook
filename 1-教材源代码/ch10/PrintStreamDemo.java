package ch10;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class PrintStreamDemo {
    public static void main(String[] args) {
        /**** 含byte、char、int、long、float、double、String等类型的对象数组 ****/
        Object values[] = { (byte) -8, 'A', '我', Integer.MAX_VALUE, 022, 0x1A, 987654321L, 3.14159, -1.7F, 2.1D, "Java语言", System.lineSeparator() };
        File file = new File("D:/log.txt"); // 写到的文件

        try (FileOutputStream out = new FileOutputStream(file); PrintStream log = new PrintStream(out)) {
            for (Object v : values) {
                log.print(v + "|"); // 写出values的每个元素
            }
            byte[] bytes = { 65, 66, 67, 13, 10 }; // 字节数组(A、B、C及Windows换行符)
            log.write(bytes, 1, bytes.length - 1); // 从B开始写出
            char[] chars = { '\t', 'J', 'a', 'v', 'a', '语', '言' }; // 字符数组
            log.print(chars); // 写出字符数组
        } catch (FileNotFoundException e) { // 第17行
            System.out.println("创建文件时发生错误！");
        } catch (IOException e) {
            System.out.println("读写时发生错误！");
        }
    }
}