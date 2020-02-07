package ch09;

public class ThrowDemo {
    public static void main(String[] args) {
        int[] a = { 1, 2, 3 };
        printArray(a);
    }

    static void printArray(int a[]) {
        for (int i = 0; i < 10; i++) {
            if (i >= a.length) {
                throw new ArrayIndexOutOfBoundsException();
                // System.out.println("--------");
            }
            System.out.printf("a[%d]=%d\n", i, a[i]);
        }
    }
}