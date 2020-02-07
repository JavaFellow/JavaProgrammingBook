package ch10;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStreamDemo {
    String dataFile = "D:/cpu.dat"; // 用于写出和读入的字节文件

    /**** 要写出的数据 ****/
    long[] ids = { 100001, 100002, 100003 };
    String[] names = { "酷睿i9-9900k ", "锐龙R7-2700X", "至强E5-2620V4" };
    float[] prices = { 4599, 2599, 3699 };
    int[] counts = { 16, 20, 10 };

    public static void main(String[] args) {
        DataStreamDemo demo = new DataStreamDemo();
        demo.save(); // 写出数据
        demo.load(); // 读入数据
    }

    void save() {
        try (FileOutputStream fos = new FileOutputStream(dataFile); DataOutputStream dos = new DataOutputStream(fos)) {
            for (int i = 0; i < ids.length; i++) {
                dos.writeLong(ids[i]); // 写出long型数据
                dos.writeUTF(names[i]); // 以UTF编码写出字符串
                dos.writeFloat(prices[i]); // 写出float型数据
                dos.writeInt(counts[i]); // 写出int型数据
            }
        } catch (IOException e) {
            System.out.println("写出发生了I/O错误！");
            System.exit(-1); // 退出程序
        }
    }

    void load() {
        System.out.printf("%-10s%-13s%8s%13s\n", "id", "name", "price", "inventory");

        for (int i = 0; i < 44; i++) { // 打印分隔线
            System.out.print("-");
        }
        System.out.println();

        try (FileInputStream fis = new FileInputStream(dataFile); DataInputStream dis = new DataInputStream(fis)) {
            while (true) { // 一直读入直至循环体抛出IOException异常
                long id = dis.readLong(); // 读入long型数据
                String name = dis.readUTF(); // 读入UTF编码的字符串
                float price = dis.readFloat(); // 读入float型数据
                int inventory = dis.readInt(); // 读入int型数据
                System.out.printf("%-10d%-12s%8.1f%12d\n", id, name, price, inventory);
            }
        } catch (IOException e) {
            System.exit(-1);
        }
    }
}