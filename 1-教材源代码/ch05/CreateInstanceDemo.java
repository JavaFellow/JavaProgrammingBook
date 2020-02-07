package ch05;

class Food { // 食物
}

class Fruit extends Food { // 水果继承食物
    Fruit() { // 系统会先调用Food()
        System.out.println("Fruit()");
    }

    Fruit(String color) { // 系统会先调用Food()
        System.out.println("Fruit(String)");
    }
}

class Apple extends Fruit { // 苹果继承水果
    Apple() { // 系统会先调用Fruit()
        System.out.println("Apple()");
    }

    Apple(String color) {
        this(color, 0); // 显式调用Apple(String, int)
        System.out.println("Apple(String)");
    }

    Apple(String color, int count) {
        super(color); // 显式调用Fruit(String)
        System.out.println("Apple(String, int)");
    }
}

public class CreateInstanceDemo { // 测试类
    public static void main(String[] args) {
        Apple a1 = new Apple();
        System.out.println();

        Apple a2 = new Apple("red");
        System.out.println();

        Apple a3 = new Apple("green", 20);
    }
}
