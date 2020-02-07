package ch11;

public class YieldDemo {
    /**** 线程类(本章数个演示程序中均有Counter类，为互不影响，设计成内部类) ****/
    class Counter extends Thread {
        boolean b; // 是否有可能主动让出CPU

        Counter(boolean b) { // 构造方法
            this.b = b;
        }

        public void run() {
            int i = 1; // 计数器
            while (i <= 12) {
                System.out.printf("%-3s", b ? i : "^");
                if (b && i % 7 == 0) { // 计数到7的倍数
                    Thread.yield(); // 让出CPU
                }
                i++;
            }
        }
    }

    public static void main(String[] args) {
        YieldDemo demo = new YieldDemo();
        Counter c1 = demo.new Counter(true); // 有可能主动让出CPU
        Counter c2 = demo.new Counter(false);// 不主动让出CPU
        c1.start();
        c2.start();
    }
}