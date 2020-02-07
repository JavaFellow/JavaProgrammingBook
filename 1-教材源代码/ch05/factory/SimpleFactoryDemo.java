package ch05.factory;

class Auto { // 抽象产品类
    public void start() { // 规定各个子类应具有的行为
        // 此处编写任何代码都没有实际意义 (子类会重写此方法)
    }
}

class Benz extends Auto { // 具体产品子类
    public void start() { // 重写父类方法
        System.out.println("启动奔驰");
    }
}

class Bmw extends Auto {
    public void start() {
        System.out.println("启动宝马");
    }
}

enum AutoType { // 具体产品类型
    BENZ, BMW
}

class AutoFactory { // 产品工厂类
    public static Auto create(AutoType type) { // 静态方法
        switch (type) {
            case BENZ:
                return new Benz(); // 子类对象一定是父类对象
            case BMW:
                return new Bmw();
            default:
                return null;
        }
    }
}

public class SimpleFactoryDemo { // 测试类
    public static void main(String[] args) {
        // 调用产品工厂的静态方法创建具体产品对象
        Auto a1 = AutoFactory.create(AutoType.BENZ);
        Auto a2 = AutoFactory.create(AutoType.BMW);
        a1.start(); // 使用具体产品对象
        a2.start();
    }
}
