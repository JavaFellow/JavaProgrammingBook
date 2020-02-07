package ch08.table;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**** 自定义的表格单元格渲染器 ****/
public class StudentTableCellRenderer extends DefaultTableCellRenderer {
    public Component getTableCellRendererComponent(JTable tab, Object val, boolean sel, boolean focus, int row, int col) {
        setHorizontalAlignment(col == 3 ? RIGHT : CENTER); // 专业列居右，其他列居中
        setBackground(new Color(row % 2 == 0 ? 0xFFFFFF : 0xE4E4E4)); // 隔行换色

        if (col == 4) { // 是否为党员列以复选按钮显示
            JPanel cell = new JPanel(new BorderLayout()); // 构造面板组件
            JCheckBox cb = new JCheckBox("", (Boolean) val); // 根据单元格值构造复选按钮
            cb.setHorizontalAlignment(CENTER); // 复选按钮居中
            if (sel) { // 根据当前行是否被选中，设置复选按钮背景色
                cb.setBackground(new Color(184, 207, 229));
            } else {
                cb.setBackground(new Color(row % 2 == 0 ? 0xFFFFFF : 0xE4E4E4));
            }
            cell.add(cb); // 加入面板
            return cell; // 返回面板组件
        }
        // 其他列调用父类方法做默认渲染(默认为标签)
        return super.getTableCellRendererComponent(tab, val, sel, focus, row, col);
    }
}