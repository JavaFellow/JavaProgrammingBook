package ch12;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {
    public static void main(String[] args) {
        HashMap map1 = new HashMap(8); // 哈希映射(指定了初始容量)
        LinkedHashMap map2 = new LinkedHashMap(8, 0.75f, true); // 链式哈希映射(注意参数3)

        Product[] ps = ProductUtil.createProducts(); // 生成产品数组
        System.out.print("产品数组：");
        for (Product p : ps) {
            System.out.print(p.getName() + "  ");
            map1.put(p.getName(), p); // 以产品名称为键，以产品对象为值
            map2.put(p.getName(), p);
        }

        map1.put(null, null); // 允许空键和空值
        System.out.print("\n\nmap1：");
        printMap(map1);

        map2.put(null, null); // 允许空键和空值
        map2.put(null, new Product(9, "微波炉", 999)); // 键与上行相同(上行的空值会被替换)

        /**** 得到以倒数第2个产品的名称为键的值(执行后该键将位于map2的最后) ****/
        map2.get(ps[ps.length - 1].getName());
        System.out.print("\nmap2：");
        printMap(map2);
    }

    /**** 打印map中的键值对 ****/
    static void printMap(Map map) {
        System.out.println("\t键(String)\t值(Product)");
        System.out.println("-------------------------------------------");

        Set set = map.entrySet(); // 得到所有条目构成的集合(映射不支持增强型for循环)
        for (Object o : set) { // 迭代条目集合
            Map.Entry entry = (Map.Entry) o; // 将元素转回条目类型
            String key = (String) entry.getKey(); // 获得键
            Product value = (Product) entry.getValue(); // 获得值
            System.out.printf("\t%-8s\t-->\t", key == null ? "【空】" : key);
            if (value != null) { // 值可能为空
                value.print();
            } else {
                System.out.println("【空】");
            }
        }
    }
}