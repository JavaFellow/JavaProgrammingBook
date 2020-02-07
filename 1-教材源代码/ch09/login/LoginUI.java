package ch09.login;

public class LoginUI {
    public static void main(String[] args) {
        LoginService loginService = new LoginService();
        try {
            /**** 请读者修改下行的用户名和密码并重新运行程序，以重现5种情况 ****/
            loginService.login("admin", "123");
            System.out.println("登录成功！"); // 若未捕获到异常则表示登录成功
        } catch (EmptyFieldException | InvalidUserException | ForbiddenUserException e) {
            System.err.println(e.getMessage());
        }
    }
}