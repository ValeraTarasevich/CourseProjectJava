package controller;

import action.Action;
import action.AddFilm;
import action.LogIn;
import action.Registration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ControllerServlet")
public class ControllerServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Action action = null;
        switch(request.getParameter("action")){
            case "LogIn":
                action = new LogIn();
                break;
            case "SignIn":
                action = new Registration();
                break;
            case "AddFilm":
                action = new AddFilm();
                break;
        }

        if(action != null){
            response.sendRedirect(action.execute(request, response));
        }

    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);

    }
}
