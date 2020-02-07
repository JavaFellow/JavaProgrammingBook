package ch10;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;

public class ConsoleDemo {
    public static void main(String[] args) throws IOException {
        Console c = System.console(); // 得到控制台对象
        if (c == null) { // 若控制台不存在则退出
            System.out.println("控制台不存在，请在命令行窗口启动程序！");
            System.exit(0);
        }

        /**** 模拟用户登录 ****/
        String name = null, psw = null;
        name = c.readLine("账号："); // 等待输入一行字符串
        psw = String.valueOf(c.readPassword("密码：")); // 输入密码
        if ("admin".equalsIgnoreCase(name.trim()) && "admin".equals(psw)) { // 登录成功
            c.printf("%1$s 于 %2$tY-%2$tm-%2$td %2$tH:%2$tM:%2$tS 登录，欢迎！", name, new Date());
        } else { // 登录失败
            c.printf("账号或密码错误，程序退出！");
            System.exit(0);
        }

        /**** 执行用户输入的命令并捕获输出 ****/
        String command = null; // 要执行的命令
        Process process = null; // 执行命令时产生的进程(请查阅API文档)
        String line = null; // 存放执行命令时输出的每行信息
        while (true) {
            c.printf("\n>> ");
            command = c.readLine(); // 等待输入命令
            if ("exit".equalsIgnoreCase(command)) { // 若输入exit则退出
                c.printf("%1$s 于 %2$tY-%2$tm-%2$td %2$tH:%2$tM:%2$tS 退出，再见！", name, new Date());
                System.exit(0);
            }
            // 通过操作系统执行输入的命令
            process = Runtime.getRuntime().exec("cmd /c " + command);
            // 获得进程的输入流并包装(当执行的命令有输出信息时，将写到此输入流)
            try (InputStream is = process.getInputStream(); InputStreamReader isr = new InputStreamReader(is); BufferedReader br = new BufferedReader(isr)) {
                while ((line = br.readLine()) != null) { // 读入一行信息
                    c.printf("%s\n", line); // 写到控制台
                }
            }
        }
    }
}