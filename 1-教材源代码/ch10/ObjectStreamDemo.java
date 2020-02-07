package ch10;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Button implements Serializable { // 让按钮对象可序列化
    int width = 30; // 按钮宽度
    int height = 20; // 按钮高度
    String label = "确定"; // 按钮上文字

    void printMe() { // 打印按钮信息
        System.out.println("按钮状态——宽度：" + width + "，高度：" + height + "，文字：" + label);
    }
}

class Window implements Serializable { // 让按钮对象可序列化
    static int x = 5; // 窗口左上角横坐标(不写出)
    transient int y = 10; // 窗口左上角纵坐标(不写出)
    int width = 640; // 窗口宽度
    int height = 480; // 窗口高度
    String title = "测试窗口"; // 窗口标题栏文字
    Button b = new Button(); // 对象类型的成员

    void printMe() { // 打印窗口信息
        System.out.println("窗口状态——左上角位置：(" + x + "，" + y + ")，宽度：" + width + "，高度：" + height + "，标题栏文字：" + title);
    }
}

public class ObjectStreamDemo {
     // 存储对象状态的文件
    String dataFileName = "E:/WindowObject.dat";

    public static void main(String[] args) throws IOException {
        ObjectStreamDemo demo = new ObjectStreamDemo();
        Window w1 = new Window(); // 要保存到文件的窗口对象
        Window w2 = null; // 从文件中取得的窗口对象
        demo.saveWindowToFile(w1);
        w2 = demo.loadWindowFromFile();
        w2.printMe();
        w2.b.printMe();
    }

     // 将窗口对象w的状态保存到文件
    void saveWindowToFile(Window w) throws IOException {
        FileOutputStream fout = null;
        ObjectOutputStream out = null; // 对象输出流
        try {
            fout = new FileOutputStream(dataFileName);
            out = new ObjectOutputStream(fout); // 构造对象输出流
            out.writeObject(w); // 序列化
        } catch (FileNotFoundException e) {
            System.out.println("建立文件失败！");
        } catch (IOException e) {
            System.out.println("写出发生了I/O错误！");
        } finally {
            if (out != null) { // 只关闭处理流
                out.close();
            }
        }
    }

     // 从文件中取得窗口对象
    Window loadWindowFromFile() throws IOException {
        Window w = null;
        FileInputStream fin = null;
        ObjectInputStream in = null; // 对象输出流
        try {
            fin = new FileInputStream(dataFileName);
            in = new ObjectInputStream(fin); // 构造对象输入流
            w = (Window) in.readObject(); // 反序列化并造型
        } catch (FileNotFoundException e) {
            System.out.println("读取文件失败！");
        } catch (IOException e) {
            System.out.println("读取发生了I/O错误！");
        } catch (ClassNotFoundException e) { // 反序列化要抛出异常
            System.out.println("找不到相应的类！");
        } finally {
            if (in != null) { // 只关闭处理流
                in.close();
            }
        }
        return w; // 返回窗口对象
    }
}
