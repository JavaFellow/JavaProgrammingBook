package ch05;

enum ShapeType { // 枚举类型
    UNKNOWN, SQUARE, TRIANGLE, CIRCLE // 若干枚举常量
}

public class EnumDemo { // 测试类
    public static void main(String[] args) {
        ShapeType[] types = ShapeType.values(); // 得到所有的枚举常量
        for (ShapeType t : types) {
            System.out.println(t.ordinal() + ": " + t.name());
        }

        ShapeType type = ShapeType.TRIANGLE; // 声明和初始化枚举对象
        System.out.println(type.getDeclaringClass().getName());

        switch (type) {
            case UNKNOWN:
                System.out.println("未知形状");
                break;
            case SQUARE:
                System.out.println("正方形");
                break;
            case TRIANGLE:
                System.out.println("三角形");
                break;
            case CIRCLE:
                System.out.println("圆形");
                break;
        }
    }
}
