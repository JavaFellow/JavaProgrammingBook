package ch11.pc;

public class PCDemo { // 测试类
    public static void main(String args[]) {
        Repository repo = new Repository();
        Producer p = new Producer(repo);
        Consumer c = new Consumer(repo);
        p.start();
        c.start();
    }
}