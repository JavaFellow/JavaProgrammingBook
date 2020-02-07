package ch05.override;

public class Square extends Shape { // 继承形状类
    public void draw() { // 重写父类方法
        type = ShapeType.SQUARE; // 修改继承自父类的字段 (并非重写父类字段)
        System.out.println("绘制" + type + "：画4条边。");
    }
}
