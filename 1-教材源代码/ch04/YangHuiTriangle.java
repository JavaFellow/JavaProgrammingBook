public class YangHuiTriangle {
    public static void main(String[] args) {
        final int N = 10;    // 阶数
        int[][] a = new int[N][];   // 省略了列数 (因每行列数不同) 
        for (int i = 0; i < a.length; i++) {   // 循环N次
            a[i] = new int[i + 1];   // 第i行 (从0开始) 有i+1列
            a[i][0] = 1;    // 每行第一列为1
            a[i][a[i].length - 1] = 1;  // 每行最后一列为1 (可写为a[i][i]=1) 
        }
        for (int i = 2; i < a.length; i++) {   // 从第3行开始为元素赋值
            // 从第2列开始为元素赋值 (不包括最后一列) 
            for (int j = 1; j < a[i].length - 1; j++) {
                a[i][j] = a[i - 1][j] + a[i - 1][j - 1];
            }
        }
        for (int i = 0; i < a.length; i++) {  // 打印N行
            for (int j = 0; j < a[i].length; j++) {    // 打印第i行
                System.out.printf("%-4d", a[i][j]);   // 打印元素
            }
            System.out.println();  // 每打印一行换行 (属于外层for) 
        }
    }
}
