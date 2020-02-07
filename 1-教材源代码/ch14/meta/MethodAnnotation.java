package ch14.meta;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ ElementType.CONSTRUCTOR, ElementType.METHOD })
public @interface MethodAnnotation { // 此注解可用于构造方法和普通方法

}