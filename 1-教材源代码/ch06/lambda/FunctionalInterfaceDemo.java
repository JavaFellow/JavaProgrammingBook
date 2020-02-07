package ch06.lambda;

/**** 是函数式接口 ****/
interface Interface1 {
    void test1(); // 仅含一个抽象方法
}

/**** 是函数式接口 ****/
interface Interface2 {
    void test2(); // 仅含一个抽象方法

    default long cube(int n) { // 默认方法不影响函数式接口
        return n * n * n;
    }
}

/**** 不是函数式接口(含2个抽象方法的普通接口)，没有语法错误 ****/
interface Interface3 {
    void test3A();

    void test3B();
}

/**** 是函数式接口，没有语法错误 ****/
@FunctionalInterface // 通过注解开启编译器强制检查
interface Interface4 extends Interface1 {
    // 继承了父接口中唯一的抽象方法test1
}

/**** 不是函数式接口，有语法错误 ****/
@FunctionalInterface
interface Interface5 extends Interface1 {
    // 重写了父接口中唯一的抽象方法(导致本接口不含任何抽象方法)
    default void test1() {

    }
}

/**** 不是函数式接口，有语法错误 ****/
@FunctionalInterface
interface Interface6 extends Interface2 {
    // 将父接口中的默认方法重新声明为了抽象方法(导致本接口含2个抽象方法)
    long cube(int n);
}

/**** 是函数式接口，没有语法错误 ****/
@FunctionalInterface
interface Interface7 {
    void test7();

    // 将父类Object中的toString方法重新声明为了抽象方法(不计为本接口的抽象方法)
    String toString();
}

/**** 不是函数式接口(含2个抽象方法的普通接口)，有语法错误 ****/
@FunctionalInterface
interface Interface8 {
    void test8A();

    void test8B();
}

public class FunctionalInterfaceDemo {

}