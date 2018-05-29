<%@ page import="entity.ErrorMsg" %><%--
  Created by IntelliJ IDEA.
  User: Valera
  Date: 24.05.2018
  Time: 23:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="shortcut icon" href="content/img/icon.png" type="img/png">
    <title>Add Films</title>
    <link rel="stylesheet" href="content/css/bootstrap.css">
    <link rel="stylesheet" href="content/Site.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.0/css/font-awesome.min.css">
    <link href="https://fonts.googleapis.com/css?family=Righteous" rel="stylesheet">
</head>
<body class="text-center-3">
<form action="Controller" class="form-signin" method="GET">
    <input type="hidden" name="action" value="AddFilm" />
    <h1 class="h3 mb-3 font-weight-normal">Add Films</h1>
    <label for="nameFilm" class="sr-only">Name Film</label>
    <input type="text" id="nameFilm" name="nameFilm" class="form-control" placeholder="Name Film" required="" autofocus=""> <br>
    <label for="year" class="sr-only">Year</label>
    <input type="text" id="year" name="year" class="form-control" placeholder="Year" required=""><br>
    <label for="style" class="sr-only">Style</label>
    <input type="text" id="style" name="style" class="form-control" placeholder="Style" required=""><br>
    <label for="country" class="sr-only">Country</label>
    <input type="text" id="country" name="country" class="form-control" placeholder="Country" required=""><br>
    <label for="picture" class="sr-only">Picture</label>
    <input type="text" id="picture" name="picture" class="form-control" placeholder="Picture Name" required=""><br>
    <label for="video" class="sr-only">Video</label>
    <input type="text" id="video" name="video" class="form-control" placeholder="Video Name" required=""><br>
    <%
        String error = (String) ErrorMsg.getInstance().getErrorMsg();
        if (error == null){
            error = "";
        }
    %>
    <h5 class="errorMsg"> <% out.print(error);%> </h5>

    <input class="mybutton my-2" type="submit" value="Add Film">
    <a href="/main">
        <button class="mybutton my-2" type="button">Back to Home</button>
    </a>
</form>


</body>
</html>
