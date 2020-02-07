package ch09.login;

public class EmptyFieldException extends Exception {
    public EmptyFieldException(String which) { // which指明是用户名还是密码为空
        super(which + "不能为空！"); // 调用父类构造方法
    }
}