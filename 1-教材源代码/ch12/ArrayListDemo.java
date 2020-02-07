package ch12;

import java.util.ArrayList;

public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList list = new ArrayList(10); // 构造顺序表(指定了初始容量)

        Product[] ps = ProductUtil.createProducts(); // 生成产品数组
        for (Product p : ps) {
            list.add(list.size(), p); // 添加到顺序表的末尾
        }

        System.out.println("现有产品：");
        ProductUtil.printProducts(list);

        /******** 模拟进货 ********/
        String inName = "空调"; // 进货产品名称
        int inCount = 20; // 进货产品数量
        System.out.print("进货：" + inName + "(" + inCount + "台)，");
        boolean found = false; // 标记进货产品是否已存在
        for (Object o : list) {
            Product p = (Product) o;
            if (inName.equals(p.getName())) { // 根据产品名称寻找
                found = true; // 找到
                p.setInventory(p.getInventory() + inCount); // 修改已存在产品的库存
                break; // 停止寻找
            }
        }
        if (found) {
            System.out.println("已找到，更新...");
        } else {
            System.out.println("未找到，添加...");
            list.add(new Product(list.size() + 1, inName, inCount)); // 添加到顺序表末尾
        }
        ProductUtil.printProducts(list);

        /******** 模拟出货 ********/
        String outName = "手机"; // 出货产品名称
        System.out.print("出货：" + outName + "(全部)，");
        found = false;
        for (Object o : list) {
            Product p = (Product) o;
            if (outName.equals(p.getName())) { // 根据产品名称寻找
                found = true;
                list.remove(p); // 删除找到的产品
                break;
            }
        }
        if (found) {
            System.out.println("已找到，删除...");
        } else {
            System.out.println("未找到！");
        }
        ProductUtil.printProducts(list);
    }
}