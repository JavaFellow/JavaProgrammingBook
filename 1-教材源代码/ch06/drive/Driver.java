package ch06.drive;

public class Driver { // 驾驶员(测试类)
    void drive(Car c) { // 测试方法(接口可以作为引用类型)
        // 程序运行时，根据c的实际类型调用相应实现类的方法(即运行时多态)，
        // 驾驶员无需关心驾驶的是何种品牌及工作方式的小轿车。
        c.start();
        c.accelerate();
        c.brake();
    }

    public static void main(String[] args) {
        Driver d = new Driver();// 创建驾驶员对象
        Car c1 = new Santana();// 创建Car对象(实现类对象赋给接口引用)
        Car c2 = new Tesla();

        d.drive(c1);// 调用测试方法
        System.out.println("----换辆车开----");
        d.drive(c2);
    }
}