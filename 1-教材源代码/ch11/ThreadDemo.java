package ch11;

/**** 方式1 ****/
class MyThread extends Thread {
    public void run() { // 重写run方法
        System.out.println("线程1运行了。");
    }
}

/**** 方式2(注意此类并非线程类) ****/
class MyRunnable implements Runnable {
    public void run() { // 重写run方法
        System.out.println("线程2运行了。");
    }
}

public class ThreadDemo { // 测试类
    public static void main(String[] args) {
        Thread t1 = new MyThread(); // 创建线程对象t1

        Runnable target = new MyRunnable(); // target并非线程对象
        Thread t2 = new Thread(target); // 创建线程对象t2

        // 创建线程对象t3(本质上仍是方式2，但使用了Lambda表达式以简化代码)
        Thread t3 = new Thread(() -> System.out.println("线程3运行了。"));

        t1.start(); // 启动t1
        t2.start(); // 启动t2
        t3.start(); // 启动t3
    }
}