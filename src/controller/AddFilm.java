package controller;

import dao.SqlFactory;
import dao.SqlManager;
import entity.ActiveUser;
import entity.Role;
import entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddFilm extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = ActiveUser.getInstance().getLogin();
        String url = "/main";

        SqlManager sql = SqlFactory.getInstance().getSqlManager();

        User user = sql.getUserByLogin(login);

        if (user!=null && user.getRole().equals(Role.ADMIN)){
            url = "/AddFilm.jsp";
        }

        RequestDispatcher d = request.getRequestDispatcher(url);
        d.forward(request, response);
    }
}
