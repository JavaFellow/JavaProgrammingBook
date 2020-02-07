public class AddDemo {
    public static void main(String[] args) {
        int a = 1, b = 3;
        char c = '我';   // '我'字符的Unicode编码为25105
        System.out.print(a + b + c + "\t");      // 打印后不换行
        System.out.print(a + b + "我" + "\t");
        System.out.print("I am " + true + "\t");
        System.out.print("我" + a + b + "\t");
        System.out.print("我" + (a + b) + "\t");
        System.out.print("我" + (a + "" + b));
    }
}
