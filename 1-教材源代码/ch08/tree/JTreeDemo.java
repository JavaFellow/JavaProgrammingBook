package ch08.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Enumeration;

import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import ch07.BaseFrame;
import ch07.ImageFactory;

public class JTreeDemo {
    public static void main(String[] args) throws IOException {
        BaseFrame f = new BaseFrame("JTree 演示");

        JTreeDemo demo = new JTreeDemo();
        DefaultMutableTreeNode root = demo.createNodesFromFile();
        JTree tree = new JTree(root); // 构造以root为根结点的树
        tree.setCellRenderer(new HardwareTreeCellRenderer()); // 设置渲染器
        JScrollPane sp = new JScrollPane(tree); // 将树放到可滚动面板中

        sp.setLocation(10, 10);
        sp.setSize(180, 200);
        f.add(sp);
        f.showMe();
    }

    /**** 从数据文件中读取结点信息并创建树 ****/
    DefaultMutableTreeNode createNodesFromFile() throws IOException {
        Hardware rootHw = new Hardware(); // 根结点的用户对象
        rootHw.setId("00"); // 根结点编号定为00
        rootHw.setName("硬件");
        rootHw.setIcon(ImageFactory.create("hardware.png"));

        DefaultMutableTreeNode root = new DefaultMutableTreeNode(rootHw); // 构造根结点

        URL url = getClass().getResource("data.txt"); // 数据文件
        InputStreamReader in = new InputStreamReader(url.openStream()); // 输入流(见第11章)
        BufferedReader reader = new BufferedReader(in); // 缓冲输入流
        String line;
        while ((line = reader.readLine()) != null) { // 按行读取数据文件
            if (line.trim().length() < 1) { // 忽略空行
                continue;
            }

            Hardware h = new Hardware(); // 构造用户对象
            String id = this.getId(line); // 取得编号
            String name = this.getName(line); // 取得名称
            h.setId(id);
            h.setName(name);

            if ("0001".equals(id)) { // 根据编号设置图标
                h.setIcon(ImageFactory.create("cpu.png"));
            } else if ("0002".equals(id)) {
                h.setIcon(ImageFactory.create("ram.png"));
            } else if ("0003".equals(id)) {
                h.setIcon(ImageFactory.create("gpu.png"));
            } else if ("0004".equals(id)) {
                h.setIcon(ImageFactory.create("hardDisk.png"));
            }

            DefaultMutableTreeNode node = new DefaultMutableTreeNode(h); // 构造子结点
            DefaultMutableTreeNode parent = this.findParent(root, node); // 找node的父结点
            parent.add(node); // 加到父结点之下
        }
        reader.close(); // 关闭缓冲输入流
        return root; // 返回根结点(唯一标识一棵树)
    }

    /**** 获得“=”左侧的编号 ****/
    String getId(String line) {
        return line.substring(0, line.indexOf("=")).trim();
    }

    /**** 获得“=”右侧的名称 ****/
    String getName(String line) {
        return line.substring(line.indexOf("=") + 1).trim();
    }

    /**** 在根结点为root的树中寻找结点node的父结点 ****/
    DefaultMutableTreeNode findParent(DefaultMutableTreeNode root, DefaultMutableTreeNode node) {
        String nodeId = ((Hardware) node.getUserObject()).getId(); // 结点node的编号

        Enumeration nodes = root.breadthFirstEnumeration(); // 广度优先遍历获得根的所有子孙
        while (nodes.hasMoreElements()) { // 根据结点编号寻找父结点
            DefaultMutableTreeNode n = (DefaultMutableTreeNode) nodes.nextElement();
            Hardware hw = (Hardware) n.getUserObject();
            String id = hw.getId();
            if (id.length() + 2 == nodeId.length() && nodeId.startsWith(id)) {
                return n;
            }
        }
        return root; // 若node是根结点的孩子，则返回根结点
    }
}