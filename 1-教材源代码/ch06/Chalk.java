package ch06;

/**** 粉笔类继承教学用具类，并实现能画画的东西接口 ****/
public class Chalk extends TeachingTool implements Drawable {
    void teaching() { // 重写父类的方法
        System.out.println("用粉笔在黑板上教学...");
    }

    public void draw() { // 实现接口的抽象方法
        System.out.println("用粉笔在地上涂鸦...");
    }

    // 测试方法
    public static void main(String[] args) {
        Chalk c = new Chalk();
        c.teaching();
        c.draw();
    }
}