package ch10;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class BufferedInputStreamDemo {
    public static void main(String[] args) {
        String src = "D:" + File.separatorChar + "TestFile.txt"; // 要读取的文本文件
        int i = 0; // 存放当前读取的字节
        try (InputStream is = new FileInputStream(src); BufferedInputStream bis = new BufferedInputStream(is)) { // 套接在输入流上
            bis.mark(1024); // 标记当前位置(尚未作读取操作，当前位置为0)
            System.out.print("第1次读取：");
            while ((i = bis.read()) != -1) { // 每次读取1字节
                System.out.printf("%-3X", i); // 以16进制输出
            }
            bis.reset(); // 回到之前标记的位置(从新读取)
            System.out.print("\n第2次读取：");
            while ((i = bis.read()) != -1) {
                System.out.printf("%-3c", (char) i); // 强制将字节转换为字符
            }
            System.out.println();

            /**** 以下代码做验证用 ****/
            String s = "语言";
            byte[] bs = s.getBytes(); // 以GBK编码得到s的字节数组
            System.out.print("【" + s + "】在文件中所占的 " + bs.length + " 字节为：");
            for (byte b : bs) {
                System.out.printf("%-3X", b); // 以16进制输出bs的全部字节
            }
        } catch (FileNotFoundException e) {
            System.out.println("找不到要读取的文件！");
        } catch (IOException e) {
            System.out.println("读取过程中出现了I/O错误！");
        }
    }
}