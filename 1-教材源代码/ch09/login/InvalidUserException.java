package ch09.login;

public class InvalidUserException extends Exception {
    public InvalidUserException() {
        super("用户名或密码错误！");
    }
}