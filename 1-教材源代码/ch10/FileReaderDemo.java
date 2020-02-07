package ch10;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class FileReaderDemo {
    public static void main(String[] args) {
        String src = "AwesomeJava.txt"; // 要读取的文本文件(位于本类所在的包下)
        URL url = FileReaderDemo.class.getResource(src); // 构造URL对象
        int ch;
        try (FileReader in = new FileReader(new File(url.toURI()))) { // 带资源的try
            while ((ch = in.read()) != -1) { // 每次读取1个字符
                System.out.print((char) ch); // 强制转换为字符并输出
            }
        } catch (URISyntaxException | FileNotFoundException e) { // 捕获多个异常类
            System.out.println("要读取的文件不存在！");
        } catch (IOException e) {
            System.out.println("读取文件时发生错误！");
        }
    }
}