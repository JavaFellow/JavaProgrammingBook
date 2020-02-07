public class ScopeDemo {
    int i = 1;                 
    int m = 3, n = m + 1;   // 合法：声明n时访问之前已声明的m 
    int j = k + 3;            // 非法：不能访问后面声明的字段k 

    void m1(int n, int arg) {   // 合法：形参n可以与字段重名 
        int i = -1;                // 合法：方法体中的局部变量可以与字段重名 
        int n = 9;                 // 非法：方法体中的局部变量不能与形参重名 
        int value = 100;          
        System.out.println(m);   // 合法：在方法体中访问之前声明的字段 (打印3) 
        System.out.println(k);   // 合法：在方法体中访问后面声明的字段 (打印5) 
        System.out.println(i);   // 合法：局部变量i有效，字段i被屏蔽 (打印 -1) 
        n = 9;                       // 合法：修改的是形参n而非字段n
        int p = 10;                 
        if (p > 0) {
            int q = 12;               // 合法：在语句块中可以声明局部变量
            int p = 20;               // 非法：不能与方法体中之前声明的变量重名 (与C/C++不同) 
            System.out.println(p); // 合法：在语句块中访问方法体中之前声明的变量 (打印10) 
            System.out.println(q); 
            System.out.println(k); // 合法：在语句块中访问后面声明的字段 (打印5)
        }
        if (i > 0) {      // 下面两行代码虽然不会执行，但仍要被编译
            int p = 30;   // 非法：原因同第17行
            int q = 22;   // 合法：此处的q与第16行的q分属不同的语句块 
        }
        System.out.println(p);   // 合法：打印10
        System.out.println(q);   // 非法：在语句块外不能访问语句块内声明的变量 
        int q = 13;                // 合法：方法体中的变量可以与之前语句块中的变量重名 
    }

    void m2(int arg) {           // 合法 ：不同方法的形参可以重名 
        int value = 200;         // 合法：不同方法的局部变量可以重名 
        System.out.println(p);  // 非法：不能访问不同方法中声明的变量 
    }

    int k = 5;  // 合法：即使在方法后声明字段，各方法也能访问该字段 
}
