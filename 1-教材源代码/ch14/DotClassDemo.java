package ch14;

public class DotClassDemo {
    public static void main(String[] args) {
        System.out.printf("1: %-24s", Integer.class.getName());
        System.out.printf("2: %-24s\n", BOOL.class.getName());
        System.out.printf("3: %-24s", DotClassDemo.class.getName());
        System.out.printf("4: %-24s\n", byte.class.getName());
        System.out.printf("5: %-24s", void.class.getName());
        System.out.printf("6: %-24s\n", int[][][].class.getName());
    }
}