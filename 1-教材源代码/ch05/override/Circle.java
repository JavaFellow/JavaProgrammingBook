package ch05.override;

public class Circle extends Shape { // 继承形状类
    public void draw() { // 重写父类方法
        type = ShapeType.CIRCLE;
        System.out.println("绘制" + type + "：画1个圆。");
    }
}
