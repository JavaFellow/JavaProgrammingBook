package ch11.pc;

public class Repository { // 仅能存放一个产品的仓库
    private boolean isEmpty = true; // 仓库是否为空
    private int product; // 存放的产品(以序号标识)

    /**** 将产品product放入仓库(同步方法) ****/
    public synchronized void put(int product) {
        if (!isEmpty) { // 仓库非空
            try {
                this.wait(); // 等待
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.product = product; // 存放产品product
        this.isEmpty = false; // 修改仓库为非空
        System.out.print("Produce " + product);
        this.notify(); // 唤醒某个等待线程
    }

    /**** 从仓库取出产品(同步方法) ****/
    public synchronized void get() {
        if (isEmpty) { // 仓库为空
            try {
                this.wait(); // 等待
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(", Consume " + this.product);
        this.isEmpty = true; // 修改仓库为空
        this.notify(); // 唤醒某个等待线程
    }
}