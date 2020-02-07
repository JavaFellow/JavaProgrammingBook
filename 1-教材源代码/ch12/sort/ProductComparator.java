package ch12.sort;

import java.util.Comparator;

import ch12.Product;

/**** 实现Comparator接口的比较器类，以支持自定义排序 ****/
public class ProductComparator implements Comparator {
    /**** 重写Comparator接口的方法 ****/
    public int compare(Object o1, Object o2) {
        Product p1 = (Product) o1; // 造型为产品对象
        Product p2 = (Product) o2;
        return p1.getInventory() - p2.getInventory(); // 以库存升序排列
    }
}