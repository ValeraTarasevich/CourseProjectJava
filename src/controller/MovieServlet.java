package controller;

import dao.SqlFactory;
import entity.ActiveUser;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MovieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("user", ActiveUser.getInstance().getLogin());
        request.setAttribute("films", SqlFactory.getInstance().getSqlManager().getAllFilms());

        RequestDispatcher d = request.getRequestDispatcher("/Movies.jsp");
        d.forward(request, response);
    }
}
