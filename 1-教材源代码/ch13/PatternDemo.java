package ch13;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternDemo {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("a*b"); // 根据参数指定的正则表达式创建模式
        Matcher m1 = p.matcher("aaab"); // 获得目标字符串的匹配器
        Matcher m2 = p.matcher("aabb"); // 复用模式p
        System.out.println(m1.matches()); // 执行匹配器(true)
        System.out.println(m2.matches()); // 执行匹配器(false)

        System.out.println(Pattern.matches("a*b", "b")); // 直接调用快捷方法(true)

        Pattern p2 = Pattern.compile("[/]+");
        String[] results = p2.split("张三//李四//王五///赵六/钱七"); // 按模式分割字符串
        for (String s : results) {
            System.out.print(s + "\t");
        }
    }
}