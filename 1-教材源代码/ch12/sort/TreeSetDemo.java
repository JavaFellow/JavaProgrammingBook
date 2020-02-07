package ch12.sort;

import java.util.TreeSet;

import ch12.Product;
import ch12.ProductUtil;

public class TreeSetDemo {
    public static void main(String[] args) {
        TreeSet set1 = new TreeSet(); // 构造树形集合(默认使用自然排序)

        ProductComparator comparator = new ProductComparator(); // 构造比较器对象
        TreeSet set2 = new TreeSet(comparator); // 构造树形集合(指定了比较器，使用自定义排序)

        Product[] ps = ProductUtil.createProducts(); // 生成产品数组
        for (Product p : ps) {
            ComparableProduct cp = ComparableProduct.from(p);
            set1.add(cp); // 添加转换后的产品到set1
            set2.add(p); // 添加原产品到set2
        }

        System.out.println("set1的元素(自然排序)：");
        ProductUtil.printProducts(set1);
        System.out.println("set2的元素(自定义排序)：");
        ProductUtil.printProducts(set2);

        Product low = (Product) set2.first(); // 得到最小的产品
        System.out.println("库存最少：" + low.getName());
        Product high = (Product) set2.last(); // 得到最大的产品
        System.out.println("库存最多：" + high.getName());

        Product target = new Product(9, "--", 150); // 用于比较的目标产品
        /**** 打印所有大于等于目标的产品 ****/
        TreeSet set3 = (TreeSet) set2.tailSet(target);
        System.out.print("库存超过" + target.getInventory() + "(含)：");
        for (Object o : set3) { // 迭代
            Product p = (Product) o;
            System.out.print(p.getName() + " ");
        }
    }
}