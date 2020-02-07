public class Person {
    String name;
    int age; // 构造方法1、2指定了默认值，此处不再指定
    String id;

    String getName() {
        return name; // 等价于：return this.name;
    }

    int getAge() {
        return age;
    }

    void setAge(int age) { // 形参与字段重名
        this.age = age;
    }

    Person sleep(int minutes) {
        System.out.println("睡 " + minutes + " 分钟...");
        return this;
    }

    Person(String name) { // 构造方法1
        this(name, 20, "N/A"); // 调用构造方法3
    }

    Person(String name, String id) { // 构造方法2
        this(name, 20, id); // 调用构造方法3
    }

    Person(String name, int age, String id) { // 构造方法3 (完全构造方法)
        this.name = name;
        this.age = age;
        this.id = id;
    }
}
