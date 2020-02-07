package ch06;

public class Circle extends RingShape {    // 圆形 (继承自环形) 
    void draw() {    // 重写父类抽象方法
        System.out.println("绘制圆形。");
    }
}
