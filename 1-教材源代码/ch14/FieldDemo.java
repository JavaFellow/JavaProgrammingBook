package ch14;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

enum BookKind { // 表示图书种类的枚举
    COMPUTER, MATH, ENGLISH
};

class Book { // 图书类
    double price = 20;
    String[] authors = { "Daniel", "Jack" };
    BookKind kind = BookKind.COMPUTER;
}

public class FieldDemo { // 测试类
    public static void main(String[] args) {
        Book book = new Book();
        Class<?> cls = book.getClass();

        try {
            /**** 通过名称获得各字段 ****/
            Field price = cls.getDeclaredField("price");
            Field authors = cls.getDeclaredField("authors");
            Field kind = cls.getDeclaredField("kind");

            System.out.printf("%-35s%s\n", "Before", "After");
            for (int i = 0; i < 62; i++) {
                System.out.print("-");
            }

            /**** 通过反射机制获得并修改各字段的值 ****/
            System.out.printf("\n%-8s = %-24s", price.getName(), price.getDouble(book));
            price.setDouble(book, 30);
            System.out.printf("%-8s = %-24s\n", "price", book.price);

            List<String> authorsList = Arrays.asList((String[]) authors.get(book));
            System.out.printf("%-8s = %-24s", authors.getName(), authorsList);
            String[] newAuthors = { "Andy", "Joe", "Tom" };
            authors.set(book, newAuthors);
            System.out.printf("%-8s = %-24s\n", "authors", Arrays.asList(book.authors));

            System.out.printf("%-8s = %-24s", kind.getName(), (BookKind) kind.get(book));
            kind.set(book, BookKind.MATH);
            System.out.printf("%-8s = %-24s\n", "kind", book.kind);
        } catch (NoSuchFieldException e) { // 由getDeclaredField方法抛出
            System.out.println("找不到名为" + e.getMessage() + "的字段。");
        } catch (IllegalAccessException e) { // 由get/set字段值的方法抛出
            System.out.println("字段不可访问。");
        }
    }
}