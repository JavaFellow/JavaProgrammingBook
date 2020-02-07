package ch10;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopier {
    public static void main(String[] args) {
        String src = "C:/TestFile.rar"; // 要复制的文件
        String dest = "C:/TestFile2.rar"; // 复制到的文件

        byte[] buff = new byte[1024]; // 用作缓冲的字节数组
        long size = 0; // 已复制的字节数
        int i = 0; // 每次读取的字节数
        long begin = System.currentTimeMillis(); // 记录复制前时间

        try (FileInputStream in = new FileInputStream(src); FileOutputStream out = new FileOutputStream(dest)) { // 多个资源
            System.out.print("正在复制中 ");
            while ((i = in.read(buff)) != -1) { // 读取输入流
                out.write(buff, 0, i); // 思考：为何不能调用write(buff)方法？
                size += i; // 累加
            }
            long end = System.currentTimeMillis(); // 记录复制后时间
            System.out.println("完毕。共 " + size + " 字节，耗时 " + (end - begin) + " 毫秒。");
        } catch (FileNotFoundException e) {
            System.out.println("要复制的文件不存在！");
        } catch (IOException e) {
            System.out.println("复制时出现错误！");
        }
    }
}