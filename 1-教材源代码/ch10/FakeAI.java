package ch10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FakeAI {
    public static void main(String[] args) {
        String[] old = { "吗", "你", "？", "?", "Can you" };
        String[] replace = { "", "我", "！", "!", "I can" };
        String line = null; // 存放输入的行
        try (InputStreamReader r = new InputStreamReader(System.in); BufferedReader br = new BufferedReader(r)) {
            System.out.print("人：");
            while (!"exit".equalsIgnoreCase(line = br.readLine())) { // 输入的行不是exit
                for (int i = 0; i < old.length; i++) {
                    line = line.replace(old[i], replace[i]);
                }
                System.out.println("机：" + line + " [" + r.getEncoding() + "]");
                System.out.print("人：");
            }
        } catch (IOException e) {
            System.out.println("出现I/O错误！");
        }
    }
}