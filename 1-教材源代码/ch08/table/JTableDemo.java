package ch08.table;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;

import ch07.BaseFrame;

public class JTableDemo {
    public static void main(String[] args) {
        BaseFrame f = new BaseFrame("JTable 演示");

        JTableDemo demo = new JTableDemo();
        JScrollPane sp = new JScrollPane(demo.createTable()); // 创建表格并加入可滚动面板
        sp.setSize(500, 140);
        sp.setLocation(10, 10);

        f.add(sp);
        f.setSize(500, 200);
        f.showMe();
    }

    /**** 创建表格组件 ****/
    JTable createTable() {
        StudentTableModel model = new StudentTableModel(); // 构造表格模型
        JTable table = new JTable(model); // 以指定模型构造表格
        TableRowSorter sorter = new TableRowSorter(model); // 构造表格行排序器(单击列头排序)
        table.setRowSorter(sorter); // 设置排序器
        table.setRowHeight(20); // 设置表格的行高
        this.setCellRendererAndEditor(table);
        this.setColumnWidth(table);
        return table; // 返回表格组件
    }

    /**** 设置表格的渲染器和编辑器 ****/
    void setCellRendererAndEditor(JTable table) {
        TableColumnModel colModel = table.getColumnModel(); // 得到表格列模型
        StudentTableCellRenderer renderer = new StudentTableCellRenderer(); // 构造渲染器

        for (int i = 0; i < colModel.getColumnCount(); i++) { // 设置每一列的渲染器
            colModel.getColumn(i).setCellRenderer(renderer);
        }
        TableColumn majorCol = colModel.getColumn(3); // 得到专业列
        JComboBox cb = new JComboBox(StudentTableModel.majors); // 构造下拉列表
        DefaultCellEditor editor = new DefaultCellEditor(cb); // 构造单元格编辑器(下拉列表形式)
        majorCol.setCellEditor(editor); // 设置专业列的编辑器
    }

    /**** 设置表格列的宽度 ****/
    void setColumnWidth(JTable table) {
        TableColumnModel colModel = table.getColumnModel();
        for (int i = 0; i < colModel.getColumnCount(); i++) {
            if (i == 0 || i == 2) { // 设置编号、年龄列的最小/最大宽度
                colModel.getColumn(i).setMinWidth(30);
                colModel.getColumn(i).setMaxWidth(50);
            }
        }
    }
}