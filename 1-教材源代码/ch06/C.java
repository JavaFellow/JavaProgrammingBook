package ch06;

public interface C extends A, B {// 接口C继承接口A和B
    int M = SIZE;      // 直接书写父接口的字段名，合法，M=2
    int N = A.SIZE;    // 通过“父接口名.字段名”显式访问，合法，N=2
    int P = VALUE;     // 非法，不知道访问的是哪个父接口的字段
    int Q = B.VALUE;   // 合法，Q=3
}
