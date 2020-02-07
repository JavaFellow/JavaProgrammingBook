package ch08.list;

import java.awt.Color;
import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

/**** 自定义列表单元渲染器 ****/
public class CityListCellRenderer extends DefaultListCellRenderer {
    Color unselectedBg = new Color(0xFFFFFF); // 未选中项的背景色
    Color selectedBg = new Color(0x666666); // 已选中项的背景色
    Color unselectedFg = new Color(0x000000); // 未选中项的前景色
    Color selectedFg = new Color(0xFFFFFF); // 已选中项的前景色

    /**** 重写父类方法(列表组件在显示其包含的每个列表项时都会调用此方法) ****/
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        JPanel item = (JPanel) value; // 得到当前列表项
        JLabel city = (JLabel) item.getComponent(1); // 得到当前项中的组件
        // 根据当前项是否被选中，设置不同的背景、前景色
        item.setBackground(isSelected ? selectedBg : unselectedBg);
        city.setForeground(isSelected ? selectedFg : unselectedFg);
        return item; // 返回渲染后的列表项
    }
}