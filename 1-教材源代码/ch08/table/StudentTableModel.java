package ch08.table;

import java.util.Random;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

/**** 自定义的表格数据模型类 ****/
public class StudentTableModel extends AbstractTableModel {

    /**** 表格行数据、表头、列名、列类型 ****/
    private Vector rows = new Vector();
    private Vector headers = new Vector();
    private String[] cols = { "编号", "姓名", "年龄", "专业", "是否为党员" };
    private Class[] columnTypes = { Integer.class, String.class, Integer.class, String.class, Boolean.class };

    /**** 姓名列数据、专业列可选数据 ****/
    private String[] names = { "王勇", "张红", "李明", "刘晓亮", "赵佳" };
    static String[] majors = { "软件工程", "物联网工程", "人工智能", "大数据与云计算" };

    /**** 默认构造方法 ****/
    StudentTableModel() {
        this.initTableHeaders();
        this.initTableRows();
    }

    /**** 初始化表头 ****/
    void initTableHeaders() {
        for (String c : cols) {
            headers.add(c); // 加入表头
        }
    }

    /**** 初始化表格行数据 ****/
    void initTableRows() {
        Random rand = new Random();
        for (int i = 0; i < names.length; i++) {
            Vector row = new Vector(); // 构造行向量
            row.add(i + 1); // 编号
            row.add(names[i]); // 姓名
            row.add(rand.nextInt(8) + 18); // 随机产生年龄(18~25)
            row.add(majors[rand.nextInt(majors.length)]); // 随机选择专业
            row.add(rand.nextBoolean()); // 随机产生true或false
            rows.add(row); // 加入表格行数据
        }
    }

    /**** 以下是重写父类的方法(AbstractTableModel实现了TableModel接口) ****/
    public int getRowCount() { // 得到表格总行数
        return rows.size();
    }

    public int getColumnCount() { // 得到表格总列数
        return cols.length;
    }

    public String getColumnName(int c) { // 得到指定列的名称
        return cols[c];
    }

    public Class getColumnClass(int c) { // 得到指定列的类型
        return columnTypes[c];
    }

    public Object getValueAt(int r, int c) { // 得到指定行列的数据
        return ((Vector) rows.get(r)).get(c);
    }

    public boolean isCellEditable(int r, int c) { // 设置指定行列是否可编辑
        return c != 0 && c != 1; // 编号、姓名列不可编辑
    }
}