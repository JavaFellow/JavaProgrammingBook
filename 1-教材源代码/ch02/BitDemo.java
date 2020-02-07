public class BitDemo {
    public static void main(String[] args) {
        int a = 98, mask;
        System.out.print("~" + a + "=" + ~a + "    ");
        mask = 169;
        System.out.print(a + "&" + mask + "=" + (a & mask) + "    ");
        mask = 86;
        System.out.print(a + "|" + mask + "=" + (a | mask) + "    ");
        mask = 86;
        System.out.print(a + "^" + mask + "=" + (a ^ mask));
    }
}
