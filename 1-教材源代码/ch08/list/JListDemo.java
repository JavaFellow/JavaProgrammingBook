package ch08.list;

import java.awt.FlowLayout;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import ch07.BaseFrame;

public class JListDemo {
    public static void main(String[] args) {
        BaseFrame f = new BaseFrame("JList 演示");

        JList[] lists = new JList[3]; // 列表组件数组
        JScrollPane[] sps = new JScrollPane[3]; // 可滚动面板数组
        String[] cities = { "北京", "上海", "深圳", "武汉", "杭州", "成都", "合肥" };

        /**** 左上部列表 ****/
        lists[0] = new JList(cities);
        lists[0].setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // 单选

        /**** 右上部列表 ****/
        JPanel[] items = new JPanel[cities.length]; // 右上部及下部列表的每一项都是面板
        Vector v = new Vector(); // 构造向量
        for (int i = 0; i < cities.length; i++) {
            JLabel order = new JLabel("  " + (i + 1) + "  ");
            order.setOpaque(true);
            items[i] = new JPanel(new FlowLayout(FlowLayout.LEFT));
            items[i].add(order); // 将序号标签加入面板
            items[i].add(new JLabel(cities[i])); // 将城市标签加入面板
            v.add(items[i]); // 将面板作为列表项加入向量
        }
        lists[1] = new JList(v); // 根据向量构造列表组件
        lists[1].setVisibleRowCount(-1); // 设置列表组件显示的行数
        lists[1].setLayoutOrientation(JList.VERTICAL_WRAP); // 垂直方向自动换列
        lists[1].setCellRenderer(new CityListCellRenderer()); // 设置列表单元渲染器
        lists[1].setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION); // 连续多选

        /**** 下部列表 ****/
        lists[2] = new JList();
        lists[2].setModel(lists[1].getModel()); // 复用右上部列表的模型
        lists[2].setVisibleRowCount(-1);
        lists[2].setLayoutOrientation(JList.HORIZONTAL_WRAP); // 水平方向自动换行
        lists[2].setCellRenderer(new CityListCellRenderer());
        lists[2].setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); // 任意多选
        for (int i = 0; i < lists.length; i++) {
            sps[i] = new JScrollPane(lists[i]); // 将列表组件加入可滚动面板
            f.add(sps[i]); // 将可滚动面板加入窗口
        }

        sps[0].setLocation(10, 10);
        sps[0].setSize(70, 90);
        sps[1].setLocation(90, 10);
        sps[1].setSize(200, 90);
        sps[2].setLocation(10, 110);
        sps[2].setSize(280, 70);

        f.showMe();
    }
}