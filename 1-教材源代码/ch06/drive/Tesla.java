package ch06.drive;

public class Tesla implements Car { // 特斯拉实现小轿车接口
    /**** 重写Car接口各方法 ****/
    public void start() {
        System.out.println("识别指纹信息，特斯拉启动了...");
    }

    public void accelerate() {
        System.out.println("踩下加速踏板，特斯拉开始加速...");
    }

    public void brake() {
        System.out.println("车载雷达识别到前方行人，特斯拉开始减速...");
    }
}