package ch10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedReaderWriterDemo {
    public static void main(String[] args) throws IOException {
        File dest = new File("D:\\Unicode.txt"); // 待写出和读入的文件

        /**** 以下为写出文件 ****/
        int ch = '一'; // 要写出的第一个字符
        String line; // 存放写出或读入的一行字符串
        try (FileWriter out = new FileWriter(dest); BufferedWriter bw = new BufferedWriter(out)) {
            for (int i = 0; i < 5; i++) { // 5行
                line = "";
                for (int j = 0; j < 24; j++) { // 24列
                    line += ((char) (ch++) + " "); // 拼接字符串并准备下一字符
                }
                bw.write(line); // 写出字符串
                bw.newLine(); // 写出换行字符
                bw.flush(); // 每写一行，刷新缓冲输出流
            }
        }

        /**** 以下为读入文件 ****/
        try (FileReader in = new FileReader(dest); BufferedReader br = new BufferedReader(in)) {
            while ((line = br.readLine()) != null) { // 每次读入一行
                System.out.println(line);
            }
        }
    }
}