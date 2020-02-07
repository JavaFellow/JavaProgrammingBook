package ch14.test;

public class TestTarget { // 需要被测试的类
    public TestTarget() { // 提供默认构造方法以便将来通过反射机制实例化
    }

    @Testable // 以Testable注解修饰需要被测试的方法
    void doNothing() {
    }

    @Testable
    void badMethod() {
        throw new RuntimeException(); // 故意抛出异常
    }

    void noTestableMethod() { // 此方法不会被测试
    }

    @Testable(expected = "20") // 预期值与实际值不一致
    int getSum() {
        int s = 0;
        for (int i = 1; i <= 10; i++) {
            s += i;
        }
        return s;
    }

    @Testable(expected = "true") // 预期值与实际值一致
    boolean isEven() {
        int i = 10;
        return i % 2 == 0;
    }

    @Testable(expected = "CH") // 预期值与实际值不一致
    String getSubstring() {
        return "CHINA".substring(1, 2);
    }
}