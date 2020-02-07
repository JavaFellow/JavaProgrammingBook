package ch09;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**** 实现AutoCloseable接口以自定义资源类 ****/
class MyResource implements AutoCloseable {
    private String tag; // 标记资源
    private boolean isThrowExceptionOnClose; // 关闭资源时是否抛出异常

    public String getTag() {
        return tag;
    }

    public MyResource(String tag) { // 构造方法1
        this(tag, false); // 调用构造方法2
    }

    public MyResource(String tag, boolean isThrowExceptionOnClose) { // 构造方法2
        this.tag = tag;
        this.isThrowExceptionOnClose = isThrowExceptionOnClose;
    }

    public void close() throws Exception { // 重写AutoCloseable接口的方法
        System.out.print("正在关闭" + tag + "...");
        if (isThrowExceptionOnClose) {
            throw new Exception("关闭" + tag + "时发生异常...");
        }
    }
}

public class TryWithResourcesDemo {
    /**** 不带catch块和finally块的try块(try块未发生异常) ****/
    void m1() throws FileNotFoundException, IOException {
        System.out.print("m1: ");
        final String file = "C:/Windows/regedit.exe";
        // 下行的构造方法可能抛出FileNotFoundException异常
        try (FileReader r = new FileReader(file)) {
            System.out.print("成功打开文件" + file + "...");
        } // 自动调用FileReader的close方法时，可能抛出IOException异常
    }

    /**** 带catch块的try块(资源的close方法发生异常) ****/
    void m2() {
        System.out.print("\nm2: ");
        final String tag = "R";
        try (MyResource r = new MyResource(tag, true)) { // close时抛出异常
            System.out.print("成功打开" + tag + "...");
            System.out.print("正在使用" + tag + "...");
        } catch (Exception e) {
            System.out.print("关闭" + tag + "时发生异常 ...");
        }
    }

    /**** 带catch块和finally块的try块(try块发生异常) ****/
    void m3() {
        System.out.print("\nm3: ");
        final String tag = "R";
        try (MyResource r = new MyResource(tag)) {
            System.out.print("成功打开" + tag + "...");
            int a = 2 / 0;
            System.out.print("正在使用" + tag + "...");
        } catch (ArithmeticException e) {
            System.out.print("发生算术异常...");
        } catch (Exception e) { // MyResource的close方法可能抛出Exception异常
            System.out.print("关闭" + tag + "时发生异常 ...");
        } finally {
            System.out.print("成功关闭" + tag + " ...");
        }
    }

    /**** 含有多个资源声明(try块和资源的close方法均未抛出异常) ****/
    private void m4() throws Exception {
        System.out.print("\nm4: ");
        final String tag1 = "R1", tag2 = "R2";
        try (MyResource r1 = new MyResource(tag1); MyResource r2 = new MyResource(tag2)) {
            System.out.print("成功打开" + tag1 + "和" + tag2 + "...");
            System.out.print("准备关闭" + tag1 + "和" + tag2 + "...");
        } finally {
            System.out.print("成功关闭" + tag1 + "和" + tag2 + "...");
        }
    }

    /**** 不带catch块和finally块的try块(try块和资源的close方法均抛出了异常) ****/
    private void m5() throws Exception { // 由调用者处理本方法抛出的异常
        System.out.print("\nm5: ");
        final String tag = "R";
        try (MyResource r = new MyResource(tag, true)) { // close时抛出异常(被抑制)
            System.out.print("成功打开" + tag + "...");
            throw new Exception("业务逻辑发生异常..."); // try块抛出异常
        }
    }

    public static void main(String[] args) throws Exception {
        TryWithResourcesDemo demo = new TryWithResourcesDemo();
        demo.m1();
        demo.m2();
        demo.m3();
        demo.m4();

        try {
            demo.m5();
        } catch (Exception e) {
            System.out.print(e.getMessage());
            System.out.print("被抑制的异常：");
            for (Throwable ex : e.getSuppressed()) {
                System.out.print(ex.getMessage());
            }
        }
    }
}