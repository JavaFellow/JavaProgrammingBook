package ch14;

/**** 复数类 ****/
class Complex {
    double real; // 实部
    double image; // 虚部

    public Complex(double real, double image) {
        this.real = real;
        this.image = image;
    }

    /**** (1) 下面的Override注解用以标记toString是重写父类Object的方法 ****/
    /**** (2) 若toString的方法名或参数写错了，编译时会报语法错误 ****/
    /**** (3) 若未指定Override注解，则即使写错了也不会报语法错误 ****/
    @Override
    public String toString() {
        String sign = image >= 0 ? " + " : " - ";
        return real + sign + Math.abs(image) + "i";
    }
}

/**** 测试类 ****/
public class OverrideAnnotationDemo {
    public static void main(String[] args) {
        Complex c1 = new Complex(5.2, 3);
        Complex c2 = new Complex(2.7, -1.6);
        System.out.println("c1 = " + c1.toString());
        System.out.println("c2 = " + c2.toString());
    }
}