package ch13;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatcherDemo {
    public static void main(String[] args) {
        Pattern p1 = Pattern.compile("[a]*b"); // 零到多个a后跟一个b
        Matcher m1 = p1.matcher("aabfooaaabfooabfoob");
        System.out.printf("%s, %s\n", m1.lookingAt(), m1.matches()); // true,false
        while (m1.find()) { // 找到下一个匹配的子串
            System.out.printf("索引[%2d ~ %2d]处匹配到 %s\n", m1.start(), m1.end() - 1, m1.group());
        }

        Pattern p2 = Pattern.compile("[/]+"); // 一到多个/
        Matcher m2 = p2.matcher("张三/李四//王五///赵六/钱七");
        System.out.println(m2.replaceAll(" | ")); // 张三 | 李四 | 王五 | 赵六 | 钱七
        System.out.println(m2.replaceFirst(" | ")); // 张三 | 李四//王五///赵六/钱七
    }
}