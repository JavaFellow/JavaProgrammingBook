public class CommandArgsDemo {
    public static void main(String[] args) {
        if (args.length < 2) {    // 少于2个参数
            System.out.println("错误的命令格式，至少要指定2个int型参数！");
            System.exit(0);   // 结束虚拟机的运行 (即退出Java程序) 
        }
        int value;   // 存放参数
        // 将首个参数作为当前最大者 (注意参数均是字符串，要先解析为所需的int型) 
        int max = Integer.parseInt(args[0]);
        for (int i = 1; i < args.length; i++) {  // 从第2个参数开始比较
            value = Integer.parseInt(args[i]);
            max = (max < value ? value : max); // 修改max (找到了新的最大者) 
        }
        System.out.println("max = " + max);
    }
}
