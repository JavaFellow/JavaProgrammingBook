package ch06;

interface GasolineCar { // 燃油车接口
    default void fuel() { // 默认方法
        System.out.print("加油...");
    }

    static void tooting() { // 静态默认方法
        System.out.print("滴滴...");
    }
}

interface ElectricCar { // 电动车接口
    default void fuel() { // 同名的默认方法
        System.out.print("充电...");
    }

    static void tooting() { // 同名的静态默认方法
        System.out.print("嘟嘟...");
    }
}

interface HybridCar extends GasolineCar, ElectricCar { // 混动车接口
    default void fuel() { // 必须重写父接口中同名的默认方法
        GasolineCar.super.fuel(); // 指定调用哪个接口的默认方法
        ElectricCar.super.fuel();
    }

    default void test() { // 普通的默认方法
        System.out.print("测试...");
    }
}

public class Bmw530LE implements HybridCar { // 接口实现类(测试类)
    public static void main(String[] args) {
        HybridCar c = new Bmw530LE();
        c.fuel(); // 调用接口的默认方法
        c.test();
        GasolineCar.tooting(); // 调用接口的静态默认方法
        ElectricCar.tooting();
    }
}