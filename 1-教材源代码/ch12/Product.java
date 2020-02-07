package ch12;

public class Product {
    private int id; // 产品编号
    private String name; // 产品名称
    private int inventory; // 产品库存

    public Product(int id, String name, int inventory) { // 构造方法
        this.id = id;
        this.name = name;
        this.inventory = inventory;
    }

    public void print() { // 打印产品信息
        System.out.printf("%-10d%-12s\t%d\n", id, name, inventory);
    }

    /**** 以下为getters和setters ****/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }
}