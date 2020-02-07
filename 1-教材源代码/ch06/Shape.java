package ch06;

public abstract class Shape { // 抽象类
    abstract void draw();  // 抽象方法

    void setColor(java.awt.Color c) { // 抽象类可以含普通方法 (Color为颜色类) 
        System.out.println("设置形状的颜色：" + c.toString());
    }
}
