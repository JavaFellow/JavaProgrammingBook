package ch12;

import java.util.Collection;
import java.util.Random;

public class ProductUtil {
    static String[] names = { "洗衣机", "手机", "电视", "电脑", "微波炉", "空调", "冰箱" };
    static Random rand = new Random(); // 随机数对象

    /**** 随机打乱names ****/
    static {
        int p, q; // 要交换的下标
        String temp;
        for (int i = 0; i < rand.nextInt(6) + 5; i++) {
            p = rand.nextInt(names.length);
            q = rand.nextInt(names.length);
            temp = names[p]; // 交换names[p]和names[q]
            names[p] = names[q];
            names[q] = temp;
        }
    }

    /**** 生成产品数组 ****/
    public static Product[] createProducts() {
        int count = rand.nextInt(100) % 4 + 2; // 产生2~5个产品
        Product[] ps = new Product[count]; // 构造产品数组
        for (int i = 0; i < ps.length; i++) { // 生成产品
            Product p = new Product(i + 1, names[i], rand.nextInt(101) + 100);
            ps[i] = p;
        }
        return ps;
    }

    /**** 打印容器c中所有产品的信息 ****/
    public static void printProducts(Collection c) {
        c.forEach(o -> {
            Product p = (Product) o; // 造型为产品
            if (p != null) { // 判断p是否非空(某些容器允许包含空对象)
                p.print();
            } else {
                System.out.println("空对象");
            }
        });
        System.out.println("-------------------");
    }
}