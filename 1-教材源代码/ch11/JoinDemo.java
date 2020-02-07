package ch11;

public class JoinDemo {
    /**** 线程类(本章数个演示程序中均有Counter类，为互不影响，设计成内部类) ****/
    class Counter extends Thread {
        public void run() {
            for (int i = 1; i <= 4; i++) {
                System.out.println("    Counter线程：" + i);
            }
        }
    }

    public static void main(String[] args) { // main方法对应着主线程
        Counter c = new JoinDemo().new Counter(); // 创建线程(注意内部类对象的创建语法)
        c.start();

        for (int i = 1; i <= 8; i++) {
            System.out.println("主线程：" + i);
            if (i == 2) {
                try {
                    c.join(); // 合并c到主线程
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}