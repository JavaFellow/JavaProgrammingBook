package ch10;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileDemo {
    public static void main(String[] args) {
        int fileCount = 0, dirCount = 0; // 文件和文件夹计数器
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        // 路径分隔符建议使用跨平台的“/”，也可用File.separatorChar动态获取
        File home = new File("C:/Program Files/Java/jdk1.8.0_202");
        System.out.println(home.getPath() + " 下的文件及文件夹："); // 得到完整路径
        System.out.printf("%-38s%-12s%20s\n", "Name", "Size(KB)", "Last Modified");
        printLine();
        File[] fs = home.listFiles(); // 得到文件夹下的所有文件及文件夹
        for (File f : fs) {
            System.out.printf("%-38s", f.getName()); // 得到文件名
            if (f.isFile()) { // 若是文件
                long b = f.length(); // 得到大小
                System.out.printf("%-12d", b == 0 ? 0 : Math.max(1, b / 1024));
                fileCount++;
            } else { // 若是文件夹
                System.out.printf("%-12s", "-");
                dirCount++;
            }
            Date d = new Date(f.lastModified()); // 得到最后修改时间并构造日期对象
            System.out.printf("%20s\n", sdf.format(d)); // 格式化日期
        }
        printLine();
        System.out.printf("共  %d 个文件，%d 个文件夹。", fileCount, dirCount);
    }

    static void printLine() { // 打印一串横线
        for (int i = 0; i < 70; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}