package ch11.pc;

public class Consumer extends Thread { // 消费者线程
    Repository repo;

    public Consumer(Repository repo) { // 构造方法
        this.repo = repo;
    }

    public void run() {
        for (int i = 1; i < 6; i++) {
            repo.get();
        }
    }
}