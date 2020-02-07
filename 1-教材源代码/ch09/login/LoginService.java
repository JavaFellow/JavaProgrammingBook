package ch09.login;

public class LoginService {
    /**** 注意方法声明中的throws子句 ****/
    public void login(String username, String password) throws EmptyFieldException, ForbiddenUserException, InvalidUserException {
        if (username == null || username.trim().length() < 1) {
            throw new EmptyFieldException("用户名");
        }
        if (password == null || password.length() < 1) {
            throw new EmptyFieldException("密码");
        }
        if (username.trim().equals("admin") && password.equals("admin")) {
            boolean b = System.currentTimeMillis() % 2 == 0;
            if (b) {
                throw new ForbiddenUserException();
            }
        } else {
            throw new InvalidUserException();
        }
    }
}