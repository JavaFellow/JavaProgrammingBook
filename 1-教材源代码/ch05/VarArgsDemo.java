public class VarArgsDemo {
    // 变长参数的格式为“类型... 形参名”
    int getMax(int first, int... varArgs) {
        int max = first; // 将第1个作为当前最大者
        for (int i : varArgs) { // 迭代 (变长参数的本质是数组)
            max = i > max ? i : max; // 修改max
        }
        return max; // 返回max
    }

    public static void main(String[] args) {
        VarArgsDemo demo = new VarArgsDemo(); // 创建测试类的对象
        // 调用方法，分别传入1、2、6个实参
        System.out.println("max(1) = " + demo.getMax(1));
        System.out.println("max(2,1) = " + demo.getMax(2, 1));
        System.out.println("max(6,4,5,9,8,7) = " + demo.getMax(6, 4, 5, 9, 8, 7));
    }
}
