package ch14.test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // 注意此行不能少
@Target(ElementType.METHOD) // 规定Testable注解只适用于普通方法
public @interface Testable {
    /**
     * 被测试方法的预期返回值(因注解的属性类型不能是Object，故定为字符串类型)
     */
    String expected() default "";
}