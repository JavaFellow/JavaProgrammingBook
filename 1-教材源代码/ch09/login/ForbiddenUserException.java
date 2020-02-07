package ch09.login;

public class ForbiddenUserException extends Exception {
    public ForbiddenUserException() {
        super("用户已被禁用！");
    }
}