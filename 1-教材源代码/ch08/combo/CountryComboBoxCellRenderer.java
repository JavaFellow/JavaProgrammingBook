package ch08.combo;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

public class CountryComboBoxCellRenderer implements ListCellRenderer {
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        JPanel item = (JPanel) value; // 获得当前列表项
        JLabel countryLab = (JLabel) item.getComponent(1); // 获得当前列表项中的组件
        JLabel descLab = (JLabel) item.getComponent(2);
        descLab.setForeground(new Color(0x888888));

        if (!isSelected) { // 如果当前列表项未被选中
            if (index % 2 == 0) { // 隔行更换背景色
                item.setBackground(new Color(0xFFFFFF));
            } else {
                item.setBackground(new Color(0xD0D0D0));
            }
            countryLab.setForeground(Color.BLACK);
        } else { // 如果当前列表项是选中的
            item.setBackground(Color.DARK_GRAY);
            countryLab.setForeground(Color.WHITE);
        }
        return item; // 返回渲染后的列表项
    }
}