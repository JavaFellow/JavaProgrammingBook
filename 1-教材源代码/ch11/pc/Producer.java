package ch11.pc;

public class Producer extends Thread { // 生产者线程
    Repository repo;

    public Producer(Repository repo) { // 构造方法
        this.repo = repo;
    }

    public void run() {
        for (int i = 1; i < 6; i++) {
            repo.put(i);
        }
    }
}