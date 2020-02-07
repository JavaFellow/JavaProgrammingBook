package ch07.event;

import java.awt.event.WindowEvent;
import java.util.EventListener;

public interface WindowListener extends EventListener {
    public void windowOpened(WindowEvent e); // 窗口首次可见时

    public void windowClosing(WindowEvent e); // 关闭窗口前

    public void windowClosed(WindowEvent e); // 关闭窗口后

    public void windowIconified(WindowEvent e); // 图标化（即最小化）窗口时

    public void windowDeiconified(WindowEvent e); // 反图标化（即还原）窗口时

    public void windowActivated(WindowEvent e); // 激活（即选中）窗口时

    public void windowDeactivated(WindowEvent e); // 反激活窗口（即由选中到未选中）时
}
