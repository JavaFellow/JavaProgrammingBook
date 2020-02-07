package ch14;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodDemo {
    public static void main(String[] args) {
        if (args.length < 1) { // 判断命令行参数个数
            System.out.print("\t格式错误，正确用法：java ch17/MethodDemo 方法名 实参1 实参2 ...");
            return;
        }

        try {
            Class<?> theClass = Class.forName("java.lang.Math"); // 要调用的方法所在的类
            Class<?>[] paramTypes = new Class<?>[args.length - 1]; // 方法的形参类型
            for (int i = 0; i < paramTypes.length; i++) {
                paramTypes[i] = double.class; // 形参均为double型
            }

            /**** 命令行的首个参数作为要调用的方法名，后面的参数作为方法实参，然后调用方法 ****/
            Method theMethod = theClass.getDeclaredMethod(args[0], paramTypes);
            Double[] theArgs = new Double[paramTypes.length];
            for (int i = 0; i < theArgs.length; i++) {
                theArgs[i] = Double.parseDouble(args[i + 1]);
            }
            Object result = theMethod.invoke(null, (Object[]) theArgs);

            /**** 构造实参表以便打印 ****/
            StringBuffer argsStr = new StringBuffer();
            for (int i = 0; i < theArgs.length; i++) { //
                argsStr.append(args[i + 1]).append(", ");
            }
            argsStr.delete(argsStr.length() - 2, argsStr.length()); // 删除最后的逗号及空格
            System.out.printf("\t%s.%s(%s) = %s", theClass.getSimpleName(), theMethod.getName(), argsStr, result);
        } catch (ClassNotFoundException e) {
            System.out.printf("\t找不到类：%s。", e.getMessage());
        } catch (NoSuchMethodException e) {
            System.out.printf("\t找不到方法：%s。", e.getMessage());
        } catch (IllegalAccessException e) {
            System.out.printf("\t方法 %s 不可访问。" + e.getMessage());
        } catch (InvocationTargetException e) {
            System.out.printf("\t调用方法 %s 时抛出异常：%s。", args[0], e.getTargetException().getMessage());
        }
    }
}