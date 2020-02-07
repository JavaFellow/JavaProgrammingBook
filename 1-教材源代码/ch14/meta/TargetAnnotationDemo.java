package ch14.meta;

public class TargetAnnotationDemo {

    @MethodAnnotation // 非法
    int i; // 字段

    @MethodAnnotation
    public TargetAnnotationDemo() { // 构造方法
    }

    @MethodAnnotation
    void m1() { // 普通方法
    }
}