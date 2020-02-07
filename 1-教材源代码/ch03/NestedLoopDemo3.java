import java.util.Scanner;

public class NestedLoopDemo3 {
    public static void main(String[] args) {
        int rows; // 总行数
        Scanner s = new Scanner(System.in);
        System.out.print("输入行数:");
        rows = s.nextInt();

        for (int i = -rows / 2; i <= rows / 2; i++) { // 共执行rows次
            // 打印行首的若干空格
            System.out.printf("%" + (3 * Math.abs(i) + 1) + "s", " ");
            // 打印第i行的所有数字
            for (int j = Math.abs(i) - rows / 2; j <= rows / 2 - Math.abs(i); j++) {
                System.out.printf("%-3d", rows / 2 + 1 - Math.abs(i) - Math.abs(j));
            }
            System.out.println(); // 换行
        }
    }
}
