package ch08.tree;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

/**** 自定义的树结点渲染器 ****/
public class HardwareTreeCellRenderer extends DefaultTreeCellRenderer {
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) value; // 获得当前结点
        Hardware hw = (Hardware) node.getUserObject(); // 获得结点的用户对象
        String id = hw.getId();
        String name = hw.getName();
        JLabel nodeLab = new JLabel(); // 构造标签
        nodeLab.setOpaque(true);

        nodeLab.setText(id.substring(id.length() - 2) + " - " + name); // 设置标签文字
        if (hw.getIcon() != null) {
            nodeLab.setIcon(hw.getIcon()); // 设置标签图标
        }
        if (selected) {
            nodeLab.setBackground(Color.LIGHT_GRAY); // 设置选中结点的背景
        } else {
            nodeLab.setBackground(Color.WHITE);
        }
        return nodeLab; // 返回渲染后的标签
    }
}