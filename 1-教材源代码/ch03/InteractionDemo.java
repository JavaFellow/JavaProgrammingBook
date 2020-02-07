import java.util.Scanner;

public class InteractionDemo {
    public static void main(String[] args) {
        int option;   // 存放输入选项
        int i;
        float f;
        String s;
        System.out.println("---------- 选项菜单 --------");
        System.out.println("1：输入整数      2：输入小数   \n3：输入字符串    0：退出    ");
        System.out.println("----------------------------");
        Scanner scanner = new Scanner(System.in);
        loop: while (true) {   // 循环条件永远为true (用break语句结束) 
            System.out.print("选项：");
            option = scanner.nextInt();   // 等待输入选项
            switch (option) {   // 判断输入的选项
                case 0:           // 退出
                    System.out.print("\t确定要退出吗 (Y/N) ：");
                    s = scanner.next();    // 等待输入字符串
                    // 判断字符串是否相等不要用“==”运算符 (见第15章) 
                    if (s.equalsIgnoreCase("Y")) {
                        System.out.println("\t程序退出！");
                        break loop;    // 结束while循环
                    } else {
                        break;          // 结束switch
                    }
                case 1:                 // 整数
                    System.out.print("\t请输入整数：");
                    i = scanner.nextInt();     // 等待输入整数
                    System.out.println("\t你输入的是" + i + "。");
                    break;
                case 2:
                    System.out.print("\t请输入小数：");
                    f = scanner.nextFloat();   // 等待输入小数
                    System.out.println("\t你输入的是" + f + "。");
                    break;
                case 3:
                    System.out.print("\t请输入字符串：");
                    s = scanner.next();
                    System.out.println("\t你输入的是\"" + s + "\"。");
                    break;
                default:                // 其他选项
                    System.out.println("\t请输入正确的选项！");
            }  // switch结束
        }  // while结束
    }
}
