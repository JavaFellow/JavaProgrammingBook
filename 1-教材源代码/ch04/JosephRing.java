public class JosephRing {
    public static void main(String[] args) {
        final int N = 13;   // 总人数
        final int S = 3;    // 从第S个人开始报数
        final int M = 5;    // 报数为M的人出圈
        boolean[] out = new boolean[N + 1]; // 统一下标与人的编号 (自然计数) 
        for (int i = 1; i <= N; i++) {       // 初始化数组元素
            out[i] = false;    // 报数前所有人均未出圈
        }
        int i = S;       // i存放下次开始报数的人的编号
        int n = 0;       // 已出圈的人
        int count;       // 报数为count的人
        System.out.print("出圈顺序：");
        while (n < N) {       // 仍有人在圈内
            count = 0;         // 出圈后重新计数
            while (count < M) {       // 未报数至M
                if (out[i] == false) {   // 报数的人未出圈
                    count++;       // 报数
                }
                if (count < M) {   // 未报数至M (上面的if语句可能修改了count) 
                    // 求下一个人的编号 (到达N+1则回到第1个人) 
                    i = (i + 1 > N ? 1 : i + 1);
                }
            } // 内层while结束
            System.out.print(i + "  ");  // 内层while结束，编号为i的人出圈
            out[i] = true;    // 标记出圈的人
            n++;                // 又有1人出圈
        } // 外层while结束
    }
}
