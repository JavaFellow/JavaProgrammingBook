public class EnhancedForDemo {
    public static void main(String[] args) {
        int[] a = new int[5];
        for (int i = 0; i < a.length; i++) { // 用循环赋值 (元素具有一定规律) 
            a[i] = 10 - 2 * i;
        }
        int i = 0;   // 下标
        for (int e : a) {    // 增强型for循环
            System.out.print("a[" + (i++) + "]=" + e + "  ");
        }
    }
}
