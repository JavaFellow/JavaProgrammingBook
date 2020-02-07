package ch06.drive;

public class Santana implements Car { // 桑塔纳实现小轿车接口
    /**** 重写Car接口各方法 ****/
    public void start() {
        System.out.println("插入并转动钥匙，桑塔纳启动了...");
    }

    public void accelerate() {
        System.out.println("踩离合、挂档、踩油门、松离合，桑塔纳开始加速...");
    }

    public void brake() {
        System.out.println("踩制动，桑塔纳开始减速...");
    }
}