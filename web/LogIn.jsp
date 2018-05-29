<%--
  Created by IntelliJ IDEA.
  User: Valera
  Date: 13.05.2018
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@page import="java.io.Console"%>
<%@ page import="entity.ErrorMsg" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <link rel="shortcut icon" href="content/img/icon.png" type="img/png">
        <title>Log In</title>
        <link rel="stylesheet" href="content/css/bootstrap.css">
        <link rel="stylesheet" href="content/Site.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.0/css/font-awesome.min.css">
        <link href="https://fonts.googleapis.com/css?family=Righteous" rel="stylesheet">
    </head>
    <body class="text-center-2">
    <%
        String error = (String) ErrorMsg.getInstance().getErrorMsg();
        if (error == null) {
            error = "";
        }
    %>
        <form class="form-signin" action="Controller" method="GET">
            <input type="hidden" name="action" value="LogIn" />
            <h1 class="h3 mb-3 font-weight-normal">Please log in</h1>
            <label for="inputLogin" class="sr-only">Login</label>
            <input type="text" id="inputLogin" name="Login" class="form-control" placeholder="Login" required="" autofocus=""><br>
            <label for="inputPassword" class="sr-only">Password</label>
            <input type="password" id="inputPassword" name="Password" class="form-control" placeholder="Password" required=""><br>
            <h5 class="errorMsg"> <% out.print(error);%> </h5>
            <input class="mybutton-2 btn-outline-success my-2 my-sm-0" href="/login" type="submit" value="Log In">

            <a href="/signin">
                <button class="mybutton-2 btn-outline-success my-2 my-sm-0" type="button">Sign In</button>
            </a>
        </form>

        <form action="/main">
            <input class="mybutton my-2" type="submit" value="Back to Home">
        </form>
    </body>
</html>
