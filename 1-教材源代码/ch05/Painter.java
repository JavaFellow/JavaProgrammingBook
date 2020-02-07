class Square { // 矩形类
}

class Triangle { // 三角形类
}

public class Painter { // 绘制器类，含有draw方法的5个重载版本
    void draw(String str) { // 版本1
        System.out.println("绘制字符串。");
    }

    void draw(Square s) { // 版本2
        System.out.println("绘制矩形。");
    }

    void draw(Square s, int x, int y) { // 版本3
        System.out.println("在指定坐标绘制矩形。");
    }

    void draw(int x, int y, Square s) { // 版本4
        System.out.println("在指定坐标绘制矩形。");
    }

    void draw(Triangle t) { // 版本5
        System.out.println("绘制三角形。");
    }
}
