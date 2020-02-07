package ch08.tree;

import javax.swing.Icon;

/**** JTree中结点的用户对象类 ****/
public class Hardware {
    String id; // 编号
    String name; // 名称
    Icon icon; // 图标

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }
}
