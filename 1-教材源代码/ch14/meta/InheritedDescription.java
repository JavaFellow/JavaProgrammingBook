package ch14.meta;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**** 指明@InheritedDescription的目标类的子类也可访问author、version属性 ****/
/**** 使用@Inherited时，要同时指定保留策略为RUNTIME，否则无效 ****/
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface InheritedDescription {
    String author();

    String version() default "1.0";
}