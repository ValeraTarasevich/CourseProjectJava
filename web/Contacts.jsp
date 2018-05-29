<%--
  Created by IntelliJ IDEA.
  User: Valera
  Date: 13.05.2018
  Time: 23:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="shortcut icon" href="content/img/icon.png" type="img/png">
    <title>Contacts</title>
    <link rel="stylesheet" href="content/css/bootstrap.css">
    <link rel="stylesheet" href="content/Site.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.0/css/font-awesome.min.css">
    <link href="https://fonts.googleapis.com/css?family=Righteous" rel="stylesheet">
</head>
<body>

<header>
    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
        <a class="navbar-logo" style="color: #20ce20;">MyCinema</a>
        <button class="navbar-toggler collapsed" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarCollapse">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link" href="/main"><i class="fa fa-home"></i>Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/about">About</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/movie"> Movies</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/contact"> Contacts</a>
                </li>
            </ul>
            <%
                String errorMsg = (String)request.getAttribute("user");
                if (errorMsg == null || errorMsg.equals("")){

            %>
            <form class="form-inline mt-2 mt-md-0" style="justify-content: space-between;">
                <a href="SignIn.jsp">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="button">Sign In</button>
                </a>
                <a href="LogIn.jsp">
                    <button  class="btn btn-outline-success my-2 my-sm-0" type="button">Log In</button>
                </a>
            </form>
            <%} else {%>
            <form class="form-inline mt-2 mt-md-0" style="justify-content: space-between;">
                <h2 style="color: darkgray; margin-right: 30px;"><%out.print(errorMsg);%></h2>
                <a href="/signout">
                    <button  class="btn btn-outline-success my-2 my-sm-0" type="button">Sign Out</button>
                </a>
            </form>
            <%}%>
        </div>
    </nav>
</header>



<iframe src="https://yandex.ru/map-widget/v1/?um=constructor%3A201d8d841b273e9ede6e60d20bf568342a30a90558c79b1f34b9535ce6944799&amp;source=constructor" width="100%" height="400" frameborder="0"></iframe>

<footer>
    <section class="bg-primary-new">
        <br>
        <div class="container">
            <div class="row centered">
                <div class="col-lg-4">
                    <p class="navbar-logo" >MyCinema</p>
                    <h4>Cinema Theater © 2018 All rights reserved.</h4>
                </div>
                <div class="col-lg-4">
                    <h5>Contact</h5>
                    <p1>Belarus, Minsk, Surganova 37/2</p1><br><br>
                    <p1>Telephone: +375-33-3565189</p1><br>
                    <p1>Email: valera.tarasevit97@gmail.com</p1>
                </div>
                <div class="col-lg-4">
                    <h5>Social</h5>
                    <a href="http://web.telegram.org.ru/#/errorMsg"><i class="fa fa-paper-plane fa-2x"></i></a>
                    <a href="https://www.facebook.com/"><i class="fa fa-facebook fa-2x MyTab"></i></a>
                    <a href="https://www.vk.com/"><i class="fa fa-vk fa-2x MyTab"></i></a>
                    <a href="https://twitter.com/"><i class="fa fa-twitter fa-2x MyTab"></i></a>
                    <a href="https://www.instagram.com"><i class="fa fa-instagram fa-2x MyTab"></i></a>
                </div>
            </div>
        </div>
        <br>
    </section>
</footer>
</body>
</html>
