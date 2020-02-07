package ch14.test;

import java.lang.reflect.Method;

public class TestLauncher { // 单元测试启动类
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        int pass = 0, fail = 0; // 测试成功或失败的方法个数
        if (args.length != 1) { // 被测试的类以命令行参数指定
            System.out.println("错误，必须指定要测试的类。");
            return;
        }

        Class<?> targetClass = Class.forName(args[0]); // 得到被测试类的Class对象
        Object targetObj = targetClass.newInstance(); // 实例化被测试类
        Method[] methods = targetClass.getDeclaredMethods(); // 得到被测试类的方法

        for (Method m : methods) {
            if (m.isAnnotationPresent(Testable.class)) { // 若方法使用了Testable注解
                Class<?> returnType = m.getReturnType(); // 得到被测试方法的返回类型
                Object returnVal = null; // 被测试方法的实际返回值
                try {
                    returnVal = m.invoke(targetObj); // 执行被测试方法
                } catch (Throwable e) { // 捕获到异常则认为方法执行失败
                    System.out.println("→方法 " + m.getName() + " 执行时发生异常。");
                    fail++;
                    continue; // 不再进行返回值与预期值的比较
                }

                /**** 若被测方法未抛出异常，继续比较返回值与预期值 ****/
                Testable anno = m.getAnnotation(Testable.class); // 得到方法的注解
                String expectedStr = anno.expected(); // 获得预期值(字符串类型)
                Object expectedVal = null;

                /** 根据方法返回类型，将字符串转换成相应类型的值 **/
                if (returnType == int.class) {
                    expectedVal = Integer.parseInt(expectedStr);
                } else if (returnType == float.class) {
                    expectedVal = Float.parseFloat(expectedStr);
                } else if (returnType == String.class) {
                    expectedVal = expectedStr;
                } else if (returnType == boolean.class) {
                    expectedVal = Boolean.parseBoolean(expectedStr);
                }

                if (expectedVal != null) { // 注解指定了预期值
                    if (expectedVal.equals(returnVal)) { // 与实际值一致
                        System.out.println("　方法 " + m.getName() + " 成功执行。");
                        pass++;
                    } else { // 与实际值不一致
                        System.out.println("→方法 " + m.getName() + " 的实际返回值为 " + returnVal + "，但预期值为 " + expectedStr + "。");
                        fail++;
                    }
                } else { // 注解未指定预期值
                    System.out.println("　方法 " + m.getName() + " 成功执行。");
                    pass++;
                }
            }
        }
        System.out.println("----------------------------------------------------");
        System.out.println("测试完毕，成功 " + pass + " 个，失败 " + fail + " 个。");
    }
}