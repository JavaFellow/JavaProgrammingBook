package ch09;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FinallyDemo {
    public static void main(String[] args) {
        String fileName = "D:/TestFile.txt"; // 要打开的文件
        FileReader reader = null; // 因finally块要访问reader，故在try块外声明

        try {
            System.out.println("准备打开文件：" + fileName + "...");
            reader = new FileReader(fileName); // 可能抛出FileNotFoundException异常
            System.out.println("成功打开了文件。");
            // ... // 继续对reader做其他操作
        } catch (FileNotFoundException e) {
            System.out.println("错误，文件未找到。");
        } finally {
            System.out.println("准备关闭文件：" + fileName + "...");
            if (reader != null) { // 若第14行成功打开了文件
                try {
                    reader.close(); // 可能抛出IOException异常，必须放在try块中
                    System.out.println("成功关闭了文件。");
                } catch (IOException e) {
                    System.out.println("关闭文件时发生了I/O错误！");
                }
            } else {
                System.out.println("之前未能打开文件，无须关闭。");
            }
        }
    }
}