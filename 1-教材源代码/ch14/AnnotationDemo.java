package ch14;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class AnnotationDemo {
    public static void main(String[] args) throws NoSuchMethodException {
        Class<Target> c = Target.class; // 目标类
        Method[] methods = c.getDeclaredMethods(); // 获得目标类的全部方法

        /**** 获得所有使用了Description注解的方法，并分别读取各方法的注解信息 ****/
        for (Method m : methods) {
            if (m.isAnnotationPresent(Description.class)) { // 使用了Description注解
                System.out.println(m.getName() + "方法使用了Description注解");
                /**** 获得并读取注解信息 ****/
                Description annotation = m.getAnnotation(Description.class);
                System.out.print("\tauthor = " + annotation.author());
                System.out.println("\tversion = " + annotation.version());
            } else {
                System.out.println(m.getName() + "方法未使用Description注解");
            }
        }

        /**** 读取指定方法使用的所有注解 ****/
        Method m = c.getMethod("methodB");
        Annotation[] annotations = m.getAnnotations();
        System.out.print(m.getName() + "方法使用的注解：");

        for (Annotation anno : annotations) {
            System.out.print(anno.annotationType().getName() + "\t");
        }
    }
}