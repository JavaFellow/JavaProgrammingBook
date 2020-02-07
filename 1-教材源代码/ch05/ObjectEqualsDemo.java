package ch05;

import ch05.override.Shape;

class Product { // 产品类
    int id; // 编号
    String name; // 名称

    public Product(int id, String name) { // 构造方法
        this.id = id;
        this.name = name;
    }

    public boolean equals(Object obj) { // 重写equals方法
        if (obj instanceof Product) { // 判断obj是否为产品类型
            return id == ((Product) obj).id; // 比较id
        }
        return false;
    }

    public int hashCode() { // 重写hashCode方法
        return id % 1000; // 以id为计算标准 (确保id相同则哈希码一定相同)
    }
}

public class ObjectEqualsDemo {
    public static void main(String[] args) {
        Shape s1 = new Shape(); // 创建前述Shape类的对象
        Shape s2 = new Shape();
        System.out.printf("1: %-30s", s1 == s2 ? "s1 == s2" : "s1 != s2");
        System.out.println(s1.equals(s2) ? "s1 equals s2" : "s1 not-equals s2");
        System.out.printf("2: %-30s", "HashCode(s1)=" + s1.hashCode());
        System.out.println("HashCode(s2)=" + s2.hashCode());

        Integer a = new Integer(1); // Integer类已重写了equals方法 (比较值)
        Integer b = new Integer(1);
        System.out.printf("3: %-30s", a == b ? "a == b" : "a != b");
        System.out.println(a.equals(b) ? "a equals b" : "a not-equals b");
        // Integer类已重写了hashCode方法 (以值作为哈希码)
        System.out.printf("4: %-30s", "HashCode(a)=" + a.hashCode());
        System.out.println("HashCode(b)=" + b.hashCode());

        Product p1 = new Product(100101, "iPhone XS");
        Product p2 = new Product(100101, "苹果XS");
        System.out.printf("5: %-30s", p1 == p2 ? "p1 == p2" : "p1 != p2");
        System.out.println(p1.equals(p2) ? "p1 equals p2" : "p1 not-equals p2");
        System.out.printf("6: %-30s", "HashCode(p1)=" + p1.hashCode());
        System.out.println("HashCode(p2)=" + p2.hashCode());
    }
}
