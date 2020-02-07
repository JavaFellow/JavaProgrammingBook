package ch11;

public class WebSiteCounter {
    public static void main(String args[]) throws InterruptedException {
        WebSite site = new WebSite();

        new Thread(site, "用户1").start(); // 模拟3个用户
        new Thread(site, "用户2").start();
        new Thread(site, "用户3").start();

        Thread.sleep(100); // 未捕获InterruptedException(由所在方法抛出)
    }
}

class WebSite implements Runnable { // 网站
    int count = 0; // 访问计数器

    public void run() {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + "：第 " + (++count) + " 位访问者");
        }
    }
}