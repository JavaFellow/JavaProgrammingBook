package ch11;

class School implements Runnable {
    Thread monitor, tom, teacher;

    public School() {
        monitor = new Thread(this, "班长"); // 创建线程时指定名称
        tom = new Thread(this, "汤姆");
        teacher = new Thread(this, "老师");
    }

    public void teach() {
        monitor.start();
        tom.start();
        teacher.start();
    }

    public void run() {
        Thread th = Thread.currentThread(); // 获得当前线程
        if (th == monitor || th == tom) {
            try {
                System.out.println(th.getName() + "：休息10秒...");
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                System.out.println(th.getName() + "被唤醒了。");
            }
            System.out.println(th.getName() + "：老师好！");
            tom.interrupt(); // 唤醒汤姆
        } else if (th == teacher) {
            for (int i = 0; i < 3; i++) {
                System.out.println(th.getName() + "：上课！");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
            }
            monitor.interrupt(); // 唤醒班长
        }
    }
}

public class InterruptDemo {
    public static void main(String[] args) {
        new School().teach();
    }
}