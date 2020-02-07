package ch11;

public class SleepDemo {
    /**** 线程类(本章数个演示程序中均有Counter类，为互不影响，设计成内部类) ****/
    class Counter extends Thread {
        int i = 0; // 计数器

        Counter(int i) { // 构造方法
            this.i = i;
        }

        public void run() { // 重写run方法
            while (i >= 0) {
                System.out.print(i + "  "); // 打印计数器当前值
                try { // sleep方法会抛出Checked型异常
                    Thread.sleep(1000); // 休眠1秒
                } catch (InterruptedException e) {
                    System.out.println("休眠中的线程被中断！");
                }
                i--; // 修改计数器
            }
        }
    }

    public static void main(String[] args) {
        System.out.print("倒计时开始：");
        new SleepDemo().new Counter(5).start(); // 创建并启动线程(注意内部类对象的创建语法)
    }
}