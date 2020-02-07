package ch05;

class Parent { // 默认继承Object类
    // 未重写父类Object的任何方法
}

class Child extends Parent { // 继承Parent类
    int seriesNo; // 序列号字段

    public Child(int seriesNo) { // 构造方法
        this.seriesNo = seriesNo;
    }

    public int hashCode() { // 重写Object类的方法
        return seriesNo; // 以序列号字段作为对象的哈希码
    }

    public String toString() { // 重写Object类的方法
        return "我的序列号是：" + seriesNo; // 自定义对象的文字描述
    }
}

public class ObjectClassDemo { // 测试类
    public static void main(String[] args) {
        Parent p = new Parent();
        Child c = new Child(10001);

        System.out.println("p的哈希码 = " + p.hashCode());
        System.out.println("c的哈希码 = " + c.hashCode() + "\n");
        System.out.println("p的文字描述 = " + p.toString());
        System.out.println("c的文字描述 = " + c.toString() + "\n");
        System.out.println("p所属的类 = " + p.getClass().getName());
        System.out.println("c所属的类 = " + c.getClass().getName());
    }
}
