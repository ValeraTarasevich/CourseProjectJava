<%@ page import="entity.ErrorMsg" %>
<%--
  Created by IntelliJ IDEA.
  User: Valera
  Date: 13.05.2018
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="shortcut icon" href="content/img/icon.png" type="img/png">
    <title>Sign In</title>
    <link rel="stylesheet" href="content/css/bootstrap.css">
    <link rel="stylesheet" href="content/Site.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.0/css/font-awesome.min.css">
    <link href="https://fonts.googleapis.com/css?family=Righteous" rel="stylesheet">
</head>
<body class="text-center-3">

    <form action="Controller" class="form-signin" method="GET">
        <input type="hidden" name="action" value="SignIn" />
        <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
        <label for="inputSurname" class="sr-only">Surname</label>
        <input type="text" id="inputSurname" name="inputSurname" class="form-control" placeholder="Surname" required="" autofocus=""> <br>
        <label for="inputName" class="sr-only">Name</label>
        <input type="text" id="inputName" name="inputName" class="form-control" placeholder="Name" required=""><br>
        <label for="inputLogin" class="sr-only">Login</label>
        <input type="text" id="inputLogin" name="inputLogin" class="form-control" placeholder="Login" required=""><br>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" name="inputPassword" class="form-control" placeholder="Password" required=""><br>
        <label for="inputRepPassword" class="sr-only">Repeat password</label>
        <input type="password" id="inputRepPassword" name="inputRepPassword" class="form-control" placeholder="Repeat password" required=""><br>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="text" id="inputEmail" name="inputEmail" class="form-control" placeholder="Email address" required=""><br>
        <%
            String error = (String) ErrorMsg.getInstance().getErrorMsg();
            if (error == null){
                error = "";
            }
        %>
        <h5 class="errorMsg"> <% out.print(error);%> </h5>

        <input class="mybutton-2 btn-outline-success my-2 my-sm-0" type="submit" value="Sign In">
        <a href="/login">
            <button class="mybutton-2 btn-outline-success my-2 my-sm-0" type="button">Log in</button>
        </a>
    </form>

        <a href="/main">
            <button class="mybutton my-2" type="button">Back to Home</button>
        </a>

</body>
</html>
