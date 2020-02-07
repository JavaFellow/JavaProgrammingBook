package ch05;

enum WeekDay { // 枚举类型
    MON("Monday", "星期一"), // 定义枚举常量时调用构造方法
    TUE("Tuesday", "星期二"),
    WED("Wednesday", "星期三"),
    THU("Thursday", "星期四"),
    FRI("Friday", "星期五"),
    SAT("Saturday", "星期六"),
    SUN("Sunday", "星期日"); // 结束的分号不能省略

    private String enName, cnName; // 字段 (存放枚举常量的英、中文描述)

    // 构造方法 (不允许在枚举类型外部通过构造方法创建枚举对象，故是私有的)
    private WeekDay(String enName, String cnName) {
        this.enName = enName;
        this.cnName = cnName;
    }

    public String getEnName() { // getter
        return enName;
    }

    public String getCnName() {
        return cnName;
    }
}

public class EnumDemo2 { // 测试类
    public static void main(String[] args) {
        System.out.printf("%-6s %-10s %-12s %s\n", "序数", "枚举常量", "英文描述", "中文描述");
        System.out.print("-------------------------------------------------\n");
        for (WeekDay d : WeekDay.values()) {
            System.out.printf("%-8d %-14s %-16s %s\n", d.ordinal(), d.name(), d.getEnName(), d.getCnName());
        }
    }
}
