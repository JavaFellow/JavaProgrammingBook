package ch05.override;

public class Triangle extends Shape { // 继承形状类
    public void draw() { // 重写父类方法
        type = ShapeType.TRIANGLE;
        System.out.println("绘制" + type + "：画3条边。");
    }
}
