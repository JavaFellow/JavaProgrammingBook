package ch14;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Description { // 定义名为Description的注解
    String author(); // author属性

    String version() default "1.0"; // version属性(指定了默认值)
}