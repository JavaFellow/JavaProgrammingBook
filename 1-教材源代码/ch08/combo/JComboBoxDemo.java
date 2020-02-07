package ch08.combo;

import java.awt.BorderLayout;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ch07.BaseFrame;
import ch07.ImageFactory;

public class JComboBoxDemo {
    public static void main(String[] args) {
        BaseFrame f = new BaseFrame("JComboBox 演示");

        JComboBox box = new JComboBox(createModel()); // 构造下拉列表组件
        box.setRenderer(new CountryComboBoxCellRenderer()); // 设置渲染器
        box.setLocation(10, 10);
        box.setSize(240, 36);

        f.add(box); // 加下拉列表组件到窗口
        f.showMe();
    }

    /**** 以向量形式生成列表项数据 ****/
    static Vector createModel() {
        int n = 4;

        String[] icons = { "china.png", "usa.png", "greece.png", "brazil.png" };
        String[] countries = { "中国", "美国", "希腊", "巴西" };
        String[] descs = { "五千年历史的国家", "美利坚合众国", "欧洲文明发源地", "足球王国" };

        JLabel[] iconLabs = new JLabel[n];
        JLabel[] countryLabs = new JLabel[n];
        JLabel[] descLabs = new JLabel[n];
        JPanel[] panels = new JPanel[n];

        Vector model = new Vector();
        for (int i = 0; i < n; i++) {
            iconLabs[i] = new JLabel(ImageFactory.create(icons[i]));
            countryLabs[i] = new JLabel(countries[i]);
            descLabs[i] = new JLabel(descs[i]);

            panels[i] = new JPanel(); // 构造面板对象作为下拉列表中的项
            panels[i].setLayout(new BorderLayout()); // 边界布局
            panels[i].add(iconLabs[i], BorderLayout.WEST); // 图标加到西侧
            panels[i].add(countryLabs[i], BorderLayout.CENTER);
            panels[i].add(descLabs[i], BorderLayout.EAST); // 描述加到东侧
            model.add(panels[i]); // 将面板加入向量
        }
        return model;
    }
}