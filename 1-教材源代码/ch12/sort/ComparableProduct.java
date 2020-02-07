package ch12.sort;

import ch12.Product;

/**** 实现了Comparable接口的产品类，以支持自然排序 ****/
public class ComparableProduct extends Product implements Comparable {
    public ComparableProduct(int id, String name, int inventory) {
        super(id, name, inventory); // 调用父类的构造方法
    }

    /**** 重写Comparable接口的方法 ****/
    public int compareTo(Object o) {
        ComparableProduct p = (ComparableProduct) o; // 造型
        return p.getId() - this.getId(); // p的编号减去当前产品编号(即以编号降序排列)
    }

    /**** 将Product对象转为ComparableProduct对象 ****/
    public static ComparableProduct from(Product p) {
        int id = p.getId(); // 得到原产品对象的各个属性
        String name = p.getName();
        int inventory = p.getInventory();
        return new ComparableProduct(id, name, inventory);
    }
}