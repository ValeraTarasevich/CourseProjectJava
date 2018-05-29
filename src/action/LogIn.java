package action;

import dao.SqlFactory;
import dao.SqlManager;
import entity.ActiveUser;
import entity.ErrorMsg;
import entity.User;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class LogIn implements Action {

    private final String LOGIN_REGULAR = "^[a-zA-Z][a-zA-Z0-9]{2,20}$";
    private final String PASSWORD_REGULAR = "^[a-zA-Z][a-zA-Z0-9]{2,20}$";

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ErrorMsg.getInstance().setErrorMsg("");
        String  login = (String) request.getParameter("Login");
        String password = (String) request.getParameter("Password");

        SqlManager sql = SqlFactory.getInstance().getSqlManager();
        List<User> list = sql.getAllUsers();

        if (!login.matches(LOGIN_REGULAR)){
            ErrorMsg.getInstance().setErrorMsg("Incorrect login. You can enter 3-20 English letters and numbers.");
            return "LogIn.jsp";
        }
        if (!password.matches(PASSWORD_REGULAR)){
            ErrorMsg.getInstance().setErrorMsg("Incorrect password. You can enter 3-20 English letters and numbers.");
            return "LogIn.jsp";
        }

        int len = list.size();
        for (int i = 0; i < len; i++) {
            if (login.equals(list.get(i).getLogin())) {
                if (!(password).equals(list.get(i).getPassword())) {
                    ErrorMsg.getInstance().setErrorMsg("User with this password are not.");
                    return ("LogIn.jsp");
                }
                else{
                    ActiveUser.getInstance().setLogin(login);
                    return ("/main");
                }
            }
        }

        ErrorMsg.getInstance().setErrorMsg("User with this login and password are not.");
        System.out.println(request.getAttribute("errorMsg"));
        return ("LogIn.jsp");
    }
}
