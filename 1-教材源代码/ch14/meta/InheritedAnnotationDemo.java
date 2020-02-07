package ch14.meta;

@InheritedDescription(author = "Chris")
class Parent { // 父类(使用了注解)
}

class Child extends Parent { // 子类(未使用注解)
}

public class InheritedAnnotationDemo {
    public static void main(String[] args) throws NoSuchMethodException {
        Child c = new Child();
        // 父类的@InheritedDescription注解能被子类Child继承
        InheritedDescription anno = c.getClass().getAnnotation(InheritedDescription.class);
        System.out.println("c.author = " + anno.author());
        System.out.println("c.version = " + anno.version());
    }
}