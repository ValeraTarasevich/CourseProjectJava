<%--
  Created by IntelliJ IDEA.
  User: Valera
  Date: 22.05.2018
  Time: 22:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <link rel="shortcut icon" href="content/img/icon.png" type="img/png">
  <title>MyCinema</title>
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
      <%} else if (errorMsg == "admin") {%>
      <form class="form-inline mt-2 mt-md-0" style="justify-content: space-between;">
        <a href="/adminpage">
          <h1 style="color: white; margin-right: 30px;">Add Film</h1>
        </a>
        <a href="/signout">
          <button  class="btn btn-outline-success my-2 my-sm-0" type="button">Sign Out</button>
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

<main role="main">

  <div class="jumbotron jumbotron-fluid">
    <div class="container">
      <h1 class="disp-1">Welcome to MyCinema</h1>
      <p class="disp-2">The best cinema in the world:)</p>
    </div>
  </div>


  <div class="row">
    <div class="col-md-4" style="text-align:center; margin-top: 2%;">
      <a class="icon icon-primary icon-lg">
        <i class="fa fa-envelope" style="margin: 35px;"></i>
      </a>
      <h2>Subscribe to be the first</h2>
      <p>
        Get the local movie listings, special promotional offers, contests and other movie-related benefits.
      </p>
    </div>
    <div class="col-md-4" style="text-align:center; margin-top: 2%;">
      <a class="icon icon-primary icon-lg">
        <i class="fa fa-retweet" style="margin: 35px;"></i>
      </a>
      <h2>Loyalty program</h2>
      <p>It's FREE and every time you make a purchase online or at your local Theater, you'll earn points.</p>
    </div>
    <div class="col-md-4" style="text-align:center; margin-top: 2%;">
      <a class="icon icon-primary icon-lg">
        <i class="fa fa-question-circle" style="margin: 35px;"></i>
      </a>
      <h2>Need help?</h2>
      <p>Not sure what you're going to do? Check out our guide on getting started.</p>
    </div>
  </div>
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
</main>
<script src="content/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
</body>


</html>
