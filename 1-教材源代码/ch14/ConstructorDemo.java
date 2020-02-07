package ch14;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ConstructorDemo {
    public static void main(String[] args) {
        try {
            Class<?> cls = Class.forName("java.util.Date");

            /**** 得到Date类的所有构造方法并分别执行 ****/
            Constructor<?>[] cs = cls.getDeclaredConstructors();
            for (Constructor<?> c : cs) {
                Class<?>[] types = c.getParameterTypes(); // 得到形参类型
                Object[] values = new Object[types.length]; // 实参数组
                switch (types.length) { // 判断形参个数
                    case 1: // 1个形参(这样的构造方法有2个，类型分别为String和long)
                        if (types[0].getSimpleName().equals("String")) {
                            values[0] = "Sun, 10 Mar 2019 22:52:45 GMT+0800";
                        } else { // long
                            values[0] = 1552229565000L; // 2019-03-10 22:52:45
                        }
                        break;
                    case 3: // 3个形参(年、月、日，详见API文档)
                        values = new Object[] { 2019 - 1900, 3 - 1, 10 };
                        break;
                    case 5: // 5个形参(年、月、日、时、分)
                        values = new Object[] { 2019 - 1900, 3 - 1, 10, 22, 52 };
                        break;
                    case 6: // 6个形参(年、月、日、时、分、秒)
                        values = new Object[] { 2019 - 1900, 3 - 1, 10, 22, 52, 45 };
                        break;
                }
                Object instance = c.newInstance(values); // 构造Date对象

                /**** 构造实参表以便打印 ****/
                String valuesStr = "";
                if (types.length == 1 && types[0].getSimpleName().equals("String"))
                    valuesStr = "\"" + values[0] + "\"";
                else {
                    for (int i = 0; i < values.length; i++) {
                        valuesStr += values[i] + ", ";
                    }
                    if (values.length > 0) {
                        valuesStr = valuesStr.substring(0, valuesStr.length() - 2);
                    }
                }
                System.out.printf("%s%-38s = %3$tY年%3$tm月%3$td日 %3$tH:%3$tM:%3$tS\n", "new Date(", valuesStr + ")", instance);
            }
        } catch (ClassNotFoundException e) {
            System.out.printf("找不到类。");
        } catch (InstantiationException e) {
            System.out.printf("实例化发生错误。");
        } catch (IllegalAccessException e) {
            System.out.printf("构造方法不可访问。");
        } catch (InvocationTargetException e) {
            System.out.printf("调用构造方法时抛出异常。");
        }
    }
}