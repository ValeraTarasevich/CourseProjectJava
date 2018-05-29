package action;

import dao.SqlFactory;
import dao.SqlManager;
import entity.ActiveUser;
import entity.ErrorMsg;
import entity.Role;
import entity.User;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class Registration implements Action {

    private final String LOGIN_REGULAR = "^[a-zA-Z][a-zA-Z0-9]{2,20}$";
    private final String SURNAME_REGULAR = "^[a-zA-Zа-яА-Я]{3,20}$";
    private final String NAME_REGULAR = "^[a-zA-Zа-яА-Я]{3,20}$";
    private final String PASSWORD_REGULAR = "^[a-zA-Z][a-zA-Z0-9]{2,20}$";
    private final String EMAIL_REGULAR = "^[a-zA-Z0-9_.+-]+[@][a-zA-Z0-9-]+[.][a-zA-Z0-9-.]+$";


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            String surname = (String) request.getParameter("inputSurname");
            String name = (String) request.getParameter("inputName");
            String login = (String) request.getParameter("inputLogin");
            String password1 = (String) request.getParameter("inputPassword");
            String password2 = (String) request.getParameter("inputRepPassword");
            String email = (String) request.getParameter("inputEmail");
            String error;
            HttpSession session = request.getSession();

            SqlManager sql = SqlFactory.getInstance().getSqlManager();
            List<User> users = sql.getAllUsers();

            if (isEmpty(email) || isEmpty(name) || isEmpty(surname) || isEmpty(password1) || isEmpty(password2)){
                ErrorMsg.getInstance().setErrorMsg("Fill in all the fields.");
                return "SignIn.jsp";
            }

            if (!surname.matches(SURNAME_REGULAR)){
                ErrorMsg.getInstance().setErrorMsg("Incorrect surname. You can enter 3-20 English or Russian letters.");
                return "SignIn.jsp";
            }
            if (!name.matches(NAME_REGULAR)){
                ErrorMsg.getInstance().setErrorMsg("Incorrect name. You can enter 3-20 English or Russian letters.");
                return "SignIn.jsp";
            }
            if (!login.matches(LOGIN_REGULAR)){
                ErrorMsg.getInstance().setErrorMsg("Incorrect login. You can enter 3-20 English letters and numbers.");
                return "SignIn.jsp";
            }
            if (!password1.matches(PASSWORD_REGULAR)){
                ErrorMsg.getInstance().setErrorMsg("Incorrect password. You can enter 3-20 English letters and numbers.");
                return "SignIn.jsp";
            }
            if (!email.matches(EMAIL_REGULAR)){
                ErrorMsg.getInstance().setErrorMsg("Incorrect email. You can enter English letters, numbers and necessarily @ and point.");
                return "SignIn.jsp";
            }

            User user = new User();
            user.setSurname(surname);
            user.setEmail(email);
            user.setRole(Role.USER);
            user.setLogin(login);
            user.setName(name);
            user.setPassword(password1);

           for (User u : users){
                if (u.getLogin().equals(login)){
                    ErrorMsg.getInstance().setErrorMsg("This login used.");

                    return "SignIn.jsp";
                }
            }

            for (User u : users){
                if (u.getEmail().equals(email)){
                    ErrorMsg.getInstance().setErrorMsg("This email used.");
                    return "SignIn.jsp";
                }
            }

            if (!password1.equals(password2)) {
                ErrorMsg.getInstance().setErrorMsg("Different passwords.");
                return "SignIn.jsp";
            }

            if (sql.addUser(user)){
                ActiveUser.getInstance().setLogin(sql.getUserByLogin(login).getLogin());
                ErrorMsg.getInstance().setErrorMsg("");
                return "/main";
            }
            else {
                ErrorMsg.getInstance().setErrorMsg("DataBase error.");
                return "SignIn.jsp";
            }

        } catch (Exception e) {
            System.out.println("ERROR:" + e);
            return "/main";
        }
    }

    private boolean isEmpty(String str){
        if (str == null || str.equals("")){
            return true;
        }
        else {
            return false;
        }
    }
}

