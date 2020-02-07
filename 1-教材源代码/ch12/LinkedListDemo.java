package ch12;

import java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList queue = new LinkedList(); // 构造链表(作为队列使用)
        LinkedList stack = new LinkedList(); // 构造链表(作为栈使用)
        Product[] ps = ProductUtil.createProducts(); // 生成产品数组

        System.out.print("1: 入队顺序：");
        for (Product p : ps) {
            queue.offer(p); // 入队(作为链表的最后一个元素)
            System.out.print(p.getName() + "|");
        }

        System.out.print("\n2: 出队顺序：");
        Product head; // 队头(第一个元素)
        while ((head = (Product) queue.peek()) != null) { // 得到队头
            System.out.print(head.getName() + "|");
            queue.poll(); // 出队(删除第一个元素)
        }

        System.out.print("\n3: 入栈顺序：");
        for (Product p : ps) {
            stack.push(p); // 入栈(作为链表的第一个元素)
            System.out.print(p.getName() + "|");
        }

        System.out.print("\n4: 出栈顺序：");
        Product top; // 栈顶(第一个元素)
        while ((top = (Product) stack.peek()) != null) { // 得到栈顶
            System.out.print(top.getName() + "|");
            stack.pop(); // 出栈(删除第一个元素)
        }
    }
}