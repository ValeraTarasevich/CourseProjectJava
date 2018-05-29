package controller;

import entity.ActiveUser;
import entity.ErrorMsg;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MainServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("user", ActiveUser.getInstance().getLogin());
        ErrorMsg.getInstance().setErrorMsg("");

        RequestDispatcher d = request.getRequestDispatcher("/Main.jsp");
        d.forward(request, response);
    }
}