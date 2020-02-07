package ch14;

public class Target {
    @Description(author = "Daniel Hu") // 使用之前定义的注解描述方法methodA
    public void methodA() {
    }

    @Deprecated
    @Description(author = "Bill Gates", version = "1.1") // 方法methodB使用了多个注解
    public void methodB() {
    }
}