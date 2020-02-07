package ch06;

public class Ellipse extends RingShape {    // 椭圆形 (继承自环形) 
    void draw() {    // 重写父类抽象方法
        System.out.println("绘制椭圆形。");
    }
}
