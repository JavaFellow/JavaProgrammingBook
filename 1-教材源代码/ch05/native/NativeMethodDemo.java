public class NativeMethodDemo { // ???
    static {
        System.loadLibrary("NativeMethod"); // ??NativeMethod.dll??
    }

    public static void main(String[] args) {
        NativeMethod test = new NativeMethod();
        test.sayHello();
        System.out.println(test.doCalc(16));
    }
}
