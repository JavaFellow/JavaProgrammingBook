package ch08;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

import ch07.BaseFrame;

public class JInternalFrameDemo {
    void init() {
        BaseFrame f = new BaseFrame("JInternalFrame 演示");

        JInternalFrame[] iFrames = new JInternalFrame[4]; // 内部窗口数组
        JDesktopPane desktop = new JDesktopPane(); // 构造桌面面板以容纳内部窗口
        for (int i = 0; i < iFrames.length; i++) {
            iFrames[i] = new JInternalFrame("内部窗口 " + (i + 1)); // 构造内部窗口
            iFrames[i].setResizable(true);
            iFrames[i].setMaximizable(true);
            if (i % 2 == 0) {
                iFrames[i].setClosable(true);
                iFrames[i].setIconifiable(true);
            }
            iFrames[i].setSize(200, 100);
            iFrames[i].setLocation(50 - i * 15, 100 - i * 30);
            iFrames[i].setVisible(true);
            desktop.add(iFrames[i]); // 加入桌面面板
        }
        iFrames[1].toFront(); // 将第二个内部窗口置顶
        f.setContentPane(desktop); // 将桌面面板作为顶层窗口的内容面板
        f.showMe();
    }

    public static void main(String[] args) {
        new JInternalFrameDemo().init();
    }
}