package ch05.singleton;

public class SingletonDemo { // 单例模式测试类
    public static void main(String[] args) {
        // 得到单例类的对象 (g1、g2、g3其实是同一个对象的不同名称)
        God g1 = God.getInstance();
        God g2 = God.getInstance();
        God g3 = God.getInstance();

        // 打印g1、g2、g3指向对象的内存地址
        System.out.println("g1的地址: " + g1.hashCode());
        System.out.println("g2的地址: " + g2.hashCode());
        System.out.println("g3的地址: " + g3.hashCode());
    }
}
