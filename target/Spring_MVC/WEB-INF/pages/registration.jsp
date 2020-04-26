<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: manager
  Date: 23.04.2020
  Time: 19:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Registration</title>
</head>
<body>
<center>
    <h1>
        <a href="/login">Login</a>
    </h1>
</center>
<div align="center">
    <h2>New User</h2>
    <form:form action="reg" method="post" modelAttribute="user">
        <table border="0" cellpadding="5">
            <tr>
                <td>Name: </td>
                <td><form:input path="name" /></td>
            </tr>
            <tr>
                <td>Password: </td>
                <td><form:input path="password" /></td>
            </tr>
            <tr>
                <td>SurName: </td>
                <td><form:input path="surName" /></td>
            </tr>
            <tr>
                <td>E-mail: </td>
                <td><form:input path="email" /></td>
            </tr>
            <tr>
                <input  type="hidden" name="role" value="ROLE_USER">
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Submit"></td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>
