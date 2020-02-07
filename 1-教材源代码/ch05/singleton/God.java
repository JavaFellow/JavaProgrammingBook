package ch05.singleton;

public class God { // 单例类 (只有一个上帝)
    // 存放唯一对象的私有字段 (外界无法访问)，因getInstance方法
    // 要使用此字段，其是静态的，故此字段也必须是静态的。
    private static God instance = null;

    private God() { // 私有构造方法 (外界无法调用)
        System.out.println("God对象被创建了。"); // 仅作演示用
    }

    // 公有静态方法，外界通过God类名直接调用此方法，以获得唯一对象。
    public static God getInstance() {
        if (instance == null) { // 若是首次调用getInstance方法
            // 创建对象并赋给instance字段。
            // 即使多次调用getInstance方法，此行也只执行一次。
            instance = new God();
        }
        return instance; // 返回唯一对象
    }
}
