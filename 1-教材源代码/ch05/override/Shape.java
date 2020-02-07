package ch05.override;

public class Shape { // 形状类 (父类)
    String type = ShapeType.UNKNOWN; // 父类字段

    public void draw() { // 父类方法 (会被子类重写，故其方法体无实际意义)
        System.out.println("...");
    }
}
