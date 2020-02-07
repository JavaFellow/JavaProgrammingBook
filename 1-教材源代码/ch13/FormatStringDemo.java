package ch13;

import java.math.BigInteger;
import java.util.Date;

public class FormatStringDemo {
    public static void main(String[] args) {
        // +
        System.out.printf("%+f|%+X|%+f|%+d|%n", 1.2, new BigInteger("32767"), -1D, (int) '我');
        // 空格
        System.out.printf("% f|% X|% f|% d|%n", 1.2, new BigInteger("32767"), -1D, (int) '我');
        // 宽度W和左对齐-
        System.out.printf("%10s|%-14E|%8o|%2A|%-12x|%n", "Java语言", 64.5, 32767, -1D, 65537L);
        // 0
        System.out.printf("%014E|%08o|%02A|%012x|%n", 64.5, 32767, -1D, 65537L);
        // #
        System.out.printf("%#X|%#o|%#x|%#e|%#f|%n", 024, 32767, -1, 65537f, 0x10.5P2);
        // ,
        System.out.printf("%,d|%,f|%,f|%,G|%n", 12345678, 0.1234, -1234.3456D, 65537.0623F);
        // (
        System.out.printf("%(d|%(o|%(d|%(e|%(f|%(g|%n", -1, new BigInteger("-24"), 12L, -12.34E-2, -12.34E-2, 0.12D);
        // .精度P
        System.out.printf("%10.5S|%-7.3s|%08.1f|%16.2E|%.4g|%n", "Java语言", new Date(), -12.354, -56.78765E-2, -123.45678);
        // 索引号N$
        System.out.printf("%2$d|%4$d|%1$d|%2$d|%n", 1, 2, 3, 4);
        // <
        System.out.printf("%3$d|%<d|%<d|%2$d|%<d|%n", 1, 2, 3, 4, 5);
    }
}