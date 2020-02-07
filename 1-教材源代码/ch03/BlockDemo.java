public class BlockDemo {
    public static void main(String[] args) {
        {   // 语句块1 (空语句块) 
        }
        int a = 1;
        {   // 语句块2
            System.out.println(a);          // 访问语句块外的变量a，打印1。
            int i = 2;   // 在语句块内声明变量
            int a = 3;   // 非法 (与语句块外的变量a重名) 
            {   // 语句块3 (嵌套在语句块2内部) 
                System.out.println(a);      // 打印1
            }
        }
        System.out.println(i);    // 非法 (此处不能访问语句块2中的变量i) 
        {   // 语句块4 (与语句块1、2并列) 
            int i = 4;   // 与语句块2中的变量i重名
            System.out.println(i);      // 打印4
        }
    }
}
