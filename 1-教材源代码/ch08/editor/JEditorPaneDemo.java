package ch08.editor;

import java.awt.BorderLayout;
import java.io.IOException;
import java.net.URL;

import javax.swing.JEditorPane;
import javax.swing.JScrollPane;

import ch07.BaseFrame;

public class JEditorPaneDemo {
    public static void main(String[] args) throws IOException { // main方法声明抛出异常
        BaseFrame f = new BaseFrame("JEditorPane 演示");

        String page = "ch09/editor/DemoPage.html";
        URL url = JEditorPaneDemo.class.getClassLoader().getResource(page);
        JEditorPane editor = new JEditorPane(url); // 此构造方法声明抛出IOException异常(见第10章)
        editor.setEditable(false);

        f.setLayout(new BorderLayout());
        f.add(new JScrollPane(editor));
        f.showMe();
    }
}
