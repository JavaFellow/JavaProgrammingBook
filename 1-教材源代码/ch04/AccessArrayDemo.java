import java.util.Random;

public class AccessArrayDemo {
    public static void main(String[] args) {
        Random random = new Random();    // 创建随机数生成器对象
        int[] a = new int[16 + 1];       // 创建数组 (只使用后16个元素) 
        int temp;      // 用于交换的临时变量
        boolean exchanged;  // 每轮排序中是否发生了元素交换
        System.out.print("排序前的数组：");
        for (int i = 1; i < a.length; i++) {
            a[i] = random.nextInt(100);   // 产生0~99的随机整数 (可能出现重复) 
            System.out.printf("%-4d", a[i]);    // 打印元素，每个占4列宽度 (左对齐)
        }
        // N个元素进行冒泡排序，至多执行N-1轮。
        for (int i = 1; i < a.length - 1; i++) {
            exchanged = false;      // 每轮排序前，初始化交换标志。
            for (int j = 1; j < a.length - i; j++) {
                if (a[j] > a[j + 1]) {    // 相邻位置的元素比较
                    temp = a[j];          // 若左大右小则交换
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    exchanged = true;     // 发生了交换，修改交换标志。
                }
            }
            if (exchanged == false) {  // 若未发生任何交换，则不用继续下一轮。
                break;  // 结束外层for循环
            }
        }
        System.out.print("\n排序后的数组：");
        for (int i = 1; i < a.length; i++) {  // 打印排序后的数组
            System.out.printf("%-4d", a[i]);
        }
    }
}
