<%--
  Created by IntelliJ IDEA.
  User: Святослав
  Date: 25.11.2019
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<center>
        <h1>
            <a href="/registration">Registration</a>
        </h1>
<form method="post" action="/login">
    <input name="j_username"/>
    <input name="j_password"/>
    <input type="submit"/>
</form>
</center>
</body>
</html>
