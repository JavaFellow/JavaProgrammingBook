package ch05;

class Father { // 父类 (默认继承Object类)
    protected int m = 2; // 保护字段
    private int n = 4; // 私有字段

    public Father() { // 无参构造方法
    }

    public Father(String s) { // 有参构造方法
    }

    public void methodA() { // 公有方法
    }

    void methodB() { // 默认权限方法
    }

    private void methodC() { // 私有方法
    }

    public void testFather(Father f) { // 形参为父类对象
    }
}

public class Son extends Father { // 子类Son继承父类Father
    public void testSon(Son s) { // 形参为子类对象
    }

    public static void main(String[] args) {
        Son s1 = new Son();// 创建子类对象 (该无参构造方法由系统提供，而非来自父类)

        System.out.println(s1.m); // 合法 (若Father与Son不在同一包中也合法)
        System.out.println(s1.n); // 非法
        s1.toString(); // 合法 (toString方法是Object类的方法)
        s1.methodA(); // 合法
        s1.methodB(); // 合法 (若Father与Son不在同一包中则非法)
        s1.methodC(); // 非法
        s1.testFather(s1); // 合法 (子类对象可以赋给父类引用)

        Father f = new Father(); // 创建父类对象

        s1.testSon(f); // 非法 (父类对象不能赋给子类引用)
        Son s2 = new Son("test"); // 非法 (子类不会自动拥有父类的构造方法)
    }
}
