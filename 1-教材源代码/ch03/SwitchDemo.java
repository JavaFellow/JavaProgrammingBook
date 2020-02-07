public class SwitchDemo {
    public static void main(String[] args) {
        char answer = 'A';     // char型
        float score = 48;      // float型
        String today = "Fri"; // 字符串型

        switch (answer) { // char型自动提升为int型
            case 'B': // 直接常量 (case子句控制的多条语句可以不加花括号)
                System.out.print("B");
                break; // 立即结束所在的switch语句，后同。
            case 64 + 1: // 相等 (常量表达式)
                System.out.print("A");
                break;
            case 'D': { // 花括号可以省略
                System.out.print("D");
                break;
            }
            case 'C':
                System.out.print("C");
                break;
            default: // 均不相等 (位于switch最后的子句，可以省略break语句)
                System.out.print("错误答案！");
        }
        System.out.print("\t");

        switch (answer) {
            case 'B':
                System.out.print("B");
            case 'A': // 相等 (此后不再比较，继续执行后面的case子句)
                System.out.print("A");
            case 'D':
                System.out.print("D");
            case 'C':
                System.out.print("C");
                break; // 到这里才结束switch语句
            default:
                System.out.print("错误答案！");
        }
        System.out.print("\t");

        if (score >= 0 && score <= 100) { // 判断分数范围
            switch (((int) score) / 10) { // 强制取整后做整除
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5: // 0~59
                    System.out.print("不及格");
                    break;
                case 6: // 60~69
                    System.out.print("及格");
                    break;
                case 7: // 70~79
                    System.out.print("中等");
                    break;
                case 8: // 80~89
                    System.out.print("良好");
                    break;
                case 9:
                case 10: // 90~100
                    System.out.print("优秀");
            }
        } else { // 超过范围
            System.out.print("分数小于0或大于100！");
        }
        System.out.print("\t");

        switch (today) { // JDK 7开始支持字符串表达式
            case "Mon":
                System.out.print("周一");
                break; // 一旦相等则结束switch (以正确得到today是周几)，后同
            case "Tue":
                System.out.print("周二");
                break;
            case "Wed":
                System.out.print("周三");
                break;
            case "Thu":
                System.out.print("周四");
                break;
            case "Fri":
                System.out.print("周五");
                break;
            case "Sat":
                System.out.print("周六");
                break;
            case "Sun":
                System.out.print("周日");
                break;
            default:
                System.out.print("未知！");
        }
    }
}
