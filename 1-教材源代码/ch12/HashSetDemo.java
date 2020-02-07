package ch12;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class HashSetDemo {
    public static void main(String[] args) {
        HashSet set1 = new HashSet(); // 哈希集合
        HashSet set2 = new HashSet(8); // 指定了初始容量
        LinkedHashSet set3 = new LinkedHashSet(8); // 链式哈希集合

        Product[] ps = ProductUtil.createProducts(); // 生成产品数组
        for (Product p : ps) {
            set1.add(p); // 添加到set1
            set1.add(p); // 重复添加(无效)
            HashedProduct hp = HashedProduct.from(p);// 转换为HashedProduct对象
            set2.add(hp); // 添加到set2
            set3.add(hp); // 添加到set3
        }

        System.out.println("set1：");
        ProductUtil.printProducts(set1);

        Product p = ps[ps.length - 1]; // 取得之前生成的最后一个产品
        int id = p.getId();
        String name = p.getName();
        int inventory = p.getInventory();

        Product p1 = new Product(id, name, inventory);
        set1.add(p1); // 加p1到set1(有效)
        System.out.println("set1(添加后)：");
        ProductUtil.printProducts(set1);

        System.out.println("set2：");
        ProductUtil.printProducts(set2);
        HashedProduct p2 = new HashedProduct(1, name, 200); // 名称与set2中某个产品相同
        set2.add(p2); // 加p2到set2(无效)
        System.out.println("set2(添加后)：");
        ProductUtil.printProducts(set2);

        set3.add(null); // 添加空对象(有效)
        set3.add(null); // 再次添加空对象(无效)
        System.out.println("set3的元素：");
        ProductUtil.printProducts(set3);
    }
}