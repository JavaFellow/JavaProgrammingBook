package ch08;

import java.awt.FlowLayout;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JSpinner;
import javax.swing.JSpinner.DateEditor;
import javax.swing.JSpinner.DefaultEditor;

import ch07.BaseFrame;

import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;

public class JSpinnerDemo {
    public static void main(String[] args) throws ParseException {
        BaseFrame f = new BaseFrame("JSpinner 演示");
        f.setLayout(new FlowLayout());

        JSpinner s0 = new JSpinner(); // 默认微调按钮
        JSpinner s1 = new JSpinner(new SpinnerNumberModel(120, 0, 255, 1)); // 数值型

        String[] weeks = { "周一", "周二", "周三", "周四", "周五", "周六", "周日" };
        JSpinner s2 = new JSpinner(new SpinnerListModel(weeks)); // 列表型
        ((DefaultEditor) s2.getEditor()).getTextField().setEditable(false); // 禁止编辑

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); // 日期格式化器
        Date now = new Date(); // 当前日期
        Date min = format.parse("1995-01-01"); // 最小日期
        Date max = format.parse("2020-12-31"); // 最大日期

        SpinnerDateModel m3 = new SpinnerDateModel(now, min, max, Calendar.DAY_OF_WEEK);
        JSpinner s3 = new JSpinner(m3); // 日期型
        DateEditor editor = new DateEditor(s3, "yyyy年MM月dd日"); // 编辑器
        s3.setEditor(editor); // 设置编辑器

        f.add(s0);
        f.add(s1);
        f.add(s2);
        f.add(s3);
        f.showMe();
    }
}